/**
 * Arena class interface
 */

#ifndef ARENA_H
#define ARENA_H

#include <iostream>
#include <GL/glut.h>
#include <cmath>
#include <list>
#include "Circle.h"

using namespace std;

// Foward declarations
class Circle;

class Arena {

private:
    Circle* outerLimit;
    Circle* innerLimit;
    list<Circle*> obstacles;

public:
    // Constructor
    Arena(Circle* outerLimit, Circle* innerLimit, list<Circle*> obstacles);

    void draw();

    bool isInside();

    // Destructor
    virtual ~Arena();
};

#endif
