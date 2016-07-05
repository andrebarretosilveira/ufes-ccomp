#include "gmres.h"

int gmres(MAT* A, double* x, double* b, double tol, int kmax, int lmax)
{
	int i, j, I, J, N, iter, ciclos;
    double Eps, inv_aux, r, res, n_u, t;
    double *c, *s, *e, *y, *Beta, *aux;
	double **up, **h;

    N         = A->n;
    Beta      = createVector(kmax);
    c         = createVector(kmax);
    s         = createVector(kmax);
    y         = createVector(kmax);
    e         = createVector(kmax+1);
    aux       = createVector(N);
    up        = createMatrix(kmax+1, N);

	h = (double**) calloc(kmax,sizeof(double*));
	for (I=0;I<kmax;I++)
		h[I] = (double*) calloc((I+2),sizeof(double));

	Eps = tol*sqrt(InnerProduct(b,b,N));
	//printf("Eps = %.12lf\n",Eps);
	res = Eps + 1.0;
	ciclos = 0;

	//while (ciclos<lmax)
	while (ciclos<lmax && res>Eps)
	{
        MATRIX_matvec(A, aux, x);

        for (J=0; J<N; J++) {
            up[0][J] = b[J] - aux[J];
        }

		e[0] = sqrt(InnerProduct(up[0], up[0], N));

		for (I=0; I<N; I++)
			up[0][I] = up[0][I]/e[0];

		i = 0;
		//while (i<kmax)
		while (i<kmax && res>Eps )
		{
            for (J=0; J<N; J++) {
                aux[J] = 0;
            }

            MATRIX_matvec(A, aux, up[i]);

            for (J=0; J<N; J++) {
                up[i+1][J] = aux[J];
            }

            // Gram-Schmidt
			for (j=0;j<i+1;j++)
			{
				Beta[j] = InnerProduct(up[i+1],up[j],N);

				for (I=0; I<N; I++)
					up[i+1][I] -= Beta[j] * up[j][I];

				h[i][j] = Beta[j];
			}

			n_u = sqrt((InnerProduct(up[i+1],up[i+1],N)));
			h[i][i+1] = n_u;
			//h[i+1][i] = n_u;
			inv_aux = 1./n_u;

			for (I=0; I<N; I++)
				up[i+1][I] = inv_aux*up[i+1][I];


            // Algoritmo QR
			for (j=0;j<i;j++)
			{
				t = h[i][j];
				h[i][j] = c[j]*t + s[j]*h[i][j+1];
				h[i][j+1] = -s[j]*t + c[j]*h[i][j+1];
			}

			r = sqrt(h[i][i]*h[i][i] + h[i][i+1]*h[i][i+1]);
			inv_aux = 1./r;
			c[i] = inv_aux*h[i][i];
			s[i] = inv_aux*h[i][i+1];
			h[i][i] = r;
			h[i][i+1]= 0.0;
			//h[i+1][i]= 0.0;
			e[i+1] = -s[i]*e[i];
			e[i] = c[i]*e[i];
			res = fabs(e[i+1]);
			i++;

            /*
            switch(i) {
                case 1:
                case 10:
                case 20:
                case 30:
                case 40:
                case 50:
                case 60:
                case 70:
                case 80:
                case 90:
                case 100:
                    printf("%.20lf\n", res);
                default:
                    break;
            }
            */
		}
		i--;

		substRetroativas(h,y,e,i);

		for (j=0;j<i+1;j++)
			for (I=0;I<N;I++)
				x[I] += y[j]*up[j][I];

        iter = ciclos*kmax + i;
		ciclos++;
	}

    printf("  - Ciclos                   : %d\n", ciclos);
    printf("  - Iteracoes                : %d\n", iter);
    printf("  - Residuo                  : %.15lf\n", res);

    // Liberando memória
    free(Beta);
    free(c);
    free(s);
    free(e);
    free(y);
    free(aux);
    freeMatrix(up, kmax+1);
    freeMatrix(h, kmax);

	return(0);
}

int gmres_precond(MAT* A, MAT* L, MAT* U, double* x, double* b, double tol, int kmax, int lmax)
{
	int i, j, I, J, N, ciclos, iter;
    double Eps, inv_aux, r, res, n_u, t;
    double *c, *s, *e, *y, *Beta, *b_cond, *aux, *aux_cond;
	double **up, **h;

    N         = A->n;
    Beta      = createVector(kmax);
    c         = createVector(kmax);
    s         = createVector(kmax);
    y         = createVector(kmax);
    e         = createVector(kmax+1);
    up        = createMatrix(kmax+1, N);
    aux       = createVector(N);
    aux_cond  = createVector(N);
    b_cond    = createVector(N);

	h = (double**) calloc(kmax,sizeof(double*));
	for (I=0;I<kmax;I++)
		h[I] = (double*) calloc((I+2),sizeof(double));

    // Condicionando b
    precondLU(L, U, b_cond, b, N);

	Eps = tol*sqrt(InnerProduct(b_cond, b_cond, N));
	//printf("Eps = %.12lf\n", Eps);
	res = Eps + 1.0;
	ciclos = 0;

	//while (ciclos<lmax)
	while (ciclos<lmax && res>Eps)
	{
        // Ação do precondicionador
        double* p = createVector(N);
		residuo(A, x, b, p, N);
        MATRIX_matvec(A, aux, x);
        precondLU(L, U, p, aux, N);

        for (J=0; J<N; J++) {
            up[0][J] = b_cond[J] - p[J];
        }

		e[0] = sqrt(InnerProduct(up[0], up[0], N));

		inv_aux = 1./e[0];
		for (I=0; I<N; I++)
			up[0][I] = inv_aux*up[0][I];

        res = e[0];
		i = 0;
		//while (i<kmax)
		while (i<kmax && res>Eps )
		{
            for (J=0; J<N; J++) {
                aux[J] = 0;
            }

            MATRIX_matvec(A, aux, up[i]);
            precondLU(L, U, p, aux, N);

            for (J=0; J<N; J++) {
                up[i+1][J] = p[J];
            }

            // Gram-Schmidt
			for (j=0;j<i+1;j++)
			{
				Beta[j] = InnerProduct(up[i+1],up[j],N);

				for (I=0; I<N; I++)
					up[i+1][I] -= Beta[j] * up[j][I];

				h[i][j] = Beta[j];
			}

			n_u = sqrt((InnerProduct(up[i+1],up[i+1],N)));
			h[i][i+1] = n_u;
			inv_aux = 1./n_u;

			for (I=0; I<N; I++)
				up[i+1][I] = inv_aux*up[i+1][I];


            // Algoritmo QR
			for (j=0;j<i;j++)
			{
				t = h[i][j];
				h[i][j] = c[j]*t + s[j]*h[i][j+1];
				h[i][j+1] = -s[j]*t + c[j]*h[i][j+1];
			}

			r = sqrt(h[i][i]*h[i][i] + h[i][i+1]*h[i][i+1]);
			inv_aux = 1./r;
			c[i] = inv_aux*h[i][i];
			s[i] = inv_aux*h[i][i+1];
			h[i][i] = r;
			h[i][i+1]= 0.0;
			e[i+1] = -s[i]*e[i];
			e[i] = c[i]*e[i];
			res = fabs(e[i+1]);
			i++;
		}
		i--;

		substRetroativas(h,y,e,i);

		for (j=0;j<i+1;j++)
			for (I=0;I<N;I++)
				x[I] += y[j]*up[j][I];

        iter = ciclos*kmax + i+1;
		ciclos++;
	}

    printf("  - Ciclos                   : %d\n", ciclos);
    printf("  - Iteracoes                : %d\n", iter);
    printf("  - Residuo                  : %.15lf\n", res);

    // Liberando memória
    free(aux_cond);
    free(b_cond);
    free(Beta);
    free(c);
    free(s);
    free(e);
    free(y);
    free(aux);
    freeMatrix(up, kmax+1);
    freeMatrix(h, kmax);

	return(0);
}

void precondLU(MAT* L, MAT* U, double* vet_out, double* vet, int N)
{
    // Precondicionamento:
    // Ax = b ---> MAx = Mb
    // Mb' = b
    //
    // Resolver:
    // LUvet_out = vet

    double *q = createVector(N); // Vetor auxiliar

    // Lq = vet
    MATRIX_forward(L, q, vet);

    // Uvet_out = q
    MATRIX_backward(U, vet_out, q);

    free(q);
}

void residuo(MAT* A, double* x, double* b, double* vet_out, int N){
	int i = 0;
	double* r = createVector(N);;

    MATRIX_matvec(A, r, x);
	for(i = 0; i < N; i++){
		vet_out[i] = b[i] - r[i];
	}
	free(r);
}
