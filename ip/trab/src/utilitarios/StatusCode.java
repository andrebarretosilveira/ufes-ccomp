package utilitarios;

/**
 * ENUM que contém os códigos de respostas
 * que podem ser retornados em uma transação
 * cliente servidor.
 * 
 * @author André Barreto
 * @author Igor Ventorim
 * @version 1.0
 *
 */
public enum StatusCode {	
	SUCCESS(0),
	ERR_PERMISS(1),
	ERR_ARGS(2),
	ERR_DESC(3);
	
	
	private final int valor;

	StatusCode(int valor)
	{
		this.valor = valor;
	}
	
	public int getValue()
	{
		return valor;
	}
	
	/**
	 * Associa o ENUM correspondente ao número informado.
	 * @param code código que se deseja saber o ENUM.
	 * @return ENUM associado ao código informado.
	 */
	public static StatusCode getStatusCode(int code)
	{
		return StatusCode.values()[code];
	}
	

}