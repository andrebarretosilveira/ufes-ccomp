/**
 * Player class interface
 */

#ifndef PLAYER_H
#define PLAYER_H

#include <iostream>
#include <GL/glut.h>
#include <chrono>
#include <cmath>
#include <cstdlib>
#include "Circle.h"
#include "Ellipse.h"
#include "Rectangle.h"
#include "Arena.h"
#include "Obstacle.h"
#include "Time.h"
#include "Bullet.h"
#include "Sphere.h"
#include "Camera.h"

using namespace std;

#define PLAYER_HEIGHT 40    // altura do jogador (posição da cabeça)
#define JUMP_TIME 1
#define JUMP_HEIGHT 40      // deslocamento vertical do pulo
#define ARM_POS_X 0
#define ARM_MAX_ROT 45
#define ARM_ROTATION_SPEED 0.05
#define ROTATION_SPEED 0.1
#define LEGS_ROT_SPEED 2.5
#define LEGS_NORMAL_ROT 90  // rotação para que fique "em pé"
#define LEGS_ROT 45	        // limite de rotação (+ e -)
#define RANDOM_ROTATION_AMOUNT 10   // qtd de rotação dos inimigos
#define RANDOM_MOVE_TIME 0.5        // parametro de movimento do inimigo

// #define HEAD_POS_HEIGHT 30
#define BODY_POS_HEIGHT 10

// Foward declarations
class Arena;
class Obstacle;
class Bullet;

class Player {

private:

public:
	Transform transform;
	Arena* arena;
    Sphere* head;
	Sphere* sholders;
	Rectangle *weaponArm, *lLegDown, *lLegUp, *rLegDown, *rLegUp, *body, *lArm;
    Obstacle* lastObstacleOn;
    Vector3 mousePos;
    GLfloat moveSpeed;
    GLfloat bulletSpeed;
    GLfloat fireFreq;
	GLfloat height;
    GLfloat heightOnJump;
    GLfloat orgRadius;
	GLfloat heightOnFall;
	GLfloat legsPosCounter;
    GLfloat life;
	GLint kills;
    GLint lastRandomMove;
    GLint randomMoveDirection;
    std::chrono::time_point<std::chrono::high_resolution_clock> lastRandomMoveTime;
    bool player;
    bool leftLegFoward;
    bool jumping;
    bool falling;
    bool climbed;
    bool overObstacle;
    bool onObstacle;
	bool alive;
	bool pressedS;
    bool invulnerable;
    std::chrono::duration<double> jumpElapsed;
    std::chrono::time_point<std::chrono::high_resolution_clock> lastFireTime;

    // Constructor
    Player(Sphere* head, Transform transform, GLfloat moveSpeed, GLfloat bulletSpeed, GLfloat fireFreq);

	void defineBody();
	void render(bool renderHead);
    void draw();
    void renderLegs(bool leftLegFoward);
    bool move(GLfloat direction);
    void rotate(GLfloat direction);
    void rotateWeaponArm(GLfloat mouseX, GLfloat mouseY);
	Vector3 getBulletSpawnPos();
	Vector3 getWeaponArmPos();
	Vector3 getEyePos();
    void rotateLegs(GLfloat direction);
	void rotateIdleArm(GLfloat direction);
    void moveRandomly();
    void jump();
    Bullet* fire();
    Bullet* fireOnFreq();
	void jumpLogic();
    void changeHeight(GLfloat heightOnJump, Obstacle* obstacle);
	void fallOnLeaveObstacle();
	bool canMove();
    bool isJumping();
    bool isOnObstacle();
    bool isPlayer();
    bool canClimb(Obstacle* obstacle);
    bool hasClimbed();
	void incrementKills();
    void setKills(GLint kills);
    Sphere* getHead();
	GLint getKills();
    GLfloat getOrgRadius();
    bool isAlive();
    void setAlive(bool state);
    void setArena(Arena* arena);
    void setPlayer(bool state);
    bool gotHitBy(Bullet* bullet);
    void die();

    // Destructor
    virtual ~Player();
};

#endif
