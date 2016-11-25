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
			long tStart = System.currentTimeMillis();
			
			String fileName = args[0];
			int analysisLevel = Integer.parseInt(args[1]);
			int outputSize = Integer.parseInt(args[2]);
			
			MarkovChain markovChain = new MarkovChain(analysisLevel);
			markovChain.createFromFile(fileName);
			String text = markovChain.generateRandomText(outputSize);
			System.out.println(text);
			
			long tEnd = System.currentTimeMillis();
			long tDelta = tEnd - tStart;
			double elapsedSeconds = tDelta / 1000.0;
			
			System.out.println("Tempo: " + elapsedSeconds + "s");
			
		} catch (NumberFormatException e) {
			System.out.println("Argumentos inválidos. Use apenas números inteiros.");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
