
#ifndef INPUT_H
#define INPUT_H

#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include "tinyxml2.h"

typedef struct config {
    char* window_title;
    int window_width, window_height;
    int window_R, window_G, window_B;

    int circle_radius;
    int circle_x, circle_y;
    int circle_R, circle_G, circle_B;
} Config;

Config* read_config_file(char* filepath);

Config* init_config();

void print_config(Config* config);

#endif
