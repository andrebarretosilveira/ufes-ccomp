/**
 * Enemy class implementation
 */

#include "Enemy.h"

// Constructor
Enemy::Enemy(Circle* head, Transform transform, GLfloat moveSpeed, GLfloat bulletSpeed, Arena* arena):
    Player(head, transform, moveSpeed, bulletSpeed, arena) {}

// Destructor
Enemy::~Enemy() {}
