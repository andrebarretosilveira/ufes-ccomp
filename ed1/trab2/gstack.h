typedef struct gstack	{
	double posx, posy;
	double orientation;
	double strokelength;
	uint colorindex;
	struct gstack *next;
} Gstack;


Gstack *push( Gstack *g, double posx, double posy, double orientation,  
	      double strokelength, uint colorindex);

Gstack *top( Gstack *g );

Gstack *pop( Gstack *g );

Gstack *freeGstack( Gstack *g );

void printGstack( Gstack *g );

#if 0
Gstack *inserirPessoa( Gstack *agenda, uint idtarefa, uint idpessoa, char *nome );

void printPessoa( Pessoa *pessoas );

void printAgenda( Gstack *t );

uint contagemTarefas( Gstack *agenda, uint idpessoa );

Gstack *limparTudo( Gstack *agenda );

#endif