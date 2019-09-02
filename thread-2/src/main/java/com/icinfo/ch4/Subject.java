package com.icinfo.ch4;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: mutl-thread
 * @description: ${description}
 * @author: jkk
 * @create: 2019-09-02 20:56
 */
public class Subject {
    private List<Observer> observers = new ArrayList<>();

    private int state;

    public void setState(int state){
        if (this.state == state){
            return;
        }
        this.state = state;
        notifyAllObserver();
    }

    public void attch(Observer observer){
        observers.add(observer);
    }

    private void notifyAllObserver() {
        observers.stream()
                .forEach(Observer::update);
    }

    public int getSate(){
        return this.state;
    }

}
