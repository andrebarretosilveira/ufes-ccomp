/**
 * Player class implementation
 */

#include "Player.h"

// Constructor
Player::Player(Circle* head, Transform transform, Arena* arena): transform(transform)
{
	this->arena = arena;
    this->head = head;
    this->moveSpeed = 1;
    this->rotationSpeed = 1;
    this->jumpTime = 2;
    this->orgRadius = head->getRadius();
    this->jumping = false;
    this->onObstacle = false;

	defineBody();
}

void Player::defineBody()
{
	GLfloat headRadius = head->getRadius();

	head->transform.position = Vector3(0,0,0);

	Transform transform = Transform(Vector3(headRadius + ARM_POS_X, 0, 0), Vector3(0,0,0), Vector3(1,1,1));
	arm = new Rectangle(headRadius*0.7, headRadius*1.8, transform, head->color);

	transform = Transform(Vector3(-headRadius/2, 0, 0), Vector3(0,0,0), Vector3(1,1,1));
	lLeg = new Rectangle(headRadius*0.7, headRadius*1.8, transform, Color(0,0,0));

	transform = Transform(Vector3(+headRadius/2, 0, 0), Vector3(0,0,180), Vector3(1,1,1));
	rLeg = new Rectangle(headRadius*0.7, headRadius*1.8, transform, Color(0,0,0));

	transform = Transform(Vector3(0, 0, 0), Vector3(0,0,0), Vector3(1,1,1));
	sholders = new Ellipse(headRadius*1.8, headRadius/2, transform, head->color);
}

// Draw Player
void Player::draw()
{
	glPushMatrix();
	glTranslatef(transform.position.x,transform.position.y,transform.position.z);
	glRotatef(transform.rotation.x,1,0,0);
	glRotatef(transform.rotation.y,0,1,0);
	glRotatef(transform.rotation.z,0,0,1);
	glScalef(transform.scale.x, transform.scale.y, transform.scale.z);

	drawLegs(true);
	arm->draw();
	sholders->draw();
    head->draw();

	glPopMatrix();
}

void Player::drawLegs(bool leftLegFoward)
{
	glPushMatrix();

	// if(leftLegFoward) {
	// 	rLeg->transform.Rotate(0,0,180);
	// }
	// else {
	// 	lLeg->transform.Rotate(0,0,180);
	// }

	rLeg->draw();
	lLeg->draw();

	glPopMatrix();
}

void Player::move(GLfloat direction) {
	Vector3 previousPos = transform.position;

	transform.print();

	GLfloat movement = direction * moveSpeed; //* Time::deltaTime;
	// cout << "deltaTime: " << Time::deltaTime << "\n";
	GLfloat dx = movement * sin(-transform.rotation.z * DEG2RAD);
	GLfloat dy = movement * cos(-transform.rotation.z * DEG2RAD);

	transform.Translate(dx, dy, 0);

	if(!canMove()) {
		// Return to previous position if went into ilegal position
		transform.position = previousPos;
	}
}

void Player::rotate(GLfloat direction) {
	transform.Rotate(0,0,direction * rotationSpeed);
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
		GLfloat scaleFactor = jumpElapsed.count() * (JUMP_RADIUS_MULT - 1) + 1;

		transform.scale = Vector3(scaleFactor, scaleFactor, 0);
		// head->setRadius(orgRadius * (jumpElapsed.count()/(jumpTime/2.0) * (JUMP_RADIUS_MULT - 1.0) + 1.0));
	}
	// Diminuindo (caindo)
	else {
		GLfloat scaleFactor = (jumpTime - jumpElapsed.count()) * (JUMP_RADIUS_MULT - 1) + 1;

		transform.scale = Vector3(scaleFactor, scaleFactor, 0);
		// head->setRadius(orgRadius*JUMP_RADIUS_MULT -
		// 	(jumpElapsed.count() - (jumpTime/2.0)/(jumpTime/2.0)) *
		// 	(orgRadius*(JUMP_RADIUS_MULT - 1)));
	}

	// End of jump
	if(jumpElapsed.count() > jumpTime) {
		jumping = false;
		transform.scale = Vector3(1,1,1);

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
