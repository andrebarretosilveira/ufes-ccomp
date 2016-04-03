/*
 * IMPLEMENTAÇÕES DOS ALGORITMOS "EFICIENTES":
 * QUICKSORT, MERGESORT, heapSort
 */


#include "efficientSorting.h"

#define SWAP(r,s) ({ int t=r; r=s; s=t; })
#define IS_LESS(v1, v2) (v1 < v2)

void mergeSort(int* v, const int N)
{
    if (N < 2) return;
    int metade = N/2;
    mergeSort(v, metade);
    mergeSort(v + metade, N - metade);
    merge(v, N, metade);
}
void merge(int* v, const int N, int metade)
{
    int i = 0, j = metade, k;
    int* vorTemp = malloc(N * sizeof(int));
    for (k = 0; k < N; k++) {
        vorTemp[k] = j == N   ? v[i++]
        : i == metade           ? v[j++]
        : v[j] < v[i]           ? v[j++]
        :                         v[i++];
    }
    for (i = 0; i < N; i++) {
        v[i] = vorTemp[i];
    }
    free(vorTemp);
}

void heapSort(int* v, const int N)
{
    int start, end;

    /* make heap */
    for (start = (N-2)/2; start >=0; start--) {
        siftDown(v, start, N);
    }

    for (end=N-1; end > 0; end--) {
        SWAP(v[end],v[0]);
        siftDown(v, 0, end);
    }
}
void siftDown(int* v, int start, int end)
{
    int root = start;

    while ( root*2+1 < end ) {
        int child = 2*root + 1;
        if ((child + 1 < end) && IS_LESS(v[child],v[child+1])) {
            child += 1;
        }
        if (IS_LESS(v[root], v[child])) {
            SWAP( v[child], v[root] );
            root = child;
        }
        else return;
    }
}

void quickSortPrimeiro(int *v, int left, int right)
{
	int i = left, j = right, pivo;

	pivo = v[left];
	while(i <= j)
	{
		while(v[i] < pivo) i++;
		while(v[j] > pivo) j--;
		if(i <= j)
		{
			SWAP(v[i], v[j]);
			i++; j--;
		}
	}
	if(j > left) quickSortPrimeiro(v, left, j);
	if(i < right) quickSortPrimeiro(v, i, right);
}

void quickSortCentral(int* v, const int N)
{
    int i, j, pivo;

    if (N < 2) return;
    pivo = v[N/2];
    for (i = 0, j = N - 1;; i++, j--) {
        while (v[i] < pivo) i++;
        while (pivo < v[j]) j--;
        if (i >= j) break;

        SWAP(v[i], v[j]);
    }

    quickSortCentral(v, i);
    quickSortCentral(v + i, N - i);
}

void quickSortMediana3(int* v, int left, int right)
{
    int i = left, j = right, pivo, mid;

    mid = (left + right) / 2;

    if(v[right] < v[left])
        SWAP(v[right], v[left]);

    if(v[mid] < v[left])
        SWAP(v[mid], v[left]);

    if(v[right] < v[mid])
        SWAP(v[right], v[mid]);

    pivo = v[mid];

	while(i <= j)
	{
		while(v[i] < pivo) i++;
		while(v[j] > pivo) j--;
		if(i <= j)
		{
			SWAP(v[i], v[j]);
			i++; j--;
		}
	}
	if(j > left) quickSortMediana3(v, left, j);
	if(i < right) quickSortMediana3(v, i, right);
}

void quickSortRandom(int* v, int left, int right)
{
    int i = left, j = right, pivo, pos;

    pos = left + rand() % (right - left + 1);
	pivo = v[pos];
	while(i <= j)
	{
		while(v[i] < pivo) i++;
		while(v[j] > pivo) j--;
		if(i <= j)
		{
			SWAP(v[i], v[j]);
			i++; j--;
		}
	}
	if(j > left) quickSortRandom(v, left, j);
	if(i < right) quickSortRandom(v, i, right);
}

void rankSort(int* v, const int N)
{
    int i, j, z, max = 1000000;

    int *count = calloc((max + 1), sizeof(int));

    for(i = 0; i < N; i++) count[v[i]]++;
    for(i = 0, z = 0; i <= max; i++) {
        for(j = 0; j < count[i]; j++) {
            v[z++] = i;
        }
    }

    free(count);
}

void radixSort(int* v, const int N)
{
    int i, d = 1, lim = 1000000, pos;
    Queue** filas = malloc(10*sizeof(Queue));

    for(i = 0; i < 10; i++)
        filas[i] = criaQueue();

    while(d <= lim) {
        pos = 0;
        for(i = 0; i < N; i++)
		      enfileira(filas[(v[i]/d)%10], v[i]);

		for(i = 0; i < 10; i++) {
			while( !isVazio(filas[i]) ) {
				v[pos] = desenfileira(filas[i]);
				pos++;
			}
		}
        d = d * 10;
    }

    for(i = 0; i < 10; i++)
        freeQueue(filas[i]);

    free(filas);
}

void radixSortBinario(int* v, const int N)
{
    int i, d = 1, lim = 10000000, pos, filaPos;
    Queue** filas = malloc(2*sizeof(Queue));

    for(i = 0; i < 2; i++)
        filas[i] = criaQueue();

    while(d <= lim) {
        pos = 0;
        for(i = 0; i < N; i++) {
            if(v[i] & d) filaPos = 1;
            else filaPos = 0;
            enfileira(filas[filaPos], v[i]);
          }

		for(i = 0; i < 2; i++) {
			while( !isVazio(filas[i]) ) {
				v[pos] = desenfileira(filas[i]);
				pos++;
			}
		}
        d = d << 1;
    }

    for(i = 0; i < 2; i++)
        freeQueue(filas[i]);

    free(filas);
}
