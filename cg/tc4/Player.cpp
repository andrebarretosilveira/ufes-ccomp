/**
 * Player class implementation
 */

#include "Player.h"

// Constructor
Player::Player(Circle* head, Transform transform, GLfloat moveSpeed, GLfloat bulletSpeed, GLfloat fireFreq, Arena* arena): transform(transform)
{
	this->arena = arena;
    this->head = head;
    this->moveSpeed = moveSpeed;
    this->bulletSpeed = bulletSpeed;
    this->fireFreq = fireFreq;
    this->rotationSpeed = ROTATION_SPEED;
    this->jumpTime = JUMP_TIME;
    this->orgRadius = head->getRadius() * 1.8;
    this->jumping = false;
    this->falling = false;
    this->overObstacle = false;
	this->onObstacle = false;
    this->climbed = false;
    this->leftLegFoward = true;
    this->player = false;
    this->alive = true;
    this->legsPosCounter = 90;

    lastFireTime = Time::now();

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
	if(!alive) return;

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
		cout << "ILEGAL move\n";
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

void Player::moveRandomly()
{
	int move = rand()%2;
	int direction = rand()%(1-(-1) + 1) + (-1);

	// cout << "Move? " << move << endl;
	// cout << "Direction: " << direction << endl;

	if(move) {
		// Do a walk movement
		this->move(0);
	}
	else {
		// Do a rotate movement
		this->rotate(direction);
	}
}

Bullet* Player::fire()
{
	if(!alive) return NULL;

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

Bullet* Player::fireOnFreq()
{
	if(Time::elapsed(lastFireTime, Time::now()).count() > fireFreq) {
		lastFireTime = Time::now();
		return fire();
	}

	return NULL;
}

void Player::jump() {
	if(!jumping) {
		jumping = true;
		jumpElapsed = std::chrono::duration<double> (0);
		sizeScaleOnJump = transform.scale.x;
		fallingInitialScale = JUMP_RADIUS_MULT * sizeScaleOnJump;
	}
}

void Player::jumpLogic() {
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

		if(overObstacle && canClimb(obstacle)) {
			climbed = true;
		}

		GLfloat heightPercentToClimb = 1;
		if(obstacle) {
			// heightPercentToClimb = JUMP_RADIUS_MULT * obstacle->getHeightPercent();
			heightPercentToClimb = obstacle->getHeightPercent();
		}

		// cout << "climbed: " << climbed << " | scale: " << transform.scale.x << " , heightToClimp: " << heightPercentToClimb << endl;
		if(climbed && abs((transform.scale.x - 1) < (JUMP_RADIUS_MULT - 1) * heightPercentToClimb)) {
		// if(climbed && abs(transform.scale.x < (1 + heightPercentToClimb))) {
			onObstacle = true;
			jumping = false;
			falling = false;
		}
		else {
			if(obstacle) obstacle->setPlayerOn(false);
		}
	}

	if(obstacle) {
		overObstacle = true;
	}
	else {
		overObstacle = false;
		onObstacle = false;
		climbed = false;
	}

	changeSize(sizeScaleOnJump, obstacle);
}

void Player::changeSize(GLfloat sizeScaleOnJump, Obstacle* obstacle)
{
	GLfloat scaleFactor = 1;

	if(jumping) {
		// Player rising
		if(!falling) {
			scaleFactor = (jumpElapsed.count()*2.0/jumpTime) * (JUMP_RADIUS_MULT*sizeScaleOnJump - sizeScaleOnJump)
				+ sizeScaleOnJump;
		}
		// Player falling
		else {
			scaleFactor = (jumpTime - jumpElapsed.count())*2.0/jumpTime * (fallingInitialScale - 1) + 1;
		}
	}
	else {
		if(onObstacle) {
			cout << "On Obstacle. Not jumping.\n";
			if(obstacle) obstacle->setPlayerOn(true);
			scaleFactor = 1 + (JUMP_RADIUS_MULT - 1) * obstacle->getHeightPercent();
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
}

bool Player::gotHitBy(Bullet* bullet)
{
	// if(!this) return false;

	if(Circle::isCirclesTouching(bullet->transform.position, bullet->shape->radius,
    	this->transform.position, this->getOrgRadius())) {

		if(this->player && bullet->firedByPlayer) {
    		cout << "Player bullet hitting Player. Ignore." << endl;
    		return false;
		}

    	cout << "Enemy bullet hitting Player" << endl;

    	this->die();

    	return true;
    }

    return false;
}

void Player::die()
{
	alive = false;
	// delete(this);
}

void Player::incrementScore()
{
	this->score++;
}

bool Player::canClimb(Obstacle* obstacle)
{
	if(!obstacle) return false;

	return transform.scale.x - 1 > (JUMP_RADIUS_MULT - 1) * obstacle->getHeightPercent();
}

bool Player::canMove() { return arena->isOnLegalLocation(this); }
bool Player::isJumping() { return this->jumping; }
bool Player::isOnObstacle() { return this->overObstacle; }
bool Player::hasClimbed() { return this->climbed; }

Circle* Player::getHead() { return this->head; }
GLint Player::getScore() { return this->score; }
GLfloat Player::getOrgRadius() { return this->orgRadius; }

void Player::setArena(Arena* arena) { this->arena = arena; }

// Destructor
Player::~Player() {}
