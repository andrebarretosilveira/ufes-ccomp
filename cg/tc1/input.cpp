
#include "input.h"

using namespace tinyxml2;

Config* read_config_file(char* filepath) {
    XMLDocument doc;
    Config* config;

    // Read the xml config file
    if(doc.LoadFile(filepath)) return NULL;

    // Initializing new configuration structure
    config = init_config();

    // Initializing new configuration structure
    config = init_config();

    // Getting WINDOW configuration info from xml file
    XMLNode* window = doc.FirstChildElement("aplicacao")->FirstChildElement("janela");
    const char* width = window->FirstChildElement("largura")->GetText();
    const char* height = window->FirstChildElement("altura")->GetText();
    const char* title = window->FirstChildElement("titulo")->GetText();
    int color_R = window->FirstChildElement("fundo")->IntAttribute("corR");
    int color_G = window->FirstChildElement("fundo")->IntAttribute("corG");
    int color_B = window->FirstChildElement("fundo")->IntAttribute("corB");

    // Storing WINDOW configuration info in the config structure
    config->window_title = strdup(title);
    config->window_width = strtol(width, NULL, 10);
    config->window_height = strtol(height, NULL, 10);
    config->window_R = color_R;
    config->window_G = color_G;
    config->window_B = color_B;

    // Getting CIRCLE configuration info from xml file
    int radius = doc.FirstChildElement("aplicacao")->FirstChildElement("circulo")->IntAttribute("raio");
    color_R = doc.FirstChildElement("aplicacao")->FirstChildElement("circulo")->IntAttribute("corR");
    color_G = doc.FirstChildElement("aplicacao")->FirstChildElement("circulo")->IntAttribute("corG");
    color_B = doc.FirstChildElement("aplicacao")->FirstChildElement("circulo")->IntAttribute("corB");
    
    // Storing CIRCLE configuration info in the config structure
    config->circle_radius = radius;
    config->circle_R = color_R;
    config->circle_G = color_G;
    config->circle_B = color_B;

    return config;
}

Config* init_config() {
    Config* config;

    config = (Config*) malloc(sizeof * config);

    return config;
}

void print_config(Config* config) {
    printf("\nWindow configuration:\n");
    printf(" Title: %s\n", config->window_title );
    printf(" Width: %d\n", config->window_width );
    printf(" Height: %d\n", config->window_height );
    printf(" Color_R: %d\n", config->window_R );
    printf(" Color_G: %d\n", config->window_G );
	printf(" Color_B: %d\n", config->window_B );

    printf("\nCircle configuration:\n");
    printf(" Radius: %d\n", config->circle_radius );
    printf(" Color_R: %d\n", config->circle_R );
    printf(" Color_G: %d\n", config->circle_G );
	printf(" Color_B: %d\n", config->circle_B );

    printf("\n");
}
