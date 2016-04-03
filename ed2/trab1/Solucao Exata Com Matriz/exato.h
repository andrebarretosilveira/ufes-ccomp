#include <stdio.h>
#include <stdlib.h>

float defineVetorCaminho(float **mat, int **matCaminho, int posAtual, int n,int nFat);
int iMenorCusto(float *vet,int n);
int permutaVetor(int n,int **matCaminho);
char semRepeticao(int *num, int r);
void geraVetorCusto(float *custo,int **matCaminho,float **matCusto,int n,int nFat);
