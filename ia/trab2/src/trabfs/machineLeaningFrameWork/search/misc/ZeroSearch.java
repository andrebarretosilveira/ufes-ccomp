/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabfs.machineLeaningFrameWork.search.misc;

import trabfs.machineLeaningFrameWork.core.AvaliadordeSolucao;
import trabfs.machineLeaningFrameWork.core.Solucao;
import trabfs.machineLeaningFrameWork.core.Problema;
import trabfs.machineLeaningFrameWork.search.Search;
import trabfs.machineLeaningFrameWork.core.Result;

/**
 *
 * @author rbroetto
 */
public class ZeroSearch extends Search{
    @Override
    public Result startSearch(Problema p){                         
        long t = System.currentTimeMillis();
//        System.out.println(this.getClass().getName());
        
        N = p.getNumAtributos()-1;
        as = new AvaliadordeSolucao(p);
        Solucao s = new Solucao(N);
        s.initOne();
        as.avalia(s);
        
        t = System.currentTimeMillis() - t;        
        Result r = new Result();
        r.setSolucao(s);                
        r.setTime(t);
        r.setMetodo(this.getClass().getName());
        r.setDataset(p.getInstances().relationName());
        r.setCalls(as.getCalls());
        r.setEvolucao(as.getEvolucao());
        
        return r;
    }
}
