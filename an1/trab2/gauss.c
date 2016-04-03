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
