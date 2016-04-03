/**
 * CABEÇALHO PATH
 * ESTRUTURA E ASSINATURA DE FUNÇÕES PARA GERENCIAR PATH
 */

#ifndef PATH_H
#define PATH_H

#include <stdio.h>
#include <stdlib.h>
#include "listInt.h"
#include "jobs.h"

 /**
  * ESTRUTURA PATH
  */
 typedef struct path {
     int pathCost;      // Custo ou Lower Bound
     int ub;            // Upper Bound
     int tempoGasto;
     typeList *caminho;
     Job *job;
 } Path;

/**
 * FUNÇÕES
 */
 Path *criaPath(Job* job, int pathCost, int ub, int tempoGasto, typeList *caminho);
void printPath(Path *p);
void printPathBB(Path *p);
void freePath(Path *p);

#endif
