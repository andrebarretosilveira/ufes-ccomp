/**
 * sistemaLinear.h
 *
 * Definição do sistema linear: estrutura
 * e funções condizentes com o mesmo.
 *
 */

#ifndef SISTEMALINEAR_H
#define SISTEMALINEAR_H

#include <stdio.h>
#include <stdlib.h>
#include "matrizPentadiagonal.h"

/*
 * Estrutura da matriz composta por 5
 * vetores, representando as diagonais
 * e a ordem da matriz
 */
typedef struct sistemaLinear
{
    MatrizPentadiagonal* matriz;
    double* f; // Vetor independente
    size_t N;  // Ordem do sistema
} SistemaLinear;

/** Funções **/
SistemaLinear* criaSistemaLinear(MatrizPentadiagonal*, double*, const size_t);
void aplicaContorno(SistemaLinear*, Dados*);
void printSistemaLinear(SistemaLinear*);
void freeSistemaLinear(SistemaLinear*);

#endif

