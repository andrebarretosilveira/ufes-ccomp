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
#include "Enemy.h"
#include "Circle.h"
#include "Transform.h"
#include "Vector3.h"
#include "Color.h"

#define WINDOW_HEIGHT 600
#define WINDOW_WIDTH 600

using namespace std;
using namespace tinyxml2;

// Foward declarations
class Obstacle;
class Enemy;
class Circle;
class Vector3;
class Transform;
class Color;

class Settings {

private:


public:
	char* arenaName;
	Circle* outerLimit;
    Circle* innerLimit;
    Circle* playerCircle;
    GLfloat playerMoveSpeed;
    GLfloat playerBulletSpeed;
    list<Obstacle*> obstacles;
    list<Enemy*> enemies;

    // Constructor
    Settings();

    bool read_xml(char* filepath);

    GLfloat xScreenToWorld(GLfloat x);
    GLfloat yScreenToWorld(GLfloat y);

    // Destructor
    virtual ~Settings();
};

#endif
