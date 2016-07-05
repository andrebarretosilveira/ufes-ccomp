/**
 *
 * Tratador de Strings de Entrada
 *
 * Implementação das funções de tratamento de string da Nice Shell (nsh)
 * 
 */
 
#include "trataStr.h"

/* Função auxiliar de separação de strings em tokens
 * @param str [String de Entrada]
 * @param delim [String Delimitadora]
 * @return tokens [String dividida em tokens]
 */
char **tokenizer(char *str, char* delim) {
	char **tokens;
	char *token;
	int i, n;
	
	tokens = (char**) calloc(MAX_TOKENS, sizeof(char*));
	
	for(i = 0; i < MAX_TOKENS; i++)
		tokens[i] = NULL;
		
	i = 0;
	token = strtok(str, delim);
	
	while(token != NULL) {
		n = strlen(token);
		tokens[i] = (char*) calloc(n+1, sizeof(char));
		strcpy(tokens[i], token);
		token = strtok(NULL, delim);
		i++;
	}
	
	return tokens;
}

/* Função que obtém os argumentos de linha de comando, o "@" e o path 
 * dos executáveis
 * @param str [String de Entrada]
 * @param bg [Parâmetro de saída para sinalização de background]
 * @param path [Parâmetro de saída para o path dos executáveis]
 * @return argv [Vetor de argumentos de linha de comando]
 */
char **getArgv(char *str, int *bg, char **path) {
	int i, n, last;
	char **tokens = tokenizer(str, " ");
	char **argv = (char**) calloc(MAX_TOKENS, sizeof(char*));
	
	for(i = 0; i < MAX_TOKENS; i++)
		argv[i] = NULL;
	
	// Obtendo path
	n = strlen(tokens[0]);
	*path = (char*) calloc(n+1, sizeof(char));
	strcpy(*path, tokens[0]);
	
	// Primeiro argumento: nome do programa
	argv[0] = getProgram(tokens[0]);
	
	// Argumentos de linha de comando
	for(i = 1; i < MAX_TOKENS; i++) {
		if(tokens[i] == NULL)
			break;
	
		n = strlen(tokens[i]);
		argv[i] = (char*) calloc(n+1, sizeof(char));
		strcpy(argv[i], tokens[i]);
	}
	
	i = MAX_TOKENS - 1;
	while(argv[i] == NULL)
		i--;
		
	// Última posição preenchida em argv
	last = i;
	
	// Verifica se o processo será ou não de background
	if(strcmp(argv[last], "@") == 0) {
	    free(argv[last]);
		argv[last] = NULL;
		*bg = 1; // TRUE
	}
	else {
		*bg = 0; // FALSE
	}
	
	for(i = 0; i < MAX_TOKENS; i++)
		if(tokens[i] != NULL)
			free(tokens[i]);
	free(tokens);
	
	return argv;
}

/* Função auxiliar que obtém o argv[0] (nome do programa)
 * @param path [Path do programa a ser descoberto o nome]
 * @return program [Nome do programa]
 */
char *getProgram(char *path) {
	char *program;
	int i, j, tam, n = strlen(path);
	
	for(i = n-1; i >= 0; i--)
		if(path[i] == '/')
			break;
		
	tam = n-i-1;
	program = (char*) calloc(tam+1, sizeof(char));
	
	for(j = i+1; j < n; j++) {
		program[j-i-1] = path[j];
	}
	return program;
}

// Função que libera a memória alocada para o vetor de argumentos
void liberarArgv(char **argv) {
	int i = 0;
	while(argv[i] != NULL) {
		free(argv[i]);
		i++;
	}
	free(argv);
}


