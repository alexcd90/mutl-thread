package com.icinfo.ch4;

/**
 * @program: mutl-thread
 * @description: ${description}
 * @author: jkk
 * @create: 2019-09-02 21:20
 */
public abstract class ObserverRunnable implements Runnable {
    final protected LifeCycleListener listener;

    public ObserverRunnable(final LifeCycleListener listener) {
        this.listener = listener;
    }

    protected void notifyChanged(final RunnableEvent event){
        listener.onEvent(event);
    }

    public enum RunnableState{
        RUNNING,ERROR,DONE
    }

    public static class RunnableEvent{
        private final RunnableState state;
        private Thread thread;
        private Throwable cause;

        public RunnableEvent(RunnableState state,Thread thread,Throwable cause){
            this.state = state;
            this.thread = thread;
            this.cause = cause;
        }

        public RunnableState getState(){
            return state;
        }

        public Thread getThread(){
            return thread;
        }

        public Throwable getCause(){
            return cause;
        }

    }
}
