#ifndef MATVECUTILS_H
#define MATVECUTILS_H

#include <stdlib.h>
#include <math.h>
#include "./CommonFiles/protos.h"

double* createVector(int);

double** createMatrix(int, int);

double InnerProduct(double*, double*, int);

void substRetroativas(double**, double*, double*, int);

void substSucessivas(double**, double*, double*, int);

void printVector(double*, int);

void printMatrix(double**, int, int);

void freeMatrix(double**, int);

#endif
