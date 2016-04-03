#
#  Makefile
#
#############################################################
#
#
CC = gcc
CPP = g++
#
# Use only one of the next two flags
#OPTIMIZE = -O3
DEBUG = -g
#
#CFLAGS = -Wall $(OPTIMIZE)  $(DEBUG)
CFLAGS = $(OPTIMIZE)  $(DEBUG)
#
#
#
LIBS = -lm
#
ALLDEFS = 
#
OBJECTS	= lsystem.o vartree.o gstack.o psinterface.o
#
EXECUTABLE = lsystem
all: $(EXECUTABLE)
#
.c.o:	; $(CC) -c $(ALLDEFS) $(CFLAGS) $(INCPATH) -o $@ $*.c
.cpp.o:	; $(CPP) -c $(ALLDEFS) $(CFLAGS) $(INCPATH) -o $@ $*.cpp
#
$(EXECUTABLE):	$(OBJECTS)
	$(CC) -o $(EXECUTABLE) $(CFLAGS) $(OBJECTS) $(LFLAGS) $(LIBS)
#
lsystem.o:	lsystem.h psinterface.h
vartree.o:	vartree.h lsystem.h
gstack.o:	gstack.h lsystem.h
psinterface.o:	psinterface.h
#
clean :
	rm -f *.o *.ln $(EXECUTABLE) *.exe *~ *.bak
strip:
	strip $(EXECUTABLE)
