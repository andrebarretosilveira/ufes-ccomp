/**
 * Sphere class interface
 */

#ifndef SPHERE_H
#define SPHERE_H

#include <iostream>
#include <GL/glut.h>
#include <cmath>
#include "Color.h"
#include "Vector3.h"
#include "Transform.h"
#define SLICES 100
#define STACK  100

using namespace std;

#define distance_3pts(x1,y1,z1,x2,y2,z2) (sqrt(pow(x2-x1, 2) + (pow(y2-y1, 2)) + (pow(z2-z1, 2))))

// Foward declarations
class Color;
class Vector3;
class Transform;

class Sphere {

private:

public:
    GLfloat radius;
    Transform transform;
    Color color;

    // Constructor
    Sphere(GLfloat radius, Transform transform, Color color);

    void render();
    void draw();

    bool isInside(Vector3 position);
    bool isTouchingSphere(Vector3 pos, GLfloat radius);
    bool isLeavingSphere(Vector3 pos, GLfloat radius);
    static bool isSpheresTouching(Vector3 circ1Pos, GLfloat circ1Radius, Vector3 circ2Pos, GLfloat circ2Radius);

    // Getters
    GLfloat getRadius();

    // Setters
    void setRadius(GLfloat radius);

    // Destructor
    virtual ~Sphere();
};

#endif
