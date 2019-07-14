package trab2ppd.slave;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.SecretKeySpec;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import com.sun.messaging.ConnectionConfiguration;
import trab2ppd.master.SubAttack;
import trab2ppd.utils.*;

/**
 * The implementation of the Slave interface.
 */
public class Slave {

	private String name;
	private String masterHost;
	private String[] dictionaryLines;
	
	private JMSContext jmsContext;
	private JMSProducer producer;
	private Queue guessesQueue;

	public Slave(String name, String masterHost) throws IOException {
		this.setName(name);
		this.masterHost = masterHost;

		dictionaryLines = FileAccess.readLines("dictionary.txt");
	}

	/**
	 * Starts a SubAttack's decryption job.
	 * @param ciphertext Encrypted text to process.
	 * @param knowntext Known fragment of the target text.
	 * @param initialwordindex Initial word index for the dictionary lookup.
	 * @param finalwordindex Final word index for the dictionary lookup.
	 * @param subAttackNumber Requested SubAttack's number.
	 * @param guessesQueue Queue to notify Master and send Guesses.
	 */
	private void startSubAttack(byte[] ciphertext, byte[] knowntext,
			int initialwordindex, int finalwordindex,
			int subAttackNumber, Queue guessesQueue) {

		System.err.println("[S] Request recieved. Starting subAttack [" + subAttackNumber + "]...");

		try {
			int currentwordindex = 0;
			for (currentwordindex = initialwordindex; currentwordindex < finalwordindex; currentwordindex++) {
				try {
					byte[] dkey = dictionaryLines[currentwordindex].getBytes(StandardCharsets.UTF_8);
					SecretKeySpec dkeySpec = new SecretKeySpec(dkey, "Blowfish");

					// Decryption
					Cipher decryption_cipher = Cipher.getInstance("Blowfish");
					decryption_cipher.init(Cipher.DECRYPT_MODE, dkeySpec);

					byte[] decrypted = decryption_cipher.doFinal(ciphertext);

					if (FileAccess.byteArrayContains(decrypted, knowntext)) {
						System.out.println("[S] Found guess \"" + dictionaryLines[currentwordindex]
								+ "\" at index: " + currentwordindex);
						
						Guess guess = new Guess(dictionaryLines[currentwordindex],
								decrypted, subAttackNumber, this.name);

						ObjectMessage message = jmsContext.createObjectMessage(); 
						message.setObject(guess);
						producer.send(guessesQueue,message);
					}

				} catch (IllegalBlockSizeException e) {
					System.err.println("[S] IllegalBlockSizeException. Continuing search...");
					
				} catch (javax.crypto.BadPaddingException e) {
					// essa excecao e jogada quando a senha esta incorreta
					// porem nao quer dizer que a senha esta correta se nao jogar essa excecao
					// System.out.println("Senha invalida.");
				}

			}

			currentwordindex = finalwordindex;// This line is only useful when measuring communication overhead
			
			// Guess with no key means the attack process is over
			Guess guess = new Guess(subAttackNumber, this.name);

			ObjectMessage message = jmsContext.createObjectMessage(); 
			message.setObject(guess);
			producer.send(guessesQueue,message);
			
			System.out.println("[S] Finished subattack [" + subAttackNumber + "] process!");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * Starts the Slave process.
	 * @param args
	 */
	public static void main(String[] args) {

		// args[0] = server address
		// args[1] = slave name

		if (args.length < 2) {
			System.out.println(
					"Invalid input\nCorrect usage:\n   " +
					"java trab2ppd.slave.Slave <server adress> <slave name>"
			);

			return;
		}

		// Read server info from console argument
		String masterHost = args[0];
		String slaveName = args[1];

		try {
			// JMS configuration stuff
			Logger.getLogger("").setLevel(Level.INFO);

			System.out.print("[S] Obtaining connection factory... ");
			com.sun.messaging.ConnectionFactory connectionFactory = new com.sun.messaging.ConnectionFactory();
			connectionFactory.setProperty(ConnectionConfiguration.imqAddressList, masterHost + ":7676");
			connectionFactory.setProperty(ConnectionConfiguration.imqConsumerFlowLimitPrefetch, "false");
			System.out.println("OK.");

			System.out.print("[S] Obtaining queues... ");
			Queue subAttacksQueue = new com.sun.messaging.Queue("SubAttacksQueue");
			Queue guessesQueue = new com.sun.messaging.Queue("GuessesQueue");
			System.out.println("OK.");

			JMSContext context = connectionFactory.createContext();

			JMSConsumer consumer = context.createConsumer(subAttacksQueue);
			JMSProducer producer = context.createProducer();
			// End of JMS configuration stuff
			
			Slave slave = new Slave(slaveName, masterHost);
			slave.setJmsContext(context);
			slave.setGuessesQueue(guessesQueue);
			slave.setProducer(producer);

			System.out.println("[S] Slave ready!");
			
			while (true) {
				Message msg = consumer.receive();
				
				if (msg instanceof ObjectMessage) {
					ObjectMessage objMsg = (ObjectMessage) msg;
					
					if (objMsg.getObject() instanceof SubAttack) {
						
						SubAttack subAttack = (SubAttack) objMsg.getObject();

						slave.startSubAttack(subAttack.getCiphertext(), subAttack.getKnowntext(),
								subAttack.getInitialWordIndex(), subAttack.getFinalWordIndex(),
								subAttack.getNumber(), guessesQueue
						);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	

	//
	// GETTERS & SETTERS
	//

	public String getMasterHost() {
		return masterHost;
	}

	public void setMasterHost(String masterHost) {
		this.masterHost = masterHost;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public JMSProducer getProducer() {
		return producer;
	}

	public void setProducer(JMSProducer producer) {
		this.producer = producer;
	}

	public Queue getGuessesQueue() {
		return guessesQueue;
	}

	public void setGuessesQueue(Queue guessesQueue) {
		this.guessesQueue = guessesQueue;
	}

	public JMSContext getJmsContext() {
		return jmsContext;
	}

	public void setJmsContext(JMSContext jmsContext) {
		this.jmsContext = jmsContext;
	}

}
