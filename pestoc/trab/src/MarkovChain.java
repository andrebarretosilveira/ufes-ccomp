import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Objeto que reúne os métodos para a criação e geração de
 * texto aleatório através de um texto de exemplo.
 * @author dellief
 *
 */

public class MarkovChain {
	private Map<String, ArrayList<Character>> map;
	private int analysisLevel;
	
	/**
	 * Cria uma instância da classe {@link MarkovChain}, recebendo
	 * o parâmetro para definir o nível de aprendizado da cadeia.
	 * @param analysisLevel Nível do aprendizado ou tamanho das
	 * palavras do mapeamento.
	 */
	public MarkovChain(int analysisLevel) {
		this.map = new HashMap<String, ArrayList<Character>>();
		this.analysisLevel = analysisLevel;
	}
	
	/**
	 * Constrói o mapeamento palavra-letras que caracteriza a
	 * Cadeia de Markov através da leitura de um arquivo de texto.
	 * @param filePath Caminho do arquivo de texto
	 * @throws IOException Se houve erro ao ler o arquivo
	 */
	public void createFromFile(String filePath) throws IOException {
		String fileContents = readFile(filePath);
		String word = null;
		for (int i = 0; i < fileContents.length() - analysisLevel + 1; i++) {
			word = fileContents.substring(i, i+analysisLevel);
			if(!this.map.containsKey(word)) {
				this.map.put(word, new ArrayList<Character>());
			}
			else {
				this.map.get(word).add(fileContents.charAt(i+analysisLevel));
			}
		}
	}
	
	/**
	 * Realiza a geração do texto aleatório através da Cadeia de Markov,
	 * iniciando em um estado e mudando de estado, armazenando e
	 * incrementando o texto final com cada novo estado da cadeia.
	 * @return Texto aleatório gerado através da Cadeia de Markov.
	 */
	public String generateRandomText(int outputSize) {
		Random rand = new Random();
		int randomPos = rand.nextInt(map.size());
		Object[] mapStrings = (Object[]) map.keySet().toArray();
		String text = (String) mapStrings[randomPos];
		
		for (int i = text.length(); i < outputSize; i++) {
			String key = text.substring(i-analysisLevel, i);
			ArrayList<Character> value = this.map.get(key);
			if(value == null || value.size() == 0) {
				randomPos = rand.nextInt(map.size());
				text += " " + (String) mapStrings[randomPos];
				i += analysisLevel;
			} else {
				randomPos = rand.nextInt(value.size());
				char nextChar = value.get(randomPos);
				text += nextChar;
			}
		}
		
		return text;
	}
	
	/**
	 * Realiza a leitura completa de um arquivo e o
	 * converte em uma string
	 * @param filePath Caminho do arquivo
	 * @return Conteúdo do arquivo como string
	 * @throws IOException Se não foi possível ler o arquivo
	 */
	private String readFile(String filePath) throws IOException {
		byte[] fileBytes = Files.readAllBytes(Paths.get(filePath));
		return new String(fileBytes);
	}
}
