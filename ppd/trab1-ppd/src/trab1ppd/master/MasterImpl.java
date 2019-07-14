package trab1ppd.master;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import br.inf.ufes.ppd.Guess;
import br.inf.ufes.ppd.Master;
import br.inf.ufes.ppd.Slave;
import br.inf.ufes.ppd.SlaveManager;
import trab1ppd.utils.FileAccess;

import java.io.IOException;

/**
 * The implementation of the Master interface.
 *
 */
public class MasterImpl implements Master {
	
	private Map<UUID, SlaveInfo> slaves;
	private Set<Attack> attacks;
	private Map<Integer, SubAttack> subAttacks;
	private ExecutorService executor = Executors.newFixedThreadPool(10);
	private int nextSubAttackID;
	private int nextAttackID;
	private int dictionaryLinesCount;
	private SlaveManager slaveCallback;
	
	public MasterImpl() throws IOException {
		this.executor = Executors.newFixedThreadPool(10);
		this.slaves = new HashMap<UUID, SlaveInfo>();
		this.attacks = new HashSet<Attack>();
		this.subAttacks = new HashMap<Integer, SubAttack>();
		this.nextSubAttackID = 0;
		this.nextAttackID = 0;
		this.dictionaryLinesCount = FileAccess.readLines("dictionary.txt").length;
		
	}
    

	/**
	 * Registers a remote reference to a slave.
	 * 
	 * @param sis the remote reference to the slave.
	 * @param slaveName is the name chosen by the slave.
	 * @param slaveKey is the universal unique identifier of the slave s. 
	 * @throws RemoteException failed to send the add request.
	 */
	@Override
	public void addSlave(Slave s, String slaveName, UUID slaveKey) throws RemoteException {
		// new slave info to be registered
		SlaveInfo newSlave = new SlaveInfo(s, slaveKey, slaveName);
		
		synchronized(slaves) {
			SlaveInfo oldSlave = slaves.putIfAbsent(slaveKey, newSlave);

			if(oldSlave != null) {
				// a slave with the given UUID was already registered.
				// update it's registry time
				oldSlave.setLastRegistryTime(System.nanoTime());
			}
			else {
				// new slave registered
				System.err.println("[M] Slave [" + slaveName + "] registered.");

				synchronized(this)
				{
					this.notifyAll();
				}
			}
		}
		
	}

	/**
	 * Starts a procedure to remove a slave from the slaves set by its UUID
	 * 
	 * @param slaveKey is the universal unique identifier of the slave to be removed. 
	 * @throws RemoteException failed to send the add request.
	 */
	@Override
	public void removeSlave(UUID slaveKey) throws RemoteException {
		removeSlaveProcedure(slaveKey);
		
	}


	/**
	 * Method called by slaves to announce a found guess event. 
	 * 
	 * @param slaveKey is the universal unique identifier of the slave whom triggered the event.
	 * @param attackNumber refers to the number of the subattack which triggered the event.
	 * @param currentindex is the dictionary index where the guess was found.
	 * @param currentguess is the guess found. 
	 * @throws RemoteException failed to send the add request.
	 */
	@Override
	public void foundGuess(UUID slaveKey, int attackNumber, long currentindex, Guess currentguess)
			throws RemoteException {
		
		synchronized(attacks) {
			SubAttack subAttack = subAttacks.get(attackNumber);
			
			if(!slaveKey.equals(subAttack.getAttackerKey())) return;
			
			Attack attack = subAttacks.get(attackNumber).getAttack();
			
			System.err.println("[M] Guess found on Attack ["+ attack.getNumber() +"]: "
					+ "\"" + currentguess.getKey() + "\"");
			
			attack.addGuess(currentguess);
		}
		
		checkpoint(slaveKey, attackNumber, currentindex);
	}
	
	/**
	 * Periodic method called by slaves to to update master's references about the subattack. 
	 * 
	 * @param slaveKey is the universal unique identifier of the slave whom triggered the event.
	 * @param attackNumber refers to the number of the subattack which triggered the event.
	 * @param currentindex is the dictionary index where the guess was found.
	 * @throws RemoteException failed to send the add request.
	 */
	@Override
	public void checkpoint(UUID slaveKey, int attackNumber, long currentindex) throws RemoteException {
		synchronized(subAttacks) {
			
			SubAttack subAttack = subAttacks.get(attackNumber);
			if(subAttack == null) return;
			
			if(!slaveKey.equals(subAttack.getAttackerKey())) return;
			
			subAttack.setCurrentWordIndex(currentindex);
			subAttack.setLastCheckpointTime(System.nanoTime());
			
	        long attackerElapsedTime = System.nanoTime() - subAttack.getStartTime();
	        double seconds = (double)attackerElapsedTime / 1000000000.0;
	        
	        String slaveName;
	        synchronized (slaves) {
	        	slaveName = slaves.get(slaveKey).getSlaveName();
			}
	        
	        String finalCheck = "";
	        if(currentindex == subAttack.getFinalWordIndex()) {
	        	finalCheck = "(final)";
	        }
			
			System.err.println("[M] Checkpoint " + finalCheck + " on Attack "
					+ "[" + subAttack.getAttack().getNumber() + "]:");
			System.err.println("  - Slave name: \"" + slaveName + "\"");
			System.err.println("  - Index progress: "  + currentindex + "/" + subAttack.getFinalWordIndex());
			System.err.println("  - Time since start: " + seconds + "s");
			System.err.println();
			
			Attack attack = subAttack.getAttack();
			synchronized (attack) {
				if(attack.isDone()) {
					attack.notifyAll();
				}
			}
		}
		
	}
	
	/**
	 * Attack request from client 
	 * 
	 * @param cipherText is the encrypted text to be decoded.
	 * @param knowntext is the word from the original text previously known.
	 * @throws RemoteException failed to send the add request.
	 */
	@Override
	public Guess[] attack(byte[] ciphertext, byte[] knowntext) throws RemoteException
	{
		System.err.println("[M] Request from client recieved.");
		
		Attack attack;
		
		synchronized(attacks) //sync here also avoids concurrent access to nextAvailableID 
		{
			nextAttackID++;
			attack = new Attack(nextAttackID, ciphertext, knowntext);
			attacks.add(attack);	
		}
		
		int slavesCount = slaves.size();
		while(slavesCount == 0)
		{
			try 
			{
				System.err.println("[M] ...but there are no slaves :( \n"
						+ "[M] Waiting for a slave to register...");
				synchronized(this)
				{
					this.wait();
					slavesCount = slaves.size();
				}
				
			}
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}

	
		System.err.println("[M] Starting Attack [" + nextAttackID + "] with " + slavesCount + " slave(s)...");
		System.err.println();
		
		int i = 0;
		synchronized(slaves)
		{
			for (Map.Entry<UUID, SlaveInfo> entry : slaves.entrySet())
			{

				nextSubAttackID++;

				long initialWordIndex = i * (dictionaryLinesCount/slavesCount);
				long finalWordIndex = (i + 1) * (dictionaryLinesCount/slavesCount);
				SubAttack subAttack = new SubAttack(nextSubAttackID, entry.getKey(),
						initialWordIndex, finalWordIndex, attack);
				subAttacks.put(nextSubAttackID, subAttack);
				attack.addSubAttack(subAttack);
				sendSubAttackRequest(subAttack);
				entry.getValue().addCurrentSubAttackJob(nextSubAttackID);
				i++;
			}

		}
		
		startAttackMaintenanceJob(attack);
		
		synchronized (attack) {
			try
			{
				if(!attack.isDone())
				{
					attack.wait();
				}
				
			}
			catch(InterruptedException e)
			{
				System.err.println("[M] Attack main thread interrupted. Returning 0 guess...");
				return new Guess[0];
			}
		}
		
		
		System.err.println("[M] Client request has finished. Returning " + attack.getFoundGuesses().size() + " found guess(es)");
		
		Guess[] foundGuesses = new Guess[attack.getFoundGuesses().size()];
		return attack.getFoundGuesses().toArray(foundGuesses);
	}

	
	//
	// Auxiliary Methods
	//
	
	/**
	 * Sets this master's callback-able remote reference.
	 * @param masterref the remote reference.
	 */
	public void setRemoteReference(Master masterref) {
		slaveCallback = (SlaveManager)masterref;
	}
	
	/**
	 * Giving a SubAttack, sends the subAttack information
	 * to the subAttack's allocated Slave.
	 * @param subAttack a SubAttack instance.
	 * @throws RemoteException failed to send the request.
	 */
	private void sendSubAttackRequest(SubAttack subAttack) throws RemoteException {

		UUID slaveKey = subAttack.getAttackerKey();
		Slave slave;
		synchronized (slaves) {
			slave = slaves.get(slaveKey).getSlaveRef();
		}
		slave.startSubAttack(
				subAttack.getAttack().getCiphertext(),
				subAttack.getAttack().getKnowntext(),
				subAttack.getCurrentWordIndex(),
				subAttack.getFinalWordIndex(),
				subAttack.getNumber(),
				slaveCallback);
	}
	
	/**
	 * Redirects a SubAttack job to another registered Slave
	 * at random. If there are no other Slave to allocate,
	 * the SubAttack stays idle until further calls to this method.
	 * @param subAttack the SubAttack to be completed by another Slave.
	 */
	private void redirectSubAttack(SubAttack subAttack) {
		subAttack.setAttackerKey(null);

		Random r = new Random();
		UUID randomSlaveKey;
				
		synchronized (slaves) {
			if(slaves.size() < 1) return;
			
			List<UUID> keys = new ArrayList<UUID>(slaves.keySet());
			randomSlaveKey = keys.get(r.nextInt(keys.size()));
		}
		try {
			
			subAttack.setAttackerKey(randomSlaveKey);
			subAttack.setLastCheckpointTime(System.nanoTime());
			sendSubAttackRequest(subAttack);
			System.err.println("[M] SubAttack [" + subAttack.getNumber() + "] redirected.");
			
		} catch (RemoteException e) {
			System.err.println("[M] Failed to redirect attack job.");
			subAttack.setAttackerKey(null);
		}
		
	}

	/**
	 * Procedure to remove a slave registry. Also removes the Slave
	 * reference on each of it's current subAttack jobs, setting them
	 * to null.
	 * @param slaveKey the UUID of the slave to be removed.
	 */
	private void removeSlaveProcedure(UUID slaveKey) {
		synchronized(slaves) {
			SlaveInfo slave = slaves.get(slaveKey);
			
			if(slave != null) {
				List<Integer> slaveCurrentAttackJobs = slave.getCurrentSubAttackJobs();
				
				System.err.println("[M] Slave [" + slave.getSlaveName() + "] removed.");
				slaves.remove(slaveKey);
				
				// Remove this slave's reference in all it's ongoing attack jobs
				synchronized (subAttacks) {
					for(int attackNumber : slaveCurrentAttackJobs) {
						subAttacks.get(attackNumber).setAttackerKey(null);
					}
				}
				
				slave.setCurrentAttackJobs(null);
			}
		}
	}
	
	
	/**
	 * Starts the Slaves maintenance thread.
	 */
	public void startSlaveMaintenanceJob() {
		executor.execute(slaveMaintenanceJob);
	}
	/**
	 * Runnable job to check the Slaves registry. If a slave's
	 * last registry time is greater than 40 seconds, it is set
	 * to be removed from the registered slaves Map.
	 */
	private Runnable slaveMaintenanceJob = new Runnable() {
        public void run() {

        	while(true) {
        		
        		synchronized (slaves) {

        			if(slaves.size() == 0) continue;

        			List<UUID> slavesToRemove = new ArrayList<UUID>();

        			for (Map.Entry<UUID, SlaveInfo> entry : slaves.entrySet())
        			{   									        
        				long slaveLastRegistryTime = entry.getValue().getLastRegistryTime();
        				long timeSinceLastSlaveRegistry = System.nanoTime() - slaveLastRegistryTime;
        				double seconds = (double)timeSinceLastSlaveRegistry / 1000000000.0;

        				if(seconds > 40) {
        					// slave registry expired. Remove it.
        					System.err.println("[M] Slave [" + entry.getValue().getSlaveName() + "] registry expired. Set to remove.");
        					slavesToRemove.add(entry.getKey());
        				}
        			}

        			for(UUID slaveKey : slavesToRemove) {
        				removeSlaveProcedure(slaveKey);
        			}
        		}
        		
        		
        		try {
        			
					TimeUnit.MILLISECONDS.sleep(5000);
					
				} catch (InterruptedException e) {
					System.err.println("[M] Slave maintenance job interrupted.");
				}

        	}

        }
    };
	
	
	/**
     * Starts the Attack maintenance thread.
     * @param attack the referenced Attack.
     */
	public void startAttackMaintenanceJob(Attack attack) {
		executor.execute(new AttackMaintenanceJob(attack));
	}
	
	/**
	 * Runnable class that realizes the Attack maintenance job.
	 * For each subAttack in the Attack's subAttack list, check
	 * the Slave's last checkpoint time. If it is greater than
	 * 20 seconds, then remove the Slave from the attack job.
	 *
	 */
	private class AttackMaintenanceJob implements Runnable {
        private Attack attack;
        
        AttackMaintenanceJob(Attack attack) {
        	this.attack = attack;
        }
        
        public void run() {
        	while(!attack.isDone()) {   				
        		List<UUID> attackersToRemove = new ArrayList<UUID>();

        		List<SubAttack> subAttacks = attack.getSubAttacks();

        		synchronized (subAttacks) {
        			for(SubAttack subAttack : subAttacks) {
        				if(subAttack.isDone()) continue;
        				
        				if(subAttack.getAttackerKey() == null) {
        					redirectSubAttack(subAttack);
        				}
        				else {
        					long lastCheckpointTime = subAttack.getLastCheckpointTime();
            				long timeSinceLastCheckpoint = System.nanoTime() - lastCheckpointTime;
            				double seconds = (double)timeSinceLastCheckpoint / 1000000000.0;

            				if(seconds > 20) {				        	
            					System.err.println("[M] SubAttack [" + subAttack.getNumber() + "] "
            							+ "of Attack [" + subAttack.getAttack().getNumber() + "] "
            							+ "with outdated checkpoint. Set to remove it's slave.");

            					attackersToRemove.add(subAttack.getAttackerKey());
            					subAttack.setAttackerKey(null);
            				}
        				}
        			}
        		}

        		// removing attackers marked for removal
        		for(UUID slaveKey : attackersToRemove) {
        			removeSlaveProcedure(slaveKey);
        		}

        		try {
        			
        			TimeUnit.MILLISECONDS.sleep(5000);
        			
        		} catch (InterruptedException e) {
					System.err.println("[M] Attack maintenance job interrupted.");
        		} 
        	}
        }
	}

}


