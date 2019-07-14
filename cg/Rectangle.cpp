/**
 * Rectangle class implementation
 */

#include "Rectangle.h"

// Constructor
Rectangle::Rectangle(GLint width, GLint height, Transform transform, Color color)
    : transform(transform), color(color), width(width), height(height)
    {}

// Draw circle using glut
void Rectangle::render()
{
    glPushMatrix();
	glTranslatef(transform.position.x,transform.position.y,transform.position.z);
	glRotatef(transform.rotation.x,1,0,0);
	glRotatef(transform.rotation.y,0,1,0);
	glRotatef(transform.rotation.z,0,0,1);
    glScalef(transform.scale.x, transform.scale.y, transform.scale.z);

    GLfloat ambientBullets[] = {0.0, 0.0, 0.0, 1.0};
	GLfloat diffuseBullets[] = {color.r, color.g, color.b, 1.0};
	GLfloat specularBullets[] = {1.0, 1.0, 1.0, 1.0};
	glMaterialfv(GL_FRONT, GL_AMBIENT, ambientBullets);
	glMaterialfv(GL_FRONT, GL_DIFFUSE, diffuseBullets);
	glMaterialfv(GL_FRONT, GL_SPECULAR, specularBullets);
	glMaterialf(GL_FRONT, GL_SHININESS, 128.0);


	glBegin(GL_QUADS);
		glVertex3f(-width/2.0,0.0,0.0);
		glVertex3f(width/2.0,0.0,0.0);
		glVertex3f(width/2.0,height,0.0);
		glVertex3f(-width/2.0,height,0.0);

		glVertex3f(width/2.0,0.0,0.0);
		glVertex3f(width/2.0,height,0.0);
		glVertex3f(width/2.0,height,10.0);
		glVertex3f(width/2.0,0,10.0);

		glVertex3f(-width/2.0,0.0,0.0);
		glVertex3f(-width/2.0,height,0.0);
		glVertex3f(-width/2.0,height,10.0);
		glVertex3f(-width/2.0,0,10.0);

		glVertex3f(-width/2.0,height,0.0);
		glVertex3f(width/2.0,height,0.0);
		glVertex3f(width/2.0,height,10.0);
		glVertex3f(-width/2.0,height,10.0);

		glVertex3f(-width/2.0,0.0,0.0);
		glVertex3f(width/2.0,0.0,0.0);
		glVertex3f(width/2.0,0.0,10.0);
		glVertex3f(-width/2.0,0.0,10.0);

		glVertex3f(-width/2.0,0.0,10.0);
		glVertex3f(width/2.0,0.0,10.0);
		glVertex3f(width/2.0,height,10.0);
		glVertex3f(-width/2.0,height,10.0);

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
