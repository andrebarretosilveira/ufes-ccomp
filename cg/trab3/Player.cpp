/**
 * Player class implementation
 */

#include "Player.h"

// Constructor
Player::Player(Circle* body, Arena* arena)
{
	this->arena = arena;
    this->body = body;
    this->moveSpeed = 2;
    this->jumpTime = 2;
    this->orgRadius = body->getRadius();
    this->jumping = false;
    this->onObstacle = false;
}

// Draw Player
void Player::draw()
{
	glPushMatrix();
	glTranslatef(body->getPosition()->x,body->getPosition()->y,body->getPosition()->z);

    body->draw();

	glPopMatrix();
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
		jumpStartTime = std::chrono::high_resolution_clock::now();
		jumpElapsed = std::chrono::duration<double> (0);
	}
}

void Player::changeSize() {
	// Record start time
	auto jumpCurrentTime = std::chrono::high_resolution_clock::now();

	this->jumpElapsed = jumpCurrentTime - jumpStartTime;

	// Aumentando (subindo)
	if(jumpElapsed.count() <= jumpTime/2.0) {
		body->setRadius(orgRadius * (jumpElapsed.count()/(jumpTime/2.0) * (JUMP_RADIUS_MULT - 1.0) + 1.0));
	}
	// Diminuindo (caindo)
	else {
		body->setRadius(orgRadius*JUMP_RADIUS_MULT -
			(jumpElapsed.count() - (jumpTime/2.0)/(jumpTime/2.0)) *
			(orgRadius*(JUMP_RADIUS_MULT - 1)));
	}

	// End of jump
	if(jumpElapsed.count() > jumpTime) {
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
