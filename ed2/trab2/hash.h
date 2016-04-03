/**
 * - CABEÇALHO HASH -
 * ASSINATURAS DAS FUNÇOES PARA MANIPULAÇAO DE HASH TABLES
 * @LAST-UPDATE 11-10-2015
 */

#ifndef HASH_H
#define HASH_H

/* Geradora de Chaves para a tabela HASH */
int hashKey(char *, const int );

/* Geradora de chaves 2 para a tabela HASH */
int hashKey2(char *, const int );

/* Cria a Hash Table */
void createHashTb(wordList ***, const int );

/* Inserir palavras na Hash de modo Encadeado */
void insertHashE(wordList **, tpWord *, int );

/* Funçao que imprimi a hash encadeada */
void printHashE(wordList **, const int );

/* Inserir palavras na Hash de modo linear */
void insertHashL(wordList **, tpWord *, int , const int );

/* Inserir palavras na Hash de modo duplo */
void insertHashR(wordList **, tpWord *, int , int ,const int );

/* Gerar tamanho ideal para Hash */
int gerarSizeHash(wordList *);

/* Exportando tabela hash encadeada para um arquivo */
void hashExportE(wordList **,const int, char * );

/* Exportando tabela Hash Linear ou ReHashing */
void hashExportLR(wordList **,const int ,char, char * );

/* Popula a hash com uma lista de palavras */
void fillHash(wordList **, wordList *, const int , char );

/* RECONSTRUINDO A TABELA HASH APARTIR DE UM ARQUIVO */
int hashImport(wordList ***, char *);

/* VERIFICA QUANTIDADE DE ESPAÇOS ESTAO PREENCHIDOS NA HASH */
int sizeOccupating(wordList **, const int );

/* LIBERANDO MEMORIA ALOCADA PARA A TABELA HASH */
void freeHash(wordList **, int );

/* Inserindo palavra na tabela hash */
void insertWordHash(tpWord *, wordList** );

/* REALIZANDO QUERIES */
void buscaHash(char ,char * ,char *);

/** BUSCA NA HASH TIPO R */
wordList* searchHashR(wordList **,int ,char *);

/** BUSCA NA HASH TIPO L */
wordList* searchHashL(wordList **,int ,char *);

/** Busca na hash tipo E */
wordList* searchHashE(wordList *,char *);

/** REALIZA A BUSCA DE VÁRIAS PALAVRAS NO MESMO DOCUMENTO */
documentList* searchHashLine(wordList **,int , char *, char );

/** SELECIONANDO TIPO DE HASH A SE BUSCAR */
wordList* searchType(wordList **, char *,char , int );

/** BUSCANDO FRASES EM UM DOCUMENTO */
documentList *searchHashAsp(wordList **,int , char *, char );

/** CONFERINDO SE UMA PALAVRA É SEGUIDO DE OUTRA EM UM DOCUMENTO */
int checkPosition(documentList *, documentList *);



#endif
