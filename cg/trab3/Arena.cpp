/**
 * Arena class implementation
 */

#include "Arena.h"

// Constructor
Arena::Arena(char* name, Circle* outerLimit, Circle* innerLimit, list<Obstacle*> obstacles)
{
	this->name = name;
    this->outerLimit = outerLimit;
    this->innerLimit = innerLimit;
    this->obstacles = obstacles;
}

// Draw Arena
void Arena::draw()
{
	if(!innerLimit || !outerLimit) {
		cout << "Arena stuff empty. Aborting.\n";
		exit(1);
	}

	glPushMatrix();
	//glTranslatef(outerLimit->getPosition()->x,outerLimit->getPosition()->y,outerLimit->getPosition()->z);
    outerLimit->draw();
	glPopMatrix();

	glPushMatrix();
	//glTranslatef(innerLimit->getPosition()->x,innerLimit->getPosition()->y,innerLimit->getPosition()->z);
    innerLimit->draw();
	glPopMatrix();

    list<Obstacle*>::iterator it;
	for (it = obstacles.begin(); it != obstacles.end(); ++it){
	    (*it)->draw();
	}
}

bool Arena::isOnLegalLocation(Player* player) {
	list<Obstacle*>::iterator it;
	for (it = obstacles.begin(); it != obstacles.end(); ++it){
	    if((*it)->isTouching(player)) {
	    	if((!player->isJumping() && !(*it)->isPlayerOn()) || !(*it)->canJumpOver())
	    		return false;
	    }
	    else {
	    	(*it)->setPlayerOn(false);
	    }
	}

	return
		! this->outerLimit->isLeavingCircle(player->getHead()) &&
		! this->innerLimit->isTouchingCircle(player->getHead());
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
