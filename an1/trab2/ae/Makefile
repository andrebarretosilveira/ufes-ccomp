# makefile for ae

# change these to reflect your Lua installation
LUA= /var/tmp/lhf/lua-5.3.1
LUAINC= $(LUA)/src
LUALIB= $(LUA)/src
LUABIN= $(LUA)/src

# these will probably work if Lua has been installed globally
#LUA= /usr/local
#LUAINC= $(LUA)/include
#LUALIB= $(LUA)/lib
#LUABIN= $(LUA)/bin

# probably no need to change anything below here
CC= gcc -std=c99
CFLAGS= $(INCS) $(WARN) -O2 $G
WARN= -pedantic -Wall -Wextra
INCS= -I$(LUAINC)
LIBS= -L$(LUALIB) -llua -lm

OBJS= ae.o
TEST= test.ae

T=tae

all:	test

test:	tae xy
	./tae < $(TEST)
	./xy

o:	$(OBJS)

tae:	$(OBJS) tae.o
	$(CC) -o $@ $@.o $(OBJS) $(LIBS)

xy:	$(OBJS) xy.o
	$(CC) -o $@ $@.o $(OBJS) $(LIBS)

clean:
	rm -f $(OBJS) core core.* tae tae.o xy xy.o

# eof
