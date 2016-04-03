#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include "trab.h"
#include "gstack.h"
#include "psinterface.h"
#define N 30
#define FREE(p) if(p!=NULL){free(p);p=NULL;}

void lerComandos(Comandos *c, FILE *fp);

int main()
{
    ArvProd *a;
    Comandos *c;
    FILE *fp;
    char entrada[N], *sfinal = NULL;
    int i;

    printf("Digite o nome do arquivo: ");
    scanf("%s", entrada);

    fp = fopen(entrada, "r");
    if(fp == NULL) {
        printf("Erro ao abrir arquivo. Abortando programa.\n");
        exit(1);
    }

    c = inicializaComandos();
    lerComandos(c, fp);
    fclose(fp);

    a = inicializaAxioma(c->axiom);
    
    for(i = 0; i < c->order; i++)
        geraArv(a, c->regras);

    sfinal = malloc(10000);
    memset(sfinal, 0, sizeof(sfinal));
    returnFolhas(a, sfinal);
    genps(c->angle, c->order, c->rotate, sfinal, "saida.ps");

	arvvLibera(a);
	liberaComandos(c);
	FREE(sfinal);
	return 0;
}

void lerComandos(Comandos *c, FILE *fp) {
    char word[N];
    int num;
    while(fscanf(fp, "%s", word) == 1) {
        if(strcmp(word, "angle") == 0) {
            fscanf(fp, "%d", &num);
            c->angle = num;
        }
        else if(strcmp(word, "order") == 0) {
            fscanf(fp, "%d", &num);
            c->order = num;
        }
        else if(strcmp(word, "axiom") == 0) {
            fscanf(fp, "%s", word);
            c->axiom = malloc(strlen(word)+1);
            strcpy(c->axiom, word);
        }
        else if(strcmp(word, "rotate") == 0) {
            fscanf(fp, "%d", &num);
            c->rotate = num;
        }
        else if(strlen(word) == 1) {
            incluiRegras(fp, c, word);
        }
        else {
            printf("Comando '%s' desconhecido. Abortando programa.\n", word);
            liberaComandos(c);
            fclose(fp);
            exit(1);
        }
    }
}
