all: processList comandosInternos comandosExternos trataStr main

processList: processList.c
	gcc -Wall -c processList.c
	
comandosInternos: comandosInternos.c
	gcc -Wall -c comandosInternos.c
	
comandosExternos: comandosExternos.c
	gcc -Wall -c comandosExternos.c
	
trataStr: trataStr.c
	gcc -Wall -c trataStr.c

main: main.c processList.o comandosInternos.o comandosExternos.o trataStr.o
	gcc -Wall -o nsh main.c processList.o comandosInternos.o comandosExternos.o trataStr.o
	
clean:
	rm nsh *.o
	
	
