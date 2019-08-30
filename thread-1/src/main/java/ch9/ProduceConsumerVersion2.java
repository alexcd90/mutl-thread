package ch9;

import java.util.stream.Stream;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年08月26
 */
public class ProduceConsumerVersion2 {
    private int i = 0;

    final private Object LOCK = new Object();

    private volatile boolean isProduced = false;

    public void produce(){
        synchronized (LOCK){
            if (isProduced){
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else {
                i++;
                System.out.println(Thread.currentThread().getName() + " P-> " + i);
                LOCK.notifyAll();
                isProduced = true;
            }
        }
    }

    public void consume(){
        synchronized (LOCK){
            if (isProduced){
                System.out.println(Thread.currentThread().getName() + " C-> " +i);
                LOCK.notifyAll();
                isProduced = false;
            }else {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        ProduceConsumerVersion2 produceConsumerVersion2 = new ProduceConsumerVersion2();

        Stream.of("P1" , "P2").forEach(n ->{
            new Thread(n){
                @Override
                public void run() {
                    while (true){
                        produceConsumerVersion2.produce();
                    }
                }
            }.start();
        });

        Stream.of("C1" , "C2").forEach(n ->{
            new Thread(n){
                @Override
                public void run() {
                    while (true){
                        produceConsumerVersion2.consume();
                    }
                }
            }.start();
        });
    }
}
