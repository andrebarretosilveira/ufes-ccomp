import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
		System.out.println(fileContents);
	}
	
	private String readFile(String filePath) throws IOException {
		byte[] fileBytes = Files.readAllBytes(Paths.get(filePath));
		return new String(fileBytes);
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
