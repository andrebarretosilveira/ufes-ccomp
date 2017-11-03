/**
 * Obstacle class implementation
 */

#include "Obstacle.h"

// Constructor
Obstacle::Obstacle(Circle* shape, bool jumpOver)
{
	this->shape = shape;
	this->jumpOver = jumpOver;
}

// Draw Obstacle
void Obstacle::draw()
{
    shape->draw();
}

bool Obstacle::isTouching(Player* player) {
	player->getBody()->setRadius(player->getOrgRadius());
	
	return this->shape->isTouchingCircle(player->getBody());
}

bool Obstacle::canJumpOver() { return this->jumpOver; }
bool Obstacle::isPlayerOn() { return this->playerOn; }

void Obstacle::setPlayerOn(bool state) { this->playerOn = state; }

Circle* Obstacle::getShape() { return this->shape; }

// Destructor
Obstacle::~Obstacle() {}
