/**
 * Time class implementation
 */

#include "Time.h"

void Time::updateFrameTime() {
}

float Time::deltaTime()
{
	auto lastFrameTime = std::chrono::high_resolution_clock::now();
	auto currentFrameTime = std::chrono::high_resolution_clock::now();

	return (currentFrameTime - lastFrameTime).count();
}
