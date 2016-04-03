/**
 * FUNÇÕES PARA O PRÉ PROCESSAMENTO DAS ENTRADAS
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include <wchar.h>
#include <wctype.h>
#include "preProcess.h"

#define BUFFER 100

/**
 * [removeAccent - Remove acento de um char]
 * @param  c    [caractér a ser avaliado]
 */
void removeAccent(wchar_t *c) {
	switch (*c) {
		case L'á': *c=L'a'; break;
		case L'à': *c=L'a'; break;
		case L'ã': *c=L'a'; break;
        case L'â': *c=L'a'; break;
		case L'é': *c=L'e'; break;
		case L'ê': *c=L'e'; break;
		case L'í': *c=L'i'; break;
        case L'î': *c=L'i'; break;
		case L'ó': *c=L'o'; break;
        case L'ô': *c=L'o'; break;
        case L'õ': *c=L'o'; break;
		case L'ú': *c=L'u'; break;
		case L'ü': *c=L'u'; break;
		case L'ç': *c=L'c'; break;

	}
}

/**
 * [removeAccentWord - Remove acentos de uma palavra]
 * @param  word    [palavra a ser processada]
 */
void removeAccentWord(wchar_t *word) {
    while(*word) {
        removeAccent(word);
        word++;
    }
}

/**
 * [clearWord - "limpa uma palavra", deixando apenas letras minúsculas sem acentos]
 * @param  p    	[palavra em wchar_t* a ser processada]
 * @param palavra	[palavra em char* onde será armazenada a conversão]
 */
void clearWord(char* palavra, wchar_t *p) {
    wchar_t *src = p, *dst = p;

    while(*src) {
        if(iswpunct((unsigned char)*src)) {
            /* Ignora este char (pontuação) */
            src++;
        }
        else {
            if(iswupper((unsigned char)*src)) {
                /* Converte para minúsculo */
                *src = towlower((unsigned char)*src);
            }
			removeAccent(src);
            /* Copia o char */
            *dst++ = *src++;
        }
    }
    *dst = 0;
    wcstombs(palavra, p, BUFFER);
}

/**
 * [processDoc - Processa um documento, chamando 'clearWord' p/ cada palavra e as armazena numa lista]
 * @param  docName	[nome do documento]
 * @param  list		[lista a armazenar as palavras]
 */
void processDoc(FILE *fin, char* docName, wordList **list) {
    wchar_t *palavra = malloc(BUFFER*sizeof(wchar_t));
    char *word = malloc(BUFFER*sizeof(char));
    int count = 0;

    while(fscanf(fin, "%ls", palavra) != EOF) {
        count++;
        clearWord(word, palavra);
		if(strcmp(word, "") != 0)
			insertWord(word, list, docName, count);
    }
	free(word);
    free(palavra);
}
