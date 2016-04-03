all : compila executa clean
		
		
compila:
		gcc -c main.c trab.c psinterface.c
		gcc -o andremito main.o trab.o psinterface.o
executa:
		valgrind --track-origins=yes --leak-check=full --show-leak-kinds=all ./andremito
clean:
		rm -rf *.o
