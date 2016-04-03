#ifndef IO_H
#define IO_H

#define BUFFER 300
#define TRUE 1
#define FALSE 0

typedef struct data Data;
typedef struct contour Contour;

struct data
{
	double beginX;
	double endX;
	double beginY;
	double endY;
	int amountX;
	int amountY;
	int contour;
    char* Fxy;
	Contour *elements;
};

struct contour
{
	int x;
	int y;
	double value;
};

/** [readData description] */
Data* readData(FILE*, double *a, double *b, double *c);

/** [writeMatrix description] */
void writeMatrix(double **matrix, double *vetIndependent,Data *input);

/** [freeData description] */
void freeData(Data *in);


#endif
