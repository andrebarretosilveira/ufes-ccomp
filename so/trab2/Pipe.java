// package so_trab2;

import java.io.IOException;
import java.io.RandomAccessFile;

// Classe que abstrai a leitura do
// arquivo pipe
public class Pipe {
    private RandomAccessFile pipe;

    Pipe(RandomAccessFile pipe) {
        this.pipe = pipe;
    }

    // Método para leitura de mensagem do pipe
    String read() throws IOException {
        byte[] bytes = new byte[10];
        if(pipe.read(bytes) != -1)
        	return new String(bytes, "UTF-8");
        else
        	return(null);


    }
}
