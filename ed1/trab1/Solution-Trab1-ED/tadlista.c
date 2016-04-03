#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "lista.h"

/** DEFINICOES DOS STRUCTS **/

// Listas
struct TipoListaCasas {
        tcasa *Primeiro, *Ultimo;
};

struct TipoListaRuas {
        trua *Primeiro, *Ultimo;
};

struct TipoListaBairros {
        tbairro *Primeiro, *Ultimo;
};

// Itens
struct TipoCasa {
        int id;
        int numero;
        int idcons;
        float consumo;
        char *nome_consumidor;
        tcasa* prox;
};

struct TipoRua {
        int id;
        char *nome;
        trua* prox;
        tlcasas* ListaCasas;
};

struct TipoBairro {
        int id;
        char *nome;
        tbairro* prox;
        tlruas* ListaRuas;
};

struct TipoCidade {
        tlbairros* ListaBairros;
};

/** FUNCOES PRINCIPAIS **/

// ADMINISTRATIVAS
int IncluirBairro(tcidade *Cidade, int id, char *nome) {
        tbairro* NovoBairro = NULL;
        tbairro* p = NULL;
        p = EncontraBairro(Cidade, id);
        if(p != NULL)
                // Bairro ja existe
                return 1;
        else {
                // Incluindo bairro...
		NovoBairro = CriaBairro(id, nome);
                InsereBairro(NovoBairro, Cidade->ListaBairros);
                return 0;
        }
}
int IncluirRua(tcidade* Cidade, int idb, int id, char *nome) {
        trua* NovaRua = NULL;
        tbairro* pcbairro = NULL;
        trua* pcrua = NULL;

        pcbairro = EncontraBairro(Cidade, idb);
        if(pcbairro == NULL)
                // Bairro nao encontrado
                return 1;

        else {
                pcrua = EncontraRua(pcbairro, id);
                if(pcrua != NULL)
                        // Rua ja existe
                        return 1;

                else {
                        // Incluindo rua...
                        NovaRua = CriaRua(id, nome);
                        InsereRua(NovaRua, pcbairro->ListaRuas);
                        return 0;
                }
        }
}
int IncluirCasa(tcidade* Cidade, int idb, int idr, int idc, int idcons, int numero, char* nome_consumidor) {
        tcasa* NovaCasa = NULL;
        tbairro* pcbairro = NULL;
        trua* pcrua = NULL;
        tcasa* pccasa = NULL;

        pcbairro = EncontraBairro(Cidade, idb);
        if(pcbairro == NULL)
                // Bairro nao encontrado
                return 1;

        else {
                pcrua = EncontraRua(pcbairro, idr);
                if(pcrua == NULL)
                        // Rua nao encontrada
                        return 1;

                else {
                        pccasa = EncontraCasa(pcrua, idc);
                        if(pccasa != NULL)
                                // Casa ja existe
                                return 1;

                        else {
                                // Incluindo casa...
                                NovaCasa = CriaCasa(idc, numero, idcons, nome_consumidor);
                                InsereCasa(NovaCasa, pcrua->ListaCasas);
                                return 0;
                        }
                }
        }
}
int EliminarRua(tcidade* Cidade, int idb, int id) {
        tbairro* pb = NULL;
        pb = EncontraBairro(Cidade, idb);
        if(pb == NULL)
                // Bairro nao encontrado
                return 1;
        else {
                trua* pr = pb->ListaRuas->Primeiro;
                trua* ant = NULL;
                while(pr != NULL && pr->id != id) {
                        ant = pr;
                        pr = pr->prox;
                }
                if(pr == NULL) {
                        // Lista vazia ou Rua nao encontrada
                        return 1;
                }
                else {
                        if(ant == NULL)
                                // Rua procurada esta na primeira posicao
                                pb->ListaRuas->Primeiro = pr->prox;
                        else
                                // Remover Rua entre outras ruas
                                ant->prox = pr->prox;

                        if(pr->prox == NULL)
                                // Rua procurada esta na ultima posicao
                                pb->ListaRuas->Ultimo = ant;

                        LiberarRua(pr);
                        return 0;
                }
        }
}
int EliminarCasa(tcidade* Cidade, int idb, int idr, int id) {
        tbairro* pb = NULL;
        trua* pr = NULL;

        pb = EncontraBairro(Cidade, idb);
        if(pb == NULL)
                // Bairro nao encontrado
                return 1;
        else {
                pr = EncontraRua(pb, idr);
                if(pr == NULL)
                        // Rua nao encontrada
                        return 1;
                else {
                        tcasa* pc = pr->ListaCasas->Primeiro;
                        tcasa* ant = NULL;
                        while(pc != NULL && pc->id != id) {
                                ant = pc;
                                pc = pc->prox;
                        }
                        if(pc == NULL)
                                // Casa nao encontrada ou Lista vazia
                                return 1;
                        else {
                                if(ant == NULL)
                                        // Casa procurada esta na primeira posicao
                                        pr->ListaCasas->Primeiro = pc->prox;
                                else
                                        // Remover Casa entre outras casas
                                        ant->prox = pc->prox;

                                if(pc->prox == NULL)
                                        // Casa procurada esta na ultima posicao
                                        pr->ListaCasas->Ultimo = ant;

                                LiberarCasa(pc);
                                return 0;
                        }
                }
        }
}

// OPERACIONAIS
int Consumir(tcidade* Cidade, int idb, int idr, int id, int consumo) {
        tbairro* p1 = NULL;
        trua* p2 = NULL;
        tcasa* p3 = NULL;

        p1 = EncontraBairro(Cidade, idb);
        if(p1 == NULL)
                return 1;
        else {
                p2 = EncontraRua(p1, idr);
                if(p2 == NULL)
                        return 1;
                else {
                        p3 = EncontraCasa(p2, id);
                        if(p3 == NULL)
                                return 1;
                        else {
                                p3->consumo = consumo;
                                return 0;
                        }
                }
        }
}
float MedirCasa(tcidade* Cidade, int idb, int idr, int id) {
        tbairro* p1 = NULL;
        trua* p2 = NULL;
        tcasa* p3 = NULL;

        p1 = EncontraBairro(Cidade, idb);
        if(p1 == NULL)
                return -1;
        else {
                p2 = EncontraRua(p1, idr);
                if(p2 == NULL)
                        return -1;
                else {
                        p3 = EncontraCasa(p2, id);
                        if(p3 == NULL)
                                return -1;
                        else
                                return p3->consumo;
                }
        }
}
float MedirRua(tcidade* Cidade, int idb, int idr) {
        float soma=0;
        tbairro* p1 = NULL;
        trua* p2 = NULL;
        tcasa* p3 = NULL;

        p1 = EncontraBairro(Cidade, idb);
        if(p1 == NULL)
                return -1;

        p2 = EncontraRua(p1, idr);
        if(p2 == NULL)
                return -1;

        p3 = p2->ListaCasas->Primeiro;
        while(p3 != NULL) {
                soma += p3->consumo;
                p3 = p3->prox;
        }
        return soma;
}
float MedirBairro(tcidade* Cidade, int id) {
        float soma=0;
        tbairro* p1 = NULL;
        trua* p2 = NULL;
        tcasa* p3 = NULL;

        p1 = EncontraBairro(Cidade, id);
        if(p1 == NULL)
                return -1;

        p2 = p1->ListaRuas->Primeiro;
        while(p2 != NULL) {
                p3 = p2->ListaCasas->Primeiro;
                while(p3 != NULL) {
                        soma += p3->consumo;
                        p3 = p3->prox;
                }
                p2 = p2->prox;
        }
        return soma;
}
float MedirCidade(tcidade* Cidade) {
        float soma=0;
        tbairro* p1 = NULL;
        trua* p2 = NULL;
        tcasa* p3 = NULL;

        p1 = Cidade->ListaBairros->Primeiro;
        while(p1 != NULL) {
                p2 = p1->ListaRuas->Primeiro;
                while(p2 != NULL) {
                        p3 = p2->ListaCasas->Primeiro;
                        while(p3 != NULL) {
                                soma += p3->consumo;
                                p3 = p3->prox;
                        }
                        p2 = p2->prox;
                }
                p1 = p1->prox;
        }
        return soma;
}

/** FUNCOES AUXILIARES **/

// Criar os Tipos
tcidade* CriaCidade() {
        tcidade* Cidade = (tcidade*)malloc(sizeof(tcidade));
        Cidade->ListaBairros = (tlbairros*)malloc(sizeof(tlbairros));
        Cidade->ListaBairros->Primeiro = NULL;
        Cidade->ListaBairros->Ultimo= NULL;
        return Cidade;
}
tbairro *CriaBairro(int id, char* nome) {
	tbairro* Bairro = (tbairro*)malloc(sizeof(tbairro));
        Bairro->nome = (char*)malloc((strlen(nome)+1)*sizeof(char));
        Bairro->ListaRuas = (tlruas*)malloc(sizeof(tlruas));
        Bairro->ListaRuas->Primeiro = NULL;
        Bairro->ListaRuas->Ultimo = NULL;
        Bairro->id = id;
        strcpy(Bairro->nome, nome);
	return Bairro;
}
trua *CriaRua(int id, char* nome) {
	trua* Rua = (trua*)malloc(sizeof(trua));
	Rua->nome = (char*)malloc((strlen(nome)+1)*sizeof(char));
        Rua->ListaCasas = (tlcasas*)malloc(sizeof(tlcasas));
        Rua->ListaCasas->Primeiro = NULL;
        Rua->ListaCasas->Ultimo = NULL;
	Rua->id = id;
	strcpy(Rua->nome, nome);
	return Rua;
}
tcasa *CriaCasa(int idc, int num_casa, int idcons, char* nome_consumidor) {
	tcasa* Casa = (tcasa*)malloc(sizeof(tcasa));
        Casa->nome_consumidor = (char*)malloc((strlen(nome_consumidor)+1)*sizeof(char));
        Casa->id = idc;
        Casa->numero = num_casa;
        Casa->idcons = idcons;
        Casa->consumo = 0;
        strcpy(Casa->nome_consumidor, nome_consumidor);
	return Casa;
}

// Retorna o Tipo que possui o id procurado. Retorna NULL se nao encontrar
tbairro* EncontraBairro(tcidade* Cidade, int id) {
        tbairro* p = Cidade->ListaBairros->Primeiro;
        while(p != NULL && p->id != id) {
                p = p->prox;
        }
        return p;
}
trua* EncontraRua(tbairro* Bairro, int id) {
        trua* p = Bairro->ListaRuas->Primeiro;
        while(p != NULL && p->id != id)
                p = p->prox;

        return p;
}
tcasa* EncontraCasa(trua* Rua, int id) {
        tcasa* p = Rua->ListaCasas->Primeiro;
        while(p != NULL && p->id != id)
                p = p->prox;

        return p;
}

// Inserir os Itens nas Listas
void InsereBairro(tbairro* NovoBairro, tlbairros* ListaBairros) {
        if(ListaBairros->Ultimo == NULL) {
                ListaBairros->Primeiro = NovoBairro;
        }
        else {
                ListaBairros->Ultimo->prox = NovoBairro;
        }
        ListaBairros->Ultimo = NovoBairro;
        ListaBairros->Ultimo->prox = NULL;
}
void InsereRua(trua* NovaRua, tlruas *ListaRuas) {
        if(ListaRuas->Ultimo == NULL) {
                ListaRuas->Primeiro = NovaRua;
        }
        else {
                ListaRuas->Ultimo->prox = NovaRua;
        }
        ListaRuas->Ultimo = NovaRua;
        ListaRuas->Ultimo->prox = NULL;
}
void InsereCasa(tcasa* Casa, tlcasas *ListaCasas) {
        tcasa* ant = NULL;
        tcasa* p = ListaCasas->Primeiro;

        // Insercao ordenada
        while(p != NULL && p->numero < Casa->numero) {
                ant = p;
                p = p->prox;
        }
        if(p == NULL) {
                // Inserir em uma lista vazia
                if(ant == NULL) {
                        ListaCasas->Primeiro = ListaCasas->Ultimo = Casa;
                }
                // Inserir na ultima posicao
                else {
                        ListaCasas->Ultimo->prox = Casa;
                        ListaCasas->Ultimo = Casa;
                }
                ListaCasas->Ultimo = Casa;
                ListaCasas->Ultimo->prox = NULL;
                free(p);
        }
        else {
                // Inserir na primeira posicao
                if(ant == NULL) {
                        ListaCasas->Primeiro = Casa;
                        ListaCasas->Primeiro->prox = p;
                        ListaCasas->Primeiro = Casa;
                }
                // Inserir em qualquer posicao entre duas s ja existentes
                else {
                        ant->prox = Casa;
                        ant->prox = Casa;
                        Casa->prox = p;
                }
        }
}

// Liberar espaco de memoria dos Tipos
void LiberarCidade(tcidade* Cidade) {
        LiberarListaBairros(Cidade->ListaBairros);
        free(Cidade);
}
void LiberarBairro(tbairro* Bairro) {
        LiberarListaRuas(Bairro->ListaRuas);
        free(Bairro->nome);
        free(Bairro);
}
void LiberarRua(trua* Rua) {
        LiberarListaCasas(Rua->ListaCasas);
        free(Rua->nome);
        free(Rua);
}
void LiberarCasa(tcasa* Casa) {
        free(Casa->nome_consumidor);
        free(Casa);
}

// Liberar espaco de memoria de uma Lista
void LiberarListaBairros(tlbairros* ListaBairros) {
        tbairro* p = ListaBairros->Primeiro;
        tbairro* aux = NULL;

        while(p != NULL) {
                aux = p->prox;
                LiberarBairro(p);
                p = aux;
        }
        free(ListaBairros);
}
void LiberarListaRuas(tlruas* ListaRuas) {
        trua* p = ListaRuas->Primeiro;
        trua* aux = NULL;

        while(p != NULL) {
                aux = p->prox;
                LiberarRua(p);
                p = aux;
        }
        free(ListaRuas);
}
void LiberarListaCasas(tlcasas* ListaCasas) {
        tcasa* p = ListaCasas->Primeiro;
        tcasa* aux = NULL;

        while(p != NULL) {
                aux = p->prox;
                LiberarCasa(p);
                p = aux;
        }
        free(ListaCasas);
}
