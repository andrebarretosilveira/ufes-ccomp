/**
 * Transform class implementation
 */

#include "Transform.h"

// Constructor
Transform::Transform(Vector3 position, Vector3 rotation, Vector3 scale)
	: position(position), rotation(rotation), scale(scale)
	{}


void Transform::Translate(GLfloat x, GLfloat y, GLfloat z) {
	position.x += x;
	position.y += y;
	position.z += z;
}

void Transform::Rotate(GLfloat x, GLfloat y, GLfloat z) {
	rotation.x += x;
	rotation.y += y;
	rotation.z += z;
}

void Transform::Scale(GLfloat x, GLfloat y, GLfloat z) {
	scale.x *= x;
	scale.y *= y;
	scale.z *= z;
}

void Transform::print() {
	cout << "- Transform -\n";
	cout << "Position: (" << position.x << "," << position.y << "," << position.z << ")\n";
	cout << "Rotation: (" << rotation.x << "," << rotation.y << "," << rotation.z << ")\n";
	cout << "Scale: (" << scale.x << "," << scale.y << "," << scale.z << ")\n";
}

// Destructor
Transform::~Transform() {}
