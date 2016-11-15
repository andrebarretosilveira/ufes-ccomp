package trabfs.machineLeaningFrameWork.search.misc;

import trabfs.machineLeaningFrameWork.core.AvaliadordeSolucao;
import trabfs.machineLeaningFrameWork.core.Solucao;
import trabfs.machineLeaningFrameWork.search.metaheuristics.BPSO;
import java.util.Random;

/**
 * Classe Partícula que é usada pelo BPSO para auxiliar
 * e modularizar a estrutura do algoritmo
 * @author André Barreto
 *
 */
public class Particle {
	private BPSO bpso;
	private Solucao solution;
	private Solucao bestSolution;
	private double[] velocity;
	private double[] genotype;
	private double w, c1, c2;
	
	/**
	 * Construtar de Partícula
	 * @param bpso Algoritmo BPSO da partícula
	 * @param numAtrib Número de características da base
	 */
	public Particle(BPSO bpso, int numAtrib) {
		this.bpso = bpso;
		this.solution = new Solucao(numAtrib);
		this.solution.initRandom();
		this.bestSolution = new Solucao(this.solution);
		this.velocity = new double[numAtrib];
		this.genotype = new double[numAtrib];
		
		// Gerando os coeficientes da partícula
		double x;
        Random rand = new Random();
        x = 2.01 + (2.4 - 2.01) * rand.nextDouble();
        w  = 1/(x-1 + Math.sqrt(Math.pow(x, 2) - 2*x));
        c1 = c2 = x*w;
	}
	
	/**
	 * Avalia a solução da partícula utilizando um
	 * AvaliadorSolucao
	 * @param as AvaliadorSolucao que avalia a solução
	 * da partícula
	 */
	public void evaluateSolution(AvaliadordeSolucao as) {
		
		// Limite de avaliações
		if(as.getCalls() >= this.bpso.getMaxCalls()) {
			return;
		}
		
		as.avalia(this.solution);
	}
	
	/**
	 * Atualiza a melhor solução individual caso
	 * a solução atual seja melhor que esta
	 */
	public void updateIndividualBest() {
		if(this.solution.getQuality() > this.bestSolution.getQuality()) {
			this.bestSolution = new Solucao(this.solution);
		}
	}
	
	/**
	 * Atualiza a velocidade e posição da partícula
	 * @param globalBest Melhor solução do Enchame
	 */
	public void updateVelocityPosition(Solucao globalBest) {
		Random rand = new Random();	
		double r;
		double r1 = rand.nextDouble();
		double r2 = rand.nextDouble();
		
		int[] pos = this.solution.getData();
		
		for (int i = 0; i < pos.length; i++) {
			double newI  = (double) pos[i];
			double bestI = (double) this.bestSolution.getData()[i];
			double bestGlobalI = (double) globalBest.getData()[i];
			
			// Cálculo da nova velocidade
			this.velocity[i] = w*this.velocity[i] +
					           c1*r1*(bestI - newI) +
					           c2*r2*(bestGlobalI - newI);
			
			// Cálculo do novo genótipo
			this.genotype[i] = this.genotype[i] + this.velocity[i];
			
			// Nova posição da partícula
			r = rand.nextDouble();
			if(r >= sigmoid(this.genotype[i])) {
				pos[i] = 0;
			} else {
				pos[i] = 1;
			}
		}
		
		// Atualiza a posição da partícula
		this.solution.setData(pos);
	}
	
	/**
	 * Função sigmóide que mapeia valores reais para
	 * os valores entre [0,1] com o objetivo de decidir
	 * o valor binário da nova posição de uma partícula
	 * @param v Valor em double a ser convertido
	 * @return Valor entre [0,1]
	 */
	private double sigmoid(double v) {
		return 1/(1 + Math.pow(Math.E, -v));
	}
	
	
	/* 
	 * Getters & Setters
	 */
	
	public BPSO getPso() {
		return bpso;
	}

	public void setPso(BPSO pso) {
		this.bpso = pso;
	}

	public Solucao getSolution() {
		return solution;
	}

	public void setSolution(Solucao solution) {
		this.solution = solution;
	}

	public Solucao getBestSolution() {
		return bestSolution;
	}

	public void setBestSolution(Solucao bestSolution) {
		this.bestSolution = bestSolution;
	}

	public double[] getVelocity() {
		return velocity;
	}

	public void setVelocity(double[] velocity) {
		this.velocity = velocity;
	}
	
	public double[] getGenotype() {
		return genotype;
	}

	public void setGenotype(double[] genotype) {
		this.genotype = genotype;
	}

	public double getW() {
		return w;
	}

	public void setW(double w) {
		this.w = w;
	}

	public double getC1() {
		return c1;
	}

	public void setC1(double c1) {
		this.c1 = c1;
	}

	public double getC2() {
		return c2;
	}

	public void setC2(double c2) {
		this.c2 = c2;
	}
}
