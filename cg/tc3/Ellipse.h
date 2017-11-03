/**
 * Ellipse class interface
 */

#ifndef ELLIPSE_H
#define ELLIPSE_H

#include <iostream>
#include <GL/glut.h>
#include <cmath>
#include "Color.h"
#include "Transform.h"

using namespace std;

// Foward declarations
class Color;
class Transform;

class Ellipse {

private:
    GLfloat radiusX, radiusY;

public:
    Transform transform;
    Color color;
    
    // Constructor
    Ellipse(GLfloat radiusX, GLfloat radiusY, Transform transform, Color color);

    void draw(); // Draw circle using glut
    
    // Destructor
    virtual ~Ellipse();
};

#endif
