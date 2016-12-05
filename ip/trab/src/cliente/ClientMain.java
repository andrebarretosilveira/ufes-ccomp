package cliente;

import java.io.IOException;
import java.util.Scanner;

/**
 * Classe principal do cliente, responsável pela
 * execução.
 * 
 * @author André Barreto
 * @author Igor Ventorim
 * @version 1.0
 *
 */
public class ClientMain {

	public static void main(String[] args) {
		String cmd;
		Scanner in = new Scanner(System.in);
		Client client = new Client();
		try {
			while(true)
			{
				try {
					System.out.print(client);
					cmd = in.nextLine();
					client.sendRequisition(cmd);
				} catch(ClientException ce) {
					System.out.println(ce.getErrorMsg());
				}
			}
			
		}  catch (IOException e) {
			e.printStackTrace();
		}
	}
}
