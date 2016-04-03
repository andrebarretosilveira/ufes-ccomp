/**
 * IMPLEMENTAÇÕES DE PATH
 */

#include "path.h"

/**
 * Cria uma estrutura do tipo path
 * @param  job        Job a ser armazenado
 * @param  pathCost   Custo do caminho a ser percorrido
 * @param  ub         Upper Bound do caminho (caso bb)
 * @param  tempoGasto Tempo gasto no caminho percorrido
 * @param  caminho    Lista do caminho percorrido
 * @return            Ponteiro para estrutura criada
 */
Path *criaPath(Job* job, int pathCost, int ub, int tempoGasto, typeList *caminho)
{
    Path *p = malloc(sizeof(Path));
    p->job = job;
    p->pathCost = pathCost;
    p->ub = ub;
    p->tempoGasto = tempoGasto;
    p->caminho = caminho;

    return p;
}

/**
 * Imprime informações sobre o caminho
 * @param p Ponteiro para path
 */
void printPath(Path *p)
{
    printf("%d: ", p->pathCost);
    printList(p->caminho);
}

/**
 * Libera espaço de memória de um Path
 * @param p Ponteiro para estrutura a ser liberada
 */
void freePath(Path *p)
{
    freeList(p->caminho);
    free(p);
}
