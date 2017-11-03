/**
 * Transform class interface
 */

#ifndef TRANSFORM_H
#define TRANSFORM_H

#include <iostream>
#include <GL/glut.h>
#include <cmath>
#include "Vector3.h"

#define DEG2RAD M_PI/180
#define RAD2DEG 180/M_PI
#define d2pts(x1,y1,x2,y2) (sqrt(pow(x2-x1, 2) + (pow(y2-y1, 2))))

using namespace std;

class Transform {

private:

public:
    Vector3 position;
    Vector3 rotation;
    Vector3 scale;

    // Constructor
    Transform(Vector3 position, Vector3 rotation, Vector3 scale);

    void Translate(GLfloat x, GLfloat y, GLfloat z);
    void Rotate(GLfloat x, GLfloat y, GLfloat z);
    void Scale(GLfloat x, GLfloat y, GLfloat z);

    void print();

    // Destructor
    virtual ~Transform();
};

#endif
