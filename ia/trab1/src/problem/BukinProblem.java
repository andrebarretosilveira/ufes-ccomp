package problem;

import jmetal.core.Problem;
import jmetal.core.Solution;
import jmetal.core.Variable;
import jmetal.encodings.solutionType.RealSolutionType;
import jmetal.util.JMException;

public class BukinProblem extends Problem {

	private static final long serialVersionUID = 5571463567262502626L;

	public BukinProblem(String solutionType) {
		numberOfVariables_ = 2;
		numberOfObjectives_ = 1;
		numberOfConstraints_ = 0;
		problemName_ = "Bukin";
		lowerLimit_ = new double[numberOfVariables_];
		upperLimit_ = new double[numberOfVariables_];
		
		lowerLimit_[0] = -15.0;
		upperLimit_[0] = -5.0;
		lowerLimit_[1] = -3.0;
		upperLimit_[1] = +3.0;
		
		if (solutionType.compareTo("Real") == 0) {
			solutionType_ = new RealSolutionType(this);
		} else {
			System.out.println("Tipo de varável informada é diferente de Real");
			System.exit(-1);
		}
	}

	@Override
	public void evaluate(Solution solution) throws JMException {
		double x1, x2, result = 0.0;
		Variable[] var = solution.getDecisionVariables();
		
		x1 = var[0].getValue();
		x2 = var[1].getValue();
		
		result = 100*Math.sqrt(Math.abs(x2-0.01*Math.pow(x1, 2))) + 0.01*Math.abs(x1 + 10);
			
		solution.setObjective(0, result);
	}

}
