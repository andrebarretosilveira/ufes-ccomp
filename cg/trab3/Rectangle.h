/**
 * Rectangle class interface
 */

#ifndef RECTANGLE_H
#define RECTANGLE_H

#include <iostream>
#include <GL/glut.h>
#include <cmath>
#include "Color.h"
#include "Transform.h"

using namespace std;

// Foward declarations
class Color;
class Transform;

class Rectangle {

private:
    GLint width, height;

public:
    Transform transform;
    Color color;
    
    // Constructor
    Rectangle(GLint width, GLint height, Transform transform, Color color);

    void draw(); // Draw circle using glut

    // Getters
    GLint getWidth();
    GLint getHeight();

    // Setters
    void setWidth(GLint width);
    void setHeight(GLint height);

    // Destructor
    virtual ~Rectangle();
};

#endif
