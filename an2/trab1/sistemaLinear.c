/**
 * sistemaLinear.c
 *
 * Implementação das funções definidas no
 * cabeçalho sistemaLinear.h
 *
 */

#include "sistemaLinear.h"

SistemaLinear* criaSistemaLinear(MatrizPentadiagonal* matriz, double* f, const size_t N)
{
    SistemaLinear* sistema;
    sistema = malloc(sizeof(SistemaLinear));
    sistema->matriz = matriz;
    sistema->f = f;
    sistema->N = N;
    return sistema;
}

/**
 * Função que aplica as condições de contorno no sistema linear
 * modificando a Matriz Pentadiagonal e o vetor independente
 * @param sistema           Sistema Linear do problema
 * @param input             [description]
 */
void aplicaContorno(SistemaLinear* sistema, Dados *input)
{
	int i,j, qtdElementos;
	int index;
	qtdElementos = (input->amountX * input->amountY);

    /*
	for( j = 0; j < input->contour;j++)
	{
		index = indiceDiscreto(input->elements[j].x,input->elements[j].y,input->amountX);
		sistema->f[index] = input->elements[j].value;
		for(i = 0; i < qtdElementos ; i++)
		{
			if(i == index)
				matrix[index][i] = 1;
            else
				matrix[index][i] = 0;
		}
	}
    */
}

/**
 * Transforma ij em indice I discreto
 * @param  i       Indice i do elemento
 * @param  j       Indice j do elemento
 * @param  amountX Número de pontos em x
 * @return         Indice I
 */
int indiceDiscreto(int i, int j, int amountX)
{
	return i + ((j-1) * amountX) - 1 ;
}

void printSistemaLinear(SistemaLinear* sistema)
{
    size_t i;
    printMatrizPenta(sistema->matriz);
    printf("\n");
    for(i=0; i < sistema->N; i++) {
        printf("%g ", sistema->f[i]);
    }

    printf("\n");
}

void freeSistemaLinear(SistemaLinear* sistema)
{
    freeMatrizPenta(sistema->matriz);
    free(sistema->f);
    free(sistema);
}
