/*
 * comandosInternos.c
 *
 * Implementação das funções definidas em
 * comandosInternos.h: Funções internas da nsh
 */

#include "comandosInternos.h"

/**
 * Executa a syscall wait para liberar todos
 * os filhos zumbis da nsh
 * @param pl Endereço da lista de processos filhos
 */
void waitZombies(ProcessList** pl)
{
    int* status = NULL;
    pid_t pid, return_pid;
    ProcessList *process, *newPL = NULL;;

    // Enquanto lista de processos não for vazia
    while(*pl != NULL) {
        process = removeProcess(pl);
        pid = process->pid;
        return_pid = waitpid(pid, status, WNOHANG);

        // Erro ao dar wait
        if(return_pid == -1) {
            printf("***ERROR: failed to wait\n");
            addProcess(&newPL, pid);
        }

        // Processo ainda rodando
        else if(return_pid == 0) {
            addProcess(&newPL, pid);
        }

        // Processo zumbi finalizado
        else if(return_pid == pid) {
            printf("Processo zumbi pid=%d liberado\n", pid);
        }

        free(process);
    }

    *pl = newPL;
}

/**
 * Aumenta a prioridade dos processos filhos da nsh
 * ao máximo permitido pelo sistema
 * @param pl Endereço da lista de processos filhos
 */
void burstFilhos(ProcessList** pl)
{
    int ret;
    ProcessList *tmp, *process;
    pid_t pid;

    tmp = *pl;
    while(tmp != NULL) {
        process = tmp;
        pid = process->pid;
        ret = setpriority(PRIO_PROCESS, pid, -20);
        if(ret == -1)
            printf("***ERROR: cannot change priority of pid=%d\n", pid);

        tmp = tmp->prox;
    }
}

/**
 * Efetua a saída da nsh, matando todos os processos
 * filhos da shell e liberando os zumbis
 * @param pl Endereço da lista de processos filhos
 */
void exitShell(ProcessList** pl)
{
    killFilhos(pl);
    waitZombies(pl);
    exit(0);
}

/**
 * Função que efetivamente mata os processos filhos
 * da nsh, utilizando a syscall kill
 * @param pl Endereço da lista de processos filhos
 */
void killFilhos(ProcessList** pl)
{
    ProcessList* process;

    while(*pl != NULL) {
        process = removeProcess(pl);
        kill(process->pid, SIGKILL);
        free(process);
    }
}
