/*
	*	ALGORITHM SOR(Sucessive Over Relaxation)
	* 	FUNCTIONS TO RESOLUTION OF THE METHOD SOR FOR MATRIX SPARSE
	* 
	* 	LAST-UPDATE 30-09-2015
	*  	@Authors - @ANDRÉ BARRETO, @IGOR VENTORIM, @VINICIUS ARRUDA
*/
#include <stdio.h>
#include <stdlib.h>
#include "sor.h"
#include <time.h>
#include "csr.h"


// *OBS: Função com muitos parâmetros, necessario trabalhar com uma estrutura!
/**
 * [sor - RESOLVENDO MATRIZ POR METODO ITERATIVO SOR]
 * @param  N       [Tamanho da matriz]
 * @param  A       [Matriz]
 * @param  b       [Vetor de termos independentes]
 * @param  omega   [Constante de relaxamento]
 * @param  toler   [Tolerancia de erro]
 * @param  iterMax [Numero maximo de iteraçoes]
 * @return         [Vetor soluçao]
 */
double *sor(const int N,double **A,double *b,float omega, double toler, int iterMax)
{

	int i,j, iter;//, condErro;
	double r, *x,erro,*v;
	float sum, normaNum,normaDen,temp;
	x = calloc(N,sizeof(double));
	v = calloc(N,sizeof(double));


	// Construindo Iteraçao O
	for(i = 0; i < N; i++)
	{
		r = 1/A[i][i];
		for(j = 0; j < N; j++)
		{
			if( i != j)
			{
				A[i][j] = A[i][j] * r;
			}
		}
		b[i] = b[i]*r;
		x[i] = b[i];

	}
	// Finalizando Iteraçao 0
	iter = 0;

	//Loop de Iteraçoes
	do
	{ 
		iter++;
		for(i = 0; i < N; i++)
		{
			sum = 0;
			for(j = 0; j < N; j++)
			{
				if( i != j)
				{
					sum += A[i][j]*x[j];
				}
			}

			v[i] = x[i];
			x[i] = omega*(b[i] - sum) + (1 - omega) * x[i];
		}
		normaNum = 0;
		normaDen = 0;

		//CALCULANDO ERRO
		for(i  = 0; i < N; i++)
		{
			temp = abs(x[i] - v[i]);
			if(temp > normaNum)
			{
				normaNum = temp;
			}

			if(abs(x[i]) > normaDen)
			{
				normaDen = abs(x[i]);
			}
		}
		erro = normaNum/normaDen;
	}while(erro > toler && iter < iterMax);
	//Fim Loop de Iteraçoes

/*	//Verificando Condiçao de parada - 1 Tolerancia / 0 Iteraçoes
	if(erro > toler)
		condErro = 0;
	else
		condErro = 1;*/
	printf("Iter: %d - IterMax: %d\n",iter,iterMax);
	return x;

}


/**
 * [sor2 - RESOLVENDO MATRIZ ESPARSA POR METODO ITERATIVO SOR]
 * @param  matrix  [Estrutura matriz no padrão CSR para matriz esparsas]
 * @param  omega   [Constante de relaxamento]
 * @param  toler   [Tolerancia de erro]
 * @param  iterMax [Numero maximo de iteraçoes]
 * @return         [Vetor soluçao]
 */
double *sor2(CSR* matrix,float omega,double toler, int iterMax)
{
	printf("OI\n");
	struct timespec Start,End;
	clock_gettime(CLOCK_MONOTONIC,&Start);
	// SOR ITERATIVO
	long double erro;
	double soma, *x,normax,aux,Elapsed_Time;
	int i,k,iter,inicio,fim;
	x = calloc(matrix->n,sizeof(int));

	//for(i = 0; i < matrix->n; i++)
		//x[i] = matrix->b[i]/matrix->d[i];
	
	iter = 0;
	// LOOP DE ITERAÇOES
	do{
		erro = 0;
		normax = 0;
		iter++;
		//printf("\nIter: %d\n",iter);
		for(i = 0; i < matrix->n; i++)
		{
			// LIMITES SUPERIOR E INFERIOR DA LINHA
			inicio = matrix->row_ptr[i];
			fim = matrix->row_ptr[i+1];
			if( inicio <= fim)
			{

				soma = matrix->b[i];
				// PERCORRENDO AS COLUNAS NAO NULAS DA LINHA
				for(k = inicio; k < fim; k++)
				{	// Igor gosta de homem
					//printf("TESTANDO - K: %d - Fim: %d\n\n",k,fim);
					soma -= matrix->A[k] * x[matrix->column_index[k]];
				}
				soma = soma / matrix->d[i];
			}
			// CALCULANDO O NOVO VALOR DE X[I]
			aux = omega * soma + (1 - omega) * x[i];

			// GUARDANDO A NORMA DE X
			if(abs(aux) > normax)
				normax = abs(aux);

			// GUARDANDO A NORMA DE X[I] -X[I-1]
			if(abs(aux - x[i]) > erro)
				erro = abs(aux - x[i]);
			x[i] = aux;				
			
		}
		aux = 1;
		if(normax > 1)
			aux = normax;
		//CALCULANDO O ERRO
		erro = erro/aux;

	}while(erro > toler && iter < iterMax);
	// FIM LOOP DE ITERAÇOES
	printf("Iter: %d - IterMax: %d\n",iter,iterMax);

	clock_gettime(CLOCK_MONOTONIC, &End);
	// CALCULANDO TEMPO GASTO DE EXECUÇÃO
	Elapsed_Time = End.tv_sec - Start.tv_sec + 1e-9*(End.tv_nsec - Start.tv_nsec);

	printf("O tempo de execucao gasto foi %lf segundos\n",Elapsed_Time);

	// RETORNANDO VETOR SOLUÇAO
	return x;


}