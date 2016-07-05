/**
 *
 * Comandos Externos
 *
 * Implementação das funções dos comandos externos da Nice Shell (nsh)
 * Last update date: 17/05/2016
 */

#include "comandosExternos.h"
#include <unistd.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/wait.h>

/**
 * [catch_ctrl_all Função com a mensagem de captura de sinais com CTRL-*]
 */
void catch_ctrl_all(int signo)
{
    if(signo == SIGINT) printf("\nNao adianta me enviar o sinal por Ctrl-c. Nao vou fazer nada!!\n");
    if(signo == SIGTSTP) printf("\nNao adianta me enviar o sinal por Ctrl-z. Nao vou fazer nada!!\n");
    if(signo == SIGCONT) printf("\nNao adianta me enviar o sinal por Ctrl-y. Nao vou fazer nada!!\n");
    if(signo == SIGQUIT) printf("\nNao adianta me enviar o sinal por Ctrl-|. Nao vou fazer nada!!\n");
}

/**
 * [catchSignal Função que trata os sinais Ctrl + * ]
 * @param act [Estrutura contendo a máscara de sinais a serem bloqueados]
 */
void catchSignal(struct sigaction act)
{
	act.sa_handler = catch_ctrl_all;
	act.sa_flags = 0;
	if(sigemptyset(&act.sa_mask) == -1 ||
		sigaction(SIGINT,&act,NULL) == -1 ||
		sigaction(SIGCONT,&act,NULL) == -1 ||
		sigaction(SIGQUIT,&act,NULL) == -1 ||
		sigaction(SIGTSTP,&act,NULL) == -1)
		perror("FAILED TO SET SIGINT TO HANDLE CTRL-*\n");
}

/**
 * [blockSigContrl Função que bloqueia os sinais Ctrl + * em uma máscara de sinais]
 * @param blockMask [Máscara de sinais que se deseja bloquear o SIGTERM]
 */
void blockSigContrl(sigset_t blockMask)
{
    if(sigemptyset(&blockMask) == -1 ||
        sigaddset(&blockMask,SIGINT) == -1 ||
        sigaddset(&blockMask,SIGTSTP) == -1 ||
        sigaddset(&blockMask,SIGCONT) == -1 ||
        sigaddset(&blockMask,SIGQUIT) == -1 )    printf("Failed to initialize the signal set\n");
    else if(sigprocmask(SIG_BLOCK,&blockMask,NULL) == -1 )  printf("Failed to block SIGTERM\n");
}

/**
 * [externCMD Função que executa um comando externo]
 * @param pl      [Lista de processos]
 * @nameProcess	  [Nome do processo a ser criado]
 * @param command [Comando a ser executado]
 * @param act     [Estrutura contendo a máscara de sinais a serem bloqueados]
 * @param isBG    [Constante inteira para saber se um comando deve ser executado como back ground]
 * @param groupIDBG [Endereço do valor que armazena o groupID dos processos de background]
 */
void externCMD(ProcessList** pl,char *nameProcess,char **command,const int isBG, pid_t *groupIDBG)
{
	int pid = fork();
	if(pid < 0)	// VERIFICANDO SE O FORK FOI BEM SUCEDIDO!
	{
		printf("***ERROR: forking child process failed\n");
		exit(1);
	}else if(pid == 0) // TRATAMENTO NO FILHO
    {
        sigset_t blockMask; // MÁSCARA DE SINAIS A SER TRATADA

    	if(nice(19) == -1) printf("Failed to initilize the priority set\n"); // INSERINDO MENOR PRIORIDADE POSSÍVEL NO PROCESSO CRIADO E VERIFICANDO SE HOUVE ERRO!
        if(signal(SIGTERM,SIG_IGN) == SIG_ERR) printf("***ERROR: Ignore SIGTERM failed\n"); // IGNORANDO SINAL SIGTERM PARA OS FILHOS COMO PRESENTE POR SUA BAIXA PRIORIDADE!

        if(!isBG)
        {    // EXECUTANDO PROCESSO EM MODO FOREGROUND
            if(execvp(nameProcess,command) == -1) // REALIZANDO O EXEC E VERIFICANDO SE É BEM SUCEDIDO
            	printf("***ERROR: execvp failed\n");
            exit(1);
        }else
        {   // EXECUTANDO PROCESSO EM MODO BACKGROUND
        	blockSigContrl(blockMask);     // BLOQUEANDO SINAIS CONTROL + * PARA OS PROCESSOS BACKGROUND
          
            if(*groupIDBG == 0)  *groupIDBG = getpid();   // DEFININDO ID DO GRUPO DE BACKGROUND
            if(setpgid(getpid(),*groupIDBG) == -1) printf("***ERROR: Set group background failed\n");   // ALTERANDO O GRUPO DO PROCESSO DE FOREGROUND PARA BACKGROUND

            if(execvp(nameProcess,command) == -1)   // REALIZANDO O EXEC E VERIFICANDO SE É BEM SUCEDIDO
            	printf("***ERROR: execvp failed\n");
            exit(1);
        }

    }else
        if(!isBG)
        {
            // NÃO PERMITINDO SINAIS CTRL ENQUANTO AGUARDA O PROCESSO FOREGROUND EXECUTAR
            signal(SIGINT,SIG_IGN);
            signal(SIGTSTP,SIG_IGN);
            signal(SIGQUIT,SIG_IGN);  
            if(waitpid(pid,NULL,0) == -1 ) printf("***ERROR: Wait failed");
        } // VERIFICANDO SE O PAI DEVE OU NÃO ESPERAR PELO TÉRMINO DO PROCESSO FILHO
        else
        {
          addProcess(pl,pid); // ADICIONANDO PROCESSO BACKGROUND NA LISTA DE PROCESSOS
          if(*groupIDBG == 0)  *groupIDBG = pid;
        }   // DEFININDO ID DO GRUPO DE BACKGROUND PARA RETORNAR COM O PAI
}
