
#include <stdio.h>
#include <stdlib.h>
#include "interpreter.h"
#include "tables.h"

extern SymTable *vt;
extern SymTable *ft;
extern LitTable *lt;

// Data stack -----------------------------------------------------------------

#define STACK_SIZE 100

int stack[STACK_SIZE];
int sp; // stack pointer

void push(int x) {
    stack[++sp] = x;
}

int pop() {
    return stack[sp--];
}

void init_stack() {
    for (int i = 0; i < STACK_SIZE; i++) {
        stack[i] = 0;
    }
    sp = -1;
}

void print_stack() {
    printf("*** STACK: ");
    for (int i = 0; i <= sp; i++) {
        printf("%d ", stack[i]);
    }
    printf("\n");
}

// ----------------------------------------------------------------------------

// Variables memory -----------------------------------------------------------

#define MEM_SIZE 100

int mem[MEM_SIZE];

void store(int addr, int val) {
    mem[addr] = val;
}

int load(int addr) {
    return mem[addr];
}

void init_mem() {
    for (int addr = 0; addr < MEM_SIZE; addr++) {
        mem[addr] = 0;
    }
}

// ----------------------------------------------------------------------------

//#define TRACE
#ifdef TRACE
#define trace(msg) printf("TRACE: %s\n", msg)
#else
#define trace(msg)
#endif

void write(char* str) {
    int i = 0;
    while(str[i] != '\0') {
        if(str[i] == '\\' && str[i+1] == 'n') {
            printf("\n");
            i++;
        }
        else
            printf("%c", str[i]);

        i++;
    }
}

void rec_run_ast(AST *ast);

void run_func_list(AST *ast) {
    trace("func_list");
    int size = get_child_count(ast);
    for (int i = 0; i < size-1; i++) {
        // setting funcion AST ptrs in function table
        AST* func_ptr = get_child(ast, i);
        int func_idx = get_data(func_ptr);
        set_func_ptr(ft, func_idx, func_ptr);
    }

    rec_run_ast(get_child(ast, size-1)); // run main func
}

void run_func_dcl(AST *ast) {
    trace("func_dcl");
    rec_run_ast(get_child(ast, 0)); // run func header
    rec_run_ast(get_child(ast, 1)); // run func body
}

void run_func_header(AST *ast) {
    trace("func_header");
    rec_run_ast(get_child(ast, 2)); // run param list
}

void run_func_body(AST *ast) {
    trace("func_body");
    rec_run_ast(get_child(ast, 0)); // run var list
    rec_run_ast(get_child(ast, 1)); // run block
}


void run_param_list(AST *ast) {
    trace("param_list");
    int size = get_child_count(ast);
    for (int i = 0; i < size; i++) {
        AST* child = get_child(ast, i);
        int var_idx = get_data(child);
        store(var_idx, pop());
    }
}

void run_var_list(AST *ast) {
    trace("var_list");
}

void run_arg_list(AST *ast) {
    trace("arg_list");
    int size = get_child_count(ast);
    for (int i = size-1; i >= 0; i--) {
        rec_run_ast(get_child(ast, i));
    }
}


void run_block(AST *ast) {
    trace("block");
    int size = get_child_count(ast);
    for (int i = 0; i < size; i++) {
        rec_run_ast(get_child(ast, i));
    }
}

void run_func_call(AST *ast) {
    trace("func_call");
    rec_run_ast(get_child(ast, 0)); // run arg list
    int func_idx = get_data(ast);
    AST* func_ptr = get_func_ptr(ft, func_idx);
    rec_run_ast(func_ptr); // run func dcl
}

void run_return(AST *ast) {
    trace("return");

    if(get_child_count(ast) <= 0) return;

    rec_run_ast(get_child(ast, 0));
}

void run_if(AST *ast) {
    trace("if");
    rec_run_ast(get_child(ast, 0));
    int test = pop();
    if (test == 1) {
        rec_run_ast(get_child(ast, 1)); // run if block
    } else if (test == 0 && get_child_count(ast) == 3) {
        rec_run_ast(get_child(ast, 2)); // run else block
    }
}

void run_while(AST *ast) {
    trace("while");
    rec_run_ast(get_child(ast, 0)); // run test.
    int again = pop();
    while (again) {
        rec_run_ast(get_child(ast, 1)); // run body.
        rec_run_ast(get_child(ast, 0)); // run test.
        again = pop();
    }
}

void run_assign(AST *ast) {
    trace("assign");
    rec_run_ast(get_child(ast, 1)); // run right child
    AST *child = get_child(ast, 0);
    int var_idx = get_data(child);
    store(var_idx, pop());
}

void run_input(AST *ast) {
    trace("input");
    int x;
    printf("input: ");
    scanf("%d", &x);
    push(x);
}

void run_output(AST *ast) {
    trace("output");
    rec_run_ast(get_child(ast, 0));
    int x = pop();
    printf("%d", x);
}

void run_write(AST *ast) {
    trace("write");
    AST *child = get_child(ast, 0);
    int idx = get_data(child);
    char* str = get_literal(lt, idx);
    write(str);
}

#define bin_op() \
    rec_run_ast(get_child(ast, 0)); \
    rec_run_ast(get_child(ast, 1)); \
    int r = pop(); \
    int l = pop()

void run_plus(AST *ast) {
    trace("plus");
    bin_op();
    push(l + r);
}

void run_minus(AST *ast) {
    trace("minus");
    bin_op();
    push(l - r);
}

void run_times(AST *ast) {
    trace("times");
    bin_op();
    push(l * r);
}

void run_over(AST *ast) {
    trace("over");
    bin_op();
    push((int) l / r);
}

void run_lt(AST *ast) {
    trace("lt");
    bin_op();
    push(l < r);
}

void run_le(AST *ast) {
    trace("le");
    bin_op();
    push(l <= r);
}

void run_gt(AST *ast) {
    trace("gt");
    bin_op();
    push(l > r);
}

void run_ge(AST *ast) {
    trace("ge");
    bin_op();
    push(l >= r);
}

void run_eq(AST *ast) {
    trace("eq");
    bin_op();
    push(l == r);
}

void run_neq(AST *ast) {
    trace("eq");
    bin_op();
    push(l != r);
}


void run_num(AST *ast) {
    trace("num");
    push(get_data(ast));
}

void run_id(AST *ast) {
    trace("id");
    int var_idx = get_data(ast);
    push(load(var_idx));
}

void run_svar(AST *ast) {
    trace("id");
    int var_idx = get_data(ast);
    push(load(var_idx));
}

void run_cvar(AST *ast) {
    trace("id");
    int var_idx = get_data(ast);
    push(load(var_idx));
}

void rec_run_ast(AST *ast) {
    switch(get_kind(ast)) {
        case FUNC_LIST_NODE:
            run_func_list(ast);
            break;
        case FUNC_DCL_NODE:
            run_func_dcl(ast);
            break;
        case FUNC_HEADER_NODE:
            run_func_header(ast);
            break;
        case FUNC_BODY_NODE:
            run_func_body(ast);
            break;

        case PARAM_LIST_NODE:
            run_param_list(ast);
            break;
        case VAR_LIST_NODE:
            run_var_list(ast);
            break;
        case ARG_LIST_NODE:
            run_arg_list(ast);
            break;

        case BLOCK_NODE:
            run_block(ast);
            break;
        case FUNC_CALL_NODE:
            run_func_call(ast);
            break;
        case RETURN_NODE:
            run_return(ast);
            break;
        case IF_NODE:
            run_if(ast);
            break;
        case WHILE_NODE:
            run_while(ast);
            break;
        case ASSIGN_NODE:
            run_assign(ast);
            break;
        case INPUT_NODE:
            run_input(ast);
            break;
        case OUTPUT_NODE:
            run_output(ast);
            break;
        case WRITE_NODE:
            run_write(ast);
            break;

        case PLUS_NODE:
            run_plus(ast);
            break;
        case MINUS_NODE:
            run_minus(ast);
            break;
        case TIMES_NODE:
            run_times(ast);
            break;
        case OVER_NODE:
            run_over(ast);
            break;
        case LT_NODE:
            run_lt(ast);
            break;
        case LE_NODE:
            run_le(ast);
            break;
        case GT_NODE:
            run_gt(ast);
            break;
        case GE_NODE:
            run_ge(ast);
            break;
        case EQ_NODE:
            run_eq(ast);
            break;
        case NEQ_NODE:
            run_neq(ast);
            break;

       case NUM_NODE:
            run_num(ast);
            break;
        case ID_NODE:
            run_id(ast);
            break;
        case SVAR_NODE:
            run_svar(ast);
            break;
        case CVAR_NODE:
            run_cvar(ast);
            break;

        default:
            fprintf(stderr, "Invalid kind: %s!\n", kind2str(get_kind(ast)));
            exit(1);
    }
}

void run_ast(AST *ast) {
    init_stack();
    init_mem();
    rec_run_ast(ast);
}
