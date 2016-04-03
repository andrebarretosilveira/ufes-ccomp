/**
 * TAD LISTA DE INTEIROS
 */

#include "listInt.h"

/**
 * [createList - Inicializa a List]
 * @return  [Valor NULL correspondente a lista vazia]
 */
typeList* createList()
{
	typeList* lista = malloc(sizeof(typeList));
	lista->ultimo = NULL;
	lista->primeiro = NULL;
	return lista;
}

/**
 * [insertList - Insere um elemento na lista]
 * @param  l    [Lista atual na qual deseja inserir o elemento]
 * @param  item [Elemento que deseja se inserir na lista]
 */
void insertList(typeList* l, int item)
{
	List* new = malloc(sizeof(List));
	if(l->ultimo == NULL)
	{
		l->primeiro = l->ultimo = new;
	}else
	{
		l->ultimo->prox = new;
		l->ultimo = l->ultimo->prox;
	}

	l->ultimo->id = item;
	l->ultimo->prox = NULL;

}

/**
 * Cria uma nova lista igual a desejada
 * @param  l Ponteiro para lista a ser duplicada
 * @return   Nova lista igual a lista l
 */
typeList *dupList(typeList *l)
{
    typeList *new = createList();
    List *aux;

    for(aux = l->primeiro; aux != NULL; aux = aux->prox)
        insertList(new, aux->id);

    return new;
}

/**
 * [printList - Imprimi a lista]
 * @param l [Lista ao qual deseja se imprimir]
 */
void printList(typeList* l)
{
	List *aux;

	for(aux = l->primeiro; aux != NULL; aux = aux->prox)
	{
		printf("%d ",aux->id);
	}
    printf("\n");
}

/**
 * [isListNull - Verifica se a lista está vazia]
 * @param  l [Lista ao qual deseja se verificar se está vazia]
 * @return   [Valor correspondente a saber se lista está vazia]
 */
int isListNull(typeList *l)
{
	return (l->primeiro == NULL);
}

/**
 * [isElementList - Verificando se um elemento pertence a lista]
 * @param  l [Lista ao qual deseja se conferir se tem determinado elemento]
 * @param  v [Elemento ao qual deseja saber se pertence a lista]
 * @return   [Valor correspondente ao elemento pertencer a lista]
 */
int isElementList(typeList *l, int v)
{
	List *aux;

	for(aux = l->primeiro; aux != NULL; aux = aux->prox)
	{
		if(aux->id == v)
		{
			return 1;
		}
	}

	return 0;
}
/**
 * [removeElement - Removendo um elemento da lista]
 * @param l [Lista ao qual deseja se remover um elemento]
 * @param v [Elemento ao qual deseja se remover da lista]
 */
void removeElement(typeList *l, int v)
{
	List* aux = NULL;
	List* p = l->primeiro;

	while(p != NULL && p->id != v)
	{
		aux = p;
		p = p->prox;
	}

	 if (p == NULL)
	 	return;

	 if (p == l->primeiro && p == l->ultimo)
	 { /* retira elemento do inicio */
	 	l->primeiro = l->ultimo = NULL;
	 	free(p);
	 	return;
	 }
	 if(p == l->ultimo)
	 {
	 	l->ultimo = aux->prox = NULL;
	 	free(p);
	 	return;
	 }
	 if(p == l->primeiro)
	 	l->primeiro = p->prox;
	 else
	 	aux->prox = p->prox;
	 	free(p);
}

/**
 * [freeList - Liberando memória da lista]
 * @param l [Lista ao qual se deseja liberar da memória]
 */
void freeList(typeList *l)
{
	List* aux = l->primeiro;
	while(aux != NULL)
	{
		List* t = aux->prox;
		free(aux);
		aux = t;
	}
	free(l);
}
