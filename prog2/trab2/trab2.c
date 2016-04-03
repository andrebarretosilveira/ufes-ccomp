#include "trab2.h"

// Ler arquivo de entrada
int ler_nome_coord(tcidade *cidades) {

        printf("Lendo arquivo %s... ", in1);
        fp = fopen(in1, "r");
        if(fp == NULL) {
                printf("Erro ao ler arquivo. Programa terminado.\n");
                return 1;
        }
        else {
                for(i=0; i<N; i++) {
                        fscanf(fp, "%[^\n]\n", cidades[i].nome);
                        fscanf(fp, "%d %d\n", &cidades[i].pos.x, &cidades[i].pos.y);
                }
                printf("OK\n");
                fclose(fp);
                return 0;
        }
}

// Ler arquivo de entrada
int ler_diaria_custo(tcidade *cidades, float (*custos)[N]) {

        printf("Lendo arquivo %s... ", in2);
        fp = fopen(in2, "r");
        if(fp == NULL) {
                printf("Erro ao ler arquivo. Programa terminado.\n");
                return 1;
        }
        else {
                for(i=0; i<N; i++)
                        fscanf(fp, "%f", &cidades[i].diaria);

                for(i=0; i<N; i++)
                        for(j=0; j<N; j++)
                                fscanf(fp, "%f", &custos[i][j]);
                printf("OK\n");
                fclose(fp);
                return 0;
        }
}

// Gera a matriz de distancias
int gerar_mat_dist(tcidade *cidades, float (*distancias)[N]) {
        float dist;

        printf("Criando arquivo %s... ", out1);
        fp = fopen(out1, "w");
        if(fp == NULL) {
                printf("Erro ao abrir arquivo. Programa terminado.\n");
                return 1;
        }
        else {
                for(i=0; i<N; i++) {
                        for(j=0; j<N; j++) {
                                dist = dist_2pontos(cidades[i].pos.x, cidades[j].pos.x, cidades[i].pos.y, cidades[j].pos.y);
                                distancias[i][j] = dist;
                                if(dist < 10) // Tabulação, para organizar a saída
                                        fprintf(fp, "0%.2f ", dist);
                                else
                                        fprintf(fp, "%.2f ", dist);

                        }
                       fprintf(fp, "\n");
                }
                printf("OK\n");
                return 0;
        }
}

// Constroi a matriz de custos
int gerar_mat_custo(tcidade *cidades, float (*distancias)[N], float (*custo_km)[N], float (*custos)[N]) {
        float custo;

        printf("Criando arquivo %s... ", out2);
        fp = fopen(out2, "w");
        if(fp == NULL) {
                printf("Erro ao abrir arquivo. Programa terminado.\n");
                return 1;
        }
        else {
                for(i=0; i<N; i++) {
                        for(j=0; j<N; j++) {
                                custo = distancias[i][j] * custo_km[i][j] + cidades[j].diaria;
                                custos[i][j] = custo;
                                if(custo < 100) // Tabulação, para organizar a saída
                                        fprintf(fp, "%.2f ", custo);
                                else
                                        fprintf(fp, "%.1f ", custo);
                        }
                        fprintf(fp, "\n");
                }
                printf("OK\n");
                fclose(fp);
                return 0;
        }
}

// Procura e mostra quais são as cidades nas extremidades do mapa e mais ao centro
void analisar_cidades(tcidade *cidades) {
        int maior_x = 0, maior_y = 0, menor_x = Mx, menor_y = My;
        float menor_dist_centro, dist_cidade;
        char cidade_norte[M], cidade_sul[M], cidade_leste[M], cidade_oeste[M], cidade_centro[M];

        menor_dist_centro = dist_2pontos(Mx, 0, My, 0); // Inicializar com a distância máxima p/ calculo da cidade ao centro

        for(i=0; i<N; i++) {
                // LESTE
                if(cidades[i].pos.x >= maior_x) {
                        if(cidades[i].pos.x != maior_x)
                                strcpy(cidade_leste, cidades[i].nome);
                        else {
                                strcat(cidade_leste, ", ");
                                strcat(cidade_leste, cidades[i].nome);
                        }
                        maior_x = cidades[i].pos.x;
                }
                // NORTE
                if(cidades[i].pos.y >= maior_y) {
                        if(cidades[i].pos.x != maior_x)
                                strcpy(cidade_norte, cidades[i].nome);
                        else {
                                strcat(cidade_norte, ", ");
                                strcat(cidade_norte, cidades[i].nome);
                        }
                        maior_y = cidades[i].pos.y;
                }
                // OESTE
                if(cidades[i].pos.x <= menor_x) {
                        if(cidades[i].pos.x != menor_x)
                                strcpy(cidade_oeste, cidades[i].nome);
                        else {
                                strcat(cidade_oeste, ", ");
                                strcat(cidade_oeste, cidades[i].nome);
                        }
                        menor_x = cidades[i].pos.x;
                }
                // SUL
                if(cidades[i].pos.y <= menor_y) {
                        if(cidades[i].pos.y != menor_y)
                                strcpy(cidade_sul, cidades[i].nome);
                        else {
                                strcat(cidade_sul, ", ");
                                strcat(cidade_sul, cidades[i].nome);
                        }
                        menor_y = cidades[i].pos.y;
                }
                // CENTRO
                dist_cidade = dist_2pontos(cidades[i].pos.x, Mx/2, cidades[i].pos.y, My/2); // Cálculo da distância da cidade até o centro do mapa
                if(dist_cidade <= menor_dist_centro) {
                        if(dist_cidade != menor_dist_centro)
                                strcpy(cidade_centro, cidades[i].nome);
                        else {
                                strcat(cidade_centro, ", ");
                                strcat(cidade_centro, cidades[i].nome);
                        }
                        menor_dist_centro = dist_cidade;
                }
        }
        printf("\nCidade(s) mais ao...\n");
        printf(" - Norte:  %s\n", cidade_norte);
        printf(" - Sul:    %s\n", cidade_sul);
        printf(" - Leste:  %s\n", cidade_leste);
        printf(" - Oeste:  %s\n", cidade_oeste);
        printf(" - Centro: %s\n", cidade_centro);

}

// Mostra o caminho entre uma cidade e outra de acordo com uma Lei (ou não) e calcula a distância e o custo da viagem
void caminho(float (*distancias)[N], float (*custos)[N], int prim, int ult, int lei) {
        float dist=0, custo=0;
        int atual, prox;

        // Segue alguma Lei de Formação
        if(lei) {
                printf("\nCidade Origem: %d\nCidade Destino: %d\nLei de Formação %d\n", prim, ult, lei);
                printf("%d", prim);
                atual = prim;
                while(atual < ult) {
                        prox = proxima_cidade(distancias, custos, atual, ult, lei);
                        printf(" -> %d", prox);
                        dist += distancias[atual-1][prox-1];
                        custo += custos[atual-1][prox-1];
                        atual = prox;
                }
                printf("\nDistancia total: %.2f km\nCusto total: R$ %.2f\n", dist, custo);
        }

        // Sequência simples
        else {
                printf("\nCidade Origem: %d\nCidade Destino: %d\n", prim, ult);
                printf("%d", prim);
                for(i=prim-1; i<ult-1; i++) {
                        printf(" -> %d", i+2);
                        dist += distancias[i][i+1];
                        custo += custos[i][i+1];
                }
                printf("\nDistancia total: %.2f km\nCusto total: R$ %.2f\n", dist, custo);
        }

}

// Retorna o valor da próxima cidade de acordo com uma das Leis de Formação
int proxima_cidade(float (*distancias)[N], float (*custos)[N], int atual, int lim, int lei) {
        float menor_dist=MD, menor_custo=MC;
        int prox, aux;

        atual--;
        switch(lei) {
                // Lei de Formação 1
                case 1:
                        {
                                for(i=atual+1; i<lim; i++) {
                                        if(distancias[atual][i] <= menor_dist) {
                                                if(distancias[atual][i] == menor_dist) {
                                                        aux = i;
                                                        // Desempate recursivo
                                                        if(num_cidades(distancias, custos, i+1, lim, lei) <= num_cidades(distancias, custos, prox+1, lim, lei)) {
                                                                prox = aux;
                                                                menor_dist = distancias[atual][prox];
                                                        }
                                                }
                                                else {
                                                        prox = i;
                                                        menor_dist = distancias[atual][prox];
                                                }
                                        }
                                }
                                break;
                        }

                // Lei de Formação 2
                case 2:
                        {
                                for(i=atual+1; i<lim; i++) {
                                        if(custos[atual][i] <= menor_custo) {
                                                if(custos[atual][i] == menor_custo) {
                                                        aux = i;
                                                        // Desempate recursivo
                                                        if(num_cidades(distancias, custos, i+1, lim, lei) <= num_cidades(distancias, custos, prox+1, lim, lei)) {
                                                                prox = aux;
                                                                menor_custo = custos[atual][prox];
                                                        }
                                                }
                                                else {
                                                        prox = i;
                                                        menor_custo = custos[atual][prox];
                                                }
                                        }
                                }
                                break;
                        }
        }
        return prox+1;
}

// Retorna o número de cidades pelo caminho para desempate
int num_cidades(float (*distancias)[N], float (*custos)[N], int prim, int ult, int lei) {
        int atual, prox, cont=0;

        atual = prim;
        while(atual < ult) {
                prox = proxima_cidade(distancias, custos, atual, ult, lei);
                atual = prox;
                cont++;
        }
        return cont;
}

// Retorna a distância entre dois pontos
float dist_2pontos(int x, int x0, int y, int y0) {
        return sqrt(pow(x-x0,2) + pow(y-y0,2));
}
