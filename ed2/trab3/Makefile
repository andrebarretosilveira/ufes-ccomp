all:
	gcc -o trab3 jobs.c path.c bs.c bb.c listInt.c skewHeap.c trab3.c -Wall -Wextra
	pdflatex trab3
	bibtex trab3
	pdflatex trab3
	pdflatex trab3

clean:
	rm trab3 trab3.pdf

debug:
	gcc -o trab3 jobs.c path.c bs.c bb.c listInt.c skewHeap.c trab3.c -Wall -Wconversion -Wextra -g
