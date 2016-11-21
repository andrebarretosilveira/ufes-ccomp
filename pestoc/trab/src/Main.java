import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		try {
			MarkovChain markovChain = new MarkovChain(2, 100);
			markovChain.createFromFile("blah.txt");
//			MarkovChain.printMap(markovChain.getMap());
			markovChain.writeRandomText();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
