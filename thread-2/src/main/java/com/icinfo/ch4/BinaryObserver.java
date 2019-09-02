package com.icinfo.ch4;

/**
 * @program: mutl-thread
 * @description: ${description}
 * @author: jkk
 * @create: 2019-09-02 21:08
 */
public class BinaryObserver extends Observer {
    public BinaryObserver(Subject subject){
        super(subject);
    }
    @Override
    public void update() {
        System.out.println("Binary String " + Integer.toBinaryString(subject.getSate()));
    }
}
