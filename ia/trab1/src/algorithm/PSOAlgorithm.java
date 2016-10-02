package algorithm;

import jmetal.core.Algorithm;
import jmetal.core.Problem;
import jmetal.core.SolutionSet;
import jmetal.util.JMException;
import algorithm.Swarm;

public class PSOAlgorithm extends Algorithm {

	private static final long serialVersionUID = 842390733642333476L;
	private Swarm swarm;
	private Statistics statistics;
	private int evaluations, maxEvaluations;
	private int numberOfParticles, convergenceLimit;
	private boolean converged;

	/**
	 * Construtor do algoritmo PSO
	 * @param problem Problema que o PSO deve resolver
	 */
	public PSOAlgorithm(Problem problem) {
		super(problem);
		this.statistics = new Statistics(this);
	}

	@Override
	public SolutionSet execute() throws JMException, ClassNotFoundException {
		long initTime = System.currentTimeMillis();
		
		this.evaluations = 0;
		this.converged = false;
		
		this.maxEvaluations    = ((int) getInputParameter("maxEvaluations"));
		this.numberOfParticles = ((int) getInputParameter("numberOfParticles"));
		this.convergenceLimit  = ((int) getInputParameter("convergenceLimit"));
		
		this.swarm = new Swarm(this, problem_, numberOfParticles);
		
		while (this.evaluations < this.maxEvaluations && !this.converged) {
			swarm.searchMinimun();
		}

		setOutputParameter("evaluations", this.evaluations);
		setOutputParameter("statistics", this.statistics);

		SolutionSet result = new SolutionSet(1);
		result.add(this.swarm.getBestSolution());
		
		long executionTime = System.currentTimeMillis() - initTime;
		
		this.statistics.getEvaluations().add(this.evaluations);
		this.statistics.getBestSolutions().add(this.swarm.getBestSolution());
		this.statistics.getExecutionTimes().add(executionTime);

		return result;
	}
	
	/**
	 * Incrementa em 1 o número de avaliações
	 */
	public void incrementEvaluations() {
		this.evaluations++;
	}
	
	
	/* Getters & Setters */

	public int getMaxEvaluations() {
		return maxEvaluations;
	}

	public void setMaxEvaluations(int maxEvaluations) {
		this.maxEvaluations = maxEvaluations;
	}

	public int getNumberOfParticles() {
		return numberOfParticles;
	}

	public void setNumberOfParticles(int numberOfParticles) {
		this.numberOfParticles = numberOfParticles;
	}

	public int getEvaluations() {
		return evaluations;
	}

	public void setEvaluations(int evaluations) {
		this.evaluations = evaluations;
	}
	
	public boolean hasConverged() {
		return converged;
	}

	public void setConverged(boolean converged) {
		this.converged = converged;
	}

	public int getConvergenceLimit() {
		return convergenceLimit;
	}

	public void setConvergenceLimit(int convergenceLimit) {
		this.convergenceLimit = convergenceLimit;
	}

}