/**
 * Time class interface
 */

#ifndef TIME_H
#define TIME_H

#include <iostream>
#include <chrono>

using namespace std;

class Time {

private:  
    // Disallow creating an instance of this object
    Time() {}

public:
    static void updateFrameTime();
    static float deltaTime();

};

#endif
