package com.icinfo.ch2;

import java.util.Optional;
import java.util.concurrent.locks.Lock;
import java.util.stream.IntStream;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年08月30
 */
public class WaitSet {
    private static final Object LOCK = new Object();

    private static void work() {
        synchronized (LOCK) {
            System.out.println("Begin..........");

            try {
                System.out.println("Thread will coming");
                LOCK.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Thread will out");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        /*new Thread(){
            @Override
            public void run() {
                work();
            }
        }.start();

        Thread.sleep(10_000L);

        synchronized (LOCK){
            LOCK.notify();
        }*/

        IntStream.rangeClosed(1, 10).forEach(i ->
                new Thread(String.valueOf(i)) {
                    @Override
                    public void run() {
                        synchronized (LOCK) {

                            try {
                                Optional.of(Thread.currentThread().getName() + " will come to wait set.")
                                        .ifPresent(System.out::println);
                                LOCK.wait();
                                Optional.of(Thread.currentThread().getName() + " will leave from wait set.")
                                        .ifPresent(System.out::println);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }.start()
        );

        IntStream.rangeClosed(1, 10).forEach(i ->
                new Thread(String.valueOf(i)) {
                    @Override
                    public void run() {
                        synchronized (LOCK) {
                            LOCK.notifyAll();

                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }.start()
        );

    }
}
