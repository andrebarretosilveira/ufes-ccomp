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

void printInfo()
{
    fprintf(stderr, "\nSintaxe: ./trab1 [Metodo de Entrada] [Arquivo?]\n");
    fprintf(stderr, "Metodos de entrada: -t (teclado) / -f [arquivo]\n");
    fprintf(stderr, "Exemplos:\n ./trab1 -t\n ./trab1 -f input.txt\n\n");
}

int main(int argc, char **argv)
{
    size_t N;
    double* vetorIndependente;
    double* x;
    FILE* fp;
    MatrizPentadiagonal* matriz;
    SistemaLinear* sistema;
    Dados* input;
    Ponto* vetorPontos;

    // Número mínimo de argumentos: 1
    if(argc < 2) {
        printInfo();
        exit(1);
    }

    // Leitura iterativa pelo terminal
    if(!strcmp(argv[1], "-t"))
        input = readDados(stdin);

    // Leitura automática por um arquivo
    else if(!strcmp(argv[1], "-f"))
    {
        fp = fopen(argv[2], "r");
        if(fp == NULL) {
            fprintf(stderr, "Erro ao abrir arquivo \"%s\" para leitura\n", argv[2]);
            printInfo();
            exit(1);
        }
        input = readDados(fp);
        fclose(fp);
    }
    else {
        fprintf(stderr, "Opcao de entrada de dados incorreta.\n\n");
        printInfo();
        exit(1);
    }

    // Ordem do sistema
    N = input->amountX * input->amountY;

    // Processo de discretização do domínio e criação do sistema
    vetorPontos = discretizaDominio(input);
    vetorIndependente = criaVetorIndependente(input, vetorPontos);
    matriz = criaMatrizPenta(input);
    sistema = criaSistemaLinear(matriz, vetorIndependente, N);
    aplicaContorno(sistema, input);
    printSistemaLinear(sistema);

    // Aplicação do algoritmo SOR
    x = sor(sistema, input->omega, input->tolerancia, input->iterMax);

    // Liberar memória
    free(x);
    free(vetorPontos);
    freeSistemaLinear(sistema);
    freeDados(input);

    return 0;
}
