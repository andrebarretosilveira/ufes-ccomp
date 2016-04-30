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

#define T0 5.1122
#define EULER 2.718281
#define Rw -250
#define Pref 100

/*
 * Estrutura dos Dados a serem lidos
 * pelo programa: domínio de x e y e
 * quantidade de partições em x e y.
 */
typedef struct dados
{
	double inicioX;
	double fimX;
	double inicioY;
	double fimY;
	int qtdX;
	int qtdY;
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
void freeDados(Dados*);

#endif
