#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "nn.h"
#include "opt.h"
#include "hull.h"
#include "outros.h"

int main(int argc, char *argv[]) {
    int *vetorCaminho, n;
    float **matrizCusto, custo;
    char *algoritmo;

    if(argc < 3) {
        printf("Inserir dois argumentos: [OrdemDaMatriz] \"Algoritmo\"\n");
        return 1;
    }

    n = atoi(argv[1]);
    algoritmo = argv[2];

    if(strcmp(algoritmo, "exato") == 0) {
    }

    else if(strcmp(algoritmo, "nn") == 0 || strcmp(algoritmo, "opt") == 0) {
        matrizCusto = alocaMatriz(n, n);
        if(matrizCusto == NULL) {
            printf("Erro ao alocar a matrizCusto.\nPrograma abortado.");
            return 1;
        }
        vetorCaminho = alocaVetor(n);
        if(vetorCaminho == NULL) {
            printf("Erro ao alocar a vetor.\nPrograma abortado.");
            liberaMatriz(matrizCusto, n);
            return 1;
        }
        lerMatriz(matrizCusto, n, n);
        custo = geraVetorCaminho(matrizCusto, vetorCaminho, 0, n);

        if(strcmp(algoritmo, "opt") == 0 && n > 3)
            vetorCaminho = novoCaminho(matrizCusto, vetorCaminho, n);

        saidaFormatada(vetorCaminho, custo, n);
        liberaMatriz(matrizCusto, n);
        free(vetorCaminho);
    }

    else if(strcmp(algoritmo, "hull") == 0) {
        if(n < 4) {
            printf("*\n");
            return 0;
        }

        Cidade *cidades = malloc(n*sizeof(Cidade));
        Pilha *p=NULL, *inter=NULL;

        lerCidades(cidades, n);
        quicksort(cidades, 0, n-1);

        p = envoltorioConvexo(cidades, n);
        inter = cidadesInteriores(p, cidades, n);
        p = caminhoHull(p, inter);
        custo = custoCaminhoHull(p);
        saidaFormatadaHull(p, custo);

        freePilha(p);
        free(cidades);
        freePilha(inter);
    }

    else {
        printf("Algoritmo \"%s\" invalido.\nPrograma abortado.\n", algoritmo);
        return 1;
    }

    return 0;
}
