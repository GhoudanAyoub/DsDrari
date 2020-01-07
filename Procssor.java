package ds;

import java.awt.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Procssor extends Thread {

    private String Pname;
    public  MyBuffer buff;
    HashMap<String,Integer> wordsCounts = new HashMap<String,Integer>();

    public Procssor() { }

    public Procssor(String pname, MyBuffer buff) {
        Pname = pname;
        this.buff = buff;
    }

    public void run(){
        System.out.println("---------->Procssor IN");
                System.out.println("---------->Procssor Working");
        do {
            Processe();
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("---------->Procssor Waiting ...");
        } while (this.buff.data.size() != 0);
        getWordsCounts();
        Lecteur.go();
        System.out.println("---------->Procssor OUT");
    }

    public void Processe(){
        String d;

            d = this.buff.data.poll();
            if (wordsCounts.containsKey(d)) {
                wordsCounts.put(d, wordsCounts.get(d) + 1);
            } else {
                wordsCounts.put(d, 1);
            }
    }

    public void getWordsCounts() {
        Set<String> setInt = wordsCounts.keySet();
        Iterator<String> it = setInt.iterator();
        while(it.hasNext()){
            String key = it.next();
            System.out.println("Valeur pour la clé " + key + " = " + wordsCounts.get(key));
        }
    }
}