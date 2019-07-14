/**
 * Bullet class interface
 */

#ifndef BULLET_H
#define BULLET_H

#include <iostream>
#include <GL/glut.h>
#include "Time.h"
#include "Player.h"
#include "Vector3.h"
#include "Sphere.h"
#include "Color.h"

#define BULLET_RADIUS 10

using namespace std;

// Foward declarations
class Player;

class Bullet {

private:

public:
    Transform transform;
    // Circle* shape;
    Sphere* shape;
    Vector3 moveDirection;
    GLfloat moveSpeed;
    GLfloat radius;
    bool firedByPlayer;

    // Constructor
    Bullet(Vector3 position, Vector3 moveDirection, GLfloat moveSpeed, GLfloat radius, Color color);

    void render();
    void move();
    bool isTouching(Player* player);
    void destroy();

    // Destructor
    virtual ~Bullet();
};

#endif
