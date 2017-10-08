/**
 * Circle class implementation
 */

#include "Circle.h"

// Constructor
Circle::Circle(int id, GLfloat radius, Point* position, Color* color)
    : id(id), radius(radius), position(position), color(color)
    {}

// Draw circle using glut
void Circle::draw()
{
    int i;
    int triangleAmount = 1000;
    GLfloat twicePi = 2.0f * M_PI;

    glEnable(GL_LINE_SMOOTH);
    glLineWidth(5.0);

    glBegin(GL_LINES);
        glColor3f(color->r, color->g, color->b);
        for(i = 0; i <= triangleAmount; i++)
        {
            glVertex2f(position->x, position->y);
            glVertex2f(position->x + (radius * cos(i * twicePi / triangleAmount)), position->y + (radius * sin(i * twicePi / triangleAmount)));
        }
    glEnd();
}

bool Circle::isInside(Point* position)
{
    return distance_2pts(this->position->x, this->position->y, position->x, position->y) < this->radius;
}

bool Circle::isTouchingCircle(Circle* circle) {
    return distance_2pts(this->position->x, this->position->y, 
        circle->position->x, circle->position->y) <= this->radius + circle->radius;
}

bool Circle::isLeavingCircle(Circle* circle) {
    return distance_2pts(this->position->x, this->position->y, 
        circle->position->x, circle->position->y) + circle->radius >= this->radius;
}

void Circle::moveOnYAxis(GLfloat dy) {
    this->position->y += dy;
}

void Circle::moveOnXAxis(GLfloat dx) {
    this->position->x += dx;
}

// Getters
GLfloat Circle::getRadius() { return this->radius; }
Point* Circle::getPosition() { return this->position; }
Color* Circle::getColor() { return this->color; }

// Setters
void Circle::setRadius(GLfloat radius) { this->radius = radius; }
void Circle::setPosition(Point* position) { this->position = position; }
void Circle::setColor(Color* color) { this->color = color; }

// Destructor
Circle::~Circle() {}
