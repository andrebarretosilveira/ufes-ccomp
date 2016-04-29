/**
 * sor.h
 *
 * Definição das funções SOR
 *
 */

#include <stdio.h>
#include <stdlib.h>
#include "sistemaLinear.h"

double *sor(SistemaLinear*, double, double, size_t, size_t*, double*, double*);
double *sorLivre(Dados* dados, Ponto* vetorPontos, double omega, double toler, size_t iterMax, size_t* numIter, double* error, double* norma);

double *sorLivreV1(Dados* dados, double omega, double toler, size_t iterMax, size_t* numIter, double* error, double* norma);
double *sorLivreV2(Dados* dados, Ponto* vetorPontos, double omega, double toler, size_t iterMax, size_t* numIter, double* error, double* norma);
double *sorLivreA1(Dados* dados, double omega, double toler, size_t iterMax, size_t* numIter, double* error, double* norma);
double *sorLivreA2(Dados* dados, double omega, double toler, size_t iterMax, size_t* numIter, double* error, double* norma);
