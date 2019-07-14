/**
 * Vector3 class interface
 */

#ifndef VECTOR3_H
#define VECTOR3_H

#include <iostream>
#include <cmath>
#include <GL/glut.h>

using namespace std;

class Vector3 {

private:

public:
    GLfloat x, y, z;

    // Constructor
    Vector3(GLfloat x, GLfloat y, GLfloat z);
    Vector3();

    GLfloat length();
    void normalize();

    // Destructor
    virtual ~Vector3();
};

Vector3 operator+(Vector3 lhs, const Vector3& rhs);

std::ostream& operator<<(std::ostream& os, const Vector3& vector);

#endif
