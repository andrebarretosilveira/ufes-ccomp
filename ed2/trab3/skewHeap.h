/**
 * CABEÇALHO SKEWHEAP
 * ESTRUTURA E ASSINUATURA DE FUNÇÕES PARA GERENCIAR SKEWHEAP
 */

#ifndef SKEWHEAP_H
#define SKEWHEAP_H

#include <stdio.h>
#include <stdlib.h>
#include "path.h"

 /**
  * ESTRUTURA DA SKEWHEAP
  */
 typedef struct skewHeap
 {
     Path *path;             // Path armazenado
     struct skewHeap *lc;    // LeftChild
     struct skewHeap *rc;    // RightChild
 } SkewHeap;

/**
 * FUNÇÕES
 */
SkewHeap *criaSkewHeap(Path *caminho);
void addPath(SkewHeap **sh, Path *caminho);
Path *removeMin(SkewHeap **sh);
SkewHeap *mergeSkewHeap(SkewHeap *left, SkewHeap *right);
int getMinCost(SkewHeap *sh);
void printSkewHeap(SkewHeap *sh);
void freeSkewHeap(SkewHeap *sh);

#endif
