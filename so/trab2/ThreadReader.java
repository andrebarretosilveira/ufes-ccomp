// package so_trab2;

import java.io.IOException;

// Thread que fará a leitura do pipe até
// que o buffer esteja cheio
public class ThreadReader extends Thread {
	private Buffer buffer;
	private Pipe pipe;

	ThreadReader(Buffer buffer, Pipe pipe) {
		this.buffer = buffer;
		this.pipe = pipe;
	}

	@Override
	public void run() {
		try {
			while(!buffer.isFull())
			{
                String msg = pipe.read();
                
                if(msg != null)
                {
                    String[] msgSplitted = msg.split("-");
                    String numb = msgSplitted[msgSplitted.length - 1];
                    int numMsg = Integer.parseInt(numb.trim());

                    // Adicionar mensagem em...
                    if((numMsg & 1) == 0) {
                        // Buffer Par
                        buffer.addMsg2Par(msg);
                    }
                    else {
                        // Buffer Ímpar
                        buffer.addMsg2Impar(msg);
                    }
                }
			}
		} catch (IOException e) {
			System.out.println("Não foi possível ler o pipe.");
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.out.println("Erro de conversão de string para inteiro");
			e.printStackTrace();
		}
	}
}
