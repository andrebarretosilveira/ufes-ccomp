/**
 * CABEÇALHO TAD LIST
 * ESTRUTURA E ASSINUATURAS DE FUNÇÕES PARA GERENCIAR O TAD LIST
 */

#ifndef LISTINT_H
#define LISTINT_H

#include <stdio.h>
#include <stdlib.h>

/** Estrutura Lista de Inteiros */
typedef struct list
{
	int id;
	struct list* prox;

}List;

typedef struct sentinela
{
	List *primeiro;
	List *ultimo;
}typeList;

/** [createList - Inicializa a List] */
typeList* createList();

/** [insertList - Insere um elemento na lista] */
void insertList(typeList* l, int item);
//typeList* insertList(typeList* l, int item);

typeList *dupList(typeList *l);

/** [printList - Imprimi a lista] */
void printList(typeList* l);

/** [isListNull - Verifica se a lista está vazia] */
int isListNull(typeList *l);

/** [isElementList - Verificando se um elemento pertence a lista] */
int isElementList(typeList *l, int v);

/** [removeElement - Removendo um elemento da lista] */
void removeElement(typeList *l, int v);

/** [freeList - Liberando memória da lista] */
void freeList(typeList *l);

#endif
