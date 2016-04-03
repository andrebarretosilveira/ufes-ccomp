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
void calc_Notas(char (*respostas)[NP], char *gabarito, float (*notas)[ND], float *nota_total, int num_cand);
float calc_Nota_Esp(char (*respostas)[NP], char *gabarito, int num_cand, int atual, int inf, int sup, float peso);
void resultado(float (*notas)[ND], float *nota_total, int *candidatos, int *habilitados, float *nota_habil, int *eliminados, int num_cand);
void atualizar_posicoes(int atual, int *habilitados, float *nota_habil, int *eliminados, int *cont_elim);
void desempate(int prox, int atual, float (*notas)[ND], float nota, int *habilitados, float *nota_habil, int *candidatos);

int main() {
	char gabarito[NP], respostas[TC][NP];
	int candidatos[TC], habilitados[NH+1], eliminados[TC-NH], num_cand, i, j;
	float notas[TC][ND], nota_total[TC], nota_habil[NH];

	ler_Gabarito(gabarito);
	ler_CartaoResp(candidatos, respostas, &num_cand);
	calc_Notas(respostas, gabarito, notas, nota_total, num_cand);
	resultado(notas, nota_total, candidatos, habilitados, nota_habil, eliminados, num_cand);

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
		putchar('\t');
                printf("%.2f", nota_total[i]);


	printf("\n");
	}
	printf("\n\n");

	//for(i=0; i<(num_cand-NH); i++)
	//	printf("Canditado Eliminado\nMATRICULA=%d\n\n", eliminados[i]);
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

void calc_Notas(char (*respostas)[NP], char *gabarito, float (*notas)[ND], float *nota_total, int num_cand) {
	int i, j, inf, sup;
	float peso, min, nota;

	for(i=0; i<num_cand; i++) {
                nota_total[i] = 0;

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

                        notas[i][j] = nota;

			if(nota < min)
				nota_total[i] = -1;

                        else if(nota_total[i] >= 0)
                                nota_total[i] += notas[i][j];
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


void resultado(float (*notas)[ND], float *nota_total, int *candidatos, int *habilitados, float *nota_habil, int *eliminados, int num_cand) {
	int i, j, k, check, cont_elim=0;
	float nota;

	for(i=0; i<num_cand; i++) {
                nota_habil[i] = 0;
		check = 1;

                nota = nota_total[i];

		for(j=0; j<NH; j++) {
			if(nota >= nota_habil[j]) {
				check = 0;

				if(nota == nota_habil[j]) {
                                        atualizar_posicoes(j, habilitados, nota_habil, eliminados, &cont_elim);
					desempate(i, j, notas, nota, habilitados, nota_habil, candidatos);
                                }

				else {
                                        atualizar_posicoes(j, habilitados, nota_habil, eliminados, &cont_elim);
					habilitados[j] = candidatos[i];
					nota_habil[j] = nota;
                                }

				break;
			}

		}

		if(check) {
			eliminados[cont_elim] = candidatos[i];
			cont_elim++;
		}

                for(k=0; k<NH; k++)
                        printf("%d-%.2f ", habilitados[k], nota_habil[k]);
                if(i==0)
                        printf("\t");
                printf("\t%d", habilitados[2]);
                printf("\t");
                for(k=0; k<(num_cand-NH); k++)
                        printf("%d  ", eliminados[k]);
                printf("\n");

	}
	printf("\nN. de Eliminados: %d\n", cont_elim);
}

void atualizar_posicoes(int atual, int *habilitados, float *nota_habil, int *eliminados, int *cont_elim) {
	int i;
        if(habilitados[NH] != 0) {
                eliminados[*cont_elim] = habilitados[NH];
                *cont_elim += 1;
        }

	for(i=NH-1; i>=atual; i--) {
		habilitados[i+1] = habilitados[i];
		nota_habil[i+1] = nota_habil[i];
	}

}


void desempate(int prox, int atual, float (*notas)[ND], float nota, int *habilitados, float *nota_habil, int *candidatos) {

	if(notas[prox][3] ==  notas[atual][3]) {
		if(notas[prox][0] ==  notas[atual][0]) {
			if(notas[prox][1] ==  notas[atual][1]) {
				if(notas[prox][2] ==  notas[atual][2]) {
					if(candidatos[prox] < candidatos[atual]) {
                                                habilitados[atual+1] = habilitados[atual];
						habilitados[atual] = candidatos[prox];
						nota_habil[atual] = nota;
					}
                                        else
                                                habilitados[atual+1] = habilitados[prox];

				}
				else if(notas[prox][2] >  notas[atual][2]) {
                                        habilitados[atual+1] = habilitados[atual];
					habilitados[atual] = candidatos[prox];
					nota_habil[atual] = nota;

				}
                                else
                                        habilitados[atual+1] = habilitados[prox];

			}
			else if(notas[prox][1] >  notas[atual][1]) {
                                habilitados[atual+1] = habilitados[atual];
				habilitados[atual] = candidatos[prox];
				nota_habil[atual] = nota;
                        }
                        else
                                habilitados[atual+1] = habilitados[prox];
		}
		else if(notas[prox][0] >  notas[atual][0]) {
                        habilitados[atual+1] = habilitados[atual];
			habilitados[atual] = candidatos[prox];
			nota_habil[atual] = nota;
		}
                else
                        habilitados[atual+1] = habilitados[prox];
                
	}
        else if(notas[prox][3] >  notas[atual][3]) {
                habilitados[atual+1] = habilitados[atual];
                habilitados[atual] = candidatos[prox];
                nota_habil[atual] = nota;
        }
        else
                        habilitados[atual+1] = habilitados[prox];
}
