#MAKE PARA O PROGRAMA COMPILANDO C e JAVA
JVC	       = javac
JSOURCES   = Main.java Buffer.java ThreadReader.java ThreadProgress.java Pipe.java
CC         = gcc
CFLAGS     = -c -lm -pthread -Wall
GCFLAGS    = -lm -pthread -Wall 
SOURCES    = trab2.c
JOBJECTS   = $(JSOURCES:.java=.class)
OBJECTS    = $(SOURCES:.c=.o)
EXECUTABLE = trab2

all: $(SOURCES) $(EXECUTABLE)
	 $(JVC) $(JSOURCES)

runJava: 
		 java Main

runC:
	  ./trab2

$(EXECUTABLE): $(OBJECTS) 
	$(CC) $(OBJECTS) $(GCFLAGS) -o $@

clean:
	rm -f $(OBJECTS) $(EXECUTABLE)
	rm -f $(JOBJECTS)


