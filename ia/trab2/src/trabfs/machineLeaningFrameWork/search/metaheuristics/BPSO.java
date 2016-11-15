/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabfs.machineLeaningFrameWork.search.metaheuristics;

import trabfs.machineLeaningFrameWork.core.AvaliadordeSolucao;
import trabfs.machineLeaningFrameWork.core.Problema;
import trabfs.machineLeaningFrameWork.core.Result;
import trabfs.machineLeaningFrameWork.core.Solucao;
import trabfs.machineLeaningFrameWork.search.Search;
import trabfs.machineLeaningFrameWork.search.misc.Particle;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe de busca Binary Particle Swarm Optimization
 * para seleção de características de uma base de dados
 * @author André Barreto
 *
 */
public class BPSO extends Search {
	private int maxCalls;
	private int numberOfParticles;
	private int convergenceCounter, convergenceLimit;
	private boolean converged;
	private List<Particle> swarm;
	
	
	public BPSO() {
		this.maxCalls = 500;
		this.numberOfParticles = 10;
		this.convergenceLimit = 100;
		this.swarm = new ArrayList<Particle>(this.numberOfParticles);
	}

    @Override
    public Result startSearch(Problema p) {
        N = p.getNumAtributos()-1;
        as = new AvaliadordeSolucao(p);
        long t = System.currentTimeMillis();
        Solucao globalBest;
        
        this.converged = false;
        this.convergenceCounter = 0;
                
        // Criando as Partículas do Enchame
 		for(int i=0; i < numberOfParticles; i++) {
 			this.swarm.add(new Particle(this, N));
 		}
        
        // Inicializando melhor solução global
        globalBest = new Solucao(this.swarm.get(0).getBestSolution());
        
        while (as.getCalls() < this.maxCalls && !this.converged) {
        	
        	for (Particle particle : this.swarm) {
    			particle.evaluateSolution(as);
    			
    			particle.updateIndividualBest();
    			Solucao individualBest = particle.getBestSolution();
    			
    			// Atualiza a melhor solução global caso uma solução
    			// individual seja melhor que a global
    			if(individualBest.getQuality() > globalBest.getQuality()) {
    				globalBest = new Solucao(individualBest);
    				this.convergenceCounter = 0;
    			}
    			else {
    				this.convergenceCounter++;
    			}
    			
    			// Atualiza a velocidade e posição da partícula
    			particle.updateVelocityPosition(globalBest);
    			
    			// Verifica se condição de convergência foi alcançada
    			if(this.convergenceCounter > this.convergenceLimit) {
    				this.converged = true;
    			}
    			
    			System.out.println("Call "+ (as.getCalls()) + ":\t" + globalBest.getQuality());
    		}
		}
        
        
        t = System.currentTimeMillis() - t;
        Result r = new Result();
        r.setSolucao(globalBest);
        r.setTime(t);
        r.setMetodo(this.getClass().getName());
        r.setDataset(p.getInstances().relationName());
        r.setCalls(as.getCalls());
        r.setEvolucao(as.getEvolucao());
        return r;
    }
        
    /* 
     * Getters & Setters
     */
    
	public int getMaxCalls() {
		return maxCalls;
	}

	public List<Particle> getSwarm() {
		return swarm;
	}

	public void setSwarm(List<Particle> swarm) {
		this.swarm = swarm;
	}

	public boolean isConverged() {
		return converged;
	}

	public void setMaxCalls(int maxEvaluations) {
		this.maxCalls = maxEvaluations;
	}

	public int getNumberOfParticles() {
		return numberOfParticles;
	}

	public void setNumberOfParticles(int numberOfParticles) {
		this.numberOfParticles = numberOfParticles;
	}

	public int getConvergenceCounter() {
		return convergenceCounter;
	}

	public void setConvergenceCounter(int convergenceCounter) {
		this.convergenceCounter = convergenceCounter;
	}

	public int getConvergenceLimit() {
		return convergenceLimit;
	}

	public void setConvergenceLimit(int convergenceLimit) {
		this.convergenceLimit = convergenceLimit;
	}

	public boolean hasConverged() {
		return converged;
	}

	public void setConverged(boolean converged) {
		this.converged = converged;
	}        
}