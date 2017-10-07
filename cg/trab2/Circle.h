/**
 * Circle class interface
 */

#ifndef CIRCLE_H
#define CIRCLE_H

#include <iostream>
#include <GL/glut.h>
#include <cmath>
#include "Color.h"
#include "Point.h"

using namespace std;

// Foward declarations
class Color;
class Point;

class Circle {

private:
    GLint radius;
    Point* location;
    Color* color;

public:
    // Constructor
    Circle(GLint radius, Point* location, Color* color);

    void draw(); // Draw circle using glut
    int isInside(int x, int y);

    void moveOnXAxis(GLfloat dx);
    void moveOnYAxis(GLfloat dx);

    // Getters
    GLint getRadius();
    Point* getLocation();
    Color* getColor();

    // Setters
    void setRadius(GLint radius);
    void setLocation(Point* location);
    void setColor(Color* color);

    // Destructor
    virtual ~Circle();
};

#endif
