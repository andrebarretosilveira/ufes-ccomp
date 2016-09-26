package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import jmetal.core.Solution;

public class Particle extends Solution {
	
	private static final long serialVersionUID = -3433769892541847790L;
	private Swarm swarm;
	private List<Double> position;
	private List<Double> velocity;
	private List<Double> bestPosition;
	private double w, c1, c2;
	
	public Particle(Swarm swarm, Integer dimensions) {
		this.swarm = swarm;
		position = new ArrayList<Double>(dimensions);
		velocity = new ArrayList<Double>(dimensions);
		bestPosition = new ArrayList<Double>(dimensions);
		
		// Gerando valores aleatórios
		Random r = new Random();
		w  = 0.8 + (1.2 - 0.8) * r.nextDouble();
		c1 = 1.1 + (2 - 1.1) * r.nextDouble();
		c2 = 1.1 + (2 - 1.1) * r.nextDouble();
		
//		double upper = this.swarm.getPso().getProblem().getUpperLimit(1);
	}

}
