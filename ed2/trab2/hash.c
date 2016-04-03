/**
 * FUNÇOES PARA A MANIPULAÇAO DE HASHS
 * @LAST-UPDATE 11-10-2015
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "word.h"
#include "hash.h"
#include <wchar.h>
#include <wctype.h>
 #include "preProcess.h"
#define BUFFER 100 /* TAMANHO MAXIMA DE PALAVRA A SER ARMAZENADA*/

/**
 * [gerarSizeHash - Gerar tamanho ideal para Hash]
 * @param  list [Lista de palavras populada]
 * @return      [Tamanho ideal para a HASH]
 */
int gerarSizeHash(wordList *list)
{
	int size = 2 * sizeList(list);
	size =	geraPrimo(size);

	return size;
}


/**
 * [hashKey - Geradora de Chaves para a tabela HASH]
 * @param  word      [Palavra a ser gerada a chave]
 * @param  sizeTable [Tamanho da tabela hash]
 * @return           [Chave gerada pela hashKey]
 */
int hashKey(char *word, const int sizeTable)
{
	int codigo = 1;
	unsigned int i;

	for(i = 0; i < strlen(word);i++)
		codigo = (31*codigo + (int)word[i])%sizeTable;


	return abs(codigo%sizeTable);
}


/**
 * [hashKey2 - Geradora de chaves 2 para a tabela HASH ]
 * @param  word      [Palavra a ser gerada a chave]
 * @param  sizeTable [Tamanho da tabela hash]
 * @return           [Chave gerada pela hashKey2]
 */
int hashKey2(char *word, const int sizeTable)
{
	int codigo = hashKey(word,sizeTable);

	return 1 + (codigo%(sizeTable-1));
}

/**
 * [createHashTb - Cria a Hash Table]
 * @param hashTable [Endereço de onde sera armazenado a HashTable]
 * @param sizeTable [Tamanho da Hash Table]
 */
void createHashTb(wordList ***hashTable, const int sizeTable)
{
	int i;

	*hashTable = malloc((unsigned int)sizeTable * sizeof(wordList*));

	for(i = 0; i < sizeTable; i++)
    	(*hashTable)[i] = NULL;
}


/**
 * [fillHash - Popula a hash com uma lista de palavras]
 * @param hashTable [Hash a ser preenchida]
 * @param list      [Lista de palavras que preenchera a hash]
 * @param sizeTable [Tamanho da hash]
 * @param type      [Tipo da hash, Encadeada, Linear ou ReHashing]
 */
void fillHash(wordList **hashTable, wordList *list, const int sizeTable, char type)
{


 	if( type == 'E')
 	{
 		/* PREENCHENDO HASH ENCADEADA */
	 	while(list != NULL)
		{
			insertHashE(hashTable,list->word,hashKey(list->word->string,sizeTable));
			list = list->prox;
		}
	}else if( type == 'L')
	{
		/* PREENCHENDO HASH LINEAR */
		while(list != NULL)
		{
			insertHashL(hashTable,list->word,hashKey(list->word->string,sizeTable),sizeTable);
			list = list->prox;
		}
	}else if( type == 'R')
	{
		/* PREENCHENDO RE-HASHING */
		while(list != NULL)
		{
			insertHashR(hashTable,list->word,hashKey(list->word->string,sizeTable),hashKey2(list->word->string,sizeTable),sizeTable);
			list = list->prox;
		}
	}else
		/* TIPO DE HASH NAO ENCONTRADO */
		printf("ERROR - Tipo de hash informado nao existe!");

}

 /**
 * [insertWordHash - Inserindo palavra na tabela hash]
 * @param word [Palavra a ser inserida]
 * @param list [Lista de palavras a ser populada]
 */
void insertWordHash(tpWord *word, wordList** list)
{
		wordList *new = malloc(sizeof(wordList));
	    new->word = word;
		new->prox = *list;
		*list = new;
}

/**
 * [insertHashE - Inserir palavras na Hash de modo encadeado]
 * @param hashTable [Endereço da tabela Hash]
 * @param p         [Palavra a ser inserida na HashTable]
 * @param hashKey   [Posiçao da Hash a ser inserido a palavra]
 */
void insertHashE(wordList **hashTable, tpWord *p, int hashKey)
{

			insertWordHash(p, &hashTable[hashKey]);

}

/**
 * [printHashE - Funçao que imprimi a hash encadeada]
 * @param hashTable [Tabela Hash encadeada que deseja imprimir]
 * @param size       [Tamanho da tabela hash]
 */
void printHashE(wordList **hashTable, const int size)
{
	int i;
	for(i = 0; i < size; i++)
	{
		printf("\nEncadeamento [ %d ]: \n",i);
		printWordList(hashTable[i]);

	}
}

/**
 * [insertHashL - Inserir palavras na Hash de modo linear]
 * @param hashTable [Endereço da tabela Hash]
 * @param p         [Palavra a ser inserida na Hash Table]
 * @param hashKey   [Chave seletora da posiçao na tabela hash]
 * @param sizeTable [Tamanho da tabela hash]
 */
void insertHashL(wordList **hashTable, tpWord *p, int hashKey, const int sizeTable)
{
	/*CONFERINDO SE OCORRE COLISAO */
	if(hashTable[hashKey] != NULL)
	{
			insertHashL(hashTable,p,(hashKey+1) % sizeTable,sizeTable);
	}else
	{

		insertWordHash(p, &hashTable[hashKey]);

	}

}


/**
 * [insertHashR - Inserir palavras na Hash de modo duplo]
 * @param hashTable [Endereço da tabela Hash]
 * @param p         [Palavra a ser inserida na Hash Table]
 * @param hashKey   [Chave seletora da posiçao na tabela hash, utilizando HASHKEY1]
 * @param hashKey2  [Chave seletora da posiçao na tabela hash, utilizando HASHKEY2]
 * @param sizeTable [Tamanho da tabela hash]
 */
void insertHashR(wordList **hashTable, tpWord *p, int hashKey, int hashKey2,const int sizeTable)
{
	/* CONFERINDO SE OCORRE COLISAO */
	if(hashTable[hashKey] != NULL)
	{
		insertHashR(hashTable,p,(hashKey+hashKey2)%sizeTable, hashKey2,sizeTable);
	}else
	{

		insertWordHash(p, &hashTable[hashKey]);
	}

}

/**
 * [sizeOccupating - VERIFICA QUANTIDADE DE ESPAÇOS ESTAO PREENCHIDOS NA HASH]
 * @param  hashTable [Table hash]
 * @param  size      [Tamanho da tabela hash]
 * @return           [Quantidade de elementos preenchidos na tabela hash]
 */
int sizeOccupating(wordList **hashTable, const int size)
{
	int i, count;

	for(i = 0; i < size; i++)
	{
		if(hashTable[i] != NULL)
			count++;
	}

	return count;
}

/**
 * [hashExportE - Exportando tabela hash encadeada para um arquivo]
 * @param hashTable [Tabela hash encadeada populada]
 * @param size      [Tamanho da tabela hash]
 */
void hashExportE(wordList **hashTable,const int size, char *file)
{
	int i;
	wordList *aux;
	documentList *aux2;
	posList *aux3;
	/* INICIALIZANDO ARQUIVO OUTFILE */
	FILE *outFile = fopen(file,"w");

	if(!outFile)
	{
		printf("Erro ao gerar outFile!");
	}
	/* EXPORTANDO TIPO DA HASH E TAMANHO */
	fprintf(outFile,"E %d \n",size);

	for( i = 0; i < size; i++)
	{
		aux = hashTable[i];
		/* EXPORTANDO INDICE E QUANTIDADE DE PALAVRAS ENCADEADA */
		if(aux != NULL)
			fprintf(outFile,"%d %d\n",i,sizeList(aux));
		/* EXPORTANDO PALAVRAS DA HASH */
		while(aux != NULL)
		{
			fprintf(outFile,"%s %d ",aux->word->string, sizeDocList(aux->word->documents));
				/* EXPORTANDO DOCUMENTOS QUE ESTAO AS PALAVRAS DA HASH */
				aux2 = aux->word->documents;
				while(aux2 != NULL)
				{

					aux3 = aux2->pos;
					fprintf(outFile,"\n%s %d \n",aux2->document,sizePosList(aux3));
					/* EXPORTANDO POSIÇÕES QUE ESTAO NOS DOCUMENTOS DA HASH */
					while(aux3 != NULL)
					{
						fprintf(outFile,"%d ",aux3->pos);
						aux3 = aux3->prox;
					}
					aux2 = aux2->prox;

				}
			fprintf(outFile,"\n\n");
			aux = aux->prox;
		}

	}
	
	fclose(outFile);
}

/**
 * [hashExportLR - Exportando tabela Hash Linear ou ReHashing]
 * @param hashTable [Tabela Hash Linear ou ReHashing populada]
 * @param size      [Tamanho da hash]
 * @param type      [Tipo da Hash, Linear ou ReHashing]
 */
void hashExportLR(wordList **hashTable,const int size,char type, char *file)
{
	int i;
	wordList *aux;	/* VARIAVEL AUXILIAR PARA NAO ALTERAR A LISTA DE PALAVRAS */
	documentList *aux2;	/* VARIAVEL AUXILIAR PARA NAO ALTERAR A LISTA DE DOCUMENTOS */
	posList *aux3; /* VARIAVEL AUXILIAR PARA NAO ALTERAR A LISTA DE POSIÇOES */
	/*  INICIALIZANDO ARQUIVO OUTFILE */
	FILE *outFile = fopen(file,"w");

	if(!outFile)
	{
		printf("Erro ao gerar outFile!");
	}


	/* EXPORTANDO TIPO DA HASH E TAMANHO */
	fprintf(outFile,"%c %d\n",type,size);
	for( i = 0; i < size; i++)
	{
		aux = hashTable[i];
		/* EXPORTANDO INDICE */
		if(aux != NULL)
			fprintf(outFile,"%d \n",i);

		/* EXPORTANDO PALAVRAS DA HASH */
		if(aux != NULL)
		{
			fprintf(outFile,"%s %d \n",aux->word->string, sizeDocList(aux->word->documents));

			/* EXPORTANDO DOCUMENTOS QUE ESTAO AS PALAVRAS DA HASH */
			aux2 = aux->word->documents;
			while(aux2 != NULL)
			{
				aux3 = aux2->pos;
				fprintf(outFile,"%s %d \n",aux2->document,sizePosList(aux3));

				/* EXPORTANDO POSIÇÕES QUE ESTAO NOS DOCUMENTOS DA HASH */
				while(aux3 != NULL)
				{
					fprintf(outFile,"%d ",aux3->pos);

					aux3 = aux3->prox;
				}

				aux2 = aux2->prox;

			}
		fprintf(outFile,"\n\n");
		}

	}

	fclose(outFile);

}

/**
 * [hashImport - RECONSTRUINDO A TABELA HASH APARTIR DE UM ARQUIVO]
 * @param hashTable [Endereço da tabela hash a ser reconstruida]
 */
int hashImport(wordList ***hashTable, char *file)
{
	char type, word[50], doc[50];
	int i,size,qtdWords = 0,qtdDoc = 0,qtdPos = 0,k = 0,j = 0,pos = 0,hashKey = 0;
	/* INICIALIZANDO ARQUIVO OUTFILE */
	FILE *outFile = fopen(file,"r");

	if(!outFile)
	{
		printf("Erro ao gerar outFile!");
	}

	/* Lendo tipo e tamanho da hash */
	fscanf(outFile,"%c %d \n",&type,&size);

	*hashTable = malloc((unsigned int)size * sizeof(wordList*));
    for(i = 0; i < size; i++)
        (*hashTable)[i] = NULL;


	if(type == 'E')
	{
		/* Importando Hash do tipo E de um arquivo */
		while(fscanf(outFile,"%d %d \n ",&hashKey,&qtdWords) != EOF)
		{
			/* Restaurando chave e quantidade de palavras na lista encadeada */

			/* printf("%d ",i); */
			for(k = 0; k < qtdWords; k++)
			{
				/* Restaurando palavra e quantidade de documentos com esta palavra */
				fscanf(outFile,"%s %d ",word,&qtdDoc);

				/* printf("%s ",word);*/

				for(j = 0; j < qtdDoc; j++)
				{
					/* Restaurando documento e posiçao da palavra */
					fscanf(outFile,"\n%s %d \n",doc, &qtdPos);
					/* printf("%s %d ",doc,pos); */
					for(i = 0; i < qtdPos; i++)
					{
						/* Restaurando posiçao da palavra no documento */
						fscanf(outFile,"%d ",&pos);
						/* Inserindo a palavra com o dados restaurados na hash */
						insertWord(word,&((*hashTable)[hashKey]),doc,pos);
					}

				}
				fscanf(outFile,"\n\n");
			}
			/*printf("\n");	*/
		}

	}else
	{

		/* Importando Hash do tipo L ou R de um arquivo */
		while(!feof(outFile))
		{
			/* Restaurando chave */
			fscanf(outFile,"%d ", &hashKey);
			/*printf("%d ",i); */

				/*Restaurando palavra e quantidade de documentos com esta palavra */
				fscanf(outFile,"%s %d ",word, &qtdDoc);
				/*printf("%s ",word);*/

				for(j = 0; j < qtdDoc; j++)
				{
					/* Restaurando documento e posiçao da palavra */
					fscanf(outFile,"%s %d ",doc, &qtdPos);
					/*printf("%s %d ",doc,pos);*/
					for(i = 0; i < qtdPos; i++)
					{
						/* Restaurando posiçao da palavra no documento */
						fscanf(outFile,"%d ",&pos);
						/*Inserindo a palavra com o dados restaurados na hash */
						insertWord(word,&((*hashTable)[hashKey]),doc,pos);
					}
					fscanf(outFile,"\n");
				}
			/*printf("\n");	*/
			fscanf(outFile,"\n\n");
		}
	}

	fclose(outFile);

    return size;

}

/**
 * [freeHash - LIBERANDO MEMORIA ALOCADA PARA A TABELA HASH]
 * @param hashTable [Tabela hash a ser liberada]
 * @param sizeHash  [Tamanho da tabela hash]
 */
void freeHash(wordList **hashTable, int sizeHash)
{
	int i;
	wordList *aux;

	for(i = 0; i < sizeHash; i++)
	{
		while(hashTable[i] != NULL)
		{
			aux = hashTable[i];
			/* LIBERANDO LISTA DE DOCUMENTOS */
			freeDocList(&hashTable[i]->word->documents);
			free(aux->word->string);
			free(aux->word);
			hashTable[i] = hashTable[i]->prox;
			free(aux);

		}

	}

	/*free(*hashTable); */
	free(hashTable);
}

/**
 * [buscaHash - REALIZANDO QUERIES]
 * @param tpHash [Tipo de Hash a realizar a query]
 * @param index  [Nome do arquivo onde a hash está indexada]
 * @param query  [Nome do arquivo onde está armazenada as queries]
 */
void buscaHash(char tpHash,char *index ,char *query)
{
	wordList **hashTable = NULL;	/* HASH A SER RESTAURADA*/
 	char word[BUFFER],wordGroup[BUFFER];	/* MAIOR PALAVRA A SER ARMAZENADA*/
 	int sizeHash = hashImport(&hashTable,index); /* RESTAURANDO A HASH E SEU TAMANHO*/
 	FILE *arq = fopen(query,"r");	/* INICIANDO ARQUIVO DE CONSULTA*/
 	char *token = NULL;
 	wchar_t linha[BUFFER];



	/** PERCORRENDO O ARQUIVO DE QUERIES */
	while(fwscanf(arq,L"%l[^\n]\n",linha) != EOF)
	{
        // REALIZANDO BUSCA COM ASPAS
		if(linha[0] == '"')
		{
			// REMOVENDO ACENTOS E PONTUAÇÃO
            swscanf(linha,L"\"%l[^\"]",linha);
            clearWord(word,linha);
   	        sprintf(wordGroup,"\"%s\"",word);
            strcpy(word,wordGroup);

			documentList *result = searchHashAsp(hashTable,sizeHash,word,tpHash);
			// IMPRIMINDO RESULTADO DE BUSCA COM ASPAS
			if(result != NULL)
			{
				printf("%s\n",wordGroup);
				printDocumentList(result);
				freeDocList(&result);
			}

		}else
		{
			// LIMPANDO ACENTOS DA PALAVRA
			clearWord(word,linha);
			strcpy(wordGroup,word);
			token = strtok(word," ");
			token = strtok(NULL, " ");
			// BUSCA DE MULTI PALAVRAS
			if(token != NULL)
			{
				strcpy(word,wordGroup);
				documentList *result = searchHashLine(hashTable,sizeHash,word,tpHash);
				if(result != NULL)
				{
					printf("%s\n",wordGroup);
					printDocumentList(result);
					freeDocList(&result);
				}
			//BUSCA DE UMA PALAVRA
			}else
			{
				wordList *listW1;
				listW1 = searchType(hashTable, word,tpHash, sizeHash);
				if(listW1)
				{
					printf("%s\n",word);
					printDocumentList(listW1->word->documents);
				}
			}


		}
		strcpy(word,"");
	}


	/** LIBERANDO MEMORIA ALOCADA PARA A HASH TABLE */
	freeHash(hashTable,sizeHash);
	fclose(arq);
}

/**
 * [searchType - SELECIONANDO TIPO DE HASH A SER BUSCAR]
 * @param  hashTable [Tabela hash]
 * @param  word      [Palavra a ser buscada]
 * @param  type      [Tipo da hash a ser buscada]
 * @param  sizeHash  [Tamanho da hash]
 * @return           [Palavra encontrada]
 */
wordList* searchType(wordList **hashTable, char *word,char type, int sizeHash)
{
	int key = hashKey(word,sizeHash);
	wordList *aux = hashTable[key];
	if(type == 'E')
	{
		aux = searchHashE(aux,word);
		return aux;
	}else
	if(type == 'L')
	{
		aux = searchHashL(hashTable,sizeHash,word);
		return aux;
	}else
	if (type == 'R')
	{
		aux = searchHashR(hashTable,sizeHash,word);
		return aux;
	}else
		printf("Tipo informado invalido.");

	return NULL;
}

/**
 * [searchHashE - Busca na hash tipo E]
 * @param  hashTable [Tabela hash]
 * @param  word      [Palavra a ser buscada]
 * @return           [Estrutura da palavra encontrada]
 */
wordList* searchHashE(wordList *hashTable,char *word)
{

	wordList *aux = hashTable;


	while(aux != NULL && strcmp(aux->word->string,word))
	{
		aux = aux->prox;
	}
		return aux;
}

/**
 * [searchHashLine - REALIZA A BUSCA DE VÁRIAS PALAVRAS NO MESMO DOCUMENTO]
 * @param  hashTable [Tabela Hash]
 * @param  sizeHash  [Tamanho da tabela Hash]
 * @param  word      [Palavra a ser buscada]
 * @param  tpHash    [Tipo da tabela hash]
 * @return           [Lista de documentos que possuem o conjunto da palavras]
 */
documentList* searchHashLine(wordList **hashTable,int sizeHash, char *word,char tpHash)
{

	int count = 0;
	char *token;
	wordList *listW1 = NULL,*listW2 = NULL;
	documentList *secondList,*dLSearch = NULL, *dL = NULL, *aux = NULL;

	// ARMAZENANDO A PRIMEIRA PALAVRA
	token = strtok(word," ");

	// BUSCANDO A PRIMEIRA PALAVRA
	listW1 = searchType(hashTable, word,tpHash, sizeHash);
	// VERIFICANDO SE A PALAVRA FOI ENCONTRADA
	if(!listW1)
		return NULL;

	// ARMAZENANDO A SEGUNDA PALAVRA
	token = strtok(NULL, " ");
	aux = listW1->word->documents;
	dLSearch = listW1->word->documents;
	// COPIANDO LISTA DE DOCUMENTOS DA PRIMEIRA PALAVRA
	while(aux != NULL)
	{
		insertDocumentSearch(&dL,aux->document);
		aux = aux->prox;
	}

	// REALIZANDO CONSULTA DAS OUTRAS PALAVRAS
	while(token != NULL)
	{
		// BUSCANDO A PALAVRA
		listW2 = searchType(hashTable, token,tpHash, sizeHash);
		// VERIFICANDO SE A PALAVRA FOI ENCONTRADA
		if(!listW2) {
            freeDocList(&dL);
            return NULL;
        }


		// PERCORRENDO LISTA DE DOCUMENTOS COPIADA
		while(dLSearch != NULL)
		{
			secondList = listW2->word->documents;
			// PERCORRENDO LISTA DE DOCUMENTOS DE PALAVRAS ATUAL
			while(secondList != NULL)
			{
				// VERIFICANDO SE AS PALAVRAS NÃO ESTÃO NO MESMO DOCUMENTO
				if(!strcmp(dLSearch->document,secondList->document))
				{
					count++;
					break;
				}
				secondList = secondList->prox;
			}
			// REMOVENDO DOCUMENTO QUE NÃO TEM AS PALAVRAS
			if(count == 0)
				removeDocument(&dL, dLSearch->document);


			dLSearch = dLSearch->prox;
			count = 0;
		}

		token = strtok(NULL, " ");
		dLSearch = listW1->word->documents;

	}
	// LISTA DE DOCUMENTOS QUE CONTEM AS PALAVRAS
	return dL;
}

/**
 * [searchHashL - BUSCA NA HASH TIPO L]
 * @param  hashTable [Tabela Hash]
 * @param  sizeHash  [Tamanho da Hash]
 * @param  word      [Palavra a ser buscada]
 * @return           [Estrutura da palavra encontrada]
 */
wordList* searchHashL(wordList **hashTable,int sizeHash,char *word)
{
	int key = hashKey(word,sizeHash);
	wordList *aux = hashTable[key];
	/** BUSCANDO A PALAVRA NA HASH TIPO L */
	while(aux != NULL && strcmp(aux->word->string,word))
	{
		key= (key + 1)%sizeHash;
		aux = hashTable[key];
	}
	/** NÃO ENCONTRO A PALAVRA NA HASH */
	return aux;
}

/**
 * [searchHashR - BUSCA NA HASH TIPO R]
 * @param  hashTable [Tabela Hash]
 * @param  sizeHash  [Tamanho da Hash]
 * @param  word      [Palavra a ser buscada]
 * @return           [Estrutura da palavra encontrada]
 */
wordList* searchHashR(wordList **hashTable,int sizeHash,char *word)
{
	int key = hashKey(word,sizeHash);
	int keyR = hashKey2(word,sizeHash);
	wordList *aux = hashTable[key];
	/** BUSCANDO A PALAVRA NA HASH TIPO R */
	while(aux != NULL && strcmp(aux->word->string,word))
	{
		key = (key + keyR)%sizeHash;
		aux = hashTable[key];
	}
	/** NÃO ENCONTRO A PALAVRA NA HASH */
	return aux;
}

/**
 * [searchHashAsp - BUSCANDO FRASES EM UM DOCUMENTO]
 * @param  hashTable [Tabela Hash]
 * @param  sizeHash  [Tamanho da tabela hash]
 * @param  word      [Frase a ser buscada]
 * @param  tpHash    [Tipo de Hash]
 * @return           [Lista de documentos que possui a frase]
 */
documentList *searchHashAsp(wordList **hashTable,int sizeHash, char *word, char tpHash)
{
	documentList *testList = NULL,*aux = NULL , *docWord1 = NULL,*docWord2 = NULL ;
	wordList *prevWord = NULL , *nextWord = NULL;
	char *token, wordAux[BUFFER], document[BUFFER];
	int iterate;

	// REMOVENDO ASPAS
	sscanf(word,"\"%[^\"]",word);
	strcpy(wordAux,word);
	// BUSCANDO LISTA DE DOCUMENTOS QUE AS PALAVRAS APARECEM
	testList = searchHashLine(hashTable,sizeHash,wordAux,tpHash);

	// CONFERINDO SE EXISTE UMA LISTA DE DOCUMENTOS QUE AS PALAVRAS APARECEM
	if(!testList)
		return NULL;

	token = strtok(word," ");
	token = strtok(NULL, " ");

	// MONTANDO LISTA DE DOCUMENTOS QUE POSSUEM A FRASE BUSCADA
	while(token != NULL)
	{
		aux = testList;
		prevWord = searchType(hashTable, word,tpHash, sizeHash);
		nextWord = searchType(hashTable, token,tpHash, sizeHash);
		// PERCORRENDO LISTA DE DOCUMENTOS QUE AS PALAVRAS APARECEM
		while(aux != NULL)
		{
			iterate = 1;
			docWord1 = searchDocument(prevWord->word->documents,aux->document);
			docWord2 = searchDocument(nextWord->word->documents,aux->document);
			// VERIFICANDO SE A PALAVRAS ESTÃO NO DOCUMENTO E SE VEM SEGUIDAS

			if(!docWord1 || !docWord2 || !checkPosition(docWord1,docWord2))
            {
            	strcpy(document, aux->document);
                aux = aux->prox; iterate = 0;
				removeDocument(&testList,document);
			}

			if(testList == NULL) return NULL;
			if(aux != NULL && iterate)
				aux = aux->prox;
		}


		word = token;
		token = strtok(NULL, " ");

	}

	return testList;
}

/**
 * [checkPosition - CONFERINDO SE UMA PALAVRA É SEGUIDO DE OUTRA EM UM DOCUMENTO]
 * @param  d1 [Documento que contem a lista de posições que a palavra 1 aparece]
 * @param  d2 [Documento que contem a lista de posições que a palavra 2 aparece]
 * @return    [Verdadeiro ou Falso]
 */
int checkPosition(documentList *d1, documentList *d2)
{
	posList *p1 = d1->pos;
	posList *p2;

	while(p1 != NULL)
	{
		p2 = d2->pos;
		while(p2 != NULL)
		{
			if( ((p1->pos) + 1) == p2->pos)
				return 1;

			p2 = p2->prox;
		}
		p1 = p1->prox;
	}

	return 0;
}
