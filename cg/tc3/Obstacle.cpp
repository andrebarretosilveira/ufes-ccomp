/**
 * Obstacle class implementation
 */

#include "Obstacle.h"

// Constructor
Obstacle::Obstacle(Circle* shape, bool jumpOver)
{
	this->shape = shape;
	this->jumpOver = jumpOver;
	this->playerOn = false;
}

// Draw Obstacle
void Obstacle::draw()
{
	glPushMatrix();
	//glTranslatef(shape->getPosition()->x,shape->getPosition()->y,shape->getPosition()->z);
    shape->draw();
	glPopMatrix();
}

bool Obstacle::isTouching(Player* player) {
	return this->shape->isTouchingCircle(player->transform.position, player->getOrgRadius());
}

bool Obstacle::isTouching(Bullet* bullet) {
	return this->shape->isTouchingCircle(bullet->transform.position, bullet->shape->getRadius());
}

bool Obstacle::canJumpOver() { return this->jumpOver; }
bool Obstacle::isPlayerOn() { return this->playerOn; }

void Obstacle::setPlayerOn(bool state) { this->playerOn = state; }

Circle* Obstacle::getShape() { return this->shape; }

// Destructor
Obstacle::~Obstacle() {}
