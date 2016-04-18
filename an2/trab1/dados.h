/**
 * dados.h
 *
 * Definição da estrutura da Matriz Pentadiagonal
 * e suas funções básicas.
 *
 */
 
#ifndef DADOS_H
#define DADOS_H

#define BUFFER 300
#define TRUE 1
#define FALSE 0

typedef struct dados Dados;
typedef struct contorno Contorno;

/*
 * Estrutura dos Dados a serem lidos
 * pelo programa: domínio de x e y,
 * quantidade de partições em x e y.
 */
struct dados
{
	double beginX;
	double endX;
	double beginY;
	double endY;
	int amountX;
	int amountY;
	//int contour;
    //char* Fxy;
	//Contour *elements;
};

struct contorno
{
	int x;
	int y;
	double value;
};

Data* readData(FILE*, double *a, double *b, double *c);
//void writeMatrix(double **matrix, double *vetIndependent,Data *input);
void freeData(Data *in);

#endif
