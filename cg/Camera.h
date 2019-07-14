/**
 * Camera class interface
 */

#ifndef CAMERA_H
#define CAMERA_H

#include <iostream>
#include <GL/glut.h>
#include "Arena.h"
#include "Color.h"
#include "Vector3.h"

using namespace std;

class Camera {

private:

public:
    Vector3 eyeOffset;
    Vector3 lookOffset;
    Vector3 up;
    GLfloat playerRotOffsetXY;
    GLfloat playerRotOffsetZY;
    bool active = false;
    int lastX = 0;
    int lastY = 0;
    double camXYAngle = 0;
    double camXZAngle = 0;

    static bool fps;


    // Constructor
    Camera(Vector3 eyeOffset, Vector3 lookOffset, Vector3 up);

    void renderScene(Vector3 cameraPos, Vector3 targetPos, Vector3 rotation);
    void rotateAroundPlayer(GLfloat offsetX, GLfloat offsetY);
    void move(Vector3 offset);
    void destroy();
    void setCamXYAngle(double);
    void setCamXZAngle(double);
    void setLocation(Vector3 playerPos, Vector3 playerRot);

    static void setDefaults(GLfloat windowWidth, GLfloat windowHeight);

    // Destructor
    virtual ~Camera();
};

#endif
