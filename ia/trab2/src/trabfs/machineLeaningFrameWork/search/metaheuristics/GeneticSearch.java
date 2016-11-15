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
import java.util.Random;

/**
 *
 * @author rbroetto
 */
public class GeneticSearch extends Search{        
    
    private int sizepopulation;
    private Double taxamutacao;
    private int niter;
    
    
    protected double[] atributequality;    
    protected Problema p;    
    protected Solucao best;
    
    protected double bestprecision;
    ArrayList<Solucao> populacao = new ArrayList<>();
    ArrayList<Solucao> pais = new ArrayList<>();
    
    public GeneticSearch(){}
    
    public GeneticSearch(int sizepop,Double txmutacao, int niteracao){
        this.sizepopulation = sizepop;
        this.taxamutacao = txmutacao;
        this.niter = niteracao;
    }
    
    @Override
    public Result startSearch(Problema problema){ 
        long t = System.currentTimeMillis();
        
        p = problema;
        as = new AvaliadordeSolucao(problema);                
        N = problema.getNumAtributos()-1;                                        
        bestprecision=0;        
        populacao = new ArrayList<>();
        pais = new ArrayList<>();
        
        initPopulation();
        for(int i=0; i < niter; i++){                        
            selecao();            
            reproducao();            
            mutacao();            
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
    
    protected void selecao(){
        double precision;
        ArrayList<Double[]> precisoes = new ArrayList<>();                
        Double id;            
        
        //seleção                
        precisoes.clear();            
        id=0.0;
        for (Solucao i : populacao) {                                                
            precision = as.avalia(i);
            Double[] d = new Double[2];
            d[0]=id;
            d[1]=precision;
            precisoes.add(d);                                    
            id++;

            if(precision > bestprecision){
                bestprecision = precision;                    
                best = i;
            }
        }            

        //ordena                
        Collections.sort(precisoes,new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
                Double[] a1 = (Double[])o1;
                Double[] a2 = (Double[])o2;
                if(a1[1].equals(a2[1])) return 0;
                if(a1[1] > a2[1]) return -1;
                return 1;
            }
        });

        Double roleta, acumulativo;
        pais.clear();

        for(int i=0;i<populacao.size()/2;i++){                    
            roleta = Math.random();
            acumulativo=0.0;                    
            for(Double[] prs : precisoes){
                acumulativo += prs[1];
                if(acumulativo > roleta){                            
                    precisoes.remove(prs);
                    pais.add(populacao.get(prs[0].intValue()));                       
                    break;
                }
            }                    
        }        
    }
  
    protected Solucao onePCrossover(Solucao a, Solucao b, Integer d) {
        
        Solucao co = new Solucao(N);
        
        for(int i=0; i<d;i++){
            co.set(i, a.get(i));
        }        
        
        for(int i=d; i<N;i++){
            co.set(i, b.get(i));
        }
        
        return co;
    }

    protected void reproducao() {        
        
        Random rand = new Random(1);                        
        
        populacao.clear();
        for(int i=0; i<pais.size()/2;i++){                        
            Solucao pai1 =  pais.get(rand.nextInt(pais.size()));
            Solucao pai2 =  pais.get(rand.nextInt(pais.size()));
            Solucao filho1 = onePCrossover(pai1, pai2, N/2);
            Solucao filho2 = onePCrossover(pai2, pai1, N/2);
           
            populacao.add(pai1);
            populacao.add(pai2);
            populacao.add(filho1);
            populacao.add(filho2);
        }
    }

    protected void mutacao() { 
        for(Solucao i : populacao){                
            if(Math.random() < taxamutacao){                
                i.inverte((int)(Math.random()*N));                
            }
        }
    }

    protected void initPopulation() {          
        for(int i=0; i<sizepopulation;i++){
            Solucao sol = new Solucao(N);
            sol.initRandom();
            populacao.add(sol);
        }        
    }

    public int getSizepopulation() {
        return sizepopulation;
    }

    public void setSizepopulation(int sizepopulation) {
        this.sizepopulation = sizepopulation;
    }

    public Double getTaxamutacao() {
        return taxamutacao;
    }

    public void setTaxamutacao(Double taxamutacao) {
        this.taxamutacao = taxamutacao;
    }

    public int getIter_max() {
        return niter;
    }

    public void setIter_max(int iter_max) {
        this.niter = iter_max;
    }
}
