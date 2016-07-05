/*
 * processList.h
 *
 * Definição de estrutura e funções para
 * manipular uma lista de processos
 */

#ifndef PROCESSLIST_H
#define PROCESSLIST_H

#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>

typedef struct processList {
    pid_t pid;
    struct processList* prox;
} ProcessList;

ProcessList* newProcess(pid_t);
ProcessList* newProcessList();
void addProcess(ProcessList**, pid_t);
ProcessList* removeProcess(ProcessList**);
void printProcessList(ProcessList*);
int sizeList(ProcessList*);

#endif
