/** BUSCANDO PALAVRAS NA HASH DE TIPO E */
	if(tpHash == 'E')
	{
		/** PERCORRENDO O ARQUIVO DE QUERIES */
		while(fscanf(arq,"%[^\n]\n",word) != EOF)
		{
			if(word[0] == '"')
			{
				
				sscanf(word,"\"%[^\"]\"",word);
				strcpy(wordGroup,word);
				token = strtok(word," ");		
				key = hashKey(word,sizeHash);
				  printf("\n%d\n\n",key);
				if(key == 101)	
					printDocumentList(hashTable[key]->word->documents);
				
				if()

				token = strtok(NULL, " ");
				keyR = hashKey(token,sizeHash);
				
			}else
			{
				strcpy(wordGroup,word);	
				token = strtok(word," ");					
				key = hashKey(word,sizeHash);
				token = strtok(NULL, " ");
				
				if(token != NULL)
				{

					if(!searchHashE(hashTable,word,key))
					{
						continue;
					}

					documentList *dLSearch, *dL;
					copyList(&dL,hashTable[key]->word->documents);
					dL = hashTable[key]->word->documents;
					dLSearch = hashTable[key]->word->documents;


					while(token != NULL)
					{

						key = hashKey(token,sizeHash);

						if(!searchHashE(hashTable,token,key))
						{
							flag = 1;
							break;
						}
						documentList *secondList = hashTable[key]->word->documents;

						while(dLSearch != NULL)
						{
							while(secondList != NULL)
							{
								if(!strcmp(dLSearch->document,secondList->document))
								{
									count++;
									break;
								}
								secondList = secondList->prox;
							}
							if(count == 0)
							{
								removeDocument(&dL, dLSearch->document);
							}
				
							dLSearch = dLSearch->prox;
							count = 0;
						}

						token = strtok(NULL, " ");
						//printf("\n\n%s\n\n",token);

					}

					if(dL != NULL && flag == 0)
					{
						printf("%s\n",wordGroup);
						printDocumentList(dL);
					}
					flag = 0;
				}else
				{
					if(searchHashE(hashTable,word,key))
					{
						printf("%s\n",word);
						printDocumentList(hashTable[key]->word->documents);
					}
				}
			}

		}
	/** [if BUSCANDO PALAVRAS HASH TIPO L] */
	}else if(tpHash == 'L')
	{
		/** PERCORRENDO O ARQUIVO DE QUERIES */
		while(fscanf(arq,"%s ",word) != EOF)
		{
			token = strtok(word," ");
			strcpy(wordGroup,word);
			token = strtok(NULL, " ");
			key = hashKey(word,sizeHash);		

			while(token != NULL)
			{
				printf("->> %s\n",token);
				token = strtok(NULL, " ");
			}
			
			if(searchHashL(hashTable,sizeHash,word,key))
			{
				printf("%s\n",word);
				printDocumentList(hashTable[key]->word->documents);
			}
			

		}
	/** [if BUSCANDO PALAVRAS HASH TIPO R] */
	}else if(tpHash == 'R')
	{

		/** PERCORRENDO O ARQUIVO DE QUERIES */
		while(fscanf(arq,"%s ",word) != EOF)
		{
			token = strtok(word," ");
			strcpy(wordGroup,word);
			token = strtok(NULL, " ");
			key = hashKey(word,sizeHash);
			keyR = hashKey2(word,sizeHash);		

			while(token != NULL)
			{
				printf("->> %s\n",token);
				token = strtok(NULL, " ");
			}
			
			if(searchHashR(hashTable,sizeHash,word,key,keyR))
			{
				printf("%s\n",word);
				printDocumentList(hashTable[key]->word->documents);
			}


		}
	}else
		printf("Tipo de hash informado, invalido!");


	key = hashKey(word,sizeHash);
				 wordList *aux = hashTable[key];
				// while(aux != NULL && strcmp(aux->word->string,word))
				// {
				// 	aux = aux->prox;
				// }
				// if(aux != NULL)
				// {
				// 	printf("%s\n",word);
				// 	printDocumentList(aux->word->documents);
				// }
				
				if(searchHashE(&aux,word))
				{
					printf("%s\n",word);
					printDocumentList(aux->word->documents);
				}



/** TALVEZ EU PRECISE DEPOIS */

strcpy(wordGroup,word);	
				token = strtok(word," ");					
				key = hashKey(word,sizeHash);
				token = strtok(NULL, " ");
				
				if(token != NULL)
				{

					if(!searchHashE(hashTable,word,key))
					{
						continue;
					}

					documentList *dLSearch, *dL;
					copyList(&dL,hashTable[key]->word->documents);
					dL = hashTable[key]->word->documents;
					dLSearch = hashTable[key]->word->documents;


					while(token != NULL)
					{

						key = hashKey(token,sizeHash);

						if(!searchHashE(hashTable,token,key))
						{
							flag = 1;
							break;
						}
						documentList *secondList = hashTable[key]->word->documents;

						while(dLSearch != NULL)
						{
							while(secondList != NULL)
							{
								if(!strcmp(dLSearch->document,secondList->document))
								{
									count++;
									break;
								}
								secondList = secondList->prox;
							}
							if(count == 0)
							{
								removeDocument(&dL, dLSearch->document);
							}
				
							dLSearch = dLSearch->prox;
							count = 0;
						}

						token = strtok(NULL, " ");
						//printf("\n\n%s\n\n",token);

					}

					if(dL != NULL && flag == 0)
					{
						printf("%s\n",wordGroup);
						printDocumentList(dL);
					}
					flag = 0;