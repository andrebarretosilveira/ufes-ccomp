/**
 * matrizPentadiagonal.c
 *
 * Implementação das funções definidas no
 * cabeçalho matrizPentadiagonal.h
 *
 */

#include "matrizPentadiagonal.h"

/**
 * Função que aloca espaço de memória para a matriz pentadiagonal
 * @param  N       Ordem da matriz
 * @param  amountX Quantidade de pontos em x
 * @return         Ponteiro para matriz alocada
 */
MatrizPentadiagonal* newMatrizPenta(const int N, const int amountX)
{
    MatrizPentadiagonal* matriz;
    matriz = malloc(sizeof(MatrizPentadiagonal));
    matriz->e = malloc((N-amountX)*sizeof(double));
    matriz->c = malloc((N-1)*sizeof(double));
    matriz->a = malloc(N*sizeof(double));
    matriz->b = malloc((N-1)*sizeof(double));
    matriz->d = malloc((N-amountX)*sizeof(double));
    matriz->N = N;
    matriz->tamED = (N-amountX);
    return matriz;
}

/**
 * Função que cria a matriz pentadiagonal, preenchendo
 * os cinco vetores com os elementos respectivos
 * @param  input Estrutura de dados de entrada
 * @param  a     Constante BetaxI
 * @param  b     Constante BetayI
 * @param  c     Constante GamaI
 * @return       Ponteiro para Matriz Pentadiagonal preenchida
 */
MatrizPentadiagonal* criaMatrizPenta(Dados* input, Ponto* vetorPontos)
{
	double hx, hy;
	double aI, bI, cI, dI, eI;
	size_t N, i;
    MatrizPentadiagonal* matriz;

    double a=1, b=1, c=1;

	// Ordem da matriz
	N = (input->amountX * input->amountY);

	// Calculando hx e hy
	hx = (input->endX - input->beginX)/((double)input->amountX-1);
	hy = (input->endY - input->beginY)/((double)input->amountY-1);

	// Valores do elementos da matriz
	aI = c + 2 *((1/(hx*hx)) + (1/(hy*hy)));
	bI = (-1/(hx*hx)) - (a/(2*hx));
	cI = (-1/(hx*hx)) + (a/(2*hx));
	dI = (-1/(hy*hy)) - (b/(2*hy));
	eI = (-1/(hy*hy)) + (b/(2*hy));

	// Alocando espaço para a matriz
	matriz = newMatrizPenta(N, input->amountX);

	// Montando a matriz pentadiagonal
    for(i=0; i < matriz->tamED; i++) {
        matriz->e[i] = eI;
        matriz->c[i] = cI;
        matriz->a[i] = aI;
        matriz->b[i] = bI;
        matriz->d[i] = dI;
    }
    for(i=matriz->tamED; i < matriz->N-1; i++) {
        matriz->c[i] = cI;
        matriz->a[i] = aI;
        matriz->b[i] = bI;
    }
    matriz->a[i] = aI;


	return matriz;
}

void preencheMatrizPenta(MatrizPentadiagonal* matriz)
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

void printMatrizPenta(MatrizPentadiagonal *matriz)
{
    size_t i;

    printf("\ne: ");
    for(i=0; i < matriz->tamED; i++)
        printf("%g ", matriz->e[i]);

    printf("\nc: ");
    for(i=0; i < matriz->N-1; i++)
        printf("%g ", matriz->c[i]);

    printf("\na: ");
    for(i=0; i < matriz->N; i++)
        printf("%g ", matriz->a[i]);

    printf("\nb: ");
    for(i=0; i < matriz->N-1; i++)
        printf("%g ", matriz->b[i]);

    printf("\nd: ");
    for(i=0; i < matriz->tamED; i++)
        printf("%g ", matriz->d[i]);

    printf("\n");

}

/**
 * Libera espaço alocado pela matriz pentadiagonal
 * @param matriz Matriz a ser desalocada
 */
void freeMatrizPenta(MatrizPentadiagonal *matriz)
{
    free(matriz->e);
    free(matriz->c);
    free(matriz->a);
    free(matriz->b);
    free(matriz->d);
    free(matriz);
}
