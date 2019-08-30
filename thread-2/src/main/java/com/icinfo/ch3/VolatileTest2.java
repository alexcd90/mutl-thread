package com.icinfo.ch3;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年08月30
 */
public class VolatileTest2 {

    private static volatile int INIT_VALUE = 0;

    private final static int MAX_VALUE = 50;

    public static void main(String[] args) {
        new Thread(() -> {
            while (INIT_VALUE < MAX_VALUE) {
                int localValue = INIT_VALUE;
                localValue++;
                INIT_VALUE = localValue;
                System.out.println("T1->" + localValue);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, "ADDER-1").start();

        new Thread(() -> {
            while (INIT_VALUE < MAX_VALUE) {
                int localValue = INIT_VALUE;
                localValue++;
                INIT_VALUE = localValue;
                System.out.println("T2->" + localValue);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, "ADDER-2").start();


    }

}
