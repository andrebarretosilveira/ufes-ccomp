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

using namespace std;

#define JUMP_RADIUS_MULT 1.5
#define ON_OBSTACLE_RADIUS_MULT 1.3
#define ARM_POS_X 5

// Foward declarations
class Arena;

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
    void jump();
    void fire();
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
