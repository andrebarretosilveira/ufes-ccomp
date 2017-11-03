/**
 * Circle class implementation
 */

#include "Circle.h"

#define distance_2pts(x1,y1,x2,y2) (sqrt(pow(x2-x1, 2) + (pow(y2-y1, 2))))

// Constructor
Circle::Circle(const int radius, const int x, const int y, const int color_R, const int color_G, const int color_B)
    : radius(radius), x(x), y(y)
    , color_R(color_R), color_G(color_G), color_B(color_B)
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
        glColor3f(color_R, color_G, color_B);
        for(i = 0; i <= triangleAmount; i++)
        {
            glVertex2f(x, y);
            glVertex2f(x + (radius * cos(i * twicePi / triangleAmount)), y + (radius * sin(i * twicePi / triangleAmount)));
        }
    glEnd();
}

int Circle::isInside(int x, int y)
{
    return distance_2pts(x, y, this->x, this->y) < this->radius;
}


// Getters
int Circle::getRadius() { return radius; }
int Circle::getX() { return x; }
int Circle::getY() { return y; }

// Setters
void Circle::setRadius(const int radius) { this->radius = radius; }
void Circle::setX(const int x) { this->x = x; }
void Circle::setY(const int y) { this->y = y; }

// Destructor
Circle::~Circle() {}
