/**
 * Circle class implementation
 */

#include "Circle.h"

#define distance_2pts(x1,y1,x2,y2) (sqrt(pow(x2-x1, 2) + (pow(y2-y1, 2))))

// Constructor
Circle::Circle(GLint radius, Point& point, Color& color)
    : radius(radius), point(point), color(color)
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
        glColor3f(color.r, color.g, color.b);
        for(i = 0; i <= triangleAmount; i++)
        {
            glVertex2f(point.x, point.y);
            glVertex2f(point.x + (radius * cos(i * twicePi / triangleAmount)), point.y + (radius * sin(i * twicePi / triangleAmount)));
        }
    glEnd();
}

int Circle::isInside(int x, int y)
{
    return distance_2pts(x, y, point.x, point.y) < this->radius;
}


// Getters
GLint Circle::getRadius() { return radius; }
Point& Circle::getPoint() { return point; }
Color& Circle::getColor() { return color; }

// Setters
void Circle::setRadius(GLint radius) { this->radius = radius; }
void Circle::setPoint(const Point& point) { this->point = point; }
void Circle::setColor(const Color& color) { this->color = color; }

// Destructor
Circle::~Circle() {}
