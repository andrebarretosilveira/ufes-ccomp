/**
 * Settings class implementation
 */

#include "Settings.h"

// Constructor
Settings::Settings()
{
    this->arena = NULL;
    this->player = NULL;
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

    // Getting ARENA file info from config file
    XMLElement* arqArena = configDoc.FirstChildElement("aplicacao")->FirstChildElement("arquivoDaArena");
    char* arenaName = strdup(arqArena->Attribute("nome"));
    const char* arena_path = arqArena->Attribute("caminho");
    const char* arena_filename = "arena.svg";

    char* arena_filepath = strcat(strdup(arena_path), arena_filename);

    // Read the ARENA svg config file
    if(arenaSvg.LoadFile(arena_filepath)) {
        cout << "\nArquivo '" << arena_filepath << "' não encontrado.\n";
        return false;
    }
    XMLElement* svg = arenaSvg.FirstChildElement("svg");

    // Getting OBSTACLE info from config file
    XMLElement* obstacleElement = configDoc.FirstChildElement("aplicacao")->FirstChildElement("obstaculo");
    GLfloat obstacleHeightPercent = obstacleElement->FloatAttribute("altura");
    obstacleHeightPercent /= 100.0;
    list<Obstacle*> obstacles;

    // Getting ENEMY info from config file
    XMLElement* enemyElement = configDoc.FirstChildElement("aplicacao")->FirstChildElement("inimigo");
    GLfloat enemyMoveSpeed = enemyElement->FloatAttribute("vel");
    GLfloat enemyBulletSpeed = enemyElement->FloatAttribute("velTiro");
    GLfloat enemyFireFreq = enemyElement->FloatAttribute("freqTiro");
    list<Player*> enemies;

    // Getting PLAYER info from config file
    XMLElement* playerElement = configDoc.FirstChildElement("aplicacao")->FirstChildElement("jogador");
    GLfloat playerMoveSpeed = playerElement->FloatAttribute("vel");
    GLfloat playerBulletSpeed = playerElement->FloatAttribute("velTiro");
    Circle* playerCircle = NULL;
    
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
            this->outerLimit = new Circle(id, r, transform, Color(0,0,1));
        }
        else if(strcmp(fill, "white") == 0) {
            Transform transform = Transform(Vector3(x,y,0), Vector3(0,0,0), Vector3(1,1,1));
            this->innerLimit = new Circle(id, r, transform, Color(1,1,1));
        }
        else if(strcmp(fill, "green") == 0) {
            Transform transform = Transform(Vector3(x,y,0), Vector3(0,0,0), Vector3(1,1,1));
            playerCircle = new Circle(id, r, transform, Color(0,1,0));
            this->player = new Player(playerCircle, playerCircle->transform, playerMoveSpeed, playerBulletSpeed, enemyFireFreq);
        }
        else if(strcmp(fill, "red") == 0) {
            Transform transform = Transform(Vector3(x,y,0), Vector3(0,0,0), Vector3(1,1,1));
            Circle* circle = new Circle(id, r, transform, Color(1,0,0));
            enemies.push_back(new Player(circle, circle->transform, enemyMoveSpeed, enemyBulletSpeed, enemyFireFreq));
        }
        else if(strcmp(fill, "black") == 0) {
            Transform transform = Transform(Vector3(x,y,0), Vector3(0,0,0), Vector3(1,1,1));
            Circle* circle = new Circle(id, r, transform, Color(0,0,0));
            obstacles.push_back(new Obstacle(circle, obstacleHeightPercent, true));
        }
    }

    this->arena = new Arena(arenaName, this->outerLimit, this->innerLimit, player, obstacles, enemies);


    return true;
}

// Destructor
Settings::~Settings() {}
