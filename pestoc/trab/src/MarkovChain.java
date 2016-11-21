import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public class MarkovChain {
	private Map<String, ArrayList<Character>> map;
	private int analysisLevel;
	private int outputSize;
	
	public MarkovChain(int analysisLevel, int outputSize) {
		this.map = new HashMap<String, ArrayList<Character>>();
		this.analysisLevel = analysisLevel;
		this.outputSize = outputSize;
	}
	
	public void createFromFile(String filePath) throws IOException {
		String fileContents = readFile(filePath);
		String word = null;
		for (int i = 0; i < fileContents.length() - analysisLevel + 1; i++) {
			word = fileContents.substring(i, i+analysisLevel);
			this.map.put(word, new ArrayList<Character>());
		}
		for (int i = 0; i < fileContents.length() - analysisLevel; i++) {
			word = fileContents.substring(i, i+analysisLevel);
			this.map.get(word).add(fileContents.charAt(i+analysisLevel));
		}
	}
	
	public void writeRandomText() {
		Random rand = new Random();
		int randomPos = rand.nextInt(map.size());
		String text = (String) map.keySet().toArray()[randomPos];
		int i;
		
		for (i = text.length(); i < outputSize; i++) {
			String key = text.substring(i-analysisLevel, i);
			ArrayList<Character> value = this.map.get(key);
			if(value == null || value.size() == 0) {
				randomPos = rand.nextInt(map.size());
				text += " " + (String) map.keySet().toArray()[randomPos];
				i += analysisLevel;
			} else {
				randomPos = rand.nextInt(value.size());
				char nextChar = value.get(randomPos);
				text += nextChar;
			}
		}
		
		System.out.println("[" + i + "]" + text);
	}
	
	private String readFile(String filePath) throws IOException {
		byte[] fileBytes = Files.readAllBytes(Paths.get(filePath));
		return new String(fileBytes);
	}
	
	public static void printMap(Map mp) {
	    Iterator it = mp.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        System.out.println(pair.getKey() + " = " + pair.getValue());
	    }
	}
	
	/*
	 * Getters & Setters
	 */

	public Map<String, ArrayList<Character>> getMap() {
		return map;
	}

	public void setMap(Map<String, ArrayList<Character>> map) {
		this.map = map;
	}

	public int getAnalysisLevel() {
		return analysisLevel;
	}

	public void setAnalysisLevel(int analysisLevel) {
		this.analysisLevel = analysisLevel;
	}

	public int getOutputSize() {
		return outputSize;
	}

	public void setOutputSize(int outputSize) {
		this.outputSize = outputSize;
	}
}
