package trab2ppd.utils;

/**
 * Guess.java
 */

import java.io.Serializable;

public class Guess implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Candidate key.
	 */
	private String key;

	/**
	 * Decrypted message when applied the candidate key.
	 */
	private byte[] message;
	
	/**
	 * SubAttack number identifier.
	 */
	private int subAttackNumber;
	
	/**
	 * Related slave's name.
	 */
	private String slaveName;
	
	
	public Guess(String key, byte[] message, int subAttackNumber, String slaveName) {
		this.key = key;
		this.message = message;
		this.subAttackNumber = subAttackNumber;
		this.slaveName = slaveName;
	}
	
	public Guess(int subAttackNumber, String slaveName) {
		this.key = null;
		this.message = null;
		this.subAttackNumber = subAttackNumber;
		this.slaveName = slaveName;
	}

	
	
	//
	// GETTERS & SETTERS
	//
	

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public byte[] getMessage() {
		return message;
	}

	public void setMessage(byte[] message) {
		this.message = message;
	}

	public int getSubAttackNumber() {
		return subAttackNumber;
	}

	public void setSubAttackNumber(int subAttackNumber) {
		this.subAttackNumber = subAttackNumber;
	}

	public String getSlaveName() {
		return slaveName;
	}

	public void setSlaveName(String slaveName) {
		this.slaveName = slaveName;
	}

}
