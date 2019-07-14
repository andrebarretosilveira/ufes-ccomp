package trab1ppd.slave;

import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.rmi.ConnectException;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.SecretKeySpec;

import br.inf.ufes.ppd.*;
import trab1ppd.utils.FileAccess;

/**
 * Represents the decryption job. Does the actual search for key
 * from a loaded dictionary and periodically sends the checkpoints
 * to the Master (SlaveManager).
 */
public class SubAttackJob implements Runnable 
{
	private String[] dictionaryLines;
	
	private byte[] ciphertext;
	private byte[] knowntext;
	private int initialwordindex;
	private int finalwordindex;
	private int currentwordindex;
	private int attackNumber;
	private UUID uuid;
	private SlaveManager callbackinterface;
	

	public SubAttackJob(String[] dictionaryLines, byte[] ciphertext, byte[] knowntext, long initialwordindex, long finalwordindex,
			int attackNumber, SlaveManager callbackinterface, UUID uuid)
	{
		this.attackNumber = attackNumber;
		this.initialwordindex = java.lang.Math.toIntExact(initialwordindex);
		this.finalwordindex = java.lang.Math.toIntExact(finalwordindex);
		this.ciphertext = ciphertext;
		this.knowntext = knowntext;
		this.uuid = uuid;
		this.callbackinterface = callbackinterface;
		this.dictionaryLines = dictionaryLines;
	}

    public void run() 
    {
    	try
		{    		
			for (currentwordindex = initialwordindex; currentwordindex < finalwordindex; currentwordindex++)
			{
				try
				{
					byte[] dkey = dictionaryLines[currentwordindex].getBytes(StandardCharsets.UTF_8);
					SecretKeySpec dkeySpec = new SecretKeySpec(dkey, "Blowfish");

					//Decryption
					Cipher decryption_cipher = Cipher.getInstance("Blowfish");
					decryption_cipher.init(Cipher.DECRYPT_MODE, dkeySpec);

					byte[] decrypted = decryption_cipher.doFinal(ciphertext);

					if(FileAccess.byteArrayContains(decrypted, knowntext))
					{
						System.out.println("[S] Found guess \"" + dictionaryLines[currentwordindex] + "\" at index: " + currentwordindex);
						Guess guess = new Guess();
						guess.setKey(dictionaryLines[currentwordindex]);
						guess.setMessage(decrypted);
						callbackinterface.foundGuess(uuid, attackNumber, currentwordindex, guess);
						
					}
					

				}
				catch ( IllegalBlockSizeException e)
				{
					System.err.println("[S] IllegalBlockSizeException. Continuing search...");
				}
				catch (javax.crypto.BadPaddingException e) 
				{
					// essa excecao e jogada quando a senha esta incorreta
					// porem nao quer dizer que a senha esta correta se nao jogar essa excecao
					//System.out.println("Senha invalida.");

				}
				catch(RemoteException remoteE)
				{
					System.err.println("[S] Failed at sending found guess to master");
				}
				catch(Exception e)
				{
					System.err.println("[S] Failed at index: " +currentwordindex + "| dictionary size: " +  dictionaryLines.length);
					e.printStackTrace();
				}
				

			}
    		
    		currentwordindex = finalwordindex;//This line is only useful when measuring communication overhead
			callbackinterface.checkpoint(uuid, attackNumber, currentwordindex );
			System.out.println("[S] Finished attack [" + attackNumber + "] process!");

			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }
    
    /**
     * The periodic checkpoint routine.
     */
    public Runnable taskCheckpointRoutine = new Runnable()
    {
        public void run() 
        {
        	try 
        	{
        		while(currentwordindex < finalwordindex)
        		{
        			TimeUnit.MILLISECONDS.sleep(10000);
        			if(currentwordindex < finalwordindex)
        			{
        				callbackinterface.checkpoint(uuid, attackNumber, currentwordindex);
        			}
    					
        		}
			}
        	catch (InterruptedException e)
        	{
				e.printStackTrace();
			}
        	catch(ConnectException e)
        	{
    			System.err.println("[S] Master address has no processes listening to the chosen port. Aborting task");

        	}
        	catch (RemoteException e) 
        	{
				e.printStackTrace();
			}
        }
    };


}