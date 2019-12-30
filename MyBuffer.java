package ds;

import java.io.Serializable;
import java.util.LinkedList;

public class MyBuffer implements Serializable {

    private int size ;
    LinkedList<String> data = new LinkedList<String>();

    public MyBuffer(int size) {
        this.size = size;
    }

    public void addWord(String s){
        this.data.add(s);
    }

    public int getSize() {
        return size;
    }

    public LinkedList<String> readword(){
        for (String da : data) {
            System.out.println(" ==> "+ da);
        }
        return data;
    }
    public void setSize(int size) {
        this.size = size;
    }
}