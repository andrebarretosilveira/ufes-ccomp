
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
  int line;
  float value;
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

int add_var(SymTable* st, char* s, int line) {
    strcpy(st->t[st->size].name, s);
    st->t[st->size].line = line;
    st->t[st->size].value = 0;
    int idx_added = st->size;
    st->size++;
    return idx_added;
}

int lookup_var(SymTable* st, char* s) {
    for (int i = 0; i < st->size; i++) {
        if (strcmp(st->t[i].name, s) == 0)  {
            return i;
        }
    }
    return -1;
}

int add_or_look(SymTable* st, char* s, int line) {
    int idx = lookup_var(st, s);
    if(idx == -1)
        return add_var(st, s, line);
    else
        return idx;
}

char* get_name(SymTable* st, int i) {
    return st->t[i].name;
}

int get_line(SymTable* st, int i) {
    return st->t[i].line;
}

int get_value(SymTable* st, int i) {
    return st->t[i].value;
}

void set_value(SymTable* st, int i, int value) {
    st->t[i].value = value;
}

void print_sym_table(SymTable* st) {
    fprintf(stderr, "Variables table:\n");
    for (int i = 0; i < st->size; i++) {
         fprintf(stderr, "Entry %d -- name: %s, value: %d, line: %d\n",
                 i, get_name(st, i), get_value(st, i), get_line(st, i));
    }
}

void free_sym_table(SymTable* st) {
    free(st);
}
