#include <stdio.h>
#include <stdlib.h>
#include <sys/time.h>
#include "./CommonFiles/protos.h"
#include "gmres.h"
#include "matvec-utils.h"

#define P    0         // Parâmetro de ILU(P)
#define TOL  0.000001  // Tolerância do GMRES
#define LMAX 1000      // Num. máximo de iterações do GMRES

double get_time ()
{
	struct timeval tv; gettimeofday(&tv, 0);
	return (double)(tv.tv_sec * 100.0 + tv.tv_usec / 10000.0);
}

int main (int argc, char* argv[])
{
	double time;
    int i, j, n;
    int Kmax, usar_rcm, usar_lu;
    FILE* fp;

	if (argc != 5)
	{
        printf("\n Erro! Sintaxe incorreta.");
		printf("\n Modo de usar: ./trab2 <arquivo_da_matriz> <Kmax> <usarRCM?> <usarLU?>\n\n");
		return 0;
	}

	MAT *A = (MAT*) malloc (sizeof(MAT));
	MATRIX_readCSR (A,argv[1]);
    Kmax = atoi(argv[2]);
    usar_rcm = atoi(argv[3]);
    usar_lu = atoi(argv[4]);
    n = A->n;

	/*---------------------------------------------*/
	/*-- CALCULO DO VETOR INDEPENDENTE b ----------*/
	/*---------------------------------------------*/
    double* b = createVector(n);
    for(i=0; i < n; i++) {
        // Calculo de b até n-1
        for(j=A->IA[i]; j < A->IA[i+1]; j++)
        {
            b[i] += A->AA[j];
        }
    }

	/*---------------------------------------------*/
	/*-- REORDENAMENTO RCM ------------------------*/
	/*---------------------------------------------*/
    int* p;			// Vetor de permutação
    int  bandwidth;
    double* b_permutado;

    if(usar_rcm) {
        bandwidth = (int) MATRIX_bandwidth(A);	// Calcula Largura de Banda da matriz original
        printf("\n  [ REORDENANDO com RCM ]\n");
        printf("  - Largura de Banda inicial : %d\n", bandwidth);

        time = get_time();					/* --- START TIME */
        REORDERING_RCM_opt(A,&p);			// Aplica o reordenamento RCM na matriz A
        MATRIX_permutation(A,p); 			// Aplica a permutação em A para trocar linhas e colunas
        time = (get_time() - time)/100.0;	/* --- END TIME   */

        bandwidth = (int) MATRIX_bandwidth(A);	// Calcula Largura de Banda da matriz reordenada
        printf("  - Largura de Banda final   : %d\n", bandwidth);
        printf("  - Tempo total              : %.6f sec\n", time);

        // Permutando o vetor b
        b_permutado = createVector(n);
        for (i = 0; i < n; ++i)
            b_permutado[i] = b[p[i]];

        free(b);
    }
    else {
        b_permutado = b;
    }

	/*---------------------------------------------*/
	/*-- ALGORITMO ILUP ---------------------------*/
	/*---------------------------------------------*/
    MAT *L, *U;

    if(usar_lu) {
        L = (MAT*) malloc(sizeof(MAT)); // Alocando matriz L
        U = (MAT*) malloc(sizeof(MAT)); // Alocando matriz U

        // Alocando estruturas para o ILU(p)
        SparMAT* mat = (SparMAT*) malloc(sizeof(SparMAT));
        SparILU* lu  = (SparILU*) malloc(sizeof(SparILU));

        printf("\n  [ CALCULANDO PRECONDICIONADOR ILU ]\n");
        time = get_time();                  /* --- START TIME */
        //
        CSRto_SPARMAT (A,mat);				// Convertendo CSR para estrutura especial
        ILUP (mat,lu,P);					// Algoritmo ILU(p)
        SPARILU_toCSR (lu,L,U);				// Convertendo estrutura especial para CSR
        //
        time = (get_time() - time)/100.0;   /* --- END TIME   */
        printf("  - Tempo total              : %.6f sec\n", time);

        SPARILU_clean (lu);					// Liberando memória da estrutura lu
        SPARMAT_clean (mat);				// Liberando memória da estrutura mat

        /* L contém a parte estritamente inferior de M / L->D contém a diagonal = 1.0 */
        /* U contém a parte estritamente superior de M / U->D contém a diagonal       */
        //MATRIX_printLU (A,L,U);
    }

	/*---------------------------------------------*/
	/*-- SOLUÇÃO DO SISTEMA POR GMRES -------------*/
	/*---------------------------------------------*/
	printf("\n  [ RESOLVENDO O SISTEMA POR GMRES ]\n");
    time = get_time();                  /* --- START TIME */
    //
    double* x = createVector(n);
    if(usar_lu)
        gmres_precond(A, L, U, x, b_permutado, TOL, Kmax, LMAX);
    else
        gmres(A, x, b_permutado, TOL, Kmax, LMAX);


    double* x_permutado;
    if(usar_rcm) {
        // Permutando a solução
        x_permutado = createVector(n);
        for (i = 0; i < n; ++i)
            x_permutado[i] = x[p[i]];

        free(x);
    }
    else {
        x_permutado = x;
    }
    //
    time = (get_time() - time)/100.0;   /* --- END TIME   */
	printf("  - Tempo total              : %.6f sec\n", time);

    // Imprimindo a solução
    fp = fopen("saida.txt", "w");
    for (i = 0; i < n; ++i)
        fprintf(fp,"%.8lf\n", x_permutado[i]);

    fprintf(fp, "\n");
    fclose(fp);

    printf("\n  Solucao escrita no arquivo 'saida.txt'\n\n");

	/*---------------------------------------------*/
	/*-- LIBERAR MEMORIA --------------------------*/
	/*---------------------------------------------*/
    if(usar_rcm) {
        free(p);
        free(b_permutado);
        free(x_permutado);
    }
    else {
        free(b);
        free(x);
    }

    if(usar_lu) {
        MATRIX_clean(L);
        MATRIX_clean(U);
    }

	MATRIX_clean(A);

	return 0;
}
