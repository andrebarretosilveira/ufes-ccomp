
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include "outros.h"

int *alocaVetor(int n) {
    int *vet;

    vet = calloc(n, sizeof(int));
    return vet;
}

float *alocaVetorFloat(int n) {
    float *vet;

    vet = calloc(n, sizeof(float));
    return vet;
}

void lerVetor(float *vet, int n) { int i;
    for(i=0; i<n; i++)
        scanf("%f", &vet[i]);
}

void copiaVetor(int *vetDest, int *vet, int n) {
    int i;

    for(i=0; i<n; i++) {
        vetDest[i] = vet[i];
    }
}

void imprimeVetor(int *vet, int n) {
    int i;

    for(i=0; i < n; i++) {
        printf("%d ", vet[i]);
    }
    printf("\n");
}

void imprimeVetorFloat(float *vet, int n) {
    int i;

    for(i=0; i < n; i++) {
        printf("%.2f ", vet[i]);
    }
    printf("\n");
}

float **alocaMatriz(int n, int m) {
    float **mat; 
    int i;

    mat = calloc(n, sizeof(float *));

    /* aloca as colunas da matriz */
    for (i = 0; i < n; i++) {
        mat[i] = calloc(m, sizeof(float));
    }
    return mat;
}

float **dupMatriz(float **mat, int n, int m) {
    int i, j;
    float **nova = alocaMatriz(n, m);

    for(i=0; i < n; i++) {
        for(j=0; j < n; j++) {
            nova[i][j] = mat[i][j];
        }
    }
    return nova;
}

void lerMatriz(float **mat, int n, int m) {
    int i, j;

    for(i=0; i < n; i++) {
        for(j=0; j < m; j++)
            scanf("%f", &mat[i][j]);
    }
}

void lerMatrizXY(float **mat, int n, int m) {
    int lin, col;

    for(col=0; col < m; col++) {
        for(lin=0; lin < n; lin++)
            scanf("%f", &mat[lin][col]);
    }
}

void imprimeMatriz(float **mat, int n, int m) {
    int i, j;

    for(i=0; i < n; i++) {
        for(j=0; j < m; j++)
            printf("%7.2f  ", mat[i][j]);
        printf("\n");
    }
}

void liberaMatriz(float **mat, int n) {
    int i;

    for(i=0; i < n; i++) {
        free(mat[i]);
    }
    free(mat);
}

float dist2Pontos(float x0, float y0, float x1, float y1) {
    return sqrt(pow(x1-x0,2) + pow(y1-y0,2));
}

void saidaFormatada(int *vetCaminho, float custo, int n) {
    int i;

    for(i=0; i < n; i++) {
        printf("%d\n", vetCaminho[i]);
    }
    printf("%.2f\n*\n", custo);
}
