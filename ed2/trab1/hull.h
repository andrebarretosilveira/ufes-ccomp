
#ifndef HULL_HEADER_FILE
#define HULL_HEADER_FILE

#include "pilha.h"

Pilha *caminhoHull(Pilha *env, Pilha *cidadesIn);
Pilha *inserirNo(Pilha *p, No *ins);
Pilha *envoltorioConvexo(Cidade *cidades, int n);
Pilha *cidadesInteriores(Pilha *env, Cidade *cidades, int n);
int curvaConvex(float x1, float y1, float x2, float y2, float x3, float y3);
float custoCaminhoHull(Pilha *caminho);
void saidaFormatadaHull(Pilha *caminho, float custo);

void lerCidades(Cidade *cidades, int n);
void imprimeCidades(Cidade *cidades, int n);

void quicksort(Cidade *c, int lo, int hi);
int particao(Cidade *c, int lo, int hi);
void troca(Cidade *cidades, int i, int j);

#endif
