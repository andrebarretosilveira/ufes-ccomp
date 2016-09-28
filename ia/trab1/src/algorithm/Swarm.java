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
	
	public Swarm(PSOAlgorithm pso, Problem problem, Integer numberOfParticles)
			throws ClassNotFoundException, JMException {
		this.pso = pso;
		this.bestSolution = new Solution(problem);
		this.particles = new ArrayList<Particle>(numberOfParticles);
		
		// Criando as Partículas do Enchame
		for(int i=0; i < numberOfParticles; i++) {
			this.particles.add(i, new Particle(this, problem));
		}
		
		// Inicializando a melhor solução aleatoriamente
		Swarm.copySolution(this.bestSolution, this.particles.get(0).getBestSolution());
	}
	
	public void evaluateParticlesFitness() throws JMException {
		for (Particle particle : this.particles) {
			particle.evaluateFitness();
		}
		
	}
	
	public void updateBests() throws JMException {
		for (Particle particle : this.particles) {
			Solution individualBest = particle.updateIndividualBest();
			if(individualBest.getObjective(0) < this.bestSolution.getObjective(0)) {
				Swarm.copySolution(this.bestSolution, individualBest);
			}
		}
	}
	
	public void updateParticlesVelocityPosition() throws JMException {
		for (Particle particle : this.particles) {
			particle.updateVelocity();
			particle.updatePosition();
		}
	}

	public PSOAlgorithm getPso() {
		return this.pso;
	}
	
	public Solution getBestSolution() {
		return this.bestSolution;
	}

	/**
	 * Copies the solution src to the solution dest
	 * @param dest Solution to be replaced with the src's contents
	 * @param src  Solution that is to be copied
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

}
