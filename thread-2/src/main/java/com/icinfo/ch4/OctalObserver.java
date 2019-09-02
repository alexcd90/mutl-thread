package com.icinfo.ch4;

/**
 * @program: mutl-thread
 * @description: ${description}
 * @author: jkk
 * @create: 2019-09-02 21:07
 */
public class OctalObserver extends Observer {

    public OctalObserver(Subject subject){
        super(subject);
    }

    @Override
    public void update() {
        System.out.println("Octal String: " + Integer.toOctalString(subject.getSate()));
    }
}
