/**
 * CLASSE PRINCIPAL
 * @LAST-UPDATE 11-10-2015
 */

 #include <stdio.h>
 #include <stdlib.h>
 #include <string.h>
 #include <locale.h>
 #include "word.h"
 #include "hash.h"
 #include "preProcess.h"
 #include "arvoreB.h"

 #define BUFFER 100

int main(int argc, char **argv) {
    FILE *fin, *fin2, *fout;
    wordList **hashTable = NULL;
    wordList *list = NULL;
    ArvoreB *arvB = NULL;
    int t;

    if(argc != 5) {
        printf("Sintaxe:\n./trab2 -i [tipoModelo] [entradaDocs] [indiceGerado]\n./trab2 -b [tipoModelo] [indice] [arquivoBuscas]\n");
        exit(1);
    }

    setlocale(LC_ALL, "");

    /** MODULO INDEX **/
    if(strcmp(argv[1], "-i") == 0) {

        // Abrindo arquivos de entrada
        fin = fopen(argv[3], "r");
        if(fin == NULL) {
            printf("Erro ao abrir arquivo \"%s\". Programa abortado.\n", argv[3]);
            exit(1);
        }
        char *docName = malloc(BUFFER*sizeof(char));
        while(fscanf(fin, "%s", docName) != EOF) {
            // Abrindo arquivos a serem processados
            fin2 = fopen(docName, "r");
            if(fin2 == NULL) {
                printf("Erro ao abrir arquivo \"%s\". Programa abortado.\n", docName);
                fclose(fin);
                free(docName);
                freeWList(&list);
                exit(1);
            }
            processDoc(fin2, docName, &list);
            fclose(fin2);
        }
        fclose(fin);
        free(docName);

        // Abrindo arquivo de saída
        fout = fopen(argv[4], "w");
        if(fin == NULL) {
            printf("Erro ao criar arquivo \"%s\". Programa abortado.\n", argv[4]);
            exit(1);
        }

        if(strcmp(argv[2], "B") == 0) {
            // Arvore B
            fillArvB(&arvB, list);
            geraIndex(arvB, fout);
        }
        else {
            t = gerarSizeHash(list);
            createHashTb(&hashTable,t);

            if(strcmp(argv[2], "E") == 0) {
                // Hash com encadeamento
                fillHash(hashTable,list,t,'E');
                hashExportE(hashTable,t,argv[4]);
            }
            else if(strcmp(argv[2], "L") == 0) {
                // Hash linear
                fillHash(hashTable,list,t,'L');
                hashExportLR(hashTable,t,'L',argv[4]);
            }
            else if(strcmp(argv[2], "R") == 0) {
                // Hash por rehashing
                fillHash(hashTable,list,t,'R');
                hashExportLR(hashTable,t,'R',argv[4]);
            }
            else
                printf("Modelo \"%s\" inexistente.\n", argv[2]);

            freeHash(hashTable,t);
        }

        fclose(fout);
        freeArvB(arvB);
        freeWList(&list);
    }

    /** MODULO BUSCA **/
    else if(strcmp(argv[1], "-b") == 0) {

        fin = fopen(argv[3], "r");
        if(fin == NULL) {
            printf("Erro ao abrir arquivo \"%s\". Programa abortado.\n", argv[3]);
            exit(1);
        }

        // Ler arquivo e recriar a estrutura
        if(strcmp(argv[2], "E") == 0) {
            // Hash com encadeamento
            buscaHash('E',argv[3],argv[4]);
        }
        else if(strcmp(argv[2], "L") == 0) {
            // Hash linear
            buscaHash('L',argv[3],argv[4]);
        }
        else if(strcmp(argv[2], "R") == 0) {
            // Hash por rehashing
			buscaHash('R',argv[3],argv[4]);
        }
        else if(strcmp(argv[2], "B") == 0) {
            // Arvore B
            importArvB(&arvB, fin);
            fclose(fin);
            fin = fopen(argv[4], "r");
            if(fin == NULL) {
                printf("Erro ao abrir arquivo \"%s\". Programa abortado.\n", argv[4]);
                exit(1);
            }
            buscaArvB(arvB, fin);
            freeArvB(arvB);
        }
        else
            printf("Modelo \"%s\" inexistente.\n", argv[2]);

        fclose(fin);
    }

    /** MODULO INEXISTENTE **/
    else {
        printf("Modulo \"%s\" incorreto. Opcoes: '-i' ou '-b'\n", argv[1]);
    }

    return 0;
}
