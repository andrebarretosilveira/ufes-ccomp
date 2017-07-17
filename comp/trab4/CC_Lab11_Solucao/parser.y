// My implementation of Lab11.

/* Options to bison */
// File name of generated parser.
%output "parser.c"
// Produces a 'parser.h'
%defines "parser.h"
// Give proper error messages when a syntax error is found.
%define parse.error verbose
// Enable LAC (lookahead correction) to improve syntax error handling.
%define parse.lac full
// Enable the trace option so that debugging is possible.
%define parse.trace

%{
#include <stdio.h>
#include "ast.h"
#include "tables.h"
#include "interpreter.h"

int yylex(void);
void yyerror(char const *s);

extern int yylineno;

SymTable *vt;

AST *ast;
%}

%define api.value.type {AST*} // Type of variable yylval;

%token IF THEN ELSE END REPEAT UNTIL READ WRITE
%token SEMI LPAREN RPAREN
%token ASSIGN

%token NUM
%token ID

%left LT EQ
// Precedence of operators (* and / have higher precedence).
// All four operators are left associative.
%left PLUS MINUS
%left TIMES OVER

// Start symbol for the grammar.
%start program

%%

program:
  stmt_sequence         { ast = $1; }
;

stmt_sequence:
  stmt_sequence stmt    { add_child($1, $2); $$ = $1; }
| stmt                  { $$ = new_subtree(STMT_SEQ_NODE, 1, $1); }
;

stmt:
  if_stmt       { $$ = $1; }
| repeat_stmt   { $$ = $1; }
| assign_stmt   { $$ = $1; }
| read_stmt     { $$ = $1; }
| write_stmt    { $$ = $1; }
;

if_stmt:
  IF expr THEN stmt_sequence END                    { $$ = new_subtree(IF_NODE, 2, $2, $4); }
| IF expr THEN stmt_sequence ELSE stmt_sequence END { $$ = new_subtree(IF_NODE, 3, $2, $4, $6); }
;

repeat_stmt:
  REPEAT stmt_sequence UNTIL expr   { $$ = new_subtree(REPEAT_NODE, 2, $2, $4); }
;

assign_stmt:
  ID ASSIGN expr SEMI   { $$ = new_subtree(ASSIGN_NODE, 2, $1, $3); }
;

read_stmt:
  READ ID SEMI          { $$ = new_subtree(READ_NODE, 1, $2); }
;

write_stmt:
  WRITE expr SEMI       { $$ = new_subtree(WRITE_NODE, 1, $2); }
;

expr:
  expr LT expr          { $$ = new_subtree(LT_NODE, 2, $1, $3); }
| expr EQ expr          { $$ = new_subtree(EQ_NODE, 2, $1, $3); }
| expr PLUS expr        { $$ = new_subtree(PLUS_NODE, 2, $1, $3); }
| expr MINUS expr       { $$ = new_subtree(MINUS_NODE, 2, $1, $3); }
| expr TIMES expr       { $$ = new_subtree(TIMES_NODE, 2, $1, $3); }
| expr OVER expr        { $$ = new_subtree(OVER_NODE, 2, $1, $3); }
| LPAREN expr RPAREN    { $$ = $2; }
| NUM                   { $$ = $1; }
| ID                    { $$ = $1; }
;

%%

// Error handling.
void yyerror (char const *s) {
    printf("PARSE ERROR (%d): %s\n", yylineno, s);
}

// Main.
int main() {
    yydebug = 0; // Toggle this variable to enter debug mode.

    vt = create_sym_table();
    if (yyparse() == 0) {
        stdin = fopen(ctermid(NULL), "r");
        run_ast(ast);
    }

    free_tree(ast);
    free_sym_table(vt);

    return 0;
}
