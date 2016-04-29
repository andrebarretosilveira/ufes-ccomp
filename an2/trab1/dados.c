/**
 * dados.c
 *
 * Implementação das funções definidas em
 * dados.h sobre a leitura e manipulação
 * dos dados necessários para o problema
 */

#include "dados.h"

/**
 * Função que lê os dados de entrada por arquivo ou diretamente do terminal
 * @param input Método de entrada: arquivo ou terminal
 */
Dados* readDados(FILE* input)
{
	Dados* dados;
	int teclado = FALSE;

    if(input == stdin) {
        teclado = TRUE;
        printf("Iniciando programa...\n");
        printf("Favor entrar com as informacoes necessarias a seguir.\n\n");
    }

	dados = malloc(sizeof(Dados));

	// Lendo domínios e quantidade de pontos
    if(teclado) printf("Dominios e quantidade de pontos: \n");
    if(teclado) printf("Intervalo de x: ");
	fscanf(input,"%lf",&dados->inicioX);
	fscanf(input,"%lf",&dados->fimX);

    if(teclado) printf("Quantidade de pontos em x: ");
	fscanf(input,"%d",&dados->qtdX);

    if(teclado) printf("Intervalo de y: ");
	fscanf(input,"%lf",&dados->inicioY);
	fscanf(input,"%lf",&dados->fimY);

    if(teclado) printf("Quantidade de pontos em y: ");
	fscanf(input,"%d",&dados->qtdY);

	if(teclado) printf("\nAlgoritmo SOR:\n");
	if(teclado) printf("Fator de relaxacao omega: ");
	fscanf(input,"%lf",&dados->omega);
	if(teclado) printf("Tolerancia: ");
	fscanf(input,"%lf",&dados->tolerancia);
	if(teclado) printf("Num. máximo de iteracoes: ");
	fscanf(input,"%zu",&dados->iterMax);

    if(teclado) printf("\nLeitura finalizada\n\n");

	return dados;
}

/**
 * Libera espaço de memória utilizado pela
 * estrutura de dados de entrada
 * @param dados Espaço de memória a ser liberado
 */
void freeDados(Dados* dados)
{
	free(dados);
}
