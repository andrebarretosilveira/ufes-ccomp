/**
 * Circle class implementation
 */

#include "Circle.h"

// Constructor
Circle::Circle(int id, GLfloat radius, Transform transform, Color color)
    : id(id), radius(radius), transform(transform), color(color)
    {}

// Draw circle using glut
void Circle::draw()
{
    glPushMatrix();
	glTranslatef(transform.position.x,transform.position.y,transform.position.z);
    glRotatef(transform.rotation.x,1,0,0);
	glRotatef(transform.rotation.y,0,1,0);
	glRotatef(transform.rotation.z,0,0,1);
    glScalef(transform.scale.x, transform.scale.y, transform.scale.z);

    int i;
    int triangleAmount = 700;
    GLfloat twicePi = 2.0f * M_PI;

    glEnable(GL_LINE_SMOOTH);
    glLineWidth(5.0);

    glBegin(GL_LINES);
        glColor3f(color.r, color.g, color.b);
        for(i = 0; i <= triangleAmount; i++)
        {
            glVertex2f(0, 0);
            glVertex2f((radius * cos(i * twicePi / triangleAmount)), (radius * sin(i * twicePi / triangleAmount)));
        }
    glEnd();

    glPopMatrix();
}

bool Circle::isInside(Vector3 position)
{
    return distance_2pts(transform.position.x, transform.position.y, position.x, position.y) < this->radius;
}

bool Circle::isTouchingCircle(Vector3 pos, GLfloat radius) {
    return distance_2pts(transform.position.x, transform.position.y,
        pos.x, pos.y) <= this->radius + radius;
}

bool Circle::isLeavingCircle(Vector3 pos, GLfloat radius) {
    return distance_2pts(transform.position.x, transform.position.y,
        pos.x, pos.y) + radius >= this->radius;
}

// Getters
GLfloat Circle::getRadius() { return this->radius; }

// Setters
void Circle::setRadius(GLfloat radius) { this->radius = radius; }

// Destructor
Circle::~Circle() {}
