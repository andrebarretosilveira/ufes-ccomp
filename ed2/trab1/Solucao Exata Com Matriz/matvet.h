#include <stdio.h>
#include <stdlib.h>

// VETOR
int *alocaVetor(int n);
float *alocaVetorFloat(int n);
void lerVetor(float *vet, int n);
void imprimeVetor(int *vet, int n);
void imprimeVetorFloat(float *vet, int n);

// MATRIZ
float **alocaMatriz(int n, int m);
float **dupMatriz(float **mat, int n, int m);
void lerMatriz(float **mat, int n, int m);
void imprimeMatriz(float **mat, int n, int m);
void liberaMatriz(float **mat, int n);
void imprimeMatrizInt(int **mat, int n, int m);
void liberaMatrizInt(int **mat, int n);
int **alocaMatrizInt(int n, int m);
