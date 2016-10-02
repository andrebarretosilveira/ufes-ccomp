
import algorithm.PSOAlgorithm;
import algorithm.Statistics;
import problem.*;
import jmetal.core.Algorithm;
import jmetal.core.Problem;
import jmetal.core.SolutionSet;
import jmetal.core.Variable;
import jmetal.util.JMException;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, JMException {
		Problem problem;
		Algorithm pso;
		
//		problem = new BukinProblem("Real");
//		problem = new EggholderProblem("Real");
		problem = new GriewankProblem("Real", 3);
		
		pso = new PSOAlgorithm(problem);
		pso.setInputParameter("maxEvaluations",  25000);
		pso.setInputParameter("numberOfParticles",  30);
		pso.setInputParameter("convergenceLimit", 1000);
		
		// Fixando valores para as constantes
		pso.setInputParameter("w",  0.8); // coef. Inércia
		pso.setInputParameter("c1", 1.2); // coef. Cognitivo
		pso.setInputParameter("c2", 1.2); // coef. Social

		long tempoInicial = System.currentTimeMillis();
		SolutionSet solution = null;
		for (int i = 0; i < 10; i++) {
			solution = pso.execute();
		}
		long tempo = System.currentTimeMillis() - tempoInicial;
		
		System.out.println("Tempo total de execucao: " + tempo + "ms\n");
		
		Statistics stats = (Statistics) pso.getOutputParameter("statistics");
		stats.generateReport();
	}

}