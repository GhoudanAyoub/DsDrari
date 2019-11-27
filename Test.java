package com.company;

import java.io.File;

public class Test {

    public static void main(String[] args) {

        String f = "C:\\Users\\TheShadow\\IdeaProjects\\complexe\\src\\com\\company\\ttf.txt";
        String f2 = "C:\\Users\\TheShadow\\IdeaProjects\\complexe\\src\\com\\company\\tt.txt";
        MyBuffer buffer = new MyBuffer(100);
        Procssor procssor = new Procssor("Thread1",buffer);
        Procssor procssor2= new Procssor("Thread2",buffer);
        procssor.start();
        procssor2.start();
        new Lecteur(f,"Thread1",buffer).start();
        new Lecteur(f2,"Thread1",buffer).start();

    }
}
