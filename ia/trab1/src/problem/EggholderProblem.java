package problem;

import jmetal.core.Problem;
import jmetal.core.Solution;
import jmetal.core.Variable;
import jmetal.encodings.solutionType.RealSolutionType;
import jmetal.util.JMException;

public class EggholderProblem extends Problem {

	private static final long serialVersionUID = 5571463567262502626L;

	public EggholderProblem(String solutionType) {
		numberOfVariables_ = 2;
		numberOfObjectives_ = 1;
		numberOfConstraints_ = 0;
		problemName_ = "Eggholder";
		lowerLimit_ = new double[numberOfVariables_];
		upperLimit_ = new double[numberOfVariables_];
		
		for(int i=0; i < numberOfVariables_; i++) {
			lowerLimit_[i] = -512.0;
			upperLimit_[i] = +512.0;
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
		double x1, x2, result = 0.0;
		Variable[] var = solution.getDecisionVariables();
		
		x1 = var[0].getValue();
		x2 = var[1].getValue();
		
		result = -(x2 + 47) * Math.sin(Math.sqrt(Math.abs(x2 + x1/2 + 47))) -
				x1*Math.sin(Math.sqrt(Math.abs(x1 - (x2 + 47))));
			
		solution.setObjective(0, result);
	}

}
