/**
 * Settings class interface
 */

#ifndef SETTINGS_H
#define SETTINGS_H

#include <iostream>
#include <GL/glut.h>
#include <list>
#include <string>
#include "tinyxml2.h"
#include "Obstacle.h"
#include "Circle.h"
#include "Point.h"
#include "Color.h"

using namespace std;
using namespace tinyxml2;

// Foward declarations
class Obstacle;
class Circle;
class Point;
class Color;

class Settings {

private:
    

public:
	char* arenaName;
	Circle* outerLimit;
    Circle* innerLimit;
    Circle* player_circle;
    list<Obstacle*> obstacles;

    // Constructor
    Settings();

    bool read_xml(char* filepath);

    // Destructor
    virtual ~Settings();
};

#endif
