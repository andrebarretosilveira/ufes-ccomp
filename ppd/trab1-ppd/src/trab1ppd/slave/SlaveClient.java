package trab1ppd.slave;

import java.io.IOException;

/**
 * Initializes the Slave and attempts to
 * connect with the Master "master".
 */
public class SlaveClient {
	
	public static void main(String[] args) {
		
		//args[0] = server address
	    //args[1] = slave name
		
		if(args.length < 2)
	    {
	      System.out.println("Invalid input\nCorrect usage:\n   java <package name>.Slave <server adress> <slave name>");
	      return;
	    }

		// Read server info from console argument
		String masterHost = args[0];
		String slaveName = args[1];
		String masterBoundName = "mestre";

		try {		
			SlaveImpl slave = new SlaveImpl(slaveName, masterHost, masterBoundName);
			
			slave.generateRemoteRef();
			slave.initConnection();
					
		} 
		catch (IOException ioE)
		{
			System.err.println("[S]Error when trying to load dictionary");
			ioE.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
