import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		try {
			MarkovChain markovChain = new MarkovChain(2, 10);
			markovChain.createFromFile("hamlet.txt");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
