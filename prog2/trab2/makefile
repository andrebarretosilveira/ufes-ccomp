all: biblioteca.o main.o
	gcc -o main main.o biblioteca.o -lm
	./main

biblioteca.c: biblioteca.c biblioteca.h
	gcc -c biblioteca.c

main.c: main.c
	gcc -c main.c

clean:
	rm -f *.o
