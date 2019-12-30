package ds;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Lecteur extends Thread{

    private String fileName;
    private String threadName;
    private  MyBuffer buffer;
    public static boolean suspended = false;

    public Lecteur(String fileName, String threadName, MyBuffer buffer) {
        this.fileName = fileName;
        this.threadName = threadName;
        this.buffer = buffer;
    }

    private String[] readWord() throws IOException {
        String donnees = new String(Files.readAllBytes(Paths.get(fileName)));
        String [] mots = donnees.split("\\s");
        for (String m : mots) {
           // System.out.println("====>" + m);
        }
        return mots;
    }
    public synchronized   void run(){
        System.out.println("---------->Lecteur IN");
        try {
            System.out.println("---------->Lecteur Working");
            int n;
                n = readWord().length;
                String[] mm = readWord();
                for (int j = 0;j<n;j++) {
                    if (n >= this.buffer.getSize()) {
                        System.out.print("-->{Lecteur Waiting} ... Process working To empty Place \n");
                        synchronized (this){
                            while (suspended) wait();
                        }
                    }
                    this.buffer.addWord(mm[j]);
                }
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("---------->Lecteur out");
    }
    public static void go(){
        suspended = true;
    }

}