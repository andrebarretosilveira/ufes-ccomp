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
    static std::chrono::time_point<std::chrono::high_resolution_clock> lastFrameTime;
    static float deltaTime;

    static void initTime();
    static void updateTime();
};

#endif
