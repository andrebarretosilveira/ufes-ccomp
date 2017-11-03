
#ifndef CIRCLE_DRAW_H
#define CIRCLE_DRAW_H

#include <stdio.h>
#include <GL/glut.h>
#include <cmath>
#include "input.h"
#include "Circle.h"

// Foward declaration
class Circle;

void draw_output(int argc, char** argv, Config* config);
void draw_circle(GLfloat x, GLfloat y, GLfloat radius);

#endif
