#ifndef EXATO_HEADER_FILE
#define EXATO_HEADER_FILE

int geraMelhorCaminho(int n, int *vetorCaminho,float **matCusto,int *melhorCaminho,int posAtual);
int geraCusto(float **matCusto,int *vetorCaminho,int n);
char semRepeticao(int *num, int r);

#endif

