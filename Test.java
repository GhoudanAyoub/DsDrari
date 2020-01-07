package ds;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class Test {

    public static void main(String[] args) {

        String f2 = "C:\\Users\\TheShadow\\IdeaProjects\\complexe\\src\\com\\company\\tt.txt";

        MyBuffer buffer = new MyBuffer(100);

        Lecteur l2 =new Lecteur(f2,"Thread1",buffer);
        l2.start();
        Procssor p1 = new Procssor("Thread1",buffer);
        p1.start();


    }
}