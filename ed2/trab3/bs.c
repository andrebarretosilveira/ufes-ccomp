/**
 * IMPLEMENTAÇÕES DE BEAM SEARCH
 */

#include "bs.h"

/**
 * [beamSearch - Realiza a heurística Beam Seach para escalonar Jobs]
 * @param  jobs [Vetor de Jobs a serem escalonados]
 * @param  N    [Quantidade de Jobs / Tamanho do vetor Jobs]
 * @param  w    [Quantidade de Jobs selecionados por nível]
 * @return      [Ponteiro para SkewHeap com o caminho de menor custo na raiz]
 */
Path *beamSearch(Job **jobs, const int N, const int W)
{
    int i, j;
    SkewHeap *sh, *shAtual;
    Path *path, *minPath;

    sh = NULL;

    /* Primeiro caso */
    path = criaPath(NULL, penalidadeMinima(jobs, N), 0, 0, createList());
    shAtual = mergeSkewHeap(NULL, geraPossibilidades(jobs, path, N));
    sh = shAtual;

    /* Demais casos */
    for(i = 1; i < N; i++) {
        shAtual = NULL;
        j = 0;
        while(j < W && sh != NULL) {
            path = removeMin(&sh);
            shAtual = mergeSkewHeap(shAtual, geraPossibilidades(jobs, path, N));
            j++;
        }

        freeSkewHeap(sh);
        sh = shAtual;
    }

    minPath = removeMin(&sh);
    freeSkewHeap(sh);

    return(minPath);
}

/**
 * [geraPossibilidades - Criar árvore de possibilidades para um determinado caminho]
 * @param  jobs  [Vetor que contém os Jobs]
 * @param  p     [Ponteiro para o caminho de referência]
 * @param  N     [Quantidade de jobs / Tamanho do vetor 'jobs']
 * @return       [SkewHeap contendo as possibilidades a partir do caminho p]
 */
SkewHeap *geraPossibilidades(Job** jobs, Path *p, const int N)
{
    int i, custo, tempo;
    SkewHeap *sh = NULL;
    Path *newPath;
    typeList *newList;

    for(i = 0; i < N; i++) {
        if(!isElementList(p->caminho, i)) {
            custo = p->pathCost + calculaLB(jobs,p,N,i);
            tempo = p->tempoGasto + jobs[i]->tempo; // Atualiza tempo gasto
            newList = dupList(p->caminho);          // Duplica a lista de caminho
            insertList(newList, i);                 // Adiciona um passo ao caminho
            newPath = criaPath(jobs[i], custo, 0, tempo, newList);
            sh = mergeSkewHeap(sh, criaSkewHeap(newPath));
        }
    }

    freePath(p); // Path utilizado para gerar a sh. Não é mais necessário
    return sh;
}

/**
 * [calculaCusto - Dado um Path e um Job, retorna o custo (penalidade) do processamento]
 * [deste job considerando o tempo já gasto pelo caminho p]
 * [@param  p   Path percorrido até o job]
 * [@param  job Job atual sendo avaliado]
 * [@return     Penalidade do processamento em questão]
 */
int calculaCusto(Path *p, Job *job)
{
    if(p->tempoGasto + job->tempo > job->deadline)
        return p->pathCost + job->penalidade;
    else
        return p->pathCost;
}
