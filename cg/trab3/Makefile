CXXFLAGS =	-O2 -g -Wall -fmessage-length=0 -std=gnu++11

OBJS = Arena.o Player.o Obstacle.o Settings.o Color.o Point.o Circle.o Rectangle.o input.o tinyxml2.o main.o

LIBS = -lGL -lGLU -lglut

TARGET = trabalhocg

$(TARGET): $(OBJS)
	$(CXX) -o $(TARGET) $(OBJS) $(LIBS)

all: $(TARGET)

clean:
	rm -f $(OBJS) $(TARGET)
