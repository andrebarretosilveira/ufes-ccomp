/**
 * Vector3 class implementation
 */

#include "Vector3.h"

// Constructor
Vector3::Vector3(GLfloat x, GLfloat y, GLfloat z)
    : x(x), y(y), z(z) {}

Vector3::Vector3() {
	x = y = z = 0;
}

GLfloat Vector3::length() {
	return sqrt(x*x + y*y);
}

void Vector3::normalize() {
    float length = this->length();
 
    if(length != 0) {
        x = x/length;
        y = y/length;
    }
}

// Destructor
Vector3::~Vector3() {}
