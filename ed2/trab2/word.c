/**
 * FUNÇÕES PARA A MANIPULAÇÃO DA ESTRUTURA PALAVRAS
 * @LAST-UPDATE 11-10-2015
 */
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "word.h"
#include <ctype.h>


/**
 * [insert_tpWord - FUNÇAO QUE INSERE tpWords EM UMA LISTA DE PALAVRAS]
 * @param list     [Endereço da lista de palavras na qual deseja inserir]
 * @param word     [Palavra que deseja inserir]
 */
void insert_tpWord(wordList **list, tpWord *word)
{
	wordList *atual = *list;
	wordList* ant = NULL;

	/* LOOP DE VERIFICAÇAO DE PALAVRAS IGUAIS */
	while( atual != NULL && strcmp(atual->word->string, word->string) < 0) {
		ant = atual;
		atual = atual->prox;
	}

    /* PALAVRA JÁ EXISTE */
	if(atual != NULL && strcmp(atual->word->string, word->string) == 0)
        return;

    if(ant == NULL)
	{
		/* ADICIONANDO PALAVRA NA LISTA DE PALAVRAS */
		wordList* new = malloc(sizeof(wordList));
        new->word = word;
		new->prox = *list;
		*list = new;
	}
    else {
        /* ADICIONANDO PALAVRA NA LISTA DE PALAVRAS */
        wordList* new = malloc(sizeof(wordList));
        new->word = word;
        new->prox = ant->prox;
        ant->prox = new;
    }
}

/**
 * [criaWord - FUNÇAO RESPONSAVEL POR CRIAR UMA PALAVRA]
 * @param word     [Palavra que deseja inserir]
 * @param document [Nome do documento que a palavra se encontra]
 * @param pos      [Posiçao da palavra no documento]
 */
tpWord *inicializaWord(char *word)
{
    tpWord *new;
    new = malloc(sizeof(tpWord));
    new->string = malloc((strlen(word) + 1) * sizeof(char));
    new->qtdWord = 1;
    new->documents = NULL;
    strcpy(new->string,word);

    return new;
}

/**
 * [criaWord - FUNÇAO RESPONSAVEL POR CRIAR UMA PALAVRA]
 * @param word     [Palavra que deseja inserir]
 * @param document [Nome do documento que a palavra se encontra]
 * @param pos      [Posiçao da palavra no documento]
 */
tpWord *criaWord(char *word, char *document, int pos)
{

    tpWord *new;
    new = malloc(sizeof(tpWord));
    new->string = malloc((strlen(word) + 1) * sizeof(char));
    new->qtdWord = 1;
    new->documents = NULL;
    strcpy(new->string,word);
    insertDocument(&new->documents,document,pos);

    return new;
}

/**
 * [insertWord - FUNÇAO RESPONSAVEL POR INSERIR PALAVRAS EM UMA LISTA DE PALAVRAS]
 * @param word     [Palavra que deseja inserir]
 * @param list     [Endereço da lista de palavras na qual deseja inserir]
 * @param document [Nome do documento que a palavra se encontra]
 * @param pos      [Posiçao da palavra no documento]
 */
void insertWord(char *word, wordList **list,char *document, int pos)
{
	wordList *atual = *list;
	wordList* ant = NULL;

	while( atual != NULL && strcmp(atual->word->string,word) < 0)
	{
		ant = atual;
		atual = atual->prox;
	}


	/** ------------------------- INSERÇÃO ORDENADA ------------------------------------------*/

	if(atual != NULL && strcmp(atual->word->string,word) == 0 )/* ADICIONANDO PALAVRA IGUAL NA LISTA DE DOCUMENTOS	*/
	{
		atual->word->qtdWord++;
		insertDocument(&atual->word->documents,document,pos);
    }else if(ant == NULL)
	{

		/* ADICIONANDO PALAVRA NA LISTA DE PALAVRAS */
		wordList* new = malloc(sizeof(wordList));
        new->word = criaWord(word, document, pos);
		new->prox = *list;
		*list = new;
	}else
		{

			/* ADICIONANDO PALAVRA NA LISTA DE PALAVRAS */
			wordList* new = malloc(sizeof(wordList));
	        new->word = criaWord(word, document, pos);
			new->prox = ant->prox;
			ant->prox = new;
		}

	//}
}

/**
 * [insertDocumentSearch - INSERÇÃO DE DOCUMENTOS PARA BUSCA]
 * @param listDoc  [Lista de documentos]
 * @param document [Documento que deseja inserir]
 */
void insertDocumentSearch(documentList **listDoc,char *document)
{
		documentList *atual = *listDoc;

		while( atual != NULL && strcmp(atual->document,document))
			atual = atual->prox;

		if(atual)
			return;
		else
		{
			documentList *new = malloc(sizeof(documentList));
			new->document = malloc((strlen(document)+1) * sizeof(char));
			new->pos = NULL;
			strcpy(new->document,document);
			new->prox = *listDoc;
			*listDoc = new;
		}
}


/**
 * [removeDocument - REMOVE UM DOCUMENTO DA LISTA DE DOCUMENTOS]
 * @param listDoc  [Lista de documentos]
 * @param document [Documento que deseja remover]
 */
void removeDocument(documentList **listDoc, char *document)
{
	documentList *ant = NULL;
	documentList *atual = *listDoc;

	while( atual != NULL && strcmp(atual->document,document))
	{
		ant = atual;
		atual = atual->prox;
	}

	if(atual == NULL)
	{
		return;
	}

	if(ant == NULL)
	{
		*listDoc = (*listDoc)->prox;
	}else
	{
		ant->prox = atual->prox;
	}

	free(atual->document);
	free(atual);

}

/**
 * [searchDocument - PESQUISA DOCUMENTO]
 * @param  listDoc  [Lista de documentos a ser pesquisada]
 * @param  document [Documento a ser procurado]
 * @return          [Documento encontrado]
 */
documentList *searchDocument(documentList *listDoc, char *document)
{
	documentList *atual = listDoc;

	while( atual != NULL && strcmp(atual->document,document))
	{
		atual = atual->prox;
	}

	return atual;
}
/**
 * [insertDocument - FUNÇAO QUE INSERE O DOCUMENTO E A POSICAO NA LISTA DE DOCUMENTOS]
 * @param listDoc  [Endereço da lista de documentos na qual deseja inserir]
 * @param document [Nome do documento que deseja inserir]
 * @param pos      [Posicao que se encontra a palavra no documento]
 */
void insertDocument(documentList **listDoc,char *document, int pos)
{

	documentList *atual = *listDoc;
	documentList *ant = NULL;


	while(atual != NULL && strcmp(atual->document,document) < 0)
	{
		ant = atual;
		atual = atual->prox;
	}

	/** ------------------------- INSERÇÃO ORDENADA ------------------------------------------*/

	if(atual != NULL && strcmp(atual->document,document) == 0)
	{
		insertPos(&atual->pos,pos);
	}else if(ant == NULL)
	{
		documentList *new = malloc(sizeof(documentList));
		new->document = malloc((strlen(document)+1) * sizeof(char));
		new->pos = NULL;
		strcpy(new->document,document);
		insertPos(&new->pos,pos);
		new->prox = *listDoc;
		*listDoc = new;
	}else
	{
		documentList *new = malloc(sizeof(documentList));
		new->document = malloc((strlen(document)+1) * sizeof(char));
		new->pos = NULL;
		strcpy(new->document,document);
		insertPos(&new->pos,pos);
		new->prox = ant->prox;
		ant->prox = new;

	}
	/* new->pos = pos; */
}

/**
 * [insertPos - INSERINDO POSIÇÃO NA LISTA DE POSIÇÕES]
 * @param listPos [Lista que contém as posições de determinada palavra em um documento]
 * @param pos     [Posiçao da palavra]
 */
void insertPos(posList **listPos,int pos)
{
	posList *new = malloc(sizeof(posList));
	new->pos = pos;
	new->prox = *listPos;
	*listPos = new;
}


/**
 * [printWordList - IMPRIMI LISTA DE PALAVRAS ARMAZENADAS NA LISTA DE PALAVRAS]
 * @param list [Lista de palavras que deseja imprimir na tela]
 */
void printWordList(wordList *list)
{
	while(list != NULL)
	{
		printf("%s ",list->word->string);
		printDocumentList(list->word->documents);
		list = list->prox;
	}
}


/**
 * [printDocumentList - IMPRIMI LISTA DE DOCUMENTOS ARMAZENADAS NA PALAVRA]
 * @param list [Lista de documentos que deseja imprimir na tela]
 */
void printDocumentList(documentList *list)
{
	while(list != NULL)
	{
		printf("%s\n",list->document);
		list = list->prox;
	}
}

/**
 * [printPosList - IMPRIMI LISTA DE POSIÇÕES ARMAZENADA EM UM DOCUMENTO]
 * @param list [description]
 */
void printPosList(posList *list)
{
	while(list != NULL)
	{
		printf("%d ",list->pos);
		list = list->prox;
	}
}

/**
 * [sizeList - VERIFICAR QUANTIDADE DE PALAVRAS DISTINTAS]
 * @param  list [Lista de palavras que deseja saber o tamanho]
 * @return      [Quantidade de palavras distintas que foram armazenadas]
 */
int sizeList(wordList *list)
{
	int count = 0;

	while(list != NULL)
	{
		count++;
		list = list->prox;
	}

	return count;
}

/**
 * [sizeList - VERIFICAR QUANTIDADE DE DOCUMENTOS]
 * @param  list [Lista de documentos que deseja saber o tamanho]
 * @return      [Quantidade de documentos que foram armazenados]
 */
int sizeDocList(documentList *list)
{
	int count = 0;

	while(list != NULL)
	{
		count++;
		list = list->prox;
	}

	return count;
}

/**
 * [sizePosList - VERIFICAR QUANTIDADE DE POSIÇÕES]
 * @param  list [Lista de posições que deseja saber o tamanho]
 * @return      [Quantidade de posições que foram armazenados]
 */
int sizePosList(posList *list)
{
	int count = 0;

	while(list != NULL)
	{
		count++;
		list = list->prox;
	}

	return count;
}

/**
 * [freePosList - LIBERAR DA MEMORIA LISTA DE POSIÇÕES]
 * @param l [Endereço da lista de posições que deseja liberar]
 */
void freePosList(posList **l)
{
	posList *aux;
	while(*l != NULL)
	{
		aux = *l;
		*l = (*l)->prox;
		free(aux);
	}
}
/**
 * [freeDocList - LIBERAR DA MEMORIA LISTA DE DOCUMENTOS]
 * @param l [Endereço da lista de documentos que deseja liberar]
 */
void freeDocList(documentList **l)
{
	documentList *aux;
	while(*l != NULL)
	{
		aux = *l;
		free(aux->document);
		freePosList(&aux->pos);
		*l = (*l)->prox;
		free(aux);
	}


}

/**
 * [freeWList - LIBERAR DA MEMORIA LISTA DE PALAVRAS]
 * @param l [Endereço da lista de palavras que deseja liberar]
 */
void freeWList(wordList **l)
{
	wordList *aux;
	while(*l != NULL)
	{
		aux = *l;
		*l = (*l)->prox;
		free(aux);

	}
	free(*l);

}

/**
 * [freeWord - LIBERAR DA MEMORIA UMA PALAVRA]
 * @param word [Endereço da palavra que deseja liberar]
 */
void freeWord(tpWord *word) {
    free(word->string);
    freeDocList(&word->documents);
    free(word);
}

/**
 * [geraPrimo -  ENCONTRAR O MENOR NUMERO PRIMO MAIOR OU IGUAL A N ]
 * @param  n [Numero a qual deseja encontrar o maior ou igual numero primo mais proximo]
 * @return   [Menor numero primo maior ou igual a N]
 */
int geraPrimo (int n)
{

	int m;
	if(n==2)
		return n;

	for( m=2; m<n; m++)
	{
		if (n%m!=0)
			continue;
		else
			return geraPrimo(n+1);
	}

	return n;
}
