
#include "input.h"
#include "circle_draw.h"

int main(int argc, char** argv) {
    Config* config;

    if(argc < 2) {
        printf("Insira caminho do arquivo ao chamar o programa. Abortando.\n");
        return 1;
    }

    printf("%s\n", argv[1]);

    config = read_config_file(argv[1]);

    print_config(config);

    draw_output(argc, argv, config);

    return 0;
}
