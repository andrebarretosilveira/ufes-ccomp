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
#include "Obstacle.h"
#include "Time.h"
#include "Bullet.h"

using namespace std;

#define JUMP_TIME 1.5
#define JUMP_RADIUS_MULT 1.4
#define ON_OBSTACLE_RADIUS_MULT 1.1
#define ARM_POS_X 5
#define ARM_MAX_ROT 45
#define ARM_ROTATION_SPEED 0.3
#define ROTATION_SPEED 0.1
#define LEGS_SPEED_MULT 5

// Foward declarations
class Arena;
class Obstacle;
class Bullet;

class Player {

private:
	Arena* arena;
    Circle* head;
	Ellipse* sholders;
	Rectangle* arm, *lLeg, *rLeg;
    Vector3 mousePos;
    GLfloat moveSpeed;
    GLfloat bulletSpeed;
    GLfloat rotationSpeed;
    GLfloat jumpTime;
    GLfloat orgRadius;
	GLfloat fallingInitialScale;
    GLfloat legsPosCounter;
    bool leftLegFoward;
    bool jumping;
    bool falling;
    bool climbed;
    bool overObstacle;
	bool onObstacle;
    std::chrono::duration<double> jumpElapsed;


public:
    Transform transform;

    // Constructor
    Player(Circle* head, Transform transform, GLfloat moveSpeed, GLfloat bulletSpeed, Arena* arena);

	void defineBody();
    void draw();
    void drawLegs(bool leftLegFoward);
    void move(GLfloat direction);
    void rotate(GLfloat direction);
    void rotateArm(GLfloat mouseX, GLfloat mouseY);
    void updateLegsPos(GLfloat direction);
    void jump();
    Bullet* fire();
	void jumpLogic();
    void changeSize(GLfloat sizeScaleOnJump, Obstacle* obstacle);
	void fallOnLeaveObstacle();
	bool canMove();
    bool isJumping();
    bool isOnObstacle();
    bool canClimb();
    bool hasClimbed();
    Circle* getHead();
    GLfloat getOrgRadius();

    // Destructor
    virtual ~Player();
};

#endif
