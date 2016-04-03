
#ifndef PILHA_HEADER_FILE
#define PILHA_HEADER_FILE

typedef struct cidade {
    float x;
    float y;
    int id;
} Cidade;

typedef struct no {
    Cidade *c;
    struct no *prox;
} No;

typedef struct {
    No *topo;
} Pilha;

Pilha *criaPilha();
No *criaNo(Cidade *c);
void *push(Pilha *p, Cidade *c);
No *pop(Pilha *p);
void imprimePilha(Pilha *p);
void freePilha(Pilha *p);

#endif
