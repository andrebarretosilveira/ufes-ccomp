all: compile gera latex
.PHONY: gera

FLAGS := -Wall -Wextra
DEBUGFLAGS := -Wall -Wconversion -Wextra -g
PRINCIPAL := trab4.c vetor.c queue.c simpleSorting.c efficientSorting.c
GERA := gera.c

compile:
	gcc -o trab4 $(PRINCIPAL) $(FLAGS)

gera:
	gcc -o gera $(GERA) $(FLAGS)

latex:
    pdflatex trab4
    bibtex trab4
    pdflatex trab4
    pdflatex trab4
    
clean:
	-rm -f trab4 gera

debug:
	-gcc -o trab4 *.c  $(DEBUGFLAGS)
