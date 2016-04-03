#include <stdio.h>
#include <stdlib.h>
#include "csr.h"


#define SEE_DATA 1


#define get_memory(ptr, size) ((ptr) = malloc(size));if((ptr) == NULL){fprintf(stderr, "Out of memory.\n");exit(EXIT_FAILURE);}


#if	SEE_DATA
static void printCSR(CSR* csr);
#endif


static COO* new_coo(size_t n, size_t nnz);
static void freeCOO(COO* coo);


static COO* new_coo(size_t n, size_t nnz)
{
	COO* new;

	get_memory(new, sizeof(COO));

	new->n = n;
	new->nnz = nnz - n;

	get_memory(new->column_index, new->nnz * sizeof(size_t));
	get_memory(new->row_index, new->nnz * sizeof(size_t));
	get_memory(new->A, new->nnz * sizeof(double));
	get_memory(new->d, n * sizeof(double));
	get_memory(new->b, n * sizeof(double));

	return new;
}


CSR* new_csr(size_t n, size_t nnz)
{
	CSR* new;

	get_memory(new, sizeof(CSR));

	new->n = n;
	new->nnz = nnz;

	get_memory(new->column_index, nnz * sizeof(size_t));
	get_memory(new->row_ptr, (n + 1) * sizeof(size_t));
	get_memory(new->A, nnz * sizeof(double));
	
	new->d = NULL;  /* d receberá o d de COO */
	new->b = NULL;  /* b receberá o b de COO */

	return new;
}


static void freeCOO(COO* coo)
{
	free(coo->column_index);
	free(coo->row_index);
	free(coo->A);
	free(coo);
}


void freeCSR(CSR* csr)
{
	free(csr->column_index);
	free(csr->row_ptr);
	free(csr->A);
	free(csr->d);
	free(csr->b);
	free(csr);
}


CSR* get_csr(const char* file_name)
{
	FILE* stream;
	COO* coo;
	size_t i;
	size_t j;
	size_t x;
	size_t y;
	size_t n;
	size_t nnz;
	double temp_A;


	stream  = fopen(file_name, "r");

	if(stream == NULL)
	{
		fprintf(stderr, "Error while opening file %s.\n", file_name);
		exit(EXIT_FAILURE);
	}

	fscanf(stream, "%lu %lu %lu", &n, &n, &nnz); 

#if	SEE_DATA
	fprintf(stdout, "%lu %lu %lu\n", n, n, nnz);
#endif

	coo = new_coo(n, nnz);


	i = j = 0;
	while(nnz > 0)
	{
		nnz--;

		fscanf(stream, "%lu %lu %lf", &x, &y, &temp_A);
		
		if(x == y)
		{
			coo->d[i++] = temp_A;
#if	SEE_DATA
		fprintf(stdout, "---Diagonal[%lu][%lu]: %f\n", x-1, y-1, temp_A);
#endif
		}
		else
		{
			coo->row_index[j] = x - 1;
			coo->column_index[j] = y - 1;
			coo->A[j++] = temp_A;
#if	SEE_DATA
		fprintf(stdout, "NaoDiagonal[%lu][%lu]: %f\n", x-1, y-1, temp_A);
#endif
		}
	}


	for(i = 0; i < n; i++)
	{
		fscanf(stream, "%lf", &coo->b[i]);
#if	SEE_DATA
		fprintf(stdout, "%f\n", coo->b[i]);
#endif
	}


	fclose(stream);
	
	return coo2csr(coo);
}


CSR* coo2csr(COO* coo)
{
	size_t k;
	size_t j;
	size_t i;
	size_t temp_s;
	double temp_d;
	CSR* csr;


	csr = new_csr(coo->n, coo->nnz);


   	for(k = 0; k < coo->n + 1; k++)
    	csr->row_ptr[k] = 0;

   /* determine row-lengths. */

   for(k = 0; k < coo->nnz; k++)
      csr->row_ptr[coo->row_index[k]] = csr->row_ptr[coo->row_index[k]] + 1;

   /* starting position of each row.. */

   k = 0;
   for(j = 0; j < coo->n + 1; j++)
   {
      temp_s = csr->row_ptr[j];
      csr->row_ptr[j] = k;
      k = k + temp_s;
   }

   /* go through the structure  once more. Fill in output matrix. */

   for(k = 0; k < coo->nnz; k++)
   {
      i = coo->row_index[k];
      j = coo->column_index[k];
      temp_d = coo->A[k];
      temp_s = csr->row_ptr[i];
      csr->A[temp_s] = temp_d;
      csr->column_index[temp_s] = j;
      csr->row_ptr[i] = temp_s + 1;
   }

   /* shift back csr->row_ptr */
   for(j = coo->n - 1;; j--)
   {
      csr->row_ptr[j + 1] = csr->row_ptr[j];
      if(j == 0)
      	break;
   }
	 csr->row_ptr[0] = 0;
	

	csr->d = coo->d;
	csr->b = coo->b;


	freeCOO(coo);
#if	SEE_DATA
	printCSR(csr);
#endif
	return csr;
}


#if	SEE_DATA
static void printCSR(CSR* csr)
{
	size_t i;

	fprintf(stdout, "\n");
	fprintf(stdout, "n: %lu\n", csr->n);
	fprintf(stdout, "nnz: %lu\n", csr->nnz);

	fprintf(stdout, "\nA:\n");
	for(i = 0; i < csr->nnz; i++)
		fprintf(stdout, "%.2f ", csr->A[i]);

	fprintf(stdout, "\nColumn Index:\n");
	for(i = 0; i < csr->nnz; i++)
		fprintf(stdout, "%lu ", csr->column_index[i]);

	fprintf(stdout, "\nRow ptr:\n");
	for(i = 0; i < csr->n + 1; i++)
		fprintf(stdout, "%lu ", csr->row_ptr[i]);

	fprintf(stdout, "\nDiagonal:\n");
	for(i = 0; i < csr->n; i++)
		fprintf(stdout, "%.2f ", csr->d[i]);

	fprintf(stdout, "\nb:\n");
	for(i = 0; i < csr->n; i++)
		fprintf(stdout, "%.2f ", csr->b[i]);

	fprintf(stdout, "\n");

}
#endif

