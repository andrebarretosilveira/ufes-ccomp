package cliente;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;
import utilitarios.CommandCode;
import utilitarios.Message;
import utilitarios.Message.CommandMessage;

/**
 * Classe de operações do cliente, responsável
 * por tratar todas as funções correspondentes
 * ao domínio do problema.
 * 
 * @author André Barreto
 * @author Igor Ventorim
 * @version 1.0
 *
 */
public class ClientOperation {
	
	private File currentDir;
	private Socket clientSocket = new Socket();

	public ClientOperation() {
		this.currentDir = new File(System.getProperty("user.home"));
	}
	
	/**
	 * Inicializa a conexão via socket
	 * @param ipServer
	 * @param port
	 * @return true caso não tenha gerado nenhum exceção caso contrário false
	 * @throws ClientException Se não foi possível abrir uma conexão
	 */
	public void openConnection(String ipServer, int port) throws ClientException
	{
		try {
			clientSocket = new Socket(ipServer,port);
			
		} catch(Exception e) {
			throw new ClientException("Erro ao abrir conexão.");
		}
	}
		
	/**
	 * Método que faz o procedimento necessário para o
	 * envio de mensagens via protocolo buffer
	 * @param type Tipo do comando a ser enviado
	 * @throws ClientException Se não foi possível enviar a mensagem
	 */
	public void sendMessage(CommandCode type) throws ClientException
	{
		try {			
			Message.CommandMessage msg = new CommandMessage(type);
			if(clientSocket.isClosed())
			{
				throw new ClientException("Erro ao enviar mensagem: socket fechado.");
			}
			
			msg.writeMessage(clientSocket.getOutputStream());
			
		} catch (IOException e) {
			throw new ClientException("Erro ao enviar mensagem, verifique a conexão com o servidor!");
		}
		
	}
	
	/**
	 * Método que faz o procedimento necessário para o
	 * envio de mensagens via protocolo buffer
	 * @param type Tipo do comando a ser enviado
	 * @param arg0 Argumento 0 em string
	 * @throws ClientException Se não foi possível enviar a mensagem
	 */
	public void sendMessage(CommandCode type, String arg0) throws ClientException
	{
		try {			
			Message.CommandMessage msg = new CommandMessage(type,arg0);
			if(clientSocket.isClosed())
			{
				throw new ClientException("Erro ao enviar mensagem: socket fechado.");
			}
			
			msg.writeMessage(clientSocket.getOutputStream());
			
		} catch (IOException e) {
			throw new ClientException("Erro ao enviar mensagem.");
		}
		
	}
	
	/**
	 * Método que faz o procedimento necessário para o
	 * envio de mensagens via protocolo buffer
	 * @param type Tipo do comando a ser enviado
	 * @param arg0 Argumento 0 em string
	 * @param arg1 Argumento 1 em string
	 * @throws ClientException Se não foi possível enviar a mensagem
	 */
	public void sendMessage(CommandCode type, String arg0, String arg1) throws ClientException
	{
		try {			
			Message.CommandMessage msg = new CommandMessage(type,arg0,arg1);
			if(clientSocket.isClosed())
			{
				throw new ClientException("Erro ao enviar mensagem: socket fechado.");
			}
			
			msg.writeMessage(clientSocket.getOutputStream());
			
		} catch (IOException e) {
			throw new ClientException("Erro ao enviar mensagem.");
		}
		
	}
	
	/**
	 * Método que faz o procedimento necessário para o
	 * envio de mensagens via protocolo buffer
	 * @param type Tipo do comando a ser enviado
	 * @param arg0 Argumento 0 em string
	 * @param data Argumento 1 em bytes
	 * ou false caso contrário.
	 */
	public void sendMessage(CommandCode type, String arg0, byte[] data) throws ClientException
	{
		try {			
			Message.CommandMessage msg = new CommandMessage(type,arg0,data);
			if(clientSocket.isClosed())
			{
				throw new ClientException("Erro ao enviar mensagem: socket fechado.");
			}
			
			msg.writeMessage(clientSocket.getOutputStream());
			
		} catch (IOException e) {
			throw new ClientException("Erro ao enviar mensagem.");
		}
		
	}
	
	/**
	 * Muda o diretório atual onde se encontra
	 * @param path Caminho do diretório alvo
	 * @throws ClientException Se não foi possível mudar o diretório
	 */
	public void changeDirLocal(String path) throws ClientException {
		if(path != null) {
			File targetDir = makeFileFromPath(path);
			if(!targetDir.isDirectory()) {
				throw new ClientException("Erro ao mudar de diretório: '" +
						targetDir.getName() + "' não é um diretório.");
			}
			else if(path.startsWith("..")) {
				this.currentDir = this.currentDir.getParentFile();
				if(path.length() > 2) {
					path = path.substring(2, path.length());
					this.changeDirLocal(path);
				}
			}
			else {
				this.currentDir = new File(this.currentDir + "/" + path);
			}
		}
	}
	
	/**
	 * Cria um arquivo no caminho indicado e adiciona seu conteúdo
	 * @param path Caminho para criar o arquivo
	 * @param fileContents Conteúdo para inserir no arquivo
	 * @throws ClientException Se houve erro ao criar o arquivo
	 */
	public void createFile(String path, byte[] fileContents) throws ClientException {
		File newFile = makeFileFromPath(path);
		OutputStream os = null;
		
		if(!newFile.getParentFile().canWrite()) {
			throw new ClientException("Erro ao criar arquivo: sem permissão.");
		}
		
		try {
			newFile.createNewFile();
			os = new FileOutputStream(newFile);
			os.write(fileContents, 0, fileContents.length);
			os.close();
			
		} catch (IOException e) {
			throw new ClientException("Erro ao criar arquivo.");
		}
	}
	
	/**
	 * Lista o conteúdo do diretório atual 'currentDir'
	 * @return Lista de bytes com o conteúdo do diretório
	 * @throws ClientException Se não foi possível listar os arquivos
	 */
	public byte[] listDirContents() throws ClientException{
		// Verifica permissão de leitura
		if(!this.currentDir.canRead()) {
			throw new ClientException("Erro ao listar arquivos do diretório: sem permissão.");
		}
		
		String list = "";
		File[] listOfFiles = this.currentDir.listFiles();
		Arrays.sort(listOfFiles);
		
		for (int i = 0; i < listOfFiles.length; i++) {
			File file = listOfFiles[i];
			if(!file.isHidden()) {
				list += file.getName() + "\n";
			}
		}
		if(list.length() >= 1) {
			list = list.substring(0, list.length()-1);
		}
		
		return list.getBytes();
	}
	
	/**
	 * Constrói um novo File para manipulação de um arquivo
	 * de acordo com o caminho do arquivo e o caminho onde
	 * se encontra atualmente
	 * @param path Caminho para um arquivo
	 * @returnFile do arquivo denotado pelo caminho path
	 */
	private File makeFileFromPath(String path) {
		if(path.startsWith("/")) {
			return new File(path);
		}
		else {
			return new File(this.currentDir.getPath() + "/" + path);
		}
	}
	
	/**
	 * Responsável por pegar o caminho atual que se encontra
	 * @return String com o caminho local
	 */
	public String getCurrentDir()
	{
		return currentDir.getPath();
	}
	
	public Socket getClientSocket()
	{
		return clientSocket;
	}
	
	/**
	 * Le conteúdo de um arquivo para ser enviado ao cliente
	 * @param path Caminho do arquivo alvo
	 * @return Conteúdo do arquivo em bytes
	 * @throws ClientException Se não foi possível ler o arquivo par upload
	 */
	public byte[] uploadFile(String path) throws ClientException {
		File file = makeFileFromPath(path);
		byte[] fileContents = null;
		InputStream is = null;
		
		try {
			if(!file.isFile()) {
				throw new ClientException("Falha ao ler arquivo informado: não é um arquivo.");
			}
			else {
				// Verifica permissão de leitura
				if(!file.canRead()) {
					throw new ClientException("Falha ao ler arquivo: sem permissão.");
				}
				
				// Pegando o conteúdo do arquivo
				fileContents = new byte[(int) file.length()];
				is = new FileInputStream(file);
				is.read(fileContents);
				is.close();
				
				return fileContents;
			}
			
		} catch (IOException e) {
			throw new ClientException("Falha ao ler arquivo");
		}
	}

	/**
	 * Limpa o console
	 * @throws IOException Se houve algum erro ao limpar o console
	 */
	public void clearConsole() throws IOException{

        final String os = System.getProperty("os.name");

        if (os.contains("Windows")){
            Runtime.getRuntime().exec("cls");

        }else{
            Runtime.getRuntime().exec("clear");
        }
    }
	
	public boolean isClose()
	{
		return clientSocket.isClosed();
	}

	/**
	 * Responsável por reconstruir os parâmetros enviados
	 * com espaço.
	 * @param parts Comando enviado particionado por espaços
	 * @return Comando enviado reconstruído parâmetros com espaços
	 */
	public String[] rebuildStrings(String[] parts)
	{
		for (int i = 0; i < parts.length; i++) {
			parts[i] = parts[i].replace("///", " ");
		}
		
		return parts;
	}
	
}
