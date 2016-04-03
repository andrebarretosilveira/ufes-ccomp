/*                                                 *
 * Solucao Exata
 *                                                 */
 
#include <stdio.h>
#include <stdlib.h>
#include "exato.h"
#include "matvet.h"

float geraMelhorCaminho(int n, int *vetorCaminho,float **matCusto,int *melhorCaminho,int posAtual){
	int *num = alocaVetor(n+1), i, j, k,*vetorPadrao = alocaVetor(n);
	float melhorCusto = 9999, custoAtual = 0;
	/*prepara o vetor com uma permutacao
	possivel,no caso 0 1 2,
	para mais na frente 
	a funcao permutar esses valores*/
	for(i=0;i< n;i++){
		vetorPadrao[i] = i;
	}

	while ( num[n] == 0 ) {            
		for(i=0; i < n; i++) {
			if ( semRepeticao(num, n) ) {
				for(j=0; j < n; j++) {
					vetorCaminho[j] = vetorPadrao[num[j]];
				}
				custoAtual = geraCusto(matCusto,vetorCaminho,n);
				//Gera o melhor custo com o melhor caminho
				if(custoAtual < melhorCusto && vetorCaminho[0] == 0 ){
					melhorCusto =  custoAtual;
					for(k=0;k < n;k++)
					melhorCaminho[k] = vetorCaminho[k];
				}	
			}
			num[0]++;
		}
		//distribui os vai-uns
		for(i=0; i < n; i++) {
			if(num[i] == n) {
				num[i] = 0;
				num[i+1]++;

			}
		}

	}
	printf("\nMelhor Caminho = ");
	for(k=0;k < n;k++)
		printf("%d ",melhorCaminho[k]);
	printf("\nMelhor custo = %.2f\n",melhorCusto);
	free(num);
	return melhorCusto;
}

float geraCusto(float **matCusto,int *vetorCaminho,int n){
	int i, posAtual, prox;
	float custo =0;
	for(i=0;i< n;i++){
		//So calcula o custo de um vetor que comeca da cidade 0
		if(vetorCaminho[0] == 0){
			posAtual = vetorCaminho[i];
			if(i+1 < n)
				prox = vetorCaminho[i+1];
			else
				//No final,calcula o custo da cidade x a cidade 0	
				prox = 0;
				//Para nao entrar os valores 9999
			if(posAtual != prox)
				custo += matCusto[posAtual][prox]; 
		}	
	}
		return custo;
}
/* Funcao que retorna verdadeiro se
 num nao contem algarismos repetidos
  e zero caso contrario. */
char semRepeticao(int *num, int r) {
	int i, j ;
 
	for(i=0; i < r; i++) {
		for(j=0; j < r && i != j; j++) {
			if(num[i] == num[j]) {
				return 0;
			}
		}
	}
 
	return 1 ;
}
