package javaio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class iorecap {
    public static void main(String[] args) {

        File myObj = null;
        try {
            myObj = new File("C:\\");
            int n = 0;
            if (myObj.exists()){
                for (File e : myObj.listFiles()){
                    System.out.println(e.getName());
                }
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        


        //FileInputStream  ***************  FileOutputStream
        File f = new File("filename.txt");
        File f2 = new File("filename2.txt");
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(f2);
            fileInputStream =new FileInputStream(f);
            byte[] buf=  new  byte[10];
            int n = 0;
            long t = System.currentTimeMillis();
            while ((n=fileInputStream.read(buf))>=0){
                for (int i=0;i<n;i++) {
                    // System.out.print((char) buf[i]);
                    fileOutputStream.write((char) buf[i]);
                }
            }
            System.out.println("\ntime :"+(System.currentTimeMillis()-t));
            fileOutputStream.close();
            fileInputStream.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


        //BufferedInputStream  ***************  BufferedOutputStream
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream("filename.txt"));
            bufferedOutputStream =new BufferedOutputStream(new FileOutputStream("filename2.txt"));
            byte[] buf=  new  byte[10];
            int n = 0;
            long t2 = System.currentTimeMillis();
            while ((n=bufferedInputStream.read(buf))>=0){
                for (int i=0;i<n;i++) {
                    // System.out.print((char) buf[i]);
                    bufferedOutputStream.write((char) buf[i]);
                }
            }
            System.out.println("\ntime :"+(System.currentTimeMillis()-t2));
            bufferedOutputStream.close();
            bufferedInputStream.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        
        //************************ */
        DataInputStream dis;
        DataOutputStream dos;
        try{
            dos=new DataOutputStream( new BufferedOutputStream(new FileOutputStream(new File("filename.txt"))));
            dos.writeFloat(333.33f);
            dos.writeInt(55);
            dos.writeChar('f');
            dos.close();
            dis = new DataInputStream(new BufferedInputStream(new FileInputStream(new File("filename.txt"))));
            System.out.println(dis.readFloat());
            System.out.println(dis.readInt());
            System.out.println(dis.readChar());
            dis.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        //************* file channel  time
        FileChannel fc,fc2;
        try {
            fileInputStream = new FileInputStream(f);
            fileOutputStream = new FileOutputStream(f2);
            fc = fileInputStream.getChannel();
            fc2 = fileOutputStream.getChannel();
            int size = (int) fc.size();
            ByteBuffer byteBuffer = ByteBuffer.allocate(size);
            long t3 = System.currentTimeMillis();
            fc.read(byteBuffer);
            fc2.write(byteBuffer);

            byteBuffer.flip();
            System.out.println(" 5656time : "+(System.currentTimeMillis() - t3));
            byte[] tabbyte = byteBuffer.array();

        }catch (Exception e) {e.getMessage();}



        //=============================== 
        File f = new File("C:\\Users\\TheShadow\\IdeaProjects\\complexe\\src\\com\\company\\ttf.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
        int countChar = 0;
        int countWord = 0;
        int countSet = 0;
        int countPata = 0;
        String line;
        while ((line = reader.readLine())!=null){
            if (line.equals("")){
                countPata++;
            }
            if (!line.equals("")){
                countChar += line.length();

                String[] Wordlist = line.split("\\s+");
                countWord +=Wordlist.length;

                String[] Setlist = line.split("[!?,;]+");
                countSet += Setlist.length;

              }

        }System.out.println("Char : "+countChar+"|| Word : "+countWord+" || Set :"+countSet+" || Par : "+countPata);




    }
}