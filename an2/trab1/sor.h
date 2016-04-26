/**
 * sor.h
 *
 * Definição das funções SOR
 *
 */

#include <stdio.h>
#include <stdlib.h>
#include "sistemaLinear.h"

double *sor(SistemaLinear*, double, double, size_t);
double *sorLivre(Dados* dados, Ponto* vetorPontos, double omega, double toler, size_t iterMax);

double *sorLivreV1(Dados* dados, double omega, double toler, size_t iterMax);
double *sorLivreV2(Dados* dados, Ponto* vetorPontos, double omega, double toler, size_t iterMax);
double *sorLivreA1(Dados* dados, double omega, double toler, size_t iterMax);
double *sorLivreA2(Dados* dados, double omega, double toler, size_t iterMax);
