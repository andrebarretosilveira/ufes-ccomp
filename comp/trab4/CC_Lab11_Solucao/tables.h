
#ifndef TABLES_H
#define TABLES_H

// Symbols Table
// ----------------------------------------------------------------------------

struct sym_table;
typedef struct sym_table SymTable;

SymTable* create_sym_table();
int get_size(SymTable*);
int add_or_look(SymTable*, char*, int);
char* get_name(SymTable*, int);
int get_line(SymTable*, int);
void print_var_table(SymTable*);
void free_sym_table(SymTable*);

#endif // TABLES_H

