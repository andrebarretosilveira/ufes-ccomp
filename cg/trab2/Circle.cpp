/**
 * Circle class implementation
 */

#include "Circle.h"

#define distance_2pts(x1,y1,x2,y2) (sqrt(pow(x2-x1, 2) + (pow(y2-y1, 2))))

// Constructor
Circle::Circle(GLint radius, Point* location, Color* color)
    : radius(radius), location(location), color(color)
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
            glVertex2f(location->x, location->y);
            glVertex2f(location->x + (radius * cos(i * twicePi / triangleAmount)), location->y + (radius * sin(i * twicePi / triangleAmount)));
        }
    glEnd();
}

int Circle::isInside(int x, int y)
{
    return distance_2pts(x, y, location->x, location->y) < this->radius;
}

void Circle::moveOnYAxis(GLfloat dy) {
    this->location->y += dy;
}

void Circle::moveOnXAxis(GLfloat dx) {
    this->location->x += dx;
}

// Getters
GLint Circle::getRadius() { return this->radius; }
Point* Circle::getLocation() { return this->location; }
Color* Circle::getColor() { return this->color; }

// Setters
void Circle::setRadius(GLint radius) { this->radius = radius; }
void Circle::setLocation(Point* location) { this->location = location; }
void Circle::setColor(Color* color) { this->color = color; }

// Destructor
Circle::~Circle() {}
