/**
 * trab1.c
 *
 * Testador do Trabalho 1 de Algoritmos
 * Numéricos: Método das Diferencas Finitas
 * Aplicado a Problemas Bidimensionais
 *
 * Autor: André Barreto Silveira
 *
 */

#include <stdlib.h>
#include <stdio.h>
#include "matrizPentadiagonal.h"
#include "sistemaLinear.h"
#include "sor.h"

#define N 12

int main()
{
    size_t i;
    MatrizPentadiagonal* matriz;
    SistemaLinear* sistema;
    double* f = malloc(N*sizeof(double));

    for(i = 0; i < N; i++)
        f[i] = i;

    matriz = newMatPen(N, 3);
    preencheMatPen(matriz);
    sistema = newSistemaLinear(matriz, f, N);
    //printSistemaLinear(sistema);
    double* x = sor(sistema, 0.6, 0.0001, 100000);

    printf("x = ");
    for(i = 0; i < N; i++)
        printf("%g ", x[i]);
    printf("\n");

    free(x);
    freeSistaLinear(sistema);

    return 0;
}
