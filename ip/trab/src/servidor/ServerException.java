package servidor;

import utilitarios.StatusCode;

/**
 * Classe responsável por tratar as exceções que
 * ocorrerem no servidor.
 * 
 * @author André Barreto
 * @author Igor Ventorim
 * @version 1.0@author igor
 *
 */
public class ServerException extends Exception {
	private StatusCode statusCode;

	private static final long serialVersionUID = 3280525997901491352L;
	
	public ServerException(StatusCode statusCode) {
		this.statusCode = statusCode;
	}
	
	/* 
	 * Getters & Setters 
	 */
	
	public StatusCode getErrorCode() {
		return statusCode;
	}

	public void setErrorCode(StatusCode statusCode) {
		this.statusCode = statusCode;
	}
}