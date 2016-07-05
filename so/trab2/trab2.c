#include <fcntl.h>
#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/stat.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>
#include <signal.h>
#include <errno.h>

#define NUM_THREADS 5
#define NUM_MESSAGES 1000
#define MESSAGE_LEN 10

void *write_msg(void* num_thread);

// Criando o mutex para sincronização das threads
pthread_mutex_t mutex = PTHREAD_MUTEX_INITIALIZER;

int k = 0;
int fd;

int main() {
    // Criando a pipe nomeada onde as threads vão escrever
    printf("Criando pipe para escrita...\n");
    mkfifo("pipe", 0644);
    
	// Abrindo a pipe nomeada
    fd = open("pipe", O_WRONLY);
    printf("Descritor do pipe: %d\n\n", fd);

    // Declarando vetor das threads
    printf("Escrevendo mensagens no pipe...\n");
    pthread_t *writer;
    writer = (pthread_t*) calloc(NUM_THREADS, sizeof(pthread_t));
    
    int num_thread[5];
    int i;
    
    // Criando e inicializando as threads escritoras
    for(i = 0; i < NUM_THREADS; i++) {
        num_thread[i] = i+1;
        pthread_create(&writer[i], NULL, write_msg, &num_thread[i]);
    }

    // Esperando o fim da execução das threads
    for(i = 0; i < NUM_THREADS; i++)
        pthread_join(writer[i],NULL);
    
    printf("Escrita finalizada.\n\n");
    free(writer);
    return 0;
}

void *write_msg(void* num_thread)
{
    char msg[MESSAGE_LEN];
    int num = *((int*) num_thread);
    
    while(k < NUM_MESSAGES)
    {
        pthread_mutex_lock(&mutex);        
        sprintf(msg, "%d-MSG-%.3d", num, k);
        write(fd, msg, MESSAGE_LEN);
        k++;
        pthread_mutex_unlock(&mutex);
        sleep(1);
    }

    return NULL;
}

