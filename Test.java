package com.company;

import java.io.File;

public class Test {

    public static void main(String[] args) {

        String f = "C:\\fichier1.txt";
         String f2 = "C:\\fichier2.txt";
        MyBuffer buffer = new MyBuffer(100);
        Procssor procssor = new Procssor("Thread1",buffer);
        Procssor procssor2= new Procssor("Thread2",buffer);
        procssor.run();
        procssor2.run();
        new Lecteur(f,"Thread1",buffer);
        new Lecteur(f2,"Thread1",buffer);

    }
}
