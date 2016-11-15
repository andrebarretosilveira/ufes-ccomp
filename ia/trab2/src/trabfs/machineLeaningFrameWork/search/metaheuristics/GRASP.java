/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabfs.machineLeaningFrameWork.search.metaheuristics;

import trabfs.machineLeaningFrameWork.core.AvaliadordeSolucao;
import trabfs.machineLeaningFrameWork.core.Problema;
import trabfs.machineLeaningFrameWork.core.Result;
import trabfs.machineLeaningFrameWork.search.Search;
import trabfs.machineLeaningFrameWork.core.Solucao;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import weka.core.Debug.Random;

/**
 *
 * @author projetoip
 */
public class GRASP extends Search{

    protected double alpha;    
    protected int maxgen=10;    
    protected int calls;    
    
    @Override
    public Result startSearch(Problema p){                         
        long t = System.currentTimeMillis();
//        System.out.println(this.getClass().getName() + ": [alpha="+alpha+"]");        
        
        Solucao best = searchRoutine(p);                       
        
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
    
    protected Solucao searchRoutine(Problema p){
        as = new AvaliadordeSolucao(p);                
        N = p.getNumAtributos()-1;                                
        Solucao s, best = new Solucao(N);
        int gen=0;        
        
        while(gen++ < maxgen){              
            s = constroi();                                                            
            buscaLocal(s);                                    
            if( s.getQuality() > best.getQuality() ){
                best = s;
            }                     
        }                
        return best;
    }

    protected Solucao constroi() {
        Random rand = new Random();
        Solucao s = new Solucao(N);
        s.initZero();
        double p = as.avalia(s);
        ArrayList<double[]> LC = new ArrayList<>();
        double[] r;   
        
        
        while(true){            
            // limpa a lista
            LC.clear(); 
            
            // adiciona elementos um a um e verifica o ganho
            for(int i=0; i<N; i++){            
                if(s.get(i) == 0){                
                    s.set(i, 1);                
                    r = new double[2];
                    r[0] = i;
                    r[1] = as.avalia(s);
                    s.set(i, 0);
                    if(r[1] > p){
                        LC.add(r);
                    }
                }
            }

            // se não houve ganho ou atributos para selecionar, para
            if(LC.isEmpty()) break;
            
            // ordena
            Collections.sort(LC,new Comparator(){
                @Override
                public int compare(Object t, Object t1) {
                    double[] v1 = (double[])t;
                    double[] v2 = (double[])t1;
                    if(v1[1] > v2[1])
                        return -1;
                    else if(v1[1] < v2[1])
                        return 1;
                    else
                        return 0;
                }
            });
            
            // escolhe aleatoriamente
            int TS = (int)(LC.size()*(1-alpha));
            if(TS==0) TS=1;            
            double[] select = LC.get(rand.nextInt(TS));
            s.set((int)select[0], 1);
            p = select[1];            
        }                
        return s;
    }

    protected void buscaLocal(Solucao s) {
        
        // simple hill-climbing       
        double pivot_a;
        double a, best;        
        int best_i=0;
        ArrayList<Integer> nh = makeList();
        
        while(true){
            pivot_a = as.avalia(s);        
            best = Double.MIN_VALUE;
            Collections.shuffle(nh);
            for(int i : nh){                
                s.inverte(i);
                a = as.avalia(s);
                s.inverte(i);                
                if(a > best){                    
                    best = a;
                    best_i = i;
                }                
            }
            
            if(best > pivot_a){
                s.inverte(best_i);
            }else{
                break;
            }
        }
    }
    
    public void setAlpha(double a){
        this.alpha = a;
    }

    private ArrayList<Integer> makeList() {
        ArrayList<Integer> l = new ArrayList<>();
        for(int i=0; i<N; i++) l.add(i);        
        return l;
    }
}
