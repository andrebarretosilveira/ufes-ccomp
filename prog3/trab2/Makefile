CC=g++
CFLAGS= -c -Wall -Wextra -std=c++0x
LDFLAGS=
SOURCES=Trab2.cpp MediaCollection.cpp Media.cpp Loan.cpp Genre.cpp Person.cpp Book.cpp Movie.cpp TvSeriesSeason.cpp ConsoleInput.cpp CsvInput.cpp Report.cpp DateUtils.cpp StringUtils.cpp Tokenizer.cpp Collator.cpp Comparators.cpp
OBJECTS=$(SOURCES:.cpp=.o)
EXECUTABLE=trab2

all: $(SOURCES) $(EXECUTABLE)

$(EXECUTABLE): $(OBJECTS)
	$(CC) $(LDFLAGS) $(OBJECTS) -o $@

.cpp.o:
	$(CC) $(CFLAGS) $< -o $@

run:
	./trab2 -g generos.csv -p pessoas.csv -m midias.csv -e emprestimos.csv

clean:
	rm -f $(EXECUTABLE) $(OBJECTS)
