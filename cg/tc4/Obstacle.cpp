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
	// this->playerOn = false;
	this->playersOn = list<Player*>();
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

void Obstacle::setPlayerOn(Player* player, bool state) {
	if(state) {
		// add player to list if not already there
		playersOn.push_back(player);
	}
	else {
		// remove player from list
		playersOn.remove(player);
	}

	// cout << "SetPlayerOn. List size: " << playersOn.size() << endl;
	// this->playerOn = state;
}

bool Obstacle::isPlayerOn(Player* player) {
	bool isPlayerOnList = (std::find(playersOn.begin(), playersOn.end(), player) != playersOn.end());

	// cout << "isPlayerOn? " << isPlayerOnList << endl;
	return isPlayerOnList;
}


bool Obstacle::canJumpOver() { return this->jumpable; }
GLfloat Obstacle::getHeightPercent() { return this->heightPercent; }
Circle* Obstacle::getShape() { return this->shape; }

// Destructor
Obstacle::~Obstacle() {}
