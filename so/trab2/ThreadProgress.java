// package so_trab2;

import java.lang.InterruptedException;

// Thread que acompanha o progresso da leitura
// e escrita nos buffers, reportando o quanto
// o buffer já foi preenchido
public class ThreadProgress extends Thread {
	private Buffer buffer;

	ThreadProgress(Buffer buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {
        try {
            while(!buffer.is10Full()) {
                System.out.print(".");
                Thread.sleep(2000);
            }
            System.out.print("\n [10%]  ");

            while(!buffer.is25Full()) {
                System.out.print(".");
                Thread.sleep(2000);
            }
            System.out.print("\n [25%]  ");

            while(!buffer.isHalfFull()) {
                System.out.print(".");
                Thread.sleep(2000);
            }
            System.out.print("\n [50%]  ");

            while(!buffer.is75Full()) {
                System.out.print(".");
                Thread.sleep(2000);
            }
            System.out.print("\n [75%]  ");

            while(!buffer.is90Full()) {
                System.out.print(".");
                Thread.sleep(2000);
            }
            System.out.print("\n [90%]  ");

            while(!buffer.isFull()) {
                System.out.print(".");
                Thread.sleep(2000);
            }
            System.out.print("\n [100%]");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
	}
}
