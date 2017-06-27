%option outfile="scanner.c"
%option noyywrap
%option nounput
%option noinput
%option yylineno

%{
#include <stdio.h>
#include "ast.h"
#include "parser.h"
#include "tables.h"
#include "string.h"

void scan_error(char const *);

extern SymTable *st;
extern LitTable *lt;

extern char *idtext;
%}

%x MLC

blank        [ \t\n]+
line_comment "//".*$
id           [a-zA-Z][a-zA-Z0-9]*
string       \".*\"
number       [0-9]+

%%
"/*"			{ BEGIN(MLC); }
<MLC>"*/"       { BEGIN(INITIAL); }
<MLC>"\n"       { /* ue */ }
<MLC>.          { /* consumindo comentarios */ }

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

{id}        { idtext = strdup(yytext); return ID;  }
{string}    { yylval = new_node(STRING_NODE, add_literal(lt, yytext)); return STRING; }
{number}    { yylval = new_node(NUM_NODE, atoi(yytext)); return NUM; }

.           { scan_error(yytext); }

%%

// Error handling
void scan_error(char const *s) {
    printf("SCANNING ERROR (%d): Unknown symbol %s\n", yylineno, s);
    exit(1);
}
