
#include "input.h"
#include "circle_draw.h"

int main(int argc, char** argv) {
    Config* config;
    const char* filename = "config.xml";

    if(argc < 2) {
        printf("Modo de uso: ./trabalhocg <diretorio_do_arquivo_config>\n");
        return 1;
    }

    char* filepath = strcat(argv[1], filename);

    config = read_config_file(filepath);

    if(config == NULL) {
        printf("Erro na leitura do arquivo.\n");
        printf("Certifique que o arquivo 'config.xml' esta no diretorio indicado.\n");
        printf("Abortando.\n\n");
        return 1;
    }

    //print_config(config);

    draw_output(argc, argv, config);

    return 0;
}
