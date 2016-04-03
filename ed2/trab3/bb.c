/**
 * IMPLEMENTAÇÕES DE BRANCH AND BOUND
 */

#include "bb.h"

/**
 * Realiza o escalonamento de Jobs, encontrando o menor deles (exato)
 * @param  jobs Vetor de Jobs a serem escalonados
 * @param  N    Quantidade de Jobs
 * @param  W    Constante para o algoritmo Beam Search
 * @return      Uma sequência de menor custo
 */
Path *branchBound(Job **jobs, const int N, const int W)
{
    int i, j, minCost, ubMax,lbMin;
    SkewHeap *sh = NULL, *shAtual;
    Path *path, *minPath, *menorCaminhoBS;

    menorCaminhoBS = beamSearch(jobs, N, W);
    minPath = menorCaminhoBS;
    minCost = menorCaminhoBS->pathCost;
    ubMax = penalidadeTotal(jobs, N);
    lbMin = penalidadeMinima(jobs, N);

    /* Primeiro caso */
    path = criaPath(NULL, lbMin, ubMax, 0, createList());
    shAtual = geraPossibilidadesBB(jobs, path, N);
    sh = shAtual;

    /* Demais casos */
    for(i = 1; i < N; i++)
    {
        shAtual = NULL;
        path = removeMin(&sh); // Caminho a ser avaliado

        while(path != NULL && path->pathCost < minCost)
        {
            // Caminho em questão possui custo menor que o menor
            // caminho encontrado até o momento

            if(path->pathCost == path->ub)
            {
                for(j = 0; j < N; j++)
                {
                    // Preenchendo o caminho de forma
                    if(!isElementList(path->caminho, j)) insertList(path->caminho, j);
                }
                //Atualizando menor caminho
                freePath(minPath);
                minPath = path;
                minCost = path->ub;
            }
            else
                shAtual = mergeSkewHeap(shAtual, geraPossibilidadesBB(jobs, path, N));

            path = removeMin(&sh); // Caminho a ser avaliado
        }
        if(path != NULL) freePath(path);

        freeSkewHeap(sh);
        sh = shAtual;
    }

    return(minPath);
}

/**
 * Cria uma lista de possíveis caminhos a serem seguidos a partir de um
 * caminho já percorrido
 * @param  jobs Vetor de Jobs
 * @param  p    Caminho percorrido
 * @param  N    Quantidade de Jobs
 * @return      Lista de possibilidades
 */
SkewHeap *geraPossibilidadesBB(Job** jobs, Path *p, const int N)
{
    int i, lb, ub, tempo;
    SkewHeap *sh = NULL;
    Path *newPath;
    typeList *newList;

    for(i = 0; i < N; i++) {
        if(!isElementList(p->caminho, i)) {
            ub = p->ub;
            lb = p->pathCost + calculaLB(jobs,p,N,i);

            if(!hasPenalidade(p, jobs[i]))
            {
                ub -= jobs[i]->penalidade;          // Diminui do ubMax se não houve penalidade
            }
            tempo = p->tempoGasto + jobs[i]->tempo; // Atualiza tempo gasto
            newList = dupList(p->caminho);          // Dushica a lista de caminho
            insertList(newList, i);                 // Adiciona um passo ao caminho
            newPath = criaPath(jobs[i], lb, ub, tempo, newList);
            sh = mergeSkewHeap(sh, criaSkewHeap(newPath));
        }
    }

    freePath(p); // Path utilizado para gerar o sh. Não é mais necessário
    return sh;
}

/**
 * Calcula um incremento ao Lower Bound de um Caminho
 * @param  jobs Vetor de Jobs
 * @param  p    Caminho a ser avaliando
 * @param  N    Quantidade de Jobs
 * @return      Valor a incrementar no Lower Bound de p
 */
int calculaLB(Job **jobs,Path *p, const int N,const int pos)
{
    int i, soma = 0;
    p->tempoGasto += jobs[pos]->tempo;
    for(i = 0; i < N; i++) {
        if(!isElementList(p->caminho, i)) {

            if (hasPenalidade(p, jobs[i]) && ((p->tempoGasto - jobs[pos]->tempo + jobs[i]->tempo)  <= jobs[i]->deadline) && i != pos)
             { soma += jobs[i]->penalidade; }
        }
    }
    p->tempoGasto -= jobs[pos]->tempo;

    if(hasPenalidade(p,jobs[pos]) && (p->tempoGasto + jobs[pos]->tempo) <= jobs[pos]->deadline)
        soma += jobs[pos]->penalidade;

    return soma;
}

/**
 * Analiza se haverá penalidade ao realizar o próximo Job dado um Caminho
 * @param  p   Caminho percorrido
 * @param  job Job a ser realizado
 * @return     1 se houver penalidade, 0 se não
 */
int hasPenalidade(Path *p, Job *job)
{
    return (p->tempoGasto + job->tempo > job->deadline);
}
