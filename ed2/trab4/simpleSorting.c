/*
 * IMPLEMENTAÇÕES DOS ALGORITMOS SIMPLES:
 * BUBBLESORT, INSERTIONSORT, SELECTIONSORT, SHAKESORT e SHELLSORT
 */

#include "simpleSorting.h"
#define trySwap { if (v[i] < v[i - 1])\
	{ t = v[i]; v[i] = v[i - 1]; v[i - 1] = t; t = 0;} }

void bubbleSort(int *v, const int N)
{
    int i, aux, houveTroca = 1;
    while (houveTroca) {
        houveTroca = 0;
        for (i = 0; i < N-1; i++) {
            if (v[i] > v[i+1]) {
                aux = v[i];
                v[i] = v[i+1];
                v[i+1] = aux;
                houveTroca = 1;
            }
        }
    }
}

void insertionSort(int *v, const int N)
{
    int i, j, valor;
    for (i = 1; i < N; i++) {
        valor = v[i];
        j = i-1;
        while ((j>=0) && (valor < v[j])) {
            v[j+1] = v[j];
            j--;
        }
        v[j+1] = valor;
    }
}

void selectionSort (int *v, const int N)
{
    int i, j, minPos, tmp;
    for (i = 0; i < N; i++) {
        minPos = i;
        for (j = i; j < N; j++) {
            if (v[j] < v[minPos]) {
                minPos = j;
            }
        }
        tmp = v[i];
        v[i] = v[minPos];
        v[minPos] = tmp;
    }
}

void shakeSort(int *v, const int N)
{
	int i, t = 0;
	while (!t) {
		for (i = 1, t = 1; i < N; i++) trySwap;
		if (t) break;
		for (i = N - 1, t = 1; i; i--) trySwap;
	}
}

void shellSort (int* v, const int N)
{
    int h, i, j, t;
    for (h = N; h /= 2;) {
        for (i = h; i < N; i++) {
            t = v[i];
            for (j = i; j >= h && t < v[j - h]; j -= h) {
                v[j] = v[j - h];
            }
            v[j] = t;
        }
    }
}
