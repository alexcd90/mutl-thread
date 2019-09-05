package com.icinfo.ch4;

import java.util.List;

/**
 * @program: mutl-thread
 * @description: ${description}
 * @author: jkk
 * @create: 2019-09-02 21:33
 */
public class ThreadLifeCycleObserver implements LifeCycleListener{
    private final Object LOCK = new Object();

    public void cocurrentQuery(List<String> ids){
        if (ids == null || ids.isEmpty()){
            return;
        }

        ids.stream().forEach(id -> new Thread(new ObserverRunnable(this) {
            @Override
            public void run() {

                try {
                    notifyChanged(new RunnableEvent(RunnableState.RUNNING,Thread.currentThread(),null));
                    System.out.println("query for the id " + id);
                    Thread.sleep(1000L);
                    notifyChanged(new RunnableEvent(RunnableState.DONE,Thread.currentThread(),null));
                } catch (Exception e) {
                    notifyChanged(new RunnableEvent(RunnableState.ERROR,Thread.currentThread(),e));
                }
            }
        }).start());
    }



    @Override
    public void onEvent(ObserverRunnable.RunnableEvent event) {
        synchronized (LOCK){
            System.out.println("The runnable [" + event.getThread().getName() + "] data changed and state is [" + event.getState() + "]");
            if (event.getCause() != null){
                System.out.println("The runnable [" + event.getThread().getName() + "] process failed.");
                event.getCause().printStackTrace();
            }
        }
    }
}
