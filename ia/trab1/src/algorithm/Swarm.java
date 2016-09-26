package algorithm;

import java.util.ArrayList;
import java.util.List;

public class Swarm {
	
	private PSOAlgorithm pso;
	private List<Double> bestPosition;
	private List<Particle> particles;
	
	public Swarm(PSOAlgorithm pso, Integer dimensions, Integer numberOfParticles) {
		this.pso = pso;
		bestPosition = new ArrayList<Double>(dimensions);
		particles = new ArrayList<Particle>(numberOfParticles);
		
		// Criando as Partículas do Enchame
		for(int i=0; i < numberOfParticles; i++) {
			particles.add(i, new Particle(this, dimensions));
		}
	}

	public PSOAlgorithm getPso() {
		return pso;
	}

}
