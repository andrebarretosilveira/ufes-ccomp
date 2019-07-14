package trab1ppd.client;


import java.io.*;
import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.RemoteException;
import java.util.*;

import br.inf.ufes.ppd.Attacker;
import br.inf.ufes.ppd.Guess;
import trab1ppd.utils.FileAccess;

import java.nio.charset.StandardCharsets;

/**
 * Requests an attack to a remote Server.
 */
public class Client
{
	Attacker serverAttacker; 
	byte[] cipherText;
	byte[] knownWord;
	Guess[] guesses;


	public Client(byte[] cipherText, byte[] knownWord, String serverAddress)
	{

		this.cipherText = cipherText;
		this.knownWord = knownWord;
		//Find attacker by its registry


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
	 * Returns a random byte[] of size derived from command line arguments.
	 * @param args is the argument passed on execution.
	 */
	public static byte[] randomizedBytes(String[] args)
	{
		Random rand = new Random();
		byte[] b;
		if(args.length < 4)
	    {
	        b = new byte[rand.nextInt(99001) + 1000];
	    }
	    else
	    {
	      try
	      {
	        b = new byte[Integer.parseInt(args[3])];
	      }
	      catch(NumberFormatException e)
	      {
	        System.out.println("Invalid input: byte array size.\nBacking-up to a randomized size solution");
	        b  = new byte[rand.nextInt(99001) + 1000];
	      }
	    }
	    rand.nextBytes(b);
	    return b;
	}
 
	
  	

	/**
	 * Send a attack request to the server, and
	 * assign the found guesses in the guesses attribute.
	 * 
	 * @param cipherText is the encrypted text to be decoded.
	 * @param knowntext is the word from the original text previously known. 
	 * @throws RemoteException failed to send the request.
	 */
	public void orderAttack(byte[] cipherText,
	  byte[] knowntext) throws RemoteException
	{
		if(serverAttacker != null)
		{
			guesses = serverAttacker.attack(cipherText, knowntext);	
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
	 * Constructs a new Client and uses it to order an attack to the server.
	 */
  public static void main(String[] args)
  {
    //args[0] = server address
    //args[1] = text to be encrypted pathname
    //args[2] = known text (single word)
    //args[3] = (optional) size of the random byte vector

  	Client client;





    byte[] cipheredText;
    byte[] knownWord;
   
    if(args.length < 3)
    {
      System.out.println("Invalid input\nCorrect usage:\n   java <package name>.Client <server adress> <input text pathname> <known word> <(optional)randombyte array size>");
      return;
    }


    knownWord = args[2].getBytes(StandardCharsets.UTF_8);



	try
	{
		cipheredText = FileAccess.readFile(args[1]);
	}
	catch(IOException e)
	{
		cipheredText = randomizedBytes(args);
	    System.out.println("Randomizing");
		try
		{
			FileAccess.saveFile("Random Bytes.cipher", cipheredText);
		}
		catch(IOException e2)
		{
			System.out.println("IOException: saving Random Bytes.cipher has failed. Processing will continue nonetheles.");
		}


	}


	client = new Client(cipheredText, knownWord, args[0]);


	try
	{
		
		client.orderAttack(cipheredText, knownWord);
	}
	catch(RemoteException e)
	{
		System.out.println("Error: Server connection has failed. Server either ended connection or it could not be reachead.");
		System.out.println("Is there a server running?");
		e.printStackTrace();
		return;
	}
	
	client.handleGuesses();

	

  }
}
