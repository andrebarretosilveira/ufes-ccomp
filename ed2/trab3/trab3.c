/**
 * TRABALHO 3 - ED2 - ESCALONAMENTO DE JOBS
 * André Barreto e Igor Ventorim
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "bs.h"
#include "bb.h"

#define W 30

int main(int argc, char **argv)
{
    int n;
    Job **jobs;
    Path *menorCaminhoBS;
    Path *menorCaminhoBB;

    /* Verifica o número de parâmetros */
    if(argc != 3)
    {
        printf("Sintaxe:\n./trab3 [númeroJobs] [algoritmo]\n");
        exit(1);
    }

    n = atoi(argv[1]);
    jobs = malloc(n*sizeof(Job*));
    lerJobs(jobs, n);

    /* Algoritmo Beam Search */
    if(strcmp(argv[2], "bs") == 0)
    {
        menorCaminhoBS = beamSearch(jobs, n, W);
        printPath(menorCaminhoBS);
        freePath(menorCaminhoBS);
    }

    /* Algoritmo Branch and Bound */
    else if(strcmp(argv[2], "bb") == 0)
    {
        menorCaminhoBB = branchBound(jobs, n, W);
        printPath(menorCaminhoBB);
        freePath(menorCaminhoBB);
    }

    /* ERRO: Algoritmo incorreto */
    else
    {
        printf("Algoritmo \"%s\" incorreto. Opcoes: \"bs\" e \"bb\"\n", argv[2]);
    }

    freeJobs(jobs, n);

    return 0;
}
