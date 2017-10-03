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

public:
    // Constructor
    Settings();

    // Destructor
    virtual ~Settings() = 0;
};

#endif
