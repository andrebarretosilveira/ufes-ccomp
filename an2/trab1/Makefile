all: compile

FLAGS := -Wall -Wextra
DEBUGFLAGS := -Wall -Wconversion -Wextra -g
PRINCIPAL := trab1.c matrizPentadiagonal.c sistemaLinear.c sor.c dados.c

compile:
	gcc -o trab1 $(PRINCIPAL) $(FLAGS)


#latex:
#    pdflatex trab4
#    bibtex trab4
#    pdflatex trab4
#    pdflatex trab4
    
clean:
	-rm -f trab1 gera

debug:
	-gcc -o trab1 *.c  $(DEBUGFLAGS)
