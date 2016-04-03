#include <stdio.h>
#include <stdlib.h>

float geraMelhorCaminho(int n, int *vetorCaminho,float **matCusto,int *melhorCaminho,int posAtual);
int iMenorCusto(float *vet,int n);
char semRepeticao(int *num, int r);
float geraCusto(float **matCusto,int *vetorCaminho,int n);
