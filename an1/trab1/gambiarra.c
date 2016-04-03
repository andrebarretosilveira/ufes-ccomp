#include <stdio.h>
#include <stdlib.h>

void lerMatriz(char *file_name,double **matrix,double *b)
{
	FILE* stream;
	size_t i,j,k;
	size_t n;
	size_t nnz;


	stream  = fopen(file_name, "r");

	fscanf(stream, "%lu %lu %lu", &n, &n, &nnz); /* im getting errors while suppressing with * */
	//fprintf(stdout, "%lu %lu %lu\n", n, n, nnz); /* debug */

	matrix = calloc(n,sizeof(double*));
	b = calloc(n,sizeof(double));


	for(i = 0; i < n; i++)
	{
		b[i] = 0;
		matrix[i] = calloc(n,sizeof(double));
		for(j = 0; j < n; j++)
			matrix[i][j] = 0;
	}

	for(k = 0; k < nnz; k++)
	{

		fscanf(stream, "%lu %lu ", &i, &j);
		fscanf(stream, "%lf", &matrix[i-1][j-1]);
	}

	for(k = 0; k < n; k++)
		fscanf(stream, "%lf", &b[i]);

	FILE *out = fopen("matriz.txt","w");


	for(i = 0; i < n; i++)
	{
		for(j = 0; j < n; j++)
			if(matrix[i][j] != 0)
			{
				fprintf(out,"%f ",matrix[i][j]);
			}else
				fprintf(out,"0 ");
			fprintf(out,"\n");

	}

	fclose(out);
	fclose(stream);

}
