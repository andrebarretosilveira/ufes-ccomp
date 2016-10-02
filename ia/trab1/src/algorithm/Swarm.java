package algorithm;

import java.util.ArrayList;
import java.util.List;

import jmetal.core.Problem;
import jmetal.core.Solution;
import jmetal.core.Variable;
import jmetal.util.JMException;

public class Swarm {
	
	private PSOAlgorithm pso;
	private Solution bestSolution;
	private List<Particle> particles;
	private int convergenceCounter;
	
	/**
	 * Construtor do objeto Enchame
	 * @param pso Algorimo PSO ao qual este enchame pertence
	 * @param problem Problema que este enchame deve resolver
	 * @param numberOfParticles Número de partícula a serem criadas
	 * @throws ClassNotFoundException
	 * @throws JMException
	 */
	public Swarm(PSOAlgorithm pso, Problem problem, Integer numberOfParticles)
			throws ClassNotFoundException, JMException {
		
		this.pso = pso;
		this.bestSolution = new Solution(problem);
		this.particles = new ArrayList<Particle>(numberOfParticles);
		this.convergenceCounter = 0;
		
		// Criando as Partículas do Enchame
		for(int i=0; i < numberOfParticles; i++) {
			this.particles.add(i, new Particle(this, pso, problem));
		}
		
		// Inicializando a melhor solução global
		Swarm.copySolution(this.bestSolution, this.particles.get(0).getBestSolution());
	}
	
	/**
	 * Realiza um passo de busca pelo mínimo global de
	 * um Problema. O Enchame envia a todas as partículas
	 * comandos para atualizar seus objetivos, atualizar
	 * as melhores soluções individuais e atualizar suas
	 * velocidades e posições. Além disto também opera
	 * um contador para verificar se o critério de
	 * convergência foi alcançado.
	 * @throws JMException
	 * @throws InterruptedException 
	 */
	public void searchMinimun() throws JMException {
		for (Particle particle : this.particles) {
			// Envia o comando para atualizar o objetivo
			// das partículas do Enchame
			particle.evaluateFitness();
			
			// Atualiza a melhor solução global caso uma das
			// soluções individuais seja melhor que a atual
			Solution individualBest = particle.updateIndividualBest();
			if(individualBest.getObjective(0) < this.bestSolution.getObjective(0)) {
				Swarm.copySolution(this.bestSolution, individualBest);
				this.convergenceCounter = 0;
			}
			else {
				this.convergenceCounter++;
			}
			
			// Verifica se condição de convergência foi alcançada
			if(this.convergenceCounter > this.pso.getConvergenceLimit()) {
				this.pso.setConverged(true);
			}
			
			// Atualiza a velocidade e posição das partículas
			particle.updateVelocityPosition();
		}
	}

	/**
	 * Copia a solução 'src' para a solução 'dest'
	 * @param dest Solução a ser sobreescrita
	 * @param src  Solução com os dados a serem replicados
	 * @throws JMException 
	 */
	static protected void copySolution(Solution dest, Solution src)
			throws JMException {
		dest.setObjective(0, src.getObjective(0));
		
		Variable[] srcVariables  = src.getDecisionVariables();
		Variable[] destVariables = dest.getDecisionVariables();
		
		for (int i = 0; i < srcVariables.length; i++) {
			destVariables[i].setValue(srcVariables[i].getValue());
		}
	}
	
	
	/* Getters & Setters */
		
	public Solution getBestSolution() {
		return this.bestSolution;
	}

}
