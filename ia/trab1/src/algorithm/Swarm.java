package algorithm;

import java.util.ArrayList;
import java.util.List;

import jmetal.core.Problem;
import jmetal.core.Solution;
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
		this.bestSolution.setObjective(0, 
				particles.get(0).getBestSolution().getObjective(0));
		this.bestSolution.setDecisionVariables(particles.get(0).
				getBestSolution().getDecisionVariables().clone());
	}
	
	public void evaluateParticlesFitness() throws JMException {
		for (Particle particle : this.particles) {
			particle.evaluateFitness();
		}
		
	}
	
	public void updateBests() {
		for (Particle particle : particles) {
			Solution individualBest = particle.updateIndividualBest();
			if(individualBest.getObjective(0) < this.bestSolution.getObjective(0)) {
				this.bestSolution.setObjective(0, individualBest.getObjective(0));
				this.bestSolution.setDecisionVariables(
						individualBest.getDecisionVariables().clone());
			}
		}
		
		System.out.println("\nBest Global: " + this.bestSolution.getObjective(0));
	}
	
	public void updateParticlesVelocityPosition() throws JMException {
		for (Particle particle : particles) {
			particle.updateVelocity();
			particle.updatePosition();
		}
	}

	public PSOAlgorithm getPso() {
		return pso;
	}
	
	public Solution getBestSolution() {
		return bestSolution;
	}


}
