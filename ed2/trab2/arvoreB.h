/**
 * - CABEÇALHO ARVORE B -
 * DEFINIÇAO DE ESTRUTURAS E ASSINATURAS DAS FUNÇOES
 */

#ifndef ARVOREB_H
#define ARVOREB_H

#define M 1001 // Ordem da Arvore B

typedef struct arvoreB ArvoreB;
struct arvoreB {
    int n;              // Número de nós ativos
    tpWord *word[M-1];  // Vetor de palavras
    ArvoreB *p[M];      // Ponteiros para subarvores
};

void buscaArvB(ArvoreB *raiz, FILE *fin);

void importArvB(ArvoreB **raiz, FILE *fin);

void geraIndex(ArvoreB *raiz, FILE *fout);

tpWord *searchArvB(ArvoreB *raiz, char *palavra);

documentList *multiSearchArvB(ArvoreB *raiz, wchar_t *linha);

documentList *sentenceSearchArvB(ArvoreB *raiz, wchar_t *linha);

void fillArvB(ArvoreB **raiz, wordList *list);

ArvoreB *insereArvB(ArvoreB *raiz, tpWord *word);

ArvoreB *insere(ArvoreB *raiz, tpWord *word, int *h, tpWord **word_retorno);

void insereWord(ArvoreB *raiz, tpWord *word, ArvoreB *filhodir);

int buscaBinaria(ArvoreB *raiz, char *palavra);

void printArvB(ArvoreB *raiz);

ArvoreB *criaArvB();

void freeArvB(ArvoreB *raiz);

#endif
