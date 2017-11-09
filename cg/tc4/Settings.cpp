/**
 * Settings class implementation
 */

#include "Settings.h"

// Constructor
Settings::Settings()
{
    this->playerCircle = NULL;
    this->outerLimit = NULL;
    this->innerLimit = NULL;
}

GLfloat Settings::xScreenToWorld(GLfloat x)
{
    GLfloat xScreenMax, xWorldMax, xWorldMin;
    GLfloat arenaRadius = outerLimit->getRadius();

    xScreenMax = WINDOW_WIDTH;
    // xScreenMin = 0;
    xWorldMax  = outerLimit->transform.position.x + arenaRadius;
    xWorldMin  = outerLimit->transform.position.x - arenaRadius;

    return (x/xScreenMax) * (xWorldMax - xWorldMin) + xWorldMin;
}

GLfloat Settings::yScreenToWorld(GLfloat y)
{
    GLfloat yScreenMax, yWorldMax, yWorldMin;
    GLfloat arenaRadius = outerLimit->getRadius();

    yScreenMax = WINDOW_HEIGHT;
    // yScreenMin = 0;
    yWorldMax  = outerLimit->transform.position.y + arenaRadius;
    yWorldMin  = outerLimit->transform.position.y - arenaRadius;

    // cout << "yWorldMax: " << yWorldMax << " | yWorldMin: " << yWorldMin << "\n";

    return (y/yScreenMax) * (yWorldMax - yWorldMin) + yWorldMin;
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

    // Getting OBSTACLE info from config file
    XMLElement* obstacleElement = configDoc.FirstChildElement("aplicacao")->FirstChildElement("obstaculo");
    GLfloat obstacleHeightPercent = obstacleElement->FloatAttribute("altura");
    obstacleHeightPercent /= 100.0;

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

    for (XMLElement* circleElement = svg->FirstChildElement("circle"); circleElement != NULL; circleElement = circleElement->NextSiblingElement("circle")) {
        int x = circleElement->IntAttribute("cx");
        int y = circleElement->IntAttribute("cy");
        float r = circleElement->IntAttribute("r");
        const char* fill = circleElement->Attribute("fill");
        int id = circleElement->IntAttribute("id");

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
            playerCircle = new Circle(id, r, transform, Color(0,1,0));
        }
        else if(strcmp(fill, "red") == 0) {
            Transform transform = Transform(Vector3(x,y,0), Vector3(0,0,0), Vector3(1,1,1));
            Circle* circle = new Circle(id, r, transform, Color(1,0,0));
            obstacles.push_back(new Obstacle(circle, obstacleHeightPercent, false));
        }
        else if(strcmp(fill, "black") == 0) {
            Transform transform = Transform(Vector3(x,y,0), Vector3(0,0,0), Vector3(1,1,1));
            Circle* circle = new Circle(id, r, transform, Color(0,0,0));
            obstacles.push_back(new Obstacle(circle, obstacleHeightPercent, true));
        }
    }

    // Getting PLAYER info from config file
    XMLElement* playerElement = configDoc.FirstChildElement("aplicacao")->FirstChildElement("jogador");
    playerMoveSpeed = playerElement->FloatAttribute("vel");
    playerBulletSpeed = playerElement->FloatAttribute("velTiro");

    return true;
}

// Destructor
Settings::~Settings() {}
