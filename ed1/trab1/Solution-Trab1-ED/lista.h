#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/** STRUCTS **/

// Listas
typedef struct TipoListaBairros tlbairros;
typedef struct TipoListaRuas tlruas;
typedef struct TipoListaCasas tlcasas;

// Itens
typedef struct TipoCidade tcidade;
typedef struct TipoBairro tbairro;
typedef struct TipoRua trua;
typedef struct TipoCasa tcasa;

/** FUNCOES PRINCIPAIS **/

// ADMINISTRATIVAS
int IncluirBairro(tcidade *Cidade, int idb, char *nome);
int IncluirRua(tcidade *Cidade, int idb, int idr, char* nome);
int IncluirCasa(tcidade* Cidade, int idb, int idr, int idc, int idcons, int numero, char* nome_consumidor);
int EliminarRua(tcidade* Cidade, int idb, int idr);
int EliminarCasa(tcidade* Cidade, int idb, int idr, int idc);

// OPERACIONAIS
int Consumir(tcidade *Cidade, int idb, int idr, int idc, int consumo);
float MedirCasa(tcidade *Cidade, int idb, int idr, int idc);
float MedirRua(tcidade *Cidade, int idb, int idr);
float MedirBairro(tcidade *Cidade, int idb);
float MedirCidade(tcidade *Cidade);

/** FUNCOES AUXILIARES **/

// Criar os Tipos
tcidade* CriaCidade();
tbairro* CriaBairro(int idb, char* nome);
trua* CriaRua(int idr, char* nome);
tcasa* CriaCasa(int idc, int numero, int idcons, char* nome_consumidor);

// Retorna um ponteiro para os tipos
tbairro* EncontraBairro(tcidade* Cidade, int idb);
trua* EncontraRua(tbairro* CelulaBairro, int idr);
tcasa* EncontraCasa(trua* CelulaRua, int numero);

// Inserir os Itens nas Listas apropriadas
void InsereBairro(tbairro *Bairro, tlbairros* ListaBairros);
void InsereRua(trua* Rua, tlruas* ListaRuas);
void InsereCasa(tcasa* Casa, tlcasas* ListaCasas);

// Liberar espacos de memoria de um Tipo
void LiberarCidade(tcidade* Cidade);
void LiberarBairro(tbairro* Bairro);
void LiberarRua(trua* Rua);
void LiberarCasa(tcasa* Casa);

// Liberar espaco de memoria de uma Lista
void LiberarListaBairros(tlbairros* ListaBairros);
void LiberarListaRuas(tlruas* ListaRuas);
void LiberarListaCasas(tlcasas* ListaCasas);

void MostraRua(tcidade* Cidade, int idr);
