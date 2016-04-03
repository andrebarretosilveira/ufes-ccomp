/*
 * Alunos: Vinicius Arruda, Igor Ventorim, André Barreto.
 * Curso: Ciência da Computação
 * E-mail: viniciusferracoarruda@gmail.com, EMAIL HERE
 * Disciplina: Algoritmos Numérios I
 * Professor: Leonardo Muniz
 * Data: 04 de outubro de 2015
 */


#ifndef CSR_H   
#define CSR_H   


typedef struct 
{
	size_t n;        /* sempre quadrada ?  */
	size_t nnz;    /* precisa de todos esses campos ? */
	size_t* column_index;
	size_t* row_index;
	double* A;
	double* d;
	double* b;
} COO;

/* ver alinhamento de memoria. MUDAR ORDEM #PRAGMA por enquanto na minha maquina esta em 48 bytes */
typedef struct 
{
	size_t n;        /* sempre quadrada ?  */
	size_t nnz;    /* precisa de todos esses campos ? */
	size_t* column_index;
	size_t* row_ptr;  /* WARNING !!! from 0 to n + 1 .. intervalo: [0, n+1)   */
	double* A;
	double* d;
	double* b;
} CSR;



CSR* get_csr(const char* file_name);
CSR* new_csr(size_t n, size_t nnz);
CSR* coo2csr(COO* coo);
void freeCSR(CSR* csr);

#endif
