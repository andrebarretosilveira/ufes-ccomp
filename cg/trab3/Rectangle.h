/**
 * Rectangle class interface
 */

#ifndef RECTANGLE_H
#define RECTANGLE_H

#include <iostream>
#include <GL/glut.h>
#include <cmath>
#include "Color.h"
#include "Point.h"

using namespace std;

// Foward declarations
class Color;
class Point;

class Rectangle {

private:
    GLint width, height;
    Point* position;
    Color* color;

public:
    // Constructor
    Rectangle(GLint width, GLint height, Point* position, Color* color);

    void draw(); // Draw circle using glut

    // Getters
    GLint getWidth();
    GLint getHeight();
    Point* getPosition();
    Color* getColor();

    // Setters
    void setWidth(GLint width);
    void setHeight(GLint height);
    void setPosition(Point* position);
    void setColor(Color* color);

    // Destructor
    virtual ~Rectangle();
};

#endif
