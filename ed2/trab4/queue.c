/*
 * IMPLEMENTAÇÃO DA ESTRUTURA QUEUE (FILA)
 * UTILIZADA NO ALGORITMO RADIXSORT
 */

#include "queue.h"

Queue* criaQueue()
{
    Queue* q = malloc(sizeof(Queue));
    q->prim = q->ult = NULL;
    return q;
}

void enfileira(Queue* q, int v)
{
    Node* node = malloc(sizeof(Node));
    node->value = v;

    if(isVazio(q))
        q->prim = node;
    else
        q->ult->prox = node;

    q->ult = node;
    node->prox = NULL;
}

int desenfileira(Queue* q)
{
    Node* aux;
    int valor;

    valor = q->prim->value;

    aux = q->prim->prox;
    free(q->prim);
    q->prim = aux;

    if(isVazio(q))
        q->ult = NULL;

    return valor;
}

int isVazio(Queue* q)
{
    return q->prim == NULL;
}

void freeQueue(Queue* q)
{
    Node *aux, *t;
    aux = q->ult;
    while(aux != NULL) {
        t = aux->prox;
        free(aux);
        aux = t;
    }
    free(q);
}
