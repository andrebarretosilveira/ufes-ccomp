/**
 * Solução de Problemas de Valor no Contorno Bidimensionais
 * @last_update 20-11-15
 * @Author André Barreto e Igor Ventorim
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "io.h"
#include "contorno.h"
#include "sor.h"
#include "csr.h"
#include "sparse.h"
#include "gauss.h"

void printInfo()
{
    printf("Sintaxe: ./trab2 [Algoritmo] [Metodo de Entrada] [Arquivo?] [Omega?] [Tolerancia?]\n");
    printf("Algoritmos: sor / gauss\n");
    printf("Metodos de entrada: -t (teclado) / -f [arquivo]\n");
    printf("Exemplos:\n ./trab2 gauss -t\n ./trab2 sor -f input.txt 0.1 0.004\n");
}

int main(int argc, char **argv)
{
    int teclado = 1;
	Data *input;
	Points *lPoints;
    FILE *fp = NULL;
	double a,b,c,**matrix,*vetorIndependent;

    if(argc < 3) {
        printInfo();
        exit(1);
    }

    if(!strcmp(argv[2], "-t"))
        input = readData(stdin, &a, &b, &c);

    else if(!strcmp(argv[2], "-f"))
    {
        teclado = 0;
        fp = fopen(argv[3], "r");
        if(fp == NULL) {
            printf("Erro ao abrir arquivo \"%s\" para leitura\n", argv[3]);
            printInfo();
            exit(1);
        }
        input = readData(fp, &a, &b, &c);
        fclose(fp);
    }
    else {
        printf("Opcao de entrada de dados incorreta.\n\n");
        printInfo();
        exit(1);
    }

	lPoints = createLPoints(input->amountX, input->amountY);
	discretiza(lPoints,input);
	matrix = createMatrix(input,a, b, c);
	vetorIndependent = createVIndependent(lPoints,input);
	insertContourn(matrix, vetorIndependent, input);
	writeMatrix(matrix, vetorIndependent,input);

    if(!strcmp(argv[1], "gauss"))
    {
        /* MÉTODO DE GAUSS */
        Sparse *sparse = NULL;

        sparse = getSparse("saida.txt");
        elimGauss(sparse);
        printf("Algoritmo: Gauss\n\n");
        printb(sparse);
        freeSparse(sparse);
    } else if(!strcmp(argv[1], "sor"))
    {
        /* MÉTODO SOR */
        CSR* csr = NULL;
        double *x, omega = 1, tol = 0.001;
        size_t i;
        const size_t MAXITER = 100000;

        printf("Algoritmo: SOR\n\n");
        if(argc < 6)
        {
            printf("Parametros do SOR nao encontrados.\n");
            printf("Assumindo:\n");
            printf(" omega = %lf\n tolerancia = %lf\n\n", omega, tol);
        }
        else
        {
            if(teclado) {
                omega = atof(argv[3]);
                tol = atof(argv[4]);
            }
            else {
                omega = atof(argv[4]);
                tol = atof(argv[5]);
            }
            printf("omega = %.2lf\ntolerancia = %.3lf\n\n", omega, tol);
        }

        csr = get_csr("saida.txt");
        x = sor(csr,omega,tol,MAXITER);

        for(i = 0; i < csr->n; i++)
            printf("%lf\n",x[i]);

        freeCSR(csr);
        free(x);
    }
    else {
        printf("Metodo \"%s\" inexistente\n\n", argv[1]);
        printInfo();
    }

	free(lPoints);
	freeMatrix(matrix,input);
	freeData(input);
	free(vetorIndependent);

	return 0;
}
