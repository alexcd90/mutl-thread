package com.icinfo.ch2;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年08月05
 */
public class TicketWindowRunnable implements Runnable {
    // 线程不安全
    //   private int index = 1;
   //    private volatile int index = 1;
    private int index = 1;
    private final static int MAX = 5000;

    @Override
    public void run() {
        while (index <= MAX) {
            System.out.println(Thread.currentThread() + " 的号码是:" + (index++));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
