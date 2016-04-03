#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

struct Node {
 int x;
 int y;
 int orient;
 struct Node *prox;
};
typedef struct Node node;

node *criaPilha(node *p);
void exibe(node *PILHA);
void libera(node *PILHA);
node *aloca(int x,int y,int orient);
void push(node *PILHA,int x,int y,int orient);
node *pop(node *PILHA);
char* translate(node* PILHA,char *regras,int angle,int z);
int calcF(char *turtle,int *x,int *y,int z,int angle,int cont);
int calcG(char *turtle,int *x,int *y,int z,int angle,int cont);
int produzturtle(char *turtle,char c,int cont);
int calcy(int y0,int z,int angle);
int calcx(int x0,int z,int angle);
