package algorithm;

import jmetal.core.Problem;
import jmetal.core.Solution;
import jmetal.core.Variable;
import jmetal.util.JMException;
import java.util.Random;

public class Particle {
	
	private Swarm swarm;
	private Problem problem;
	private PSOAlgorithm pso;
	private Solution solution;
	private Solution bestSolution;
	private double[] velocity;
	
	public Particle(Swarm swarm, Problem problem, PSOAlgorithm pso)
			throws ClassNotFoundException, JMException {
		
		int dimensions = problem.getNumberOfVariables();
		this.swarm = swarm;
		this.problem = problem;
		this.pso = pso;
		this.solution = new Solution(problem);
		this.bestSolution = new Solution(problem);
		this.velocity = new double[dimensions];
		
		// Inicializando a solução da partícula aleatoriamente
		this.inicializeSolution();
				
		// Copiando a solução inicial como a melhor solução encontrada
		Swarm.copySolution(this.bestSolution, this.solution);
	}
	
	/**
	 * Executa a função evaluate do problema para a solução
	 * desta Partícula. Verifica se a mesma se encontra nos
	 * limites definidos pelo problema.
	 * @throws JMException
	 */
	public void evaluateFitness() throws JMException {
		// Limite de evaluations
		if(this.pso.getEvaluations() >= this.pso.getMaxEvaluations()) {
			return;
		}
		
		this.problem.evaluate(this.solution);
		this.pso.incrementEvaluations();
		
		// Caso a partícula saia dos limites do domínio
		// a partícula é resetada para uma nova posição
		// dentro do domínio
		if(!this.isWithinProblemLimits()) {
			this.inicializeSolution();
		}
	}
	
	public Solution updateIndividualBest() throws JMException {
		double fitness = this.solution.getObjective(0);
		
		if(fitness < this.bestSolution.getObjective(0)) {
			Swarm.copySolution(this.bestSolution, this.solution);
		}
				
		return this.bestSolution;
	}
	
	/**
	 * Atualiza o vetor velocidade da partícula e em seguida
	 * atualiza a posição da mesma, utilizando a velocidade
	 * atual
	 * @throws JMException
	 */
	public void updateVelocityPosition() throws JMException {
		Variable[] pos = this.solution.getDecisionVariables();
		double w  = (double) this.pso.getInputParameter("w");
		double c1 = (double) this.pso.getInputParameter("c1");
		double c2 = (double) this.pso.getInputParameter("c2");
		
		Random rand = new Random();		
		double r1 = rand.nextDouble();
		double r2 = rand.nextDouble();
		
		for (int i = 0; i < this.problem.getNumberOfVariables(); i++) {
			double newI  = pos[i].getValue();
			double bestI = this.bestSolution.getDecisionVariables()[i].getValue();
			double bestGlobalI = this.swarm.getBestSolution().
					getDecisionVariables()[i].getValue();
			
			// Cálculo da nova velocidade
			this.velocity[i] = w*this.velocity[i] +
					           c1*r1*(bestI - newI) +
					           c2*r2*(bestGlobalI - newI);
		}
		
		// Atualizando a posição da partícula
		// PosNova = PosAtual + Velocidade
		for (int i = 0; i < pos.length; i++) {
			pos[i].setValue(pos[i].getValue() + this.velocity[i]);
		}
	}
	
	/**
	 * Inicializa a solução da partícula, gerando uma nova posição
	 * para a mesma no domínio do problema. Também chama a execução
	 * do evaluate do Problema para atualizar o Objective do nova
	 * posição da partícula
	 * @throws JMException
	 */
	public void inicializeSolution() throws JMException {
		// Inicializando a solução da partícula aleatoriamente
		// dentro dos limites do domínio em questão
		Random r = new Random();
		Variable[] var = this.solution.getDecisionVariables();
		for (int i = 0; i < var.length; i++) {
			double upper = this.problem.getUpperLimit(i);
			double lower = this.problem.getLowerLimit(i);
			var[i].setValue(lower + (upper - lower) * r.nextDouble());
		}
		
		this.evaluateFitness();
	}
	
	/**
	 * Verifica se a partícula está dentro do domínio do Problema
	 * @return true se está, false se estiver fora do domínio
	 * @throws JMException
	 */
	public boolean isWithinProblemLimits() throws JMException {
		Variable[] var = this.solution.getDecisionVariables();
		for (int i = 0; i < var.length; i++) {
			double upperLimit = this.problem.getUpperLimit(i);
			double lowerLimit = this.problem.getLowerLimit(i);
			
			if(var[i].getValue() > upperLimit ||
			   var[i].getValue() < lowerLimit) {
				return false;
			}
		}
		
		return true;
	}
	
	public Solution getBestSolution() {
		return this.bestSolution;
	}

}
