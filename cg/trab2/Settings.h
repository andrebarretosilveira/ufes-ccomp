/**
 * Settings class interface
 */

#ifndef SETTINGS_H
#define SETTINGS_H

#include <iostream>
#include <GL/glut.h>
#include <cmath>

using namespace std;

// Foward declarations
//class OtherClassUsedHere;

class Settings {

private:
    Circle* outerLimit;
    Circle* innerLimit;
    list<Circle*> obstacles;

public:
    // Constructor
    Settings();

    bool read_xml(char* filepath);

    // Destructor
    virtual ~Settings() = 0;
};

#endif
