package trab1ppd.client;
import javax.crypto.*;
import javax.crypto.spec.*;

import br.inf.ufes.ppd.Guess;
import trab1ppd.utils.FileAccess;

import java.io.*;
import java.util.*;
import java.nio.charset.StandardCharsets;
import java.text.NumberFormat;


/**
 * Measures the time taken to do a serial dictionary attack on a random byte[].
 */
public class CentralizedMeasurement 
{
	String[] dictionaryLines;
	byte[] cipheredText;
	byte[] knownWord;
	
	public CentralizedMeasurement()
	{

		knownWord = new byte[8];
		try
		{
			dictionaryLines = FileAccess.readLines("dictionary.txt");
			
		}
		catch(IOException ioe)
		{
	        System.err.println("No dictionary file located.");
			dictionaryLines = new String[0];
			//Random message special case
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
		cipheredText = new byte[size];
	    rand.nextBytes(cipheredText);
	    
	}
	
	/**Executes a serial dictionary attack on the ciphered text.
	 */
	public Guess[] attack()
	{
		List<Guess> guesses = new LinkedList<Guess>();
		try
		{

			for (int i = 0; i< dictionaryLines.length; i++)
			{
				try
				{
					byte[] dkey = dictionaryLines[i].getBytes(StandardCharsets.UTF_8);
					SecretKeySpec dkeySpec = new SecretKeySpec(dkey, "Blowfish");

					//Decryption
					Cipher decryption_cipher = Cipher.getInstance("Blowfish");
					decryption_cipher.init(Cipher.DECRYPT_MODE, dkeySpec);


					byte[] decrypted = decryption_cipher.doFinal(cipheredText);
					
					if(FileAccess.byteArrayContains(decrypted, knownWord))
					{
						Guess g = new Guess();
						
						g.setKey(dictionaryLines[i]);
						g.setMessage(decrypted);
						guesses.add(g);
					}
					
				}
				catch (javax.crypto.BadPaddingException e) 
				{
					// essa excecao e jogada quando a senha esta incorreta
					// porem nao quer dizer que a senha esta correta se nao jogar essa excecao
					//System.out.println("Senha invalida.");

				}
				catch(Exception e)
				{
					e.printStackTrace();
				}	
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return guesses.toArray(new Guess[guesses.size()]);
	}

	
	/** Tries to save all found guesses in a file. If it fails, it prints an error message.
	 * @param guesses is the list of guesses found by a previous attack.
	 */
	public void handleGuesses(Guess[] guesses)
	{
		if(guesses == null)
			return;
			
		for (int i = 0; i < guesses.length; i++)
		{
			//System.out.println(guesses[i].getKey());
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

	public static void main(String[] args)
	{
		//args[0] = number of intervals
		//args[1] = interval size
		//args[2] = sampling quantity
	
		if(args.length < 3)
		{
			System.out.println("Invalid input\nCorrect usage:\n   java <package name>.CentralizedMeasurement <number of intervals> <interval size> <sampling quantity>");
		    return;
		}
		
		CentralizedMeasurement inst = new CentralizedMeasurement();
		double[] capturedTimes = null;
		int samplingInterval = 0; 
		int repetitions= 0;
		
		try
		{
			
			repetitions = Integer.parseInt(args[2]);
			capturedTimes = new double[Integer.parseInt(args[0]) + 1];
			samplingInterval = Integer.parseInt(args[1]);
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
		
		
		System.out.println("Attacking a " + 8 +" bytes text");
		inst.resetCipheredText(8);
		long initTime = System.nanoTime();
		for(int i = 0; i < repetitions;i++)
		{
			inst.attack();
		}
		capturedTimes[0] = (double)(System.nanoTime() - initTime) / (1000000000.0 * repetitions);
		for(int k = 1; k < capturedTimes.length;k++)
		{
			System.out.println("Attacking a " + (k * samplingInterval) +" bytes text");
			inst.resetCipheredText(k * samplingInterval);
			initTime = System.nanoTime();
			for(int i = 0; i < repetitions;i++)
			{
				inst.handleGuesses(inst.attack());

			}
			capturedTimes[k] = (double)(System.nanoTime() - initTime) / (1000000000.0 * repetitions);
			
		}
		
		
		
		
		//Generate CSR file
		NumberFormat nf_fr = NumberFormat.getInstance(Locale.FRENCH);
		
		String csv = "";
		csv += "Number of bytes;Time in seconds\n";
		csv += 8 +";" + nf_fr.format(capturedTimes[0]) + "\n";
		for(int i = 1; i < capturedTimes.length;i++)
		{
			csv += i * samplingInterval +";" + nf_fr.format(capturedTimes[i]) + "\n";
		}
		
		
		try {
			FileAccess.saveFile("CentralizedMeasurements.csv", csv.getBytes());
		}
		catch(IOException e)
		{
			System.err.println("Failed to output measurements");
		}
		
		
		
		
		
	}
}