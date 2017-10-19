/**
 * Rectangle class implementation
 */

#include "Rectangle.h"

// Constructor
Rectangle::Rectangle(GLint width, GLint height, Point* position, Color* color)
    : width(width), height(height), position(position), color(color)
    {}

// Draw circle using glut
void Rectangle::draw()
{
    glPushMatrix();
	glTranslatef(position->x,position->y,position->z);

    glColor3f(color->r,color->g,color->b);

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
Point* Rectangle::getPosition() { return this->position; }
Color* Rectangle::getColor() { return this->color; }

// Setters
void Rectangle::setWidth(GLint width) { this->width = width; }
void Rectangle::setHeight(GLint height) { this->height = height; }
void Rectangle::setPosition(Point* position) { this->position = position; }
void Rectangle::setColor(Color* color) { this->color = color; }

// Destructor
Rectangle::~Rectangle() {}
