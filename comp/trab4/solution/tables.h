
#ifndef TABLES_H
#define TABLES_H

#include "ast.h"

// Literals Table
// ----------------------------------------------------------------------------

// Opaque structure.
// For simplicity, the table is implemented as a sequential list.
struct lit_table;
typedef struct lit_table LitTable;

// Creates an empty literal table.
LitTable* create_lit_table();

// Adds the given string to the table without repetitions.
// String 's' is copied internally.
// Returns the index of the string in the table.
int add_literal(LitTable* lt, char* s);

// Returns a pointer to the string stored at index 'i'.
char* get_literal(LitTable* lt, int i);

// Prints the given table to stdout.
void print_lit_table(LitTable* lt);

// Clears the allocated structure.
void free_lit_table(LitTable* lt);


// Symbols Table
// ----------------------------------------------------------------------------

// Opaque structure.
// For simplicity, the table is implemented as a sequential list.
// This table only stores the variable name and the declaration line.
struct sym_table;
typedef struct sym_table SymTable;

typedef enum id_type {
    SVAR,
    CVAR,
    FUNC
} IdType;


SymTable* create_sym_table();
int get_size(SymTable*);
int add_var(SymTable*, char*, int, int, int);
int add_func(SymTable*, char*, int, int);
int lookup_var(SymTable*, char*, int);
int lookup_func(SymTable*, char*);
char* get_name(SymTable*, int);
int get_line(SymTable*, int);
int get_value(SymTable*, int);
int get_arity(SymTable*, int);
int get_iscvar(SymTable* st, int i);
AST* get_func_ptr(SymTable*, int);
void set_arity(SymTable*, int, int);
void set_func_ptr(SymTable*, int, AST*);
char* type2str(IdType);
void print_var_table(SymTable*);
void print_func_table(SymTable*);
void free_sym_table(SymTable*);

#endif // TABLES_H

