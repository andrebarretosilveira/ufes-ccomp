/**
 * Gerador de sequências inteiras
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#define MAX 1000000

int main(int argc, char** argv)
{
    int i, num;

	if(argc != 3) {
		printf("Sintaxe: ./gera [Tipo] [Quantidade de números]\n");
        return 0;
    }

    int n = atoi(argv[2]);
    srand( (unsigned)time(NULL) );

    /* Gerar em ordem aleatória */
	if(!strcmp(argv[1], "-a"))
    {
        for(i = 0; i < n; i++) {
            num = rand()%n;
            printf("%d\n", num);
        }
	}

    /* Gerar em ordem crescente */
    else if(!strcmp(argv[1], "-c"))
    {
        num = rand()%5;
        printf("%d\n", num);

        for(i = 1; i < n; i++) {
            num += rand()%3;
            if(num >= MAX)
                printf("%d\n", MAX);
            else
                printf("%d\n", num);
        }
    }

    /* Gerar em ordem decrescente */
    else if(!strcmp(argv[1], "-d"))
    {
        int dec;

        num = (MAX - 5) + rand()%5;
        printf("%d\n", num);

        for(i = 1; i < n; i++) {
            dec = rand()%3;
            num -= dec;
            if(num <= 0)
                printf("0\n");
            else
                printf("%d\n", num);
        }
    }
    else
        printf("Opcao '%s' inexistente\n", argv[1]);

	return 0;
}
