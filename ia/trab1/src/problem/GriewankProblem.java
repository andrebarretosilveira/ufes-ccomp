package problem;

import jmetal.core.Problem;
import jmetal.core.Solution;
import jmetal.core.Variable;
import jmetal.encodings.solutionType.RealSolutionType;
import jmetal.util.JMException;

public class GriewankProblem extends Problem {

	private static final long serialVersionUID = 5571463567262502626L;

	public GriewankProblem(String solutionType, Integer numberOfVariables) {
		numberOfVariables_ = numberOfVariables;
		numberOfObjectives_ = 1;
		numberOfConstraints_ = 0;
		problemName_ = "Griewank";
		lowerLimit_ = new double[numberOfVariables_];
		upperLimit_ = new double[numberOfVariables_];
		
		for(int i=0; i < numberOfVariables_; i++) {
			lowerLimit_[i] = -600.0;
			upperLimit_[i] = +600.0;
		}
		
		if (solutionType.compareTo("Real") == 0) {
			solutionType_ = new RealSolutionType(this);
		} else {
			System.out.println("Tipo de varável informada é diferente de Real");
			System.exit(-1);
		}
	}

	@Override
	public void evaluate(Solution solution) throws JMException {
		double x, result;
		double sum = 0, product = 1;
		Variable[] var = solution.getDecisionVariables();
		
		for (int i = 0; i < numberOfVariables_; i++) {
			x        = var[i].getValue();
			sum     += Math.pow(x, 2)/400;
			product *= Math.cos(x/Math.sqrt((double) i+1.0));
		}
		
		result = sum - product + 1;
		
		solution.setObjective(0, result);
	}

}
