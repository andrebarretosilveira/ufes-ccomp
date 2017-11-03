/**
 * Color class interface
 */

#ifndef COLOR_H
#define COLOR_H

#include <iostream>
#include <GL/glut.h>

using namespace std;

class Color {

private:

public:
    GLfloat r, g, b;

    // Constructor
    Color(GLfloat r, GLfloat g, GLfloat b);

    // Destructor
    virtual ~Color();
};

#endif
