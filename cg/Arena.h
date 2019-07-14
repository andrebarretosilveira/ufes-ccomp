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
#include "Sphere.h"
#include "Cylinder.h"

#define TIME_TO_AFTER_MSG 2

using namespace std;

// Foward declarations
class Bullet;
class Obstacle;
class Circle;
class Player;

class Arena {

private:
    std::chrono::duration<double> endMsgTimer;

public:
    char* name;
    Cylinder* outerLimit;
    Cylinder* innerLimit;
    Cylinder* ceiling;
    Player* player;
    list<Bullet*> bullets;
	list<Obstacle*> obstacles;
    list<Player*> enemies;

    Sphere* testSphere;

    // Constructor
    Arena(char* name, Cylinder* outerLimit, Cylinder* innerLimit, Player* player, list<Obstacle*> obstacles, list<Player*> enemies);

    void render(bool textOn);
    void render2D();
    void drawScore();
    void drawInvincibleText();
    void drawLifeText();
    void drawEndGameText(bool playerWon);
    void drawPaused();

    void update();
    void updateEnemies();
    void updateBullets();

    void reset();

    bool allEnemiesDead();
    bool bulletHitEnemy(Bullet* bullet);
    bool isOnLegalLocation(Player* player);
    bool isOnLegalLocation(Bullet* bullet);
    Obstacle* isTouchingObstacle(Player* player);

    // Destructor
    virtual ~Arena();
};

#endif
