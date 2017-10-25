/*
 * Robo.cpp
 *
 *  Created on: 3 de out de 2017
 *      Author: 2014100486
 */

#include "Robo.h"

Robo::Robo()
{
	gX = gY = 0;
	gTheta1 = gTheta2 = gTheta3 = 0;
	gThetaWheel = 0;
}


Robo::~Robo() {}

void Robo::moveOnXAxis(GLfloat dx) {
	this->gX += dx;
	this->rotateWheel(-dx*360/(2*M_PI*radiusWheel));
}

void Robo::moveOnYAxis(GLfloat dy) {
	this->gY += dy;
}

void Robo::rotatePaddle1(GLfloat dTheta) {
	this->gTheta1 += dTheta;
}

void Robo::rotatePaddle2(GLfloat dTheta) {
	this->gTheta2 += dTheta;
}

void Robo::rotatePaddle3(GLfloat dTheta) {
	this->gTheta3 += dTheta;
}

void Robo::rotateWheel(GLfloat dTheta) {
	this->gThetaWheel += dTheta;
}

void Robo::desenha() {
	this->desenhaRobo(gX, gY, gTheta1, gTheta2, gTheta3, gThetaWheel);
}

void Robo::desenhaRobo(GLfloat gX,GLfloat gY,GLfloat gTheta1,GLfloat gTheta2,GLfloat gTheta3,GLfloat gThetaWheel) {
	glPushMatrix();
	glTranslated(gX,gY,0);

	this->DesenhaRect(baseHeight,baseWidth,1,0,0);
	this->desenhaBracos(0, baseHeight, gTheta1, gTheta2, gTheta3);
	this->desenhaRodas(0, 0, gThetaWheel);

	glPopMatrix();
}

void Robo::desenhaBracos(GLfloat gX,GLfloat gY,GLfloat gTheta1,GLfloat gTheta2,GLfloat gTheta3) {
	glPushMatrix();

	glTranslated(gX,gY,0);
	glRotatef(gTheta1,0,0,1);
	this->DesenhaRect(paddleHeight, paddleWidth, 0, 0, 1);

	glTranslated(0,paddleHeight,0);
	glRotatef(gTheta2,0,0,1);
	this->DesenhaRect(paddleHeight, paddleWidth, 0, 1, 0);

	glTranslated(0,paddleHeight,0);
	glRotatef(gTheta3,0,0,1);
	this->DesenhaRect(paddleHeight, paddleWidth, 1, 1, 0);

	glRotatef(-gTheta1,0,0,1);
	glRotatef(-gTheta1,0,0,1);
	glRotatef(-gTheta1,0,0,1);

	glPopMatrix();
}

void Robo::desenhaRodas(GLfloat gX,GLfloat gY, GLfloat gThetaWheel) {
	glPushMatrix();

	glPushMatrix();
	glTranslated(+baseWidth/2.0,0,0);
	glRotatef(gThetaWheel,0,0,1);
	this->desenhaCircle(radiusWheel, 0, 0, 1);
	glPopMatrix();

	glPushMatrix();
	glTranslated(-baseWidth/2.0,0,0);
	glRotatef(gThetaWheel,0,0,1);
	this->desenhaCircle(radiusWheel, 0, 0, 1);
	glPopMatrix();

	glPopMatrix();
}

void Robo::DesenhaRect(GLint height,GLint width,GLfloat R, GLfloat G,GLfloat B) {
	glColor3f(R,G,B);

	glBegin(GL_QUADS);
		glVertex2f(-width/2.0,0.0);
		glVertex2f(width/2.0,0.0);
		glVertex2f(width/2.0,height);
		glVertex2f(-width/2.0,height);
	glEnd();
}

void Robo::desenhaCircle(GLint radius,GLfloat R, GLfloat G,GLfloat B) {
	int i;
	GLfloat x, y;

	glColor3f(R,G,B);
	glVector3Size(3);
	glBegin(GL_POINTS);
		for (i = 0; i < 360; i+=20) {
			x = radius * cos(M_PI*i/180);
			y = radius * sin(M_PI*i/180);
			glVertex3f(x, y, 0);
		}
	glEnd();
}
