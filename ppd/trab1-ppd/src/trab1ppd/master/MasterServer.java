package trab1ppd.master;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import br.inf.ufes.ppd.Master;

/**
 * Locates the Registry and Initializes the Server.
 */
public class MasterServer {
	
	public static void main(String[] args) {
		
		// Server info
		String host = "127.0.0.1";
		String bindName = "mestre";

		try {
			MasterImpl master = new MasterImpl();
			Master masterref = (Master) UnicastRemoteObject.exportObject(master, 0);
			
			// Bind the remote object in the registry
			Registry registry = LocateRegistry.getRegistry(host); // e.g.: host = 127.0.0.1
			System.err.println("[M] Server binding at local registry...");

			registry.rebind(bindName, masterref);
			System.err.println("[M] Server ready!");
			
			master.setRemoteReference(masterref);
			master.startSlaveMaintenanceJob();
			
		} catch (Exception e) {
			System.err.println("[M] Server exception: " + e.toString());
		}
	}

}
