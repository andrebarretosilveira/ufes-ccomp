/**
 * matrizPentadiagonal.h
 *
 * Definição da estrutura da Matriz Pentadiagonal
 * e suas funções básicas.
 *
 */

#include <stdio.h>
#include <stdlib.h>
#include "dados.h"

#ifndef MATRIZPENTADIAGONAL_H
#define MATRIZPENTADIAGONAL_H

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
MatrizPentadiagonal* newMatrizPenta(const int, const int);
MatrizPentadiagonal* criaMatrizPenta(Dados*, Ponto*);
void preencheMatrizPenta(MatrizPentadiagonal*);
void printMatrizPenta(MatrizPentadiagonal*);
void freeMatrizPenta(MatrizPentadiagonal*);

#endif
