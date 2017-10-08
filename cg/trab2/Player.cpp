/**
 * Player class implementation
 */

#include "Player.h"

// Constructor
Player::Player(Circle* body, Arena* arena)
{
	this->arena = arena;
    this->body = body;
    this->moveSpeed = 1;
    this->orgRadius = body->getRadius();
    this->jumping = false;
    this->onObstacle = false;
}

// Draw Player
void Player::draw()
{
    body->draw();
}

bool Player::canMove() {
	return arena->isOnLegalLocation(this);
}

void Player::moveOnXAxis(GLfloat dx) {
	body->moveOnXAxis(dx * moveSpeed);

	if(!canMove()) body->moveOnXAxis(-dx * moveSpeed);
}

void Player::moveOnYAxis(GLfloat dy) {
	body->moveOnYAxis(dy * moveSpeed);

	if(!canMove()) body->moveOnYAxis(-dy * moveSpeed);
}

void Player::jump() {
	if(!jumping) {
		jumping = true;
		jumpPreviousTime = std::chrono::high_resolution_clock::now();
		jumpElapsed = std::chrono::duration<double> (0);
	}
}

void Player::changeSize() {
	// Record start time
	auto jumpCurrentTime = std::chrono::high_resolution_clock::now();

	this->jumpElapsed = jumpCurrentTime - jumpPreviousTime;

	if(jumpElapsed.count() <= JUMP_TIME/2) {
		body->setRadius(orgRadius * (jumpElapsed.count()/(JUMP_TIME/2) * (JUMP_RADIUS_MULT - 1.0) + 1.0));
	}
	else {
		body->setRadius(orgRadius*JUMP_RADIUS_MULT -
			(jumpElapsed.count() - (JUMP_TIME/2)/(JUMP_TIME/2)) *
			(orgRadius*(JUMP_RADIUS_MULT - 1)));
	}

	// End of jump
	if(jumpElapsed.count() > JUMP_TIME) {
		jumping = false;
		body->setRadius(orgRadius);

		Obstacle* obstacle = arena->isOnObstacle(this);
		if(obstacle) {
			obstacle->setPlayerOn(true);
		}
	}
}

bool Player::isJumping() { return this->jumping; }

Circle* Player::getBody() { return this->body; }
GLfloat Player::getOrgRadius() { return this->orgRadius; }

// Destructor
Player::~Player() {}
