package servidor;

import java.util.Arrays;
import utilitarios.StatusCode;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Classe que contém todas as operações referentes
 * ao domínio do problema no lado do servidor.
 * 
 * @author André Barreto
 * @author Igor Ventorim
 * @version 1.0
 */
public class ServerOperation {
	private File currentDir;

	/**
	 * Construtor de ServerOperations
	 * Faz o diretório atual ser o diretório pessoal do usuário
	 * que executou o servidor
	 */
	public ServerOperation() {
		this.currentDir = new File(System.getProperty("user.home"));
	}

	/**
	 * Lista o conteúdo do diretório atual 'currentDir'
	 * @throws ServerException Se não foi possível listar os arquivos
	 */
	public byte[] listDirContents() throws ServerException {
		// Verifica permissão de leitura
		if(!this.currentDir.canRead()) {
			throw new ServerException(StatusCode.ERR_PERMISS);
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
	 * Muda o diretório atual onde o servidor se encontra
	 * @param path Caminho do diretório alvo
	 * @throws ServerException Se não foi possível mudar o diretório
	 */
	public void changeDir(String path) throws ServerException {
		if(path != null) {
			File targetDir = makeFileFromPath(path);
			
			if(!targetDir.isDirectory()) {
				throw new ServerException(StatusCode.ERR_ARGS);
			}
			else {
				// Verifica permissão de leitura
				if(!targetDir.canRead()) {
					throw new ServerException(StatusCode.ERR_PERMISS);
				}
				
				this.currentDir = targetDir;
			}
		}
	}
	
	/**
	 * Move um arquivo para outro caminho
	 * @param pathSrc Caminho do arquivo
	 * @param pathDest Caminho destino do arquivo
	 * @throws ServerException Se houve erro ao mover
	 */
	public void moveFile(String pathSrc, String pathDest) throws ServerException {
		this.copyFile(pathSrc, pathDest);
		this.removeFile(pathSrc);
	}
	
	/**
	 * Cria um novo diretório com o caminho especificado
	 * @param path Caminho do novo diretório
	 * @throws ServerException Se não foi possível criar o diretório
	 */
	public void makeDir(String path) throws ServerException {
		File newDir = makeFileFromPath(path);
		File parent = newDir.getParentFile();
		
		// Verifica permissões de leitura e escrita para
		// criar o diretório
		if(!parent.canWrite() || !parent.canRead()) {
			throw new ServerException(StatusCode.ERR_PERMISS);
		}
		else {
			if(!newDir.mkdirs()) {
				throw new ServerException(StatusCode.ERR_DESC);
			}
		}
	}
	
	/**
	 * Remove o diretório especificado por um caminho
	 * @param path Caminho do diretório alvo
	 * @throws ServerException Se não foi possível remover o diretório
	 */
	public void removeDir(String path) throws ServerException {
		File file = makeFileFromPath(path);
		
		if(!file.isDirectory()) {
			throw new ServerException(StatusCode.ERR_ARGS);
		}
		else {
			if(!file.canWrite() || !file.canRead()) {
				throw new ServerException(StatusCode.ERR_PERMISS);
			}
			
			rmdir(file);
		}
	}
	
	/**
	 * Remove o arquivo especificado por um caminho
	 * @param path Caminho do arquivo alvo
	 * @throws ServerException Se não foi possível remover o arquivo
	 */
	public void removeFile(String path) throws ServerException {
		File file = makeFileFromPath(path);
		
		if(!file.isFile()) {
			throw new ServerException(StatusCode.ERR_ARGS);
		}
		else {
			// Verifica permissão de escrita
			if(!file.canWrite()) {
				throw new ServerException(StatusCode.ERR_PERMISS);
			}
			
			// Tenta remover o arquivo
			if(!file.delete()) {
				throw new ServerException(StatusCode.ERR_DESC);
			}
		}
	}
	
	/**
	 * Faz a copia do conteúdo de um arquivo para outro
	 * @param pathSrc Caminho do arquivo de origem
	 * @param pathDest Caminho do arquivo destino
	 * @throws ServerException Se ocorreu algum erro na cópia
	 */
	public void copyFile(String pathSrc, String pathDest) throws ServerException {
		File fileSrc  = makeFileFromPath(pathSrc);
		File fileDest = makeFileFromPath(pathDest);
		
		try {
			if(fileSrc.isDirectory() || !fileSrc.isFile()) {
				throw new ServerException(StatusCode.ERR_ARGS);
			}
			else if(fileDest.isDirectory()) {
				if(!fileDest.canWrite()) {
					throw new ServerException(StatusCode.ERR_PERMISS);
				}
				fileDest = new File(fileDest.getPath() + "/" + fileSrc.getName());
				fileDest.createNewFile();
				cp(fileSrc, fileDest);
			}
			else {
				cp(fileSrc, fileDest);
			}
						
		} catch(IOException e) {
			throw new ServerException(StatusCode.ERR_DESC);
		}
		
	}
	
	/**
	 * Le conteúdo de um arquivo para ser enviado ao cliente
	 * @param path Caminho do arquivo alvo
	 * @return Conteúdo do arquivo em string
	 * @throws ServerException Se não foi possível ler o arquivo
	 */
	public byte[] catFile(String path) throws ServerException {
		return downloadFile(path);
	}

	/**
	 * Le conteúdo de um arquivo para ser enviado ao cliente
	 * @param path Caminho do arquivo alvo
	 * @return Conteúdo do arquivo em string
	 * @throws ServerException Se não foi possível ler o arquivo
	 */
	public byte[] downloadFile(String path) throws ServerException {
		File file = makeFileFromPath(path);
		byte[] fileContents = null;
		InputStream is = null;
		
		try {
			if(!file.isFile()) {
				throw new ServerException(StatusCode.ERR_ARGS);
			}
			else {
				// Verifica permissão de leitura
				if(!file.canRead()) {
					throw new ServerException(StatusCode.ERR_PERMISS);
				}
				
				// Pegando o conteúdo do arquivo
				fileContents = new byte[(int) file.length()];
				is = new FileInputStream(file);
				is.read(fileContents);
				is.close();
				
				return fileContents;
			}
		
		} catch (IOException e) {
			throw new ServerException(StatusCode.ERR_DESC);
		}
	}
	
	/**
	 * Cria um arquivo no caminho indicado e adiciona seu conteúdo
	 * @param path Caminho para criar o arquivo
	 * @param fileContents Conteúdo para inserir no arquivo
	 * @throws ServerException Se houve erro ao criar o arquivo
	 */
	public void createFile(String path, byte[] fileContents) throws ServerException {
		File newFile = makeFileFromPath(path);
		OutputStream os = null;
		
		if(!newFile.getParentFile().canWrite()) {
			throw new ServerException(StatusCode.ERR_PERMISS);
		}
		
		try {
			newFile.createNewFile();
			os = new FileOutputStream(newFile);
			os.write(fileContents, 0, fileContents.length);
			os.close();
			
		} catch (IOException e) {
			throw new ServerException(StatusCode.ERR_DESC);
		}
	}
	
	/**
	 * Constrói um novo File para manipulação de um arquivo
	 * de acordo com o caminho do arquivo e o caminho onde
	 * se encontra o servidor atualmente
	 * @param currentDir Diretório atual do servidor
	 * @param path Caminho para um arquivo
	 * @return File do arquivo denotado pelo caminho path
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
	 * Efetua a remoção do diretório 'dir', removendo antes
	 * todos os arquivos e diretórios recursivamente que
	 * estão contidos pelo diretório 'dir'
	 * @param dir Diretório a ser removido
	 * @throws ServerException Se não foi possível remover o diretório
	 */
	private static void rmdir(File dir) throws ServerException {
		File[] contents = dir.listFiles();
		
		// Loop para remover os arquivos e diretórios dentro
		// do diretório alvo para depois deletá-lo
		for (File f : contents) {
			if(f.isDirectory()) {
				rmdir(f);
			}
			else {
				f.delete();
			}
		}
		
		// Tenta remover o diretório
		if(!dir.delete()) {
			throw new ServerException(StatusCode.ERR_DESC);
		}
	}

	/**
	 * Efetua a cópia do conteúdo de um arquivo para outro
	 * por meio de FileStreams
	 * @param source Arquivo origem do conteúdo
	 * @param dest Arquivo destino do conteúdo
	 * @throws IOException Se houve erro ao copiar
	 */
	private static void cp(File source, File dest) throws IOException {
	    InputStream is = null;
	    OutputStream os = null;
	    try {
	        is = new FileInputStream(source);
	        os = new FileOutputStream(dest);
	        byte[] buffer = new byte[1024];
	        int length;
	        while ((length = is.read(buffer)) > 0) {
	            os.write(buffer, 0, length);
	        }
	    } finally {
	        is.close();
	        os.close();
	    }
	}
	
	/* 
	 * Getters & Setters
	 */
	
	public File getCurrentDir() {
		return currentDir;
	}

	public void setCurrentDir(File currentDir) {
		this.currentDir = currentDir;
	}
}
