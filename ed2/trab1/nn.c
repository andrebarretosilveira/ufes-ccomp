/*                                                 *
 * Heuristica Next Neighbor (Vizinho mais Proximo) *
 *                                                 */

#include <stdio.h>
#include <stdlib.h>
#include "nn.h"
#include "outros.h"

#define VISITADO 999

float geraVetorCaminho(float **mat, int *vetor, int posAtual, int n) {
    int i, prox;
    float custo=0;
    float **matAux = dupMatriz(mat, n, n);

    i = 0;
    vetor[i] = posAtual;
    prox = proxCidade(matAux, posAtual, n);
    custo += matAux[posAtual][prox];
    posAtual = prox;

    for(i=1; i < n; i++) {
        vetor[i] = posAtual;
        prox = proxCidade(matAux, posAtual, n);
        custo += matAux[posAtual][prox];
        marcaVisita(matAux, posAtual, n);
        posAtual = prox;
    }
    liberaMatriz(matAux, n);
    return custo;
}

int proxCidade(float **mat, int posAtual, int n) {
    int i, prox=0;
    float menorDist = VISITADO;

    for(i=1; i < n; i++) {
        if(mat[posAtual][i] < menorDist) {
            menorDist = mat[posAtual][i];
            prox = i;
        }
    }
    return prox;
}

void marcaVisita(float **mat, int cidade, int n) {
    int i;

    for(i=0; i < n; i++) {
        mat[i][cidade] = VISITADO;
    }
}
