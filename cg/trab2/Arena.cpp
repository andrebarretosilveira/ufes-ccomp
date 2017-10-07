/**
 * Arena class implementation
 */

#include "Arena.h"

// Constructor
Arena::Arena(char* name, Circle* outerLimit, Circle* innerLimit, list<Circle*> obstacles)
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

    outerLimit->draw();
    innerLimit->draw();

    list<Circle*>::iterator it;
	for (it = obstacles.begin(); it != obstacles.end(); ++it){
	    (*it)->draw();
	}
}

// Destructor
Arena::~Arena() {}
