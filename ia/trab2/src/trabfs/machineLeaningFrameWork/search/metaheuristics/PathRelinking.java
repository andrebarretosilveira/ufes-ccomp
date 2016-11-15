/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabfs.machineLeaningFrameWork.search.metaheuristics;

import trabfs.machineLeaningFrameWork.core.AvaliadordeSolucao;
import trabfs.machineLeaningFrameWork.core.Problema;
import trabfs.machineLeaningFrameWork.core.Solucao;
import java.util.ArrayList;

/**
 *
 * @author rbroetto
 */
public class PathRelinking {
        
    protected int N;    
    protected AvaliadordeSolucao as;    
    
    public PathRelinking(Problema p, AvaliadordeSolucao as){        
        this.N = p.getNumAtributos()-1; 
        this.as = as;
    }
    
    public Solucao startPathRelinking(Solucao a, Solucao b){
        Solucao new_s =  new Solucao(a);
        Solucao best_s = new Solucao(N);
        // captura posições diferentes
        ArrayList<Integer> index = new ArrayList<>();
        for(int i=0; i<N; i++)
            if(new_s.get(i) != b.get(i)) 
                index.add(i);
        
        double f;
        int j=0;
        while(index.size() > 0){
            f=0;            
            for(Integer i=0; i<index.size(); i++){
                new_s.inverte(index.get(i));
                as.avalia(new_s);
                if( new_s.getQuality() > f  )
                {
                    f = new_s.getQuality();
                    j=i;
                } 
                new_s.inverte(index.get(i));
            }
            int z = index.remove(j);
            new_s.inverte(z);
            as.avalia(new_s);
            
            if(new_s.getQuality() > best_s.getQuality()){
                best_s = new Solucao(new_s);
            }
        }        
        return best_s;
    }
}
