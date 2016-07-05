// package so_trab2;

import java.util.Vector;

// Buffer onde são armazenados as
// mensagens lidas do pipe
public class Buffer {
	private static int bufferSize = 500;
	private int posPar, posImpar = 0;
    private boolean isParFull, isImparFull = false;
	private Vector<String> par = new Vector<String>(bufferSize);
	private Vector<String> impar = new Vector<String>(bufferSize);

    // Método para adicionar mensagens no buffer PAR
	synchronized void addMsg2Par(String msg) {
		par.add(this.posPar, msg);
		this.posPar++;
        if(posPar == bufferSize)
            this.isParFull = true;
	}

    // Método para adicionar mensagens no buffer IMPAR
	synchronized void addMsg2Impar(String msg) {
		impar.add(this.posImpar, msg);
		this.posImpar++;
        if(posImpar == bufferSize)
            this.isImparFull = true;
	}

    // Verifica se o buffer está 10% cheio
    // (usado no ThreadProgress)
    boolean is10Full() {
        return (this.posPar >= bufferSize/10) && (this.posImpar >= bufferSize/10);
    }

    // Verifica se o buffer está 25% cheio
    // (usado no ThreadProgress)
    boolean is25Full() {
        return (this.posPar >= bufferSize/4) && (this.posImpar >= bufferSize/4);
    }

    // Verifica se o buffer está 50% cheio
    // (usado no ThreadProgress)
    boolean isHalfFull() {
        return (this.posPar >= bufferSize/2) && (this.posImpar >= bufferSize/2);
    }

    // Verifica se o buffer está 75% cheio
    // (usado no ThreadProgress)
    boolean is75Full() {
        return (this.posPar >= 3*bufferSize/4) && (this.posImpar >= 3*bufferSize/4);
    }

    // Verifica se o buffer está 90% cheio
    // (usado no ThreadProgress)
    boolean is90Full() {
        return (this.posPar >= 9*bufferSize/10) && (this.posImpar >= 9*bufferSize/10);
    }

    // Verifica se o buffer está 100% cheio
    // (usado no ThreadProgress e no ThreadReader)
    boolean isFull() {
        return (this.isParFull && this.isImparFull);
    }

    Vector<String> getPar() {
        return this.par;
    }

    Vector<String> getImpar() {
        return this.impar;
    }
}
