package ch9;

import java.util.stream.Stream;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年08月09
 */
public class DifferenceOfWaitAndSleep {

    private final static Object LOCK = new Object();

    // SLEEP 不会释放锁
    // WAIT 会释放锁
    public static void main(String[] args) {
        Stream.of("T1" , "T2").forEach(name -> {
            new Thread(name){
                @Override
                public void run() {
                    m2();
                }
            }.start();
        });
    }

    public static void m1(){
        synchronized (LOCK){
            try {
                System.out.println("The Thread " + Thread.currentThread().getName() + " enter.");
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void m2(){
        synchronized (LOCK){
            try {
                System.out.println("The Thread " + Thread.currentThread().getName() + " enter.");
                LOCK.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
