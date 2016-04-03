#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct regrasprod {
    char parametro;
	char *regra;
	struct regrasprod *prox;
} RegrasProd;

// Comandos para o sistema
typedef struct comandos {
    int angle;
    int order;
    int rotate;
    char *axiom;
    RegrasProd *regras;
} Comandos;

// Arvore de filhos variaveis
typedef struct arvprod {
	char info;
	struct arvprod *prim; // Primeiro filho
	struct arvprod *prox; // Proximo irmao
} ArvProd;

// Funcoes
ArvProd* inicializaAxioma (char *axioma);
Comandos *inicializaComandos();
RegrasProd *inicializaRegras();
ArvProd *arvvCria (char c);
int incluiRegras(FILE *fp,Comandos *c,char *word);
void geraArv (ArvProd *a, RegrasProd *regras);
void returnFolhas (ArvProd *a,char* sfinal);
void arvvLibera (ArvProd* a);
void liberaRegras(RegrasProd* r);
void liberaComandos(Comandos* c);
