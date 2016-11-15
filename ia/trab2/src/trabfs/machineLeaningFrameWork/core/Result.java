/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabfs.machineLeaningFrameWork.core;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author raphael
 */
public class Result {
    protected Solucao solucao;
    protected long time;
    protected String dataset;
    protected String metodo;
    protected int calls;
    protected int run;
    protected ArrayList<Double> evolucao;
    
    public Solucao getSolucao() {
        return solucao;
    }

    public void setSolucao(Solucao solucao) {
        this.solucao = solucao;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getDataset() {
        return dataset;
    }

    public void setDataset(String dataset) {
        this.dataset = dataset;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public int getCalls() {
        return calls;
    }

    public void setCalls(int calls) {
        this.calls = calls;
    }

    public int getRun() {
        return run;
    }

    public void setRun(int run) {
        this.run = run;
    }
    
    
    
    public void printResult() {        
        System.out.println("Método : " + metodo.split("\\.")[metodo.split("\\.").length-1]);
        System.out.println("Dataset: " + dataset +"("+ solucao.getData().length +" características)");
        System.out.println("Solution: " + solucao.getBinaryFormat());
        System.out.println("Quality: " + solucao.getQuality());
        System.out.println("Calls: " + calls);
        System.out.println("Time: " + time);        
    }

    public void printResult(File f) {
        
        String output="";
        
        output += metodo.split("\\.")[metodo.split("\\.").length-1] +";";
        output += dataset+";";
        output += run+";";
        
        output += calls + ";";
        output += time + ";";
        int c=0;
        
        for(int i : solucao.getData()){
            output += i;            
            c+=i;
        }
        output += ";";
        DecimalFormat df = new DecimalFormat("#.###");
        output += df.format(solucao.getQuality()) +";"+ c + ";";        
        
        for(Double d : evolucao){
            output += d +" ";
        }
        
        try {
            appendInFile(f.getAbsolutePath(), output);
        } catch (IOException ex) {
            Logger.getLogger(Result.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void appendInFile(String p, String t) throws IOException {
        Files.write(
                Paths.get(p),
                t.getBytes(),
                StandardOpenOption.APPEND
        );
    }

    public void setEvolucao(ArrayList<Double> evolucao) {
        this.evolucao = evolucao;
    }
}
