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

%x comments

blank        [ \t\n]+
line_comment "//".*$
id           [a-zA-Z][a-zA-Z0-9]*
string       \".*\"
number       [0-9]+

%%
"/*"                 { BEGIN(comments); }
<comments>"*/"       { BEGIN(INITIAL); }
<comments>"\n"       { yylineno++; }
<comments>.          { /* consumindo comentarios */ }

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
"<="        { return LE; }
">"         { return GT; }
">="        { return GE; }
"=="        { return EQ; }
"!="        { return NEQ; }

"("         { return LPAREN; }
")"         { return RPAREN; }
"["         { return LBRACK; }
"]"         { return RBRACK; }
"{"         { return LBRACE; }
"}"         { return RBRACE; }
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
    exit(1);
}
