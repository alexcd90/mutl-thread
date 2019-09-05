package com.icinfo.ch8;

import java.util.function.Consumer;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年09月05
 */
public class FutureService {

    public <T> Future<T> submit(final FutureTask<T> task) {
        AsynFuture<T> asynFuture = new AsynFuture<>();
        new Thread(() -> {
            T result = task.call();
            asynFuture.done(result);
        }).start();
        return asynFuture;
    }

    public <T> Future<T> submit(final FutureTask<T> task, final Consumer<T> consumer){
        AsynFuture<T> asynFuture = new AsynFuture<>();
        new Thread(()->{
            T result = task.call();
            asynFuture.done(result);
            consumer.accept(result);
        }).start();
        return asynFuture;
    }

}
