/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabfs.machineLeaningFrameWork.core;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.bayes.NaiveBayesSimple;
import weka.classifiers.lazy.IBk;
import weka.core.Debug.Random;
import weka.core.Instances;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Remove;

/**
 *
 * @author projetoip
 */
public class AvaliadordeSolucao {
    
    protected Problema p;
    protected int nfolds;
    protected int K=3;
    protected int calls;    
    protected ArrayList<Double> evolucao;
    protected double best;
    
    public AvaliadordeSolucao(Problema p){
        this.p = p;
        this.nfolds=10;
        this.calls=0;
        this.evolucao=new ArrayList<>();
        this.best = 0.0;
    }
    
    public double avalia(Solucao s){
        double precision=0.0, c;
        try {
            // cria vetor de indices dos atributos selecionados            
            int[] toremove = makeIndex(s);
            
            //remove atributos nao selecionados
            Remove remove = new Remove();
            remove.setAttributeIndicesArray(toremove);
            remove.setInvertSelection(true);
            remove.setInputFormat(p.getInstances());
            Instances subproblema = Filter.useFilter(p.getInstances(), remove);
            subproblema.setClassIndex(subproblema.numAttributes()-1);
            // classifica e pega o resultado
            Random rand = new Random(1);   // create seeded number generator
                                     
            IBk clf = new IBk(K);                        
            //SimpleNaiveBayes clf = new SimpleNaiveBayes();
            //NaiveBayesSimple clf = new NaiveBayesSimple();
            
            
            
            //clf.buildClassifier(subproblema);
            Evaluation eval = new Evaluation(subproblema);                
            eval.crossValidateModel(clf, subproblema, nfolds, rand);
            precision = (double)eval.correct()/subproblema.numInstances();            
            
            calls++;
            
        } catch (Exception ex) {
            Logger.getLogger(AvaliadordeSolucao.class.getName()).log(Level.SEVERE, null, ex);
        }        
                
        s.setQuality(precision);        

        if(precision > this.best){
            this.best = precision;
        }
        
        evolucao.add(this.best);                        
        return s.getQuality();
    }

    private int[] makeIndex(Solucao s) {        
        
        ArrayList<Integer> index = new ArrayList<>();
        int i=0;
        for (;i<s.getData().length;i++){
            if(s.getData()[i]==1){
                index.add(i);
            }
        }
        index.add(i);                        
                        
        int[] r = new int[index.size()];
        int j=0;
        for (Integer k : index) r[j++] = k;
        return r;
    }

    public int getCalls() {
        return calls;
    }

    public ArrayList<Double> getEvolucao() {
        return evolucao;
    }    
}
