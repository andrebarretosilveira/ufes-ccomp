/*
 * CABEÇALHO DOS ALGORITMOS "EFICIENTES":
 * QUICKSORT, MERGESORT, HEAPSORT, RANKSORT, RADIXSORT
 */

#ifndef EFFICIENTSORTING_H
#define EFFICIENTSORTING_H

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "queue.h"

void merge(int*, const int, int);
void mergeSort(int*, const int);
void siftDown(int*, int, int);
void heapSort(int*, const int);
void quickSortPrimeiro(int*, int, int);
void quickSortCentral(int*, const int);
void quickSortMediana3(int*, int, int);
void quickSortRandom(int*, int, int);
void rankSort(int*, const int);
void radixSort(int*, const int);
void radixSortBinario(int*, const int);

#endif
