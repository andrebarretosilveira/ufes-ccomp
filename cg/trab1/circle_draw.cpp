
#include "circle_draw.h"

WindowConfig* window;
CircleConfig* circle;

int key_flags[256];
int can_draw;
int resize;
float previous_distance;

#define distance_2pts(x1,y1,x2,y2) (sqrt(pow(x2-x1, 2) + (pow(y2-y1, 2))))

void display(void) {
    glClear(GL_COLOR_BUFFER_BIT);

    if(can_draw) {
        draw_circle(circle->x, circle->y, circle->radius);
    }

    glutSwapBuffers();
}

void draw_circle(GLfloat x, GLfloat y, GLfloat radius)
{
    int i;
    int triangleAmount = 100;
    GLfloat twicePi = 2.0f * M_PI;

    glEnable(GL_LINE_SMOOTH);
    glLineWidth(5.0);

    glBegin(GL_LINES);
        glColor3f(circle->color_R, circle->color_G, circle->color_B);
        for(i = 0; i <= triangleAmount; i++)
        {
            glVertex2f(x, y);
            glVertex2f(x + (radius * cos(i * twicePi / triangleAmount)), y + (radius * sin(i * twicePi / triangleAmount)));
        }
    glEnd();
}

void init(void) {
    glClearColor(window->color_R, window->color_G, window->color_B, 0.0);

    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();
    glOrtho(0, window->width, 0, window->height, -1.0, 1.0);
}

void keyPress(unsigned char key, int x, int y) {
    key_flags[key] = 1;

    //glutPostRedisplay();
}

void keyRelease(unsigned char key, int x, int y) {
    key_flags[key] = 0;

    //glutPostRedisplay();
}

void mouse(int button, int state, int x, int y) {
    int newX = x;
    int newY =  window->height - y;

    // Check if left mouse button clicked
    if(button == GLUT_LEFT_BUTTON && state) {
        // Check if circle is already drawn
        if(!can_draw) {
            circle->x = newX;
            circle->y = newY;
            can_draw = true;
        }
    }
    else if(button == GLUT_RIGHT_BUTTON) {
        resize = !state;
        previous_distance = distance_2pts(newX, newY, circle->x, circle->y);
        printf("Resize: %d, radius: %d\n", resize, circle->radius);
    }
}

void motion(int x, int y) {
    int newX = x;
    int newY =  window->height - y;

    //printf("Motion: %d %d %d %d %f %d\n", newX, newY, circle->x, circle->y, distance_2pts(newX, newY, circle->x, circle->y), circle->radius);

    // Check if mouse is inside circle
    if(distance_2pts(newX, newY, circle->x, circle->y) < circle->radius) {
        // RESIZE condition
        if(resize) {
            float current_distance = distance_2pts(newX, newY, circle->x, circle->y);

            circle->radius += current_distance - previous_distance;

            if(circle->radius < 50) {
                circle->radius = 50;
            }

            previous_distance = current_distance;
        }
        // MOVE condition
        else {
            //int offsetX = newX + circle->x;
            //int offsetY = newY + circle->y;
            circle->x = newX;
            circle->y = newY;
        }

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

void draw_output(int argc, char** argv, Config* config) {
    window = config->window;
    circle = config->circle;
    can_draw = false;
    resize = false;

    glutInit(&argc, argv);
    glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB);
    glutInitWindowSize(window->width, window->height);
    glutInitWindowPosition(200, 200);
    glutCreateWindow(window->title);
    init();
    glutDisplayFunc(display);
    glutKeyboardFunc(keyPress);
    glutKeyboardUpFunc(keyRelease);
    glutMouseFunc(mouse);
    glutMotionFunc(motion);
    glutIdleFunc(idle);
    glutMainLoop();
}
