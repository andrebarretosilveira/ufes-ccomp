CXXFLAGS =	-O2 -g -Wall -fmessage-length=0

OBJS = Arena.o Circle.o Settings.o input.o tinyxml2.o main.o

LIBS = -lGL -lGLU -lglut

TARGET = trabalhocg

$(TARGET): $(OBJS)
	$(CXX) -o $(TARGET) $(OBJS) $(LIBS)

all: $(TARGET)

clean:
	rm -f $(OBJS) $(TARGET)
