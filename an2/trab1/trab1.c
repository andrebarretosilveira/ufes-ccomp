/**
 * trab1.c
 *
 * Testador do Trabalho 1 de Algoritmos
 * Numéricos: Método das Diferencas Finitas
 * Aplicado a Problemas Bidimensionais
 *
 * Autor: André Barreto Silveira
 *
 */

#include <stdlib.h>
#include <stdio.h>
#include "matrizPentadiagonal.h"

int main()
{
    MatrizPentadiagonal* matriz;
    matriz = newMatPen(12, 3);
    preencheMatPen(matriz);
    printMatPen(matriz);
    freeMatPen(matriz);

    return 0;
}
