/**
 * Arena class implementation
 */

#include "Arena.h"

// Constructor
Arena::Arena(char* name, Circle* outerLimit, Circle* innerLimit, Player* player, list<Obstacle*> obstacles, list<Player*> enemies)
{
	this->name = name;
    this->outerLimit = outerLimit;
    this->innerLimit = innerLimit;
    this->player = player;
	this->obstacles = list<Obstacle*>(obstacles);
    this->enemies = list<Player*>(enemies);

    list<Player*>::iterator it;
	for (it = enemies.begin(); it != enemies.end(); ++it) {
	    (*it)->setArena(this);
	}

	this->player->setArena(this);
}

// Draw Arena
void Arena::draw()
{
	outerLimit->draw();
    innerLimit->draw();

    // Drawing Obstacles
    list<Obstacle*>::iterator itObs;
	for (itObs = obstacles.begin(); itObs != obstacles.end(); ++itObs){
	    (*itObs)->draw();
	}

	// Drawing Enemies
	list<Player*>::iterator itEne;
	for (itEne = enemies.begin(); itEne != enemies.end(); ++itEne){
	    (*itEne)->draw();
	}

	// Drawing Bullets
    list<Bullet*>::iterator itBullets;
    for (itBullets = bullets.begin(); itBullets != bullets.end(); ++itBullets) {
        (*itBullets)->draw();
    }

    drawScore();

	if(!player->isAlive()) {
		drawEndGameText(false);
	}
	else if(allEnemiesDead()) {
		drawEndGameText(true);
	}
}

void Arena::drawScore()
{
	glPushMatrix();
	glTranslatef(outerLimit->transform.position.x,outerLimit->transform.position.y,outerLimit->transform.position.z);
	glTranslatef(outerLimit->radius - 90, outerLimit->radius - 40, 0);

	//
	string scoreIncompleteString = "Kills: ";
	string playerScoreStr = std::to_string(player->getKills());
	const char* scoreString = (scoreIncompleteString + playerScoreStr).c_str();
	int j = strlen( scoreString );

	glColor3f(0, 0, 0);
	glRasterPos2f(0, 0);
	for( int i = 0; i < j; i++ ) {
		glutBitmapCharacter( GLUT_BITMAP_TIMES_ROMAN_24, scoreString[i] );
	}

	glPopMatrix();
}

void Arena::drawEndGameText(bool playerWon)
{
	glPushMatrix();
	glTranslatef(outerLimit->transform.position.x-55,outerLimit->transform.position.y,outerLimit->transform.position.z);

	string message;

	if(playerWon) {
		message = "You win! :)";
	}
	else {
		message = "You lose :(";
	}

	const char* endGameText = message.c_str();
	int j = strlen( endGameText );

	glColor3f(0, 0, 0);
	glRasterPos2f(0, 0);
	for( int i = 0; i < j; i++ ) {
		glutBitmapCharacter( GLUT_BITMAP_TIMES_ROMAN_24, endGameText[i] );
	}

	endMsgTimer += Time::deltaTime;

	if(endMsgTimer.count() > TIME_TO_AFTER_MSG) {
		glTranslatef(-25,-40,0);

		if(playerWon) {
			message = "Click to restart";
		}
		else {
			message = "Click to try again";
		}

		endGameText = message.c_str();
		int j = strlen( endGameText );

		glColor3f(0, 0, 0);
		glRasterPos2f(0, 0);
		for( int i = 0; i < j; i++ ) {
			glutBitmapCharacter( GLUT_BITMAP_TIMES_ROMAN_24, endGameText[i] );

		}

		glPopMatrix();
	}

	glPopMatrix();
}

void Arena::reset()
{
	if(endMsgTimer.count() > TIME_TO_AFTER_MSG) {
		player->setAlive(true);
		player->setKills(0);

		list<Player*>::iterator it;
		for (it = enemies.begin(); it != enemies.end(); ++it) {
			Player* enemy = (*it);
			enemy->setAlive(true);
		}

		endMsgTimer = Time::zeroDuration();
	}
}

void Arena::update()
{
	updateEnemies();
	updateBullets();
}

void Arena::updateEnemies()
{
	list<Player*>::iterator it;
	for (it = enemies.begin(); it != enemies.end(); ++it) {

		Player* enemy = (*it);

		enemy->moveRandomly();

		// Fire on frequency
	    Bullet* bulletFired = enemy->fireOnFreq();
	    if(bulletFired) {
	    	bullets.push_back(bulletFired);
	    }
	}
}

bool Arena::allEnemiesDead()
{
	list<Player*>::iterator it;
	for (it = enemies.begin(); it != enemies.end(); ++it) {

		Player* enemy = (*it);

		if(enemy->isAlive()) return false;
	}

	return true;
}

void Arena::updateBullets() {
    Bullet* bulletToRemove = NULL;

    list<Bullet*>::iterator it;
    for (it = bullets.begin(); it != bullets.end(); ++it) {

        if(bulletToRemove) {
            bullets.remove(bulletToRemove);
        }

        Bullet* bullet = (*it);

        bullet->move();

        if(!this->isOnLegalLocation(bullet)) {
            // cout << "Destroy bullet\n";
            bulletToRemove = bullet;
            // bullets.remove(bullet);
            // delete (*it);
        }
        else {
            bulletToRemove = NULL;
        }

        if(this->bulletHitEnemy(bullet)) {
            bulletToRemove = bullet;
			player->incrementKills();
        }

        if(player->gotHitBy(bullet)) {
            bulletToRemove = bullet;
            endMsgTimer = Time::zeroDuration();
            // Game Over?
        }
    }

    if(bulletToRemove) {
        bullets.remove(bulletToRemove);
        bulletToRemove->destroy();
    }
}

bool Arena::bulletHitEnemy(Bullet* bullet)
{
	list<Player*>::iterator it;
	for (it = enemies.begin(); it != enemies.end(); ++it) {
		Player* enemy = (*it);

	    if(Circle::isCirclesTouching(bullet->transform.position, bullet->shape->radius,
	    	enemy->transform.position, enemy->getOrgRadius())) {
	    	// cout << "Bullet hit Enemy... ";

	    	if(bullet->firedByPlayer && enemy->isAlive() && !enemy->isOnObstacle()) {
	    		// cout << "Fired by Player. Kill Enemy." << endl;
	    		// enemies.remove(enemy);
	    		enemy->die();

	    		endMsgTimer = Time::zeroDuration();

	    		return true;
	    	}

	    	// cout << "Fired by Enemy. Friendly Fire." << endl;
	    }
	}

	return false;
}

bool Arena::isOnLegalLocation(Player* player) {
	list<Obstacle*>::iterator it;

	// Check collision with obstacles
	for (it = obstacles.begin(); it != obstacles.end(); ++it){
		Obstacle* obstacle = (*it);

	    if(obstacle->isTouching(player)) {
	    	if((!player->isJumping() && !obstacle->isPlayerOn(player)) || !obstacle->canJumpOver() ||
	    		(player->isJumping() && !player->canClimb(obstacle) && !player->hasClimbed())) {
	    		// cout << "Touching Obstacle!\n";
	    		return false;
	    	}
	    }
	}

	list<Player*>::iterator it2;

	// Check collision with enemies
	for (it2 = enemies.begin(); it2 != enemies.end(); ++it2) {
		Player* enemy = (*it2);

		// Skip if you are yourself
		if(player == enemy) continue;

		if(enemy->isAlive() && Circle::isCirclesTouching(enemy->transform.position, enemy->getOrgRadius(),
	    	player->transform.position, player->getOrgRadius())) {
			return false;
		}
	}

	if(this->player != player) {
		if(Circle::isCirclesTouching(this->player->transform.position, this->player->getOrgRadius(),
	    	player->transform.position, player->getOrgRadius())) {
			return false;
		}
	}


	// Check collision with arena borders
	return
		! this->outerLimit->isLeavingCircle(player->transform.position, player->getOrgRadius()) &&
		! this->innerLimit->isTouchingCircle(player->transform.position, player->getOrgRadius());
}

bool Arena::isOnLegalLocation(Bullet* bullet) {
	list<Obstacle*>::iterator it;
	for (it = obstacles.begin(); it != obstacles.end(); ++it){
	    if((*it)->isTouching(bullet)) {
    		// cout << "Touching Obstacle!\n";
    		return false;
	    }
	}

	return
		! this->outerLimit->isLeavingCircle(bullet->transform.position, bullet->shape->radius) &&
		! this->innerLimit->isTouchingCircle(bullet->transform.position, bullet->shape->radius);
}

Obstacle* Arena::isTouchingObstacle(Player* player) {
	list<Obstacle*>::iterator it;
	for (it = obstacles.begin(); it != obstacles.end(); ++it){
	    if((*it)->isTouching(player))
	    	return (*it);
	}

	return NULL;
}

// Destructor
Arena::~Arena() {}
