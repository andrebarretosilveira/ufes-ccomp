/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trabfs.machineLeaningFrameWork.search.metaheuristics;
import trabfs.machineLeaningFrameWork.core.Solucao;
import java.util.Random;

/**
 *
 * @author rbroetto
 */
public class PRGeneticSearch extends GeneticSearch{        
        
    PathRelinking pr;
            
    @Override
    protected void reproducao() {   
        pr = new PathRelinking(p, as);
        Random rand = new Random(1);                
        populacao.clear();
        for(int i=0; i<pais.size()/2;i++){
            
            Solucao pai1 =  pais.get(rand.nextInt(pais.size()));
            Solucao pai2 =  pais.get(rand.nextInt(pais.size()));                        
            Solucao filho1 = pr.startPathRelinking(pai1, pai2);
            Solucao filho2 = pr.startPathRelinking(pai2, pai1);
                        
            populacao.add(pai1);
            populacao.add(pai2);
            populacao.add(filho1);
            populacao.add(filho2);
        }
    }
}
