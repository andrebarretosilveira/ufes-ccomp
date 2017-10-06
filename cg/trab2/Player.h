/**
 * Player class interface
 */

#ifndef PLAYER_H
#define PLAYER_H

#include <iostream>
#include <GL/glut.h>
#include "Circle.h"

using namespace std;

// Foward declarations
class Circle;

class Player {

private:
    Circle* body;
    GLfloat moveSpeed;

public:
    // Constructor
    Player(Circle* body);

    void draw();

    void moveOnXAxis(GLfloat dx);
    void moveOnYAxis(GLfloat dy);

    // Destructor
    virtual ~Player();
};

#endif
