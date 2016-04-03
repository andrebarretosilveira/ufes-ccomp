/**
 * ASSINATURA DAS FUNÇÕES DA ELIMINAÇÃO DE GAUSS
 */

#include "sparse.h"

void elimGauss(Sparse *);

void substRetroativas(Sparse *);

void pivotParcial(double **A, double *b, int k, int n);
