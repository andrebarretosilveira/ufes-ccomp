//============================================================================
// Name        : main.cpp
// Author      : André Barreto Silveira
// Description : Main file - TC4 - CG
//============================================================================

#include <iostream>
#include <GL/glut.h>
#include <list>
#include "Arena.h"
#include "Player.h"
#include "Settings.h"

int keyFlags[256];
Settings* settings;
Arena* arena;
Player* player;
Vector3 worldPos;
list<Bullet*> bullets;

void drawBullets() {
    list<Bullet*>::iterator it;
    for (it = bullets.begin(); it != bullets.end(); ++it){
        (*it)->draw();
    }
}

void display(void) {
	glClear(GL_COLOR_BUFFER_BIT);

	arena->draw();
    player->draw();
    drawBullets();

	glutSwapBuffers();
}

void init(void) {
  glClearColor(1.0f,1.0f,1.0f,1.0f);

  glMatrixMode(GL_PROJECTION);

  GLfloat arena_radius = arena->outerLimit->getRadius();
  GLfloat window_pos_x = arena->outerLimit->transform.position.x;
  GLfloat window_pos_y = arena->outerLimit->transform.position.y;

  worldPos = Vector3(window_pos_x, window_pos_y, 0);

  glOrtho(window_pos_x - arena_radius, window_pos_x + arena_radius,
    window_pos_y - arena_radius, window_pos_y + arena_radius,
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

void mouse(int button, int state, int x, int y) {
    // Check if left mouse button was clicked
    if(button == GLUT_LEFT_BUTTON && !state &&
        !player->isJumping() && !player->isOnObstacle()) {
        Bullet* bullet = player->fire();
        bullets.push_back(bullet);
    }
}

void passiveMotion(int x, int y) {
    int newX = settings->xScreenToWorld(x);
    int newY = settings->yScreenToWorld(WINDOW_HEIGHT - y);

	// cout << "newX = " << newX << " | newY = " << newY << "\n";

    player->rotateArm(newX, newY);
}

void updateBullets() {
    Bullet* bulletToRemove = NULL;

    list<Bullet*>::iterator it;
    for (it = bullets.begin(); it != bullets.end(); ++it) {

        if(bulletToRemove) {
            bullets.remove(bulletToRemove);
        }

        Bullet* bullet = (*it);

        bullet->move();

        if(!arena->isOnLegalLocation(bullet)) {
            // cout << "Destroy bullet\n";
            bulletToRemove = bullet;
            // bullets.remove(bullet);
            // delete (*it);
        }
        else {
            bulletToRemove = NULL;
        }
    }

    if(bulletToRemove) {
        bullets.remove(bulletToRemove);
        delete(bulletToRemove);
    }
}

void idle() {
	Time::updateTime();

    updateBullets();

    if(keyFlags['w'] == 1) {
		player->move(+1);
    }
    if(keyFlags['s'] == 1) {
		player->move(-1);
    }
    if(keyFlags['d'] == 1) {
		player->rotate(-1);
    }
    if(keyFlags['a'] == 1) {
		player->rotate(+1);
    }
    if(keyFlags['p'] == 1) {
        player->jump();
    }

    if(player->isJumping()) {
        player->jumpLogic();
    }
    else if(player->isOnObstacle()) {
        player->fallOnLeaveObstacle();
    }

    glutPostRedisplay();
}

int main(int argc,char** argv) {
    settings = new Settings();

    const char* config_filename = "config.xml";

    if(argc < 2) {
        cout << "\nModo de uso: ./trabalhocg <diretorio_do_arquivo_config>\n\n";
        return 1;
    }

    char* config_path = argv[1];

    if(strcmp(config_path, ".") == 0) strcat(config_path, "/");

    char* config_filepath = strcat(config_path, config_filename);


    if(!settings->read_xml(config_filepath)) {
        cout << "\nErro na leitura dos arquivos.\n";
        cout << "Certifique que os arquivos 'config.xml' e 'arena.svg'\nestao nos diretorios indicados.\n";
        cout << "\nAbortando programa.\n\n";
        return 1;
    }

    // arena = new Arena(settings->arenaName, settings->outerLimit, settings->innerLimit, settings->obstacles);
	// player = new Player(settings->playerCircle, settings->playerCircle->transform,
    //     settings->playerMoveSpeed, settings->playerBulletSpeed, arena);

    arena = settings->arena;
	player = settings->player;

	glutInit(&argc,argv);

	glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB);
	glutInitWindowSize(WINDOW_WIDTH,WINDOW_HEIGHT);
	glutInitWindowPosition(100,100);
	glutCreateWindow(arena->name);
	init();

	glutDisplayFunc(display);
	glutKeyboardFunc(keyPress);
    glutKeyboardUpFunc(keyRelease);
    glutMouseFunc(mouse);
    glutPassiveMotionFunc(passiveMotion);
    glutIdleFunc(idle);

	Time::initTime();

	glutMainLoop();

}
