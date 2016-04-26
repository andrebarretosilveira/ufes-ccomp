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

	printf("Numero de iteracoes: %lu\n",iter);
    printf("Erro: %f\n", erro);

	return x;
}

/**
 * Algoritmo SOR - Successive Over Relaxation:
 * resolve o método das diferenças finitas
 * bidimensional livre de matriz
 * @param  omega   Parâmetro de relaxação do SOR
 * @param  toler   Tolerância do erro de parada
 * @param  iterMax Número máximo de iterações
 * @return         O vetor solução do sistema
 */
double *sorLivre(Dados* dados, double omega, double toler, size_t iterMax)
{
	double *x; // Vetor solução
	double soma, normaX, normaDif, aux, erro;
    double e, c, a, b, d, vetInd, tamED;
    double hx, hy;
	size_t N, i, j, iter, dr;

    N = dados->amountX*dados->amountY;

    // Solução inicial nula
	x = calloc(N, sizeof(double));

    // Distância relativa de elementos até a primeira
    // ocorrência de um elemento "e". Em outras palavras,
    // o número n de partições +1 no eixo x
    dr = dados->amountX + 1;

    tamED = N - dados->amountX;

    // Calculando hx e hy
	hx = (dados->endX - dados->beginX)/((double)dados->amountX-1);
	hy = (dados->endY - dados->beginY)/((double)dados->amountY-1);

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
        a = 2 *((1/(hx*hx)) + (1/(hy*hy)));
        b = (-1/(hx*hx));
        d = (-1/(hy*hy));
        vetInd = T0;

        soma = b * x[1] +
               d * x[dr];

        // Novo valor de x[i] em auxiliar para calcular norma e avaliar erro
        aux = (1 - omega) * x[i] + (omega/a) * (vetInd - soma);

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
        c = (-1/(hx*hx));
        a = 2 *((1/(hx*hx)) + (1/(hy*hy)));
        b = (-1/(hx*hx));
        d = (-1/(hy*hy));
        vetInd = 0;

        for(j=1; j < dr; j++, i++) {
            soma = c * x[j-1] +
                   b * x[j+1] +
                   d * x[j+dr];

            // Novo valor de x[i] em auxiliar para calcular norma e avaliar erro
            aux = (1 - omega) * x[i] + (omega/a) * (vetInd - soma);

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
        e = (-1/(hy*hy));
        c = (-1/(hx*hx));
        a = 2 *((1/(hx*hx)) + (1/(hy*hy)));
        b = (-1/(hx*hx));
        d = (-1/(hy*hy));

        for(j=dr; j < tamED; j++, i++) {
            soma = e * x[j-dr] +
                   c * x[j-1]  +
                   b * x[j+1]  +
                   d * x[j+dr];

            // Novo valor de x[i] em auxiliar para calcular norma e avaliar erro
            aux = (1 - omega) * x[i] + (omega/a) * (vetInd - soma);

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
        e = (-1/(hy*hy));
        c = (-1/(hx*hx));
        a = 2 *((1/(hx*hx)) + (1/(hy*hy)));
        b = (-1/(hx*hx));

        for(j=tamED; j < N-1; j++, i++) {
            soma = e * x[j-dr] +
                   c * x[j-1]  +
                   b * x[j+1];

            // Novo valor de x[i] em auxiliar para calcular norma e avaliar erro
            aux = (1 - omega) * x[i] + (omega/a) * (vetInd - soma);

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
        e = (-1/(hy*hy));
        c = (-1/(hx*hx));
        a = 2 *((1/(hx*hx)) + (1/(hy*hy)));

        soma = e * x[j-dr] +
               c * x[j-1];

        // Novo valor de x[i] em auxiliar para calcular norma e avaliar erro
        aux = (1 - omega) * x[i] + (omega/a) * (vetInd - soma);

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

	printf("Numero de iteracoes: %lu\n",iter);
    printf("Erro: %f\n", erro);

	return x;
}

double *sorLivre2(Dados* dados, double omega, double toler, size_t iterMax)
{
	double *x; // Vetor solução
	double soma, normaX, normaDif, aux, erro;
    double e, c, a, b, d, vetInd, tamED;
	size_t N, i, j, iter, dr;

    N = dados->amountX*dados->amountY;

    // Solução inicial nula
	x = calloc(N, sizeof(double));

    // Distância relativa de elementos até a primeira
    // ocorrência de um elemento "e". Em outras palavras,
    // o número n de partições +1 no eixo x
    dr = dados->amountX + 1;

    tamED = N - dados->amountX;

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
        soma = b * x[1] +
               d * x[dr];

        // Novo valor de x[i] em auxiliar para calcular norma e avaliar erro
        aux = (1 - omega) * x[i] + (omega/a) * (vetInd - soma);

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
            soma = c * x[j-1] +
                   b * x[j+1] +
                   d * x[j+dr];

            // Novo valor de x[i] em auxiliar para calcular norma e avaliar erro
            aux = (1 - omega) * x[i] + (omega/a) * (vetInd - soma);

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
        for(j=dr; j < tamED; j++, i++) {
            soma = e * x[j-dr] +
                   c * x[j-1]  +
                   b * x[j+1]  +
                   d * x[j+dr];

            // Novo valor de x[i] em auxiliar para calcular norma e avaliar erro
            aux = (1 - omega) * x[i] + (omega/a) * (vetInd - soma);

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
        for(j=tamED; j < N-1; j++, i++) {
            soma = e * x[j-dr] +
                   c * x[j-1]  +
                   b * x[j+1];

            // Novo valor de x[i] em auxiliar para calcular norma e avaliar erro
            aux = (1 - omega) * x[i] + (omega/a) * (vetInd - soma);

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
        soma = e * x[j-dr] +
               c * x[j-1];

        // Novo valor de x[i] em auxiliar para calcular norma e avaliar erro
        aux = (1 - omega) * x[i] + (omega/a) * (vetInd - soma);

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

	printf("Numero de iteracoes: %lu\n",iter);
    printf("Erro: %f\n", erro);

	return x;
}
