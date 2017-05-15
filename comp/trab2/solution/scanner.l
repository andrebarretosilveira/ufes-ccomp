%option outfile="scanner.c"
%option noyywrap
%option nounput
%option noinput
%option yylineno

%{
#include <stdio.h>
#include "parser.h"

void scan_error(char const *);
%}

%s comments

blank        [ \t\n]+
line_comment "//".*$
id           [a-zA-Z]+
string       \".*\"
number       [0-9]+

%%
"/*"                 BEGIN(comments);
<comments>"*/"       BEGIN(INITIAL);
<comments>[^*]*"*/"  /* consumindo comentarios */

{blank}
{line_comment}

"if"        { return IF; }
"else"      { return ELSE; }
"while"     { return WHILE; }
"write"     { return WRITE; }
"input"     { return INPUT; }
"output"    { return OUTPUT; }
"return"    { return RETURN; }
"int"       { return INT; }
"void"      { return VOID; }

"+"         { return PLUS; }
"-"         { return MINUS; }
"*"         { return TIMES; }
"/"         { return OVER; }

"<"         { return LT; }
"<="        { return LEQ; }
">"         { return GT; }
">="        { return GEQ; }
"=="        { return EQ; }
"!="        { return NEQ; }

"("         { return LPAR; }
")"         { return RPAR; }
"["         { return LBRAC; }
"]"         { return RBRAC; }
"{"         { return LCUR; }
"}"         { return RCUR; }
";"         { return SEMI; }
","         { return COMMA; }
"="         { return ASSIGN; }

{string}    { return STRING; }
{id}        { return ID; }
{number}    { yylval = atoi(yytext); return NUM; }

.           { scan_error(yytext); }

%%

// Error handling
void scan_error(char const *s) {
    printf("SCANNING ERROR (%d) : Unknown symbol %s\n", yylineno, s);
}
