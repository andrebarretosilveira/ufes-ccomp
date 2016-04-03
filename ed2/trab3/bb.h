/**
 * CABEÇALHO BRANCH AND BOUND
 * ESTRUTURA E ASSINUATURA DE FUNÇÕES PARA GERENCIAR BRANCH AND BOUND
 */

#ifndef BB_H
#define BB_H

#include <stdio.h>
#include <stdlib.h>
#include "bs.h"
#include "jobs.h"
#include "path.h"
#include "skewHeap.h"

 /**
  * FUNÇÕES
  */
Path *branchBound(Job **jobs, const int N, const int W);
SkewHeap *geraPossibilidadesBB(Job** jobs, Path *p, const int N);
int calculaLB(Job **jobs, Path *p, const int N, const int pos);
int hasPenalidade(Path *p, Job *job);

#endif
