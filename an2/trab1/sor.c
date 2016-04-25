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

/**
 * Algoritmo SOR - Successive Over Relaxation:
 * resolve o sistema linear pentadiagonal
 * @param  sistema Ponteiro para o sistema linear
 * @param  omega   Parâmetro de relaxação do SOR
 * @param  toler   Tolerância do erro de parada
 * @param  iterMax Número máximo de iterações
 * @return         O vetor solução do sistema
 */
double *sor(SistemaLinear* sistema, double omega, double toler, size_t iterMax)
{
	double *x; // Vetor solução
	double soma, normaX, normaDif, aux, erro;
	size_t i, j, iter, dr;
    MatrizPentadiagonal* matriz;

    // Solução inicial nula
	x = calloc(sistema->N, sizeof(double));

    matriz = sistema->matriz;

    // Distância relativa de elementos até a primeira
    // ocorrência de um elemento "e". Em outras palavras,
    // o número n de partições +1 no eixo x
    dr = (matriz->N - matriz->tamED);

    // Iterar até erro aceitável ou máximo de iterações atingido
	iter = 0;
	do {
        normaX = 0;
        normaDif = 0;
        i = 0;
		iter++;

        /*
         * Cálculo de x[0]
         * Primeira linha da matriz: apenas existem
         * os elementos de a, b e d
         */
        soma = matriz->b[i] * x[1] +
               matriz->d[i] * x[dr];

        // Novo valor de x[i] em auxiliar para calcular norma e avaliar erro
        aux = (1 - omega) * x[i] + (omega/matriz->a[i]) * (sistema->f[i] - soma);

        // Norma de x[i]
        if(fabs(aux) > normaX)
            normaX = fabs(aux);

        // Norma da diferença (x[i] - x[i-1])
        if(fabs(aux - x[i]) > normaDif)
            normaDif = fabs(aux - x[i]);

        // Atualizando valor de x[i]
        x[i] = aux;

        i++;

        /*
         * Cálculo de x[1] até x[dr-1]
         * Linhas que possuem c, a, b e d até a
         * ocorrência do primeiro elemento de e:
         * de 1 até dr-1
         */
        for(j=1; j < dr; j++, i++) {
            soma = matriz->c[j] * x[j-1] +
                   matriz->b[j] * x[j+1] +
                   matriz->d[j] * x[j+dr];

            // Novo valor de x[i] em auxiliar para calcular norma e avaliar erro
            aux = (1 - omega) * x[i] + (omega/matriz->a[i]) * (sistema->f[i] - soma);

            // Norma de x[i]
            if(fabs(aux) > normaX)
                normaX = fabs(aux);

            // Norma da diferença (x[i] - x[i-1])
            if(fabs(aux - x[i]) > normaDif)
                normaDif = fabs(aux - x[i]);

            // Atualizando valor de x[i]
            x[i] = aux;
        }

        /*
         * Cálculo de x[dr] até x[tamED-1]
         * Linhas que possuem e, c, a, b e d até
         * a NÃO ocorrência de elementos de d:
         * de dr até tamED-1
         */
        for(j=dr; j < matriz->tamED; j++, i++) {
            soma = matriz->e[j] * x[j-dr] +
                   matriz->c[j] * x[j-1]  +
                   matriz->b[j] * x[j+1]  +
                   matriz->d[j] * x[j+dr];

            // Novo valor de x[i] em auxiliar para calcular norma e avaliar erro
            aux = (1 - omega) * x[i] + (omega/matriz->a[i]) * (sistema->f[i] - soma);

            // Norma de x[i]
            if(fabs(aux) > normaX)
                normaX = fabs(aux);

            // Norma da diferença (x[i] - x[i-1])
            if(fabs(aux - x[i]) > normaDif)
                normaDif = fabs(aux - x[i]);

            // Atualizando valor de x[i]
            x[i] = aux;
        }

        /*
         * Cálculo de x[tamED] até x[N-2]
         * Linhas que possuem e, c, a e b até
         * a NÃO ocorrência de elementos de b:
         * de tamED até N-1
         */
        for(j=matriz->tamED; j < sistema->N-1; j++, i++) {
            soma = matriz->e[j] * x[j-dr] +
                   matriz->c[j] * x[j-1]  +
                   matriz->b[j] * x[j+1];

            // Novo valor de x[i] em auxiliar para calcular norma e avaliar erro
            aux = (1 - omega) * x[i] + (omega/matriz->a[i]) * (sistema->f[i] - soma);

            // Norma de x[i]
            if(fabs(aux) > normaX)
                normaX = fabs(aux);

            // Norma da diferença (x[i] - x[i-1])
            if(fabs(aux - x[i]) > normaDif)
                normaDif = fabs(aux - x[i]);

            // Atualizando valor de x[i]
            x[i] = aux;
        }

        /*
         * Cálculo de x[N-1]
         * Última linha da matriz: apenas existem
         * os elementos de e, c e a
         */
        soma = matriz->e[j] * x[j-dr] +
               matriz->c[j] * x[j-1];

        // Novo valor de x[i] em auxiliar para calcular norma e avaliar erro
        aux = (1 - omega) * x[i] + (omega/matriz->a[i]) * (sistema->f[i] - soma);

        // Norma de x[i]
        if(fabs(aux) > normaX)
            normaX = fabs(aux);

        // Norma da diferença (x[i] - x[i-1])
        if(fabs(aux - x[i]) > normaDif)
            normaDif = fabs(aux - x[i]);

        // Atualizando valor de x[i]
        x[i] = aux;

		/*
         * Cálculo do erro
         */
		erro = normaDif/normaX;
	}
    while(erro > toler && iter < iterMax);

    printf("Erro: %f\n", erro);
	printf("Iter: %lu - IterMax: %lu\n",iter,iterMax);

	return x;
}
