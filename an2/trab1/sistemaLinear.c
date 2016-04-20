/**
 * sistemaLinear.c
 *
 * Implementação das funções definidas no
 * cabeçalho sistemaLinear.h
 *
 */

#include "sistemaLinear.h"

SistemaLinear* criaSistemaLinear(MatrizPentadiagonal* matriz, double* f, const size_t N)
{
    SistemaLinear* sistema;
    sistema = malloc(sizeof(SistemaLinear));
    sistema->matriz = matriz;
    sistema->f = f;
    sistema->N = N;
    return sistema;
}

/**
 * Função que aplica as condições de contorno no sistema linear
 * modificando a Matriz Pentadiagonal e o vetor independente
 * @param sistema           Sistema Linear do problema
 * @param input             [description]
 */
void aplicaContorno(SistemaLinear* sistema, Dados *dados)
{
	int i, j, I;
    //size_t N;
    MatrizPentadiagonal* matriz;

    matriz = sistema->matriz;
    //N = matriz->N;

    for(i=0, j=0; i < dados->amountX; i++) {
        I = indiceDiscreto(i, j, dados->amountX);
        printf("%d + (%d*%d) = I = %d \n", i,j,dados->amountX,I);
        sistema->f[I] = 1;
        matriz->b[I] = 0;
        matriz->a[I] = 1;
        matriz->c[I] = 0;
        matriz->d[I] = 0;
    }
    for(i=dados->amountX-1, j=1; j < dados->amountY-1; j++) {
        I = indiceDiscreto(i, j, dados->amountX);
        printf("%d + (%d*%d) = I = %d \n", i,j,dados->amountX,I);
        sistema->f[I] = 1;
        matriz->e[I] = 0;
        matriz->a[I] = 1;
        matriz->c[I] = 0;
        matriz->d[I] = 0;
    }
    for(i=dados->amountX-1, j=dados->amountY-1; i > 0; i--) {
        I = indiceDiscreto(i, j, dados->amountX);
        printf("%d + (%d*%d) = I = %d \n", i,j,dados->amountX,I);
        sistema->f[I] = 1;
        matriz->e[I] = 0;
        matriz->b[I] = 0;
        matriz->a[I] = 1;
        matriz->c[I] = 0;
    }
    for(i=0, j=dados->amountY-1; j > 0; j--) {
        I = indiceDiscreto(i, j, dados->amountX);
        printf("%d + (%d*%d) = I = %d \n", i,j,dados->amountX,I);
        sistema->f[I] = 1;
        matriz->e[I] = 0;
        matriz->b[I] = 0;
        matriz->a[I] = 1;
        matriz->d[I] = 0;
    }
}

/**
 * Transforma ij em indice I discreto
 * @param  i       Indice i do elemento
 * @param  j       Indice j do elemento
 * @param  amountX Número de pontos em x
 * @return         Indice I
 */
int indiceDiscreto(int i, int j, int amountX)
{
	return i + (j * amountX);
}

void printSistemaLinear(SistemaLinear* sistema)
{
    size_t i;
    printMatrizPenta(sistema->matriz);
    printf("\n");
    for(i=0; i < sistema->N; i++) {
        printf("%g ", sistema->f[i]);
    }

    printf("\n");
}

void freeSistemaLinear(SistemaLinear* sistema)
{
    freeMatrizPenta(sistema->matriz);
    free(sistema->f);
    free(sistema);
}
