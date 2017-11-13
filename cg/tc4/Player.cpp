/**
 * Player class implementation
 */

#include "Player.h"

// Constructor
Player::Player(Circle* head, Transform transform, GLfloat moveSpeed, GLfloat bulletSpeed, Arena* arena): transform(transform)
{
	this->arena = arena;
    this->head = head;
    this->moveSpeed = moveSpeed;
    this->bulletSpeed = bulletSpeed;
    this->rotationSpeed = ROTATION_SPEED;
    this->jumpTime = JUMP_TIME;
    this->orgRadius = head->getRadius() * 1.8;
    this->jumping = false;
    this->falling = false;
    this->overObstacle = false;
	this->onObstacle = false;
    this->climbed = false;
    this->leftLegFoward = true;
    this->legsPosCounter = 90;

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

	mousePos = Vector3(0,0,0);
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

	drawLegs(leftLegFoward);
	arm->draw();
	sholders->draw();
    head->draw();

	glPopMatrix();
}

void Player::drawLegs(bool leftLegFoward)
{
	if(leftLegFoward) {
		lLeg->transform.rotation.z = 0;
		rLeg->transform.rotation.z = 180;
	}
	else {
		lLeg->transform.rotation.z = 180;
		rLeg->transform.rotation.z = 0;
	}

	rLeg->draw();
	lLeg->draw();
}

void Player::move(GLfloat direction) {
	Vector3 previousPos = transform.position;

	// transform.print();

	GLfloat movement = direction * moveSpeed * Time::deltaTime.count() * 1000;
	GLfloat dx = movement * sin(-transform.rotation.z * DEG2RAD);
	GLfloat dy = movement * cos(-transform.rotation.z * DEG2RAD);

	transform.Translate(dx, dy, 0);

	updateLegsPos(direction);

	if(!canMove()) {
		// Return to previous position if went into ilegal position
		// cout << "ILEGAL move\n";
		transform.position = previousPos;
	}

	// rotateArm(mousePos);
}

void Player::rotate(GLfloat direction) {
	GLfloat rotation = direction * rotationSpeed * Time::deltaTime.count() * 1000;

	transform.Rotate(0,0,rotation);
}

void Player::rotateArm(GLfloat mouseX, GLfloat mouseY) {
	GLfloat direction = mouseX - mousePos.x;
	direction = (direction > 0) - (direction < 0);

	mousePos = Vector3(mouseX, mouseY, 0);

	GLfloat deltaRotation = -direction * ARM_ROTATION_SPEED * Time::deltaTime.count() * 1000;
	GLfloat newArmAngle = arm->transform.rotation.z + deltaRotation;


	if(newArmAngle > ARM_MAX_ROT)
		newArmAngle = ARM_MAX_ROT;
	else if(newArmAngle < -ARM_MAX_ROT)
		newArmAngle = -ARM_MAX_ROT;

	arm->transform.rotation.z = newArmAngle;
}

void Player::updateLegsPos(GLfloat direction) {
	legsPosCounter += direction * (moveSpeed*LEGS_SPEED_MULT) * Time::deltaTime.count() * 1000;

	if(sin(legsPosCounter * DEG2RAD) > 0) {
		leftLegFoward = true;
	}
	else {
		leftLegFoward = false;
	}
}


Bullet* Player::fire() {
	GLfloat bodyRotation = this->transform.rotation.z + 90;

	GLfloat armPosX = transform.position.x;
	armPosX += arm->transform.position.x * sin(bodyRotation * DEG2RAD);
	armPosX += arm->transform.position.y * sin(bodyRotation * DEG2RAD);

	GLfloat armPosY = transform.position.y;
	armPosY += arm->transform.position.y * -cos(bodyRotation * DEG2RAD);
	armPosY += arm->transform.position.x * -cos(bodyRotation * DEG2RAD);

	GLfloat handHeight = arm->getHeight();
	GLfloat handWidth = arm->getWidth();
	GLfloat armRotation = bodyRotation + arm->transform.rotation.z;

	Vector3 bulletSpawnPos = Vector3(armPosX, armPosY, 0);
	bulletSpawnPos.x += handHeight * cos(armRotation * DEG2RAD);
	bulletSpawnPos.y += handHeight * sin(armRotation * DEG2RAD);

	Vector3 targetDirection = Vector3(bulletSpawnPos.x - armPosX, bulletSpawnPos.y - armPosY, 0);
	targetDirection.normalize();

	return new Bullet(bulletSpawnPos, targetDirection, bulletSpeed, handWidth*0.7);
}


void Player::jump() {
	if(!jumping) {
		jumping = true;
		jumpElapsed = std::chrono::duration<double> (0);
	}
}

void Player::jumpLogic() {
	GLfloat sizeScaleOnJump = transform.scale.x;

	jumpElapsed += Time::deltaTime;

	Obstacle* obstacle = arena->isOnObstacle(this);

	// Subindo
	if(jumpElapsed.count() <= jumpTime/2.0) {
		jumping = true;
		falling = false;
		climbed = false;
		onObstacle = false;
	}
	// No chão
	else if(jumpElapsed.count() > jumpTime) {
		jumping = false;
		falling = false;
		overObstacle = false;
	}
	// Caindo
	else {
		jumping = true;
		falling = true;

		fallingInitialScale = transform.scale.x;

		if(overObstacle && canClimb()) {
			climbed = true;
		}

		GLfloat heightPercentToClimb = 0;
		if(obstacle) {
			heightPercentToClimb = JUMP_RADIUS_MULT * obstacle->getHeightPercent();
		}

		if(climbed && abs(transform.scale.x - heightPercentToClimb) < 0.01) {
			onObstacle = true;
			jumping = false;
			falling = false;
		}
		else {
			if(obstacle) obstacle->setPlayerOn(false);
		}
	}

	if(jumping) {
		if(obstacle) {
			overObstacle = true;
		}
		else {
			overObstacle = false;
			onObstacle = false;
			climbed = false;
		}
	}

	changeSize(sizeScaleOnJump, obstacle);
}

void Player::changeSize(GLfloat sizeScaleOnJump, Obstacle* obstacle)
{
	GLfloat scaleFactor = 1;

	if(jumping) {
		// Player rising
		if(!falling) {
			scaleFactor = jumpElapsed.count() * (JUMP_RADIUS_MULT - sizeScaleOnJump) + sizeScaleOnJump;
		}
		// Player falling or on Obstacle
		else if(falling) {
			scaleFactor = (jumpTime - jumpElapsed.count()) * (fallingInitialScale - 1) + 1;
		}
	}
	else {
		if(onObstacle) {
			cout << "On Obstacle. Not jumping.\n";
			if(obstacle) obstacle->setPlayerOn(true);
			scaleFactor = JUMP_RADIUS_MULT * obstacle->getHeightPercent();
		}
		else {
			cout << "On Ground. Not jumping.\n";
			transform.scale = Vector3(1,1,1);
			if(obstacle) obstacle->setPlayerOn(false);
		}
	}

	transform.scale = Vector3(scaleFactor, scaleFactor, 0);
}

void Player::fallOnLeaveObstacle()
{
	Obstacle* obstacle = arena->isOnObstacle(this);

	if(obstacle) return;

	cout << "Not on any obstacle. Falling..." << endl;

	//Not touching any obstacles
	overObstacle = false;
	onObstacle = false;
	climbed = false;
	jumping = true;
	falling = true;

	fallingInitialScale = transform.scale.x;
}

bool Player::canMove() { return arena->isOnLegalLocation(this); }
bool Player::isJumping() { return this->jumping; }
bool Player::isOnObstacle() { return this->overObstacle; }
bool Player::canClimb() { return transform.scale.x - ON_OBSTACLE_RADIUS_MULT >= 0.01; }
bool Player::hasClimbed() { return this->climbed; }

Circle* Player::getHead() { return this->head; }
GLfloat Player::getOrgRadius() { return this->orgRadius; }

// Destructor
Player::~Player() {}
