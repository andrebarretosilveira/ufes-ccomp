#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "listInt.h"
#include "skewHeap.h"

void createFileJobs(int qtdJobs)
{
		int tempo,penalidade,multa;
		FILE *arq = fopen("jobs.txt","w");

		int i;
		srand( (unsigned)time(NULL) );

		for(i = 0; i < qtdJobs; i++)
		{
			tempo = rand()%qtdJobs+1;
			penalidade = tempo + rand()%qtdJobs + 1;
			multa = rand()%10+1; 
			fprintf(arq,"%d %d %d\n",tempo,penalidade,multa);
		}
		
		fclose(arq);
}

int main(int argc, char** argv)
{
	typeList *new;
	new = createList();
	if(argc == 2)
	{
		int qtdJobs = atoi(argv[1]);
		createFileJobs(qtdJobs);
	}
	else
	{
		fprintf(stdout, "Usage: %s [Quantidade de jobs que deseja gerar]\n", argv[0]);
	}

	return 0;
}