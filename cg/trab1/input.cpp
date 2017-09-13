
#include <stdlib.h>
#include "input.h"
#include "tinyxml2.h"

using namespace tinyxml2;

Config* read_config_file(char* path) {
    XMLDocument doc;
    Config* config;

    // Read the xml config file
    doc.LoadFile(path);

    // Getting WINDOW configuration info from xml file
    XMLNode* window = doc.FirstChildElement("aplicacao")->FirstChildElement("janela");
    const char* window_width = window->FirstChildElement("largura")->GetText();
    const char* window_height = window->FirstChildElement("altura")->GetText();
    const char* window_title = window->FirstChildElement("titulo")->GetText();
    int window_color_R = window->FirstChildElement("fundo")->IntAttribute("corR");
    int window_color_G = window->FirstChildElement("fundo")->IntAttribute("corG");
    int window_color_B = window->FirstChildElement("fundo")->IntAttribute("corB");

    // Getting CIRCLE configuration info from xml file
    int circle_radius = doc.FirstChildElement("aplicacao")->FirstChildElement("circulo")->IntAttribute("raio");
    int circle_color_R = doc.FirstChildElement("aplicacao")->FirstChildElement("circulo")->IntAttribute("corR");
    int circle_color_G = doc.FirstChildElement("aplicacao")->FirstChildElement("circulo")->IntAttribute("corG");
    int circle_color_B = doc.FirstChildElement("aplicacao")->FirstChildElement("circulo")->IntAttribute("corB");

    // Initializing new configuration structure
    config = init_config();

    // Storing configuration info in the config structure
    // Window
    config->window->title = window_title;
    config->window->width = strtol(window_width, NULL, 10);
    config->window->height = strtol(window_height, NULL, 10);
    config->window->color_R = window_color_R;
    config->window->color_G = window_color_G;
    config->window->color_B = window_color_B;
    // Circle
    config->circle->radius = circle_radius;
    config->circle->color_R = circle_color_R;
    config->circle->color_G = circle_color_G;
    config->circle->color_B = circle_color_B;

    return config;
}

Config* init_config() {
    Config* config;

    config = (Config*) malloc(sizeof * config);
    config->window = (WindowConfig*) malloc(sizeof * config->window);
    config->circle = (CircleConfig*) malloc(sizeof * config->circle);

    return config;
}

void print_config(Config* config) {
    printf("\nWindow configuration:\n");
    printf("  Title: %s\n", config->window->title );
    printf("  Width: %d\n", config->window->width );
    printf("  Height: %d\n", config->window->height );
    printf("  Color_R: %d\n", config->window->color_R );
    printf("  Color_G: %d\n", config->window->color_G );
	printf("  Color_B: %d\n", config->window->color_B );

    printf("\nCircle configuration:\n");
    printf("  Radius: %d\n", config->circle->radius );
    printf("  Color_R: %d\n", config->circle->color_R );
    printf("  Color_G: %d\n", config->circle->color_G );
	printf("  Color_B: %d\n", config->circle->color_B );
}
