package algorithm;

import jmetal.core.Algorithm;
import jmetal.core.Problem;
import jmetal.core.SolutionSet;
import jmetal.util.JMException;
import algorithm.Swarm;

public class PSOAlgorithm extends Algorithm {

	private static final long serialVersionUID = 842390733642333476L;
	private Swarm swarm;

	public PSOAlgorithm(Problem problem) {
		super(problem);
		
	}

	@Override
	public SolutionSet execute() throws JMException, ClassNotFoundException {
		int maxEvaluations;
		int evaluations;
		int numberOfParticles;

		maxEvaluations    = ((int) getInputParameter("maxEvaluations"));
		numberOfParticles = ((int) getInputParameter("numberOfParticles"));
		
		evaluations = 0;
		
		swarm = new Swarm(this, problem_, numberOfParticles);

		evaluations++;
		
		while (evaluations < maxEvaluations) {
			swarm.evaluateParticlesFitness();
			swarm.updateBests();
			swarm.updateParticlesVelocityPosition();
			evaluations++;
		}

		setOutputParameter("evaluations", evaluations);

		SolutionSet result = new SolutionSet(1);
		result.add(swarm.getBestSolution());

		return result;
	}

}