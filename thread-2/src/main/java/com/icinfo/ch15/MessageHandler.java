package com.icinfo.ch15;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年09月05
 */
public class MessageHandler {
    private final static Random random = new Random(System.currentTimeMillis());

    private final static Executor executor = Executors.newFixedThreadPool(5);


    public void request(Message message){
        executor.execute(()->{
            final String value = message.getValue();
            try {
                Thread.sleep(random.nextInt(1000));
                System.out.println("The message will be handle by " + Thread.currentThread().getName() + " " + value);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    public void shutdown(){
        final ExecutorService service = Executors.newFixedThreadPool(5);
        ((ExecutorService)executor).shutdown();
    }
}
