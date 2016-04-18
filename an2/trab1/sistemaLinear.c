/**
 * sistemaLinear.c
 *
 * Implementação das funções definidas no
 * cabeçalho sistemaLinear.h
 *
 */

#include "sistemaLinear.h"

SistemaLinear* newSistemaLinear(MatrizPentadiagonal* matriz, double* f, const size_t N)
{
    SistemaLinear* sistema;
    sistema = malloc(sizeof(SistemaLinear));
    sistema->matriz = matriz;
    sistema->f = f;
    sistema->N = N;
    return sistema;
}

void printSistemaLinear(SistemaLinear* sistema)
{
    size_t i;
    printMatPen(sistema->matriz);
    printf("\n");
    for(i=0; i < sistema->N; i++) {
        printf("%g ", sistema->f[i]);
    }

    printf("\n");
}

void freeSistaLinear(SistemaLinear* sistema)
{
    freeMatPen(sistema->matriz);
    free(sistema->f);
    free(sistema);
}
