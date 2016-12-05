package cliente;

/**
 * Classe que trata as exceções geradas pelo cliente.
 * 
 * @author André Barreto
 * @author Igor Ventorim
 * @version 1.0
 *
 */
public class ClientException extends Exception {
	private static final long serialVersionUID = 7595161066898959840L;
	
	private String errorMsg;

	public ClientException(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
}
