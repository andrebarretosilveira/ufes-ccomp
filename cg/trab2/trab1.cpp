
#include <stdio.h>
#include <GL/glut.h>
#include <cmath>
#include "input.h"
#include "Circle.h"

int key_flags[256];
Settings* settings;

void display(void) {
    glClear(GL_COLOR_BUFFER_BIT);

    // add draw here

    glutSwapBuffers();
}

void init(void) {
    glClearColor(settings->window_R, settings->window_G, settings->window_B, 0.0);

    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();
    glOrtho(0, settings->window_width, 0, settings->window_height, -1.0, 1.0);
}

void keyPress(unsigned char key, int x, int y) {
    key_flags[key] = 1;
}

void keyRelease(unsigned char key, int x, int y) {
    key_flags[key] = 0;
}

void idle() {
    if(key_flags['w'] == 1 || key_flags['W'] == 1) {
        circle->y += 1;
    }
    if(key_flags['s'] == 1 || key_flags['S'] == 1) {
        circle->y -= 1;
    }
    if(key_flags['d'] == 1 || key_flags['D'] == 1) {
        circle->x += 1;
    }
    if(key_flags['a'] == 1 || key_flags['A'] == 1) {
        circle->x -= 1;
    }

    glutPostRedisplay();
}

void draw_screen(int argc, char** argv) {
    glutInit(&argc, argv);
    glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB);
    glutInitWindowSize(settings->window_width, settings->window_height);
    glutInitWindowPosition(200, 200);
    glutCreateWindow(settings->window_title);
    init();
    glutDisplayFunc(display);
    glutKeyboardFunc(keyPress);
    glutKeyboardUpFunc(keyRelease);
    glutIdleFunc(idle);
    glutMainLoop();
}

int main(int argc, char** argv) {
    Config* config;

    if(argc < 2) {
        printf("Insira caminho do arquivo ao chamar o programa. Abortando.\n");
        return 1;
    }

    //config = read_config_file(argv[1]);

    //print_config(config);

    draw_output(argc, argv, config);

    return 0;
}
