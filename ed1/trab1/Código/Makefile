#
#  Makefile
# 
#
#############################################################
#
#
CC = gcc
CPP = g++
#
# Use only one of the next two flags
#OPTIMIZE = -O3
#WARNING = -Wall -Wpedandic
DEBUG = -g
#
CFLAGS = $(WARNING) $(OPTIMIZE) $(DEBUG)
#CFLAGS = $(OPTIMIZE)  $(DEBUG)
#
#
#
LIBS = -lm
#
ALLDEFS = 
#
OBJECTS	= energie.o tad.o
#
EXECUTABLE = energie
all: $(EXECUTABLE)
#
.c.o:	; $(CC) -c $(ALLDEFS) $(CFLAGS) $(INCPATH) -o $@ $*.c
.cpp.o:	; $(CPP) -c $(ALLDEFS) $(CFLAGS) $(INCPATH) -o $@ $*.cpp
#
$(EXECUTABLE):	$(OBJECTS)
	$(CC) -o $(EXECUTABLE) $(CFLAGS) $(OBJECTS) $(LFLAGS) $(LIBS)
#
energie.o:	energie.h tad.h
tad.o:		energie.h tad.h
#
clean :
	rm -f *.o *.ln $(EXECUTABLE) *.exe *~ *.bak
strip :
	strip $(EXECUTABLE)
