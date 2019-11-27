package com.company;

import java.util.LinkedList;

public class MyBuffer {

    private int size ;
    LinkedList<String> data = new LinkedList<String>();

    public MyBuffer(int size) {
        this.size = size;
    }

    public void addWord(String s){
        this.data.add(s);
    }

}
