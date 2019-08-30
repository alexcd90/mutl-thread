package com.icinfo.ch4;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年08月05
 */
public class DaemonThread {
    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread() {

            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName() + " running");
                    Thread.sleep(100_000L);
                    System.out.println(Thread.currentThread().getName() + " done.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        // 守护线程在启动前设置,否则报错
        t.setDaemon(true);
        t.start();


        //JDK1.7
        Thread.sleep(5_000L);
        System.out.println(Thread.currentThread().getName());

    }
}
