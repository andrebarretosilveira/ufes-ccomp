/**
 * dados.c
 *
 * Implementação das funções definidas em
 * dados.h sobre a leitura dos dados
 * necessários para o problema
 */
 
#include <stdio.h>
#include <stdlib.h>
#include "dados.h"

/**
 * Função que lê os dados de entrada por
 * arquivo ou diretamente do terminal
 * @param input Método de entrada:
 *              arquivo ou terminal
 */
Dados* readDados(FILE* input)
{
	Dados *ini = malloc(sizeof(Dados));
	int i, teclado = FALSE;

    if(input == stdin) {
        teclado = TRUE;
        printf("Iniciando programa...\n");
        printf("Favor entrar com as informacoes necessarias a seguir.\n\n");
    }

	// Lendo domínios e quantidade de pontos
    if(teclado) printf("Dominios e quantidade de pontos: \n");
    if(teclado) printf("Intervalo de x: ");
	fscanf(input,"%lf",&ini->beginX);
	fscanf(input,"%lf",&ini->endX);

    if(teclado) printf("Quantidade de pontos em x: ");
	fscanf(input,"%d",&ini->amountX);

    if(teclado) printf("Intervalo de y: ");
	fscanf(input,"%lf",&ini->beginY);
	fscanf(input,"%lf",&ini->endY);

    if(teclado) printf("Quantidade de pontos em y: ");
	fscanf(input,"%d",&ini->amountY);

	/*
	// LENDO QUANTIDADE DE ELEMENTOS DE CONTORNO
    if(teclado) printf("Digite a quantidade de elementos de contorno: ");
	fscanf(input,"%d",&ini->contour);
	ini->elements = calloc((size_t)ini->contour,sizeof(Contour));

	// LENDO INDICES E VALORES DOS CONTORNOS
    if(teclado) printf("Entre com os valores de contorno: [posx posy valor]\n");
	for(i = 0; i < ini->contour;i++) {
		fscanf(input,"%d %d %lf",&(ini->elements[i].x),&(ini->elements[i].y),&(ini->elements[i].value));
    }
	
    ini->Fxy = calloc(BUFFER, sizeof(char));
    if(teclado) printf("\nF(x,y) = \n");
    fscanf(input,"%s", ini->Fxy);

    if(teclado) printf("\nSolucao do sistema:\n");
    */
    
	return ini;
}

/** [freeDados description] */
void freeDados(Dados *in)
{
	free(in->elements);
    free(in->Fxy);
	free(in);
}
