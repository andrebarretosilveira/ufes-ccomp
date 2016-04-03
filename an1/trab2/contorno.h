#include "io.h"
#include "ae.h"

#ifndef CONTOUR_H
#define CONTOUR_H

typedef struct point
{
	double x;
	double y;
}Points;

/** [createLPoints Alocando espaço na memória para o vetor de pontos] */
Points* createLPoints(const int N, const int M);

/** [discretiza Discretiza dominios e gera pontos] */
void discretiza(Points *lPoints, Data *input/*,double *hx, double *hy*/);

/** [freeLPoints Libera da memória vetor de pontos] */
void freeLPoints(Points *lPoints);

/** [createVIndependent Criando vetor independente] */
double *createVIndependent(Points *lPoints,Data *input);

/** [insertContourn Inserindo valor de contorno na matriz] */
void insertContourn(double **matrix, double *vetIndependent, Data *input);

/** [generatorNewIndex Transforma indice i,j em indice I] */
int generatorNewIndex(int i, int j, int amountX);

/** [createMatrix Cria matriz pentadiagonal] */
double **createMatrix(Data *input,double a, double b, double c);

/** [freeMatrix Liberando memória da matriz] */
void freeMatrix(double** matrix, Data *input);

#endif
