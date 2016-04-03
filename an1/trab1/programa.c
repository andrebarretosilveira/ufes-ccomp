#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "csr.h"
#include "sor.h"
#include "gauss.h"
#include "sparse.h"
#include "gambiarra.c"

#define MAXITER 100000

int main(int argc, char** argv)
{
	/* MÉTODO DE GAUSS */
	if(argc == 3 && !strcmp(argv[1], "gauss"))
	{
		Sparse *sparse = NULL;

	    sparse = getSparse(argv[2]);
	    elimGauss(sparse);
	    // printSparse(sparse);
	    // printf("\n");
	    printb(sparse);
	    freeSparse(sparse);
	}

	/* MÉTODO SOR */
	else if(argc == 5 && !strcmp(argv[1], "sor"))
	{
		CSR* teste = NULL;
		double *x, omega, tol, **m = NULL, *b = NULL; //,*x2;,**matrix,*b;
		size_t i;
		omega = atof(argv[3]);
		tol = atof(argv[2]);

		lerMatriz(argv[4], m, b);
		teste = get_csr(argv[4]); //FEM_3D_thermal1.txt
		//printf("\n%p\n",teste);
		x = sor(teste,omega,tol,MAXITER);


		for( i = 0; i < teste->n; i++)
			printf("%g\n",x[i]);

		freeCSR(teste);
		free(x);

		/*sor(get_coo(argv[4]), atof(argv[2]), atof(argv[3]));*/
	}

	else
	{
		fprintf(stdout, "Usage: %s gauss [nome do arquivo da matrix]\nUsage: %s sor [tolerancia] [fator de relaxacao] [nome do arquivo da matrix]\n", argv[0], argv[0]);
	}

	return 0;
}
