/**
 * Player class implementation
 */

#include "Player.h"

// Constructor
Player::Player(Circle* head, Point* position, Arena* arena)
{
	this->arena = arena;
    this->head = head;
	this->position = position;
    this->moveSpeed = 2;
    this->jumpTime = 2;
    this->orgRadius = head->getRadius();
    this->jumping = false;
    this->onObstacle = false;

	defineBody();
}

void Player::defineBody()
{
	GLfloat headRadius = head->getRadius();

	head->setPosition(new Point(0,0,0));

	arm = new Rectangle(headRadius/3, headRadius/2, new Point(ARM_POS_X, 0, 0), head->getColor());
}

// Draw Player
void Player::draw()
{
	glPushMatrix();
	glTranslatef(position->x,position->y,position->z);

    head->draw();

	glPopMatrix();
}

void Player::moveOnXAxis(GLfloat dx) {
	head->moveOnXAxis(dx * moveSpeed);

	if(!canMove()) head->moveOnXAxis(-dx * moveSpeed);
}

void Player::moveOnYAxis(GLfloat dy) {
	head->moveOnYAxis(dy * moveSpeed);

	if(!canMove()) head->moveOnYAxis(-dy * moveSpeed);
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
		head->setRadius(orgRadius * (jumpElapsed.count()/(jumpTime/2.0) * (JUMP_RADIUS_MULT - 1.0) + 1.0));
	}
	// Diminuindo (caindo)
	else {
		head->setRadius(orgRadius*JUMP_RADIUS_MULT -
			(jumpElapsed.count() - (jumpTime/2.0)/(jumpTime/2.0)) *
			(orgRadius*(JUMP_RADIUS_MULT - 1)));
	}

	// End of jump
	if(jumpElapsed.count() > jumpTime) {
		jumping = false;
		head->setRadius(orgRadius);

		Obstacle* obstacle = arena->isOnObstacle(this);
		if(obstacle) {
			obstacle->setPlayerOn(true);
		}
	}
}

bool Player::canMove() { return arena->isOnLegalLocation(this); }
bool Player::isJumping() { return this->jumping; }

Circle* Player::getHead() { return this->head; }
GLfloat Player::getOrgRadius() { return this->orgRadius; }

// Destructor
Player::~Player() {}
