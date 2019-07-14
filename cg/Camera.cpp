/**
 * Camera class implementation
 */

#include "Camera.h"
#include "cmath"

bool Camera::fps;

// Constructor
Camera::Camera(Vector3 eyeOffset, Vector3 lookOffset, Vector3 up)
	: eyeOffset(eyeOffset),lookOffset(lookOffset),up(up)
{
	playerRotOffsetXY = 0;
	playerRotOffsetZY = 0;
}

void Camera::renderScene(Vector3 cameraPos, Vector3 targetPos, Vector3 rotation)
{
	GLfloat playerRotXY = rotation.z + playerRotOffsetXY;
	GLfloat playerRotZY = rotation.x + playerRotOffsetZY;

	// playerRotZY = playerRotZY > 20 ? 20 : playerRotZY;
	// playerRotZY = playerRotZY < -10 ? -10 : playerRotZY;

	// cout << playerRotOffsetZY << " | " << playerRotZY << endl;

	double xline = (eyeOffset.x)*cos(playerRotXY*DEG2RAD) - (eyeOffset.y)*sin(playerRotXY*DEG2RAD);
	double yline = (eyeOffset.x)*sin(playerRotXY*DEG2RAD) + (eyeOffset.y)*cos(playerRotXY*DEG2RAD);
	double zline = (eyeOffset.z)*sin(playerRotZY*DEG2RAD) - (eyeOffset.y)*cos(playerRotZY*DEG2RAD);

	if(Camera::fps){
		// glRotatef(-rotation.z,0,1,0);

		// xline = eyeOffset.x;
		// yline = eyeOffset.y;
		zline = eyeOffset.z;
	}
	else {
		// yline += (eyeOffset.z)*cos(playerRotZY*DEG2RAD) + (eyeOffset.y)*sin(playerRotZY*DEG2RAD);
	}

	Vector3 cameraEye = Vector3(
		cameraPos.x + xline,
		cameraPos.y + yline,
		cameraPos.z + zline // zline aqui...
	);

	Vector3 cameraLook = Vector3(
		targetPos.x + lookOffset.x,
		targetPos.y + lookOffset.y,
		targetPos.z + lookOffset.z
	);

	gluLookAt(
		cameraEye.x,cameraEye.y,cameraEye.z,
		cameraLook.x,cameraLook.y,cameraLook.z,
		up.x,up.y,up.z
	);

}

void Camera::rotateAroundPlayer(GLfloat offsetXY, GLfloat offsetZY)
{
	playerRotOffsetXY += offsetXY;
	playerRotOffsetZY -= offsetZY/5.0;

	playerRotOffsetZY = playerRotOffsetZY > 20 ? 20 : playerRotOffsetZY;
	playerRotOffsetZY = playerRotOffsetZY < -10 ? -10 : playerRotOffsetZY;
}

void Camera::move(Vector3 offset)
{
	eyeOffset.x += offset.x;
	eyeOffset.y += offset.y;
	eyeOffset.z += offset.z;

	// if(eyeOffset.x > 100 || eyeOffset.x < -100) {
	// 	eyeOffset.x -= offset.x;
	// 	eyeOffset.y -= offset.y;
	// 	eyeOffset.z -= offset.z;
	//
	// 	cout << "offset = " << eyeOffset.x << " " << eyeOffset.y << " " << eyeOffset.z << endl;
	// 	cout << "Rotacionado ate o limite arbritario '100'" <<endl;
	// }

}

void Camera::destroy()
{
	delete(this);
}


void Camera::setDefaults(GLfloat windowWidth, GLfloat windowHeight)
{
	double angle = 45;
	double fAspect = windowWidth/windowHeight;
	double zNear = 0.1;
	double zFar = 1000;

	Camera::fps = false;

	gluPerspective(angle,fAspect,zNear,zFar);

}

void Camera::setCamXYAngle(double angle)
{
	if(angle > 180)
	{
		camXYAngle = 180;
	}else
	{
		camXYAngle = angle;
	}

}

void Camera::setCamXZAngle(double angle)
{
	if(angle > 90)
	{
		camXZAngle = 90;
	}else
	{
		camXZAngle = angle;
	}
}

// Destructor
Camera::~Camera() {}
