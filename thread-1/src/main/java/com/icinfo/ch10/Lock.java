package com.icinfo.ch10;


import java.util.Collection;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年08月26
 */
public interface Lock {

    class TimeOutException extends Exception {

        public TimeOutException(String msg){
            super(msg);
        }
    }

    void lock() throws InterruptedException;

    void lock(long mills) throws InterruptedException, TimeOutException;

    void unlock();

    Collection<Thread> getBlockedThread();

    int getBlockSize();

}
