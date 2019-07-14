/**
 * Player class implementation
 */

#include "Player.h"

// Constructor
Player::Player(Sphere* head, Transform transform, GLfloat moveSpeed, GLfloat bulletSpeed, GLfloat fireFreq): transform(transform)
{
    this->head = head;
    this->moveSpeed = moveSpeed;
    this->bulletSpeed = bulletSpeed;
    this->fireFreq = fireFreq;
    this->height = PLAYER_HEIGHT;
    this->orgRadius = head->getRadius() * 1.8;
    this->jumping = false;
    this->falling = false;
    this->overObstacle = false;
	this->onObstacle = false;
    this->climbed = false;
    this->leftLegFoward = true;
    this->player = false;
    this->alive = true;
    this->pressedS = false;
    this->invulnerable = false;
    this->lastObstacleOn = NULL;
    this->legsPosCounter = 90;
    this->kills = 0;
    this->life = 100;

	lastRandomMove = 1;
	randomMoveDirection = 1;
	lastRandomMoveTime = Time::now();
	lastFireTime = Time::now();

	defineBody();
}

void Player::defineBody()
{
	GLfloat headRadius = head->getRadius();

    // head->transform.position = Vector3(0,-2,sholders->transform.position.z + sholders->getRadius());
    head->transform.position = Vector3(0, -2, height);

    Transform transform = Transform(Vector3(0, -2, height/1.5), Vector3(0,0,0), Vector3(2,1,0.5));
	sholders = new Sphere(headRadius/1.2, transform, Color(0,1,1));

    // Transform transform = Transform(Vector3(0, -10, height - headRadius*2), Vector3(0,0,0), Vector3(1,1,1));
	// sholders = new Rectangle(headRadius*3, headRadius*1.5, transform, Color(0,1,1));

    transform = Transform(Vector3(0, 0, height/5), Vector3(90,0,0), Vector3(1,1,1));
	body = new Rectangle(headRadius*1.5, headRadius*1.8, transform, Color(0.5,1,1));

    transform = Transform(Vector3(headRadius + ARM_POS_X, -2, height/1.7), Vector3(0,0,0), Vector3(1,1,1));
	weaponArm = new Rectangle(headRadius*0.7, headRadius*3, transform, head->color);

	transform = Transform(Vector3(-headRadius - ARM_POS_X, -10, height/1.5), Vector3(270,0,0), Vector3(1,1,1));
	lArm = new Rectangle(headRadius*0.7, headRadius*1.8, transform, head->color);

    transform = Transform(Vector3(-headRadius/2, 0, height/5), Vector3(LEGS_NORMAL_ROT,0,180), Vector3(1,1,1));
	lLegUp = new Rectangle(headRadius*0.7, headRadius, transform, Color(0,0.1,0.1));

	transform = Transform(Vector3(-headRadius/2, 0, height/5 -10), Vector3(LEGS_NORMAL_ROT,0,180), Vector3(1,1,1));
	lLegDown = new Rectangle(headRadius*0.7, headRadius, transform, Color(0,0.1,0.1));

    transform = Transform(Vector3(+headRadius/2, 0, height/5), Vector3(LEGS_NORMAL_ROT,0,180), Vector3(1,1,1));
	rLegUp = new Rectangle(headRadius*0.7, headRadius, transform, Color(0,0.1,0.1));

	transform = Transform(Vector3(+headRadius/2, 0, height/5 -10), Vector3(LEGS_NORMAL_ROT,0,180), Vector3(1,1,1));
	rLegDown = new Rectangle(headRadius*0.7, headRadius, transform, Color(0.1,0.1,0.1));

	mousePos = Vector3(0,0,0);

    this->transform.position.z = BODY_POS_HEIGHT;

}

// Draw Player
void Player::render(bool renderHead)
{
	if(!alive) return;

	glPushMatrix();
	glTranslatef(transform.position.x,transform.position.y,transform.position.z);
	glRotatef(transform.rotation.x,1,0,0);
	glRotatef(transform.rotation.y,0,1,0);
	glRotatef(transform.rotation.z,0,0,1);
	glScalef(transform.scale.x, transform.scale.y, transform.scale.z);

    GLfloat ambientPlayer[] = {0.0, 0.0, 0.0, 1.0};
    GLfloat diffusePlayer[] = {0.0, 1.0, 0.0, 1.0};
    GLfloat specularPlayer[] = {1.0, 1.0, 1.0, 1.0};
    glMaterialfv(GL_FRONT, GL_AMBIENT, ambientPlayer);
    glMaterialfv(GL_FRONT, GL_DIFFUSE, diffusePlayer);
    glMaterialfv(GL_FRONT, GL_SPECULAR, specularPlayer);
    glMaterialf(GL_FRONT, GL_SHININESS, 60.0);

    if(player && Camera::fps) {
        weaponArm->render();
    }
    else {
        rLegUp->render();
        if(rLegUp->transform.rotation.x > 90)
        {
            rLegDown->render();
        }


        lLegUp->render();
        if(lLegUp->transform.rotation.x > 90)
        {
            lLegDown->render();
        }

        body->render();
    	weaponArm->render();
    	lArm->render();
        sholders->render();

        if(renderHead) head->render();
    }

	glPopMatrix();
}

void Player::draw()
{
    if(!alive) return;

    glPushMatrix();
    glTranslatef(transform.position.x,transform.position.y,transform.position.z);
    glRotatef(transform.rotation.x,1,0,0);
    glRotatef(transform.rotation.y,0,1,0);
    glRotatef(transform.rotation.z,0,0,1);
    glScalef(transform.scale.x, transform.scale.y, transform.scale.z);

    int i;
    int triangleAmount = 700;
    GLfloat twicePi = 2.0f * M_PI;

    glEnable(GL_LINE_SMOOTH);
    glLineWidth(5.0);

    glBegin(GL_LINES);
        glColor3f(head->color.r, head->color.g, head->color.b);
        for(i = 0; i <= triangleAmount; i++)
        {
            glVertex2f(0, 0);
            glVertex2f((head->radius * cos(i * twicePi / triangleAmount)), (head->radius * sin(i * twicePi / triangleAmount)));
        }
    glEnd();

    glPopMatrix();
}

bool Player::move(GLfloat direction) {
    if(!alive) return false;

	Vector3 previousPos = transform.position;

	GLfloat movement = direction * moveSpeed * Time::deltaTime.count() * 1000;
	GLfloat dx = movement * sin(-transform.rotation.z * DEG2RAD);
	GLfloat dy = movement * cos(-transform.rotation.z * DEG2RAD);

	transform.Translate(dx, dy, 0);

	rotateLegs(direction);
    rotateIdleArm(direction);

	if(!canMove()) {
        // Jump if you are a bot
		if(arena->isTouchingObstacle(this) && !this->isPlayer() && !this->onObstacle) {
			this->jump();
		}

        // Return to previous position if went into ilegal position
		transform.position = previousPos;

		return false;
	}

	return true;
}

void Player::rotate(GLfloat direction) {
    if(!alive) return;

	GLfloat rotation = direction * ROTATION_SPEED * Time::deltaTime.count() * 1000;

    rotation = pressedS ? -rotation : rotation;

	transform.Rotate(0,0,rotation);
}

void Player::rotateIdleArm(GLfloat direction) {
    if(!alive) return;

    Vector3 armCurrentRot = lArm->transform.rotation;

    GLfloat rotX = LEGS_NORMAL_ROT + LEGS_ROT * sin(legsPosCounter * DEG2RAD) + 180;

    lArm->transform.rotation = Vector3(rotX, armCurrentRot.y, armCurrentRot.z);
}

void Player::rotateWeaponArm(GLfloat mouseX, GLfloat mouseY) {
    if(!alive) return;

    GLfloat horzDir = mouseX - mousePos.x;
	GLfloat vertDir = mouseY - mousePos.y;

    horzDir = (horzDir > 0) - (horzDir < 0);
	vertDir = (vertDir > 0) - (vertDir < 0);

	mousePos = Vector3(mouseX, mouseY, 0);

    GLfloat horzDeltaDir = -horzDir * ARM_ROTATION_SPEED * Time::deltaTime.count() * 1000;
	GLfloat vertDeltaDir = vertDir * ARM_ROTATION_SPEED * Time::deltaTime.count() * 1000;

    GLfloat horzNewArmAngle = weaponArm->transform.rotation.z + horzDeltaDir;
	GLfloat vertNewArmAngle = weaponArm->transform.rotation.x + vertDeltaDir/5;

	if(horzNewArmAngle > ARM_MAX_ROT)
		horzNewArmAngle = ARM_MAX_ROT;
	else if(horzNewArmAngle < -ARM_MAX_ROT)
		horzNewArmAngle = -ARM_MAX_ROT;

    if(vertNewArmAngle > ARM_MAX_ROT)
        vertNewArmAngle = ARM_MAX_ROT;
    else if(vertNewArmAngle < -ARM_MAX_ROT)
        vertNewArmAngle = -ARM_MAX_ROT;

    if(Camera::fps) {
        this->rotate(-horzDir/5);
    }
    else {
        weaponArm->transform.rotation.z = horzNewArmAngle;
    }
	weaponArm->transform.rotation.x = vertNewArmAngle;
}

void Player::rotateLegs(GLfloat direction) {
    if(!alive) return;

	legsPosCounter += direction * (moveSpeed*LEGS_ROT_SPEED) * Time::deltaTime.count() * 1000;
	// GLfloat headRadius = head->getRadius();
    Vector3 rLegDownCurrentRot = rLegDown->transform.rotation;
    Vector3 rLegUpCurrentRot = rLegUp->transform.rotation;
    GLfloat rotXup = LEGS_NORMAL_ROT + LEGS_ROT * sin(legsPosCounter * DEG2RAD);
	GLfloat rotXdown = LEGS_NORMAL_ROT + LEGS_ROT * sin(-legsPosCounter * DEG2RAD);

	rLegUp->transform.rotation = Vector3(rotXup, rLegUpCurrentRot.y, rLegUpCurrentRot.z);
	if(rotXup <= 90)
	{
		// rLegDown->transform.rotation = Vector3(rotXup, rLegDownCurrentRot.y,rLegUpCurrentRot.z);
		// double xline = rLegUp->transform.position.x*cos(rotXup * DEG2RAD) - rLegUp->transform.position.y*sin(rotXup * DEG2RAD);
		// double yline = rLegUp->transform.position.x*sin(rotXup * DEG2RAD) + rLegUp->transform.position.y*cos(rotXup * DEG2RAD);
		// rLegDown->transform.position = Vector3(yline,xline,0);
		rLegUp->transform.scale = Vector3(rLegUp->transform.scale.x,2,rLegUp->transform.scale.z);

	}else
	{
		rLegUp->transform.scale = Vector3(rLegUp->transform.scale.x,1,rLegUp->transform.scale.z);
		rLegDown->transform.rotation = Vector3(rotXdown, rLegDownCurrentRot.y,rLegUpCurrentRot.z);
	}




    // rLegDown->transform.position.y += rLegUp->transform.position.z * cos(rLegUp->transform.rotation.x * DEG2RAD);
	// rLegDown->transform.position.z -= rLegUp->transform.position.z * cos(rLegUpCurrentRot.y * DEG2RAD);

    Vector3 lLegUpCurrentRot = lLegUp->transform.rotation;
	Vector3 lLegDownCurrentRot = lLegDown->transform.rotation;
    rotXup = LEGS_NORMAL_ROT - LEGS_ROT * sin(legsPosCounter * DEG2RAD);
	rotXdown = LEGS_NORMAL_ROT - LEGS_ROT * sin(-legsPosCounter * DEG2RAD);
	// double xline = lLegUp->transform.position.x*cos(rotXup * DEG2RAD) - lLegUp->transform.position.y*sin(rotXup * DEG2RAD);
	// double yline = lLegUp->transform.position.x*sin(rotXup * DEG2RAD) + lLegUp->transform.position.y*cos(rotXup * DEG2RAD);


	lLegUp->transform.rotation = Vector3(rotXup, lLegUpCurrentRot.y, lLegUpCurrentRot.z);
	if(rotXup <= 90)
	{
		// lLegDown->transform.rotation = Vector3(rotXup, lLegDownCurrentRot.y, lLegDownCurrentRot.z);
		// double xline = lLegUp->transform.position.x*cos(rotXup * DEG2RAD) - lLegUp->transform.position.y*sin(rotXup * DEG2RAD);
		// double yline = lLegUp->transform.position.x*sin(rotXup * DEG2RAD) + lLegUp->transform.position.y*cos(rotXup * DEG2RAD);
		// lLegDown->transform.position = Vector3(xline+headRadius*0.7,yline+headRadius*1.4,0);
		lLegUp->transform.scale = Vector3(lLegUp->transform.scale.x,2,lLegUp->transform.scale.z);
	}else
	{
		lLegUp->transform.scale = Vector3(lLegUp->transform.scale.x,1,lLegUp->transform.scale.z);
		lLegDown->transform.rotation = Vector3(rotXdown, lLegDownCurrentRot.y, lLegDownCurrentRot.z);
	}


}

void Player::moveRandomly()
{
	int move, direction;

	if(Time::elapsed(lastRandomMoveTime, Time::now()).count() < RANDOM_MOVE_TIME) {
		move = lastRandomMove;
		direction = randomMoveDirection;
	}
	else {
		if(lastRandomMoveTime == Time::initialTime) {
			// Has hit a wall, rotate now
			move = 0;
		}
		else {
			// Keep moving foward a little more
			move = 1;
		}

		// Setting the direction to 1 here avoids too much moonwalk
		direction = randomMoveDirection;

		lastRandomMove = move;
		lastRandomMoveTime = Time::now();
	}

	if(move) {
		// Do a walk movement
		if(!this->move(direction) && !this->isJumping()) {
			// Ilegal move, then try another type on next move
			lastRandomMoveTime = Time::initialTime;
			randomMoveDirection = rand()%2 * 2 - 1;
		}
	}
	else {
		// Do a rotate movement
		this->rotate(direction);
	}

	// Jump stuff
	if(this->isJumping()) {
        this->jumpLogic();
    }
    else if(this->isOnObstacle()) {
        this->fallOnLeaveObstacle();
    }
}

Bullet* Player::fire()
{
	if(!alive || this->isJumping()) return NULL;

	GLfloat bodyRotation = this->transform.rotation.z + 90;

    Vector3 armPos = Vector3(transform.position.x, transform.position.y, transform.position.z);

	armPos.x += weaponArm->transform.position.x * sin(bodyRotation * DEG2RAD);
	armPos.x += weaponArm->transform.position.y * sin(bodyRotation * DEG2RAD);
	armPos.y += weaponArm->transform.position.y * -cos(bodyRotation * DEG2RAD);
	armPos.y += weaponArm->transform.position.x * -cos(bodyRotation * DEG2RAD);
    armPos.z += weaponArm->transform.position.z;

	GLfloat handHeight = weaponArm->getHeight();
	GLfloat handWidth = weaponArm->getWidth();
    GLfloat armRotation = bodyRotation + weaponArm->transform.rotation.z;
	GLfloat armVertRotation = weaponArm->transform.rotation.x;

	Vector3 bulletSpawnPos = Vector3(armPos.x, armPos.y, armPos.z);
	bulletSpawnPos.x += handHeight * cos(armRotation * DEG2RAD);
	bulletSpawnPos.y += handHeight * sin(armRotation * DEG2RAD);
    bulletSpawnPos.z += handHeight * sin(armVertRotation * DEG2RAD);

    // Vector3 bulletSpawnPos = this->getBulletSpawnPos();

	Vector3 targetDirection = Vector3(bulletSpawnPos.x - armPos.x, bulletSpawnPos.y - armPos.y, bulletSpawnPos.z - armPos.z);
	targetDirection.normalize();

	return new Bullet(bulletSpawnPos, targetDirection, bulletSpeed, handWidth*0.7, head->color);
}

Vector3 Player::getEyePos()
{
    GLfloat bodyRotation = this->transform.rotation.z + 90;

    Vector3 eyePos = Vector3(transform.position.x, transform.position.y, transform.position.z);

	eyePos.x += head->transform.position.x * sin(bodyRotation * DEG2RAD);
	eyePos.x += head->transform.position.y * sin(bodyRotation * DEG2RAD);
	eyePos.y += head->transform.position.y * -cos(bodyRotation * DEG2RAD);
	eyePos.y += head->transform.position.x * -cos(bodyRotation * DEG2RAD);
    eyePos.z += head->transform.position.z + head->radius;

    return eyePos;
}

Vector3 Player::getWeaponArmPos()
{
    GLfloat bodyRotation = this->transform.rotation.z + 90;

    Vector3 armPos = Vector3(transform.position.x, transform.position.y, transform.position.z);

	armPos.x += weaponArm->transform.position.x * sin(bodyRotation * DEG2RAD);
	armPos.x += weaponArm->transform.position.y * sin(bodyRotation * DEG2RAD);
	armPos.y += weaponArm->transform.position.y * -cos(bodyRotation * DEG2RAD);
	armPos.y += weaponArm->transform.position.x * -cos(bodyRotation * DEG2RAD);
    armPos.z += weaponArm->transform.position.z;

    return armPos;
}

Vector3 Player::getBulletSpawnPos()
{
    GLfloat bodyRotation = this->transform.rotation.z + 90;

    Vector3 armPos = Vector3(transform.position.x, transform.position.y, transform.position.z);

	armPos.x += weaponArm->transform.position.x * sin(bodyRotation * DEG2RAD);
	armPos.x += weaponArm->transform.position.y * sin(bodyRotation * DEG2RAD);
	armPos.y += weaponArm->transform.position.y * -cos(bodyRotation * DEG2RAD);
	armPos.y += weaponArm->transform.position.x * -cos(bodyRotation * DEG2RAD);
    armPos.z += weaponArm->transform.position.z;

	GLfloat handHeight = weaponArm->getHeight();
	// GLfloat handWidth = weaponArm->getWidth();
    GLfloat armRotation = bodyRotation + weaponArm->transform.rotation.z;
	GLfloat armVertRotation = weaponArm->transform.rotation.x;

	Vector3 bulletSpawnPos = Vector3(armPos.x, armPos.y, armPos.z);
	bulletSpawnPos.x += handHeight * cos(armRotation * DEG2RAD);
	bulletSpawnPos.y += handHeight * sin(armRotation * DEG2RAD);
    bulletSpawnPos.z += handHeight * sin(armVertRotation * DEG2RAD);

    return bulletSpawnPos;
}

Bullet* Player::fireOnFreq()
{
    // BLoquando tiro dos inimigos
    // return NULL;

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
		heightOnJump = transform.position.z;
		heightOnFall = transform.position.z;
	}
}

void Player::jumpLogic() {
	jumpElapsed += Time::deltaTime;

	Obstacle* obstacle = arena->isTouchingObstacle(this);

	GLfloat jumpTime = JUMP_TIME * (JUMP_HEIGHT + heightOnJump - BODY_POS_HEIGHT) / JUMP_HEIGHT;

	// Subindo
	if(jumpElapsed.count() <= jumpTime/2.0) {
		jumping = true;
		falling = false;
		climbed = false;
		onObstacle = false;
	}
	// No chão
	else if(jumpElapsed.count() +0.01 > jumpTime) {
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

		if(climbed && obstacle && abs((transform.position.z) < obstacle->shape->height + BODY_POS_HEIGHT +2)) {
			onObstacle = true;
			jumping = false;
			falling = false;
		}
		// else {
		// 	if(obstacle) obstacle->setPlayerOn(this, false);
		// }
	}

	if(obstacle) {
		overObstacle = true;
	}
	else {
		overObstacle = false;
		onObstacle = false;
		climbed = false;
	}

	changeHeight(heightOnJump, obstacle);
}

void Player::changeHeight(GLfloat heightOnJump, Obstacle* obstacle)
{
	GLfloat newHeight = BODY_POS_HEIGHT;

    GLfloat jumpTime = JUMP_TIME * (JUMP_HEIGHT + heightOnJump - BODY_POS_HEIGHT) / JUMP_HEIGHT;

	if(jumping) {
		// Player rising
		if(!falling) {
			newHeight = (jumpElapsed.count()*2.0/jumpTime) * (JUMP_HEIGHT + heightOnJump) + heightOnJump;
		}
		// Player falling
		else {
			newHeight = (jumpTime - jumpElapsed.count())*2.0/jumpTime * (JUMP_HEIGHT + heightOnJump*2 - BODY_POS_HEIGHT) + BODY_POS_HEIGHT;
		}

	}
	else {
		if(onObstacle) {
			// cout << "On Obstacle. Not jumping.\n";
			if(obstacle) obstacle->setPlayerOn(this, true);
			lastObstacleOn = obstacle;
			newHeight = obstacle->shape->height + BODY_POS_HEIGHT;
		}
		else {
			// cout << "On Ground. Not jumping.\n";
			// transform.scale = Vector3(1,1,1);
			if(lastObstacleOn) {
                lastObstacleOn->setPlayerOn(this, false);
            }
		}
	}

    transform.position.z = newHeight;
}

void Player::fallOnLeaveObstacle()
{
	Obstacle* obstacle = arena->isTouchingObstacle(this);

	if(obstacle) return;

	// cout << "Not on any obstacle. Falling..." << endl;

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
    	this->transform.position, this->orgRadius)) {

		if(this->isOnObstacle() || (this->player && bullet->firedByPlayer)) {
    		// cout << "Player bullet hitting Player. Ignore." << endl;
    		return false;
		}

    	// cout << "Enemy bullet hitting Player" << endl;
    	if(this->isAlive() && !invulnerable) {
            life -= 35;

            if(life <= 0)
            {
                life = 0;
                this->die();
            }

    		return true;
    	}
    }

    return false;
}

void Player::die()
{
	alive = false;
	// delete(this);
}

bool Player::canClimb(Obstacle* obstacle)
{
	if(!obstacle) return false;

	return transform.position.z > obstacle->shape->height;
}

bool Player::canMove() { return arena->isOnLegalLocation(this); }
bool Player::isPlayer() { return this->player; }
bool Player::isJumping() { return this->jumping; }
bool Player::isOnObstacle() { return this->overObstacle; }
bool Player::hasClimbed() { return this->climbed; }
Sphere* Player::getHead() { return this->head; }
GLint Player::getKills() { return this->kills; }
void Player::incrementKills() { this->kills++; }
void Player::setKills(GLint kills) { this->kills = kills; }
GLfloat Player::getOrgRadius() { return this->orgRadius; }
bool Player::isAlive() { return this->alive; }
void Player::setAlive(bool state) { this->alive = state; }
void Player::setArena(Arena* arena) { this->arena = arena; }
void Player::setPlayer(bool state) { this->player = state; }

// Destructor
Player::~Player() {}
