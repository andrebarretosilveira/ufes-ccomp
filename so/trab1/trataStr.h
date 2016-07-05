/**
 *
 * Tratador de Strings de Entrada
 *
 * Declaração das funções de tratamento de string da Nice Shell (nsh)
 * 
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAX_TOKENS 7

/* Função auxiliar de separação de strings em tokens
 * @param str [String de Entrada]
 * @param delim [String Delimitadora]
 * @return tokens [String dividida em tokens]
 */
char **tokenizer(char *str, char *delim);

/* Função que obtém os argumentos de linha de comando, o "@" e o path 
 * dos executáveis
 * @param str [String de Entrada]
 * @param bg [Parâmetro de saída para sinalização de background]
 * @param path [Parâmetro de saída para o path dos executáveis]
 * @return argv [Vetor de argumentos de linha de comando]
 */
char **getArgv(char *str, int *bg, char **path);

/* Função auxiliar que obtém o argv[0] (nome do programa)
 * @param path [Path do programa a ser descoberto o nome]
 * @return program [Nome do programa]
 */
char *getProgram(char *path);

// Função que libera a memória alocada para o vetor de argumentos
void liberarArgv(char **argv);


