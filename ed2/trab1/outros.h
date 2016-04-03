
#ifndef OUTROS_HEADER_FILE
#define OUTROS_HEADER_FILE

// VETOR
int *alocaVetor(int n);
float *alocaVetorFloat(int n);
void lerVetor(float *vet, int n);
void copiaVetor(int *vetDest, int *vet, int n);
void imprimeVetor(int *vet, int n);
void imprimeVetorFloat(float *vet, int n);

// MATRIZ
float **alocaMatriz(int n, int m);
float **dupMatriz(float **mat, int n, int m);
void lerMatriz(float **mat, int n, int m);
void lerMatrizXY(float **mat, int n, int m);
void imprimeMatriz(float **mat, int n, int m);
void liberaMatriz(float **mat, int n);

float dist2Pontos(float x0, float y0, float x1, float y1);
void saidaFormatada(int *vetCaminho, float custo, int n);

#endif
