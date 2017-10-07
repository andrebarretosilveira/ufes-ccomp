/**
 * Arena class interface
 */

#ifndef ARENA_H
#define ARENA_H

#include <iostream>
#include <GL/glut.h>
#include <cmath>
#include <list>
#include <iterator>
#include "Circle.h"

using namespace std;

// Foward declarations
class Circle;

class Arena {

private:
	

public:
    char* name;
    Circle* outerLimit;
    Circle* innerLimit;
    list<Circle*> obstacles;

    // Constructor
    Arena(char* name, Circle* outerLimit, Circle* innerLimit, list<Circle*> obstacles);

    void draw();

    bool isInside();

    // Destructor
    virtual ~Arena();
};

#endif
