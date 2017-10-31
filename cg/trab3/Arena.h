/**
 * Arena class interface
 */

#ifndef ARENA_H
#define ARENA_H

#include <iostream>
#include <GL/glut.h>
#include <cmath>
#include <list>
#include <iterator>
#include "Obstacle.h"
#include "Circle.h"
#include "Player.h"
#include "Bullet.h"

using namespace std;

// Foward declarations
class Obstacle;
class Circle;
class Player;

class Arena {

private:
	

public:
    char* name;
    Circle* outerLimit;
    Circle* innerLimit;
    list<Obstacle*> obstacles;

    // Constructor
    Arena(char* name, Circle* outerLimit, Circle* innerLimit, list<Obstacle*> obstacles);

    void draw();

    bool isOnLegalLocation(Player* player);
    bool isOnLegalLocation(Bullet* bullet);
    Obstacle* isOnObstacle(Player* player);

    // Destructor
    virtual ~Arena();
};

#endif
