/*                                      *
 * Heuristica Envoltório Convexo (hull) *
 *                                      */

#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include "hull.h"
#include "pilha.h"
#include "outros.h"

Pilha *caminhoHull(Pilha *env, Pilha *cidadesIn) {
    Pilha *p;
    No *aux = cidadesIn->topo;

    for(aux=cidadesIn->topo; aux != NULL; aux=aux->prox)
        p = inserirNo(env, aux);

    return env;
}

// Gera o envoltório convexo
Pilha *envoltorioConvexo(Cidade *cidades, int n) {
    int i;
    Pilha *p;
    No *no;

    p = criaPilha();
    push(p, &cidades[0]);
    push(p, &cidades[1]);

    for(i=2; i < n; i++) {
        no = p->topo;
        if(no->prox == NULL)
            push(p, &cidades[i]);

        else {
            if(!curvaConvex(cidades[i].x, cidades[i].y, no->c->x, no->c->y, no->prox->c->x, no->prox->c->y)) {
                free(pop(p));
                i--;
            }
            else
                push(p, &cidades[i]);
        }
    }

    for(i=n-2; i >= 0; i--) {
        no = p->topo;
        if(no->prox == NULL)
            push(p, &cidades[i]);

        else {
            if(!curvaConvex(cidades[i].x, cidades[i].y, no->c->x, no->c->y, no->prox->c->x, no->prox->c->y)) {
                free(pop(p));
                i++;
            }
            else
                push(p, &cidades[i]);
        }
    }
    free(pop(p));

    return p;
}

// Retorna as cidades interiores ao envoltório convexo
Pilha *cidadesInteriores(Pilha *env, Cidade *cidades, int n) {
    int i, encontrou;
    Pilha *p = criaPilha();
    No *aux;

    for(i=0; i < n; i++) {
        encontrou = 0;
        for(aux=env->topo; aux != NULL; aux=aux->prox)
            if(cidades[i].x == aux->c->x && cidades[i].y == aux->c->y) {
                encontrou = 1;
                break;
            }

        if(!encontrou)
            push(p, &cidades[i]);
    }

    return p;
}

Pilha *inserirNo(Pilha *p, No *ins) {
    No *ant=NULL, *maisProx, *antMaisProx, *aux;
    No *novo = criaNo(ins->c);
    float dist, menorDist = 9999;
    float custo1, custo2;

    // Definindo variaveis para insercao
    for(aux = p->topo; aux != NULL; aux = aux->prox) {
        dist = dist2Pontos(novo->c->x, novo->c->y, aux->c->x, aux->c->y);
        if(dist < menorDist) {
            antMaisProx = ant;
            maisProx = aux;
            menorDist = dist;
        }
        ant = aux;
    }

    /** Analisar melhor caminho **/

    // Caso o +prox seja o primeiro
    if(p->topo->c->id == maisProx->c->id) {
        // Inserindo antes
        aux = p->topo;
        p->topo = novo;
        novo->prox = aux;
        custo1 = custoCaminhoHull(p);

        // Inserindo depois
        p->topo = aux;
        ant->prox = novo;
        novo->prox = NULL;
        custo2 = custoCaminhoHull(p);

        if(custo1 < custo2) {
            ant->prox = NULL;
            aux = p->topo;
            p->topo = novo;
            novo->prox = aux;
        }
    }
    else {
        // Inserindo antes
        antMaisProx->prox = novo;
        novo->prox = maisProx;
        custo1 = custoCaminhoHull(p);

        // Inserindo depois
        antMaisProx->prox = maisProx;
        aux = maisProx->prox;
        maisProx->prox = novo;
        novo->prox = aux;
        custo2 = custoCaminhoHull(p);

        if(custo1 < custo2) {
            maisProx->prox = aux;
            aux = antMaisProx->prox;
            antMaisProx->prox = novo;
            novo->prox = aux;
        }
    }

    return p;
}

// Retorna 1 se a curva for convexa (curva pra esquerda)
int curvaConvex(float x1, float y1, float x2, float y2, float x3, float y3) {
    return (x2-x1)*(y3-y1) - (y2-y1)*(x3-x1) >= 0;
}

float custoCaminhoHull(Pilha *caminho) {
    No *no;
    float custo = 0;

    for(no=caminho->topo; no->prox != NULL; no=no->prox) {
        custo += dist2Pontos(no->c->x, no->c->y, no->prox->c->x, no->prox->c->y);
    }
    custo += dist2Pontos(no->c->x, no->c->y, caminho->topo->c->x, caminho->topo->c->y);
    
    return custo;
}

void saidaFormatadaHull(Pilha *caminho, float custo) {
    No *aux = caminho->topo;

    while(aux->c->id != 0)
        aux = aux->prox;

    for(; aux != NULL; aux = aux->prox)
        printf("%d\n", aux->c->id);

    aux = caminho->topo;

    while(aux->c->id != 0) {
        printf("%d\n", aux->c->id);
        aux = aux->prox;
    }

    printf("%.2f\n*\n", custo);
}

void lerCidades(Cidade *cidades, int n) {
    int i;

    for(i = 0; i < n; i++) {
        scanf("%f %f", &cidades[i].x, &cidades[i].y);
        cidades[i].id = i;
    }
}

void imprimeCidades(Cidade *cidades, int n) {
    int i;

    for(i = 0; i < n; i++)
        printf("%.2f ; %.2f  ->  %d\n", cidades[i].x, cidades[i].y, cidades[i].id);
}

void quicksort(Cidade *cidades, int lo, int hi) {
    if(lo < hi) {
        int p = particao(cidades, lo, hi);
        quicksort(cidades, lo, p-1);
        quicksort(cidades, p+1, hi);
    }
}

int particao(Cidade *cidades, int lo, int hi) {
    float pivot = cidades[hi].x, temp;
    int i = lo, j;
    
    for(j=lo; j<hi; j++) {
        if(cidades[j].x <= pivot) {
            troca(cidades, i, j);
            i++;
        }
    }
    troca(cidades, i , hi);

    return i;
}

void troca(Cidade *cidades, int i, int j) {
    Cidade temp;

    temp = cidades[i];
    cidades[i] = cidades[j];
    cidades[j] = temp;
}
