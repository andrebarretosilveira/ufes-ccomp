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
import weka.core.Debug.Random;

/**
 *
 * @author rbroetto
 */
public class MeuMetodo extends Search{

    @Override
    public Result startSearch(Problema p) {
        N = p.getNumAtributos()-1;
        as = new AvaliadordeSolucao(p);
        long t = System.currentTimeMillis();
        Solucao best;
        
        // ---------------------------------- [implemente o método de busca a partir daqui]
                
        Solucao s = new Solucao(N);
        s.initZero();
        best = new Solucao(s);
        
        int iter=0;
        Random rand = new Random();
        while(iter++ < 1000){
            int index = rand.nextInt(N);
            s.inverte(index);
            as.avalia(s);
            if(s.getQuality() > best.getQuality()){
                best = new Solucao(s);
            }else{
                s.inverte(index);
            }
            System.out.println("Iter "+(iter) + ":\t"+best.getQuality());
        }
        
        // ---------------------------------- [fim do método de busca]
        
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


//int iter=0;
//Random rand = new Random();
//while(iter++ < 1000){
//    int index = rand.nextInt(N);
//    s.inverte(index);
//    as.avalia(s);
//    if(s.getQuality() > best.getQuality()){
//        best = new Solucao(s);                
//    }
//    System.out.println("Iter "+(iter) + ":\t"+best.getQuality());
//}