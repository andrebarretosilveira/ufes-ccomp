/**
 *
 * Comandos Externos
 * 
 * Definição das funções dos comandos externos da Nice Shell (nsh)
 * Last update date: 17/05/2016
 */

#ifndef EXTERNS_COMMANDS
#define EXTERNS_COMMANDS
#include "processList.h"
#include <signal.h>

/**
 * [catch_ctrl_all Função com a mensagem de captura de sinais com CTRL-*]
 */
void catch_ctrl_all();

/**
 * [catchSignal Função que trata os sinais Ctrl + * ]
 * @param act [Estrutura contendo a máscara de sinais a serem bloqueados]
 */
void catchSignal(struct sigaction act);

/**
 * [blockSigContrl Função que bloqueia os sinais Ctrl + * em uma máscara de sinais]
 * @param blockMask [Máscara de sinais que se deseja bloquear o SIGTERM]
 */
void blockSigContrl(sigset_t blockMask);

/**
 * [externCMD Função que executa um comando externo]
 * @param pl      [Lista de processos]
 * @nameProcess	  [Nome do processo a ser criado]
 * @param command [Comando a ser executado]
 * @param act     [Estrutura contendo a máscara de sinais a serem bloqueados]
 * @param isBG    [Constante inteira para saber se um comando deve ser executado como back ground]
 * @param groupIDBG [Endereço do valor que armazena o groupID dos processos de background]
 */
void externCMD(ProcessList** pl,char *nameProcess,char **command,const int isBG, pid_t *groupIDBG);

#endif