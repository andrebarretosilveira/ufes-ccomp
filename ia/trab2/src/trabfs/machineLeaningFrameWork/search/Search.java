/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabfs.machineLeaningFrameWork.search;

import trabfs.machineLeaningFrameWork.core.Result;
import trabfs.machineLeaningFrameWork.core.Problema;
import trabfs.machineLeaningFrameWork.core.AvaliadordeSolucao;

/**
 *
 * @author raphael
 */
public abstract class Search {
        
    protected int N;    
    protected AvaliadordeSolucao as;    
    
    public Result startSearch(Problema p){
        return null;
    }
}
