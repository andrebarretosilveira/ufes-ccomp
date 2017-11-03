/**
 * Circle class interface
 */

#ifndef CIRCLE_H
#define CIRCLE_H

#include <iostream>
#include <GL/glut.h>
#include <cmath>
#include "Color.h"
#include "Vector3.h"
#include "Transform.h"

using namespace std;

#define distance_2pts(x1,y1,x2,y2) (sqrt(pow(x2-x1, 2) + (pow(y2-y1, 2))))


// Foward declarations
class Color;
class Vector3;
class Transform;

class Circle {

private:

public:
    int id;
    GLfloat radius;
    Transform transform;
    Color color;
    
    // Constructor
    Circle(int id, GLfloat radius, Transform transform, Color color);

    void draw(); // Draw circle using glut

    bool isInside(Vector3 position);
    bool isTouchingCircle(Vector3 pos, GLfloat radius);
    bool isLeavingCircle(Vector3 pos, GLfloat radius);

    // Getters
    GLfloat getRadius();

    // Setters
    void setRadius(GLfloat radius);

    // Destructor
    virtual ~Circle();
};

#endif
