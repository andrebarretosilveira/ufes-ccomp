
import algorithm.PSOAlgorithm;
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
		
		problem = new BukinProblem("Real");
//		problem = new EggholderProblem("Real");
//		problem = new GriewankProblem("Real", 3);
		
		pso = new PSOAlgorithm(problem);
		pso.setInputParameter("maxEvaluations", 25000);
		pso.setInputParameter("numberOfParticles", 30);
		
		// Fixando valores para as constantes
		pso.setInputParameter("w",  0.8); // coef. Inércia
		pso.setInputParameter("c1", 1.2); // coef. Cognitivo
		pso.setInputParameter("c2", 1.2); // coef. Social

		long tempoInicial = System.currentTimeMillis();
		SolutionSet solution = pso.execute();
		long tempo = System.currentTimeMillis() - tempoInicial;
		
		System.out.println("Tempo de execucao: " + tempo/1000.0 + "s");
		

		/** Log de Execução */
		System.out.println("Total de avaliações realizadas: " + 
							pso.getOutputParameter("evaluations"));
		
		Variable[] v = solution.get(0).getDecisionVariables();
		System.out.print("Solução: [" + v[0].getValue());
		for (int i = 1; i < v.length; i++) {
			System.out.print("," + v[i].getValue());
		}
		System.out.println("]");
		System.out.println("Mínimo global: " + solution.get(0).getObjective(0));
	}

}