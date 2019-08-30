package ch9;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年08月09
 */
public class ProduceConsumerVersion1 {
    private AtomicInteger i = new AtomicInteger(1);

    final private Object LOCK = new Object();

    private void produce() {
        synchronized (LOCK) {
            System.out.println("P->" + (i.getAndIncrement()));
        }
    }

    private void consume() {
        synchronized (LOCK) {
            System.out.println("C->" + i);
        }
    }


    public static void main(String[] args) {
        ProduceConsumerVersion1 pc = new ProduceConsumerVersion1();

        new Thread("P") {
            @Override
            public void run() {
                while (true) {
                    pc.produce();
                }
            }
        }.start();

        new Thread("C") {
            @Override
            public void run() {
                while (true) {
                    pc.consume();
                }
            }
        }.start();
    }

}


