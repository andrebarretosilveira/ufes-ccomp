# Lua installation
LUA= /var/tmp/lhf/lua-5.3.1
LUAINC= $(LUA)/src
LUALIB= $(LUA)/src
LUABIN= $(LUA)/src

CC=gcc
FLAGS= $(INCS) $(WARN) -O2 $G
WARN= -Wall -Wextra
INCS= -I$(LUAINC)
LIBS= -L$(LUALIB) -llua -lm
SOURCES=trab2.c io.c contorno.c sparse.c csr.c gauss.c sor.c ae.c
OBJECTS=$(SOURCES:.cpp=.o)
EXEC=trab2

all:
	$(CC) -o $(EXEC) $(SOURCES) $(FLAGS) $(LIBS)

clean:
	rm -f $(EXEC)

debug:
	$(CC) -o $(EXEC) $(SOURCES) $(FLAGS) -g
