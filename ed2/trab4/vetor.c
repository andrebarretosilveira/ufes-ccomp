/**
 * IMPLEMENTAÇÕES VETOR
 * Funções para manipular vetores inteiros
 */

#include <stdio.h>
#include <stdlib.h>

int* criaVetor(const int N)
{
    int* v = malloc(N*sizeof(int));
    return v;
}

int* lerVetor(const int N)
{
    int i, valor;
    int* v = criaVetor(N);

    for(i = 0; i < N; i++) {
        scanf("%d", &valor);
        v[i] = valor;
    }

    return v;
}

void printVetor(int* v, const int N)
{
    int i;
    for(i = 0; i < N; i++) {
        printf("%d\n", v[i]);
    }
    printf("\n");
}

void freeVetor(int* v)
{
    free(v);
}
