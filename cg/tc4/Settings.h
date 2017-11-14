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
#include "Arena.h"
#include "Player.h"
#include "Enemy.h"
#include "Obstacle.h"
#include "Circle.h"
#include "Transform.h"
#include "Vector3.h"
#include "Color.h"

#define WINDOW_HEIGHT 600
#define WINDOW_WIDTH 600

using namespace std;
using namespace tinyxml2;

// Foward declarations
class Arena;
class Player;
class Enemy;
class Obstacle;
class Circle;
class Vector3;
class Transform;
class Color;

class Settings {

private:

public:
	Arena* arena;
	Player* player;
	Circle* outerLimit;
    Circle* innerLimit;
    // list<Obstacle*> obstacles;
    // list<Enemy*> enemies;

    // Constructor
    Settings();

    bool read_xml(char* filepath);

    GLfloat xScreenToWorld(GLfloat x);
    GLfloat yScreenToWorld(GLfloat y);

    // Destructor
    virtual ~Settings();
};

#endif
