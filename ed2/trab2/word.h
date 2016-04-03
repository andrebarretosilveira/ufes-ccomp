/**
 * - CABEÇALHO WORD -
 * DEFINIÇAO DE ESTRUTURAS E ASSINATURAS DAS FUNÇOES
 * @LAST-UPDATE 11-10-2015
 */

#ifndef WORD_H   
#define WORD_H   

/* DEFININDO STRUCT WORDLIST COMO WORDLIST */
typedef struct wordList wordList;

/* DEFININDO STRUCT DOCUMENT LIST COMO DOCUMENTLIST */
typedef struct documentList documentList;

/* DEFININDO STRUCT WORD COMO TPWORD */
typedef struct word tpWord;

/* DEFININDO STRUCT POSLIT COMO POSLIST */
typedef struct posList posList;

/*	ESTRUTURA PARA ARMAZENAR LISTA DE POSIÇOES E DOCUMENTOS DAS PALAVRAS */
struct documentList
{
	posList *pos;
	char *document;
	documentList *prox;
};

/* ESTRUTURA PARA ARMAZENAR AS POSIÇÕES DAS PALAVRAS */
struct posList
{
	int pos;
	posList *prox;
};

/*	ESTRUTURA PARA A LISTA DE PALAVRAS A SEREM ARMAZENADAS */
struct wordList
{
	tpWord *word;
	wordList *prox;
};

/*	ESTRUTURA PALAVRA */
struct word
{
	char *string;
	int qtdWord;
	documentList *documents;
};

/*	INSERE UMA TPWORD NUMA LISTA DE WORDS */
void insert_tpWord(wordList **list, tpWord *word);

/*	INICIALIZA UMA PALAVRA APENAS COM A STRING */
tpWord *inicializaWord(char *word);

/*	CRIA UMA PALAVRA */
tpWord *criaWord(char *, char *, int );

/*	FUNÇAO QUE INSERE O DOCUMENTO E A POSICAO NA LISTA DE DOCUMENTOS */
void insertDocument(documentList **,char *, int );

/*	IMPRIMI LISTA DE DOCUMENTOS ARMAZENADAS NA PALAVRA */
void printDocumentList(documentList *);

/*	FUNÇAO RESPONSAVEL POR INSERIR PALAVRAS EM UMA LISTA DE PALAVRAS */
void insertWord(char *, wordList **,char *, int );

/*	IMPRIMI LISTA DE PALAVRAS ARMAZENADAS NA LISTA DE PALAVRAS */
void printWordList(wordList *);

/*	VERIFICAR QUANTIDADE DE PALAVRAS DISTINTAS */
int sizeList(wordList *);

/*	LIBERAR DA MEMORIA LISTA DE DOCUMENTOS */
void freeDocList(documentList **);

/*	LIBERAR DA MEMORIA LISTA DE PALAVRAS */
void freeWList(wordList **);

/*	LIBERAR DA MEMORIA UMA PALAVRA */
void freeWord(tpWord *);

/*	ENCONTRAR O MENOR NUMERO PRIMO MAIOR OU IGUAL A N */
int geraPrimo (int );

/* VERIFICAR QUANTIDADE DE DOCUMENTOS */
int sizeDocList(documentList *);

/* LIBERAR DA MEMORIA LISTA DE POSIÇÕES */
void freePosList(posList **);

/* VERIFICAR QUANTIDADE DE POSIÇÕES */
int sizePosList(posList *);
 
/* IMPRIMI LISTA DE POSIÇÕES ARMAZENADA EM UM DOCUMENTO */
void printPosList(posList *);

/* INSERINDO POSIÇÃO NA LISTA DE POSIÇÕES */
void insertPos(posList **,int );

/* INSERÇÃO DE DOCUMENTOS PARA BUSCA */
void insertDocumentSearch(documentList **,char *);

/* REMOVE UM DOCUMENTO DA LISTA DE DOCUMENTOS */
void removeDocument(documentList **, char *);

/* PESQUISA DOCUMENTO */
documentList *searchDocument(documentList *listDoc, char *document);




#endif
