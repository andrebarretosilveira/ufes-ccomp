package trab1ppd.slave;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import br.inf.ufes.ppd.*;
import trab1ppd.utils.FileAccess;

/**
 * The implementation of the Slave interface.
 */
public class SlaveImpl implements Slave {
	
	private String name;
	private UUID uuid;
	private Registry registry;
	private Master master;
	private String masterBoundName;
	private String masterHost;
	private Slave remoteRef;
	private ExecutorService executor;

	private String[] dictionaryLines;
	
	public SlaveImpl(String name, String masterHost, String masterBoundName) throws IOException {
		this.setName(name);
		this.masterHost = masterHost;
		this.masterBoundName = masterBoundName;
		this.uuid = UUID.randomUUID();
		this.executor = Executors.newFixedThreadPool(10);
		this.master = null;
		this.registry = null;
		this.remoteRef = null;
		
		dictionaryLines = FileAccess.readLines("dictionary.txt");
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable()
		{
			public void run() 
			{
				try 
				{
					if(master != null)
					{
						master.removeSlave(uuid);
					}
					
				} 
				catch (RemoteException e){}
				
			}
		}));
	}
	
	@Override
	public void startSubAttack(byte[] ciphertext, byte[] knowntext, long initialwordindex, long finalwordindex,
			int attackNumber, SlaveManager callbackinterface) throws RemoteException 
	{
		SubAttackJob subAttack = new SubAttackJob(dictionaryLines,
				ciphertext,
				knowntext,
				initialwordindex,
				finalwordindex,
				attackNumber,
				callbackinterface,
				uuid);
		
		executor.execute(subAttack);
		executor.execute(subAttack.taskCheckpointRoutine);
		
		System.err.println("[S] Request recieved. Starting subAttack [" + attackNumber + "]...");
	}
	
	    
	/**
	 * Starts searching for the Master in registry. Calls the executor, creating
	 * a thread to periodically try to locate the Master. This procedure is called
	 * when the Slave fails to re-register once. See the "registrationMaintenance".
	 */
	public void startMasterSearchJob() {
		this.master = null;
		this.registry = null;
		
		System.err.println("[S] Searching for master...");
		executor.execute(masterSearchJob);
	}
	private Runnable masterSearchJob = new Runnable() {
        public void run() {
        	try {       		
        		while(master == null) {
        			TimeUnit.MILLISECONDS.sleep(5000);

        			locateMaster();
        			if(master != null) registerToMaster();        			
        		}
        		
        		System.out.println("[S] Master found! Connection estabilished.");
				startRegistrationMaintenanceJob();
				
			} catch (InterruptedException e) {
				System.err.println("[S] Connection Thread was interrupted.");
			}
       }
    };

	
	/**
	 * Starts the registration maintenance. Calls the executor, creating
	 * a thread to periodically attempt to re-register to Master.
	 */
	public void startRegistrationMaintenanceJob() {
		executor.execute(registrationMaintenanceJob);
	}
	private Runnable registrationMaintenanceJob = new Runnable() {
        public void run() {
        	try {
        		while(true) {        			
    				registerToMaster();
    				
        			if(master == null) throw new Exception();

        			TimeUnit.MILLISECONDS.sleep(30000); 
        		}
				
			} catch (Exception e) {
				System.err.println("[S] Failed to update registry at Master.");
				
				startMasterSearchJob();
			}
       }
    };
		
    
	/**
	 * Attempts to locate the Master in the rmiregistry. If the master is
	 * found, sends the registration request and starts the registration
	 * maintenance. If the connection fails, this method calls the startMasterSearchJob.
	 */
	public void initConnection() {
		System.err.println("[S] Initializing connection...");
		
		locateMaster();
		
		if(master != null) registerToMaster();
		if(master != null) {
			System.err.println("[S] Connection estabilished!");
			startRegistrationMaintenanceJob();
		}
		else startMasterSearchJob();
	}
	
	/**
	 * Tries to locate the Master with the parameters set in this Slave.
	 */
	private void locateMaster() {

		try {
			
			registry = LocateRegistry.getRegistry(masterHost);
			
		} catch (RemoteException e) {
			System.err.println("[S] Error trying to locate master's registry.");
		}
		try {	
			
			master = (Master) registry.lookup(masterBoundName);
			
		} catch (RemoteException e) {
			System.err.println("[S] Error trying to locate master in registry.");
		} catch (NotBoundException e) {
			System.err.println("[S] Master not found in registry.");
		}
	}

	/**
	 * Attempts to establish connection with the Master by sending a
	 * registration request via the Master reference in this Slave.
	 * If the attempt fails, the Master reference is set to null.
	 */
	private void registerToMaster() {
		try {
			this.master.addSlave(this.remoteRef, this.name, this.uuid);

		} catch (RemoteException e) {
			System.err.println("[S] Error trying to register to master.");
			master = null;
		}
	}

	/**
	 * Generates a UnicastRemoteObject reference of this Slave.
	 * @throws RemoteException failed to generate a Remote Reference.
	 * Failing to generate a Remote Reference kills the Slave process.
	 */
	public void generateRemoteRef() throws RemoteException {
		this.remoteRef = (Slave) UnicastRemoteObject.exportObject(this, 0);
	}
	
	
	//
	// GETTERS & SETTERS
	//

	public String getMasterBoundName() {
		return masterBoundName;
	}

	public void setMasterBoundName(String masterBoundName) {
		this.masterBoundName = masterBoundName;
	}

	public String getMasterHost() {
		return masterHost;
	}

	public void setMasterHost(String masterHost) {
		this.masterHost = masterHost;
	}

	public ExecutorService getExecutor() {
		return executor;
	}

	public void setExecutor(ExecutorService executor) {
		this.executor = executor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	
	public Registry getRegistry() {
		return registry;
	}

	public void setRegistry(Registry registry) {
		this.registry = registry;
	}

	public Master getMaster() {
		return master;
	}

	public void setMaster(Master master) {
		this.master = master;
	}

	public Slave getRemoteRef() {
		return remoteRef;
	}

	public void setRemoteRef(Slave remoteRef) {
		this.remoteRef = remoteRef;
	}

}
