#include <stdio.h>
#include <stdlib.h>
#include "trab.h"
#define FREE(p) if(p!=NULL){free(p);p=NULL;}

ArvProd *inicializaAxioma (char *axioma) {
	size_t tam = strlen(axioma);
	short i;
	
	ArvProd *tmp = arvvCria(0);
	ArvProd *tmp2 = tmp;
	tmp2->prim = arvvCria(axioma[0]);	
    tmp2 = tmp2->prim;
	for(i = 1; i < tam; i++) {
        tmp2->prox = arvvCria(axioma[i]);
        tmp2 = tmp2->prox;
	}
	return tmp;
}

Comandos *inicializaComandos() {
    Comandos *c = malloc(sizeof(Comandos));
    c->angle = 0;
    c->order = 0;
    c->rotate = 0;
    c->axiom = NULL;
    c->regras = NULL;
    return c; 
}

RegrasProd* inicializaRegra() {
    RegrasProd* r = malloc(sizeof(RegrasProd));
    r->prox = NULL;
    return r;
}

ArvProd* arvvCria (char c) {
	ArvProd *a; 
	a = (ArvProd*)malloc(sizeof(ArvProd));
	a->info = c;
	a->prim = NULL;
	a->prox = NULL;
	return a;
}
 
int incluiRegras(FILE *fp, Comandos *c, char *word) {
	RegrasProd *r;
    RegrasProd *nova = inicializaRegra();

    nova->parametro = word[0];

	fscanf(fp, "%s", word);
	if(strcmp(word, "=") != 0) {
        printf("Erro de sintaxe. Programa abortado.\n");
        liberaRegras(nova);
        liberaComandos(c);
        fclose(fp);
        exit(1);
	}

    fscanf(fp, "%s", word);
    nova->regra = malloc(strlen(word)+1);
    strcpy(nova->regra, word);

    if(c->regras == NULL)
        c->regras = nova;

    else {
        for(r = c->regras; r->prox != NULL; r = r->prox);

        r->prox = nova;
    }
}

void geraArv (ArvProd *a, RegrasProd *regras) {
    RegrasProd *aux;

	if(a == NULL) return;
	
	if(a->prim != NULL)
		geraArv(a->prim, regras);
	
	else {
        for(aux = regras; aux != NULL; aux = aux->prox) {
            if(aux->parametro == a->info) {
                ArvProd *tmp;
                size_t tam = strlen(aux->regra);
                short i;
                if(tam > 1) {
                    // Gerar novas folhas
                    a->prim = arvvCria(aux->regra[0]);
                    tmp = a->prim;
                    for(i = 1; i < tam; i++) {
                        tmp->prox = arvvCria(aux->regra[i]);
                        tmp = tmp->prox;
                    }
                }
                else
                    a->prim = arvvCria(aux->regra[0]);
            }
        }
	}
	
	geraArv(a->prox, regras);
}

void returnFolhas (ArvProd *a, char *sfinal) {
	int i;
	if(a == NULL) return;
	
	if(a->prim == NULL) {
		i = 0;
		while(sfinal[i] != '\0')
			i++;

		sfinal[i] = a->info;
		sfinal[i+1] = '\0';
	}
	returnFolhas(a->prim,sfinal);
	returnFolhas(a->prox,sfinal);
}

void arvvLibera (ArvProd *a) {
	ArvProd* p = a->prim;
	while(p != NULL) {
        ArvProd *t = p->prox;
        arvvLibera (p);
        p = t;
	}
	FREE(a);
}

void liberaComandos(Comandos* c) {
    FREE(c->axiom);
	liberaRegras(c->regras);
	FREE(c);
}

void liberaRegras(RegrasProd* r) {
	RegrasProd* aux;
    while(r != NULL) {
        aux = r->prox;
        FREE(r->regra);
        FREE(r);
        r = aux;
    }
}
