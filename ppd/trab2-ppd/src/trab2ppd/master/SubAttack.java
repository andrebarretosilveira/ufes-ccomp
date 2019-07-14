package trab2ppd.master;

import java.io.Serializable;

/**
 * Contains information of an ongoing subAttack, including the Slave attacker,
 * the Attack that it belongs to and the last checkpoint received time. When the
 * subAttack is finished, the isDone() method returns true.
 *
 */
public class SubAttack implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int number;
	private int initialWordIndex;
	private int finalWordIndex;
	private byte[] ciphertext;
	private byte[] knowntext;
	private boolean done;
	private transient Attack attack;

	public SubAttack(int subAttackNumber, int initialWordIndex, int finalWordIndex,
			byte[] ciphertext, byte[] knowntext, Attack attack) {
		this.number = subAttackNumber;
		this.initialWordIndex = initialWordIndex;
		this.finalWordIndex = finalWordIndex;
		this.ciphertext = ciphertext;
		this.knowntext = knowntext;
		this.done = false;
		this.attack = attack;
	}

	
	
	//
	// GETTERS & SETTERS
	//

	public int getInitialWordIndex() {
		return initialWordIndex;
	}

	public void setInitialWordIndex(int initialWordIndex) {
		this.initialWordIndex = initialWordIndex;
	}

	public int getFinalWordIndex() {
		return finalWordIndex;
	}

	public void setFinalWordIndex(int finalWordIndex) {
		this.finalWordIndex = finalWordIndex;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public Attack getAttack() {
		return attack;
	}

	public void setAttack(Attack attack) {
		this.attack = attack;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int attackNumber) {
		this.number = attackNumber;
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

}
