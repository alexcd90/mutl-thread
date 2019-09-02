package com.icinfo.ch4;

/**
 * @program: mutl-thread
 * @description: ${description}
 * @author: jkk
 * @create: 2019-09-02 21:18
 */
public interface LifeCycleListener {
    void onEvent(ObserverRunnable.RunnableEvent event);
}
