/**
 * Time class implementation
 */

#include "Time.h"

std::chrono::time_point<std::chrono::high_resolution_clock> Time::lastFrameTime;
std::chrono::duration<double> Time::deltaTime;

void Time::initTime() {
	lastFrameTime = std::chrono::high_resolution_clock::now();
}

std::chrono::time_point<std::chrono::high_resolution_clock> Time::now() {
	return std::chrono::high_resolution_clock::now();
}

std::chrono::duration<double> Time::elapsed(std::chrono::time_point<std::chrono::high_resolution_clock> before,
	std::chrono::time_point<std::chrono::high_resolution_clock> now) {
	return (now - before);
}

void Time::updateTime() {
	auto currentFrameTime = std::chrono::high_resolution_clock::now();
	deltaTime = (currentFrameTime - lastFrameTime);
	lastFrameTime = currentFrameTime;
	
	// cout << "deltaTime = " << deltaTime.count() << "\n";
}
