package trab1ppd.master;

import java.util.UUID;

/**
 * Contains information of an ongoing subAttack, including
 * the Slave attacker, the Attack that it belongs to and
 * the last checkpoint received time. When the subAttack is
 * finished, the isDone() method returns true.
 *
 */
public class SubAttack {
	private int number;
	private UUID attackerKey;
	private long startTime;
	private long lastCheckpointTime;
	private long initialWordIndex;
	private long finalWordIndex;
	private long currentWordIndex;
	private boolean done;
	private Attack attack;
	
	
	public SubAttack(int attackNumber, UUID attackerKey, long initialWordIndex, long finalWordIndex, Attack attack) {
		this.setNumber(attackNumber);
		this.attackerKey = attackerKey;
		this.startTime = System.nanoTime();
		this.lastCheckpointTime = System.nanoTime();
		this.initialWordIndex = initialWordIndex;
		this.finalWordIndex = finalWordIndex;
		this.currentWordIndex = initialWordIndex;
		this.done = false;
		this.attack = attack;
	}
	
	
	
	//
	// GETTERS & SETTERS
	//
	
	/**
	 * Sets the current word index the Slave has reached in the
	 * requested file. If the index is equal to the last index,
	 * sets done to true and calls the Attack's checkSubAttacks
	 * method to check if all subAttacks are done.
	 * @param currentWordIndex
	 */
	public void setCurrentWordIndex(long currentWordIndex) {
		this.currentWordIndex = currentWordIndex;
		
		if(currentWordIndex == finalWordIndex) {
			this.done = true;
			
			attack.checkSubAttacks();
		}
	}
	public UUID getAttackerKey() {
		return attackerKey;
	}
	public void setAttackerKey(UUID attacker) {
		this.attackerKey = attacker;
	}
	public long getStartTime() {
		return startTime;
	}
	public void setStartTime(long attackStartTime) {
		this.startTime = attackStartTime;
	}
	public long getLastCheckpointTime() {
		return lastCheckpointTime;
	}
	public void setLastCheckpointTime(long lastCheckpointTime) {
		this.lastCheckpointTime = lastCheckpointTime;
	}
	public long getInitialWordIndex() {
		return initialWordIndex;
	}
	public void setInitialWordIndex(long initialWordIndex) {
		this.initialWordIndex = initialWordIndex;
	}
	public long getFinalWordIndex() {
		return finalWordIndex;
	}
	public void setFinalWordIndex(long finalWordIndex) {
		this.finalWordIndex = finalWordIndex;
	}
	public long getCurrentWordIndex() {
		return currentWordIndex;
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

}
