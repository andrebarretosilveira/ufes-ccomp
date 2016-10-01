package algorithm;

import jmetal.core.Algorithm;
import jmetal.core.Problem;
import jmetal.core.SolutionSet;
import jmetal.util.JMException;
import algorithm.Swarm;

public class PSOAlgorithm extends Algorithm {

	private static final long serialVersionUID = 842390733642333476L;
	private Swarm swarm;
	private int evaluations, maxEvaluations, numberOfParticles;
	private boolean hasConverged;

	public PSOAlgorithm(Problem problem) {
		super(problem);
		
	}

	@Override
	public SolutionSet execute() throws JMException, ClassNotFoundException {
		this.maxEvaluations    = ((int) getInputParameter("maxEvaluations"));
		this.numberOfParticles = ((int) getInputParameter("numberOfParticles"));
		this.evaluations = 0;
		
		this.swarm = new Swarm(this, problem_, numberOfParticles);

//		this.evaluations++;
		
		while (this.evaluations < this.maxEvaluations) {
			try {
				swarm.searchMinimun();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			swarm.evaluateParticlesFitness();
//			swarm.updateBests();
//			swarm.updateParticlesVelocityPosition();
//			evaluations++;
		}

		setOutputParameter("evaluations", this.evaluations);

		SolutionSet result = new SolutionSet(1);
		result.add(this.swarm.getBestSolution());

		return result;
	}
	
	public void incrementEvaluations() {
		this.evaluations++;
	}

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

}