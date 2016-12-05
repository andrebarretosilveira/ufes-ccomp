package servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.google.protobuf.ByteString;

import utilitarios.CommandCode;
import utilitarios.Message;
import utilitarios.Message.ResponseMessage;
import utilitarios.StatusCode;
import utilitarios.Message.CommandMessage;

/**
 * Classe responsável por realizar a comunicação entre
 * interface e operações do servidor que implementa
 * runnable para que seja possível a conexão de vários
 * clientes no servidor.
 * 
 * @author André Barreto
 * @author Igor Ventorim
 * @version 1.0
 *
 */
public class Server implements Runnable {
	private ServerOperation serverOperation;
	private ServerSocket serverSocket;
	private Socket client;
	private byte[] response;
	private int cmdId;
	final private int PORTNUMBER = 8888;

	public Server()	{
		this.serverOperation = new ServerOperation();
	}
	
	/**
	 * Coloca o servidor para ouvir a porta 8888. O servidor ficará
	 * bloquado até que uma conexão seja criada.
	 * @throws IOException Se ocorrer algum erro de I/O ao tentar ouvir a porta
	 */
	public void listenPort() throws IOException {
		System.out.println("[ Servidor ouvindo a porta " + PORTNUMBER + " ]\n");
		this.serverSocket = new ServerSocket(PORTNUMBER);
		this.client = this.serverSocket.accept();
		serverSocket.close();
		System.out.println("* Cliente conectado: " + this.client.getInetAddress().getHostAddress() + "\n");
	}
	
	/**
	 * Executa uma requisição a partir da mensagem do cliente
	 * @param cmdMsg Mensagem recebida pelo cliente
	 * @throws ServerException Se houve algum erro previsto no
	 * contexto do servidor ao executar a requisição do cliente. 
	 * @throws IOException Se houve algum erro de I/O durante a 
	 * execução da requisição do cliente
	 */
	public void executeRequisition(CommandMessage cmdMsg)
			throws ServerException, IOException {
		
		CommandCode command = cmdMsg.getCommand();
		this.response = null;
		
		switch(command) {
		case LS:
			this.response = this.serverOperation.listDirContents();
			break;
			
		case CD:
			this.serverOperation.changeDir(cmdMsg.getArg0());
			break;
			
		case MV:
			this.serverOperation.moveFile(cmdMsg.getArg0(), cmdMsg.getArg1());
			break;
			
		case MKDIR:
			this.serverOperation.makeDir(cmdMsg.getArg0());
			break;
			
		case RMDIR:
			this.serverOperation.removeDir(cmdMsg.getArg0());
			break;
			
		case RM:
			this.serverOperation.removeFile(cmdMsg.getArg0());
			break;
			
		case CP:
			this.serverOperation.copyFile(cmdMsg.getArg0(), cmdMsg.getArg1());
			break;
			
		case CAT:
			this.response = this.serverOperation.catFile(cmdMsg.getArg0());
			break;
			
		case UPLOAD:
			byte[] fileContents = cmdMsg.getData().toByteArray();
			this.serverOperation.createFile(cmdMsg.getArg0(), fileContents);
			break;
			
		case DOWNLOAD:
			this.response = this.serverOperation.downloadFile(cmdMsg.getArg0());
			break;
			
		default:
			break;
		}
		
	}
	
	/**
	 * Responde ao cliente com uma mensagem de sucesso
	 * @throws IOException Se não foi possível criar o
	 * outputStream para o cliente
	 */
	public void respondSuccess() throws IOException {
		Message.ResponseMessage response;
		
		if(this.response != null) {
			ByteString data = ByteString.copyFrom(this.response);
			response = new ResponseMessage(StatusCode.SUCCESS, data);
		} else {
			response = new ResponseMessage(StatusCode.SUCCESS);
		}
		
		response.writeMessage(this.client.getOutputStream());
	}
	
	/**
	 * Responde ao cliente com uma mensagem de erro
	 * @param se Exceção gerada no servidor relativo ao erro
	 * @throws IOException Se não foi possível responder ao cliente
	 */
	public void respondFailure(ServerException se) throws IOException {
		Message.ResponseMessage response = new ResponseMessage(se.getErrorCode());
		response.writeMessage(this.client.getOutputStream());
	}

	@Override
	public void run() {
		int cmdId = 0;
		
		try {
			Message.CommandMessage msg = new CommandMessage();
			while(true) {
				try {
					// Ler mensagem do cliente
					msg.readMessage(this.getClient().getInputStream());
					if(Server.isEndMessage(msg)) {
						break;
					}
					
					cmdId = this.cmdId;
					this.cmdId++;
					
					System.out.println("[" + cmdId + "] " + "Comando recebido: " + msg.getCommand().name() +
							"    (" + this.client.getInetAddress().getHostAddress() + ")");
					
					// Executar requisição
					this.executeRequisition(msg);
					
					// Responder ao Cliente "sucesso"
					this.respondSuccess();
					System.out.println("[" + cmdId + "] " + msg.getCommand().name() + ": " + StatusCode.SUCCESS);
					
				} catch(ServerException se) {
					System.out.println("[" + cmdId + "] " + msg.getCommand().name() + ": ERRO (" + se.getErrorCode() + ")");
				
					// Retornar erro ao Cliente
					this.respondFailure(se);
				}
			}
			
			this.client.close();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Verifica se a mensagem contém dados a ser lido. Caso
	 * não seja, significa que a conexão foi encerrada.
	 * @param msg Mensagem lida do cliente
	 * @return true se a mensagem estiver vazia (fim da conexão)
	 */
	public static boolean isEndMessage(Message.CommandMessage msg) {
		return msg.getMessage() == null;
	}
	
	
	/*
	 * Getters & Setters
	 */
	
	public ServerSocket getServerSocket() {
		return serverSocket;
	}

	public void setServerSocket(ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
	}

	public Socket getClient() {
		return client;
	}

	public void setClient(Socket client) {
		this.client = client;
	}

	public int getPortNumber() {
		return PORTNUMBER;
	}

	public byte[] getResponse() {
		return response;
	}

	public void setResponse(byte[] response) {
		this.response = response;
	}
}
