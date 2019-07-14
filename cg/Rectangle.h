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

class Rectangle {

private:

public:
    Transform transform;
    Color color;
    GLint width, height;

    // Constructor
    Rectangle(GLint width, GLint height, Transform transform, Color color);

    void render();

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
