package ds;

import java.io.IOException;

public class Test {

    public static void main(String[] args) throws IOException, InterruptedException {

        String f = "C:\\Users\\TheShadow\\IdeaProjects\\complexe\\src\\com\\company\\ttf.txt";
        String f2 = "C:\\Users\\TheShadow\\IdeaProjects\\complexe\\src\\com\\company\\tt.txt";

        MyBuffer buffer = new MyBuffer(1000);

        Lecteur l2 =new Lecteur(f2,"Thread1",buffer);
        l2.start();
        Procssor p1 = new Procssor("Thread1",buffer);
        p1.start();
    }
}