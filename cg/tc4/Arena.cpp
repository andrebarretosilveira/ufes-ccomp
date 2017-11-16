/**
 * Arena class implementation
 */

#include "Arena.h"

// Constructor
Arena::Arena(char* name, Circle* outerLimit, Circle* innerLimit, list<Obstacle*> obstacles, list<Player*> enemies)
{
	this->name = name;
    this->outerLimit = outerLimit;
    this->innerLimit = innerLimit;
	this->obstacles = list<Obstacle*>(obstacles);
    this->enemies = list<Player*>(enemies);

    list<Player*>::iterator it;
	for (it = enemies.begin(); it != enemies.end(); ++it) {
	    (*it)->setArena(this);
	}
}

// Draw Arena
void Arena::draw()
{
	if(!innerLimit || !outerLimit) {
		cout << "Arena stuff empty. Aborting.\n";
		exit(1);
	}

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
}

void Arena::updateEnemies()
{
	list<Player*>::iterator it;
	for (it = enemies.begin(); it != enemies.end(); ++it) {
	    Bullet* bulletFired = (*it)->fireOnFreq();
	    if(bulletFired) {
	    	bullets.push_back(bulletFired);
	    }
	}
}

void Arena::updateBullets(Player* player) {
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
        }

        if(player->gotHitBy(bullet)) {
            bulletToRemove = bullet;
            player = NULL;
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
	    	cout << "Bullet touching enemy" << endl;
        	enemies.remove(enemy);
	    	enemy->die();

	    	return true;
	    }
	}

	return false;
}

bool Arena::isOnLegalLocation(Player* player) {
	list<Obstacle*>::iterator it;

	for (it = obstacles.begin(); it != obstacles.end(); ++it){
	    if((*it)->isTouching(player)) {
	    	if((!player->isJumping() && !(*it)->isPlayerOn()) || !(*it)->canJumpOver() ||
	    		(player->isJumping() && !player->canClimb((*it)) && !player->hasClimbed())) {
	    		// cout << "Touching Obstacle!\n";
	    		return false;
	    	}
	    }
	    else {
	    	(*it)->setPlayerOn(false);
	    }
	}

	return
		! this->outerLimit->isLeavingCircle(player->transform.position, player->getOrgRadius()) &&
		! this->innerLimit->isTouchingCircle(player->transform.position, player->getOrgRadius());
}

bool Arena::isOnLegalLocation(Bullet* bullet) {
	list<Obstacle*>::iterator it;
	for (it = obstacles.begin(); it != obstacles.end(); ++it){
	    if((*it)->isTouching(bullet) && (*it)->canJumpOver()) {
    		// cout << "Touching Obstacle!\n";
    		return false;
	    }
	}

	return
		! this->outerLimit->isLeavingCircle(bullet->transform.position, bullet->shape->radius) &&
		! this->innerLimit->isTouchingCircle(bullet->transform.position, bullet->shape->radius);
}

Obstacle* Arena::isOnObstacle(Player* player) {
	list<Obstacle*>::iterator it;
	for (it = obstacles.begin(); it != obstacles.end(); ++it){
	    if((*it)->isTouching(player))
	    	return (*it);
	}

	return NULL;
}

// Destructor
Arena::~Arena() {}
