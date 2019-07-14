package trab2ppd.master;

/**
 * Attacker.java
 */


import java.rmi.Remote;
import java.rmi.RemoteException;

import trab2ppd.utils.Guess;

public interface Attacker extends Remote {

	/**
	 * Operação oferecida pelo mestre para iniciar um ataque.
	 * @param ciphertext mensagem critografada
	 * @param knowntext trecho conhecido da mensagem decriptografada
	 * @return vetor de chutes: chaves candidatas e mensagem
	 * decriptografada com chaves candidatas
	 */
	public Guess[] attack(byte[] ciphertext,
			byte[] knowntext) throws RemoteException ;
}
