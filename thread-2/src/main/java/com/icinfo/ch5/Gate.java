package com.icinfo.ch5;

/**
 * @program: mutl-thread
 * @description: ${description}
 * @author: jkk
 * @create: 2019-09-02 22:20
 */
public class Gate {
    private int counter = 0;

    private String name ="Nobody";

    private String address = "Nowhere";

    public synchronized void pass(String name, String address){
        this.counter++;
        this.name = name;
        this.address = address;
        verify();
    }

    private void verify(){
        if (this.name.charAt(0) != this.address.charAt(0)){
            System.out.println("*******BROKEN********" + toString());
        }
    }

    public synchronized String toString(){
        return "No." + counter + ":" + name + "," + address;
    }
}
