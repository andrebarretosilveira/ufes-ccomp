/**
 * IMPLEMENTAÇÕES DE FUNÇÕES JOBS
 */

#include "jobs.h"

/**
 * Armazena espaço de cria um Job
 * @param   tempo       Tempo de processamento
 * @param   deadline    Limite até penalidade
 * @param   penalidade  Penalidade após execedido a deadline
 * @param   id          Identificador do Job
 * @return              Ponteiro para estrutura
 */
Job *criaJob(int id, int tempo, int deadline, int penalidade)
{
    Job *job = malloc(sizeof(Job));
    job->id = id;
    job->tempo = tempo;
    job->deadline = deadline;
    job->penalidade = penalidade;

    return job;
}

/**
 * Ler do stdin os dados para armazenar em 'job'
 * @param  jobs  Vetor de Jobs a armazenar os dados
 * @param  N     Número de Jobs a serem lidos
 */
void lerJobs(Job **jobs, const int N)
{
    int i, tempo, deadline, penalidade;

    for(i = 0; i < N; i++) {
        scanf("%d %d %d", &tempo, &deadline, &penalidade);
        jobs[i] = criaJob(i, tempo, deadline, penalidade);
    }
}

/**
 * Calcula a penalidade máxima somada dos jobs
 * @param  jobs Vetor de jobs
 * @param  N    Tamanho do vetor
 * @return      Total das penalidades (ub máximo)
 */
int penalidadeTotal(Job **jobs, const int N)
{
    int i, total = 0;

    for(i = 0; i < N; i++) {
        total += jobs[i]->penalidade;
    }

    return total;
}

/**
 * Calcula a menor penalidade possível dos Jobs
 * @param  jobs Vetor de jobs
 * @param  N    Tamanho do vetor
 * @return      Menor penalidade (lb mínimo)
 */
int penalidadeMinima(Job **jobs, const int N)
{
    int i, min = 0;

    for(i = 0; i < N; i++) {
        if (jobs[i]->tempo > jobs[i]->deadline)
        {
            min += jobs[i]->penalidade;
        }
    }

    return min;
}

/**
 * Imprime na tela informações do Job
 * @param  job  Ponteiro para estrutura do Job
 */
void printJob(Job *job)
{
    printf("Job %d: %d %d %d\n",
    job->id, job->tempo, job->deadline, job->penalidade);
}

/**
 * Liberar espaço de memória do vetor 'jobs'
 * @param  jobs  Vetor de Jobs alocado
 * @param  N     Número de Jobs/Tamanho do vetor
 */
void freeJobs(Job **jobs, const int N)
{
    int i;

    for(i = 0; i < N; i++) {
        free(jobs[i]);
    }
    free(jobs);
}
