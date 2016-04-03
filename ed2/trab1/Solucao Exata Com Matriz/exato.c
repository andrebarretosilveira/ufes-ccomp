/*                                                 *
 * Solucao Exata
 *                                                 */

#include <stdio.h>
#include <stdlib.h>
#include "exato.h"
#include "matvet.h"

float defineVetorCaminho(float **mat, int **matCaminho, int posAtual, int n, int nFat){

	int i=0, j=0, k=0 , prox,indiceMenorCusto=0;
	float *custo = alocaVetorFloat(nFat), menorCusto=0;
	
	permutaVetor(n,matCaminho);

	geraVetorCusto(custo,matCaminho,mat,n,nFat);

	/*printf("\nCusto = ");
	for(i=0;i<nFat;i++){
	printf("%.2f ",custo[i]);
	}
	*/

	indiceMenorCusto = iMenorCusto(custo,nFat);

	printf("\nMenor Caminho = ");
	for(i=0;i<n;i++){
		printf("%d ",matCaminho[indiceMenorCusto][i]);
	}
	//saidaFormatada(menorCaminho,menorCusto,n);
	menorCusto = custo[indiceMenorCusto];
	printf("\nCusto Final = %.2f\n",menorCusto);
	free(custo);
	return menorCusto;
}
void geraVetorCusto(float *custo,int **matCaminho,float **matCusto,int n,int nFat){
	int i, j, posAtual, prox;
	for(i=0;i< nFat;i++){
		for(j=0;j< n;j++){
			if((matCaminho[i][0] == 0)){
				posAtual = matCaminho[i][j];
				
				if(j+1 < n)
					prox = matCaminho[i][j+1];
				else	
					prox = 0;
				
				//printf("MatCaminho j = %d\n",matCaminho[i][j]);
				custo[i] = custo[i] + matCusto[posAtual][prox]; 
			}	
		}
	}
}

int iMenorCusto(float *vet,int n){
	int i, indiceMenorCusto=0;
	float menorDist = vet[0];

	for (i = 0; i < n; i++){
		if(vet[i] != 0){
		    if (vet[i] < menorDist){
		        menorDist = vet[i];
		        indiceMenorCusto = i;
		    }
		}
	}
	return indiceMenorCusto;
}

/* Funcao que retorna verdadeiro se
 * `num' nao contem algarismos repetidos
 * e zero caso contrario. */
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

int permutaVetor(int n,int **matCaminho){
	int *num = alocaVetor(n+1), i, j, indexMatriz;

	for(i=0;i< n;i++){
		matCaminho[0][i] = i;
	}
	/* Indice da permutacao na matriz. A primeira
	 * permutacao tem indice 1, pois o indice 0
	 * eh usado para armazenar a entrada. */
	indexMatriz = 1;
 
	while ( num[n] == 0 ) {
		for(i=0; i < n; i++) {            
			if ( semRepeticao(num, n) ) {
				for(j=0; j < n; j++) {
					matCaminho[indexMatriz][j] = matCaminho[0][num[j]];
				}
				indexMatriz++;
				//printf("\nMAOE\n");
			}
			
			 num[0]++;
		}

		/* distribui os vai-uns. */
		for(i=0; i < n; i++) {
			if(num[i] == n) {
				num[i] = 0;
				num[i+1]++;
				
			}
		}

	}
	free(num);
}
