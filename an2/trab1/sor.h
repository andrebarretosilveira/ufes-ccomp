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
double *sorLivre(Dados* dados, double omega, double toler, size_t iterMax);
