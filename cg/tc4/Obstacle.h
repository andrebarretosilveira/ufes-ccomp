/**
 * Obstacle class interface
 */

#ifndef OBSTACLE_H
#define OBSTACLE_H

#include <iostream>
#include <GL/glut.h>
#include <chrono>
#include "Arena.h"
#include "Player.h"
#include "Circle.h"
#include "Bullet.h"

using namespace std;

// Foward declarations
class Arena;
class Player;
class Circle;

class Obstacle {

private:
    Circle* shape;
    bool jumpOver;
    bool playerOn;


public:
    // Constructor
    Obstacle(Circle* shape, bool jumpOver);

    void draw();

    bool isTouching(Player* player);
    bool isTouching(Bullet* bullet);

    Circle* getShape();
    bool canJumpOver();
    bool isPlayerOn();

    void setPlayerOn(bool state);

    // Destructor
    virtual ~Obstacle();
};

#endif
