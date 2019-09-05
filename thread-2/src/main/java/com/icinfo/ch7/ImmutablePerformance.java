package com.icinfo.ch7;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年09月04
 */
public class ImmutablePerformance {
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        SyncObj syncObj = new SyncObj();
        syncObj.setName("Alex");

        Thread t1 = new Thread(){
            @Override
            public void run() {
                for (long l =0L;l<100;l++){
                    System.out.println(Thread.currentThread().getName() + "=" + syncObj.toString());
                }
            }
        };
        t1.start();

        Thread t2 = new Thread(){
            @Override
            public void run() {
                for (long l = 0L; l < 100; l++) {
                    System.out.println(Thread.currentThread().getName() + "=" + syncObj.toString());
                }
            }
        };
        t2.start();
        t1.join();
        t2.join();

        long endTime = System.currentTimeMillis();
        System.out.println("Elapsed time " + (endTime - startTime));

    }
}

final class ImmutableObj {
    private final String name;

    ImmutableObj(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "[" + name + "]";
    }
}

class SyncObj {
    private String name;

    public synchronized void setName(String name){
        this.name = name;
    }

    @Override
    public synchronized String toString() {
        return "[" + name + "]";
    }
}