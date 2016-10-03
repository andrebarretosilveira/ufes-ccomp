
import algorithm.PSOAlgorithm;
import algorithm.Statistics;
import problem.*;
import jmetal.core.Algorithm;
import jmetal.core.Problem;
import jmetal.util.JMException;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, JMException {
		Problem bukin = new BukinProblem("Real");
		Problem eggholder = new EggholderProblem("Real");
		Problem griewank = new GriewankProblem("Real", 3);
		
		Algorithm psoBukin = new PSOAlgorithm(bukin);
		psoBukin.setInputParameter("maxEvaluations",  25000);
		psoBukin.setInputParameter("numberOfParticles",  30);
		psoBukin.setInputParameter("convergenceLimit", 1000);
		psoBukin.setInputParameter("w",  0.8); // coef. Inércia
		psoBukin.setInputParameter("c1", 1.8); // coef. Cognitivo
		psoBukin.setInputParameter("c2", 1.8); // coef. Social
		
		Algorithm psoEggholder = new PSOAlgorithm(eggholder);
		psoEggholder.setInputParameter("maxEvaluations",  25000);
		psoEggholder.setInputParameter("numberOfParticles",  30);
		psoEggholder.setInputParameter("convergenceLimit", 1000);
		psoEggholder.setInputParameter("w",  0.8); // coef. Inércia
		psoEggholder.setInputParameter("c1", 1.0); // coef. Cognitivo
		psoEggholder.setInputParameter("c2", 1.0); // coef. Social
		
		Algorithm psoGriewank = new PSOAlgorithm(griewank);
		psoGriewank.setInputParameter("maxEvaluations",  25000);
		psoGriewank.setInputParameter("numberOfParticles",  30);
		psoGriewank.setInputParameter("convergenceLimit", 1000);
		psoGriewank.setInputParameter("w",  0.8); // coef. Inércia
		psoGriewank.setInputParameter("c1", 1.6); // coef. Cognitivo
		psoGriewank.setInputParameter("c2", 1.6); // coef. Social

		for (int i = 0; i < 10; i++) {
			psoBukin.execute();
			psoEggholder.execute();
			psoGriewank.execute();
		}
				
		Statistics bukinStats = (Statistics) psoBukin.getOutputParameter("statistics");
		Statistics eggholderStats = (Statistics) psoEggholder.getOutputParameter("statistics");
		Statistics griewankStats = (Statistics) psoGriewank.getOutputParameter("statistics");

		bukinStats.generateReport();
		eggholderStats.generateReport();
		griewankStats.generateReport();
	}

}