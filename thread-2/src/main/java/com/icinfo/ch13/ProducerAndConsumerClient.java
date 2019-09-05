package com.icinfo.ch13;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年09月05
 */
public class ProducerAndConsumerClient {

    public static void main(String[] args) {
        final MessageQueue messageQueue = new MessageQueue();
        new ProducerThread(messageQueue, 1).start();
        new ProducerThread(messageQueue, 2).start();
        new ProducerThread(messageQueue, 3).start();
        new ConsumerThread(messageQueue, 1).start();
//        new ConsumerThread(messageQueue, 2).start();
//        new ConsumerThread(messageQueue, 3).start();

    }


}
