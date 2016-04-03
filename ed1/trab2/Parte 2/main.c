#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>
#include "pilha.h"
#include "psinterface.h"

int main(){
    FILE* op;
    op = fopen("MENINO.txt","w");
    node *Pilha = criaPilha(Pilha);
    
    char *sfinal = translate(Pilha,"F+F-F",4,100);
    fprintf(op,"%s",sfinal);
    genpsTurtle( 6, 1, 0, sfinal, "saida.ps" );
    
    libera(Pilha);
    free(Pilha);
    free(sfinal);
    fclose(op);
	return 0;
}
