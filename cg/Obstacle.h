/**
 * Obstacle class interface
 */

#ifndef OBSTACLE_H
#define OBSTACLE_H

#include <iostream>
#include <GL/glut.h>
#include <list>
#include <chrono>
#include <algorithm>
#include "Arena.h"
#include "Player.h"
#include "Cylinder.h"
#include "Bullet.h"

using namespace std;

// Foward declarations
class Arena;
class Player;
class Bullet;
class Cylinder;

class Obstacle {

private:

public:
    Cylinder* shape;
    list<Player*> playersOn;
    bool jumpable;
    // bool playerOn;

    // Constructor
    Obstacle(Cylinder* shape, bool jumpable);

    void render();
    void draw();

    bool isTouching(Player* player);
    bool isTouching(Bullet* bullet);

    Cylinder* getShape();
    bool canJumpOver();
    bool isPlayerOn(Player* player);

    void setPlayerOn(Player* player, bool state);

    // Destructor
    virtual ~Obstacle();
};

#endif
