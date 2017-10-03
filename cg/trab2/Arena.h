/**
 * Arena class interface
 */

#ifndef ARENA_H
#define ARENA_H

#include <iostream>
#include <GL/glut.h>
#include <cmath>

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
    Arena(Circle* outerLimit, Circle* innerLimit);

    void Draw();

    bool isInside();

    // Destructor
    virtual ~Arena();
};

#endif
