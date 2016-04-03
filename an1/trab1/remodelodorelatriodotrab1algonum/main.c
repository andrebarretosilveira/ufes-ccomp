#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "csr.h"

/*
static void gauss(CSR* csr);
static void sor(CSR* csr, double tolerancia, double relaxamento);
*/

int main(int argc, char** argv)
{
	if(argc == 3)
	{
		if(strcmp(argv[1], "gauss"))
		{
			fprintf(stdout, "Usage: %s gauss [nome do arquivo da matrix]\nUsage: %s sor [tolerancia] [fator de relaxacao] [nome do arquivo da matrix]\n", argv[0], argv[0]);
			return 0;
		}

		freeCSR(get_csr(argv[2]));
		/*gauss(get_coo(argv[2]));*/
	}
	else if(argc == 5)
	{
		if(strcmp(argv[1], "sor"))
		{
			fprintf(stdout, "Usage: %s gauss [nome do arquivo da matrix]\nUsage: %s sor [tolerancia] [fator de relaxacao] [nome do arquivo da matrix]\n", argv[0], argv[0]);
			return 0;
		}

		/*sor(get_coo(argv[4]), atof(argv[2]), atof(argv[3]));*/
	}
	else
	{
		fprintf(stdout, "Usage: %s gauss [nome do arquivo da matrix]\nUsage: %s sor [tolerancia] [fator de relaxacao] [nome do arquivo da matrix]\n", argv[0], argv[0]);
		return 0;
	}


	return 0;
}

/*
static void gauss(CSR* csr)
{



}


static void sor(CSR* csr, double tolerancia, double relaxamento)
{



}
*/

