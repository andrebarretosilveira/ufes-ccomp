/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabfs.machineLeaningFrameWork.core;

import java.text.DecimalFormat;
import java.util.ArrayList;
import weka.core.Debug;
import weka.core.Debug.Random;
import weka.core.Instances;

/**
 *
 * @author projetoip
 */
public class Solucao {

    
    private int[] data;
    double quality;    

    
    public Solucao(int n){
        data = new int[n];
        quality = 0.0;
    }
    
    public Solucao(Solucao t){
        data = t.data.clone();
        quality = t.getQuality();                
    }
    
    public int get(int n){
        return data[n];
    }
    
    public void set(int n,int v){
        if(v==0 || v==1)
            data[n]=v;
        else
            System.out.println("warning: use os valores 0 ou 1");
    }
    
    public int[] getData(){
        return data;
    }

    public void initRandom(){
        Random r = new Debug.Random();
        for(int i=0; i<data.length;i++){
            data[i] = r.nextInt(2);            
        }
    }
   
    public double getQuality() {
        return quality;
    }

    public void setQuality(double quality) {
        this.quality = quality;
    }

    public void setData(int[] data) {
        this.data = data;
    }

    public void inverte(int n){
        if(data[n]==1){
            data[n]=0;            
        }
        else{
            data[n]=1;            
        }
    }

    public String getBinaryFormat() {
        String s="";        
        for(int i=0; i<data.length;i++){
            s += data[i];
            if(i < data.length-1)
                s += ",";
        }
        return "["+s+"]";
    }

    public void initOne() {
        for(int i=0; i<data.length;i++){
            data[i] = 1;
        }
    }
    
     public void initZero(){        
        for(int i=0; i<data.length;i++){
            data[i] = 0;
        }
    }

    public boolean igual(Solucao candidate) {
        for(int i=0; i<data.length;i++){
            if(this.data[i] != candidate.data[i]){
                return false;
            }
        }
        return true;
    }
}
