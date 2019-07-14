package trab1ppd.client;


import java.io.*;
import java.rmi.*;
import java.rmi.registry.*;
import java.text.NumberFormat;
import java.rmi.RemoteException;
import java.util.*;

import br.inf.ufes.ppd.Attacker;
import br.inf.ufes.ppd.Guess;
import trab1ppd.utils.FileAccess;



/**
 * Measures the time taken to do a dictionary attack on a random byte[] using a remote server.
 */
public class ParallelMeasurement
{
	Attacker serverAttacker; 
	byte[] cipherText;
	byte[] knownWord;
	Guess[] guesses;


 
	public ParallelMeasurement(String serverAddress)
	{
	    knownWord = new byte[8];
	    
	    try 
		{
			Registry registry = LocateRegistry.getRegistry(serverAddress); // e.g.: host = 127.0.0.1
			serverAttacker = (Attacker) registry.lookup("mestre");
			
		}
		catch (RemoteException e)
		{
			System.err.println("[C] error trying to locate server.");
		}
		catch (NotBoundException e)
		{
			System.err.println("[C] exception: server name \'master' not found in server's registry.");
		}
	}

	/**
	 *	Assigns a new random byte[] of a specific size to the
	 *text to be decoded.
	 * @param size is quantity of elements in the byte[]. 
	 */
	public void resetCipheredText(int size)
	{
		//Random message special case
		
		Random rand = new Random();
		cipherText = new byte[size];
	    rand.nextBytes(cipherText);
	    
	}
	
	/**
	 * Request attacks multiple times to the server and returns
	 *  the average of the time taken to process all attack.
	 * 
	 * @param bytesNumber is the size of the random byte[] to be attacked.
	 * @param repetitions is the number of attacks to be considered. 
	 */
	public double attackAverageSecondsTaken(int bytesNumber, int repetitions) 
	{
		long initTime;
		try
		{
			System.out.println("Number of bytes = " + bytesNumber);
			resetCipheredText(bytesNumber);
			initTime = System.nanoTime();
			for(int i = 0; i < repetitions;i++)
			{
				orderAttack();
				handleGuesses();
			}

		}
		catch(RemoteException e)
		{
			e.printStackTrace();
			System.out.println("Error: Server connection has failed. Server either ended connection or it could not be reachead.");
			System.out.println("Is there a server running?");
			return -1;
		}
		
		return (double)(System.nanoTime() - initTime) / (1000000000.0 * repetitions);

	}
	
	/**
	 * Send a attack request to the server, and
	 * assign the found guesses in the guesses attribute.
	 * 
	 * @throws RemoteException failed to send the request.
	 */
	public void orderAttack() throws RemoteException
	{
		if(serverAttacker != null)
		{
			guesses = serverAttacker.attack(cipherText, knownWord);	
		}		
	}


	/**
	 * Save found guesses into a file or prints error message if the latter fails. 
	 */
	public void handleGuesses()
	{
		if(guesses == null)
			return;
			
		for (int i = 0; i < guesses.length; i++)
		{
			System.out.println(guesses[i].getKey());
			try
			{
				FileAccess.saveFile(guesses[i].getKey() + ".msg", guesses[i].getMessage());
			}
			catch(IOException e)
			{
	        	System.out.println("Saving guess " + guesses[i].getKey() + ".msg has failed");
			}
			
		}
	}

	



	/**
	 * Constructs a new ParallelMeasurement and uses it to measure the time taken
	 * to execute a remote attack for different sizes of text. 
	 */
  public static void main(String[] args)
  {
	    //args[0] = server address
		//args[1] = sampling size
		//args[2] = sampling bytes count intervals
		//args[3] = sampling repetitions
		
	ParallelMeasurement client;

   
    if(args.length < 4)
    {
      System.out.println("Invalid input\nCorrect usage:\n   java <package name>.ParallelMeasurement <server adress> <number of intervals> <interval size> <sampling quantity>");
      return;
    }





	client = new ParallelMeasurement(args[0]);
	double[] capturedTimes = null;
	int samplingInterval = 0; 
	int repetitions= 0;
	try
	{
		
		repetitions = Integer.parseInt(args[3]);
		capturedTimes = new double[Integer.parseInt(args[1]) + 1];
		samplingInterval = Integer.parseInt(args[2]);
		if(samplingInterval % 8 != 0)
		{
			System.err.println("Invalid input: Sampling interval must be multiple of 8");
			return;
		}
	}
	catch(NumberFormatException e)
	{
		System.out.println("Invalid input: Sample Size Passed is invalid.\nFailed to run the experiment");
		return;
	}
	
	
	//Measure attacks
	capturedTimes[0] = client.attackAverageSecondsTaken(8,repetitions);
	for(int k = 1; k < capturedTimes.length;k++)
	{
		capturedTimes[k] = client.attackAverageSecondsTaken(k * samplingInterval,repetitions);
	}
	
	//Generate CSV file
	NumberFormat nf_fr = NumberFormat.getInstance(Locale.FRENCH);
	
	String csv = "";
	csv += "Number of bytes;Time in seconds\n";
	csv += 8 +";" + nf_fr.format(capturedTimes[0]) + "\n";
	for(int i = 1; i < capturedTimes.length;i++)
	{
		csv += i * samplingInterval +";" + nf_fr.format(capturedTimes[i]) + "\n";
	}
	
	//Save CSV file
	try {
		FileAccess.saveFile("ParallelMeasurements.csv", csv.getBytes());
	}
	catch(IOException e)
	{
		System.err.println("Failed to output measurements");
	}
	
	
	

  }
}