/*
 * ESTRUTURA QUEUE (FILA)
 * UTILIZADA NO ALGORITMO RADIXSORT
 */

#ifndef QUEUE_H
#define QUEUE_H

#include "stdlib.h"

typedef struct node Node;
struct node {
    int value;
    Node* prox;
};

typedef struct queue {
    Node *prim, *ult;
} Queue;

Queue* criaQueue();
void enfileira(Queue*, int);
int desenfileira(Queue*);
int isVazio(Queue*);
void freeQueue(Queue*);

#endif
