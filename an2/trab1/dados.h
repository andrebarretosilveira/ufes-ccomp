/**
 * dados.h
 *
 * Definição das estruturas de dados necessárias
 * para formular o problema, armazenando informações
 * relacionadas ao domínio e a discretização.
 *
 */

#include <stdio.h>
#include <stdlib.h>

#ifndef DADOS_H
#define DADOS_H

#define BUFFER 3
#define TRUE 1
#define FALSE 0

#define F(x,y) 0
#define BETAx(x,y) 0
#define BETAy(x,y) 0
#define GAMA(x,y) 0

/*
 * Estrutura dos Dados a serem lidos
 * pelo programa: domínio de x e y e
 * quantidade de partições em x e y.
 */
typedef struct dados
{
    size_t experimento;
	double beginX;
	double endX;
	double beginY;
	double endY;
	int amountX;
	int amountY;
	double omega;
	double tolerancia;
	size_t iterMax;
} Dados;

/**
 * Estrutura de Ponto usado para a
 * discretização do domínio
 */
typedef struct ponto
{
	double x;
	double y;
} Ponto;

Dados* readDados(FILE*);
Ponto* discretizaDominio(Dados*);
double *criaVetorIndependente(Dados*, Ponto*);
double f(double x, double y);
void freeDados(Dados*);

#endif
