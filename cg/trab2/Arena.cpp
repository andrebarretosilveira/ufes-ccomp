/**
 * Arena class implementation
 */

#include "Arena.h"

// Constructor
Arena::Arena(Circle* outerLimit, Circle* innerLimit, list<Circle*> obstacles)
{
    this->outerLimit = outerLimit;
    this->innerLimit = innerLimit;
    this->obstacles = obstacles;
}

// Draw Arena
void Arena::draw()
{
    innerLimit->draw();
    outerLimit->draw();
}

// Destructor
Arena::~Arena() {}