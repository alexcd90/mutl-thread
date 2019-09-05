package com.icinfo.ch13;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年09月05
 */
public class ProducerThread extends Thread {

    private final MessageQueue queue;

    private final static Random random = new Random(System.currentTimeMillis());

    private final static AtomicInteger counter = new AtomicInteger(0);

    public ProducerThread(MessageQueue queue, int seq) {
        super("PRODUCER-" + seq);
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                final Message message = new Message("Message-" + counter.getAndIncrement());
                queue.put(message);
                System.out.println(Thread.currentThread().getName() + " put message " + message.getData());
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
