/**
 * CABEÇALHO BEAMSEARCH
 * ESTRUTURA E ASSINUATURA DE FUNÇÕES PARA GERENCIAR BEAMSEARCH
 */

#ifndef BS_H
#define BS_H

#include <stdio.h>
#include <stdlib.h>
#include "bb.h"
#include "jobs.h"
#include "path.h"
#include "skewHeap.h"

 /**
  * FUNÇÕES
  */
Path *beamSearch(Job **jobs, const int N, const int w);
SkewHeap *geraPossibilidades(Job** jobs, Path *p, const int N);
int calculaCusto(Path *p, Job *job);

#endif
