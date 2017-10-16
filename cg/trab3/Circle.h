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

#define distance_2pts(x1,y1,x2,y2) (sqrt(pow(x2-x1, 2) + (pow(y2-y1, 2))))


// Foward declarations
class Color;
class Point;

class Circle {

private:
    int id;
    GLfloat radius;
    Point* position;
    Color* color;

public:
    // Constructor
    Circle(int id, GLfloat radius, Point* position, Color* color);

    void draw(); // Draw circle using glut

    bool isInside(Point* position);

    bool isTouchingCircle(Circle* circle);
    bool isLeavingCircle(Circle* circle);

    void moveOnXAxis(GLfloat dx);
    void moveOnYAxis(GLfloat dx);

    // Getters
    GLfloat getRadius();
    Point* getPosition();
    Color* getColor();

    // Setters
    void setRadius(GLfloat radius);
    void setPosition(Point* position);
    void setColor(Color* color);

    // Destructor
    virtual ~Circle();
};

#endif
