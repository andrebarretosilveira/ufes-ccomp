//============================================================================
// Name        : main.cpp
// Author      : André Barreto Silveira
// Description : Main file - TC2 - CG
//============================================================================

#include <stdio.h>
#include <stdlib.h>
#include <GL/glut.h>
#include "Arena.h"
#include "Player.h"
#include "Settings.h"

#define WINDOW_HEIGHT 600
#define WINDOW_WIDTH 600

int keyFlags[256];
Settings* settings;
Arena* arena;
Player* player;

void display(void) {
	glClear(GL_COLOR_BUFFER_BIT);

	arena->draw();
    player->draw();

	glutSwapBuffers();
}

void init(void) {
  glClearColor(0.0f,0.0f,0.0f,1.0f);

  glMatrixMode(GL_PROJECTION);

  float window_size = arena->outerLimit->getRadius() * 2;
  float window_pos_x = arena->outerLimit->getLocation()->x;
  float window_pos_y = arena->outerLimit->getLocation()->y;

  glOrtho(window_pos_x - window_size/2, window_pos_x + window_size/2,
    window_pos_y - window_size/2, window_pos_y + window_size/2,
    100,-100);

  glMatrixMode(GL_MODELVIEW);
  glLoadIdentity();
}

void keyPress(unsigned char key, int x, int y) {
    keyFlags[key] = 1;
}

void keyRelease(unsigned char key, int x, int y) {
    keyFlags[key] = 0;
}

void idle() {
    if(keyFlags['w'] == 1) {
		player->moveOnYAxis(+1);
    }
    if(keyFlags['s'] == 1) {
		player->moveOnYAxis(-1);
    }
    if(keyFlags['d'] == 1) {
		player->moveOnXAxis(+1);
    }
    if(keyFlags['a'] == 1) {
		player->moveOnXAxis(-1);
    }

    glutPostRedisplay();
}

int main(int argc,char** argv) {
    settings = new Settings();

    const char* config_filename = "config.xml";

    if(argc < 2) {
        printf("\nModo de uso: ./trabalhocg <diretorio_do_arquivo_config>\n\n");
        return 1;
    }

    char* config_filepath = strcat(argv[1], config_filename);

    printf("%s\n", config_filepath);

    if(!settings->read_xml(config_filepath)) {
        printf("\nErro na leitura dos arquivos.\n");
        printf("Certifique que os arquivos 'config.xml' e 'arena.svg' estao nos diretorios indicados.\n");
        printf("Abortando.\n\n");
        return 1;
    }

    arena = new Arena(settings->arenaName, settings->outerLimit, settings->innerLimit, settings->obstacles);
	player = new Player(settings->player_circle);

	glutInit(&argc,argv);

	glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB);
	glutInitWindowSize(WINDOW_WIDTH,WINDOW_HEIGHT);
	glutInitWindowPosition(100,100);
	glutCreateWindow(arena->name);
	init();

	glutDisplayFunc(display);
	glutKeyboardFunc(keyPress);
    glutKeyboardUpFunc(keyRelease);
    glutIdleFunc(idle);

	glutMainLoop();

}
