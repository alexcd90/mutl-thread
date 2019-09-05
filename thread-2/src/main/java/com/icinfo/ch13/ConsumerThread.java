package com.icinfo.ch13;

import java.util.Random;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年09月05
 */
public class ConsumerThread extends Thread{
    private final MessageQueue queue;

    private final static Random random = new Random(System.currentTimeMillis());

    public ConsumerThread(MessageQueue queue, int seq) {
        super("Consumer-" + seq);
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true){
            try {
                final Message message = queue.take();
                System.out.println(Thread.currentThread().getName() + " take a message " + message.getData());
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
