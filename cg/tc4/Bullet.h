/**
 * Bullet class interface
 */

#ifndef BULLET_H
#define BULLET_H

#include <iostream>
#include <GL/glut.h>
#include "Time.h"
#include "Player.h"
#include "Circle.h"
#include "Vector3.h"

#define BULLET_RADIUS 10

using namespace std;

// Foward declarations
class Player;
class Circle;
class Vector3;

class Bullet {

private:
    
public:
    Transform transform;
    Circle* shape;
    Vector3 moveDirection;
    GLfloat moveSpeed;
    GLfloat radius;
    bool firedByPlayer;

    // Constructor
    Bullet(Vector3 position, Vector3 moveDirection, GLfloat moveSpeed, GLfloat radius);

    void draw();
    void move();
    bool isTouching(Player* player);
    void destroy();

    // Destructor
    virtual ~Bullet();
};

#endif
