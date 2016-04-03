/**
 * CABEÇALHO VETOR
 * Funções para manipular vetores inteiros
 */

#ifndef VETOR_H
#define VETOR_H

#include <stdio.h>
#include <stdlib.h>

int* criaVetor(const int N);
int* lerVetor(const int N);
void printVetor(int* v, const int N);
void freeVetor(int* v);

#endif
