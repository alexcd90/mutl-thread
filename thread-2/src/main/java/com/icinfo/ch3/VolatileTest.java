package com.icinfo.ch3;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年08月30
 */
public class VolatileTest {
    private static volatile int INIT_VALUE = 0;

    private final static int MAX_VALUE = 50;

    public static void main(String[] args) {
        new Thread(()->{
            int localValue = INIT_VALUE;
            while (localValue < MAX_VALUE){
                if (localValue != INIT_VALUE){
                    System.out.printf(Thread.currentThread().getName()+" The value updated to [%d]\n", INIT_VALUE);
                    localValue = INIT_VALUE;
                }
            }
        },"READER").start();

        new Thread(()->{
            int localValue = INIT_VALUE;
            while (INIT_VALUE < MAX_VALUE){
                System.out.printf(Thread.currentThread().getName() + " Update the value to [%d]\n", ++localValue);
                INIT_VALUE = localValue;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "UPDATER").start();
    }
}
