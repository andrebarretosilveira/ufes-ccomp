/**
 * matrizPentadiagonal.h
 *
 * Definição da estrutura da Matriz Pentadiagonal
 * e suas funções básicas.
 *
 */

#ifndef MATRIZPENTADIAGONAL_H
#define MATRIZPENTADIAGONAL_H

#include <stdio.h>
#include <stdlib.h>

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
    size_t n;
} MatrizPentadiagonal;

/** Funções **/
MatrizPentadiagonal* newMatPen(int);
void preencheMatPen(MatrizPentadiagonal*);
void printMatPen(MatrizPentadiagonal*);
void freeMatPen(MatrizPentadiagonal*);

#endif
