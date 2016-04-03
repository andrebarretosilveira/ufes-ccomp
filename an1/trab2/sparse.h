
#ifndef SPARSE_H                 
#define SPARSE_H


typedef struct list
{
	double value;
	size_t row;
	struct list* next;
} List;

typedef struct
{
	size_t n;
	double* diagonal;
	double* b;
	List** matrix;
} Sparse;


Sparse* getSparse(const char* fileName);
void freeSparse(Sparse* sparse);
void set(Sparse* sparse, size_t i, size_t j, double value);
double get(Sparse* sparse, size_t i, size_t j);
void printSparse(Sparse *);
void printb(Sparse *sparse);


#endif
