/**
 * Player class implementation
 */

#include "Player.h"

// Constructor
Player::Player(Circle* body)
{
    this->body = body;
}

// Draw Player
void Player::draw()
{
    body->draw();
}

// Destructor
Player::~Player() {}
