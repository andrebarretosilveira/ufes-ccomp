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
    Point& point;
    Color& color;

public:
    // Constructor
    Circle(GLint radius, Point& point, Color& color);

    void draw(); // Draw circle using glut
    int isInside(int x, int y);

    // Getters
    GLint getRadius();
    Point& getPoint();
    Color& getColor();

    // Setters
    void setRadius(GLint radius);
    void setPoint(const Point& point);
    void setColor(const Color& color);

    // Destructor
    virtual ~Circle();
};

#endif
