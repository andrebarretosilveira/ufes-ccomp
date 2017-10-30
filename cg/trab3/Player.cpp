/**
 * Player class implementation
 */

#include "Player.h"

// Constructor
Player::Player(Circle* head, Transform transform, Arena* arena): transform(transform)
{
	this->arena = arena;
    this->head = head;
    this->moveSpeed = 0.3;
    this->rotationSpeed = 0.1;
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

	lastMousePos = Vector3(0,0,0);
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

	GLfloat movement = direction * moveSpeed * Time::deltaTime.count() * 1000;
	GLfloat dx = movement * sin(-transform.rotation.z * DEG2RAD);
	GLfloat dy = movement * cos(-transform.rotation.z * DEG2RAD);

	transform.Translate(dx, dy, 0);

	if(!canMove()) {
		// Return to previous position if went into ilegal position
		cout << "ILEGAL move\n";
		transform.position = previousPos;
	}

	rotateArm(lastMousePos);
}

void Player::rotate(GLfloat direction) {
	GLfloat rotation = direction * rotationSpeed * Time::deltaTime.count() * 1000;

	transform.Rotate(0,0,rotation);

	rotateArm(lastMousePos);
}

void Player::rotateArm(GLfloat mouseX, GLfloat mouseY) {
	GLfloat armPosX = transform.position.x + arm->transform.position.x;
	GLfloat armPosY = transform.position.y + arm->transform.position.y;

	GLfloat angle = -atan((armPosX - mouseX)/(armPosY - mouseY)) * RAD2DEG - transform.rotation.z;

	if(angle > ARM_MAX_ROT) angle = ARM_MAX_ROT;
	else if(angle < -ARM_MAX_ROT) angle = -ARM_MAX_ROT;

	// cout << "Rotate Arm :: mouse X = " << mouseX << " | mouse Y = " << mouseY << " | Angle = " << angle << "\n";
	// cout << "           :: playerX = " << transform.position.x << " | playerY = " << transform.position.y << "\n";

	lastMousePos = Vector3(mouseX, mouseY, 0);

	arm->transform.rotation.z = angle;
}

void Player::rotateArm(Vector3 mousePos) {
	GLfloat bodyRotation = transform.rotation.z;
	GLfloat armPosX = transform.position.x + arm->transform.position.x;
	GLfloat armPosY = transform.position.y + arm->transform.position.y;

	GLfloat angle = -atan((armPosX - lastMousePos.x)/(armPosY - lastMousePos.y)) * RAD2DEG - bodyRotation;

	cout << "bodyRotation: " << bodyRotation << " | angle: " << angle << "\n";

	if(angle > ARM_MAX_ROT) angle = ARM_MAX_ROT;
	else if(angle < -ARM_MAX_ROT) angle = -ARM_MAX_ROT;

	arm->transform.rotation.z = angle;
}


Bullet* Player::fire() {
	cout << "Pow!\n";

	GLfloat armPosX = transform.position.x + arm->transform.position.x;
	GLfloat armPosY = transform.position.y + arm->transform.position.y;

	GLfloat handDelta = arm->getHeight();
	GLfloat dx = handDelta * sin(-transform.rotation.z * DEG2RAD);
	GLfloat dy = handDelta * cos(-transform.rotation.z * DEG2RAD);

	Vector3 bulletSpawnPos = Vector3(armPosX, armPosY, 0);
	bulletSpawnPos.x += dx;
	bulletSpawnPos.y += dy;

	Vector3 targetDirection = Vector3(lastMousePos.x - armPosX, lastMousePos.y - armPosY, 0);
	targetDirection.normalize();

	return new Bullet(bulletSpawnPos, targetDirection, BULLET_MOVE_SPEED);
}


void Player::jump() {
	if(!jumping) {
		jumping = true;
		jumpElapsed = std::chrono::duration<double> (0);
	}
}

void Player::changeSize() {
	jumpElapsed += Time::deltaTime;
	// cout << "jumpElapsed = " << jumpElapsed.count() << "\n";

	// Aumentando (subindo)
	if(jumpElapsed.count() <= jumpTime/2.0) {
		GLfloat scaleFactor = jumpElapsed.count() * (JUMP_RADIUS_MULT - 1) + 1;

		transform.scale = Vector3(scaleFactor, scaleFactor, 0);
	}
	// Diminuindo (caindo)
	else {
		GLfloat scaleFactor = (jumpTime - jumpElapsed.count()) * (JUMP_RADIUS_MULT - 1) + 1;

		transform.scale = Vector3(scaleFactor, scaleFactor, 0);
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
bool Player::isOnObstacle() { return this->onObstacle; }

Circle* Player::getHead() { return this->head; }
GLfloat Player::getOrgRadius() { return this->orgRadius; }

// Destructor
Player::~Player() {}
