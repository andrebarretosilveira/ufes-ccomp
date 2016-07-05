// package so_trab2;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

public class Main {
	static int qtdThreads = 5;

	public static void main(String[] args){
		Buffer buffer = new Buffer();
		ThreadReader[] readers = new ThreadReader[qtdThreads];
        ThreadProgress progress = new ThreadProgress(buffer);

		try {
            // Arquivo do pipe
            Pipe pipe = new Pipe(new RandomAccessFile("./pipe", "r"));

            // Criando e iniciando as Threads leitoras
            System.out.println("\n Lendo mensagens do pipe:");
            System.out.print(" [0%]   ");
            for(int i = 0; i < readers.length; i++) {
            	readers[i] = new ThreadReader(buffer, pipe);
            	readers[i].start();
            }

            // Iniciando Thread de progresso
            progress.start();

            // Esperando as Threads leitoras encerrarem
            for(int i = 0; i < readers.length; i++) {
            	readers[i].join();
            }
            progress.join();

            System.out.println("\n Leitura finalizada.\n");

		} catch (FileNotFoundException e) {
			System.out.println("Pipe não encotrado.");
			e.printStackTrace();
		} catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

		System.out.println("Buffer par:");
        System.out.println(buffer.getPar().toString());
        System.out.print("\n");
		System.out.println("Buffer ímpar:");
        System.out.println(buffer.getImpar().toString());
        System.out.print("\n");
	}
}
