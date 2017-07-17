/* My implementation of Lab11 */

%option outfile="scanner.c"
%option noyywrap
%option nounput
%option noinput
%option yylineno

%{
#include "ast.h"
#include "parser.h"
#include "tables.h"

#define process_token(type) return type

extern SymTable *vt;
%}

number      [0-9]+
identifier  [a-zA-Z]+
ignore      [ \t\n]+

/* Multi-line comments are handled in the rules section.
   First we need to define a start condition. */
%x          MLC

%%

"{"             { BEGIN(MLC); } /* Enter special state. */
<MLC>"}"        { BEGIN(INITIAL); } /* Go back to normal state. */
<MLC>.|\n       { } /* Ignore everything that is inside a comment. */

{ignore}        { } /* Eat up whitespace. */

"if"            { process_token(IF); }
"then"          { process_token(THEN); }
"else"          { process_token(ELSE); }
"end"           { process_token(END); }
"repeat"        { process_token(REPEAT); }
"until"         { process_token(UNTIL); }
"read"          { process_token(READ); }
"write"         { process_token(WRITE); }

"+"             { process_token(PLUS); }
"-"             { process_token(MINUS); }
"*"             { process_token(TIMES); }
"/"             { process_token(OVER); }

"="             { process_token(EQ); }
"<"             { process_token(LT); }

"("             { process_token(LPAREN); }
")"             { process_token(RPAREN); }
";"             { process_token(SEMI); }

":="            { process_token(ASSIGN); }

{number}        { yylval = new_node(NUM_NODE, atoi(yytext)); process_token(NUM); }
{identifier}    { yylval = new_node(ID_NODE, add_or_look(vt, yytext, yylineno)); process_token(ID); }

                /* Be sure to keep this as the last rule */
.               { printf("SCANNING ERROR (%d): Unknown symbol %s\n", yylineno, yytext);
                  exit(1); }

%%
