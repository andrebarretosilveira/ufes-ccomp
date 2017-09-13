
typedef struct windowconfig {
    const char* title;
    int width, height;
    int color_R, color_G, color_B;
} WindowConfig;

typedef struct circleconfig {
    int radius;
    int color_R, color_G, color_B;
} CircleConfig;

typedef struct config {
    WindowConfig* window;
    CircleConfig* circle;
} Config;

Config* read_config_file(char* path);

Config* init_config();

void print_config(Config* config);
