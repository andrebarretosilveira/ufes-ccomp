/**
 * Bullet class interface
 */

#ifndef BULLET_H
#define BULLET_H

#include <iostream>
#include <GL/glut.h>
#include "Time.h"
#include "Circle.h"
#include "Vector3.h"

#define BULLET_RADIUS 10

using namespace std;

// Foward declarations
class Circle;
class Vector3;

class Bullet {

private:
    
public:
    Transform transform;
    Circle* shape;
    Vector3 moveDirection;
    GLfloat moveSpeed;

    // Constructor
    Bullet(Vector3 position, Vector3 moveDirection, GLfloat moveSpeed);

    void draw();
    void move();

    // Destructor
    virtual ~Bullet();
};

#endif
