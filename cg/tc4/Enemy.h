/**
 * Enemy class interface
 */

#ifndef ENEMY_H
#define ENEMY_H

#include "Player.h"

using namespace std;

#define JUMP_TIME 1.5
#define JUMP_RADIUS_MULT 1.4
#define ON_OBSTACLE_RADIUS_MULT 1.1
#define ARM_POS_X 5
#define ARM_MAX_ROT 45
#define ARM_ROTATION_SPEED 0.3
#define ROTATION_SPEED 0.1
#define LEGS_SPEED_MULT 5

// Foward declarations
class Arena;
class Obstacle;
class Bullet;

class Enemy : Player {

private:

public:

    // Constructor
    Enemy(Circle* head, Transform transform, GLfloat moveSpeed, GLfloat bulletSpeed, Arena* arena);

    // Destructor
    virtual ~Enemy();
};

#endif
