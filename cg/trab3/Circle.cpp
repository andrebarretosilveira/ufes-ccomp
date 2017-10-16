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
    int triangleAmount = 700;
    GLfloat twicePi = 2.0f * M_PI;

    glEnable(GL_LINE_SMOOTH);
    glLineWidth(5.0);

    glBegin(GL_LINES);
        glColor3f(color->r, color->g, color->b);
        for(i = 0; i <= triangleAmount; i++)
        {
            glVertex2f(0, 0);
            glVertex2f((radius * cos(i * twicePi / triangleAmount)), (radius * sin(i * twicePi / triangleAmount)));
        }
    glEnd();
    //
    // int i;
	// GLfloat x, y;
    //
	// glColor3f(color->r,color->g,color->b);
	// //glPointSize(3);
	// glBegin(GL_POINTS);
	// 	for (i = 0; i < 360; i+=1) {
	// 		x = radius * cos(M_PI*i/180);
	// 		y = radius * sin(M_PI*i/180);
	// 		glVertex3f(x, y, 0);
	// 	}
	// glEnd();
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
