/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabfs.machineLeaningFrameWork.search.metaheuristics;

import trabfs.machineLeaningFrameWork.core.AvaliadordeSolucao;
import trabfs.machineLeaningFrameWork.core.Problema;
import trabfs.machineLeaningFrameWork.core.Solucao;
import weka.core.Debug.Random;

/**
 *
 * @author projetoip
 */
public class FCGRASP {

    private double minp=0.2, maxp=0.8;
    private int N;
    private double[] atributequality;
    private AvaliadordeSolucao as;
    private int maxgen=10;
    Problema problema;
    double[] qualidades;
    long runtime;
    
    public void startGRASP(Problema p){                        
        long initialtime = System.currentTimeMillis();
        problema = p; 
        qualidades = problema.getAttributeQuality();
        as = new AvaliadordeSolucao(problema);
        N = p.getNumAtributos()-1;                                
        Solucao s, best = new Solucao(N);
        int gen=0;
        while(gen++ < maxgen){            
            //System.out.println("construindo");
            s = constroi();            
            //System.out.println(as.avalia(s));
            //System.out.println("buscando");
            buscaLocal(s);            
            if( s.getQuality() > best.getQuality() ){
                best = s;
            }            
        }        
        long finaltime = System.currentTimeMillis();
        runtime = (finaltime-initialtime)/(long)1000.0f;        
        System.out.println(runtime);
    }

    private Solucao constroi() {
        Random rand = new Random();
        Solucao s = new Solucao(N);
        s.initZero();        
        for(int i=0; i<N; i++){
            if(rand.nextDouble() < minp + (maxp-minp)*qualidades[i] ){
                s.set(i, 1);
            }
        }        
        return s;
    }

    private void buscaLocal(Solucao s) {
        
        // hill-climbing
        int best_i=0;        
        double best_a = as.avalia(s);
        double global_best_a = best_a, a;
        
        while(true){
            best_a = s.getQuality();
            for(int i=0; i<N; i++){
                s.inverte(i);
                a = as.avalia(s);
                s.inverte(i);                
                if(a > best_a){
                    best_a = a;
                    best_i=i;
                }
            }
            if(best_a > global_best_a){
                global_best_a = best_a;
                s.inverte(best_i);
            }else{
                as.avalia(s);
                break;
            }
        }
    }
}
