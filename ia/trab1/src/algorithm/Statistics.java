package algorithm;

import java.util.ArrayList;
import java.util.List;

import jmetal.core.Solution;
import jmetal.core.Variable;
import jmetal.util.JMException;

public class Statistics {
	private PSOAlgorithm pso;
	
	// Estatísticas dos números de avaliações
	private List<Integer>  evaluations;
	private int            minEvaluation, maxEvaluation;
	private double         meanEvaluation, evaluationSD;
	
	// Estatísticas dos tempos de execução do algoritmo
	private List<Long>     executionTimes;
	private long           minExecutionTime, maxExecutionTime;
	private double         meanExecutionTime, executionTimeSD;
	
	// Estatísticas das melhores soluções encontradas
	private List<Solution> bestSolutions;
	private double         minBestSolution, maxBestSolution;
	private double         meanBestSolution, bestSolutionSD;
	private double[]       meanBestSolutionCoord;
	
	public Statistics(PSOAlgorithm pso) {
		this.pso = pso;
		this.evaluations = new ArrayList<Integer>();
		this.executionTimes = new ArrayList<Long>();
		this.bestSolutions = new ArrayList<Solution>();
	}

	public void generateReport() throws JMException {
		this.setEvaluationStats();
		this.setExecutionStats();
		this.setSolutionStats();
		
		String coordenadas = "[";
		for (int i = 0; i < meanBestSolutionCoord.length; i++) {
			coordenadas += this.meanBestSolutionCoord[i] + " ";
		}
		coordenadas += "]";
		
		System.out.println(this.pso.getProblem().getName().toUpperCase());
		
//		System.out.println(this.evaluations.toString());
		System.out.println("- Avaliações:");
		System.out.println("  - Número médio de avaliações:   " + this.meanEvaluation);
		System.out.println("  - Número mínimo de avaliações:  " + this.minEvaluation);
		System.out.println("  - Número máximo de avaliações:  " + this.maxEvaluation);
		System.out.println("  - Desvio padrão:                " + this.evaluationSD);
		
//		System.out.println(this.executionTimes.toString());
		System.out.println("- Tempos de Execução:");
		System.out.println("  - Tempo médio de execução:      " + this.meanExecutionTime + " ms");
		System.out.println("  - Tempo mínimo de execução:     " + this.minExecutionTime + " ms");
		System.out.println("  - Tempo máximo de execução:     " + this.maxExecutionTime + " ms");
		System.out.println("  - Desvio padrão:                " + this.executionTimeSD + " ms");
		
//		System.out.println(this.bestSolutions.toString());
		System.out.println("- Ótimos encontrados:");
		System.out.println("  - Valor médio dos ótimos:       " + this.meanBestSolution);
		System.out.println("  - Valor mínimo dos ótimos:      " + this.minBestSolution);
		System.out.println("  - Valor máximo dos ótimos:      " + this.maxBestSolution);
		System.out.println("  - Desvio padrão:                " + this.bestSolutionSD);
		System.out.println("  - Média das coordenadas:        " + coordenadas);
	}
	
	public void setEvaluationStats() {
		int max, min;
		double mean = 0;
		double sd = 0;
		int arraySize = this.evaluations.size();
		
		max = min = this.evaluations.get(0);
		
		// Loop para encontrar o mínimo, máximo e
		// o valor médio do conjunto de valores
		for (Integer evaluation : this.evaluations) {
			mean += evaluation;
			
			if(evaluation > max) {
				max = evaluation;
			}
			else if(evaluation < min) {
				min = evaluation;
			}
		}
		mean = mean/arraySize;
		
		// Loop para calcular o desvio-padrão
		for (Integer evaluation : this.evaluations) {
			sd += Math.pow((evaluation - mean), 2);
		}
		sd = Math.sqrt(sd/arraySize);
		
		
		this.maxEvaluation = max;
		this.minEvaluation = min;
		this.meanEvaluation = mean;
		this.evaluationSD = sd;
	}
	
	public void setExecutionStats()	{
		long max, min;
		double mean = 0;
		double sd = 0;
		int arraySize = this.executionTimes.size();
		
		max = min = this.executionTimes.get(0);
		
		// Loop para encontrar o mínimo, máximo e
		// o valor médio do conjunto de valores
		for (Long time : this.executionTimes) {
			mean += time;
			
			if(time > max) {
				max = time;
			}
			else if(time < min) {
				min = time;
			}
		}
		mean = mean/arraySize;
		
		// Loop para calcular o desvio-padrão
		for (Long time : executionTimes) {
			sd += Math.pow((time - mean), 2);
		}
		sd = Math.sqrt(sd/arraySize);
		
		
		this.maxExecutionTime = max;
		this.minExecutionTime = min;
		this.meanExecutionTime = mean;
		this.executionTimeSD = sd;
	}
	
	public void setSolutionStats() throws JMException {
		double max, min;
		double mean = 0;
		double sd = 0;
		int problemDimensions;
		double[] meanCoord;
		int arraySize;
		
		arraySize = this.bestSolutions.size();
		problemDimensions = this.pso.getProblem().getNumberOfVariables();
		meanCoord = new double[problemDimensions];
		max = min = this.bestSolutions.get(0).getObjective(0);
		
		for(int i = 0; i < problemDimensions; i++) {
			meanCoord[i] = 0;
		}
		
		// Loop para encontrar o mínimo, máximo,
		// o valor médio do conjunto de valores e
		// a média das coordenadas das soluções
		for (Solution solution : this.bestSolutions) {
			double objective = solution.getObjective(0);
			
			mean += objective;
			
			if(objective > max) {
				max = objective;
			}
			else if(objective < min) {
				min = objective;
			}
			
			// Soma dos pontos da solução para calcular a média
			Variable[] var = solution.getDecisionVariables();
			for (int i = 0; i < problemDimensions; i++) {
				meanCoord[i] += var[i].getValue();
			}
		}
		mean = mean/arraySize;
		
		// Loop para computar o valor médio dos pontos
		for (int i = 0; i < problemDimensions; i++) {
			meanCoord[i] /= arraySize;
		}
		
		// Loop para calcular o desvio-padrão
		for (Solution solution : this.bestSolutions) {
			double objective = solution.getObjective(0);
			
			sd += Math.pow((objective - mean), 2);
		}
		sd = Math.sqrt(sd/arraySize);
		
		
		this.maxBestSolution = max;
		this.minBestSolution = min;
		this.meanBestSolution = mean;
		this.meanBestSolutionCoord = meanCoord;
		this.bestSolutionSD = sd;
	}
	
	/** 
	 * Getters and Setters 
	 */

	public List<Integer> getEvaluations() {
		return evaluations;
	}

	public void setEvaluations(List<Integer> evaluations) {
		this.evaluations = evaluations;
	}

	public List<Long> getExecutionTimes() {
		return executionTimes;
	}

	public void setExecutionTimes(List<Long> executionTimes) {
		this.executionTimes = executionTimes;
	}

	public List<Solution> getBestSolutions() {
		return bestSolutions;
	}

	public void setBestSolutions(List<Solution> bestSolutions) {
		this.bestSolutions = bestSolutions;
	}
}
