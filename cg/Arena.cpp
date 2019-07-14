/**
 * Arena class implementation
 */

#include "Arena.h"

// Constructor
Arena::Arena(char* name, Cylinder* outerLimit, Cylinder* innerLimit, Player* player, list<Obstacle*> obstacles, list<Player*> enemies)
{
	this->name = name;
    this->outerLimit = outerLimit;
    this->innerLimit = innerLimit;
    this->player = player;
	this->obstacles = list<Obstacle*>(obstacles);
    this->enemies = list<Player*>(enemies);

    list<Player*>::iterator it;
	for (it = enemies.begin(); it != enemies.end(); ++it) {
	    (*it)->setArena(this);
	}

	outerLimit->height = player->height * 6;
	innerLimit->height = player->height * 6;
	outerLimit->inside = true;
	innerLimit->inside = false;

	Vector3 ceilingPos = outerLimit->transform.position;
	ceilingPos.z = outerLimit->height;

	Transform transform = Transform(ceilingPos, Vector3(0,0,0), Vector3(1,1,1));
	ceiling = new Cylinder(outerLimit->radius, 100, transform, Color(1,1,1));
	ceiling->diskOnTop = false;

	endMsgTimer = Time::zeroDuration();

	this->player->setArena(this);
}

// Draw Arena
void Arena::render(bool textOn)
{
	glPushMatrix();
	GLfloat ambientOuterLimit[] = {0.5, 0.5, 0.5, 1.0};
	GLfloat diffuseOuterLimit[] = {0.0, 0.0, 1.0, 1.0};
	GLfloat specularOuterLimit[] = {1.0, 1.0, 1.0, 1.0};
	glMaterialfv(GL_FRONT, GL_AMBIENT, ambientOuterLimit);
	glMaterialfv(GL_FRONT, GL_DIFFUSE, diffuseOuterLimit);
	glMaterialfv(GL_FRONT, GL_SPECULAR, specularOuterLimit);
	glMaterialf(GL_FRONT, GL_SHININESS, 128);
	outerLimit->render();
	// ceiling->render();
	glPopMatrix();


    // Drawing Obstacles
    list<Obstacle*>::iterator itObs;
	GLfloat ambientObstacle[] = {0.0, 0.0, 0.0, 1.0};
	GLfloat diffuseObstacle[] = {1.0, 1.0, 1.0, 1.0};
	GLfloat specularObstacle[] = {1.0, 1.0, 1.0, 1.0};
	for (itObs = obstacles.begin(); itObs != obstacles.end(); ++itObs){
	    glPushMatrix();

		glMaterialfv(GL_FRONT, GL_AMBIENT, ambientObstacle);
		glMaterialfv(GL_FRONT, GL_DIFFUSE, diffuseObstacle);
		glMaterialfv(GL_FRONT, GL_SPECULAR, specularObstacle);
		glMaterialf(GL_FRONT, GL_SHININESS, 128.0);
		(*itObs)->render();
		glPopMatrix();
	}

	glPushMatrix();
	GLfloat ambientInnerLimit[] = {1.0, 1.0, 1.0, 1.0};
	GLfloat diffuseInnerLimit[] = {1.0, 1.0, 1.0, 1.0};
	GLfloat specularInnerLimit[] = {1.0, 1.0, 1.0, 1.0};
	glMaterialfv(GL_FRONT, GL_AMBIENT, ambientInnerLimit);
	glMaterialfv(GL_FRONT, GL_DIFFUSE, diffuseInnerLimit);
	glMaterialfv(GL_FRONT, GL_SPECULAR, specularInnerLimit);
	glMaterialf(GL_FRONT, GL_SHININESS, 128.0);
	innerLimit->render();
	glPopMatrix();

	// Drawing Enemies
	list<Player*>::iterator itEne;
	GLfloat ambientEnemies[] = {0.0, 0.0, 0.0, 1.0};
	GLfloat diffuseEnemies[] = {1.0, 0.0, 0.0, 1.0};
	GLfloat specularEnemies[] = {1.0, 1.0, 1.0, 1.0};
	for (itEne = enemies.begin(); itEne != enemies.end(); ++itEne){
		glPushMatrix();
		glMaterialfv(GL_FRONT, GL_AMBIENT, ambientEnemies);
		glMaterialfv(GL_FRONT, GL_DIFFUSE, diffuseEnemies);
		glMaterialfv(GL_FRONT, GL_SPECULAR, specularEnemies);
		glMaterialf(GL_FRONT, GL_SHININESS, 128.0);
	    (*itEne)->render(true);
		glPopMatrix();
	}

	// Drawing Bullets
    list<Bullet*>::iterator itBullets;
    for (itBullets = bullets.begin(); itBullets != bullets.end(); ++itBullets) {
		(*itBullets)->render();
    }

	// glPushMatrix();
	// GLfloat ambientText[] = {1.0, 1.0, 1.0, 1.0};
	// GLfloat diffuseText[] = {1.0, 1.0, 0.0, 1.0};
	// GLfloat specularText[] = {1.0, 1.0, 1.0, 1.0};
	// glMaterialfv(GL_FRONT, GL_AMBIENT, ambientText);
	// glMaterialfv(GL_FRONT, GL_DIFFUSE, diffuseText);
	// glMaterialfv(GL_FRONT, GL_SPECULAR, specularText);
	// glMaterialf(GL_FRONT, GL_SHININESS, 128.0);

    if(textOn)
    {
    	drawScore();

		if(player->invulnerable)
		{
			drawInvincibleText();
		}
		else {
			drawLifeText();
		}

		if(!player->isAlive()) {
			drawEndGameText(false);
		}
		else if(allEnemiesDead()) {
			drawEndGameText(true);
		}

	}
	// glPopMatrix();

}

void Arena::render2D()
{
	outerLimit->drawLines();
	innerLimit->drawLines();

	// Drawing Enemies
	list<Player*>::iterator itEne;
	for (itEne = enemies.begin(); itEne != enemies.end(); ++itEne){
	    (*itEne)->draw();
	}

	// Drawing Obstacles
    list<Obstacle*>::iterator itObs;
	for (itObs = obstacles.begin(); itObs != obstacles.end(); ++itObs){
	    (*itObs)->draw();
	}
}

void Arena::drawScore()
{

	glPushMatrix ();
	glLoadIdentity ();
	glMatrixMode(GL_PROJECTION);
	glPushMatrix ();
	glLoadIdentity();

	GLint viewport [4];
	glGetIntegerv (GL_VIEWPORT, viewport);
	gluOrtho2D (0,viewport[2], viewport[3], 0);

	glDepthFunc (GL_ALWAYS);

	string invincibleStr = "Kills: ";
	string playerScoreStr = std::to_string(player->getKills());
	const char *invincibleText = (invincibleStr + playerScoreStr).c_str();

	glPushAttrib(GL_ENABLE_BIT);
		glDisable(GL_LIGHTING);
		// glDisable(GL_TEXTURE_2D);
		//Draw text in the x, y, z position
        glColor3f(1,1,0);
        glRasterPos3f(viewport[2] - 90, 40, 0);
        while( *invincibleText ){
            glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24, *invincibleText);
            invincibleText++;
        }
    glPopAttrib();

	glDepthFunc (GL_LESS);
	glPopMatrix ();
	glMatrixMode(GL_MODELVIEW);
	glPopMatrix ();

}

void Arena::drawInvincibleText()
{
	// cout << "Escreve 'invecivel vai'" << endl;

	glPushMatrix ();
	glLoadIdentity ();
	glMatrixMode(GL_PROJECTION);
	glPushMatrix ();
	glLoadIdentity();

	GLint viewport [4];
	glGetIntegerv (GL_VIEWPORT, viewport);
	gluOrtho2D (0,viewport[2], viewport[3], 0);

	glDepthFunc (GL_ALWAYS);

	string invincibleStr = "Invulnerable";
	const char *invincibleText = (invincibleStr).c_str();

	glPushAttrib(GL_ENABLE_BIT);
		glDisable(GL_LIGHTING);
        glColor3f(1,1,0);
        glRasterPos3f(10, 40, 0);
        while( *invincibleText ){
            glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24, *invincibleText);
            invincibleText++;
        }
    glPopAttrib();

	glDepthFunc (GL_LESS);
	glPopMatrix ();
	glMatrixMode(GL_MODELVIEW);
	glPopMatrix ();

}


void Arena::drawPaused()
{
	// cout << "Escreve 'invecivel vai'" << endl;

	glPushMatrix ();
	glLoadIdentity ();
	glMatrixMode(GL_PROJECTION);
	glPushMatrix ();
	glLoadIdentity();

	GLint viewport [4];
	glGetIntegerv (GL_VIEWPORT, viewport);
	gluOrtho2D (0,viewport[2], viewport[3], 0);

	glDepthFunc (GL_ALWAYS);

	string invincibleStr = "GAME PAUSED";
	const char *invincibleText = (invincibleStr).c_str();

	glPushAttrib(GL_ENABLE_BIT);
		glDisable(GL_LIGHTING);
        glColor3f(1,1,0);
        glRasterPos3f(viewport[2]/2-80, viewport[3]/2, 0);
        while( *invincibleText ){
            glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24, *invincibleText);
            invincibleText++;
        }
    glPopAttrib();

	glDepthFunc (GL_LESS);
	glPopMatrix ();
	glMatrixMode(GL_MODELVIEW);
	glPopMatrix ();

}


void Arena::drawLifeText()
{
	// cout << "Escreve 'invecivel vai'" << endl;

	glPushMatrix ();
	glLoadIdentity ();
	glMatrixMode(GL_PROJECTION);
	glPushMatrix ();
	glLoadIdentity();

	GLint viewport [4];
	glGetIntegerv (GL_VIEWPORT, viewport);
	gluOrtho2D (0,viewport[2], viewport[3], 0);

	glDepthFunc (GL_ALWAYS);

	string lifeStr = "hp: ";
	string playerLife = std::to_string((int)player->life);
	const char *lifeText = (lifeStr + playerLife).c_str();

	glPushAttrib(GL_ENABLE_BIT);
		glDisable(GL_LIGHTING);
        glColor3f(1,1,0);
        glRasterPos3f(10, 40, 0);
        while( *lifeText ){
            glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24, *lifeText);
            lifeText++;
        }
    glPopAttrib();

	glDepthFunc (GL_LESS);
	glPopMatrix ();
	glMatrixMode(GL_MODELVIEW);
	glPopMatrix ();

}

void Arena::drawEndGameText(bool playerWon)
{
	string message;

	if(playerWon) {
		message = "You win! :)";
	}
	else {
		message = "You lose :(";
	}


	glPushMatrix ();
	glLoadIdentity ();
	glMatrixMode(GL_PROJECTION);
	glPushMatrix ();
	glLoadIdentity();

	GLint viewport [4];
	glGetIntegerv (GL_VIEWPORT, viewport);
	gluOrtho2D (0,viewport[2], viewport[3], 0);

	glDepthFunc (GL_ALWAYS);


		const char *endGameText = message.c_str();
		glPushAttrib(GL_ENABLE_BIT);
			glDisable(GL_LIGHTING);
			// glDisable(GL_TEXTURE_2D);
			//Draw text in the x, y, z position
			glColor3f(1,1,0);
			glRasterPos3f(viewport[2]/2-50, 50, 0);
			while( *endGameText ){
				glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24, *endGameText);
				endGameText++;
			}
		glPopAttrib();






	endMsgTimer += Time::deltaTime;

	if(endMsgTimer.count() > TIME_TO_AFTER_MSG) {


		if(playerWon) {
			message = "Click to restart";
		}
		else {
			message = "Click to try again";
		}

		endGameText = message.c_str();

		    //Push to recover original attributes
		glPushAttrib(GL_ENABLE_BIT);
			glDisable(GL_LIGHTING);
			// glDisable(GL_TEXTURE_2D);
			//Draw text in the x, y, z position
			glColor3f(1,1,0);
			glRasterPos3f(viewport[2]/2-70, 80, 0);

			while( *endGameText ){
				glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24, *endGameText);
				endGameText++;
			}
		glPopAttrib();

	}



	glDepthFunc (GL_LESS);
	glPopMatrix ();
	glMatrixMode(GL_MODELVIEW);
	glPopMatrix ();


}

void Arena::reset()
{
	if(endMsgTimer.count() > TIME_TO_AFTER_MSG) {
		player->setAlive(true);
		player->setKills(0);
		player->life = 100;

		list<Player*>::iterator it;
		for (it = enemies.begin(); it != enemies.end(); ++it) {
			Player* enemy = (*it);
			enemy->setAlive(true);
		}

		endMsgTimer = Time::zeroDuration();
	}
}

void Arena::update()
{
	updateEnemies();
	updateBullets();
}

void Arena::updateEnemies()
{
	list<Player*>::iterator it;
	for (it = enemies.begin(); it != enemies.end(); ++it) {

		Player* enemy = (*it);

		enemy->moveRandomly();

		// Fire on frequency
	    Bullet* bulletFired = enemy->fireOnFreq();
	    if(bulletFired) {
	    	bullets.push_back(bulletFired);
	    }
	}
}

bool Arena::allEnemiesDead()
{
	list<Player*>::iterator it;
	for (it = enemies.begin(); it != enemies.end(); ++it) {

		Player* enemy = (*it);

		if(enemy->isAlive()) return false;
	}

	return true;
}

void Arena::updateBullets() {
    Bullet* bulletToRemove = NULL;

    list<Bullet*>::iterator it;
    for (it = bullets.begin(); it != bullets.end(); ++it) {

        if(bulletToRemove) {
            bullets.remove(bulletToRemove);
        }

        Bullet* bullet = (*it);

        bullet->move();

        if(!this->isOnLegalLocation(bullet)) {
            // cout << "Destroy bullet\n";
            bulletToRemove = bullet;
        }
        else {
            bulletToRemove = NULL;
        }

        if(this->bulletHitEnemy(bullet)) {
            bulletToRemove = bullet;
			player->incrementKills();
        }

        if(player->gotHitBy(bullet) && !player->invulnerable) {
            bulletToRemove = bullet;
            endMsgTimer = Time::zeroDuration();
            // Game Over?
        }
    }

    if(bulletToRemove) {
        bullets.remove(bulletToRemove);
        bulletToRemove->destroy();
    }
}

bool Arena::bulletHitEnemy(Bullet* bullet)
{
	list<Player*>::iterator it;
	for (it = enemies.begin(); it != enemies.end(); ++it) {
		Player* enemy = (*it);

		Vector3 hitBoxPos = enemy->transform.position + enemy->head->transform.position;
		hitBoxPos.z /= 2;

	    if(Sphere::isSpheresTouching(bullet->transform.position, bullet->shape->radius,
	    	hitBoxPos, enemy->getOrgRadius() * 1.3)) {
	    	// cout << "Bullet hit Enemy... ";

	    	if(bullet->firedByPlayer && enemy->isAlive()) {
	    		// cout << "Fired by Player. Kill Enemy." << endl;
	    		// enemies.remove(enemy);
	    		enemy->die();

	    		endMsgTimer = Time::zeroDuration();

	    		return true;
	    	}

	    	// cout << "Fired by Enemy. Friendly Fire." << endl;
	    }
	}

	return false;
}

bool Arena::isOnLegalLocation(Player* player) {
	list<Obstacle*>::iterator it;

	// Check collision with obstacles
	for (it = obstacles.begin(); it != obstacles.end(); ++it){
		Obstacle* obstacle = (*it);

	    if(obstacle->isTouching(player)) {
	    	if((!player->isJumping() && !obstacle->isPlayerOn(player)) || !obstacle->canJumpOver() ||
	    		(player->isJumping() && !player->canClimb(obstacle) && !player->hasClimbed())) {
	    		return false;
	    	}
	    }
	}

	list<Player*>::iterator it2;

	// Check collision with enemies
	for (it2 = enemies.begin(); it2 != enemies.end(); ++it2) {
		Player* enemy = (*it2);

		// Skip if you are yourself
		if(player == enemy) continue;

		if(enemy->isAlive() && Circle::isCirclesTouching(enemy->transform.position, enemy->getOrgRadius(),
	    	player->transform.position, player->getOrgRadius())) {
			return false;
		}
	}

	if(this->player != player) {
		if(Circle::isCirclesTouching(this->player->transform.position, this->player->getOrgRadius(),
	    	player->transform.position, player->getOrgRadius())) {
			return false;
		}
	}


	// Check collision with arena borders
	return
		! this->outerLimit->isLeavingCylinder(player->transform.position, player->getOrgRadius()) &&
		! this->innerLimit->isTouchingCylinder(player->transform.position, player->getOrgRadius());
}

bool Arena::isOnLegalLocation(Bullet* bullet) {
	list<Obstacle*>::iterator it;
	for (it = obstacles.begin(); it != obstacles.end(); ++it){
		// if((*it)->isTouching(bullet)) {   // alerta de gambiarra
		Vector3 hitBoxPos = (*it)->shape->transform.position;
		hitBoxPos.z += (*it)->shape->height;

	    if(Sphere::isSpheresTouching(hitBoxPos, (*it)->shape->radius * 0.7,
			bullet->transform.position, bullet->shape->radius)) {
    		// cout << "Touching Obstacle!\n";
    		return false;
	    }
	}

	return
		! this->outerLimit->isLeavingCylinder(bullet->transform.position, bullet->shape->radius) &&
		! this->innerLimit->isTouchingCylinder(bullet->transform.position, bullet->shape->radius);
}

Obstacle* Arena::isTouchingObstacle(Player* player) {
	list<Obstacle*>::iterator it;
	for (it = obstacles.begin(); it != obstacles.end(); ++it){
	    if((*it)->isTouching(player))
	    	return (*it);
	}

	return NULL;
}

// Destructor
Arena::~Arena() {}
