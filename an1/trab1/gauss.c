/**
 * FUNÇÕES PARA EXECUTAR A ELIMINAÇÃO DE GAUSS
 */
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "gauss.h"

/**
 * [elimGaussS - FAZ A ELIMINAÇÃO GAUSSIANA DE UMA MATRIZ ESPARSA sparse]
 * @param sparse [Estrutura onde é armazenada a matriz esparsa]
 */
 void elimGauss(Sparse *sparse)
 {
     List *aux;
     size_t j, k, N = sparse->n;
     double m, valt, vpivo, newValue;
     struct timespec Start, End;
     double Elapsed_Time;

     clock_gettime(CLOCK_MONOTONIC, &Start);

     // Iterando para cada linha (linha do pivô)
     for(k = 0; k < N-1; k++) {
         // Iterando para cada linha abaixo da linha do pivô
         for(aux = sparse->matrix[k]; aux != NULL; aux = aux->next) {
             if(aux->row > k) {
                 m = - aux->value/sparse->diagonal[k];
                 aux->value = 0.0;
                 // Iterando na coluna da linha i para modificar os valores
                 for(j = k + 1; j < N; j++) {
                 	vpivo = get(sparse, k, j);          // Valor da linha do pivô
                 	if(vpivo != 0.0) {
                        valt = get(sparse, aux->row, j);    // Valor da linha sendo alterada
                        newValue = valt + m * vpivo;        // Combinação das linhas
                        set(sparse, aux->row, j, newValue);     // Modifica o valor
                     }
                 }
                 // Modificar o valor do vetor independente
                 sparse->b[aux->row] += m * sparse->b[k];
             }
         }
     }

     // Gerar o vetor solução
     substRetroativas(sparse);

     clock_gettime(CLOCK_MONOTONIC, &End);
     Elapsed_Time = End.tv_sec - Start.tv_sec + 1e-9*(End.tv_nsec - Start.tv_nsec);

     printf("O Tempo de execucao da Eliminacao de Gauss foi %f segundos.\n", Elapsed_Time);
 }

/**
 * [substRetroativas - CALCULA O VETOR SOLUÇÃO DE UM SISTEMA TRIANGULAR SUPERIOR]
 * @param sparse [Estrutura onde é armazenada a matriz esparsa]
 * Vetor solução é armazenado em sparse->b
 */
void substRetroativas(Sparse *sparse)
{
    size_t i, j;
    size_t N = sparse->n;
    double soma;

    sparse->b[N-1] = sparse->b[N-1]/sparse->diagonal[N-1];
    for(i = N-1; i > 0; i--) {
        soma = 0;
        for(j = i; j < N; j++)
            soma = soma + get(sparse, i-1, j) * sparse->b[j];

        sparse->b[i-1] = (sparse->b[i-1] - soma)/sparse->diagonal[i-1];
    }
}

/*
void pivotParcial(double **A, double *b, int k, int n) {
    int i, j, p;
    double maior, tmp;

    p = k;
    maior = abs(A[k][k]);
    for(i = k+1; i < n; i++) {
        if(abs(A[i][k]) > maior) {
            maior = abs(A[i][k]);
            p = i;
        }
    }
    if(p != k) {
        printf("Pivoteou\n");
        for(j = k; j < n; j++) {
            tmp = A[k][j];
            A[k][j] = A[p][j];
            A[p][j] = tmp;
        }
        tmp = b[k];
        b[k] = b[p];
        b[p] = tmp;
    }
}
*/
/**
 * [elimGauss - FUNÇÃO QUE GERA MATRIZ TRIANGULAR SUPERIOR]
 * @param A     [Matriz de coeficientes a ser transformada]
 * @param b     [Vetor independente]
 * @param n     [Ordem da matriz A]
 */
/*
void elimGauss(double **A, double *b, int n) {
    int i, j, k;
    double m;

    for(k = 0; k < n-1; k++) {
        pivotParcial(A, b, k, n);
        for(i = k+1; i < n; i++) {
            m = -A[i][k]/A[k][k];
            for(j = k; j < n; j++)
                A[i][j] = A[i][j] + m*A[k][j];

            b[i] = b[i] + m*b[k];
        }
    }
}

*/
