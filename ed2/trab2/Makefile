all:
	gcc -o trab2 word.c hash.c preProcess.c trab2.c arvoreB.c -Wall -Wextra
	pdflatex trab2
	bibtex trab2
	pdflatex trab2
	pdflatex trab2

clean:
	rm -rf trab2

debug:
	gcc -o trab2 word.c hash.c preProcess.c trab2.c arvoreB.c -Wall -Wconversion -Wextra -g
