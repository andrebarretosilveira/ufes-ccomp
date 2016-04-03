	/*
	*	ALGORITHM SOR(Sucessive Over Relaxation)
	* 	FUNCTIONS TO RESOLUTION OF THE METHOD SOR FOR MATRIX SPARSE
	*
	* 	LAST-UPDATE 03-10-2015
	*  	@Authors - @ANDRÉ BARRETO, @IGOR VENTORIM, @VINICIUS ARRUDA
*/
#include <stdio.h>
#include <stdlib.h>
#include "sor.h"
#include <time.h>
#include "csr.h"
#include <math.h>


/**
 * [sor2 - RESOLVENDO MATRIZ ESPARSA POR METODO ITERATIVO SOR]
 * @param  matrix  [Estrutura matriz no padrão CSR para matriz esparsas]
 * @param  omega   [Constante de relaxamento]
 * @param  toler   [Tolerancia de erro]
 * @param  iterMax [Numero maximo de iteraçoes]
 * @return         [Vetor soluçao]
 */
double *sor(CSR* matrix,double omega,double toler, size_t iterMax)
{
	struct timespec Start,End;
	clock_gettime(CLOCK_MONOTONIC,&Start);
	// SOR ITERATIVO
	double *x;	/* VETOR SOLUÇÃO */
	double soma,normax,aux,Elapsed_Time,erro;
	size_t i,k,iter,inicio,fim;

	x = calloc(matrix->n,sizeof(double));	/* ALOCANDO TAMANHO DO VETOR SOLUÇÃO */

	/* PREENCHENDO VETOR INDEPENDENTE INICIAL */
	//for(i = 0; i < matrix->n; i++)
	//	x[i] = matrix->b[i]/matrix->d[i];

	iter = 0;
	/* LOOP DE ITERAÇOES */
	do{
		erro = 0;
		normax = 0;
		iter++;

		/* LOOP PARA ENCONTRAR O VALOR DE CADA VARIÁVEL X */
		for(i = 0; i < matrix->n; i++)
		{
			/* LIMITES SUPERIOR E INFERIOR DA LINHA */
			inicio = matrix->row_ptr[i];
			fim = matrix->row_ptr[i+1]-1;

			/* INICIANDO CONTA COM O INDICE DO VETOR INDEPENDENTE */
			soma = matrix->b[i];
			if( inicio <= fim)
			{

				/* PERCORRENDO AS COLUNAS NAO NULAS DA LINHA */
				for(k = inicio; k <= fim; k++)
				{
					/*ALGEBRA PARA ENCONTRAR A EQUAÇÃO DE X[I]*/
					soma -= matrix->A[k]* x[matrix->column_index[k]];
				}

			}
			/* DIVIDINDO EQUAÇÃO PELA DIAGONAL */
			soma = soma / matrix->d[i];

			/* CALCULANDO O NOVO VALOR DE X[I] APARTI DO FATOR DE RELAXAÇÃO */
			aux = omega * soma + (1 - omega) * x[i];

			/* GUARDANDO A NORMA DE X */
			if(fabs(aux) > normax)
				normax = fabs(aux);

			/* GUARDANDO A NORMA DE X[I] -X[I-1] */
			if(fabs(aux - x[i]) > erro)
				erro = fabs(aux - x[i]);

			/* ATUALIZANDO O VALOR DE X[I] */
			x[i] = aux;

		}
		aux = 1;
		if(normax > 1)
			aux = normax;
		//CALCULANDO O ERRO
		erro = erro/aux;

		//printf("ERRO - %f\n",erro);

	}while(erro > toler && iter < iterMax);
	// FIM LOOP DE ITERAÇOES
	printf("Iter: %lu - IterMax: %lu\n",iter,iterMax);

	clock_gettime(CLOCK_MONOTONIC, &End);
	// CALCULANDO TEMPO GASTO DE EXECUÇÃO
	Elapsed_Time = End.tv_sec - Start.tv_sec + 1e-9*(End.tv_nsec - Start.tv_nsec);

	printf("O tempo de execucao gasto foi %g segundos\n",Elapsed_Time);

	// RETORNANDO VETOR SOLUÇAO
	return x;

}
