/**
 * matrizPentadiagonal.h
 *
 * Definição da estrutura da Matriz Pentadiagonal
 * e suas funções básicas.
 *
 */

#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include "dados.h"

#ifndef MATRIZPENTADIAGONAL_H
#define MATRIZPENTADIAGONAL_H

// Variável global que identifica
// o experimento a ser efetuado
extern int flagExp;

/*
 * Estrutura da matriz composta por 5
 * vetores, representando as diagonais
 * e a ordem da matriz
 */
typedef struct matrizPentadiagonal
{
	double *e;
	double *c;
	double *a;
	double *b;
	double *d;
    size_t N;      // Ordem da matriz Pentadiagonal
    size_t tamED;  // Tamanho dos vetores *e e *d
} MatrizPentadiagonal;

/** Funções **/
MatrizPentadiagonal* alocaMatrizPentadiagonal(const int);
MatrizPentadiagonal* criaMatrizPentadiagonal(Dados*, Ponto*);
void montaMatrizV1(MatrizPentadiagonal*, Dados*);
void montaMatrizV2(MatrizPentadiagonal*, Dados*, Ponto*);
void montaMatrizA1(MatrizPentadiagonal*, Dados*);
void montaMatrizA2_P(MatrizPentadiagonal*, Dados*);
void montaMatrizA2_V(MatrizPentadiagonal*, Dados*);
void printMatrizPentadiagonal(MatrizPentadiagonal*);
void freeMatrizPentadiagonal(MatrizPentadiagonal*);

#endif
