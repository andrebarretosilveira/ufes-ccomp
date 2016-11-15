/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabfs.machineLeaningFrameWork.core;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import weka.attributeSelection.ASEvaluation;
import weka.attributeSelection.AttributeSelection;
import weka.attributeSelection.ChiSquaredAttributeEval;
import weka.attributeSelection.InfoGainAttributeEval;
import weka.attributeSelection.Ranker;
import weka.attributeSelection.ReliefFAttributeEval;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

/**
 *
 * @author projetoip
 */
public class Problema {
    private int numAtributos;
    private int numExemplos;
    private Instances data;
    double[][] R;
    
    public Problema(String path){        
        try {
            DataSource source = new DataSource(path);        
            data = source.getDataSet();            
            data.setClassIndex(data.numAttributes() - 1);            
            numAtributos = data.numAttributes();
            numExemplos = data.numInstances();                                    
        } catch (Exception ex) {
            Logger.getLogger(Problema.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }

    public int getNumAtributos() {
        return numAtributos;
    }

    public int getNumExemplos() {
        return numExemplos;
    }
    
    public Instances getInstances(){
        return data;
    }

    public void setInstances(Instances data) {
        this.data = data;
    }        

    public double[] getAttributeQuality() {
        try {
            
            ASEvaluation[] filters = {
                new InfoGainAttributeEval(),
                new ChiSquaredAttributeEval(),
                new ReliefFAttributeEval()
            };
            R = new double[data.numAttributes()-1][filters.length];
            Ranker rk = new Ranker();            
            AttributeSelection selec = new AttributeSelection();
            selec.setSearch(rk);
            
            for(int j=0; j<filters.length;j++){
                selec.setEvaluator(filters[j]);
                selec.SelectAttributes(data);
                double[][] full = selec.rankedAttributes();
                //double[] r = new double[full.length];

                
                Arrays.sort(full,new Comparator(){
                    @Override
                    public int compare(Object t, Object t1) {
                        double[]a1 = (double[])t;
                        double[]a2 = (double[])t1;
                        if(a1[0] > a2[0])
                            return 1;
                        else if(a1[0] < a2[0])
                            return -1;
                        else
                            return 0;
                    }
                });                                

                double max=Double.NEGATIVE_INFINITY, min=Double.POSITIVE_INFINITY;
                for(int i=0; i<full.length;i++){
                    if(full[i][1] < min) min = full[i][1];
                    if(full[i][1] > max) max = full[i][1];
                }
                
                // armazena
                for(int i=0; i<full.length;i++){
                    R[i][j] = (full[i][1]-min)/(max-min);                
                }            
            }
        
            double[] Rfinal = new double[data.numAttributes()-1];
            double SW = 1.0f;
            for(int i=0; i<Rfinal.length;i++){
                Rfinal[i] = somaWK(i)/3.0f;                
            }                        
            
            return Rfinal;            
        } catch (Exception ex) {
            Logger.getLogger(Problema.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return null;
    }
    
    private double w(int i, int j){
        return R[i][j];
    }

    private double somaW() {
        double s=0.0;
        for(double[] r : R){
            for(double rr : r){
                s += rr;
            }
        }
        return s;
    }
    
    private double somaWK(int k) {
        double s=0.0;
        for(double r : R[k]){            
            s += r;            
        }
        return s;
    }
}
