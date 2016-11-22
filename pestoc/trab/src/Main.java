import java.io.IOException;

public class Main {

	public static void main(String[] args) {		
		try {
			if(args.length < 3) {
				System.out.println("Execute com os parâmetros em ordem:");
				System.out.println("1. Nome do arquivo de entrada");
				System.out.println("2. Nível de aprendizado da cadeia");
				System.out.println("3. Tamanho do texto de saída");
				return;
			}
			
			String fileName = args[0];
			int analysisLevel = Integer.parseInt(args[1]);
			int outputSize = Integer.parseInt(args[2]);
			
			MarkovChain markovChain = new MarkovChain(analysisLevel);
			markovChain.createFromFile(fileName);
			String text = markovChain.generateRandomText(outputSize);
			System.out.println(text);
			
		} catch (NumberFormatException e) {
			System.out.println("Argumentos inválidos. Use apenas números inteiros.");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
