package trab1ppd.master;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import br.inf.ufes.ppd.Guess;

/**
 * Contains the information of an ongoing Attack requested
 * by a Client. When the Attack is finished, isDone() returns true.
 * @author 2014100468
 *
 */
public class Attack {
	
	private int number;
	private byte[] ciphertext;
	private byte[] knowntext;
	private List<Guess> foundGuesses;
	private List<SubAttack> subAttacks;
	private boolean done;
	
	
	public Attack(int number, byte[] ciphertext, byte[] knowntext) {
		this.number = number;
		this.ciphertext = ciphertext;
		this.knowntext = knowntext;
		this.setDone(false);
		this.foundGuesses = new LinkedList<Guess>();
		this.subAttacks = new ArrayList<SubAttack>();
	}
	
	/**
	 * Adds a SubAttack to the subAttacks list.
	 * @param subAttack Instance of a SubAttack.
	 */
	public void addSubAttack(SubAttack subAttack) {
		synchronized (subAttacks) {
			this.subAttacks.add(subAttack);
		}
	}
	
	/** 
	 * Checks all subAttacks of this Attack. If they are
	 * all done, then set this Attack to done as well.
	 */
	public void checkSubAttacks() {
		if(done) return;
		
		synchronized (subAttacks) {
			for(SubAttack subAttack : subAttacks) {
				if(subAttack.isDone() == false) {
					return;
				}
			}

			this.done = true;
		}
	}

	//
	// GETTERS & SETTERS
	//
	

	public List<Guess> getFoundGuesses() {
		return foundGuesses;
	}

	public void setFoundGuesses(List<Guess> foundGuesses) {
		this.foundGuesses = foundGuesses;
	}

	public void addGuess(Guess guess)
	{
		synchronized(foundGuesses)
		{
			foundGuesses.add(guess);
		}
	}
	
	public byte[] getCiphertext() {
		return ciphertext;
	}
	public void setCiphertext(byte[] ciphertext) {
		this.ciphertext = ciphertext;
	}
	public byte[] getKnowntext() {
		return knowntext;
	}
	public void setKnowntext(byte[] knowntext) {
		this.knowntext = knowntext;
	}
	public List<SubAttack> getSubAttacks() {
		return subAttacks;
	}
	public void setSubAttacks(List<SubAttack> subAttacks) {
		this.subAttacks = subAttacks;
	}
	public boolean isDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	}
	public int getNumber() {
		return number;
	}
	
}
