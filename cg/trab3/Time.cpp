/**
 * Time class implementation
 */

#include "Time.h"

std::chrono::time_point<std::chrono::high_resolution_clock> Time::lastFrameTime;
float Time::deltaTime;

void Time::initTime() {
	lastFrameTime = std::chrono::high_resolution_clock::now();
}

void Time::updateTime() {
	auto currentFrameTime = std::chrono::high_resolution_clock::now();
	deltaTime = (currentFrameTime - lastFrameTime).count();
	cout << "deltaTime = " << deltaTime << "\n";
	lastFrameTime = currentFrameTime;
}
