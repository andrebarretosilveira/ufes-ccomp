package algorithm;

import jmetal.core.Algorithm;
import jmetal.core.Problem;
import jmetal.core.Solution;
import jmetal.core.Variable;
import jmetal.util.JMException;
import java.util.Random;

public class Particle {
	
	private Swarm swarm;
	private Problem problem;
	private Solution solution;

	private Solution bestSolution;
	private double[] velocity;
	
	public Particle(Swarm swarm, Problem problem)
			throws ClassNotFoundException, JMException {
		
		int dimensions = problem.getNumberOfVariables();
		this.swarm = swarm;
		this.problem = problem;
		this.solution = new Solution(problem);
		this.bestSolution = new Solution(problem);
		this.velocity = new double[dimensions];
		
		// Inicializando a solução da partícula aleatoriamente
		Random r = new Random();
		Variable[] var = this.solution.getDecisionVariables();
		for (int i = 0; i < var.length; i++) {
			double upper = this.problem.getUpperLimit(i);
			double lower = this.problem.getLowerLimit(i);
			var[i].setValue(lower + (upper - lower) * r.nextDouble());
		}
				
		// Inicializando a partícula e atualizando o melhor individual
		this.evaluateFitness();
		this.bestSolution.setObjective(0, this.solution.getObjective(0));
		this.bestSolution.setDecisionVariables(var.clone());
	}
	
	public void evaluateFitness() throws JMException {
		this.problem.evaluate(this.solution);
	}
	
	public Solution updateIndividualBest() {
		double newFitness = this.solution.getObjective(0);
		System.out.println("newFitness: " + newFitness + " | BestSolution: " + this.bestSolution.getObjective(0));
		if(newFitness < this.bestSolution.getObjective(0)) {
			this.bestSolution.setObjective(0, newFitness);
			this.bestSolution.setDecisionVariables(
					this.solution.getDecisionVariables().clone());
		}
		
		System.out.println("Best Ind.: " + this.bestSolution.getObjective(0));
		
		return this.bestSolution;
	}
	
	public void updateVelocity() throws JMException {
		// Constantes usadas na atualização da velocidade
		Algorithm pso = this.swarm.getPso();
		double w  = (double) pso.getInputParameter("w");
		double c1 = (double) pso.getInputParameter("c1");
		double c2 = (double) pso.getInputParameter("c2");
		Random rand = new Random();		
		double r1 = rand.nextDouble();
		double r2 = rand.nextDouble();
		
		for (int i = 0; i < this.problem.getNumberOfVariables(); i++) {
			double newI  = this.solution.getDecisionVariables()[i].getValue();
			double bestI = this.bestSolution.getDecisionVariables()[i].getValue();
			double bestGlobalI = this.swarm.getBestSolution().
					getDecisionVariables()[i].getValue();
			
			this.velocity[i] = w*this.velocity[i] + c1*r1*(bestI - newI) +
					c2*r2*(bestGlobalI - newI);
		}
	}
	
	public void updatePosition() throws JMException {
		Variable[] pos = this.solution.getDecisionVariables();
		for (int i = 0; i < this.problem.getNumberOfVariables(); i++) {
			pos[i].setValue(pos[i].getValue() + this.velocity[i]);
		}
	}
	
	public Solution getBestSolution() {
		return this.bestSolution;
	}

}
