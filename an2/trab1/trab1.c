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
    fprintf(stderr, "\nSintaxe: ./trab1 [Experimento] [Metodo de Entrada] [Arquivo?]\n");
    fprintf(stderr, "Experimentos: 1, 2, 3 ou 4\n");
    fprintf(stderr, "Metodos de entrada: -t (teclado) , -f [arquivo]\n");
    fprintf(stderr, "Exemplos:\n ./trab1 1 -t\n ./trab1 2 -f input.txt\n\n");
}

int main(int argc, char **argv)
{
    size_t i, N;
    double* vetorIndependente;
    double* x;
    FILE* fp;
    MatrizPentadiagonal* matriz;
    SistemaLinear* sistema;
    Dados* input;
    Ponto* vetorPontos;

    // Número mínimo de argumentos: 2
    if(argc < 3) {
        printInfo();
        exit(1);
    }

    // Variável global do experimento
    flagExp = atoi(argv[1]);

    // Leitura iterativa pelo terminal
    if(!strcmp(argv[2], "-t"))
        input = readDados(stdin);

    // Leitura automática por um arquivo
    else if(!strcmp(argv[2], "-f"))
    {
        fp = fopen(argv[3], "r");
        if(fp == NULL) {
            fprintf(stderr, "\nErro ao abrir arquivo \"%s\" para leitura\n", argv[3]);
            printInfo();
            exit(1);
        }
        input = readDados(fp);
        fclose(fp);
    }

    // Opção de entrada incorreta
    else {
        fprintf(stderr, "\nOpcao '%s' de entrada de dados invalida.\n", argv[2]);
        printInfo();
        exit(1);
    }

    // Verifica se o experimento é válido
    if(flagExp < 1 || flagExp > 4) {
        fprintf(stderr, "\nExperimento '%d' invalido\n", flagExp);
        printInfo();
        exit(1);
    }

    /*
    printf("\nExperimento: ");

    if(flagExp == 1)
        printf("Validação 1 - Solução trivial");
    else if (flagExp == 2)
        printf("Validação 2 - Solução conhecida");
    else if (flagExp == 3)
        printf("Aplicação Física 1 - Resfriador bidimensional");
    else if (flagExp == 4)
        printf("Aplicação Física 2 - Escoamento em Águas Subterrâneas");

    printf("\nCalculando ...");
    */

    // Ordem do sistema
    N = input->amountX * input->amountY;

    // Processo de discretização do domínio e criação do sistema
    vetorPontos = discretizaDominio(input);
    vetorIndependente = criaVetorIndependente(input, vetorPontos);
    matriz = criaMatrizPentadiagonal(input, vetorPontos);
    sistema = criaSistemaLinear(matriz, vetorIndependente, N);

    // Aplicação das condições de contorno
    aplicaContorno(sistema, input);
    
    //printSistemaLinear(sistema);

    // Aplicação do algoritmo SOR
    x = sor(sistema, input->omega, input->tolerancia, input->iterMax);
    //x = sorLivre(input, input->omega, input->tolerancia, input->iterMax);

    printf("\n");
    for(i=0; i < N; i++) {
        printf("%.4lf ", x[i]);
        if((i+1) % input->amountX == 0)
            printf("\n");
    }
    printf("\n\n");

    // Liberar memória
    free(x);
    free(vetorPontos);
    freeSistemaLinear(sistema);
    freeDados(input);

    return 0;
}
