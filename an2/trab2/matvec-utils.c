#include "matvec-utils.h"

double* createVector(int n)
{
	return calloc(n, sizeof(double));
}

double** createMatrix(int n, int m)
{
	int i;
	double** matrix = calloc(n, sizeof(double*));

	for(i=0; i < n; i++)
		matrix[i] = createVector(m);
	
	return matrix;
}

double InnerProduct(double *A1, double *B1, int N)
{
	int I;
	double IP = 0.0;

	for (I=0; I<N; I++)
		IP += A1[I] * B1[I];
	return(IP);
}

void substRetroativas(double **A, double *x, double *b, int N)
{
	int i,j;
	double soma;
	
	x[N] = b[N]/A[N][N];
	for (i=N-1; i >= 0; i--)
	{
		soma = 0;
		for (j=i+1; j <= N; j++)
        {
			soma += A[j][i]*x[j];	
        }
		x[i] = (1./A[i][i])*(b[i]-soma);
	}
}

void substSucessivas(double **A, double *x, double *b, int N)
{
	int i,j;
	double soma;
	
	x[0] = b[0]/A[0][0];
	for (i=1; i <= N; i++)
	{
		soma = 0;
		for (j=0; j < i; j++)
        {
			soma += A[i][j]*x[j];	
        }

		x[i] = (1./A[i][i])*(b[i]-soma);
	}
}

void printVector(double* vet, int n)
{
    int i;

    for(i=0; i < n; i++)
        printf("%.2lf ", vet[i]);

    printf("\n");
}

void printMatrix(double** mat, int n, int m)
{
    int i, j;

    for(i=0; i < n; i++) {
        for(j=0; j < m; j++)
            printf("%.2lf ", mat[i][j]);

        printf("\n");
    }

    printf("\n");
}

void freeMatrix(double** M, int n)
{
    int i;

    for(i=0; i < n; i++)
        free(M[i]);

    free(M);
}
