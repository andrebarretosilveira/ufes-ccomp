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
import java.util.ArrayList;

/**
 *
 * @author raphael
 */
public class TabuSearch extends Search{

    @Override
    public Result startSearch(Problema p) {
        
        long t = System.currentTimeMillis();
        System.out.println(this.getClass().getName());
        as = new AvaliadordeSolucao(p);
        N = p.getNumAtributos()-1;
        
        Solucao s = new Solucao(N);
        s.initRandom();
        Solucao best = new Solucao(s);
        ArrayList<Solucao> tabuList = new ArrayList<>();
        
        int numIter=40;
        
        while(numIter-- > 0){
            double bestQuality = 0.0;
            int bestIndex=0;
            
            for(int i=0; i<N;i++){
                s.inverte(i);
                if(!isInTabuSearch(tabuList, s)){
                    as.avalia(s);
                    double q = s.getQuality();                
                    if(q > bestQuality){
                        bestQuality = q;
                        bestIndex = i;
                    }
                }
                s.inverte(i);                
            }            
            s.inverte(bestIndex);
            s.setQuality(bestQuality);
            
            if(s.getQuality() > best.getQuality()){
                best = new Solucao(s);
            }
            
            tabuList.add(new Solucao(s));            
            if(tabuList.size() > 50){
                tabuList.remove(0);
            }
            System.out.println(as.getCalls()+";"+ String.valueOf(best.getQuality()).replace(".", ",") );
        }
                
        t = System.currentTimeMillis() - t;
        Result r = new Result();
        r.setSolucao(best);
        r.setTime(t);
        r.setMetodo(this.getClass().getName());
        r.setDataset(p.getInstances().relationName());
        r.setCalls(as.getCalls());
        
        return r;
        
    }

    private boolean isInTabuSearch(ArrayList<Solucao> tabuList, Solucao candidate) {
        for(Solucao s : tabuList){
            if(s.igual(candidate)){
                return true;
            }
        }
        return false;
    }
    
}
