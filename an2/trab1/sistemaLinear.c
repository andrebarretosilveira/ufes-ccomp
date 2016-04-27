/**
 * sistemaLinear.c
 *
 * Implementação das funções definidas no
 * cabeçalho sistemaLinear.h
 *
 */

#include "sistemaLinear.h"

/**
 * Cria a estrutura do sistema pentadiagonal a
 * partir de uma matriz pentadiagonal e um vetor
 * independente
 * @param  matriz Ponteiro para matriz pentadiagonal
 * @param  f      Ponteiro para vetor independente
 * @param  N      Ordem do sistema
 * @return        Ponteiro para a estrutura do sistema
 */
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
	int N;
	double *vetorIndependente;

	N = (dados->amountX * dados->amountY);
	vetorIndependente = malloc(N*sizeof(double));

    if(flagExp == 1)
        montaVetorIndependenteV1(vetorIndependente, N);

    else if(flagExp == 2)
        montaVetorIndependenteV2(vetorIndependente, vetorPontos, N);

    else if(flagExp == 3)
        montaVetorIndependenteA1(vetorIndependente, N);

    else if(flagExp == 4)
        montaVetorIndependenteA2(vetorIndependente, vetorPontos, N);

	return vetorIndependente;
}

/**
 * Método de construção específico do experimento 1:
 * "Validação 1 - Solução trivial"
 * @param vetorIndependente Vetor independente do sistema
 * @param N                 Ordem do sistema
 */
void montaVetorIndependenteV1(double* vetorIndependente, const int N)
{
    int i;
    for(i=0; i < N; i++)
        vetorIndependente[i] = 0;
}

/**
* Método de construção específico do experimento 2:
* "Validação 2 - Solução conhecida"
 * @param vetorIndependente Vetor independente do sistema
 * @param vetorPontos       Vetor de pontos discretos
 * @param N                 Ordem do sistema
 */
void montaVetorIndependenteV2(double* vetorIndependente, Ponto* vetorPontos, const int N)
{
    int i;
    double x, y;
    const double e = 0.5772156649;

    for(i=0; i < N; i++) {
        x = vetorPontos[i].x;
        y = vetorPontos[i].y;
        vetorIndependente[i] = -((2.5*pow(e,pow(x,4.5))*(81*pow(x,9)-81*pow(x,8) +
            135*pow(x,4.5)-99*pow(x,3.5)+8)*(y-1)*y)+(20*pow(e,pow(x,4.5))*(x-1)*x)) +
            5*pow(e,pow(x,4.5))*(x*(9*(x-1)*pow(x,3.5)+4)-2)*(y-1)*y +
            20*y*(10*pow(e,pow(x,4.5))*(x-1)*x*(2*y-1)) +
            10*x*y*(1-x)*(1-y)*pow(e,pow(x,4.5));
    }
}

/**
* Método de construção específico do experimento 3:
* "Aplicação Física 1 - Resfriador bidimensional"
 * @param vetorIndependente Vetor independente do sistema
 * @param N                 Ordem do sistema
 */
void montaVetorIndependenteA1(double* vetorIndependente, const int N)
{
    int i;
    double c, uRef, T;

    // Constantes do problema
    c = 1;
    T = 2;
    uRef = 70;

    for(i=0; i < N; i++)
        vetorIndependente[i] = 2*c*uRef/T;
}

/**
* Método de construção específico do experimento 4:
* "Aplicação Física 2 - Escoamento em Águas Subterrâneas"
 * @param vetorIndependente Vetor independente do sistema
 * @param vetorPontos       Vetor de pontos discretos
 * @param N                 Ordem do sistema
 */
void montaVetorIndependenteA2(double* vetorIndependente, Ponto* vetorPontos, const int N)
{
    int i;
    double x, y;

    for(i=0; i < N; i++) {
        x = vetorPontos[i].x;
        y = vetorPontos[i].y;
        vetorIndependente[i] = 0;
    }
}

/**
 * Função que aplica as condições de contorno no sistema linear
 * modificando a Matriz Pentadiagonal e o vetor independente
 * @param sistema Ponteiro para o sistema pentadiagonal
 * @param dados   Ponteiro para os dados de entrada
 */
void aplicaContorno(SistemaLinear* sistema, Dados *dados)
{
    // Aplicando condições de contorno específicas
    if(flagExp == 1)
        aplicaContornoValidacao1(sistema, dados);

    else if(flagExp == 2)
        aplicaContornoValidacao2(sistema, dados);

    else if(flagExp == 3)
        aplicaContornoAplicacao1(sistema, dados);

    else if(flagExp == 4)
        aplicaContornoAplicacao2(sistema, dados);
}

/**
 * Aplicação das Condições de Contorno específicas
 * do experimento "Validação 1 - Solução trivial"
 * @param sistema Ponteiro para o sistema pentadiagonal
 * @param dados   Ponteiro para os dados de entrada
 */
void aplicaContornoValidacao1(SistemaLinear* sistema, Dados* dados)
{
	int i, j, I;
    MatrizPentadiagonal* matriz;

    matriz = sistema->matriz;

    for(i=0, j=0; i < dados->amountX; i++) {
        I = indiceDiscreto(i, j, dados->amountX);
        sistema->f[I] = T0;
        matriz->e[I]  = 0;
        matriz->b[I]  = 0;
        matriz->a[I]  = 1;
        matriz->c[I]  = 0;
        matriz->d[I]  = 0;
    }
    for(i=dados->amountX-1, j=1; j < dados->amountY-1; j++) {
        I = indiceDiscreto(i, j, dados->amountX);
        sistema->f[I] = T0;
        matriz->e[I]  = 0;
        matriz->b[I]  = 0;
        matriz->a[I]  = 1;
        matriz->c[I]  = 0;
        matriz->d[I]  = 0;
    }
    for(i=dados->amountX-1, j=dados->amountY-1; i > 0; i--) {
        I = indiceDiscreto(i, j, dados->amountX);
        sistema->f[I] = T0;
        matriz->e[I]  = 0;
        matriz->b[I]  = 0;
        matriz->a[I]  = 1;
        matriz->c[I]  = 0;
        matriz->d[I]  = 0;
    }
    for(i=0, j=dados->amountY-1; j > 0; j--) {
        I = indiceDiscreto(i, j, dados->amountX);
        sistema->f[I] = T0;
        matriz->e[I]  = 0;
        matriz->b[I]  = 0;
        matriz->a[I]  = 1;
        matriz->c[I]  = 0;
        matriz->d[I]  = 0;
    }
}

/**
 * Aplicação das Condições de Contorno específicas
 * do experimento "Validação 2 - Solução conhecida"
 * @param sistema Ponteiro para o sistema pentadiagonal
 * @param dados   Ponteiro para os dados de entrada
 */
void aplicaContornoValidacao2(SistemaLinear* sistema, Dados* dados)
{
	int i, j, I;
    MatrizPentadiagonal* matriz;

    matriz = sistema->matriz;

    for(i=0, j=0; i < dados->amountX; i++) {
        I = indiceDiscreto(i, j, dados->amountX);
        sistema->f[I] = 0;
        matriz->e[I]  = 0;
        matriz->b[I]  = 0;
        matriz->a[I]  = 1;
        matriz->c[I]  = 0;
        matriz->d[I]  = 0;
    }
    for(i=dados->amountX-1, j=1; j < dados->amountY-1; j++) {
        I = indiceDiscreto(i, j, dados->amountX);
        sistema->f[I] = 0;
        matriz->e[I]  = 0;
        matriz->b[I]  = 0;
        matriz->a[I]  = 1;
        matriz->c[I]  = 0;
        matriz->d[I]  = 0;
    }
    for(i=dados->amountX-1, j=dados->amountY-1; i > 0; i--) {
        I = indiceDiscreto(i, j, dados->amountX);
        sistema->f[I] = 0;
        matriz->e[I]  = 0;
        matriz->b[I]  = 0;
        matriz->a[I]  = 1;
        matriz->c[I]  = 0;
        matriz->d[I]  = 0;
    }
    for(i=0, j=dados->amountY-1; j > 0; j--) {
        I = indiceDiscreto(i, j, dados->amountX);
        sistema->f[I] = 0;
        matriz->e[I]  = 0;
        matriz->b[I]  = 0;
        matriz->a[I]  = 1;
        matriz->c[I]  = 0;
        matriz->d[I]  = 0;
    }
}

/**
 * Aplicação das Condições de Contorno específicas
 * do experimento "Aplicação Física 1 - Resfriador bidimensional"
 * @param sistema Ponteiro para o sistema pentadiagonal
 * @param dados   Ponteiro para os dados de entrada
 */
void aplicaContornoAplicacao1(SistemaLinear* sistema, Dados* dados)
{
	int i, j, I;
    double uRef, c, hx;
    MatrizPentadiagonal* matriz;

    matriz = sistema->matriz;
	hx = (dados->endX - dados->beginX)/((double)dados->amountX-1);
    uRef = 70;
    c = 1;

    for(i=0, j=0; i < dados->amountX; i++) {
        I = indiceDiscreto(i, j, dados->amountX);
        sistema->f[I] = 70;
        matriz->e[I]  = 0;
        matriz->b[I]  = 0;
        matriz->a[I]  = 1;
        matriz->c[I]  = 0;
        matriz->d[I]  = 0;
    }
    for(i=dados->amountX-1, j=1; j < dados->amountY-1; j++) {
        I = indiceDiscreto(i, j, dados->amountX);
        // Aplicação da condição de contorno mista
        // k*parcial(u)/parcial(n) = c(uRef-u(L,y)
        sistema->f[I] = sistema->f[I] - matriz->b[I]*hx*uRef;
        matriz->a[I]  = matriz->a[I] + matriz->b[I]*(1 - hx*c);
        matriz->b[I]  = 0;
    }
    for(i=dados->amountX-1, j=dados->amountY-1; i > 0; i--) {
        I = indiceDiscreto(i, j, dados->amountX);
        sistema->f[I] = 70;
        matriz->e[I]  = 0;
        matriz->b[I]  = 0;
        matriz->a[I]  = 1;
        matriz->c[I]  = 0;
        matriz->d[I]  = 0;
    }
    for(i=0, j=dados->amountY-1; j > 0; j--) {
        I = indiceDiscreto(i, j, dados->amountX);
        sistema->f[I] = 200;
        matriz->e[I]  = 0;
        matriz->b[I]  = 0;
        matriz->a[I]  = 1;
        matriz->c[I]  = 0;
        matriz->d[I]  = 0;
    }
}

/**
 * Aplicação das Condições de Contorno específicas
 * do experimento "Aplicação Física 2 - Escoamento em Águas Subterrâneas"
 * @param sistema Ponteiro para o sistema pentadiagonal
 * @param dados   Ponteiro para os dados de entrada
 */
void aplicaContornoAplicacao2(SistemaLinear* sistema, Dados* dados)
{
	int i, j, I;
    MatrizPentadiagonal* matriz;

    matriz = sistema->matriz;

    for(i=0, j=0; i < dados->amountX; i++) {
        I = indiceDiscreto(i, j, dados->amountX);
        sistema->f[I] = 0;
        matriz->b[I]  = 0;
        matriz->a[I]  = 1;
        matriz->c[I]  = 0;
        matriz->d[I]  = 0;
    }
    for(i=dados->amountX-1, j=1; j < dados->amountY-1; j++) {
        I = indiceDiscreto(i, j, dados->amountX);
        sistema->f[I] = 0;
        matriz->e[I]  = 0;
        matriz->a[I]  = 1;
        matriz->c[I]  = 0;
        matriz->d[I]  = 0;
    }
    for(i=dados->amountX-1, j=dados->amountY-1; i > 0; i--) {
        I = indiceDiscreto(i, j, dados->amountX);
        sistema->f[I] = 0;
        matriz->e[I]  = 0;
        matriz->b[I]  = 0;
        matriz->a[I]  = 1;
        matriz->c[I]  = 0;
    }
    for(i=0, j=dados->amountY-1; j > 0; j--) {
        I = indiceDiscreto(i, j, dados->amountX);
        sistema->f[I] = 0;
        matriz->e[I]  = 0;
        matriz->b[I]  = 0;
        matriz->a[I]  = 1;
        matriz->d[I]  = 0;
    }
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
	return i + (j * amountX);
}

void printSistemaLinear(SistemaLinear* sistema)
{
    size_t i;
    printMatrizPentadiagonal(sistema->matriz);
    printf("\nf = ");
    for(i=0; i < sistema->N; i++) {
        printf("%g ", sistema->f[i]);
    }

    printf("\n\n");
}

/**
 * Libera espaço de memória ocupada pelo
 * sistema linear pentadiagonal
 * @param sistema Ponteiro para os sistema
 */
void freeSistemaLinear(SistemaLinear* sistema)
{
    freeMatrizPentadiagonal(sistema->matriz);
    free(sistema->f);
    free(sistema);
}
