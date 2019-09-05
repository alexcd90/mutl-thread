package com.icinfo.ch14;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年09月05
 */
public class CountDown {
    private final int total;

    private int counter = 0;

    public CountDown(int total) {
        this.total = total;
    }

    public void down(){
        synchronized (this){
            this.counter++;
            this.notifyAll();
        }
    }

    public void await() throws InterruptedException {
        synchronized (this){
            while (counter!=total){
                this.wait();
            }
        }
    }
}
