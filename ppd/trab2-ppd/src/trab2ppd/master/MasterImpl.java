package trab2ppd.master;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import com.sun.messaging.ConnectionConfiguration;
import trab2ppd.utils.FileAccess;
import trab2ppd.utils.Guess;

import java.io.IOException;

/**
 * The implementation of the Master interface.
 *
 */
public class MasterImpl implements Master 
{
	
	private Map<Integer, SubAttack> subAttacks;
	private int nextSubAttackID;
	private int nextAttackID;
	private int dictionaryLinesCount;
	
	private JMSContext jmsContext;
	private JMSProducer producer;
	private Queue subAttacksQueue;
	private int m;
	
	public MasterImpl(int m ) throws IOException {
		this.m = m ;
		this.subAttacks = new HashMap<Integer, SubAttack>();
		this.nextSubAttackID = 0;
		this.nextAttackID = 0;
		this.dictionaryLinesCount = FileAccess.readLines("dictionary.txt").length;
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
		
		synchronized(this)
		{
			nextAttackID++;
			attack = new Attack(nextAttackID);
		}
		
		// TODO fazer a partição com base no número "m" de palavras
		int numberOfPartitions =  dictionaryLinesCount/m;
	
		System.out.println("[M] Starting Attack [" + nextAttackID + "] with "
				+ "" + numberOfPartitions + " partitions...");
		System.out.println();
		
		for (int i = 0; i <= numberOfPartitions; i++) {
			nextSubAttackID++;

			int initialWordIndex = i * (m);
			int finalWordIndex = (i != numberOfPartitions ?(i + 1) * (m):dictionaryLinesCount);

			SubAttack subAttack = new SubAttack(nextSubAttackID,
					initialWordIndex, finalWordIndex,
					ciphertext, knowntext, attack);
			
			synchronized (subAttacks) {
				subAttacks.put(nextSubAttackID, subAttack);
			}
			
			attack.addSubAttack(subAttack);
						
			// Enqueue the SubAttack
			try {
				ObjectMessage message = jmsContext.createObjectMessage();
				
				
				message.setObject(subAttack);
				producer.send(subAttacksQueue,message);
				
			} catch (JMSException e) {
				e.printStackTrace();
			};
		}
		
		
		
		
				
		synchronized (attack) {
			try
			{
				attack.checkSubAttacks();
				
				while(!attack.isDone())
				{
					attack.wait();
					attack.checkSubAttacks();
				}
				
			}
			catch(InterruptedException e)
			{
				System.err.println("[M] Attack main thread interrupted. Returning 0 guess.");
				return new Guess[0];
			}
		}
		
		
		System.err.println("[M] Client request finished. Returning " 
				+ attack.getFoundGuesses().size() + " found guess(es).");
		
		Guess[] foundGuesses = new Guess[attack.getFoundGuesses().size()];
		return attack.getFoundGuesses().toArray(foundGuesses);
	}

	/**
	 * Deals with a received Guess message.
	 * @param msg The received message.
	 */
	public void onMessage(Message msg) {
		try {
			if (msg instanceof ObjectMessage)
			{
				ObjectMessage objMsg = (ObjectMessage) msg;
				
				if(objMsg.getObject() instanceof Guess)
				{
					Guess guess = (Guess) objMsg.getObject();
					
					if(guess.getKey() == null) {
						System.out.println("[M] SubAttack "
								+ "[" + guess.getSubAttackNumber() + "] completed by "
								+ "slave \"" + guess.getSlaveName() + "\"");
						
						
						synchronized (subAttacks) {
							SubAttack subAttack = subAttacks.get(guess.getSubAttackNumber());
							subAttack.setDone(true);
							
							Attack attack = subAttack.getAttack();
							synchronized (attack) {
								// Notify blocked attack thread of a
								// finished SubAttack job
								attack.notifyAll();
							}
						}
					}
					else {
						System.err.println("[M] Guess found: \"" + guess.getKey() + "\"");
						System.err.println("  - SubAttack: [" + guess.getSubAttackNumber() + "]");
						System.err.println("  - Slave name: \"" + guess.getSlaveName() + "\"");
						System.err.println();
						
						// Adding guess to Attack's guesses list
						synchronized (subAttacks) {
							SubAttack subAttack = subAttacks.get(guess.getSubAttackNumber());
							
							subAttack.getAttack().addGuess(guess);
						}
					}
				}
				
			}
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Starts the Master Server.
	 * @param args
	 */
	public static void main(String[] args) {
		
		if(args.length < 1)
		{
			System.out.println("Invalid input\nCorrect usage:\n   java <package name>.MasterImpl <number of segments>");
			return;
		}
		
		// Server info
		String host = "127.0.0.1";
		String bindName = "mestre";

		try {
			// RMI configuration stuff
			MasterImpl master = new MasterImpl(Integer.parseInt(args[0]));
			Master masterref = (Master) UnicastRemoteObject.exportObject(master, 0);
			
			System.err.print("[M] Server binding at local registry... ");
			// Bind the remote object in the registry
			Registry registry = LocateRegistry.getRegistry(host);
			registry.rebind(bindName, masterref);
			System.out.println("OK.");
			// End of RMI configuration stuff
			
			// JMS configuration stuff
			Logger.getLogger("").setLevel(Level.INFO);
	
			System.out.print("[M] Obtaining connection factory... ");
			com.sun.messaging.ConnectionFactory connectionFactory = new com.sun.messaging.ConnectionFactory();
			connectionFactory.setProperty(ConnectionConfiguration.imqAddressList, host + ":7676");
			connectionFactory.setProperty(ConnectionConfiguration.imqConsumerFlowLimitPrefetch, "false");
			System.out.println("OK.");
	
			System.out.print("[M] Obtaining queues... ");
			Queue subAttacksQueue = new com.sun.messaging.Queue("SubAttacksQueue");
			Queue guessesQueue = new com.sun.messaging.Queue("GuessesQueue");
			System.out.println("OK.");
			
			JMSContext context = connectionFactory.createContext();
			
			JMSProducer producer = context.createProducer();
			JMSConsumer consumer = context.createConsumer(guessesQueue);
			// End of JMS configuration stuff
			
			master.setJmsContext(context);
			master.setProducer(producer);
			master.setSubAttacksQueue(subAttacksQueue);
			
			System.err.println("[M] Server ready!");
			
			while (true) {
				Message msg = consumer.receive();
				master.onMessage(msg);
			}
			
			
		} catch (Exception e) {
			System.err.println("[M] Server exception: " + e.toString());
			e.printStackTrace();
		}
	}
	
	
	//
	// GETTERS & SETTERS
	//
	
	public JMSContext getJmsContext() {
		return jmsContext;
	}

	public void setJmsContext(JMSContext jmsContext) {
		this.jmsContext = jmsContext;
	}

	public JMSProducer getProducer() {
		return producer;
	}

	public void setProducer(JMSProducer producer) {
		this.producer = producer;
	}

	public Queue getSubAttacksQueue() {
		return subAttacksQueue;
	}

	public void setSubAttacksQueue(Queue subAttacksQueue) {
		this.subAttacksQueue = subAttacksQueue;
	}

}


