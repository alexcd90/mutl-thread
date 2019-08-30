package com.icinfo.ch8;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年08月09
 */
public class OtherService {

    private final Object lock = new Object();

    private DeadLock deadLock;

    public void s1() {
        synchronized (lock) {
            System.out.println("s1==========");
        }
    }

    public void s2() {
        synchronized (lock) {
            System.out.println("s2==========");
            deadLock.m2();
        }
    }

    public void setDeadLock(DeadLock deadLock) {
        this.deadLock = deadLock;
    }

}
