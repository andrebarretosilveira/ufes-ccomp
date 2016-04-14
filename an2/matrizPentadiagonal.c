/**
 * matrizPentadiagonal.c
 *
 * Implementação das funções definidas no
 * cabeçalho matrizPentadiagonal.h
 *
 */

#include "matrizPentadiagonal.h"

MatrizPentadiagonal* newMatPen(int n)
{
    MatrizPentadiagonal* matriz;
    matriz = malloc(sizeof(MatrizPentadiagonal));
    matriz->e = malloc(n*sizeof(double));
    matriz->c = malloc(n*sizeof(double));
    matriz->a = malloc(n*sizeof(double));
    matriz->b = malloc(n*sizeof(double));
    matriz->d = malloc(n*sizeof(double));
    matriz->n = n;
    return matriz;
}

void preencheMatPen(MatrizPentadiagonal* matriz)
{
    size_t i;
    for(i=0; i < matriz->n; i++) {
        matriz->e[i] = i+1;
        matriz->c[i] = i+1;
        matriz->a[i] = i+1;
        matriz->b[i] = i+1;
        matriz->d[i] = i+1;
    }
}

void printMatPen(MatrizPentadiagonal *matriz)
{
    size_t i;
    for(i=0; i < matriz->n; i++) {
        printf(" | %2g %2g %2g %2g %2g |\n",
            matriz->e[i], matriz->c[i],
            matriz->a[i], matriz->b[i],
            matriz->d[i]
        );
    }
}

void freeMatPen(MatrizPentadiagonal *matriz)
{
    free(matriz->e);
    free(matriz->c);
    free(matriz->a);
    free(matriz->b);
    free(matriz->d);
    free(matriz);
}
