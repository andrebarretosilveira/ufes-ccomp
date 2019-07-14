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
	return sqrt(x*x + y*y + z*z);
}

void Vector3::normalize() {
    float length = this->length();

    if(length != 0) {
        x = x/length;
        y = y/length;
        z = z/length;
    }
}

std::ostream& operator<<(std::ostream& os, const Vector3& vector)
{
    os << "(" << vector.x << ", " << vector.y << ", " << vector.z << ")" << endl;
    return os;
}

Vector3 operator+(Vector3 lhs, const Vector3& rhs)
{
    lhs.x += rhs.x;
    lhs.y += rhs.y;
    lhs.z += rhs.z;

    return lhs;
}

// Destructor
Vector3::~Vector3() {}
