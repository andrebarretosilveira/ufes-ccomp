/*
 * processList.c
 *
 * Implementação das funções definidas em
 * processList.h para a manipulação de lista
 * de processos
 */

#include "processList.h"

/**
 * Cria uma nova e vazia lista de processos
 * @return Ponteiro para lista de processos
 */
ProcessList* newProcessList()
{
    return NULL;
}

/**
 * Cria um processo, que é caracterizado por
 * uma lista de processos unitária
 * @param  pid Valor do pid do processo
 * @return     Ponteiro para o processo
 */
ProcessList* newProcess(pid_t pid)
{
    ProcessList* process;
    process = malloc(sizeof(ProcessList));
    process->pid = pid;
    process->prox = NULL;
    return process;
}

/**
 * Adiciona um processo à lista de processos
 * @param pl  Endereço da lista de processos
 * @param pid Pid do processo a ser adicionado
 */
void addProcess(ProcessList** pl, pid_t pid)
{
    ProcessList* process = newProcess(pid);

    process->prox = *pl;
    *pl = process;
}

/**
 * Remove o primeiro processo da lista de processos
 * @param  pl Endereço da lista de processos
 * @return    Ponteiro para o processo removido
 */
ProcessList* removeProcess(ProcessList** pl)
{
    ProcessList* process;

    if(*pl == NULL) return NULL;

    process = *pl;
    *pl = (*pl)->prox;
    return process;
}

/**
 * sizeList Função que retorna o tamanho da lista
 * @param  pl Lista de processos
 * @return    Quantidade de processos armazenados na lista
 */
int sizeList(ProcessList* pl)
{
    ProcessList* tmp = pl;
    int count = 0;

    while(tmp != NULL)
    {
        count++;
        tmp = tmp->prox;
    }
    return count;
}
