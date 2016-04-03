/**
 * - CABEÇALHO PRE_PROCESS
 * ASSINATURAS DAS FUNÇÕES PARA O PRÉ PROCESSAMENTO DAS ENTRADAS
 */

#ifndef PREPROCESS_H
#define PREPROCESS_H

#include "word.h"

/* Remove o acento de um char */
void removeAccent(wchar_t *c);

/* Remove os acentos de uma string */
void removeAccentWord(wchar_t *word);

/* Remove de uma palavra de pontuações e acentos */
void clearWord(char *palavra, wchar_t *p);

/* Processa um documento, limpando as palavras */
void processDoc(FILE *fin, char *docName, wordList **list);

#endif
