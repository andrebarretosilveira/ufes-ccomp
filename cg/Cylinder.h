/**
 * Cylinder class interface
 */

#ifndef CYLINDER_H
#define CYLINDER_H

#include <iostream>
#include <GL/glut.h>
#include <cmath>
#include "Color.h"
#include "Vector3.h"
#include "Transform.h"

#define SLICES 100
#define STACK  100
#define distance_2pts(x1,y1,x2,y2) (sqrt(pow(x2-x1, 2) + (pow(y2-y1, 2))))

using namespace std;

// Foward declarations
class Color;
class Vector3;
class Transform;

class Cylinder {

private:

public:
    GLfloat radius;
    GLfloat height;
    Transform transform;
    Color color;
    GLUquadricObj *cylinderQuadratic;
    GLUquadricObj *diskQuadratic;
    bool diskOnTop;
    bool inside;

    // Constructor
    Cylinder(GLfloat radius, GLfloat height, Transform transform, Color color);

    void render();
    void draw();
    void drawLines();

    bool isInside(Vector3 position);
    bool isTouchingCylinder(Vector3 pos, GLfloat radius);
    bool isLeavingCylinder(Vector3 pos, GLfloat radius);
    static bool isCylindersTouching(Vector3 circ1Pos, GLfloat circ1Radius, Vector3 circ2Pos, GLfloat circ2Radius);

    // Getters
    GLfloat getRadius();

    // Setters
    void setRadius(GLfloat radius);

    // Destructor
    virtual ~Cylinder();
};

#endif
