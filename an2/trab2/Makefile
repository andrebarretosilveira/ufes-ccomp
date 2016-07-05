CC         = gcc
CFLAGS     = -c -lm -Wall
GCFLAGS    = -lm -Wall
SOURCES    = ./CommonFiles/matrix.c        \
			 ./CommonFiles/linked_list.c   \
			 ./CommonFiles/graph.c         \
			 ./CommonFiles/ilup.c          \
			 ./CommonFiles/rcm.c           \
			 matvec-utils.c                \
			 gmres.c                       \
			 trab2.c

OBJECTS    = $(SOURCES:.c=.o)
EXECUTABLE = trab2

all: $(SOURCES) $(EXECUTABLE)

$(EXECUTABLE): $(OBJECTS)
	$(CC) $(OBJECTS) $(GCFLAGS) -o $@

clean:
	rm -f $(OBJECTS) $(EXECUTABLE)
