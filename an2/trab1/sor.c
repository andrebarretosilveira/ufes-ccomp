/**
 * sor.c
 *
 * Implementação do SOR para os dois casos:
 * SOR em matriz pentadiagonal e SOR livre
 * de matriz
 *
 */

#include <math.h>
#include "sor.h"


double *sor(SistemaLinear* sistema, double omega, double toler, size_t iterMax)
{
	double *x; // Vetor solução
	double soma, normaX, normaDif, aux, erro;
	size_t i, j, iter, dr;

    // Solução inicial nula
	x = calloc(sistema->N, sizeof(double));

    // Distância relativa de elementos até a primeira
    // ocorrência de um elemento "e". Em outras palavras,
    // o número n de partições no eixo x
    dr = (sistema->matriz->N - sistema->matriz->tamED);

    // Iterar até erro aceitável ou máximo de iterações atingido
	iter = 0;
	do {
		iter++;

		// Loop para encontrar x[i]
		for(i = 0; i < sistema->N; i++) {
            soma = 0;

            // Primeira linha da matriz: apenas existem
            // os elementos de a, b e d
            soma += sistema->matriz->b[0]*x[1] +
                    sistema->matriz->d[0]*x[dr];

            // Linhas que possuem c, a, b e d até a
            // ocorrência do primeiro elemento de e:
            // de 1 até dr+1
            for(j=1; j < dr; j++) {
                soma += sistema->matriz->c[j-1] * x[j-1] +
                        sistema->matriz->b[j]   * x[j+1] +
                        sistema->matriz->d[j]   * x[j+dr];
            }

            // Linhas que possuem e, c, a, b e d até
            // a NÃO ocorrência de elementos de d:
            // de dr até tamED
            for(j=dr; j < sistema->matriz->tamED; j++) {
                soma += sistema->matriz->e[j-dr] * x[j-dr] +
                        sistema->matriz->c[j-1]  * x[j-1]  +
                        sistema->matriz->b[j]    * x[j+1]  +
                        sistema->matriz->d[j]    * x[j+dr];
            }

            // Linhas que possuem e, c, a e b até
            // a NÃO ocorrência de elementos de b:
            // de tamED até N-1
            for(j=sistema->matriz->tamED; j < sistema->N-1; j++) {
                soma += sistema->matriz->e[j-dr] * x[j-dr] +
                        sistema->matriz->c[j-1]  * x[j-1]  +
                        sistema->matriz->b[j]    * x[j+1];
            }

            // Última linha da matriz: apenas existem
            // os elementos de e, c e a
            soma += sistema->matriz->e[j-dr] * x[j-dr] +
                    sistema->matriz->c[j-1]  * x[j-1];

			// Calculo do novo valor de x[i]
            //printf("aux = (1-%g)*%g + (%g/%g)*(%g-%g)\n", omega, x[i], omega, sistema->matriz->a[i], sistema->f[i], soma);
			aux = (1 - omega) * x[i] + (omega/sistema->matriz->a[i]) * (sistema->f[i] - soma);

			// Norma de x[i]
            normaX = fabs(aux);

			// Norma da diferença (x[i] - x[i-1])
            normaDif = fabs(aux - x[i]);

			// Atualizando valor de x[i]
			x[i] = aux;
		}

		// Cálculo do erro
		erro = normaDif/normaX;

		printf("ERRO: %f\n",erro);
	}
    while(erro > toler && iter < iterMax);

	printf("Iter: %lu - IterMax: %lu\n",iter,iterMax);

	return x;
}
