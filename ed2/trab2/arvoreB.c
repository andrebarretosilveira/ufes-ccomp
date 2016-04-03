/**
 * FUNÇÕES PARA A MANIPULAÇÃO DA ARVORE B
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <wchar.h>
#include <wctype.h>
#include "word.h"
#include "hash.h"
#include "arvoreB.h"
#include "preProcess.h"

#define BUFFER 100
#define MIN_OCUP (M/2 - 1)  /* Minímo de ocupação de um nó */

/**
 * [buscaArvB - Lê um arquivo apontado por fin realiza buscas na árvore B]
 * @param raiz   [Ponteiro para a arvore B a ser recriada]
 * @param fin    [Ponteiro para arquivo onde se encontram as palavras a serem buscadas]
 */
void buscaArvB(ArvoreB *raiz, FILE *fin)
{
    char *palavra = malloc(BUFFER*sizeof(char));
    wchar_t *linha = malloc(BUFFER*sizeof(wchar_t));
    wchar_t *ptr, *token, wordGroup[BUFFER];
    tpWord *word;
    documentList *docList = NULL;

    while(fgetws(linha, BUFFER, fin) != NULL) { /* Lendo linha por linha */
        /* Remover '\n' lido pelo fgetws */
        if ((ptr = wcschr(linha, L'\n')) != NULL)
            *ptr = L'\0';

        /* Salvando busca original */
        wcsncpy(wordGroup, linha, BUFFER);

        /* Busca de frase (possui aspas) */
        if(linha[0] == '"') {
            docList = sentenceSearchArvB(raiz, wordGroup);
            if(docList != NULL) {
                printf("%ls\n", linha);
                printDocumentList(docList);
                freeDocList(&docList);
            }
        }

        else {
            /* Dividindo a linha em tokens (palavras) */
            token = wcstok(linha, L" ", &ptr);
            token = wcstok(NULL, L" ", &ptr);

            /* Recopiando a busca original */
            wcsncpy(linha, wordGroup, BUFFER);

            /* Busca de múltiplas palavras */
            if(token != NULL) {
                docList = multiSearchArvB(raiz, wordGroup);
                if(docList != NULL) {
                    printf("%ls\n", linha);
                    printDocumentList(docList);
                    freeDocList(&docList);
                }
            }

            /* Busca simples de uma palavra */
            else {
                clearWord(palavra, linha);
                word = searchArvB(raiz, palavra);
                if(word != NULL) {
                    printf("%s\n", palavra);
                    printDocumentList(word->documents);
                }
            }
        }
    }
    free(palavra);
    free(linha);
}

/**
 * [importArvB - Lê um arquivo apontado por fin e recria a árvore B]
 * @param raiz   [Ponteiro para a arvore B a ser recriada]
 * @param fin    [Ponteiro para arquivo a ler o índice]
 */
void importArvB(ArvoreB **raiz, FILE *fin)
{
    tpWord *word;
    char *in = malloc(BUFFER*sizeof(char));
    char *palavra = malloc(BUFFER*sizeof(char));
    char *doc = malloc(BUFFER*sizeof(char));
    int pos;

    while(fscanf(fin, "%s", in) != EOF) {
        /* Inserir palavra criada na árvore */
        if(strcmp(in, ";") == 0)
            *raiz = insereArvB(*raiz, word);

        /* Inserir documento e posições na word */
        else if(strcmp(in, "-") == 0) {
            fscanf(fin, "%s", doc);
            fscanf(fin, "%d", &pos);
            while(pos != -1) {
                insertDocument(&word->documents, doc, pos);
                fscanf(fin, "%d", &pos);
            }
        }

        /* Criar estrutura da palavra */
        else {
            strcpy(palavra, in);
            word = inicializaWord(palavra);
        }
    }

    free(in);
    free(palavra);
    free(doc);
}

/**
 * [geraIndex - Cria o arquivo de índices apontado por fout da árvore raiz]
 * @param raiz   [Ponteiro para arvore B]
 * @param fout   [Ponteiro para arquivo a ser escrito]
 */
void geraIndex(ArvoreB *raiz, FILE *fout)
{
    int i;
    tpWord *word;
    documentList *doclist;
    posList *poslist;

    if(raiz != NULL) {
        for(i = 0; i < raiz->n; i++) {
            geraIndex(raiz->p[i], fout); /* Chamada recursiva */
            word = raiz->word[i];
            fprintf(fout, "%s", word->string);
            doclist = word->documents;

            while(doclist != NULL) { /* Imprimir lista de documentos */
                fprintf(fout, "\n- %s\n", doclist->document);
                poslist = doclist->pos;

                while(poslist != NULL) { /* Imprimir lista de posições */
                    fprintf(fout, "%d ", poslist->pos);
                    poslist = poslist->prox;
                }
                fprintf(fout, "-1");
                doclist = doclist->prox;
            }
            fprintf(fout, "\n;\n");
        }
        geraIndex(raiz->p[i], fout);
    }
}

/**
 * [searchArvB - Busca na árvore B por uma palavra indicada]
 * @param raiz   [Ponteiro para arvore B]
 * @param word   [Palavra a ser buscada na árvore]
 * @return       [Ponteiro para palavra encontrada]
 */
tpWord *searchArvB(ArvoreB *raiz, char *word)
{
    int pos;

    if(raiz == NULL)
        return NULL;

    pos = buscaBinaria(raiz, word);

    if(strcmp(raiz->word[pos]->string, word) == 0)
        return raiz->word[pos]; /* Palavra encontrada */

    if(strcmp(raiz->word[pos]->string, word) > 0)
        return searchArvB(raiz->p[pos], word); /* Buscar a esquerda (subarvore) */
    else
        return searchArvB(raiz->p[pos+1], word); /* Buscar a direita (subarvore) */

    return NULL;
}

/**
 * [multiSearchArvB - Busca na árvore para encontrar múltiplas palavras em um mesmo documento]
 * @param raiz   [Ponteiro para arvore B]
 * @param linha  [Palavras a sererem buscadas na árvore]
 * @return       [Ponteiro para palavra encontrada]
 */
documentList *multiSearchArvB(ArvoreB *raiz, wchar_t *linha)
{
    int manter = 0;
    char *palavra = malloc(BUFFER*sizeof(char));
    wchar_t *token, *ptr;
    tpWord *word, *word2;
    documentList *dLSearch = NULL, *dL = NULL, *aux = NULL;
    documentList *secondList = NULL;

    /* Dividindo a linha em tokens (palavras) */
    token = wcstok(linha, L" ", &ptr);
    token = wcstok(NULL, L" ", &ptr);

    clearWord(palavra, linha);

    if(token == NULL) {
        word = searchArvB(raiz, palavra);
        free(palavra);
        if(word) {
            aux = word->documents;
            while(aux != NULL)
        	{
        		insertDocumentSearch(&dL, aux->document);
        		aux = aux->prox;
        	}
            return dL;
        }
        return NULL;
    }

    word = searchArvB(raiz, palavra);

    if(word == NULL) {
        free(palavra);
        return NULL;
    }

    aux = word->documents;

    while(aux != NULL)
	{
		insertDocumentSearch(&dL, aux->document);
		aux = aux->prox;
	}

    dLSearch = word->documents;

    while(token != NULL)
	{
        clearWord(palavra, token);
        word2 = searchArvB(raiz, palavra);
		if(!word2) {
            freeDocList(&dL);
            free(palavra);
			return NULL;
        }

		while(dLSearch != NULL)
		{
            secondList = word2->documents;
			while(secondList != NULL)
			{
                if(!strcmp(dLSearch->document,secondList->document))
				{
					manter = 1;
					break;
				}
				secondList = secondList->prox;
			}
            if(manter == 0)
				removeDocument(&dL, dLSearch->document);

			dLSearch = dLSearch->prox;
            manter = 0;
		}
        dLSearch = word->documents;
        token = wcstok(NULL, L" ", &ptr); /* Iterador de palavras */
    }
    free(palavra);
    return dL;
}

/**
 * [sentenceSearchArvB - Busca na árvore para encontrar palavras em sequência (entre aspas)]
 * @param raiz   [Ponteiro para arvore B]
 * @param linha  [Palavras a sererem buscadas na árvore]
 * @return       [Ponteiro para lista de documentos onde se encontra a frase]
 */
documentList *sentenceSearchArvB(ArvoreB *raiz, wchar_t *linha)
{
    int iterate;
    documentList *testList, *aux , *docWord1, *docWord2;
    tpWord *word, *nextWord;
    char *palavra = malloc(BUFFER*sizeof(char));
    wchar_t *token, *ptr, *wcharAux = malloc(BUFFER*sizeof(wchar_t));

    /* Remover aspas */
    swscanf(linha, L"\"%l[^\"]", linha);
    wcsncpy(wcharAux, linha, BUFFER);

    /* Pegando lista de documentos em comum entras as palavras */
    testList = multiSearchArvB(raiz, wcharAux);
    aux = testList;

    /* Encerra a busca avançada se a lista retornada for nula */
    if(testList == NULL) {
        free(palavra);
        free(wcharAux);
        return NULL;
    }

    /* Dividindo a linha em tokens (palavras) */
    token = wcstok(linha, L" ", &ptr);
    token = wcstok(NULL, L" ", &ptr);

    /* Primeira palavra */
    clearWord(palavra, linha);
    word = searchArvB(raiz, palavra);

    while(token != NULL)
    {
        /* Próximas palavras */
        clearWord(palavra, token);
        nextWord = searchArvB(raiz, palavra);

        while(aux != NULL)
        {
            iterate = 1;
            docWord1 = searchDocument(word->documents,aux->document);
            docWord2 = searchDocument(nextWord->documents,aux->document);

            if((!docWord1 || !docWord2) || !checkPosition(docWord1, docWord2)) {
                strcpy(palavra, aux->document);
                aux = aux->prox; iterate = 0;
                removeDocument(&testList, palavra);
            }

            if(testList == NULL) {
                free(palavra);
                free(wcharAux);
                return NULL;
            }

            if(aux != NULL && iterate)
                aux = aux->prox;
        }

        wcsncpy(linha, token, BUFFER);
        token = wcstok(NULL, L" ", &ptr);
        aux = testList;
    }
    free(palavra);
    free(wcharAux);
    return testList;
}

/**
 * [fillArvB - Preenche a ArvoreB raiz com a lista de palavras list]
 * @param raiz   [Ponteiro para arvore B]
 * @param list   [Lista de palavras a serem inseridas]
 */
void fillArvB(ArvoreB **raiz, wordList *list)
{
    while(list != NULL) {
        *raiz = insereArvB(*raiz, list->word);
        list = list->prox;
    }
}

/**
 * [insereArvB - INSERE UM PALAVRA tpWord NA ARVORE-B arv]
 * @param raiz   [Ponteiro para arvore B]
 * @param word   [Ponteiro para a palavra a ser inserida]
 * @return       [Ponteiro para nova árvore B]
 */
ArvoreB *insereArvB(ArvoreB *raiz, tpWord *word)
{
    int h;
    ArvoreB *filho_dir, *nova_raiz;
    tpWord *wordReturn = NULL;

    filho_dir = insere(raiz, word, &h, &wordReturn);
    if(h) { // Aumetará a altura da árvore
        nova_raiz = criaArvB();
        nova_raiz->n = 1;
        nova_raiz->word[0] = wordReturn;
        nova_raiz->p[0] = raiz;
        nova_raiz->p[1] = filho_dir;

        return(nova_raiz);
    }
    else return(raiz);
}

/**
 * [insereWord - Insere uma palavra na sub-árvore raiz]
 * @param raiz       [Ponteiro para arvore B]
 * @param word       [Palavra ser inserida]
 * @param filhodir   [Ponteiro para um filho à direita do nó]
 */
void insereWord(ArvoreB *raiz, tpWord *word, ArvoreB *filhodir)
{
    int k, pos;

    k = raiz->n;
    /* Busca para obter a posição ideal para inserir a nova palavra */
    pos = buscaBinaria(raiz, word->string);
    if(raiz->word[pos] != NULL)
        if(strcmp(raiz->word[pos]->string, word->string) < 0) pos++;

    /* Realiza o remanejamento para manter as palavras ordenadas */
    while (k > pos && strcmp(word->string, raiz->word[k-1]->string) < 0) {
        raiz->word[k] = raiz->word[k-1];
        raiz->p[k+1] = raiz->p[k];
        k--;
    }
    /* insere a palavra na posição ideal */
    raiz->word[pos] = word;
    raiz->p[pos+1] = filhodir;
    raiz->n++;
}

/**
 * [insere - Realiza a busca recursiva do nó para inserir a palavra e faz as subdivisões quando necessárias]
 * @param raiz          [Ponteiro para arvore B]
 * @param word          [Palavra ser inserida]
 * @param h             [Variável de controle booleana]
 * @param wordReturn    [Palavra retornada de chamadas recursivas. A que será inserida]
 */
ArvoreB *insere(ArvoreB *raiz, tpWord *word, int *h, tpWord **wordReturn)
{
    int i, pos;
    tpWord *wordMediano; /* Auxiliar para armazenar a palavra que irá subir para o pai */
    ArvoreB *temp, *filho_dir; /* Ponteiro para o filho à direita da palavra */

    if (raiz == NULL) {
        /* O nó anterior é o ideal para inserir a nova palavra (chegou em um nó folha) */
        *h = 1;
        *wordReturn = word;
        return (NULL);
    }
    /* Busca para obter a posição ideal para inserir a nova palavra */
    pos = buscaBinaria(raiz, word->string);
    if(raiz->word[pos] != NULL)
        if(strcmp(raiz->word[pos]->string, word->string) < 0) pos++;

    if (raiz->n > pos && strcmp(raiz->word[pos]->string, word->string) == 0) {
        /* Palavra já existe na Árvore */
        *h = 0;
        return (NULL);
    }
    /* Desce na árvore até encontrar o nó folha para inserir a palavra. */
    filho_dir = insere(raiz->p[pos], word, h, wordReturn);

    if (*h) { /* Se 1 deve inserir a wordReturn no nó. */
        if (raiz->n < M-1) { /* Tem espaço na página */
            insereWord(raiz, *wordReturn, filho_dir);
            *h = 0;
            return (NULL);
        }
        /* OVERFLOW. Precisa subdividir */
        temp = criaArvB();

        /* Elemento mediano que vai subir para o pai */
        wordMediano = raiz->word[MIN_OCUP];

        /* Insere metade do nó raiz no temp (efetua subdivisão) */
        temp->p[0] = raiz->p[MIN_OCUP+1];
        for(i = MIN_OCUP + 1; i < M-1; i++)
            insereWord(temp, raiz->word[i], raiz->p[i+1]);

        /* Atualiza nó raiz. */
        for (i = MIN_OCUP + 1; i < M; i++) {
            raiz->word[i-1] = NULL;
            raiz->p[i] = NULL;
        }
        raiz->n = MIN_OCUP;

        /* Verifica em qual nó será inserida a nova palavra */
        if (pos <= MIN_OCUP)
            insereWord(raiz, *wordReturn, filho_dir);
        else
            insereWord(temp, *wordReturn, filho_dir);

        /* Retorna o mediano para inserí-lo no nó pai e o temp como filho direito do mediano. */
        *wordReturn = wordMediano;
        return(temp);
    }
    return (NULL);
}

/**
 * [buscaBinaria - Realiza uma busca binária para encontrar a posição para o elemento]
 * @param raiz   [Ponteiro para arvore B]
 * @param word   [Palavra ser inserida]
 * @return       [Posicao a inserir a palavra]
 */
int buscaBinaria(ArvoreB *raiz, char *palavra)
{
    int li, m = 0, ls;
    li = 0; ls = (raiz->n)-1;
    while (li <= ls) {
        m = (li + ls)/2;
        if(strcmp(raiz->word[m]->string, palavra) == 0) return m;
        if(strcmp(raiz->word[m]->string, palavra) < 0) li = m + 1;
        else ls = m - 1;
    }
    /* Retorna a posição apropriada */
    return m;
}

void printArvB(ArvoreB *raiz)
{
    int i;

    if(raiz != NULL) {
        for(i = 0; i < raiz->n; i++) {
            printArvB(raiz->p[i]);
            printf("%s %d", raiz->word[i]->string, i);
        }
        printArvB(raiz->p[i]);
    }
    printf("\n");
}

/**
 * [criaArvB - INICIALIZA A ARVORE B]
 * @return  [Ponteiro para estrutura da arvore B]
 */
ArvoreB *criaArvB() {
    int i;

    ArvoreB *arv = malloc(sizeof(ArvoreB));
    arv->n = 0;
    for(i = 0; i < M-1; i++) {
        arv->word[i] = NULL;
        arv->p[i] = NULL;
    }
    arv->p[M-1] = NULL;

    return arv;
}

/**
 * [freeArvB - Libera arvore e tudo que há de bom]
 * @param raiz   [Ponteiro para arvore B]
 */
void freeArvB(ArvoreB *raiz)
{
    int i;

    if(raiz != NULL) {
        for(i = 0; i < raiz->n; i++) {
            freeArvB(raiz->p[i]);
            freeWord(raiz->word[i]);
        }
        freeArvB(raiz->p[raiz->n]);
        free(raiz);
    }
}
