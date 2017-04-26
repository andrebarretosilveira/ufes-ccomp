%{
#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>

void strtoupper(char*);
%}

%s bcomment

blank      [ \t\n]+
reserved   (if|else|input|int|output|return|void|while|write)
number     [0-9]+
id         [a-zA-Z][a-zA-Z0-9]*
string     \".*\"
lcomment   \/\/.*$
unknown    [^ \t\n]

%%

{blank}     // Pular caracteres brancos
{lcomment}  // Pular comentários de linha

"/*"              BEGIN(bcomment); // Começar a consumir comentários
<bcomment>"*/"    BEGIN(INITIAL);  // '*/' encontrado, fim dos comentários
<bcomment>"*"                      // Apenas um '*', então continue consumindo
<bcomment>[^*]*                    // Consome comentários até achar um '*'

{reserved}  { 
              printf("%d: %s -> ", yylineno, yytext); 
              strtoupper(yytext);
              printf("%s\n", yytext); 
            }

"+"         { printf("%d: %s -> %s\n", yylineno, yytext, "PLUS"); }
"-"         { printf("%d: %s -> %s\n", yylineno, yytext, "MINUS"); }
"*"         { printf("%d: %s -> %s\n", yylineno, yytext, "TIMES"); }
"/"         { printf("%d: %s -> %s\n", yylineno, yytext, "OVER"); }
"<"         { printf("%d: %s -> %s\n", yylineno, yytext, "LT"); }
"<="        { printf("%d: %s -> %s\n", yylineno, yytext, "LE"); }
">"         { printf("%d: %s -> %s\n", yylineno, yytext, "GT"); }
">="        { printf("%d: %s -> %s\n", yylineno, yytext, "GE"); }
"=="        { printf("%d: %s -> %s\n", yylineno, yytext, "EQ"); }
"!="        { printf("%d: %s -> %s\n", yylineno, yytext, "NEQ"); }
"="         { printf("%d: %s -> %s\n", yylineno, yytext, "ASSIGN"); }

";"         { printf("%d: %s -> %s\n", yylineno, yytext, "SEMI"); }
","         { printf("%d: %s -> %s\n", yylineno, yytext, "COMMA"); }
"("         { printf("%d: %s -> %s\n", yylineno, yytext, "LPAREN"); }
")"         { printf("%d: %s -> %s\n", yylineno, yytext, "RPAREN"); }
"["         { printf("%d: %s -> %s\n", yylineno, yytext, "LBRACK"); }
"]"         { printf("%d: %s -> %s\n", yylineno, yytext, "RBRACK"); }
"{"         { printf("%d: %s -> %s\n", yylineno, yytext, "LBRACE"); }
"}"         { printf("%d: %s -> %s\n", yylineno, yytext, "RBRACE"); }

{number}    { printf("%d: %s -> %s\n", yylineno, yytext, "NUM"); }

{id}        { printf("%d: %s -> %s\n", yylineno, yytext, "ID"); }

{string}    { printf("%d: %s -> %s\n", yylineno, yytext, "STRING"); }

{unknown}   { printf("%d: %s -> %s\n", yylineno, yytext, "UNKNOWN"); }

%%
int main() { yylex(); return 0; }

void strtoupper(char* s) {
    char* init = s;

    while(*s) {
        *s = toupper((unsigned char) *s);
        s++;
    }

    s = init;
}
