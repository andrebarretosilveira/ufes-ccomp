package trabfs.machineLeaningFrameWork.search.misc;

import trabfs.machineLeaningFrameWork.core.AvaliadordeSolucao;
import trabfs.machineLeaningFrameWork.core.Solucao;
import trabfs.machineLeaningFrameWork.core.Problema;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import weka.attributeSelection.AttributeSelection;
import weka.attributeSelection.WrapperSubsetEval;
import weka.attributeSelection.GeneticSearch;
import weka.classifiers.lazy.IBk;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author projetoip
 */
public class BlackBox {
    public double startBlackBox(Problema p){
        try {
            Random r = new Random();
            //cria avaliador de solucao
            AvaliadordeSolucao ads = new AvaliadordeSolucao(p);            
            //seta busca            
            GeneticSearch gs =  new GeneticSearch();                        
            gs.setSeed(r.nextInt());            
            //seta evaluator
            WrapperSubsetEval wse = new WrapperSubsetEval();
            //seta classificador
            IBk ibk = new IBk(3);
            // seta selecao de atributos
            AttributeSelection as = new AttributeSelection();
            
            //liga componentes
            wse.setClassifier(ibk);            
            as.setSearch(gs);
            as.setEvaluator(wse);                        
                                    
            //usa metodo e pega solucao
            Solucao s = new Solucao(p.getNumAtributos()-1);
            s.initZero();
            as.SelectAttributes(p.getInstances());            
            for(int i=0; i < as.selectedAttributes().length-1; i++){                
                s.set(as.selectedAttributes()[i], 1);
            }  
            ads.avalia(s);
            return s.getQuality();
            
        } catch (Exception ex) {
            Logger.getLogger(BlackBox.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0.0;
    }
}
