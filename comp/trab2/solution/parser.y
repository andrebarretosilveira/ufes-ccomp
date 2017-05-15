/* Options to bison */
%output "parser.c"
%defines "parser.h"
%define parse.error verbose
%define parse.lac full

// Enable the trace option so that debugging is possible.
%define parse.trace

%{
#include <stdio.h>

int yylex(void);
void yyerror(char const *s);

extern int yylineno;
%}

%token NUM ID IF ELSE WHILE WRITE RETURN ASSIGN SEMI INPUT OUTPUT COMMA EPS
%token LPAR RPAR LBRAC RBRAC LCUR RCUR
%token STRING INT VOID
%left LT LEQ GT GEQ EQ NEQ
%left PLUS MINUS
%left TIMES OVER

%%

program: func_dcl_list ;

func_dcl_list:
  func_dcl_list func_dcl
| func_dcl
;

func_dcl: func_header func_body ;

func_header: ret_type ID LPAR params RPAR ;

func_body: LCUR opt_var_decl opt_stmt_list RCUR ;

opt_var_decl: | var_decl_list ;

opt_stmt_list: | stmt_list ;

ret_type:
  INT
| VOID
;

params:
  VOID
| param_list
;

param_list:
  INT ID
| INT ID LBRAC RBRAC
;

var_decl_list:
  var_decl_list var_decl
| var_decl
;

var_decl:
  INT ID SEMI
| INT ID LBRAC NUM RBRAC SEMI
;

stmt_list:
  stmt_list stmt
| stmt ;

stmt:
  assign_stmt
| if_stmt
| while_stmt
| return_stmt
| func_call SEMI
;

assign_stmt: lval ASSIGN arith_expr SEMI ;

lval:
  ID
| ID LBRAC NUM RBRAC
| ID LBRAC ID RBRAC
;

if_stmt:
  IF LPAR bool_expr RPAR block
| IF LPAR bool_expr RPAR block ELSE block
;

block: LCUR opt_stmt_list RCUR ;

while_stmt: WHILE LPAR bool_expr RPAR block ;

return_stmt: 
  RETURN SEMI
| RETURN arith_expr SEMI
;

func_call:
  output_call
| write_call
| user_func_call
;

input_call: INPUT LPAR RPAR ;

output_call: OUTPUT LPAR arith_expr RPAR ;

write_call: WRITE LPAR STRING RPAR ;

user_func_call: ID LPAR opt_arg_list RPAR ;

opt_arg_list: EPS | arg_list ;

arg_list:
  arg_list COMMA arith_expr
| arith_expr
;

bool_expr: arith_expr bool_op arith_expr ;

arith_expr:
  arith_expr PLUS arith_expr
| arith_expr MINUS arith_expr
| arith_expr TIMES arith_expr
| arith_expr OVER arith_expr
| LPAR arith_expr RPAR
| lval
| input_call
| user_func_call
| NUM
;

bool_op:
  LT
| LEQ
| GT
| GEQ
| EQ
| NEQ
;


%%

int main() {
  yyparse();
  //printf("PARSE SUCCESSFUL!\n");
  return 0;
}

// Error handling.
void yyerror (char const *s) {
    printf("PARSE ERROR (%d): %s\n", yylineno, s);
}
