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
MatrizPentadiagonal* alocaMatrizPentadiagonal(const int N)
{
    MatrizPentadiagonal* matriz;
    matriz = malloc(sizeof(MatrizPentadiagonal));
    matriz->e = malloc(N*sizeof(double));
    matriz->c = malloc(N*sizeof(double));
    matriz->a = malloc(N*sizeof(double));
    matriz->b = malloc(N*sizeof(double));
    matriz->d = malloc(N*sizeof(double));
    return matriz;
}

/**
 * Função que cria a matriz pentadiagonal, preenchendo
 * os cinco vetores com os elementos respectivos
 * @param  dados       Ponteiro para estrutura de dados
 * @param  vetorPontos Vetor de pontos discretos
 * @return             Ponteiro para estrutura da matriz
 *                     pentadiagonal criada
 */
MatrizPentadiagonal* criaMatrizPentadiagonal(Dados* dados, Ponto* vetorPontos)
{
    size_t N;
    MatrizPentadiagonal* matriz;

	// Ordem da matriz
	N = (dados->amountX * dados->amountY);

	// Alocando espaço para a matriz
	matriz = alocaMatrizPentadiagonal(N);
    matriz->N = N;
    matriz->tamED = (N-dados->amountX);

    // Validação 1
    if(flagExp == 1)
        montaMatrizV1(matriz, dados);

    // Validação 2
    else if(flagExp == 2)
        montaMatrizV2(matriz, dados, vetorPontos);

    // Aplicação Física 1
    else if(flagExp == 3)
        montaMatrizA1(matriz, dados);

    // Aplicação Física 2
    else if(flagExp == 4)
        montaMatrizA2(matriz, dados, vetorPontos);

	return matriz;
}

/**
 * Método de construção específico do experimento 1:
 * "Validação 1 - Solução trivial"
 * @param matriz      Ponteiro para matriz pentadiagonal
 * @param dados       Ponteiro para estrutura de Dados
 */
void montaMatrizV1(MatrizPentadiagonal* matriz, Dados* dados)
{
    size_t i;
    double hx, hy;

    // Calculando hx e hy
	hx = (dados->endX - dados->beginX)/((double)dados->amountX-1);
	hy = (dados->endY - dados->beginY)/((double)dados->amountY-1);

    // Montando a matriz pentadiagonal
    // BETAx, BETAy, GAMA são nulos
    for(i=0; i < matriz->N; i++) {
        matriz->e[i] = (-1/(hy*hy));
        matriz->c[i] = (-1/(hx*hx));
        matriz->a[i] = 2 *((1/(hx*hx)) + (1/(hy*hy)));
        matriz->b[i] = (-1/(hx*hx));
        matriz->d[i] = (-1/(hy*hy));
    }
}

/**
 * Método de construção específico do experimento 2:
 * "Validação 2 - Solução conhecida"
 * @param matriz      Ponteiro para matriz pentadiagonal
 * @param dados       Ponteiro para estrutura de Dados
 * @param vetorPontos Vetor de pontos discretos
 */
void montaMatrizV2(MatrizPentadiagonal* matriz, Dados* dados, Ponto* vetorPontos)
{
    size_t i;
    double y, hx, hy;

    // Calculando hx e hy
	hx = (dados->endX - dados->beginX)/((double)dados->amountX-1);
	hy = (dados->endY - dados->beginY)/((double)dados->amountY-1);

    // Montando a matriz pentadiagonal
    // k = 1
    // BETAx = 1
    // BETAy = 20y
    // GAMA = 1
    for(i=0; i < matriz->N; i++) {
        y = vetorPontos[i].y;
        matriz->e[i] = (-1/(hy*hy)) - (20*y/(2*hy));
        matriz->c[i] = (-1/(hx*hx)) - (1/(2*hx));
        matriz->a[i] = 1 + 2*((1/(hx*hx)) + (1/(hy*hy)));
        matriz->b[i] = (-1/(hx*hx)) + (1/(2*hx));
        matriz->d[i] = (-1/(hy*hy)) + (20*y/(2*hy));
    }
}

/**
 * Método de construção específico do experimento 3:
 * "Aplicação Física 1 - Resfriador bidimensional"
 * @param matriz      Ponteiro para matriz pentadiagonal
 * @param dados       Ponteiro para estrutura de Dados
 */
void montaMatrizA1(MatrizPentadiagonal* matriz, Dados* dados)
{
    size_t i;
    double hx, hy;
    double c, T;

    // Constantes do problema
    c = 1;
    T = 2;

    // Calculando hx e hy
	hx = (dados->endX - dados->beginX)/((double)dados->amountX-1);
	hy = (dados->endY - dados->beginY)/((double)dados->amountY-1);

    // Montando a matriz pentadiagonal
    // k = 1
    // BETAx = 0
    // BETAy = 0
    // GAMA = 2c/T
    for(i=0; i < matriz->N; i++) {
        matriz->e[i] = (-1/(hy*hy));
        matriz->c[i] = (-1/(hx*hx));
        matriz->a[i] = 2*c/T + 2 *((1/(hx*hx)) + (1/(hy*hy)));
        matriz->b[i] = (-1/(hx*hx));
        matriz->d[i] = (-1/(hy*hy));
    }
}

/**
 * Método de construção específico do experimento 4:
 * "Aplicação Física 2 - Escoamento em Águas Subterrâneas"
 * @param matriz      Ponteiro para matriz pentadiagonal
 * @param dados       Ponteiro para estrutura de Dados
 * @param vetorPontos Vetor de pontos discretos
 */
void montaMatrizA2(MatrizPentadiagonal* matriz, Dados* dados, Ponto* vetorPontos)
{
    size_t i;
    double x, y, hx, hy;

    // Calculando hx e hy
	hx = (dados->endX - dados->beginX)/((double)dados->amountX-1);
	hy = (dados->endY - dados->beginY)/((double)dados->amountY-1);

    // Montando a matriz pentadiagonal
    for(i=0; i < matriz->N; i++) {
        x = vetorPontos[i].x;
        y = vetorPontos[i].y;
        matriz->e[i] = (-1/(hy*hy)) - (BETAy(x,y)/(2*hy));
        matriz->c[i] = (-1/(hx*hx)) - (BETAx(x,y)/(2*hx));
        matriz->a[i] = GAMA(x,y) + 2 *((1/(hx*hx)) + (1/(hy*hy)));
        matriz->b[i] = (-1/(hx*hx)) + (BETAx(x,y)/(2*hx));
        matriz->d[i] = (-1/(hy*hy)) + (BETAy(x,y)/(2*hy));
    }
}

void printMatrizPentadiagonal(MatrizPentadiagonal *matriz)
{
    size_t i;

    printf("\ne: ");
    for(i=0; i < matriz->N; i++)
        printf("%g ", matriz->e[i]);

    printf("\nc: ");
    for(i=0; i < matriz->N; i++)
        printf("%g ", matriz->c[i]);

    printf("\na: ");
    for(i=0; i < matriz->N; i++)
        printf("%g ", matriz->a[i]);

    printf("\nb: ");
    for(i=0; i < matriz->N; i++)
        printf("%g ", matriz->b[i]);

    printf("\nd: ");
    for(i=0; i < matriz->N; i++)
        printf("%g ", matriz->d[i]);

    printf("\n");
}

/**
 * Libera espaço alocado pela matriz pentadiagonal
 * @param matriz Matriz a ser desalocada
 */
void freeMatrizPentadiagonal(MatrizPentadiagonal *matriz)
{
    free(matriz->e);
    free(matriz->c);
    free(matriz->a);
    free(matriz->b);
    free(matriz->d);
    free(matriz);
}
