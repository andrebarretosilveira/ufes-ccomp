/**
 * Player class implementation
 */

#include "Player.h"

// Constructor
Player::Player(Circle* body)
{
    this->body = body;
    this->moveSpeed = 1;
}

// Draw Player
void Player::draw()
{
    body->draw();
}

void Player::moveOnXAxis(GLfloat dx) {
	body->moveOnXAxis(dx * moveSpeed);
}

void Player::moveOnYAxis(GLfloat dy) {
	body->moveOnYAxis(dy * moveSpeed);
}

// Destructor
Player::~Player() {}
