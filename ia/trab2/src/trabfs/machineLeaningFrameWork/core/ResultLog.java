/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabfs.machineLeaningFrameWork.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author raphael
 */
public class ResultLog {

    private static final String BASE_DIR = "resultlog/";

    private static final String ATTR_SEL = "atributos_selecionados.txt";
    private static final String TX_ACERTO = "taxa_de_acerto.txt";
    private static final String TM_EXEC = "tempo_de_execucao.txt";
    private static final String CALLS = "numero_de_chamadas.txt";

    private String runDir;

    public ResultLog() {
    }

    public void makeFiles() {
        Date d = new Date(System.currentTimeMillis());
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date(System.currentTimeMillis()));

        SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMddHHmmss");
        String formatted = format1.format(d);

        runDir = BASE_DIR + formatted + System.getProperty("file.separator");

        new File(runDir).mkdir();
    }

    public void doLog(Result r) {
        String p = runDir + r.getDataset() + "/" + r.getMetodo() + "/";
        new File(p).mkdirs();
        create(p + ATTR_SEL);
        create(p + TM_EXEC);
        create(p + TX_ACERTO);
        create(p + CALLS);

        try {
            
            appendInFile(p + ATTR_SEL, r.getSolucao().getBinaryFormat() + "\n");
            appendInFile(p + TM_EXEC, r.getTime() + "\n");
            appendInFile(p + TX_ACERTO, r.getSolucao().getQuality() + "\n");
            appendInFile(p + CALLS, r.getCalls() + "\n");
        } catch (IOException ex) {
            Logger.getLogger(ResultLog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void create(String p) {
        File file = new File(p);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(ResultLog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void appendInFile(String p, String t) throws IOException {
        Files.write(
                Paths.get(p),
                t.getBytes(),
                StandardOpenOption.APPEND
        );
    }

    private void clean(File file) {
        for (File f : file.listFiles()) {
            if (f.isFile()) {
                f.delete();
            } else {
                clean(f);
            }
        }
    }

    public void makeTables(String path) {
        File bd = new File(path);
        for (File f : bd.listFiles()) {
            if (f.isDirectory()) {
                System.out.println("dataset=" + f.getName() + ";");
                //makeAtributosSelecionados(f);
                makeTaxadeAcerto(f);
            }
        }
    }

    private void makeAtributosSelecionados(File dataset) {

        ArrayList<ArrayList<Double>> mtd_val = new ArrayList<>();
        ArrayList<String> mtd_lbl = new ArrayList<>();
        int repetition_size = 0;

        for (File f : dataset.listFiles()) {
            ArrayList<Double> val = new ArrayList<>();
            mtd_lbl.add(f.getName());
            File ff = getFile(f, ATTR_SEL);

            BufferedReader reader = null;

            try {
                reader = new BufferedReader(new FileReader(ff));
                String text = null;

                repetition_size = 0;
                while ((text = reader.readLine()) != null) {
                    int idx = 0;
                    for (String s : text.split(";")) {
                        if (val.size() < idx + 1) {
                            val.add(0.0);
                        }
                        val.set(idx, val.get(idx) + Double.parseDouble(s));
                        idx++;
                    }
                    repetition_size++;
                }

                mtd_val.add(val);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                }
            }
        }

        int m_size = mtd_lbl.size();
        int a_size = mtd_val.get(0).size();

        System.out.print(";");
        for (String m : mtd_lbl) {
            System.out.print(m + ";");
        }
        System.out.println();

        for (int i = 0; i < a_size; i++) {
            System.out.print("attr" + i + ";");
            for (int j = 0; j < m_size; j++) {
                String v = Double.toString(mtd_val.get(j).get(i) / repetition_size).replace('.', ',');
                System.out.print(v + ";");
            }
            System.out.println();
        }
    }

    private void makeTaxadeAcerto(File dataset) {

        ArrayList<ArrayList<Double>> mtd_val = new ArrayList<>();
        ArrayList<ArrayList<Double>> mtd_tim = new ArrayList<>();
        ArrayList<ArrayList<Double>> mtd_calls = new ArrayList<>();

        ArrayList<String> mtd_lbl = new ArrayList<>();
        int repetition_size = 0;

        File[] lf = dataset.listFiles();
        Arrays.sort(lf);

        for (File f : lf) {
            ArrayList<Double> val = new ArrayList<>();
            mtd_lbl.add(f.getName());
            File ff = getFile(f, TX_ACERTO);
            File ff2 = getFile(f, TM_EXEC);
            File ff3 = getFile(f, CALLS);

            BufferedReader reader = null;

            try {
                reader = new BufferedReader(new FileReader(ff));
                String text = null;

                val = new ArrayList<>();
                repetition_size = 0;
                while ((text = reader.readLine()) != null) {
                    int idx = 0;
                    val.add(Double.parseDouble(text));
                    repetition_size++;
                }
                mtd_val.add(val);
                reader.close();

                reader = new BufferedReader(new FileReader(ff2));
                val = new ArrayList<>();
                repetition_size = 0;
                while ((text = reader.readLine()) != null) {
                    int idx = 0;
                    val.add(Double.parseDouble(text));
                    repetition_size++;
                }
                mtd_tim.add(val);
                reader.close();

                reader = new BufferedReader(new FileReader(ff3));
                val = new ArrayList<>();
                repetition_size = 0;
                while ((text = reader.readLine()) != null) {
                    int idx = 0;
                    val.add(Double.parseDouble(text));
                    repetition_size++;
                }
                mtd_calls.add(val);
                reader.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                }
            }
        }

        int m_size = mtd_lbl.size();
        int a_size = mtd_val.get(0).size();

        System.out.print(";");
        for (String m : mtd_lbl) {
            System.out.print(m + ";;;");
        }
        System.out.println();

        System.out.print(";");
        for (String m : mtd_lbl) {
            System.out.print("acc;time;calls;");
        }
        System.out.println();

        for (int i = 0; i < a_size; i++) {
            System.out.print("run" + (i + 1) + ";");
            for (int j = 0; j < m_size; j++) {
                String a = Double.toString(mtd_val.get(j).get(i)).replace('.', ',');
                String b = Double.toString(mtd_tim.get(j).get(i) / 1000.0).replace('.', ',');
                String c = Double.toString(mtd_calls.get(j).get(i));
                System.out.print(a + ";" + b + ";" + c + ";");
            }
            System.out.println();
        }

        System.out.print("max;");
        for (int j = 0; j < m_size; j++) {
            String a = Double.toString(getMax(mtd_val.get(j))).replace('.', ',');
            String b = Double.toString(getMax(mtd_tim.get(j)) / 1000).replace('.', ',');
            String c = Double.toString(getMax(mtd_calls.get(j)));
            System.out.print(a + ";" + b + ";" + c + ";");
        }
        System.out.println();

        System.out.print("avg;");
        for (int j = 0; j < m_size; j++) {
            String a = Double.toString(getAvg(mtd_val.get(j))).replace('.', ',');
            String b = Double.toString(getAvg(mtd_tim.get(j)) / 1000).replace('.', ',');
            String c = Double.toString(getAvg(mtd_calls.get(j)));
            System.out.print(a + ";" + b + ";" + c + ";");
        }
        System.out.println();

    }

    private File getFile(File f, String q) {
        final String j = q;
        File[] files = f.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().contains(j);
            }
        });
        return files[0];
    }

    private Double getMax(ArrayList<Double> l) {
        Double maxV = Double.MIN_VALUE;
        for (Double v : l) {
            if (v > maxV) {
                maxV = v;
            }
        }
        return maxV;
    }

    private Double getAvg(ArrayList<Double> l) {
        Double sum = 0.0;
        for (Double v : l) {
            sum += v;
        }
        return sum / l.size();
    }
}
