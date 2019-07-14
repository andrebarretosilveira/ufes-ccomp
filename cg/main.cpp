//============================================================================
// Name        : main.cpp
// Author      : André Barreto Silveira e Igor Ventorim
// Description : Main file - TF - CG
//============================================================================

#include <iostream>
#include <GL/glut.h>
#include <list>
#include "Arena.h"
#include "Player.h"
#include "Settings.h"
#include "Sphere.h"
#include "Camera.h"

int keyFlags[256];
Settings* settings;
Arena* arena;
Player* player;
Vector3 worldPos;
Camera *camera1;
Camera *camera2;
Camera *playerVision;
bool mouseRightButtonDown = 0;
Vector3 lastMousePos = Vector3(0,0,0);
static bool lightingEnebled = true;
static bool light = true;

GLfloat ambientPlayer[] = {0.0, 0.0, 0.0, 1.0};
GLfloat diffusePlayer[] = {0.0, 1.0, 0.0, 1.0};
GLfloat specularPlayer[] = {1.0, 1.0, 1.0, 1.0};


void updateSpot();
void initSpot();

void displayPlayerVision()
{
    glViewport(0,WINDOW_HEIGHT*0.72,WINDOW_WIDTH,WINDOW_HEIGHT*0.28);

    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();

    gluPerspective (45, (GLfloat)500/(GLfloat)200, 1, -50);

    glMatrixMode(GL_MODELVIEW);
    glLoadIdentity();

    Vector3 handInicio = player->getEyePos();
    Vector3 handFinal = player->getBulletSpawnPos();

    gluLookAt(
		handInicio.x,handInicio.y,handInicio.z-10,
		handFinal.x,handFinal.y,handInicio.z-15,
		0,0,1
	);
    initSpot();
    arena->render(false);
    glPushMatrix();
    glMaterialfv(GL_FRONT, GL_AMBIENT, ambientPlayer);
    glMaterialfv(GL_FRONT, GL_DIFFUSE, diffusePlayer);
    glMaterialfv(GL_FRONT, GL_SPECULAR, specularPlayer);
    glMaterialf(GL_FRONT, GL_SHININESS, 60.0);
    player->render(false);
    glPopMatrix();
}

void displayCamerasVision()
{
    glViewport(0,0,WINDOW_WIDTH,WINDOW_HEIGHT*0.72);
    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();

    gluPerspective (45, (GLfloat)500/(GLfloat)500, 1, -50);

    glMatrixMode(GL_MODELVIEW);
    glLoadIdentity();

    if(camera1->active)
    {
        Vector3 camPos = player->getWeaponArmPos();
        Vector3 camTargetPos = player->getBulletSpawnPos();
        Vector3 camRot = player->transform.rotation;
        camera1->renderScene(camPos, camTargetPos, camRot);
        Camera::fps = true;

    }
    else if(camera2->active)
    {
        Vector3 camPos = player->transform.position;
        Vector3 camRot = Vector3(0,0,player->transform.rotation.z);
        camera2->renderScene(camPos, camPos, camRot);
        Camera::fps = false;
    }

    initSpot();
    arena->render(true);
    glPushMatrix();
    glMaterialfv(GL_FRONT, GL_AMBIENT, ambientPlayer);
    glMaterialfv(GL_FRONT, GL_DIFFUSE, diffusePlayer);
    glMaterialfv(GL_FRONT, GL_SPECULAR, specularPlayer);
    glMaterialf(GL_FRONT, GL_SHININESS, 60.0);
    player->render(true);
    glPopMatrix();
}

void displayMinimapVision()
{
    GLfloat window_pos_x = arena->outerLimit->transform.position.x;
    GLfloat window_pos_y = arena->outerLimit->transform.position.y;
    GLfloat arenaRadius = arena->outerLimit->radius;


    glViewport(-10+(WINDOW_WIDTH/6)*5,10,WINDOW_WIDTH/6,(WINDOW_HEIGHT*0.72)/6);

    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();

    glOrtho(
        window_pos_x - arenaRadius, window_pos_x + arenaRadius,
        window_pos_y - arenaRadius, window_pos_y + arenaRadius,
        100, -100
    );

    glMatrixMode(GL_MODELVIEW);
    glLoadIdentity();

    glPushAttrib(GL_ENABLE_BIT);
       glDisable(GL_LIGHTING);
       glDisable(GL_TEXTURE_2D);

       arena->render2D();
       player->draw();

    glPopAttrib();

    // glPopMatrix();
}

void display(void) {

        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

        displayPlayerVision();
        displayMinimapVision();
        displayCamerasVision();

        // glViewport(0,0,WINDOW_WIDTH,WINDOW_HEIGHT);
        if(settings->paused)
        {
            arena->drawPaused();
        }
        glutSwapBuffers();
        glutPostRedisplay();

}

void initSpot()
{

    /*Particular properties of all the lights*/
    Vector3 handFinal = player->getBulletSpawnPos();
    // Vector3 handFinal = player->transform.position;
    float noAmbient[] = {0.0f, 0.0f, 0.2f, 1.0f};       //low ambient light
    float diffuse[]   = {1.0f, 1.0f, 1.0f, 1.0f};
    float position[]  = {handFinal.x, handFinal.y, handFinal.z, 1.0f};

    //properties of the light
    glLightfv(GL_LIGHT1, GL_AMBIENT, noAmbient);
    glLightfv(GL_LIGHT1, GL_DIFFUSE, diffuse);
    glLightfv(GL_LIGHT1, GL_POSITION, position);

            /*Spot properties*/

    /*
        * define the spot direction and cut-off
        */
    updateSpot();

    //exponent propertie defines the concentration of the light
    glLightf(GL_LIGHT1, GL_SPOT_EXPONENT, 15.0f);

    //light attenuation (default values used here : no attenuation with the distance)
    glLightf(GL_LIGHT1, GL_CONSTANT_ATTENUATION, 1.0f);
    glLightf(GL_LIGHT1, GL_LINEAR_ATTENUATION, 0.0f);
    glLightf(GL_LIGHT1, GL_QUADRATIC_ATTENUATION, 0.0f);
}

/*
* Update position, direction and cut-off of the light
*/
void updateSpot()
{
    Vector3 handFinal = player->getBulletSpawnPos();
    Vector3 handInit = player->getWeaponArmPos();
    float direction[] = { handFinal.x - handInit.x , handFinal.y - handInit.y , handFinal.z - handInit.z};

    //spot direction
    glLightfv(GL_LIGHT1, GL_SPOT_DIRECTION, direction);
    //angle of the cone light emitted by the spot : value between 0 to 180
    glLightf(GL_LIGHT1, GL_SPOT_CUTOFF, 45);
}

void init(void) {
    //Lightning
    glEnable(GL_DEPTH_TEST);
    // glEnable( GL_TEXTURE_2D );
    // glEnable(GL_LIGHTING);
    // glShadeModel (GL_SMOOTH);
    // glDepthFunc(GL_LEQUAL);

	glClearColor(0,0,0,0);

	glMatrixMode(GL_PROJECTION);

	Vector3 outerLimitPos = arena->outerLimit->transform.position;
	worldPos = Vector3(outerLimitPos.x, outerLimitPos.y, outerLimitPos.z);

    // Lighting set up
    glLightModeli(GL_LIGHT_MODEL_LOCAL_VIEWER,GL_TRUE);
    glEnable(GL_LIGHTING);
    glEnable(GL_LIGHT0);
    // glEnable(GL_NORMALIZE);

    // Set lighting intensity and color
    GLfloat qaAmbientLight[] = {0.2,0.2,0.2,1.0};
    GLfloat qaDiffuseLight[] = {0.8,0.8,0.8,1.0};
    GLfloat qaSpecularLight[] = {1.0,1.0,1.0,1.0};
    glLightfv(GL_LIGHT0,GL_AMBIENT,qaAmbientLight);
    glLightfv(GL_LIGHT0,GL_DIFFUSE,qaDiffuseLight);
    glLightfv(GL_LIGHT0,GL_SPECULAR,qaSpecularLight);

    // Set the light position
    GLfloat qaLightPosition[] = {outerLimitPos.x, outerLimitPos.y, 20,1.0};
    glLightfv(GL_LIGHT0, GL_POSITION, qaLightPosition);

	Camera::setDefaults(WINDOW_WIDTH, WINDOW_HEIGHT);

	glMatrixMode(GL_MODELVIEW);
    Vector3 playerPos = player->transform.position;

    Vector3 eyeOffset = Vector3(0,-10,20);
    Vector3 lookOffset = Vector3(0,0,20);
    Vector3 up = Vector3(0,0,1);
	camera1 = new Camera(eyeOffset,lookOffset,up);

	eyeOffset = Vector3(0,-100,500);
    lookOffset = Vector3(0,20,10);
	camera2 = new Camera(eyeOffset,lookOffset,up);

    eyeOffset = Vector3(0,player->getHead()->getRadius(),-10);
    lookOffset = Vector3(0,player->getHead()->getRadius(),-10);
	playerVision = new Camera(eyeOffset,lookOffset,up);

	camera1->active = true;
    camera2->active = false;
    playerVision->active = false;
}

void keyPress(unsigned char key, int x, int y) {
    keyFlags[key] = 1;

	if(key == 'n')
    {
        lightingEnebled = !lightingEnebled;
        if ( lightingEnebled ){
            glDisable( GL_LIGHT0 );
            glEnable(GL_LIGHT1);
        }else{
            glEnable( GL_LIGHT0 );
            glDisable(GL_LIGHT1);
        }
    }
	if(key == '1')
	{
		player->weaponArm->transform.rotation.z = 0;
	}
	if(key == 'i')
	{
		player->invulnerable = !player->invulnerable;
	}

    if(key == 'l')
    {
        light = !light;
        if(light)
        {
            glEnable(GL_LIGHTING);
        }else
        {
            glDisable(GL_LIGHTING);
        }

    }

    if(key == ' ')
    {
        settings->paused = !settings->paused;
    }
}

void keyRelease(unsigned char key, int x, int y) {
    keyFlags[key] = 0;
}

void mouse(int button, int state, int x, int y) {
    // Check if left mouse button was clicked
    if(button == GLUT_LEFT_BUTTON && !state) {
        Bullet* bullet = player->fire();

        if(bullet) {
            bullet->firedByPlayer = true;
            arena->bullets.push_back(bullet);
        }

        arena->reset();
    }

    if(button == GLUT_RIGHT_BUTTON && state == GLUT_DOWN)
    {
        camera2->lastX = x;
        camera2->lastY = y;
        mouseRightButtonDown = 1;
		lastMousePos = Vector3(x,y,0);
    }

    if (button == GLUT_RIGHT_BUTTON && state == GLUT_UP) {
        mouseRightButtonDown = 0;
    }

}

void activeMouseMotion(int x, int y) {
	if(mouseRightButtonDown && camera2->active)
	{
		int offsetXY = lastMousePos.x < x ? -1 : +1;
		int offsetZY = lastMousePos.y < y ? -1 : +1;

		camera2->rotateAroundPlayer(offsetXY, offsetZY);

		lastMousePos = Vector3(x,y,0);
	}
}

void passiveMouseMotion(int x, int y) {
    if(settings->paused){return;}
    int newX = settings->xScreenToWorld(x);
    int newY = settings->yScreenToWorld(WINDOW_HEIGHT - y);

    player->rotateWeaponArm(newX, newY);

}

void idle() {
    if(!settings->paused)
    {
    	Time::updateTime();
        // static bool gameVision = true;


        arena->update();

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

        if(keyFlags['1'] == 1)
        {
            camera1->active = true;
            camera2->active = false;
        }

        if(keyFlags['2'] == 1)
        {
            camera1->active = false;
            camera2->active = true;
        }


    	player->pressedS = keyFlags['s'];

        if(player->isJumping()) {
            player->jumpLogic();
        }
        else if(player->isOnObstacle()) {
            player->fallOnLeaveObstacle();
        }

        glutPostRedisplay();
    }
}

void reshape (int w, int h) {

    glViewport (0, 0, (GLsizei)w, (GLsizei)h);

    // changeCamera(camAngle, w, h);
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

    arena = settings->arena;
	player = settings->player;
    player->setPlayer(true);

	glutInit(&argc,argv);

	glutInitDisplayMode(GLUT_DOUBLE | GLUT_DEPTH);
	glutInitWindowSize(WINDOW_WIDTH,WINDOW_HEIGHT);
	glutInitWindowPosition(30, 50);
	glutCreateWindow(arena->name);
	init();

	glutDisplayFunc(display);
	glutKeyboardFunc(keyPress);
    glutKeyboardUpFunc(keyRelease);
    glutReshapeFunc (reshape);
    glutMouseFunc(mouse);
	glutPassiveMotionFunc(passiveMouseMotion);
    glutMotionFunc(activeMouseMotion);
    glutIdleFunc(idle);

	Time::initTime();

	glutMainLoop();

}
