/**
 * Arena class interface
 */

#ifndef ARENA_H
#define ARENA_H

#include <iostream>
#include <GL/glut.h>
#include <cmath>
#include <cstring>
#include <list>
#include <iterator>
#include "Bullet.h"
#include "Obstacle.h"
#include "Circle.h"
#include "Player.h"
#include "Bullet.h"

using namespace std;

// Foward declarations
class Bullet;
class Obstacle;
class Circle;
class Player;

class Arena {

private:


public:
    char* name;
    Circle* outerLimit;
    Circle* innerLimit;
    list<Bullet*> bullets;
	list<Obstacle*> obstacles;
    list<Player*> enemies;

    // Constructor
    Arena(char* name, Circle* outerLimit, Circle* innerLimit, list<Obstacle*> obstacles, list<Player*> enemies);

    void draw();
    void drawScore(Player* player);
    void updateEnemies();
    void updateBullets(Player* player);

    bool bulletHitEnemy(Bullet* bullet);
    bool isOnLegalLocation(Player* player);
    bool isOnLegalLocation(Bullet* bullet);
    Obstacle* isOnObstacle(Player* player);

    // Destructor
    virtual ~Arena();
};

#endif
