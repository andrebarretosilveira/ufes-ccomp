
all: bison flex gcc
	@echo "Done."

bison: parser.y
	bison parser.y

flex: scanner.l
	flex scanner.l

gcc: scanner.c parser.c ast.c tables.c interpreter.c
	gcc -Wall -Wextra -g -ggdb -o trab4 scanner.c parser.c ast.c tables.c interpreter.c

clean:
	@rm -f *.o *.output scanner.c parser.h parser.c trab4 *.dot *.pdf
