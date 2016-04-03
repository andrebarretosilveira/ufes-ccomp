
#ifndef OPT_HEADER_FILE
#define OPT_HEADER_FILE

int *novoCaminho(float **matCusto, int *vetorCaminho, int n);
float custoCaminho(float **matCusto, int *vetorCaminho, int n);
void trocaAresta(int *vetorCaminho, int *novoCaminho, int pos1, int pos2, int n);

#endif
