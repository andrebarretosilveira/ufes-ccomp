/*                                  *
 * Heuristica de melhoramento 2-opt * 
 *                                  */

#include <stdio.h>
#include <stdlib.h>
#include "opt.h"
#include "outros.h"

int *novoCaminho(float **matCusto, int *vetorCaminho, int n) {
    int i, j;
    int *vetAux = alocaVetor(n);
    int *melhorCaminho = alocaVetor(n);

    copiaVetor(melhorCaminho, vetorCaminho, n);

    i = 0; // Unico caso diferente
    for(j=2; j < n-1; j++) {
        trocaAresta(vetorCaminho, vetAux, i, j, n);
        if(custoCaminho(matCusto, vetAux, n) < custoCaminho(matCusto, melhorCaminho, n))
            copiaVetor(melhorCaminho, vetAux, n);
    }

    for(i=1; i<n-3; i++) {
        for(j=i+2; j<n; j++) {
            trocaAresta(vetorCaminho, vetAux, i, j, n);
            if(custoCaminho(matCusto, vetAux, n) < custoCaminho(matCusto, melhorCaminho, n))
                copiaVetor(melhorCaminho, vetAux, n);
        }
    }

    free(vetAux);
    free(vetorCaminho);
    return melhorCaminho;
}

void trocaAresta(int *vetorCaminho, int *novoCaminho, int pos1, int pos2, int n) {
    int i, k;

    for(i=0; i <= pos1; i++)
        novoCaminho[i] = vetorCaminho[i];

    for(i=pos1+1, k=pos2; i <= pos2; i++, k--)
        novoCaminho[i] = vetorCaminho[k];

    for(i=pos2+1; i < n; i++)
        novoCaminho[i] = vetorCaminho[i];
}

float custoCaminho(float **matCusto, int *vetorCaminho, int n) {
    int i;
    float custo=0;

    for(i=0; i < n-1; i++) {
        custo += matCusto[vetorCaminho[i]][vetorCaminho[i+1]];
    }
    custo += matCusto[vetorCaminho[n-1]][0];
    return custo;
}
