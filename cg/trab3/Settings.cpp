/**
 * Settings class implementation
 */

#include "Settings.h"

// Constructor
Settings::Settings()
{
    this->player_circle = NULL;
    this->outerLimit = NULL;
    this->innerLimit = NULL;
}

// Draw Settings
bool Settings::read_xml(char* config_filepath)
{
    XMLDocument configDoc, arenaSvg;

    // Read the CONFIG xml file
    if(configDoc.LoadFile(config_filepath)) {
        cout << "\nArquivo '" << config_filepath << "' não encontrado.\n";
        return false;
    }

    // Getting ARENA file info from config file
    XMLElement* arqArena = configDoc.FirstChildElement("aplicacao")->FirstChildElement("arquivoDaArena");
    arenaName = strdup(arqArena->Attribute("nome"));
    //const char* arena_type = arqArena->Attribute("tipo");
    const char* arena_path = arqArena->Attribute("caminho");
    const char* arena_filename = "arena.svg";

    char* arena_filepath = strcat(strdup(arena_path), arena_filename);

    // Read the ARENA svg config file
    if(arenaSvg.LoadFile(arena_filepath)) {
        cout << "\nArquivo '" << arena_filepath << "' não encontrado.\n";
        return false;
    }
    XMLElement* svg = arenaSvg.FirstChildElement("svg");

    for (XMLElement* circleNode = svg->FirstChildElement("circle"); circleNode != NULL; circleNode = circleNode->NextSiblingElement("circle")) {
        int x = circleNode->IntAttribute("cx");
        int y = circleNode->IntAttribute("cy");
        float r = circleNode->IntAttribute("r");
        const char* fill = circleNode->Attribute("fill");
        int id = circleNode->IntAttribute("id");

        // Convert y to screen coordinates
        y = WINDOW_HEIGHT - y;

        if(strcmp(fill, "blue") == 0) {
            Transform transform = Transform(Vector3(x,y,0), Vector3(0,0,0), Vector3(1,1,1));
            outerLimit = new Circle(id, r, transform, Color(0,0,1));
        }
        else if(strcmp(fill, "white") == 0) {
            Transform transform = Transform(Vector3(x,y,0), Vector3(0,0,0), Vector3(1,1,1));
            innerLimit = new Circle(id, r, transform, Color(1,1,1));
        }
        else if(strcmp(fill, "green") == 0) {
            Transform transform = Transform(Vector3(x,y,0), Vector3(0,0,0), Vector3(1,1,1));
            player_circle = new Circle(id, r, transform, Color(0,1,0));
        }
        else if(strcmp(fill, "red") == 0) {
            Transform transform = Transform(Vector3(x,y,0), Vector3(0,0,0), Vector3(1,1,1));
            Circle* circle = new Circle(id, r, transform, Color(1,0,0));
            obstacles.push_back(new Obstacle(circle, false));
        }
        else if(strcmp(fill, "black") == 0) {
            Transform transform = Transform(Vector3(x,y,0), Vector3(0,0,0), Vector3(1,1,1));
            Circle* circle = new Circle(id, r, transform, Color(0,0,0));
            obstacles.push_back(new Obstacle(circle, true));
        }
    }

    return true;
}

// Destructor
Settings::~Settings() {}
