
all: gcc
	@echo "Done."

gcc: trab1.cpp tinyxml2.cpp circle_draw.cpp input.cpp
	g++ -Wall -Wextra -g -o trab1 trab1.cpp tinyxml2.cpp circle_draw.cpp input.cpp -lGL -lGLU -lglut

clean:
	@rm -f *.o trab1
