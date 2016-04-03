CC = gcc
CFLAGS = -Wall -Wextra -Wconversion -pedantic  
OBJ = main.o csr.o
LIBS =  

#all: 

%.o: %.c
	$(CC) -c -o $@ $< $(CFLAGS) 
	
trab1: $(OBJ)
	$(CC) -o $@ $^ $(LIBS) 
	$(MAKE) clean

clean:
	rm -f *.o

