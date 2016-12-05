package servidor;

import java.io.IOException;

/**
 * Classe principal do servidor,
 * responsável por sua execução.
 * 
 * @author André Barreto
 * @author Igor Ventorim
 * @version 1.0 *
 */
public class ServerMain {

	public static void main(String[] args) {
		
		while(true)
		{
			try {
				Server server = new Server();
				server.listenPort();
				Thread t = new Thread(server);
				t.start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
