/**
 * Player class interface
 */

#ifndef PLAYER_H
#define PLAYER_H

#include <iostream>
#include <GL/glut.h>
#include <chrono>
#include <cmath>
#include <cstdlib>
#include "Circle.h"
#include "Ellipse.h"
#include "Rectangle.h"
#include "Arena.h"
#include "Obstacle.h"
#include "Time.h"
#include "Bullet.h"

using namespace std;

#define JUMP_TIME 1
#define JUMP_RADIUS_MULT 1.4
#define ARM_POS_X 5
#define ARM_MAX_ROT 45
#define ARM_ROTATION_SPEED 0.3
#define ROTATION_SPEED 0.1
#define LEGS_SPEED_MULT 5
#define RANDOM_ROTATION_AMOUNT 10
#define RANDOM_MOVE_AMOUNT 10
#define RANDOM_ROTATION_AMOUNT 10

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
    GLfloat fireFreq;
    GLfloat rotationSpeed;
    GLfloat jumpTime;
    GLfloat sizeScaleOnJump;
    GLfloat orgRadius;
	GLfloat fallingInitialScale;
    GLfloat legsPosCounter;
	GLint score;
    bool leftLegFoward;
    bool jumping;
    bool falling;
    bool climbed;
    bool overObstacle;
    bool onObstacle;
    bool alive;
    std::chrono::duration<double> jumpElapsed;
    std::chrono::time_point<std::chrono::high_resolution_clock> lastFireTime;


public:
    Transform transform;
    bool player;

    // Constructor
    Player(Circle* head, Transform transform, GLfloat moveSpeed, GLfloat bulletSpeed, GLfloat fireFreq, Arena* arena);

	void defineBody();
    void draw();
    void drawLegs(bool leftLegFoward);
    void move(GLfloat direction);
    void rotate(GLfloat direction);
    void rotateArm(GLfloat mouseX, GLfloat mouseY);
    void updateLegsPos(GLfloat direction);
    void moveRandomly();
    void jump();
    Bullet* fire();
    Bullet* fireOnFreq();
	void jumpLogic();
    void changeSize(GLfloat sizeScaleOnJump, Obstacle* obstacle);
	void fallOnLeaveObstacle();
	bool canMove();
    bool isJumping();
    bool isOnObstacle();
    bool canClimb(Obstacle* obstacle);
    bool hasClimbed();
	void incrementScore();
    Circle* getHead();
	GLint getScore();
    GLfloat getOrgRadius();
    void setArena(Arena* arena);
    bool gotHitBy(Bullet* bullet);
    void die();

    // Destructor
    virtual ~Player();
};

#endif
