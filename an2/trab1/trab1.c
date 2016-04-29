/**
 * trab1.c
 *
 * Trabalho 1 de Algoritmos Numéricos:
 * Método das Diferencas Finitas Aplicado a Problemas Bidimensionais
 *
 * Aluno: André Barreto Silveira
 *
 */

#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include "matrizPentadiagonal.h"
#include "sistemaLinear.h"
#include "sor.h"
#include "dados.h"

// Flag do experimento
int flagExp;

void printInfo()
{
    fprintf(stderr, "\nSintaxe: ./trab1 [Experimento] [SOR] [Metodo de Entrada] [Arquivo?]\n");
    fprintf(stderr, "Experimentos: 1, 2, 3 ou 4\n");
    fprintf(stderr, "SOR: 'normal' ou 'livre'\n");
    fprintf(stderr, "Metodos de entrada: -t (teclado) , -f [arquivo]\n");
    fprintf(stderr, "Exemplos:\n ./trab1 1 normal -t\n ./trab1 2 livre -f input.txt\n\n");
}

int main(int argc, char **argv)
{
    int N;
    size_t numIter;
    double *x, *vetorIndependente;
    double error, norma;
    FILE* fp;
    char* tipoSOR;
    char* arqvSaida = "solucao.mat";
    MatrizPentadiagonal* matriz;
    SistemaLinear* sistema;
    Dados* input;
    Ponto* vetorPontos;

    // Número mínimo de argumentos: 3
    if(argc < 4) {
        printInfo();
        exit(1);
    }

    // Variável global do experimento
    flagExp = atoi(argv[1]);

    // Tipo do SOR a ser usado
    tipoSOR = argv[2];

    // Verifica se o experimento é válido
    if(flagExp < 1 || flagExp > 4) {
        fprintf(stderr, "\nExperimento '%d' invalido\n", flagExp);
        printInfo();
        exit(1);
    }

    // Verifica se a opção SOR é válida
    if(strcmp(tipoSOR, "normal") != 0 && strcmp(tipoSOR, "livre") != 0) {
        fprintf(stderr, "\nTipo SOR '%s' invalido\n", tipoSOR);
        printInfo();
        exit(1);
    }

    // Leitura iterativa pelo terminal
    if(!strcmp(argv[3], "-t"))
        input = readDados(stdin);

    // Leitura automática por um arquivo
    else if(!strcmp(argv[3], "-f"))
    {
        fp = fopen(argv[4], "r");
        if(fp == NULL) {
            fprintf(stderr, "\nErro ao abrir arquivo \"%s\" para leitura\n", argv[4]);
            printInfo();
            exit(1);
        }
        input = readDados(fp);
        fclose(fp);
    }

    // Opção de entrada incorreta
    else {
        fprintf(stderr, "\nOpcao '%s' de entrada de dados invalida.\n", argv[3]);
        printInfo();
        exit(1);
    }

    // Ordem do sistema
    N = input->qtdX * input->qtdY;

    // Processo de discretização resulta em um vetor de pontos
    vetorPontos = discretizaDominio(input);

    // SOR utilizando matriz esparsa
    if(strcmp(tipoSOR, "normal") == 0) {
        // Criação do sistema linear penta-diagonal
        vetorIndependente = criaVetorIndependente(input, vetorPontos);
        matriz = criaMatrizPentadiagonal(input, vetorPontos);
        sistema = criaSistemaLinear(matriz, vetorIndependente, N);

        // Aplicação das condições de contorno
        aplicaContorno(sistema, input);

        // Aplicação do SOR
        x = sor(sistema, input->omega, input->tolerancia, input->iterMax, &numIter, &error, &norma);

        // Liberar memória alocada pelo sistema
        freeSistemaLinear(sistema);
    }

    // Aplicação do algortimo SOR livre de matriz
    else
        x = sorLivre(input, vetorPontos, input->omega, input->tolerancia, input->iterMax, &numIter, &error, &norma);

    // Imprimindo relatório do programa
    printf("\n");

    if(flagExp == 1)
        printf("Validacao 1 - Solucao trivial\n");
    else if (flagExp == 2)
        printf("Validacao 2 - Solucao conhecida\n");
    else if (flagExp == 3)
        printf("Aplicacao Fisica 1 - Resfriador bidimensional\n");
    else if (flagExp == 4)
        printf("Aplicacao Fisica 2 - Escoamento em Aguas Subterraneas\n");

    printf("\nSOR \"%s\"\n", tipoSOR);
	printf("Numero de iteracoes : %lu\n", numIter);
    printf("Norma da solucao    : %lf\n", norma);
    printf("Erro                : %lf\n", error);

    // Imprimindo solução em formato .mat para leitura em octave
    fp = fopen(arqvSaida, "w");
    if(fp == NULL) {
        fprintf(stderr, "Erro ao abrir arquivo \"%s\" para escrita\n\n", arqvSaida);
        printf("Imprimindo solucao na saida padrao\n");
        printVetorSolucao(stdout, x, N, input->qtdX, input->qtdY);
        printf("\n\n");
    }
    else {
        printVetorSolucao(fp, x, N, input->qtdX, input->qtdY);
        printf("\nArquivo \"%s\" gerado.\n\n", arqvSaida);
    }

    fclose(fp);

    // Liberar memória
    free(x);
    free(vetorPontos);
    freeDados(input);

    return 0;
}
