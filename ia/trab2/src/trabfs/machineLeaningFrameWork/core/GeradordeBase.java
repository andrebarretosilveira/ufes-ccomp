/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabfs.machineLeaningFrameWork.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import weka.core.Debug.Random;

/**
 *
 * @author projetoip
 */
public class GeradordeBase {
        
    int numeroe,numeroa,numeroc;
    double[] vetorPerturbacao;
    
    public void geraBase(int nume, int numa, int numc, String path){
        
        if(new File(path).exists())
            return;
        
        Random r = new Random();
        
        ArrayList<String> classes = new ArrayList<>();
        ArrayList<Exemplo> exemplos = new ArrayList<>();
        Hashtable<String,Exemplo> centroides = new Hashtable<>();
        Exemplo e;
        numeroe=nume;
        numeroa=numa;
        numeroc=numc;
                        
        //gera as classes e centroides de cada classe
        for(int i=0; i<numeroc;i++){
            String rot = "classe"+i;
            classes.add(rot);
            e = new Exemplo(numeroa);
            e.makeRandom();
            e.setClasse(rot);
            centroides.put(rot, e);            
        }
        
        //gera a perturbacao (variancia) para cada atributo
        vetorPerturbacao = makePerturbacao();
        
        // gera base
        for(int i=0; i<numeroe; i++){
            e = new Exemplo(numeroa);
            e.makeDerivate(centroides.get(classes.get(r.nextInt(classes.size()))),vetorPerturbacao);
            exemplos.add(e);
        }                
        
        toFile(exemplos, classes, path);
    }
    
    private void toFile(ArrayList<Exemplo> el,ArrayList<String> cl, String path){
        try {
            if(el.isEmpty()) return;
            PrintWriter writer = new PrintWriter(path, "UTF-8");            
            writer.print("@RELATION synteticdataset\n\n");
            for(int i=0; i<numeroa;i++) writer.print("@ATTRIBUTE atributo"+i+" REAL\n");
            writer.print("@ATTRIBUTE class {");
            for(int i=0; i<cl.size();i++){
                writer.print(cl.get(i));
                if(i<cl.size()-1) writer.print(",");
            }
            writer.print("}\n\n");
            writer.print("@DATA\n");            
            for(Exemplo e : el) writer.print(e.printExemplo()+"\n");
            
            writer.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GeradordeBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(GeradordeBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private double[] makePerturbacao() {
        double[] p = new double[numeroa];
        Random r = new Random();
        for(int i=0; i<numeroa;i++){
            p[i] = 0.5 + r.nextDouble();
        }
        return p;
    }
}

class Exemplo{
    
    double[] data;
    String classe;
    double amplitude=1000.0;
    double perturbacao=1.0;
    
    public Exemplo(int n){
        data = new double[n]; 
    } 
    
    public void setOn(int i,double v){
        data[i]=v;
    }
    
    public double getOn(int i){
        return data[i];
    }
    
    public void setClasse(String c){
        classe = c;
    }
    
    public String getClasse(){
        return classe;
    }
    
    public String printExemplo(){
        String r="";
        for(double d : data){
            r += d + ",";
        }
        r += classe;
        return r;
    }

    void makeRandom() {
        Random r = new Random();
        for(int i=0; i<data.length;i++){
            data[i] = r.nextDouble()*amplitude;
        }
    }

    void makeDerivate(Exemplo e,double[] p) {
        Random r = new Random();
        this.classe = e.getClasse();
        for(int i=0; i<data.length;i++){
            double pivot = e.getOn(i);
            double var = ( - p[i] + 2*p[i]*r.nextDouble())*amplitude;
            this.data[i] = pivot + var;
        }
    }        
}
