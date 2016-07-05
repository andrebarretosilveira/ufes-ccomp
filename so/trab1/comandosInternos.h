/*
 * comandosInternos.h
 *
 * Definição das funções internas da
 * Nice Shell (nsh)
 */
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <signal.h>
#include <sys/wait.h>
#include <sys/types.h>
#include <sys/resource.h>
#include "processList.h"

void waitZombies(ProcessList**);
void burstFilhos(ProcessList**);
void exitShell(ProcessList**);
void killFilhos(ProcessList**);
