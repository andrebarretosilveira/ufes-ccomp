#include <stdio.h>
#include <stdlib.h>
#include "sparse.h"


#define get_memory(ptr, size) ((ptr) = malloc(size));if((ptr) == NULL){fprintf(stderr, "Out of memory.\n");exit(EXIT_FAILURE);}


static void freeList(List** l);
static List* createNode(double value, size_t row);
static void insert(List** l, double value, size_t row);


Sparse* getSparse(const char* fileName)
{
	FILE* stream;
	Sparse* sparse;
	size_t n;
	size_t nnz;
	size_t i;
	size_t j;
	double temp_A;

	stream = fopen(fileName, "r");

	if(stream == NULL)
	{
		fprintf(stderr, "Error while opening file %s.\n", fileName);
		exit(EXIT_FAILURE);
	}

	fscanf(stream, "%lu %lu %lu", &n, &n, &nnz);

	get_memory(sparse, sizeof(Sparse));

	sparse->n = n;

	get_memory(sparse->diagonal, n * sizeof(double));
	get_memory(sparse->b, n * sizeof(double));
	get_memory(sparse->matrix, n * sizeof(List *));


	for(i = 0; i < n; i++)
	{
		sparse->matrix[i] = NULL;  /* warning: change this to memset zeros can produce errors. NULL is not always zero. */
	}


	while(nnz > 0)
	{
		fscanf(stream, "%lu %lu %lf", &i, &j, &temp_A);

		i--; /* Corrige o indice. */
		j--; /* Corrige o indice. */

		if(i == j)
			sparse->diagonal[j] = temp_A;
		else
			insert(&sparse->matrix[j], temp_A, i);

		nnz--;
	}

	for(i = 0; i < n; i++)
	{
		fscanf(stream, "%lf", &sparse->b[i]);
	}


	fclose(stream);

	return sparse;
}


void freeSparse(Sparse* sparse)
{
	size_t i;

	free(sparse->diagonal);
	free(sparse->b);

	for(i = 0; i < sparse->n; i++)
	{
		freeList(&sparse->matrix[i]);
	}

	free(sparse->matrix);
	free(sparse);
}


static void freeList(List** l)
{
	List* temp;

	while(*l != NULL)
	{
		temp = (*l)->next;
		free(*l);
		*l = temp;
	}
}


static List* createNode(double value, size_t row)
{
	List* new;

	get_memory(new, sizeof(List));

	new->value = value;
	new->row = row;
	new->next = NULL;

	return new;
}


static void insert(List** l, double value, size_t row)
{
	List* new = createNode(value, row);

	new->next = *l;                                          /* O nó recentemente, tem como próximo o primeiro elemento da lista *l, */
	*l = new;                                                /* Se a lista *l for vazia (NULL), então aponta para NULL. */
}                                                            /* Atualiza o ponteiro *l para o primeiro elemento da lista. */


void set(Sparse* sparse, size_t i, size_t j, double value)
{
	List* column;

	if(i == j)
	{
		sparse->diagonal[j] = value;
		return;
	}
	else
	{
		column = sparse->matrix[j];
		while(column != NULL)
		{
			if(column->row == i)
			{
				column->value = value;  /* da pra melhorar, fazendo a operação de adiçãoe subtração direto aqui com += */
				return;
			}

			column = column->next;
		}

		if(column == NULL)
		{
			insert(&sparse->matrix[j], value, i);
		}
	}
}


double get(Sparse* sparse, size_t i, size_t j)
{
	List* column;

	if(i == j)
	{
		return sparse->diagonal[j];
	}
	else
	{
		column = sparse->matrix[j];
		while(column != NULL)
		{
			if(column->row == i)
			{
				return column->value;
			}
			column = column->next;
		}
	}

	return 0.0;
}

void printSparse(Sparse *sparse)
{
    size_t i, j;

    for(i = 0; i < sparse->n; i++) {
        for(j = 0; j< sparse->n; j++)
            printf("%.2f ", get(sparse, i, j));
        printf("\n");
    }
}

void printb(Sparse *sparse)
{
    size_t i;

    for(i = 0; i < sparse->n; i++)
        printf("%.2f\n", sparse->b[i]);

}
