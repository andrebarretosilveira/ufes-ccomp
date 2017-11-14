/**
 * Enemy class interface
 */

#ifndef ENEMY_H
#define ENEMY_H

#include "Player.h"

using namespace std;

// Foward declarations
class Arena;
class Player;
class Obstacle;
class Bullet;

class Enemy : public Player {

private:

public:

    // Constructor
    Enemy(Circle* head, Transform transform, GLfloat moveSpeed, GLfloat bulletSpeed, Arena* arena);

    // Destructor
    virtual ~Enemy();
};

#endif
