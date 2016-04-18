/**
 * matrizPentadiagonal.c
 *
 * Implementação das funções definidas no
 * cabeçalho matrizPentadiagonal.h
 *
 */

#include "matrizPentadiagonal.h"

MatrizPentadiagonal* newMatPen(const int N, const int xParts)
{
    MatrizPentadiagonal* matriz;
    matriz = malloc(sizeof(MatrizPentadiagonal));
    matriz->e = malloc((N-xParts)*sizeof(double));
    matriz->c = malloc((N-1)*sizeof(double));
    matriz->a = malloc(N*sizeof(double));
    matriz->b = malloc((N-1)*sizeof(double));
    matriz->d = malloc((N-xParts)*sizeof(double));
    matriz->N = N;
    matriz->tamED = (N-xParts);
    return matriz;
}

void preencheMatPen(MatrizPentadiagonal* matriz)
{
    size_t i;
    for(i=0; i < matriz->N-1; i++) {
        matriz->c[i] = i+2;
        matriz->a[i] = i+20;
        matriz->b[i] = i+1;
    }
    matriz->a[i] = i+20;

    size_t relat = matriz->N - matriz->tamED;
    for(i=0; i < matriz->tamED; i++) {
        matriz->e[i] = i+relat+1;
        matriz->d[i] = i+1;
    }
}

void printMatPen(MatrizPentadiagonal *matriz)
{
    size_t i;

    printf("    e  c  a  b  d  \n");
    printf(" ------------------\n");

    printf(" |       %2g %2g %2g |\n",
        matriz->a[0], matriz->b[0],
        matriz->d[0]
    );

    size_t ls = (matriz->N - matriz->tamED);
    for(i=1; i < ls; i++) {
        printf(" |    %2g %2g %2g %2g |\n",
            matriz->c[i-1], matriz->a[i],
            matriz->b[i], matriz->d[i]
        );
    }

    size_t li = ls;
    for(i=li; i < matriz->tamED; i++) {
        printf(" | %2g %2g %2g %2g %2g |\n",
            matriz->e[i-li], matriz->c[i-1],
            matriz->a[i], matriz->b[i],
            matriz->d[i]
        );
    }

    for(i=matriz->tamED; i < matriz->N-1; i++) {
        printf(" | %2g %2g %2g %2g    |\n",
            matriz->e[i-li], matriz->c[i],
            matriz->a[i], matriz->b[i]
        );
    }

    printf(" | %2g %2g %2g       |\n",
        matriz->e[i-li], matriz->c[i-1],
        matriz->a[i]
    );
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
