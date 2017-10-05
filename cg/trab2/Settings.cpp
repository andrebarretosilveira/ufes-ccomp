/**
 * Settings class implementation
 */

#include "Settings.h"

// Constructor
Settings::Settings()
{
    this->outerLimit = NULL;
    this->innerLimit = NULL;
    this->obstacles = NULL;
}

// Draw Settings
bool Settings::read_xml(char* config_filepath)
{
    XMLDocument configDoc, arenaSvg;

    // Read the CONFIG xml file
    if(configDoc.LoadFile(config_filepath)) return false;

    // Getting ARENA file info from config file
    XMLNode* arqArena = configDoc.FirstChildElement("aplicacao")->FirstChildElement("arquivoDaArena");
    const char* arena_name = arqArena->Attribute("nome");
    const char* arena_type = arqArena->Attribute("tipo");
    const char* arena_path = arqArena->Attribute("caminho");

    const char* arena_filename = "arena.svg";
    char* arena_filepath = strcat(arena_path, arena_filename);

    // Read the ARENA svg config file
    if(arenaSvg.LoadFile(arena_filepath)) return false;

    XMLNode* svg = arenaSvg.FirstChildElement("svg");

    for (XMLNode* circleNode = svg->FirstChildElement("circle"); circleNode != NULL; circleNode = circleNode->NextSiblingElement("cicle")) {
        /* code */
    }


    // Storing WINDOW configuration info in the config structure
    // config->window_title = strdup(title);
    // config->window_width = strtol(width, NULL, 10);
    // config->window_height = strtol(height, NULL, 10);
    // config->window_R = color_R;
    // config->window_G = color_G;
    // config->window_B = color_B;
    //
    // // Getting CIRCLE configuration info from xml file
    // int radius = configDoc.FirstChildElement("aplicacao")->FirstChildElement("circulo")->IntAttribute("raio");
    // color_R = configDoc.FirstChildElement("aplicacao")->FirstChildElement("circulo")->IntAttribute("corR");
    // color_G = configDoc.FirstChildElement("aplicacao")->FirstChildElement("circulo")->IntAttribute("corG");
    // color_B = configDoc.FirstChildElement("aplicacao")->FirstChildElement("circulo")->IntAttribute("corB");

    return true;
}

// Destructor
Settings::~Settings() {}
