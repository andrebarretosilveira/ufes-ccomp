/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabfs.machineLeaningFrameWork.search.greedymethods;

import trabfs.machineLeaningFrameWork.core.AvaliadordeSolucao;
import trabfs.machineLeaningFrameWork.core.Problema;
import trabfs.machineLeaningFrameWork.core.Result;
import trabfs.machineLeaningFrameWork.core.Solucao;
import java.util.ArrayList;

/**
 *
 * @author raphael
 */
public class SFBS extends SBS{
   
    @Override
    public Result startSearch(Problema p) {

        long t = System.currentTimeMillis();
        as = new AvaliadordeSolucao(p);
        N = p.getNumAtributos() - 1;

        Solucao s = new Solucao(N), best;
        s.initOne();
        ArrayList<Integer> idx = makeLista(N);
        ArrayList<Integer> idr = new ArrayList<>();

        as.avalia(s);
        double q, bestQ = s.getQuality();
        best = new Solucao(s);

        while (idx.size() > 0) {
            int pos = -1;
            q = 0.0;
            for (int i = 0; i < idx.size(); i++) {
                s.set(idx.get(i), 0);
                as.avalia(s);
                if (s.getQuality() > q) {
                    q = s.getQuality();
                    pos = i;

                    if (s.getQuality() > bestQ) {
                        bestQ = s.getQuality();
                        best = new Solucao(s);
                    }
                }
                s.set(idx.get(i), 1);
            }

            s.set(idx.get(pos), 0);
            s.setQuality(q);
            idr.add(idx.remove(pos));
            
            pos = -1;
            for(int i=0; i<idr.size(); i++){                
                s.set(idr.get(i) , 1);                
                as.avalia(s);
                if(s.getQuality() > q){
                    q = s.getQuality();                    
                    pos = i;
                    
                    if(s.getQuality() > bestQ){
                        bestQ = s.getQuality();                    
                        best = new Solucao(s);
                    }                                                    
                }                
                s.set(idr.get(i), 0);
            }
            
            // remove caso melhora
            if(pos != -1){
                s.set(idr.get(pos), 1);
                s.setQuality(q);                
                //idx.add(idr.remove(pos));
                idr.remove(pos);
            }                        
        }

        t = System.currentTimeMillis() - t;
        Result r = new Result();
        r.setSolucao(best);
        r.setTime(t);
        r.setMetodo(this.getClass().getName());
        r.setDataset(p.getInstances().relationName());
        r.setCalls(as.getCalls());
        r.setEvolucao(as.getEvolucao());

        return r;
    }
    
}
