package com.company;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Procssor extends Thread {

    private String Pname;
    public  MyBuffer buff;
    HashMap<String,Integer> wordsCounts = new HashMap<String,Integer>();


    public Procssor(String pname, MyBuffer buff) {
        Pname = pname;
        this.buff = buff;
    }

    public void run(){
        Set<String> s = this.wordsCounts.keySet();
        Iterator<String> it = s.iterator();
        while (it.hasNext()){
            it.remove();
        }
    }

    public void Processe(String n){
        Set<String> s = this.wordsCounts.keySet();
        Iterator<String> it = s.iterator();
        String t;
        while (it.hasNext()){
            if ((t=it.next()).equals(n))it.remove();
        }
    }

    public HashMap<String, Integer> getWordsCounts() {
        return wordsCounts;
    }
}
