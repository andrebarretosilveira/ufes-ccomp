#include "trab2.h"

int main() {
        int org, dest;
        float custo_km[N][N], custos[N][N], distancias[N][N];
        tcidade cidades[N];

        if(ler_nome_coord(cidades))
                return 1;
        if(ler_diaria_custo(cidades, custo_km))
                return 1;
        if(gerar_mat_dist(cidades, distancias))
                return 1;
        if(gerar_mat_custo(cidades, distancias, custo_km, custos))
                return 1;

        analisar_cidades(cidades);
        caminho(distancias, custos, 1, N, 0);
        caminho(distancias, custos, 1, N, 1);
        caminho(distancias, custos, 1, N, 2);

        while(1) {
                printf("\nConstruir caminho de: "); scanf("%d %d", &org, &dest);
                if(dest < org || dest == org || dest > N || org < 1)
                        printf(" * Erro: Dados de entrada incorretos *\n");
                else {
                        caminho(distancias, custos, org, dest, 1);
                        caminho(distancias, custos, org, dest, 2);
                        return 0;
                }
        }
}
