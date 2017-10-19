/**
 * Player class interface
 */

#ifndef PLAYER_H
#define PLAYER_H

#include <iostream>
#include <GL/glut.h>
#include <chrono>
#include "Circle.h"
#include "Rectangle.h"
#include "Arena.h"

using namespace std;

#define JUMP_RADIUS_MULT 1.5
#define ON_OBSTACLE_RADIUS_MULT 1.3
#define ARM_POS_X 5

// Foward declarations
class Rectangle;
class Circle;
class Arena;

class Player {

private:
	Arena* arena;
	Point* position;
    Circle* head;
	//Ellipse* sholders;
	Rectangle* arm, *lLeg, *rLeg;
    GLfloat moveSpeed;
    GLfloat jumpTime;
    GLfloat orgRadius;
    bool jumping;
    bool onObstacle;
    std::chrono::time_point<std::chrono::high_resolution_clock> jumpStartTime;
    std::chrono::duration<double> jumpElapsed;


public:
    // Constructor
    Player(Circle* head, Point* position, Arena* arena);

	void defineBody();
    void draw();
    void moveOnXAxis(GLfloat dx);
    void moveOnYAxis(GLfloat dy);
    void jump();
    void changeSize();
	bool canMove();
    bool isJumping();
    Circle* getHead();
    GLfloat getOrgRadius();

    // Destructor
    virtual ~Player();
};

#endif
