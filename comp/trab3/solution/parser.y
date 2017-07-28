/* Options to bison */
%output "parser.c"
%defines "parser.h"
%define parse.error verbose
%define parse.lac full

// Enable the trace option so that debugging is possible.
%define parse.trace

%{
#include <stdio.h>
#include <stdlib.h>
#include "ast.h"
#include "parser.h"
#include "tables.h"
#include "string.h"

int yylex(void);
void yyerror(char const *s);
void check_var();
void check_func();
int new_var();
int new_func();

extern char *yytext;
extern int yylineno;

char *idtext;
char *functext;
int func_arity;
int curr_scope;

LitTable *lt;
SymTable *vt;
SymTable *ft;
AST *ast;

%}

%define api.value.type {AST*} // Type of variable yylval;

%token NUM ID IF ELSE WHILE WRITE RETURN ASSIGN SEMI INPUT OUTPUT COMMA
%token LPAREN RPAREN LBRACK RBRACK LBRACE RBRACE
%token STRING INT VOID
%left LT LE GT GE EQ NEQ
%left PLUS MINUS
%left TIMES OVER

%%

program:
  func_dcl_list { ast = $1; }
;

func_dcl_list:
  func_dcl_list func_dcl    { add_child($1, $2); $$ = $1; }
| func_dcl                  { $$ = new_subtree(FUNC_LIST_NODE, 1, $1); }
;

func_dcl:
  func_header func_body   { $$ = new_subtree(FUNC_DCL_NODE, 2, $1, $2); curr_scope++; }
;

func_header:
    ret_type ID { functext = strdup(idtext); } LPAREN params RPAREN { $2 = new_node(ID_NODE, new_func()); free(functext); $$ = new_subtree(FUNC_HEADER_NODE, 3, $1, $2, $5); }
;

func_body:
  LBRACE opt_var_decl opt_stmt_list RBRACE  { $$ = new_subtree(FUNC_BODY_NODE, 2, $2, $3); }
;

opt_var_decl:
  /* epsilon */     { $$ = new_node(VAR_LIST_NODE, 0); }
| var_decl_list     { $$ = $1; }
;

opt_stmt_list:
  /* epsilon */     { $$ = new_node(BLOCK_NODE, 0); }
| stmt_list         { $$ = $1; }
;

ret_type:
  INT       { $$ = new_node(INT_NODE, 0); }
| VOID      { $$ = new_node(VOID_NODE, 0); }
;

params:
  VOID          { func_arity = 0; $$ = new_node(PARAM_LIST_NODE, 0); }
| param_list    { $$ = $1; }
;

param_list:
  param_list COMMA param    { func_arity++; add_child($1, $3); $$ = $1; }
| param                     { func_arity = 1; $$ = new_subtree(PARAM_LIST_NODE, 1, $1); }
;

param:
  INT ID { $$ = new_node(SVAR_NODE, new_var()); free(idtext); }
| INT ID { $2 = new_node(CVAR_NODE, new_var()); free(idtext); } LBRACK RBRACK  { $$ = $2; }
;

var_decl_list:
  var_decl_list var_decl    { add_child($1, $2); $$ = $1; }
| var_decl                  { $$ = new_subtree(VAR_LIST_NODE, 1, $1); }
;

var_decl:
  INT ID { $2 = new_node(SVAR_NODE, new_var()); free(idtext); } SEMI  { $$ = $2; }
| INT ID { $2 = new_node(CVAR_NODE, new_var()); free(idtext); } LBRACK NUM RBRACK SEMI { add_child($2, $5); $$ = $2; }
;

stmt_list:
  stmt_list stmt    { add_child($1, $2); $$ = $1; }
| stmt              { $$ = new_subtree(BLOCK_NODE, 1, $1); }
;

block:
  LBRACE opt_stmt_list RBRACE   { $$ = $2; }
;

stmt:
  assign_stmt       { $$ = $1; }
| if_stmt           { $$ = $1; }
| while_stmt        { $$ = $1; }
| return_stmt       { $$ = $1; }
| func_call SEMI    { $$ = $1; }
;

assign_stmt:
  lval ASSIGN arith_expr SEMI   { $$ = new_subtree(ASSIGN_NODE, 2, $1, $3); }
;

lval:
  ID  { check_var(); $$ = new_node(SVAR_NODE, lookup_var(vt, idtext, curr_scope)); free(idtext); }
| ID LBRACK NUM RBRACK     { check_var(); $1 = new_node(CVAR_NODE, lookup_var(vt, idtext, curr_scope)); free(idtext); add_child($1, $3); $$ = $1; }
| ID LBRACK   { check_var(); $1 = new_node(CVAR_NODE, lookup_var(vt, idtext, curr_scope)); } ID { check_var(); $4 = new_node(SVAR_NODE, lookup_var(vt, idtext, curr_scope)); free(idtext); } RBRACK      { add_child($1, $4); $$ = $1; }
;

if_stmt:
  IF LPAREN bool_expr RPAREN block              { $$ = new_subtree(IF_NODE, 2, $3, $5); }
| IF LPAREN bool_expr RPAREN block ELSE block   { $$ = new_subtree(IF_NODE, 3, $3, $5, $7); }
;

while_stmt:
  WHILE LPAREN bool_expr RPAREN block   { $$ = new_subtree(WHILE_NODE, 2, $3, $5); }
;

return_stmt: 
  RETURN SEMI               { $$ = new_subtree(RETURN_NODE, 0); }
| RETURN arith_expr SEMI    { $$ = new_subtree(RETURN_NODE, 1, $2); }
;

func_call:
  output_call       { $$ = $1; }
| write_call        { $$ = $1; }
| user_func_call    { $$ = $1; }
;

input_call:
  INPUT LPAREN RPAREN   { $$ = new_subtree(INPUT_NODE, 0); }
;

output_call:
  OUTPUT LPAREN arith_expr RPAREN   { $$ = new_subtree(OUTPUT_NODE, 1, $3); }
;

write_call:
  WRITE LPAREN STRING RPAREN    { $$ = new_subtree(WRITE_NODE, 1, $3); }
;

user_func_call:
  //ID { functext = strdup(idtext); free(idtext); } LPAREN opt_arg_list RPAREN    { check_func(); free(functext); $$ = new_subtree(FUNC_CALL_NODE, 1, $4); }
  ID { functext = strdup(idtext); free(idtext); } LPAREN opt_arg_list RPAREN    { check_func(); $$ = new_subtree(FUNC_CALL_NODE, 1, $4); set_data($$, lookup_func(ft, functext)); free(functext); }
;

opt_arg_list:
  /*epsilon*/   { func_arity = 0; $$ = new_node(ARG_LIST_NODE, 0); }
| arg_list      { $$ = $1; }
;

arg_list:
  arg_list COMMA arith_expr { func_arity++; add_child($1, $3); $$ = $1; }
| arith_expr                { func_arity = 1; $$ = new_subtree(ARG_LIST_NODE, 1, $1); }
;

bool_expr:
  arith_expr LT  arith_expr { $$ = new_subtree(LT_NODE, 2, $1, $3);  }
| arith_expr LE  arith_expr { $$ = new_subtree(LE_NODE, 2, $1, $3);  }
| arith_expr GT  arith_expr { $$ = new_subtree(GT_NODE, 2, $1, $3);  }
| arith_expr GE  arith_expr { $$ = new_subtree(GE_NODE, 2, $1, $3);  }
| arith_expr EQ  arith_expr { $$ = new_subtree(EQ_NODE, 2, $1, $3);  }
| arith_expr NEQ arith_expr { $$ = new_subtree(NEQ_NODE, 2, $1, $3); }
;

arith_expr:
  arith_expr PLUS arith_expr    { $$ = new_subtree(PLUS_NODE, 2, $1, $3); }
| arith_expr MINUS arith_expr   { $$ = new_subtree(MINUS_NODE, 2, $1, $3); }
| arith_expr TIMES arith_expr   { $$ = new_subtree(TIMES_NODE, 2, $1, $3); }
| arith_expr OVER arith_expr    { $$ = new_subtree(OVER_NODE, 2, $1, $3); }
| LPAREN arith_expr RPAREN      { $$ = $2; }
| lval                          { $$ = $1; }
| input_call                    { $$ = $1; }
| user_func_call                { $$ = $1; }
| NUM                           { $$ = $1; }
;


%%

int main() {
    yydebug = 0; // Toggle this variable to enter debug mode.

    // Initialization of tables before parsing.
    lt = create_lit_table();  // Literals table
    vt = create_sym_table();  // Variables table
    ft = create_sym_table();  // Functions table

    curr_scope = 0;

    if(!yyparse()) {
        //printf("PARSE SUCCESSFUL!\n");
    }

    // printf("\n\n");
    // print_lit_table(lt); printf("\n\n");
    // print_var_table(vt); printf("\n\n");
    // print_func_table(ft); printf("\n\n");

    print_dot(ast);

    free_lit_table(lt);
    free_sym_table(vt);

    return 0;
}

void check_var() {
    int idx = lookup_var(vt, idtext, curr_scope);
    if (idx == -1) {
        printf("SEMANTIC ERROR (%d): variable '%s' was not declared.\n",
                yylineno, idtext);
        exit(1);
    }
}

void check_func() {
    int idx = lookup_func(ft, functext);
    if (idx == -1) {
        printf("SEMANTIC ERROR (%d): function '%s' was not declared.\n",
                yylineno, functext);
        exit(1);
    }
    if(func_arity != get_arity(ft, idx)) {
        printf("SEMANTIC ERROR (%d): function '%s' was called with %d arguments but declared with %d parameters.\n",
                yylineno, functext, func_arity, get_arity(ft, idx));
        exit(1);
    }
}

int new_var() {
    int idx = lookup_var(vt, idtext, curr_scope);
    if (idx != -1) {
        printf("SEMANTIC ERROR (%d): variable '%s' already declared at line %d.\n",
                yylineno, idtext, get_line(vt, idx));
        exit(1);
    }
    return add_var(vt, idtext, curr_scope, yylineno);
}

int new_func() {
    int idx = lookup_func(ft, functext);
    if (idx != -1) {
        printf("SEMANTIC ERROR (%d): function '%s' already declared at line %d.\n",
                yylineno, functext, get_line(ft, idx));
        exit(1);
    }
    return add_func(ft, functext, func_arity, yylineno);
}

// Error handling.
void yyerror (char const *s) {
    printf("PARSE ERROR (%d): %s\n", yylineno, s);
    exit(1);
}
