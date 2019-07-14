/**
 * Obstacle class implementation
 */

#include "Obstacle.h"

// Constructor
Obstacle::Obstacle(Cylinder* shape, bool jumpable)
{
	this->shape = shape;
	this->jumpable = jumpable;
	this->playersOn = list<Player*>();
}

// Draw Obstacle
void Obstacle::render()
{
    shape->render();
}

void Obstacle::draw()
{
	shape->draw();
}

bool Obstacle::isTouching(Player* player) {
	return this->shape->isTouchingCylinder(player->transform.position, player->getOrgRadius());
}

bool Obstacle::isTouching(Bullet* bullet) {
	return this->shape->isTouchingCylinder(bullet->transform.position, bullet->shape->getRadius());
}

void Obstacle::setPlayerOn(Player* player, bool state) {
	if(state) {
		// add player to list if not already there
		playersOn.push_back(player);
	}
	else {
		// remove player from list
		playersOn.remove(player);
	}
}

bool Obstacle::isPlayerOn(Player* player) {
	bool isPlayerOnList = (std::find(playersOn.begin(), playersOn.end(), player) != playersOn.end());

	// cout << "isPlayerOn? " << isPlayerOnList << endl;
	return isPlayerOnList;
}


bool Obstacle::canJumpOver() { return this->jumpable; }
Cylinder* Obstacle::getShape() { return this->shape; }

// Destructor
Obstacle::~Obstacle() {}
