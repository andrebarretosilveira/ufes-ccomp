
#include "circle_draw.h"

#define distance_2pts(x1,y1,x2,y2) (sqrt(pow(x2-x1, 2) + (pow(y2-y1, 2))))

Config* config;
Circle* circle;

int key_flags[256];
int resize_state;
int move_state;
int offsetX, offsetY;
float previous_distance;

int limit_between(int value, int li, int ls) {
    if(value < li) return li;
    else if(value > ls) return ls;
    else return value;
}

void display(void) {
    glClear(GL_COLOR_BUFFER_BIT);

    if(circle != NULL) {
        circle->draw();
    }

    glutSwapBuffers();
}

// void draw_circle(GLfloat x, GLfloat y, GLfloat radius)
// {
//     int i;
//     int triangleAmount = 1000;
//     GLfloat twicePi = 2.0f * M_PI;

//     glEnable(GL_LINE_SMOOTH);
//     glLineWidth(5.0);

//     glBegin(GL_LINES);
//         glColor3f(circle->color_R, circle->color_G, circle->color_B);
//         for(i = 0; i <= triangleAmount; i++)
//         {
//             glVertex2f(x, y);
//             glVertex2f(x + (radius * cos(i * twicePi / triangleAmount)), y + (radius * sin(i * twicePi / triangleAmount)));
//         }
//     glEnd();
// }

void init(void) {
    glClearColor(config->window_R, config->window_G, config->window_B, 0.0);

    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();
    glOrtho(0, config->window_width, 0, config->window_height, -1.0, 1.0);
}

// void keyPress(unsigned char key, int x, int y) {
//     key_flags[key] = 1;
// }

// void keyRelease(unsigned char key, int x, int y) {
//     key_flags[key] = 0;
// }

void mouse(int button, int state, int x, int y) {
    int newX = x;
    int newY = config->window_height - y;

    // Check if left mouse button was clicked
    if(button == GLUT_LEFT_BUTTON) {
        if(state == false) { // Mouse Button Down
            // Check if circle is not already drawn
            if(circle == NULL) {
                circle = new Circle(config->circle_radius, newX, newY,
                    config->circle_R, config->circle_G, config->circle_B);
            }
            else if(circle->isInside(newX, newY)) {
                offsetX = newX - circle->getX();
                offsetY = newY - circle->getY();
                move_state = true;
            }
        }
        else { // Mouse Button Up
            move_state = false;
        }
    }
    // Check if right mouse button was clicked
    else if(button == GLUT_RIGHT_BUTTON) {
        if(circle && circle->isInside(newX, newY)) {
            resize_state = !state;
            previous_distance = distance_2pts(newX, newY, circle->getX(), circle->getY());
        }
        else {
            resize_state = false;
        }
    }
}

void motion(int x, int y) {
    int newX = x;
    int newY = config->window_height - y;

    // RESIZE state
    if(resize_state) {
        float current_distance = distance_2pts(newX, newY, circle->getX(), circle->getY());

        //circle->radius += current_distance - previous_distance;
        circle->setRadius(circle->getRadius() + current_distance - previous_distance);

        if(circle->getRadius() < 30) {
            circle->setRadius(30);
        }

        previous_distance = current_distance;
    }
    // MOVE state
    else if(move_state) {        
        circle->setX(limit_between(newX - offsetX, 0, config->window_width));
        circle->setY(limit_between(newY - offsetY, 0, config->window_height));
    }
}

void idle() {
    // if(key_flags['w'] == 1 || key_flags['W'] == 1) {
    //     circle->y += 1;
    // }
    // if(key_flags['s'] == 1 || key_flags['S'] == 1) {
    //     circle->y -= 1;
    // }
    // if(key_flags['d'] == 1 || key_flags['D'] == 1) {
    //     circle->x += 1;
    // }
    // if(key_flags['a'] == 1 || key_flags['A'] == 1) {
    //     circle->x -= 1;
    // }

    glutPostRedisplay();
}

void draw_output(int argc, char** argv, Config* config_input) {
    config = config_input;
    circle = NULL;
    resize_state = false;
    move_state = false;

    glutInit(&argc, argv);
    glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB);
    glutInitWindowSize(config->window_width, config->window_height);
    glutInitWindowPosition(200, 200);
    glutCreateWindow(config->window_title);
    init();
    glutDisplayFunc(display);
    // glutKeyboardFunc(keyPress);
    // glutKeyboardUpFunc(keyRelease);
    glutMouseFunc(mouse);
    glutMotionFunc(motion);
    glutIdleFunc(idle);
    glutMainLoop();
}
