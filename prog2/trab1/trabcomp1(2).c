#include <stdio.h>

/** DEFINIÇÃO DE CONSTANTES: **/
#define TC 100	// Máximo de Candidatos
#define NP 20	// Número de Perguntas
#define NA 4	// Número de Alternativas das questões
#define ND 4	// Número de Disciplinas
#define NH 2	// Número de Habilitados

// Número de Questões
#define Port 5
#define Logic 3
#define Etic 2
#define Conhec 10

// Pesos
#define PP 2.5
#define PL 1.5
#define PE 1.0
#define PC 3.5

// Pontuações Mínimas
#define MP 5.0
#define ML 1.5
#define ME 1.0
#define MC 14.0
/** ------------------------ **/

void ler_Gabarito(char *gabarito);
void ler_CartaoResp(int *candidatos, char (*respostas)[NP], int *num_cand);
char alternativa();
void calc_Notas(char (*respostas)[NP], char *gabarito, float (*notas)[ND], int num_cand);
float calc_Nota_Esp(char (*respostas)[NP], char *gabarito, int num_cand, int atual, int inf, int sup, float peso);
void resultado(float (*notas)[ND], int *candidatos, int *habilitados, float *nota_habil, int *eliminados, int num_cand);
void atualizar_posicoes(int atual, int *habilitados, float *nota_habil, int *eliminados, int *cont_elim);
void zerar_notas(float *notas);

int main() {
	char gabarito[NP], respostas[TC][NP];
	int candidatos[TC], habilitados[NH], eliminados[TC-NH], num_cand, i, j;
	float notas[TC][ND], nota_habil[NH];

	ler_Gabarito(gabarito);
	ler_CartaoResp(candidatos, respostas, &num_cand);
	calc_Notas(respostas, gabarito, notas, num_cand);
	resultado(notas, candidatos, habilitados, nota_habil, eliminados, num_cand);

	printf("N. de candidatos: %d\n\n", num_cand);

	printf("Gabarito:  ");
	for(i=0; i<NP; i++)
		printf("%c ", gabarito[i]);

	printf("\n\n");
	for(i=0; i<num_cand; i++) {
		printf("%d:\t", candidatos[i]);
		for(j=0; j<NP; j++)
			printf("%c ", respostas[i][j]);
		putchar('\t');
		for(j=0; j<ND; j++)
			printf("%.2f ", notas[i][j]);

	printf("\n");
	}
	printf("\n\n");

//	for(i=0; i<(num_cand-NH); i++)
//		printf("Canditado Eliminado\nMATRICULA=%d\n\n", eliminados[i]);
	for(i=0; i<NH; i++)
		printf("Habilitado %d\nMATRICULA=%d\nPONTUAÇAO=%.2f\n", i+1, habilitados[i], nota_habil[i]);

	printf("\n\n");

	return 0;
}

void ler_Gabarito(char *gabarito) {
	int i;

	for(i=0; i<NP; i++) {
		scanf("%c\n", &gabarito[i]);
	}
}

void ler_CartaoResp(int *candidatos, char (*respostas)[NP], int *num_cand) {
	int i, j;

	for(i=0; i<TC; i++) {
		scanf("%d\n", &candidatos[i]);
		if(candidatos[i] == -1)
			break;

		for(j=0; j<NP; j++) {
			respostas[i][j] = alternativa();
		}
	}
	*num_cand = i;
}

char alternativa() {
	int i, opcao, cont=0, resp;
	for(i=0; i<NA; i++) {
		scanf("%d\n", &opcao);
		if(opcao == 1) {
			cont++;
			resp = i;
		}
	}
	if(cont == 1)
		return 'a' + resp;
	else
		return 'i'; //Inválido
}

void calc_Notas(char (*respostas)[NP], char *gabarito, float (*notas)[ND], int num_cand) {
	int i, j, inf, sup;
	float peso, min, nota;

	for(i=0; i<num_cand; i++) {
		for(j=0; j<ND; j++) {
			switch(j) {
				case 0:
					{
						peso = PP;
						min = MP;
						inf = 0; sup = Port;
						break;
					}
				case 1:
					{
						peso = PL;
						min = ML;
						inf = Port; sup = Port+Logic;
						break;
					}
				case 2:
					{
						peso = PE;
						min = ME;
						inf = Port+Logic; sup = Port+Logic+Etic;
						break;
					}
				case 3:
					{
						peso = PC;
						min = MC;
						inf = Port+Logic+Etic; sup = Port+Logic+Etic+Conhec;
					}

			}
			nota = calc_Nota_Esp(respostas, gabarito, num_cand, i, inf, sup, peso);

			if(nota < min)
				notas[i][j] = -1;
			else
				notas[i][j] = nota;
		}
	}
}

float calc_Nota_Esp(char (*respostas)[NP], char *gabarito, int num_cand, int atual, int inf, int sup, float peso) {
	int i;
	float nota=0;

	for(i=inf; i<sup; i++)
		if(respostas[atual][i] == gabarito[i])
			nota += 1*peso;
	return nota;
}


void resultado(float (*notas)[ND], int *candidatos, int *habilitados, float *nota_habil, int *eliminados, int num_cand) {
	int i, j, k, check, cont_elim=0;
	float nota;

	zerar_notas(nota_habil);
	for(i=0; i<num_cand; i++) {
		nota = 0;
		check = 1;

		for(j=0; j<ND; j++)
			nota += notas[i][j];

		for(j=0; j<NH; j++) {
			if(nota >= nota_habil[j]) {
				check = 0;

				if(i >= NH)
					atualizar_posicoes(j, habilitados, nota_habil, eliminados, &cont_elim);

				if(nota == nota_habil[j])
					i = i;
					//desempate(i, j, notas, habilitados, candidatos);
				else {
					habilitados[j] = candidatos[i];
					nota_habil[j] = nota;
					for(k=0; k<NH; k++)
						printf("%d-%.2f ", habilitados[k], nota_habil[k]);
					printf("\n");
				}
				break;
			}
		}

		if(check) {
			eliminados[cont_elim] = candidatos[i];
			cont_elim++;
		}

	}
	printf("\nN. de Eliminados: %d\n", cont_elim);
}

void zerar_notas(float *notas) {
	int i;
	for(i=0; i<NH; i++)
		notas[i] = 0;
}


void atualizar_posicoes(int atual, int *habilitados, float *nota_habil, int *eliminados, int *cont_elim) {
	int i;
	eliminados[*cont_elim] = habilitados[NH-1];
	*cont_elim++;
	for(i=NH-2; i>=atual; i--) {
		habilitados[i+1] = habilitados[i];
		nota_habil[i+1] = nota_habil[i];
	}

}

/*
int desempate(int prox, int atual, float (*notas)[ND], int *habilitados, int *candidatos) {

	if(notas[prox][3] >  notas[atual][3])
		return prox;
	else if(notas[prox][3] <  notas[atual][3])
		return atual;
	else {
		if(notas[prox][1] >  notas[atual][1])
			return prox;
		else if(notas[prox][1] <  notas[atual][1])
			return atual;
		else {
		}
	}
}
*/
