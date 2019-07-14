package trab1ppd.master;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import br.inf.ufes.ppd.Slave;

/**
 * Contains information about a specific Slave, including it's
 * remote reference, uuid, name, last registry time and a list
 * of it's ongoing subAttacks.
 * @author 2014100468
 *
 */
public class SlaveInfo {
	
	private UUID slaveKey;
	private Slave slaveRef;
	private String slaveName;
	private long lastRegistryTime;
	private List<Integer> currentSubAttackJobs;
	
	
	
	public SlaveInfo(Slave slaveRef, UUID slaveKey, String slaveName) {
		this.slaveKey = slaveKey;
		this.slaveRef = slaveRef;
		this.slaveName = slaveName;
		this.lastRegistryTime = System.nanoTime();
		this.setCurrentAttackJobs(new ArrayList<Integer>());
	}
	
	
	/**
	 * Adds a subAttack number to the current subAttacks jobs list
	 * that references a subAttack.
	 * @param subAttackNumber
	 */
	public void addCurrentSubAttackJob(int subAttackNumber) {
		currentSubAttackJobs.add(subAttackNumber);
	}
	
	
	//
	// GETTERS & SETTERS
	//
	
	public Slave getSlaveRef() {
		return slaveRef;
	}
	public void setSlaveRef(Slave slaveRef) {
		this.slaveRef = slaveRef;
	}
	public String getSlaveName() {
		return slaveName;
	}
	public void setSlaveName(String slaveName) {
		this.slaveName = slaveName;
	}
	public long getLastRegistryTime() {
		return lastRegistryTime;
	}
	public void setLastRegistryTime(long lastRegistryTime) {
		this.lastRegistryTime = lastRegistryTime;
	}
	public UUID getSlaveKey() {
		return slaveKey;
	}
	public void setSlaveKey(UUID uuid) {
		this.slaveKey = uuid;
	}
	public List<Integer> getCurrentSubAttackJobs() {
		return currentSubAttackJobs;
	}
	public void setCurrentAttackJobs(List<Integer> currentAttackJobs) {
		this.currentSubAttackJobs = currentAttackJobs;
	}
}
