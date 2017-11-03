/**
 * Point class interface
 */

#ifndef POINT_H
#define POINT_H

#include <iostream>
#include <GL/glut.h>

using namespace std;

class Point {

private:

public:
    GLint x, y, z;

    // Constructor
    Point(GLint x, GLint y, GLint z);

    // Destructor
    virtual ~Point();
};

#endif
