
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include "tables.h"

// Literals Table
// ----------------------------------------------------------------------------

#define LITERAL_MAX_SIZE 128
#define LITERALS_TABLE_MAX_SIZE 100

struct lit_table {
    char t[LITERALS_TABLE_MAX_SIZE][LITERAL_MAX_SIZE];
    int size;
};

LitTable* create_lit_table() {
    LitTable *lt = malloc(sizeof * lt);
    lt->size = 0;
    return lt;
}

int add_literal(LitTable* lt, char* s) {
    for (int i = 0; i < lt->size; i++) {
        if (strcmp(lt->t[i], s) == 0) {
            return i;
        }
    }
    strcpy(lt->t[lt->size], s);
    int idx_added = lt->size;
    lt->size++;
    return idx_added;
}

char* get_literal(LitTable* lt, int i) {
    return lt->t[i];
}

void print_lit_table(LitTable* lt) {
    printf("Literals table:\n");
    for (int i = 0; i < lt->size; i++) {
        printf("Entry %d -- %s\n", i, get_literal(lt, i));
    }
}

void free_lit_table(LitTable* lt) {
    free(lt);
}

// Symbols Table
// ----------------------------------------------------------------------------

#define SYMBOL_MAX_SIZE 128
#define SYMBOL_TABLE_MAX_SIZE 100

typedef struct {
  char name[SYMBOL_MAX_SIZE];
  int scope;
  int arity;
  int line;
  int is_cvar;
  AST* ptr;
} Entry;

struct sym_table {
    Entry t[SYMBOL_TABLE_MAX_SIZE];
    int size;
};

SymTable* create_sym_table() {
    SymTable *st = malloc(sizeof * st);
    st->size = 0;
    return st;
}

int get_size(SymTable* st) {
    return st->size;
}

int add_var(SymTable* vt, char* s, int scope, int line, int is_cvar) {
    strcpy(vt->t[vt->size].name, s);
    vt->t[vt->size].scope = scope;
    vt->t[vt->size].line = line;
    vt->t[vt->size].ptr = NULL;
    vt->t[vt->size].is_cvar = is_cvar;
    int idx_added = vt->size;
    vt->size++;
    return idx_added;
}

int add_func(SymTable* ft, char* s, int arity, int line) {
    strcpy(ft->t[ft->size].name, s);
    ft->t[ft->size].arity = arity;
    ft->t[ft->size].line = line;
    ft->t[ft->size].ptr = NULL;
    int idx_added = ft->size;
    ft->size++;
    return idx_added;
}

int lookup_var(SymTable* st, char* s, int scope) {
    for (int i = 0; i < st->size; i++) {
        if (strcmp(st->t[i].name, s) == 0 && st->t[i].scope == scope) {
            return i;
        }
    }
    return -1;
}

int lookup_func(SymTable* st, char* s) {
    for (int i = 0; i < st->size; i++) {
        if (strcmp(st->t[i].name, s) == 0) {
            return i;
        }
    }
    return -1;
}

char* get_name(SymTable* st, int i) {
    return st->t[i].name;
}

int get_scope(SymTable* st, int i) {
    return st->t[i].scope;
}

int get_arity(SymTable* st, int i) {
    return st->t[i].arity;
}

int get_line(SymTable* st, int i) {
    return st->t[i].line;
}

int get_iscvar(SymTable* st, int i) {
    return st->t[i].is_cvar;
}

AST* get_func_ptr(SymTable* st, int i) {
    return st->t[i].ptr;
}

void set_arity(SymTable* st, int i, int arity) {
    st->t[i].arity = arity;
}

void set_func_ptr(SymTable* st, int i, AST* ptr) {
    st->t[i].ptr = ptr;
}

void print_var_table(SymTable* st) {
    printf("Variables table:\n");
    for (int i = 0; i < st->size; i++) {
         printf("Entry %d -- name: %s, scope: %d, line: %d\n",
                 i, get_name(st, i), get_scope(st, i), get_line(st, i));
    }
}

void print_func_table(SymTable* st) {
    printf("Functions table:\n");
    for (int i = 0; i < st->size; i++) {
         printf("Entry %d -- name: %s, arity: %d, line: %d\n",
                 i, get_name(st, i), get_arity(st, i), get_line(st, i));
    }
}

char* type2str(IdType type) {
    switch(type) {
        case SVAR: return "SVAR";
        case CVAR: return "CVAR";
        case FUNC: return "FUNC";
        default: return "wtf";
    }
}

void free_sym_table(SymTable* st) {
    free(st);
}
