package cliente;

import java.io.IOException;
import java.util.Scanner;
import utilitarios.CommandCode;
import utilitarios.Message;
import utilitarios.StatusCode;
/**
 * Classe responsável por realizar a comunicação
 * entre a interface e as operações do cliente. 
 * 
 * @author André Barreto
 * @author Igor Ventorim
 * @version 1.0
 */
public class Client {
	private final int PORT = 8888;
	private boolean isLogged;
	private Scanner in;
	private Message.ResponseMessage response;
	private ClientOperation clientOperation;

	/**
	 * Constructor
	 */
	public Client() {
		this.isLogged = false;
		this.in = new Scanner(System.in);
		this.clientOperation = new ClientOperation();
		
	}
	
	/**
	 * Método responsável por receber o comando a ser 
	 * enviado e enviá-lo para a operação ser realizada.
	 * @param cmd Comando a ser enviado.
	 * @throws ClientException
	 * @throws IOException
	 */
	public void sendRequisition(String cmd) throws ClientException, IOException {
		String[] requisition = buildIn(cmd);
		clientOperation.rebuildStrings(requisition);
		CommandCode code = CommandCode.getCode(requisition[0]);
		StatusCode status = null;

		switch(code)
		{
			case OPEN:
				
				if(requisition.length == 2)
				{
					clientOperation.openConnection(requisition[1], PORT);
					if(clientOperation.getClientSocket().isConnected())
					{ 
						isLogged = true; 
						System.out.println("Connected to "+requisition[1]+".");
					}
				}else
				{
					throw new ClientException("Erro de parâmetro informe: open <ip ou nome da máquina>"
							+ ",ex.: open 127.0.0.1");
				}
				break;
			
			case LS:
				if(!isLogged){System.out.println(new String (clientOperation.listDirContents())); break;}
				clientOperation.sendMessage(CommandCode.LS);
				response = new Message.ResponseMessage();
			 	response.readMessage(clientOperation.getClientSocket().getInputStream());
			 	
			 	status = response.getStatusCode();
				if(status != StatusCode.SUCCESS) {
					throw new ClientException("Erro ao listar diretório: " + status.toString());
				}
				 
			 	System.out.println(response.getString());
				break;
				
			case CD:
				if(requisition.length >= 2)
				{
					if(!isLogged){ clientOperation.changeDirLocal(requisition[1]); break;}
					clientOperation.sendMessage(CommandCode.CD,requisition[1]);
					response = new Message.ResponseMessage();
				 	response.readMessage(clientOperation.getClientSocket().getInputStream());
				 	
				 	status = response.getStatusCode();
					if(status != StatusCode.SUCCESS) {
						throw new ClientException("Erro ao mudar diretório: " + status.toString());
					}
				}
				
				break;
				
			case MV:
				if(requisition.length >= 3)
				{
					clientOperation.sendMessage(CommandCode.MV,requisition[1],requisition[2]);
					response = new Message.ResponseMessage();
					response.readMessage(clientOperation.getClientSocket().getInputStream());
					 
					status = response.getStatusCode();
					if(status != StatusCode.SUCCESS) {
						throw new ClientException("Erro ao mover arquivo: " + status.toString());
					}
				}
				break;
				
			case MKDIR:
				if(requisition.length >= 2)
				{
					clientOperation.sendMessage(CommandCode.MKDIR,requisition[1]);
					response = new Message.ResponseMessage();
				 	response.readMessage(clientOperation.getClientSocket().getInputStream());
				 	
				 	status = response.getStatusCode();
					if(status != StatusCode.SUCCESS) {
						throw new ClientException("Erro ao criar diretório: " + status.toString());
					}
				}
				
				break;
				
			case RMDIR:
				if(requisition.length >= 2)
				{
					clientOperation.sendMessage(CommandCode.RMDIR,requisition[1]);
					response = new Message.ResponseMessage();
				 	response.readMessage(clientOperation.getClientSocket().getInputStream());
				 	
				 	status = response.getStatusCode();
					if(status != StatusCode.SUCCESS) {
						throw new ClientException("Erro ao remover diretório: " + status.toString());
					}
				}
				
				break;
				
			case RM:
				if(requisition.length >= 2)
				{
					clientOperation.sendMessage(CommandCode.RM,requisition[1]);
					response = new Message.ResponseMessage();
				 	response.readMessage(clientOperation.getClientSocket().getInputStream());
				 	
				 	status = response.getStatusCode();
					if(status != StatusCode.SUCCESS) {
						throw new ClientException("Erro ao remover arquivo: " + status.toString());
					}
				}

				break;
				
			case CAT:
				if(requisition.length >= 2)
				{
					if(!isLogged){System.out.println(new String(clientOperation.uploadFile(requisition[1])));break;}
					clientOperation.sendMessage(CommandCode.CAT,requisition[1]);
					response = new Message.ResponseMessage();
				 	response.readMessage(clientOperation.getClientSocket().getInputStream());
				 	
				 	status = response.getStatusCode();
					if(status != StatusCode.SUCCESS) {
						throw new ClientException("Erro ao ler arquivo: " + status.toString());
					}
					
				 	System.out.println(response.getBytes().toStringUtf8());
				}
				
				break;
				
			case DOWNLOAD:
				if(requisition.length == 2)
				{
					clientOperation.sendMessage(CommandCode.DOWNLOAD,requisition[1]);
					response = new Message.ResponseMessage();
				 	response.readMessage(clientOperation.getClientSocket().getInputStream());
				 	
				 	status = response.getStatusCode();
					if(status != StatusCode.SUCCESS) {
						throw new ClientException("Erro ao baixar arquivo: " + status.toString());
					}
					
			 		clientOperation.createFile(requisition[1], response.getBytes().toByteArray());
					
				}
				break;
				
			case UPLOAD:
				if(requisition.length == 2)
				{
					byte[] file = clientOperation.uploadFile(requisition[1]);
					clientOperation.sendMessage(CommandCode.UPLOAD,requisition[1],file);
					response.readMessage(clientOperation.getClientSocket().getInputStream());
					status = response.getStatusCode();
					if(status != StatusCode.SUCCESS) {
						throw new ClientException("Erro ao copiar arquivo: " + status.toString());
					}
				}
				break;
				
			case CP:
				if(requisition.length >= 3)
				{
					clientOperation.sendMessage(CommandCode.CP,requisition[1],requisition[2]);
					response = new Message.ResponseMessage();
				 	response.readMessage(clientOperation.getClientSocket().getInputStream());

				 	status = response.getStatusCode();
					if(status != StatusCode.SUCCESS) {
						throw new ClientException("Erro ao copiar arquivo: " + status.toString());
					}
				}

				break;
				
			case LCD:
				if(requisition.length >= 2)
				{
					clientOperation.changeDirLocal(requisition[1]);
				}
					
				break;
				
			case LPWD:
				if(!isLogged){break;}
				System.out.println(clientOperation.getCurrentDir());
				break;
				
			case LLS:
				if(!isLogged){break;}
				System.out.println(new String (clientOperation.listDirContents()));
				break;
				
			case CLOSE:
				if(!isLogged){break;}
				clientOperation.getClientSocket().close();
				isLogged = false;
				break;
				
			case CLEAR:
				clientOperation.clearConsole();
				break;
				
			case EXIT:
				if(!isLogged){Runtime.getRuntime().exit(0);}
				break;
					
			case MAN:
				Runtime.getRuntime().exec("man ./utilitarios/man");
				break;
			default:
				throw new ClientException("Comando inválido!");
				
		}
	}


	/* Getters & Setters */
	
	public boolean isLogged() {
		return isLogged;
	}

	public void setLogged(boolean isLogged) {
		this.isLogged = isLogged;
	}

	public Scanner getIn() {
		return in;
	}

	public void setIn(Scanner in) {
		this.in = in;
	}

	public Message.ResponseMessage getResponse() {
		return response;
	}

	public void setResponse(Message.ResponseMessage response) {
		this.response = response;
	}

	public ClientOperation getClientOperations() {
		return clientOperation;
	}

	public void setClientOperations(ClientOperation clientOperations) {
		this.clientOperation = clientOperations;
	}

	public int getPORT() {
		return PORT;
	}
	
	@Override
	public String toString()
	{
		if(!this.isLogged()) {
			return "Client:~"+this.getClientOperations().getCurrentDir()+"$ ";
			
		} else {
			return "ftp> ";
		}
	}
	
	/**
	 * Responsável por repartir a mensagem em suas partes
	 * relevantes para ser enviado para o comando apropriado.
	 * @param cmd Comando a ser enviado para o servidor.
	 * @return Partes da mensagem, separando comando de parâmetros.
	 */
	private String[] buildIn(String cmd)
	{
		cmd = cmd.replace("\\ ", "///");
		return cmd.split(" ");
		
	}
}
