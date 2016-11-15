/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabfs.machineLeaningFrameWork.search.metaheuristics;

import trabfs.machineLeaningFrameWork.core.AvaliadordeSolucao;
import trabfs.machineLeaningFrameWork.core.Problema;
import trabfs.machineLeaningFrameWork.core.Solucao;
import trabfs.machineLeaningFrameWork.search.metaheuristics.PathRelinking;
import trabfs.machineLeaningFrameWork.search.metaheuristics.GRASP;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import weka.core.Debug.Random;

/**
 *
 * @author projetoip
 */
public class PRGRASP extends GRASP{

    ArrayList<Solucao> P;
    int max_p_size=50; 
    int pr_times=3;
    
    @Override
    protected Solucao searchRoutine(Problema p){
        as = new AvaliadordeSolucao(p);  
        PathRelinking pr = new PathRelinking(p, as);
        
        N = p.getNumAtributos()-1;                                
        P = new ArrayList<>();
        Random r = new Random();                   
        Solucao s, best=null;
        int gen=0;
        while(gen++ < maxgen){                 
            
            s = constroi();                                    
            buscaLocal(s);                                    
            
            P.add(s);
            if(gen >= 2){
                for(int i=0; i<pr_times; i++){
                    Solucao initial_path   = P.get(r.nextInt(P.size()));                    
                    Solucao reference_path = P.get(r.nextInt(P.size()));
                    Solucao b = pr.startPathRelinking(initial_path, reference_path);
                    P.add(b);                
                }                
            }   
            best = refatoraPool();            
        }
        return best;
    }

    private Solucao refatoraPool() {
        
        Collections.sort(P, new Comparator(){
            @Override
            public int compare(Object t, Object t1) {
                Solucao o1 = (Solucao)t;
                Solucao o2 = (Solucao)t1;
                if(o1.getQuality() > o2.getQuality()){
                    return -1;
                }else if(o1.getQuality() > o2.getQuality()){
                    return 1;
                }else{
                    return 0;
                }
            }
        } );
        
        while(P.size() > max_p_size) P.remove(P.size()-1);
        return P.get(0);
    }
}
