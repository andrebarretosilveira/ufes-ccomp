/**
 * Cylinder class implementation
 */

#include "Cylinder.h"

// Constructor
Cylinder::Cylinder(GLfloat radius, GLfloat height, Transform transform, Color color)
    : radius(radius), height(height), transform(transform), color(color)
    {
        cylinderQuadratic = gluNewQuadric();
        diskQuadratic = gluNewQuadric();
        diskOnTop = false;
        inside = false;
    }

// Draw circle using glut
void Cylinder::render()
{
    glPushMatrix();
	glTranslatef(transform.position.x,transform.position.y,transform.position.z);
    glRotatef(transform.rotation.x,1,0,0);
	glRotatef(transform.rotation.y,0,1,0);
	glRotatef(transform.rotation.z,0,0,1);
    glScalef(transform.scale.x, transform.scale.y, transform.scale.z);

    GLfloat diskPos = diskOnTop ? height : 0;
    glTranslatef(0,0,+diskPos);
    gluDisk(diskQuadratic, 0, radius, SLICES, 1);
    glTranslatef(0,0,-diskPos);

    glColor3f(color.r, color.g, color.b);
    gluCylinder(cylinderQuadratic, radius, radius, height, SLICES, STACK);

    glPopMatrix();
}

void Cylinder::draw()
{
    glPushMatrix();
	glTranslatef(transform.position.x,transform.position.y,transform.position.z);
    glRotatef(transform.rotation.x,1,0,0);
	glRotatef(transform.rotation.y,0,1,0);
	glRotatef(transform.rotation.z,0,0,1);
    glScalef(transform.scale.x, transform.scale.y, transform.scale.z);

    // cout << transform.position;
    // cout << transform.rotation;
    // cout << transform.scale;

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

void Cylinder::drawLines()
{
    glPushMatrix();
	glTranslatef(transform.position.x,transform.position.y,transform.position.z);
    glRotatef(transform.rotation.x,1,0,0);
	glRotatef(transform.rotation.y,0,1,0);
	glRotatef(transform.rotation.z,0,0,1);
    glScalef(transform.scale.x, transform.scale.y, transform.scale.z);

    int i;
	GLfloat x, y;

	glColor3f(color.r,color.g,color.b);
	glPointSize(2);
	glBegin(GL_POINTS);
		for (i = 0; i < 360; i+=1) {
			x = radius * cos(M_PI*i/180);
			y = radius * sin(M_PI*i/180);
			glVertex3f(x, y, 0);
		}
	glEnd();

    glPopMatrix();
}

bool Cylinder::isInside(Vector3 position)
{
    return distance_2pts(transform.position.x, transform.position.y, position.x, position.y) < this->radius;
    // return true;
}

bool Cylinder::isTouchingCylinder(Vector3 pos, GLfloat radius) {
    return distance_2pts(transform.position.x, transform.position.y,
        pos.x, pos.y) <= this->radius + radius;
    // return true;
}

bool Cylinder::isLeavingCylinder(Vector3 pos, GLfloat radius) {
    return distance_2pts(transform.position.x, transform.position.y,
        pos.x, pos.y) + radius >= this->radius;
    // return true;
}

bool Cylinder::isCylindersTouching(Vector3 circ1Pos, GLfloat circ1Radius, Vector3 circ2Pos, GLfloat circ2Radius) {
    return distance_2pts(circ1Pos.x, circ1Pos.y,
        circ2Pos.x, circ2Pos.y) <= circ1Radius + circ2Radius;
    // return true;
}

// Getters
GLfloat Cylinder::getRadius() { return this->radius; }

// Setters
void Cylinder::setRadius(GLfloat radius) { this->radius = radius; }

// Destructor
Cylinder::~Cylinder() {}
