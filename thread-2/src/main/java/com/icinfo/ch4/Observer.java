package com.icinfo.ch4;

/**
 * @program: mutl-thread
 * @description: ${description}
 * @author: jkk
 * @create: 2019-09-02 20:58
 */
public abstract class Observer {
    protected Subject subject;

    public Observer(Subject subject){
        this.subject = subject;
        this.subject.attch(this);
    }

    public abstract void update();
}
