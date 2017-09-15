
#ifndef CIRCLE_DRAW_H
#define CIRCLE_DRAW_H

#include <stdio.h>
#include <GL/glut.h>
#include <cmath>
#include "input.h"

void draw_output(int argc, char** argv, Config* config);
void draw_circle(GLfloat x, GLfloat y, GLfloat radius);

#endif
