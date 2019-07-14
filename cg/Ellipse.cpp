/**
 * Ellipse class implementation
 */

#include "Ellipse.h"

// Constructor
Ellipse::Ellipse(GLfloat radiusX, GLfloat radiusY, Transform transform, Color color)
    : radiusX(radiusX), radiusY(radiusY), transform(transform), color(color)
    {}

// Draw circle using glut
void Ellipse::draw()
{
    glPushMatrix();
	glTranslatef(transform.position.x,transform.position.y,transform.position.z);
	glRotatef(transform.rotation.x,1,0,0);
	glRotatef(transform.rotation.y,0,1,0);
	glRotatef(transform.rotation.z,0,0,1);
    glScalef(transform.scale.x, transform.scale.y, transform.scale.z);

    glColor3f(color.r,color.g,color.b);

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
            glVertex2f((radiusX * cos(i * twicePi / triangleAmount)), (radiusY * sin(i * twicePi / triangleAmount)));
        }
    glEnd();

    glPopMatrix();
}

// Destructor
Ellipse::~Ellipse() {}
