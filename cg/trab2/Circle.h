/**
 * Circle class interface
 */

#ifndef CIRCLE_H
#define CIRCLE_H

#include <iostream>
#include <GL/glut.h>
#include <cmath>

using namespace std;

// Foward declarations
//class OtherClassUsedHere;

class Circle {

private:
    int radius;
    int x, y;
    int color_R, color_G, color_B;

public:
    // Constructor
    Circle(const int radius, const int x, const int y, const int color_R, const int color_G, const int color_B);

    void draw(); // Draw circle using glut
    int isInside(int x, int y);

    // Getters
    int getRadius();
    int getX();
    int getY();

    // Setters
    void setRadius(const int radius);
    void setX(const int x);
    void setY(const int y);

    // Destructor
    virtual ~Circle();
};

#endif
