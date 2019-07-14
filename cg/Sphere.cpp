/**
 * Sphere class implementation
 */

#include "Sphere.h"

// Constructor
Sphere::Sphere(GLfloat radius, Transform transform, Color color)
    : radius(radius), transform(transform), color(color)
    {}

// Draw circle using glut
void Sphere::render()
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

    // glColor3f(color.r,color.g,color.b);

    glutSolidSphere(radius, SLICES, STACK);

    glPopMatrix();
}

bool Sphere::isInside(Vector3 position)
{
    return distance_3pts(transform.position.x, transform.position.y, transform.position.y, position.x, position.y, position.z) < this->radius;
}

bool Sphere::isTouchingSphere(Vector3 pos, GLfloat radius) {
    return distance_3pts(transform.position.x, transform.position.y, transform.position.z, pos.x, pos.y, pos.z) <= this->radius + radius;
}

bool Sphere::isLeavingSphere(Vector3 pos, GLfloat radius) {
    return distance_3pts(transform.position.x, transform.position.y, transform.position.z, pos.x, pos.y, pos.z) + radius >= this->radius;
}

bool Sphere::isSpheresTouching(Vector3 pos1, GLfloat radius1, Vector3 pos2, GLfloat radius2) {
    return distance_3pts(pos1.x, pos1.y, pos1.z, pos2.x, pos2.y, pos2.z) <= radius1 + radius2;
}

// Getters
GLfloat Sphere::getRadius() { return this->radius; }

// Setters
void Sphere::setRadius(GLfloat radius) { this->radius = radius; }

// Destructor
Sphere::~Sphere() {}
