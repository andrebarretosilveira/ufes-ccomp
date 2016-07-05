#include <stdio.h>
#include <stdlib.h>
#include "trataStr.h"
#include "comandosInternos.h"
#include "comandosExternos.h"

#define BUFFER 1000
#define TRUE 1
#define FALSE 0

int main() {
	char **argv;
	char *entry;
	char *path;
	int bg;
	struct sigaction act;
    pid_t groupIDBG = 0;
    ProcessList *pl;

    pl = newProcessList();
    entry = malloc((BUFFER+1)*sizeof(char));

	while(TRUE)
    {
        catchSignal(act);
		printf("nsh> ");
		scanf("%[^\n]s", entry);
        setbuf(stdin, NULL);

        // Evita erro de executar um programa junto ao CTRL-C
		if(strcmp(entry, "") == 0)
            continue;

        // Sair da nsh após dar kill nos filhos
		if(strcmp(entry, "exit") == 0) {
            free(entry);
            exitShell(&pl);
        }

        // Liberar os filhos zumbis
        else if(strcmp(entry, "wait") == 0) {
            waitZombies(&pl);
            printf("Nao existem mais processos zumbis\n");
        }

        // Aumentar a prioridade dos processo filhos
        else if(strcmp(entry, "burst") == 0) {
            burstFilhos(&pl);
        }

        // Executa um comando externo
        else {
        	argv = getArgv(entry, &bg, &path);
        	externCMD(&pl, path, argv, bg, &groupIDBG);
        	free(path);
        	liberarArgv(argv);
        }

        // Garante programa vazio para verificar (ver acima)
        strcpy(entry, "");

        // Se não existe programas no grupo background
        // Então resete o id do grupo
        if(!sizeList(pl)) groupIDBG = 0;
	}

    return 0;
}
