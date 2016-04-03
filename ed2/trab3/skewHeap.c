/**
 * IMPLEMENTAÇÕES DE SKEW HEAP
 */

#include "skewHeap.h"

/**
 * Cria uma SkewHeap vazia
 * @return Ponteiro para estrutura inicializada
 */
SkewHeap *criaSkewHeap(Path *path)
{
    SkewHeap *sh = malloc(sizeof(SkewHeap));
    sh->path = path;
    sh->lc = NULL;
    sh->rc = NULL;
    return sh;
}

/**
 * Adiciona um path em uma SkillHeap
 * @param sh  Ponteiro para estrutura onde será adicionado o path
 * @param path Ponteiro para path a ser armazenado
 */
void addPath(SkewHeap **sh, Path *path)
{
    SkewHeap *new = criaSkewHeap(path);
    *sh = mergeSkewHeap(*sh, new);
}

/**
 * Remove o menor caminho da SkewHeap de paths
 * @param  sh Ponteiro para SkewHeap
 * @return    Menor caminho da Heap
 */
Path *removeMin(SkewHeap **sh)
{
    if(*sh == NULL)
        return NULL;

    SkewHeap *node = *sh;
    Path *minPath = (*sh)->path;
    *sh = mergeSkewHeap((*sh)->lc, (*sh)->rc);
    free(node);

    return minPath;
}

/**
 * Executa um merge entre duas SkillHeaps
 * @param  left  Ponteiro para sh da esquerda
 * @param  right Ponteiro para sh da direita
 * @return       SkillHeap unida
 */
SkewHeap *mergeSkewHeap(SkewHeap *left, SkewHeap *right)
{
    SkewHeap *temp;

    if (left == NULL) return right;
    if (right == NULL) return left;

    if (getMinCost(left) <= getMinCost(right)) {
        left->rc = mergeSkewHeap(left->rc, right);
        /* Swap subtrees */
        temp = left->lc;
        left->lc = left->rc;
        left->rc = temp;

        return left;
     }//else if((getMinCost(left) == getMinCost(right)) && (left->path->job != NULL && right->path->job != NULL))
     // {
     //      if(left->path->job->id < right->path->job->id)
     //       {
     //            left->rc = mergeSkewHeap(left->rc, right);
     //             //Swap subtrees 
     //            temp = left->lc;
     //            left->lc = left->rc;
     //            left->rc = temp;
     //            return left;
     //       }else
     //         return mergeSkewHeap(right, left);
         

     // }
     else {
         return mergeSkewHeap(right, left);
     }
}

int getMinCost(SkewHeap *sh)
{
    return sh->path->pathCost;
}

/**
 * Imprime a SkewHeap em pre-order
 * @param sh Ponteiro para SkewHeap
 */
void printSkewHeap(SkewHeap *sh)
{
    if(sh == NULL) return;

    printSkewHeap(sh->lc);
    printSkewHeap(sh->rc);

    printPath(sh->path);
}

/**
 * Libera a SkillHeap recursivamente
 * @param sh Ponteiro para sh a ser liberada
 */
void freeSkewHeap(SkewHeap *sh)
{
    if(sh == NULL) return;

    freeSkewHeap(sh->lc);
    freeSkewHeap(sh->rc);

    freePath(sh->path);
    free(sh);
}
