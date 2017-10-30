/**
 * Player class interface
 */

#ifndef PLAYER_H
#define PLAYER_H

#include <iostream>
#include <GL/glut.h>
#include <chrono>
#include <cmath>
#include "Circle.h"
#include "Ellipse.h"
#include "Rectangle.h"
#include "Arena.h"
#include "Time.h"
#include "Bullet.h"

using namespace std;

#define JUMP_RADIUS_MULT 1.5
#define ON_OBSTACLE_RADIUS_MULT 1.3
#define ARM_POS_X 5
#define ARM_MAX_ROT 45
#define BULLET_MOVE_SPEED 0.1

// Foward declarations
class Arena;
class Bullet;

class Player {

private:
	Arena* arena;
    Circle* head;
	Ellipse* sholders;
	Rectangle* arm, *lLeg, *rLeg;
    GLfloat moveSpeed;
    GLfloat rotationSpeed;
    GLfloat jumpTime;
    GLfloat orgRadius;
    Vector3 lastMousePos;
    bool jumping;
    bool onObstacle;
    std::chrono::duration<double> jumpElapsed;


public:
    Transform transform;

    // Constructor
    Player(Circle* head, Transform transform, Arena* arena);

	void defineBody();
    void draw();
    void drawLegs(bool leftLegFoward);
    void move(GLfloat direction);
    void rotate(GLfloat direction);
    void rotateArm(GLfloat x, GLfloat y);
    void rotateArm(Vector3 mousePos);
    void jump();
    Bullet* fire();
    void changeSize();
	bool canMove();
    bool isJumping();
    bool isOnObstacle();
    Circle* getHead();
    GLfloat getOrgRadius();

    // Destructor
    virtual ~Player();
};

#endif
