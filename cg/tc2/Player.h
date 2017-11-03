/**
 * Player class interface
 */

#ifndef PLAYER_H
#define PLAYER_H

#include <iostream>
#include <GL/glut.h>
#include <chrono>
#include "Circle.h"
#include "Arena.h"

using namespace std;

#define JUMP_RADIUS_MULT 1.5
#define ON_OBSTACLE_RADIUS_MULT 1.3

// Foward declarations
class Circle;
class Arena;

class Player {

private:
	Arena* arena;
    Circle* body;
    GLfloat moveSpeed;
    GLfloat jumpTime;
    GLfloat orgRadius;
    bool jumping;
    bool onObstacle;
    std::chrono::time_point<std::chrono::high_resolution_clock> jumpStartTime;
    std::chrono::duration<double> jumpElapsed;


public:
    // Constructor
    Player(Circle* body, Arena* arena);

    void draw();

    bool canMove();

    void moveOnXAxis(GLfloat dx);
    void moveOnYAxis(GLfloat dy);

    void jump();
    void changeSize();

    bool isJumping();

    Circle* getBody();
    GLfloat getOrgRadius();

    // Destructor
    virtual ~Player();
};

#endif
