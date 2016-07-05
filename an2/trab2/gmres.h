#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include "CommonFiles/protos.h"
#include "matvec-utils.h"

int gmres(MAT*, double*, double*, double, int, int);

int gmres_precond(MAT*, MAT*, MAT*, double*, double*, double, int, int);

void precondLU(MAT*, MAT*, double*, double*, int);

void residuo(MAT* A, double* x, double* b, double* vet_out, int N);
