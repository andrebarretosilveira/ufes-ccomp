/**
 * Rectangle class implementation
 */

#include "Rectangle.h"

// Constructor
Rectangle::Rectangle(GLint width, GLint height, Transform transform, Color color)
    : width(width), height(height), transform(transform), color(color)
    {}

// Draw circle using glut
void Rectangle::draw()
{
    glPushMatrix();
	glTranslatef(transform.position.x,transform.position.y,transform.position.z);
	glRotatef(transform.rotation.x,1,0,0);
	glRotatef(transform.rotation.y,0,1,0);
	glRotatef(transform.rotation.z,0,0,1);

    glColor3f(color.r,color.g,color.b);

	glBegin(GL_QUADS);
		glVertex2f(-width/2.0,0.0);
		glVertex2f(width/2.0,0.0);
		glVertex2f(width/2.0,height);
		glVertex2f(-width/2.0,height);
	glEnd();

    glPopMatrix();
}

// Getters
GLint Rectangle::getWidth() { return this->width; }
GLint Rectangle::getHeight() { return this->height; }

// Setters
void Rectangle::setWidth(GLint width) { this->width = width; }
void Rectangle::setHeight(GLint height) { this->height = height; }

// Destructor
Rectangle::~Rectangle() {}
