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

	// Lendo experimento a ser aplicado
    if(teclado) printf("Digite o experimento: \n");
	fscanf(input, "%d", &dados->experimento);

	// Lendo domínios e quantidade de pontos
    if(teclado) printf("Dominios e quantidade de pontos: \n");
    if(teclado) printf("Intervalo de x: ");
	fscanf(input,"%lf",&dados->beginX);
	fscanf(input,"%lf",&dados->endX);

    if(teclado) printf("Quantidade de pontos em x: ");
	fscanf(input,"%d",&dados->amountX);

    if(teclado) printf("Intervalo de y: ");
	fscanf(input,"%lf",&dados->beginY);
	fscanf(input,"%lf",&dados->endY);

    if(teclado) printf("Quantidade de pontos em y: ");
	fscanf(input,"%d",&dados->amountY);

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
 * Função que discretiza o domínio, criando um vetor de pontos
 * correspondentes à discretização
 * @param  dados Estrutura dos dados de entrada
 * @return       Vetor de pontos
 */
Ponto* discretizaDominio(Dados* dados)
{
	int i, j, n, m, pos;
	double hx, hy;
	Ponto *vetorPontos;

    n = dados->amountX;
    m = dados->amountY;
	hx = (dados->endX - dados->beginX)/((double)n-1);
	hy = (dados->endY - dados->beginY)/((double)m-1);

	vetorPontos = calloc((size_t)(n*m),sizeof(Ponto));

	pos = 0;
	for(i = 1; i <= dados->amountX; i++)
		for(j = 1; j <= dados->amountY; j++)
		{
			vetorPontos[pos].x = dados->beginX + (double)(j - 1)*(hx);
			vetorPontos[pos].y = dados->beginY + (double)(i - 1)*(hy);
			pos++;
		}

    return vetorPontos;
}

/**
 * Função que gera o vetor independente do sistema
 * @param  vetorPontos Vetor com todos os pontos discretizados
 * @param  dados       Estrutura de dados de entrada
 * @return             Vetor independente do sistema
 */
double *criaVetorIndependente(Dados* dados, Ponto* vetorPontos)
{
	int i, N;
	double *vetorIndependente;
    double x, y;

	N = (dados->amountX * dados->amountY);
	vetorIndependente = calloc((size_t)N, sizeof(double));
    
    for(i=0; i < N; i++) {
        x = vetorPontos[i].x;
        y = vetorPontos[i].y;
        vetorIndependente[i] = F(x,y);
    }

	return vetorIndependente;
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