/**
 * CABEÇALHO JOBS
 * ESTRUTURA E ASSINUATURA DE FUNÇÕES PARA GERENCIAR JOBS
 */

#ifndef JOBS_H
#define JOBS_H

#include <stdio.h>
#include <stdlib.h>

/**
 * ESTRUTURA DE JOBS
 */
 typedef struct job {
     int id;            // Identificador do Job
     int tempo;         // Tempo de processamento
     int deadline;      // Tempo limite sem penalidade
     int penalidade;    // Penalidade ao exceder o deadline
 } Job;

 /**
  * FUNÇÕES
  */
Job *criaJob(int id, int tempo, int deadline, int penalidade);
void lerJobs(Job **jobs, const int N);
int penalidadeTotal(Job **jobs, const int N);
int penalidadeMinima(Job **jobs, const int N);
void printJob(Job *job);
void freeJobs(Job **jobs, const int N);

#endif
