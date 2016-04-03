#include <stdio.h>
#include <stdlib.h>
#include "io.h"

/**
 * [readData Lendo dados de entrada]
 * @param a   [Constante da equação]
 * @param b   [Constante da equação]
 * @param c   [Constante da equação]
 */
Data* readData(FILE* input, double *a, double *b, double *c)
{
	Data *ini = malloc(sizeof(Data));
	int i, teclado = FALSE;

    if(input == stdin) {
        teclado = TRUE;
        printf("Iniciando programa...\n");
        printf("Favor entrar com as informacoes necessarias a seguir.\n\n");
    }

	/*LENDO CONSTANTES*/
    if(teclado) printf("Insira as constantes: \n");
    if(teclado) printf("a = ");
	fscanf(input,"%lf",a);

    if(teclado) printf("b = ");
	fscanf(input,"%lf",b);

    if(teclado) printf("c = ");
	fscanf(input,"%lf",c);

	/*LENDO DOMINIOS E QUANTIDADE DE PONTOS*/
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

	/*LENDO QUANTIDADE DE ELEMENTOS DE CONTORNO*/
    if(teclado) printf("Digite a quantidade de elementos de contorno: ");
	fscanf(input,"%d",&ini->contour);
	ini->elements = calloc((size_t)ini->contour,sizeof(Contour));

	/*LENDO INDICES E VALORES DOS CONTORNOS*/
    if(teclado) printf("Entre com os valores de contorno: [posx posy valor]\n");
	for(i = 0; i < ini->contour;i++) {
		fscanf(input,"%d %d %lf",&(ini->elements[i].x),&(ini->elements[i].y),&(ini->elements[i].value));
    }
	
    ini->Fxy = calloc(BUFFER, sizeof(char));
    if(teclado) printf("\nF(x,y) = \n");
    fscanf(input,"%s", ini->Fxy);

    if(teclado) printf("\nSolucao do sistema:\n");
	return ini;
}

/**
 * [writeMatrix Escrevendo sistema no modo CSR]
 * @param matrix         [Matriz a ser escrita]
 * @param vetIndependent [Vetor independente]
 * @param input          [Dados de entrada]
 */
void writeMatrix(double **matrix, double *vetIndependent,Data *input)
{
	int i,j,count = 0,sizeMatrix;
	sizeMatrix = (input->amountX * input->amountY);
	FILE *new = fopen("saida.txt","w");

	for(i = 0; i < sizeMatrix;i++)
		for(j = 0; j < sizeMatrix; j++)
			if(matrix[i][j] != 0)	
				count++;

	fprintf(new,"%d %d %d\n",sizeMatrix,sizeMatrix,count);

	for(i = 0; i < sizeMatrix;i++)
		for(j = 0; j < sizeMatrix; j++)
		{
			if(matrix[i][j] != 0)
			{
				fprintf(new,"%d %d %lf\n",i+1,j+1,matrix[i][j]);
				count++;
			}
		}

	for(j = 0; j < sizeMatrix; j++)
        fprintf(new,"%lf\n",vetIndependent[j]);

	fclose(new);

}

/** [freeData description] */
void freeData(Data *in)
{
	free(in->elements);
    free(in->Fxy);
	free(in);
}
