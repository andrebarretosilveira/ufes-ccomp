package algorithm;

import jmetal.core.Algorithm;
import jmetal.core.Problem;
import jmetal.core.Solution;
import jmetal.core.SolutionSet;
import jmetal.core.Variable;
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
		double gamma;
		int evaluations;
		int numberOfParticles = 10;

		maxEvaluations = ((int) getInputParameter("maxEvaluations"));
		gamma = (double) getInputParameter("gamma");
		
		swarm = new Swarm(this, problem_.getNumberOfVariables(), numberOfParticles);

		evaluations = 0;

		Solution solution = new Solution(problem_);
		problem_.evaluate(solution);
		evaluations++;

		while (evaluations < maxEvaluations && solution.getObjective(0) != 0.0) {
			Variable[] var = solution.getDecisionVariables().clone();
			for (int i = 0; i < var.length; i++) {
				var[i].setValue(var[i].getValue() - gamma * 2.0 * (i + 1.0) * var[i].getValue());
			}

			Solution nSol = new Solution(problem_, var);
			problem_.evaluate(nSol);
			evaluations++;

			if (nSol.getObjective(0) < solution.getObjective(0)) {
				solution = nSol;
			}
		}

		setOutputParameter("evaluations", evaluations);

		SolutionSet result = new SolutionSet(1);
		result.add(solution);

		return result;
	}

}