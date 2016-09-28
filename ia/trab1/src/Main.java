
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

		problem = new Bukin("Real");
		pso = new PSOAlgorithm(problem);
		pso.setInputParameter("maxEvaluations", 25000);
		pso.setInputParameter("numberOfParticles", 30);
		
		// Fixando valores para as constantes
		pso.setInputParameter("w",  0.85); // coef. Inércia
		pso.setInputParameter("c1", 1.80); // coef. Cognitivo
		pso.setInputParameter("c2", 2.00); // coef. Social

		long tempoInicial = System.currentTimeMillis();
		SolutionSet solution = pso.execute();
		long tempo = System.currentTimeMillis() - tempoInicial;
		System.out.println("Tempo de execucao: " + tempo);

		/** Log de Execução */
		System.out.println("Total de avaliações realizadas: " + 
							pso.getOutputParameter("evaluations"));
		
		Variable[] v = solution.get(0).getDecisionVariables();
		System.out.print("Solução e resulado: [" + v[0].getValue());
		for (int i = 1; i < v.length; i++) {
			System.out.print("," + v[i].getValue());
		}
		System.out.println("] = " + solution.get(0).getObjective(0));
	}

}