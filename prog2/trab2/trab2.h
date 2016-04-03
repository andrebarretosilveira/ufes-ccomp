#include <stdio.h>
#include <math.h>
#include <string.h>

#define N 30   // Número de cidades
#define M 40   // Tamanho máximo dos nomes
#define Mx 24  // Maior x cartesiano
#define My 28  // Maior y cartesiano
#define MD 99  // Distância máxima
#define MC 999 // Custo máximo

// Arquivos
#define in1  "nome-coord.txt"
#define in2  "diaria-custo.txt"
#define out1 "distacia.txt"
#define out2 "custo.txt"

// Definição de Structs
typedef struct {
        int x, y;
} tposicao;

typedef struct {
        char nome[M];
        float diaria;
        tposicao pos;
} tcidade;

// Definição global
FILE *fp;
int i,j;

/** FUNÇÕES **/
int ler_nome_coord(tcidade *cidades);
int ler_diaria_custo(tcidade *cidades, float (*custos)[N]);
float dist_2pontos(int x, int x0, int y, int y0);
int gerar_mat_dist(tcidade *cidades, float (*distancias)[N]);
int gerar_mat_custo(tcidade *cidades, float (*distancias)[N], float (*custo_km)[N], float (*custos)[N]);
void analisar_cidades(tcidade *cidades);
int proxima_cidade(float (*distancias)[N], float (*custos)[N], int atual, int lim, int lei);
int num_cidades(float (*distancias)[N], float (*custos)[N], int prim, int ult, int lei);
void caminho(float (*distancias)[N], float (*custos)[N], int prim, int ult, int lei);
