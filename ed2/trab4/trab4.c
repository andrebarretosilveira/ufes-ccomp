/**
 * TRABALHO 4 - ED2 - ALGORITMOS DE ORDENAÇÃO
 * André Barreto Silveira
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "vetor.h"
#include "simpleSorting.h"
#include "efficientSorting.h"

int main(int argc, char **argv)
{
    /* Verifica o número de parâmetros */
    if(argc != 3)
    {
        printf("Sintaxe: ./trab4 [Algoritmo] [Quantidade de numeros]\n");
        exit(1);
    }

    int n = atoi(argv[2]);
    int *v = lerVetor(n);

    /* Algoritmo Bubble Sort */
    if(!strcmp(argv[1], "bubble"))
    {
        bubbleSort(v, n);
    }

    /* Algoritmo Insertion Sort */
    else if(!strcmp(argv[1], "insertion"))
    {
        insertionSort(v, n);
    }

    /* Algoritmo Selection Sort */
    else if(!strcmp(argv[1], "selection"))
    {
        selectionSort(v, n);
    }

    /* Algoritmo Shake Sort */
    else if(!strcmp(argv[1], "shake"))
    {
        shakeSort(v, n);
    }

    /* Algoritmo Quick Sort - Pivô primeiro */
    else if(!strcmp(argv[1], "quickprimeiro"))
    {
        quickSortPrimeiro(v, 0, n-1);
    }

    /* Algoritmo Quick Sort - Pivô central */
    else if(!strcmp(argv[1], "quickcentral"))
    {
        quickSortCentral(v, n);
    }

    /* Algoritmo Quick Sort - Pivô mediana de 3 */
    else if(!strcmp(argv[1], "quickmediana3"))
    {
        quickSortMediana3(v, 0, n-1);
    }

    /* Algoritmo Quick Sort - Pivô aleatório */
    else if(!strcmp(argv[1], "quickrandom"))
    {
        srand( (unsigned)time(NULL) );
        quickSortRandom(v, 0, n-1);
    }

    /* Algoritmo Merge Sort */
    else if(!strcmp(argv[1], "merge"))
    {
        mergeSort(v, n);
    }

    /* Algoritmo Heap Sort */
    else if(!strcmp(argv[1], "heap"))
    {
        heapSort(v, n);
    }

    /* Algoritmo Shell Sort */
    else if(!strcmp(argv[1], "shell"))
    {
        shellSort(v, n);
    }

    /* Algoritmo Rank Sort */
    else if(!strcmp(argv[1], "rank"))
    {
        rankSort(v, n);
    }

    /* Algoritmo Radix Sort */
    else if(!strcmp(argv[1], "radix"))
    {
        radixSort(v, n);
    }

    /* Algoritmo Radix Sort binário */
    else if(!strcmp(argv[1], "radixbin"))
    {
        radixSortBinario(v, n);
    }

    /* ERRO: Algoritmo inexistente */
    else
    {
        printf("Algoritmo \"%s\" inexistente\n", argv[1]);
        freeVetor(v);
        exit(1);
    }

    printVetor(v, n);
    freeVetor(v);

    return 0;
}
