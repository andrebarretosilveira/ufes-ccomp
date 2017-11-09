/**
 * Obstacle class implementation
 */

#include "Obstacle.h"

// Constructor
Obstacle::Obstacle(Circle* shape, GLfloat heightPercent, bool jumpable)
{
	this->shape = shape;
	this->heightPercent = heightPercent;
	this->jumpable = jumpable;
	this->playerOn = false;
}

// Draw Obstacle
void Obstacle::draw()
{
    shape->draw();
}

bool Obstacle::isTouching(Player* player) {
	return this->shape->isTouchingCircle(player->transform.position, player->getOrgRadius());
}

bool Obstacle::isTouching(Bullet* bullet) {
	return this->shape->isTouchingCircle(bullet->transform.position, bullet->shape->getRadius());
}

bool Obstacle::canJumpOver() { return this->jumpable; }
bool Obstacle::isPlayerOn() { return this->playerOn; }

void Obstacle::setPlayerOn(bool state) { this->playerOn = state; }
GLfloat Obstacle::getHeightPercent() { return this->heightPercent; }
Circle* Obstacle::getShape() { return this->shape; }

// Destructor
Obstacle::~Obstacle() {}
