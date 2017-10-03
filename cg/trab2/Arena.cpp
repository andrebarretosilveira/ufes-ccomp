/**
 * Arena class implementation
 */

#include "Arena.h"

// Constructor
Arena::Arena(Circle* outerLimit, Circle* innerLimit)
{
    this->outerLimit = outerLimit;
    this->innerLimit = innerLimit;
}

// Draw Arena
void Arena::draw()
{
    innerLimit->draw();
    outerLimit->draw();
}

// Destructor
Arena::~Arena() {}
