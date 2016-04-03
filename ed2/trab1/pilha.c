#include <stdio.h>
#include <stdlib.h>
#include "pilha.h"

Pilha *criaPilha() {
    Pilha *p = malloc(sizeof(Pilha));
    p->topo = NULL;
    return p;
}

No *criaNo(Cidade *c) {
    No *no = malloc(sizeof(No));
    no->c = c;
    no->prox = NULL;

    return no;
}

void *push(Pilha *p, Cidade *c) {
    No *novo = criaNo(c);
    novo->prox = p->topo;
    p->topo = novo;
}

No *pop(Pilha *p) {
    No *ret = p->topo;
    p->topo = p->topo->prox;
    return ret;
}

void imprimePilha(Pilha *p) {
    No *aux;

    for(aux = p->topo; aux != NULL; aux = aux->prox)
        printf(" %.2f ; %.2f  -  id = %d\n", aux->c->x, aux->c->y, aux->c->id);

    printf("\n");
}

void freePilha(Pilha *p) {
    No *aux;

    aux = p->topo;

    while(aux != NULL) {
        p->topo = p->topo->prox;
        free(aux);
        aux = p->topo;
    }
    free(p);
}
