package utilitarios;

/**
 * ENUM que contém os códigos de comandos
 * que podem ser enviados em uma transação
 * cliente servidor.
 * 
 * @author André Barreto
 * @author Igor Ventorim
 * @version 1.0
 *
 */
public enum CommandCode {	
	LS(0),
	CD(1),
	MV(2),
	MKDIR(3),
	RMDIR(4),
	RM(5),
	CP(6),
	CAT(7),
	UPLOAD(8),
	DOWNLOAD(9),
	OPEN(10),
	CLOSE(11),
	LCD(12),
	LPWD(13),
	LLS(14),
	CLEAR(15),
	EXIT(16),
	MAN(17),
	ERRO(-1);
	
	private int value;
	CommandCode(int value) {
		// TODO Auto-generated constructor stub
		this.value = value;
	}
	
	public int getValue()
	{
		return value;
	}
	
	// Vetor que associa posição(int) com um Comando
	private static CommandCode[] allValues = values();
	
	/**
	 * Converte um inteiro para um comando
	 * @param n Valor de um comando
	 * @return CommandCode associado ao inteiro
	 */
    public static CommandCode fromInt(int n) {
    	return allValues[n];
    }
	
	/**
	 * 
	 * Retorna o commandcode correspondente a string de entrada
	 * @param cmd String com o comando a se descobrir o commandcode
	 * @return Commandcode
	 */
	public static CommandCode getCode(String cmd)
	{
		for (CommandCode cc : CommandCode.values()) 
		{
			if(cc.name().equals(cmd.toUpperCase())){ return cc; }
		}
		
		return ERRO;
	}
	
	/**
	 * 
	 * Retorna o commandcode correspondente ao número de entrada
	 * @param cmd Inteiro com o comando a se descobrir o commandcode
	 * @return Commandcode
	 */
	public static CommandCode getCode(int cmd)
	{
		for (CommandCode cc : CommandCode.values()) 
		{
			if(cc.value == cmd){ return cc; }
		}
		
		return ERRO;
	}
	

}
