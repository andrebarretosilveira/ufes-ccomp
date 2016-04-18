#include <stdio.h>
#include <stdlib.h>
#include "contorno.h"

/**
 * [createLPoints Alocando espaço na memória para o vetor de pontos]
 * @param  N [Quantidade de pontos X]
 * @param  M [Quantidade de pontos Y]]
 * @return   [Vetor de pontos criado na memória]
 */
Points* createLPoints(const int N, const int M)
{
	Points *new = calloc((size_t)(N*M),sizeof(Points));
	return new;
}

/**
 * [freeLPoints Libera da memória vetor de pontos]
 * @param lPoints [Vetor de pontos a ser liberado]
 */
void freeLPoints(Points *lPoints)
{
	free(lPoints);
}

/**
 * [discretiza Discretiza dominios e gera pontos]
 * @param lPoints [Vetor de pontos a ser encontrado]
 * @param input   [Dados de entrada]
 */
void discretiza(Points *lPoints, Data *input)
{
	int i,j,pos = 0;
	double hx,hy;

	hx = (input->endX - input->beginX)/((double)input->amountX-1);
	hy = (input->endY - input->beginY)/((double)input->amountY-1);

	for( i = 1; i <= input->amountX;i++)
		for( j = 1; j <= input->amountY;j++)
		{
			lPoints[pos].x = input->beginX + (double)(j - 1)*(hx);
			lPoints[pos].y = input->beginY + (double)(i - 1)*(hy);
			pos++;
		}
}

/**
 * [createVIndependent Criando vetor independente]
 * @param  lPoints [Vetor com todos os pontos discretizados]
 * @param  input   [Dados de entrada]
 * @return         [Vetor independente]
 */
double *createVIndependent(Points *lPoints,Data *input)
{

	double *vetIndependent;
	int i, qtdElementos;
	qtdElementos = (input->amountX * input->amountY);

	vetIndependent = calloc((size_t)qtdElementos,sizeof(double));

    ae_open();
    
    for(i = 0; i < qtdElementos;i++)
	{
        ae_set("x", lPoints[i].x);
        ae_set("y", lPoints[i].y);
        ae_set("e", 2.718281);
		vetIndependent[i] = ae_eval(input->Fxy);
	}
    ae_close();

	return vetIndependent;

}

/**
 * [insertContourn Inserindo valor de contorno na matriz]
 * @param matrix         [Matriz pentadiagonal]
 * @param vetIndependent [Vetor independente]
 * @param index          [Indice I]
 * @param valor          [Valor de contorno]
 * @param input          [Dados de entrada]
 */
void insertContourn(double **matrix, double *vetIndependent, Data *input)
{
	int i,j, qtdElementos;
	int index;
	qtdElementos = (input->amountX * input->amountY);

	for( j = 0; j < input->contour;j++)
	{
		index = generatorNewIndex(input->elements[j].x,input->elements[j].y,input->amountX);
		vetIndependent[index] = input->elements[j].value;
		for(i = 0; i < qtdElementos ; i++)
		{
			if(i == index)
			{
				matrix[index][i] = 1;
			}else
				matrix[index][i] = 0;
		}
	}
}

/**
 * [generatorNewIndex Transforma indice i,j em indice I]
 * @param  i       [Indice i do elemento]
 * @param  j       [Indice j do elemento]
 * @param  amountX [Quantidade de colunas da matriz]
 * @return         [Indice I]
 */
int generatorNewIndex(int i, int j, int amountX)
{
	return i + ((j-1) * amountX) - 1 ;
}

/**
 * [createMatrix Cria matriz pentadiagonal]
 * @param  input [Dados de entrada]
 * @param  a     [Constante a]
 * @param  b     [Constante b]
 * @param  c     [Constante c]
 * @return       [Matriz pentadiagonal]
 */
double **createMatrix(Data *input,double a, double b, double c)
{
	double hx,hy, **matrix;
	double aI,bI,cI,dI,eI;
	int qtdElementos, i, j;

	/*Lendo tamanho da matriz*/
	qtdElementos = (input->amountX * input->amountY);

	/*CALCULANDO hx e hy*/
	hx = (input->endX - input->beginX)/((double)input->amountX-1);
	hy = (input->endY - input->beginY)/((double)input->amountY-1);

	/*VALORES DOS ELEMENTOS DA MATRIZ*/
	aI = c + 2 *((1/(hx*hx)) + (1/(hy*hy)));
	bI = (-1/(hx*hx)) - (a/(2*hx));
	cI = (-1/(hx*hx)) + (a/(2*hx));
	dI = (-1/(hy*hy)) - (b/(2*hy));
	eI = (-1/(hy*hy)) + (b/(2*hy));

	/*ALOCANDO ESPAÇO DA MATRIZ*/
	matrix = calloc((size_t)qtdElementos,sizeof(double*));
	for(i = 0; i < qtdElementos; i++)
		matrix[i] = calloc((size_t)qtdElementos,sizeof(double));

	/*CONSTRUINDO MATRIZ*/
	for(i = 0; i < qtdElementos; i++)
		for( j = 0; j < qtdElementos; j++)
		{
			if( i == j)
				matrix[i][j] = aI;
			else if ((j+1) == i)
				matrix[i][j] = bI;
			else if((j-1) == i)
				matrix[i][j] = cI;
			else if((j+input->amountX) == i) /*CONFERIR -> i - 1ou i - else if((j+input->amount) == i-1)*/
				matrix[i][j] = dI;
			else if ((j-input->amountX) == i) /*CONFERIR -> i-1 ou i  - else if ((j-input->amount) == i-1)*/
				matrix[i][j] = eI;
			else
				matrix[i][j] = 0;
		}

	return matrix;
}

/**
 * [freeMatrix Liberando memória da matriz]
 * @param Matrix [Matriz a ser liberada da memória]
 * @param input  [Dados de entrada]
 */
    void freeMatrix(double** matrix, Data *input)
{
	int i,size;

	size = (input->amountX * input->amountY);
	for(i = 0; i < size; i++)
		free(matrix[i]);

	free(matrix);
}
