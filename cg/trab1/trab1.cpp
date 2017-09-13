#include <stdio.h>
#include "input.h"

int main(int argc, char** argv) {
    Config* config;

    config = read_config_file("config.xml");

    print_config(config);

    return 0;
}
