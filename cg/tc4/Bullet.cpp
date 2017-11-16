/**
 * Bullet class implementation
 */

#include "Bullet.h"

// Constructor
Bullet::Bullet(Vector3 position, Vector3 moveDirection, GLfloat moveSpeed, GLfloat radius)
	: transform(Transform(position, Vector3(0,0,0), Vector3(1,1,1))),
	  moveDirection(moveDirection), moveSpeed(moveSpeed), radius(radius)
	  
{
	this->shape = new Circle(0, radius, Transform(Vector3(0,0,0), Vector3(0,0,0), Vector3(1,1,1)),
		Color(0,0,0));

	firedByPlayer = false;

	// cout << "Bullet created! r = " << shape->getRadius() << "\n";
	// cout << "bulletPos: (" << position.x << ", " << position.y << ")\n";
	// cout << "targetDirection: (" << moveDirection.x << ", " << moveDirection.y << ")\n";
}

// Draw Bullet
void Bullet::draw()
{
	glPushMatrix();
	glTranslatef(transform.position.x,transform.position.y,transform.position.z);
    glRotatef(transform.rotation.x,1,0,0);
	glRotatef(transform.rotation.y,0,1,0);
	glRotatef(transform.rotation.z,0,0,1);
    glScalef(transform.scale.x, transform.scale.y, transform.scale.z);

    shape->draw();
    
    glPopMatrix();
}

void Bullet::move()
{
	// cout << "Bullet moving!\n";
	transform.position.x += moveDirection.x * moveSpeed * Time::deltaTime.count() * 1000;
	transform.position.y += moveDirection.y * moveSpeed * Time::deltaTime.count() * 1000;
}

bool Bullet::isTouching(Player* player) {
	return this->shape->isTouchingCircle(player->transform.position, player->getOrgRadius());
}

void Bullet::destroy()
{
	delete(this);
}

// Destructor
Bullet::~Bullet() {}
