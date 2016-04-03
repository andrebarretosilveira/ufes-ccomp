#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "lista.h"

// Ler uma linha de um entrada
char *LerLinha(FILE *file);
// Separar os argumentos do comando (nao esta funfando)
int SepararArgumento(char *comando, char **tipo, char **operacao, char **arg1, char **arg2, char **arg3, char **arg4, char **arg5, char **arg6);
// Da free nos argumentos
void LiberarArgumentos(int num_arg, char *tipo, char *operacao, char *arg1, char *arg2, char *arg3, char *arg4, char *arg5, char *arg6);

int main() {
        int num_arg, idb, idr, idc, id_cons, num;
        float x, consumo;
        char *comando = NULL, *tipo = NULL , *operacao = NULL, *arg1 = NULL, *arg2 = NULL;
        char *arg3 = NULL, *arg4 = NULL, *arg5 = NULL, *arg6 = NULL;
        char txt[40];
        FILE *entrada = NULL, *saida = NULL;

        printf("Digite o nome do arquivo de entrada: ");
        scanf("%s", txt);

        entrada = fopen(txt, "r");
        if(entrada == NULL) {
                printf("ERRO ao abrir o arquivo de entrada.\n");
                return 1;
        }
        saida = fopen("saida.txt", "w");
        if(saida == NULL) {
                printf("ERRO ao abrir o arquivo de saida.\n");
                return 1;
        }

        tcidade *Cidade = CriaCidade();
        IncluirBairro(Cidade, 13, "Praia de Itaparica");
        IncluirBairro(Cidade, 17, "Itapoa");

        while(!feof(entrada)) {
                comando = LerLinha(entrada);
                if(comando[0] != '\0') {
                        // Analise dos argumentos e utilizacao das funcoes
                        num_arg = SepararArgumento(comando, &tipo, &operacao, &arg1, &arg2, &arg3, &arg4, &arg5, &arg6);
                        if(strcmp(tipo, "cidade") == 0) {
                                if(strcmp(operacao, "medir") == 0) {
                                        if(num_arg != 2)
                                                fprintf(saida, "ERRO: numero de argumentos incorreto para '%s %s'\n", operacao, tipo);
                                        else {
                                                x = MedirCidade(Cidade);
                                                fprintf(saida, "Consumo da Cidade = %.2f\n", x);
                                        }
                                }
                                else
                                        fprintf(saida, "ERRO: operacao \"%s\" incorreta para o tipo \"%s\"\n", operacao, tipo);
                        }
                        else if(strcmp(tipo, "bairro") == 0) {
                                if(strcmp(operacao, "medir") == 0) {
                                        if(num_arg != 3)
                                                fprintf(saida, "ERRO: numero de argumentos incorreto para '%s %s'\n", operacao, tipo);
                                        else {
                                                idb = atoi(arg1);
                                                if(idb == 0)
                                                        fprintf(saida, "ERRO: id \"%s\" invalido. Comando: '%s'\n", arg1, comando);
                                                else {
                                                        x = MedirBairro(Cidade, idb);
                                                        if(x < 0)
                                                                fprintf(saida, "ERRO: Bairro id=%d nao encontrado. Comando: '%s'\n", idb, comando);
                                                        else 
                                                                fprintf(saida, "Consumo do Bairro = %.2f (Bairro id=%d)\n", x, idb);
                                                }
                                        }
                                }
                                else
                                        fprintf(saida, "ERRO: operacao \"%s\" incorreta para o tipo \"%s\".\n", operacao, tipo);
                        }
                        else if(strcmp(tipo, "rua") == 0) {
                                if(strcmp(operacao, "medir") == 0) {
                                        if(num_arg != 4)
                                                fprintf(saida, "ERRO: numero de argumentos incorreto para '%s %s'\n", operacao, tipo);
                                        else {
                                                idb = atoi(arg1);
                                                idr = atoi(arg2);
                                                if(idb == 0)
                                                        fprintf(saida, "ERRO: id \"%s\" invalido. Comando: %s\n", arg1, comando);
                                                else if(idr == 0)
                                                        fprintf(saida, "ERRO: id \"%s\" invalido. Comando: %s\n", arg2, comando);
                                                else {
                                                        x = MedirRua(Cidade, idb, idr);
                                                        if(x < 0)
                                                                fprintf(saida, "ERRO: Consumo da Rua nao pode ser calculado. (Rua id=%d, Bairro id=%d)\n", idr, idb);
                                                        else 
                                                                fprintf(saida, "Consumo da Rua = %.2f (Rua id=%d, Bairro id=%d)\n", x, idr, idb);
                                                }
                                        }
                                }
                                else if(strcmp(operacao, "incluir") == 0) {
                                        if(num_arg != 5)
                                                fprintf(saida, "ERRO: numero de argumentos incorreto para '%s %s'\n", operacao, tipo);
                                        else {
                                                idb = atoi(arg1);
                                                idr = atoi(arg2);
                                                if(idb == 0)
                                                        fprintf(saida, "ERRO: id \"%s\" invalido. Comando: '%s'\n", arg1, comando);
                                                else if(idr == 0)
                                                        fprintf(saida, "ERRO: id \"%s\" invalido. Comando: '%s'\n", arg2, comando);
                                                else {
                                                        if(IncluirRua(Cidade, idb, idr, arg2))
                                                                fprintf(saida, "ERRO: Rua nao incluida. (Rua id=%d, Bairro id=%d) \n", idr, idb);
                                                        else 
                                                                fprintf(saida, "Rua '%s' id=%d incluida com sucesso no bairro id=%d\n", arg3, idr, idb);
                                                }
                                        }
                                }
                                else if(strcmp(operacao, "eliminar") == 0) {
                                        if(num_arg != 4)
                                                fprintf(saida, "ERRO: numero de argumentos incorreto para '%s %s'\n", operacao, tipo);
                                        else {
                                                idb = atoi(arg1);
                                                idr = atoi(arg2);
                                                if(idb == 0)
                                                        fprintf(saida, "ERRO: id \"%s\" invalido. Comando: '%s'\n", arg1, comando);
                                                else if(idr == 0)
                                                        fprintf(saida, "ERRO: id \"%s\" invalido. Comando: '%s'\n", arg2, comando);
                                                else {
                                                        if(EliminarRua(Cidade, idb, idr))
                                                                fprintf(saida, "ERRO: Rua nao removida. (Rua id=%d, Bairro id=%d)\n", idr, idb);
                                                        else 
                                                                fprintf(saida, "Rua id=%d removida com sucesso do bairro id=%d\n", idr, idb);
                                                }
                                        }
                                }
                                else
                                        fprintf(saida, "ERRO: operacao \"%s\" incorreta para o tipo \"%s\".\n", operacao, tipo);
                        }
                        else if(strcmp(tipo, "casa") == 0) {
                                if(strcmp(operacao, "medir") == 0) {
                                        if(num_arg != 5)
                                                fprintf(saida, "ERRO: numero de argumentos incorreto para '%s %s'\n", operacao, tipo);
                                        else {
                                                idb = atoi(arg1);
                                                idr = atoi(arg2);
                                                idc = atoi(arg3);
                                                if(idb == 0)
                                                        fprintf(saida, "ERRO: id \"%s\" invalido. Comando: '%s'\n", arg1, comando);
                                                else if(idr == 0)
                                                        fprintf(saida, "ERRO: id \"%s\" invalido. Comando: '%s'\n", arg2, comando);
                                                else if(idc == 0)
                                                        fprintf(saida, "ERRO: id \"%s\" invalido. Comando: '%s'\n", arg2, comando);
                                                else {
                                                        x = MedirCasa(Cidade, idb, idr, idc);
                                                        if(x < 0)
                                                                fprintf(saida, "ERRO: Consumo da Casa nao pode ser calculado. (Casa id=%d, Rua id=%d, Bairro id=%d)\n", idc, idr, idb);
                                                        else 
                                                                fprintf(saida, "Consumo da Casa = %.2f (Casa id=%d, Rua id=%d, Bairro id=%d)\n", x, idc, idr, idb);
                                                }
                                        }
                                }
                                else if(strcmp(operacao, "consumir") == 0) {
                                        if(num_arg != 6)
                                                fprintf(saida, "ERRO: numero de argumentos incorreto para '%s %s'\n", operacao, tipo);
                                        else {
                                                idb = atoi(arg1);
                                                idr = atoi(arg2);
                                                idc = atoi(arg3);
                                                consumo = strtof(arg4, NULL);
                                                if(idb == 0)
                                                        fprintf(saida, "ERRO: id \"%s\" invalido. Comando: '%s'\n", arg1, comando);
                                                else if(idr == 0)
                                                        fprintf(saida, "ERRO: id \"%s\" invalido. Comando: '%s'\n", arg2, comando);
                                                else if(idc == 0)
                                                        fprintf(saida, "ERRO: id \"%s\" invalido. Comando: '%s'\n", arg3, comando);
                                                else if(consumo == 0)
                                                        fprintf(saida, "ERRO: consumo \"%s\" invalido. Comando: '%s'\n", arg4, comando);
                                                else {
                                                        if(Consumir(Cidade, idb, idr, idc, consumo))
                                                                fprintf(saida, "ERRO: Consumo nao atribuido a Casa. (Casa id=%d, Rua id=%d, Bairro id=%d)\n", idc, idr, idb);
                                                        else 
                                                                fprintf(saida, "Consumo %.2f atribuido a Casa id=%d, Rua id=%d, Bairro id=%d\n", consumo, idc, idr, idb);
                                                }
                                        }
                                }
                                else if(strcmp(operacao, "incluir") == 0) {
                                        if(num_arg != 8)
                                                fprintf(saida, "ERRO: numero de argumentos incorreto para '%s %s'\n", operacao, tipo);
                                        else {
                                                idb = atoi(arg1);
                                                idr = atoi(arg2);
                                                idc = atoi(arg3);
                                                id_cons = atoi(arg4);
                                                num = atoi(arg5);

                                                if(idb == 0)
                                                        fprintf(saida, "ERRO: id \"%s\" invalido. Comando: '%s'\n", arg1, comando);

                                                else if(idr == 0)
                                                        fprintf(saida, "ERRO: id \"%s\" invalido. Comando: '%s'\n", arg2, comando);

                                                else if(idc == 0)
                                                        fprintf(saida, "ERRO: id \"%s\" invalido. Comando: '%s'\n", arg3, comando);

                                                else if(id_cons == 0)
                                                        fprintf(saida, "ERRO: id \"%s\" invalido. Comando: '%s'\n", arg4, comando);

                                                else if(num == 0)
                                                        fprintf(saida, "ERRO: num \"%s\" invalido. Comando: '%s'\n", arg5, comando);

                                                else {
                                                        if(IncluirCasa(Cidade, idb, idr, idc, id_cons, num, arg6))
                                                                fprintf(saida, "ERRO: Casa nao incluida. (Casa id=%d, Rua id=%d, Bairro id=%d)\n", idc, idr, idb);
                                                        else
                                                                fprintf(saida, "Casa id=%d de '%s' incluida com sucesso na Rua id=%d do Bairro id=%d\n", idc, arg6, idr, idb);
                                                }
                                        }
                                }
                                else if(strcmp(operacao, "eliminar") == 0) {
                                        if(num_arg != 5)
                                                fprintf(saida, "ERRO: numero de argumentos incorreto para '%s %s'\n", operacao, tipo);
                                        else {
                                                idb = atoi(arg1);
                                                idr = atoi(arg2);
                                                idc = atoi(arg3);

                                                if(idb == 0)
                                                        fprintf(saida, "ERRO: id \"%s\" invalido. Comando: '%s'\n", arg1, comando);

                                                else if(idr == 0)
                                                        fprintf(saida, "ERRO: id \"%s\" invalido. Comando: '%s'\n", arg2, comando);

                                                else if(idc == 0)
                                                        fprintf(saida, "ERRO: id \"%s\" invalido. Comando: '%s'\n", arg3, comando);

                                                else {
                                                        if(EliminarCasa(Cidade, idb, idr, idc)) {
                                                                fprintf(saida, "ERRO: Casa nao removida. (Casa id=%d, Rua id=%d, Bairro id=%d)\n", idc, idr, idb);
                                                        }
                                                        else
                                                                fprintf(saida, "Casa id=%d removida com sucesso da Rua id=%d do Bairro id=%d\n", idc, idr, idc);
                                                }
                                        }
                                }
                                else
                                        fprintf(saida, "ERRO: operacao \"%s\" incorreta para o tipo \"%s\".\n", operacao, tipo);
                        }
                        else
                                fprintf(saida, "ERRO: tipo \"%s\" nao existe.\n", tipo);

                        LiberarArgumentos(num_arg, tipo, operacao, arg1, arg2, arg3, arg4, arg5, arg6);
                }
                free(comando);
        }
        printf("Arquivo 'saida.txt' criado.\n");
        fclose(entrada);
        fclose(saida);
        LiberarCidade(Cidade);
	return 0;
}

char *LerLinha(FILE *file) {
        int tam = 10, cont = 0;
        char *linha, ch;

        linha = (char*)malloc(tam);
        if (linha == NULL) {
                printf("Erro ao alocar espaco para linha.\n");
                exit(1);
        }

        ch = fgetc(file);
        while ((ch != '\n') && (ch != EOF)) {
                if (cont == tam) {
                        tam += tam;
                        linha = realloc(linha, tam);
                        if (linha == NULL) {
                                printf("Erro ao alocar espaco para linha.\n");
                                exit(1);
                        }
                }
                linha[cont] = ch;
                cont++;

                ch = fgetc(file);
        }
        linha[cont] = '\0';
        linha = realloc(linha, cont+1);
        return linha;
}

int SepararArgumento(char *comando, char **tipo, char **operacao, char **arg1, char **arg2, char **arg3, char **arg4, char **arg5, char **arg6) {
        int pos_comando = 0, pos_arg = 0, cont_arg = 0, tam = 100;
        char ch, arg[tam];

        for(ch = '?'; ch != '\0'; pos_comando++) {
                ch = comando[pos_comando];

                // Ler argumento entre aspas
                if(ch == '\"') {
                        for(pos_comando++, ch = comando[pos_comando]; ch != '\"' && ch != '\0'; pos_arg++) {
                                arg[pos_arg] = ch;
                                pos_comando++;
                                ch = comando[pos_comando];
                        }
                        if(ch != '\0') {
                                pos_comando++;
                                ch = comando[pos_comando];
                        }
                }
                // Separar argumento
                if(ch == ' ' || ch == '\0') {
                        // Verifica os espacos
                        if(pos_arg != 0) {
                                arg[pos_arg] = '\0';
                                switch(cont_arg) {
                                        case 0: {
                                                        *tipo = (char*)malloc(strlen(arg)+1);
                                                        strcpy(*tipo, arg);
                                                        break;
                                                }
                                        case 1: {
                                                        *operacao = (char*)malloc(strlen(arg)+1);
                                                        strcpy(*operacao, arg);
                                                        break;
                                                }
                                        case 2: {
                                                        *arg1 = (char*)malloc(strlen(arg)+1);
                                                        strcpy(*arg1, arg);
                                                        break;
                                                }
                                        case 3: {
                                                        *arg2 = (char*)malloc(strlen(arg)+1);
                                                        strcpy(*arg2, arg);
                                                        break;
                                                }
                                        case 4: {
                                                        *arg3 = (char*)malloc(strlen(arg)+1);
                                                        strcpy(*arg3, arg);
                                                        break;
                                                }
                                        case 5: {
                                                        *arg4 = (char*)malloc(strlen(arg)+1);
                                                        strcpy(*arg4, arg);
                                                        break;
                                                }
                                        case 6: {
                                                        *arg5 = (char*)malloc(strlen(arg)+1);
                                                        strcpy(*arg5, arg);
                                                        break;
                                                }
                                        case 7: {
                                                        *arg6 = (char*)malloc(strlen(arg)+1);
                                                        strcpy(*arg6, arg);
                                                        break;
                                                }
                                }
                                pos_arg = 0;
                                cont_arg++;
                        }
                }
                else {
                        arg[pos_arg] = ch;
                        pos_arg++;
                }
        }
        return cont_arg;
}

void LiberarArgumentos(int num_arg, char *tipo, char *operacao, char *arg1, char *arg2, char *arg3, char *arg4, char *arg5, char *arg6) {
        switch(num_arg) {
                case 8: free(arg6);
                case 7: free(arg5);
                case 6: free(arg4);
                case 5: free(arg3);
                case 4: free(arg2);
                case 3: free(arg1);
                case 2: free(operacao);
                case 1: free(tipo);
        }
}
