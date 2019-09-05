package com.icinfo.ch10;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年09月05
 */
public class ThreadLocalSimulator<T> {
    private final Map<Thread,T> storage = new HashMap<>();

    public void set(T t){
        synchronized (this){
            Thread key = Thread.currentThread();
            storage.put(key, t);
        }
    }

    public T get(){
        synchronized (this){
            Thread key = Thread.currentThread();
            T value = storage.get(key);
            if (value==null){
                return initValue();
            }
            return value;
        }
    }

    public T initValue() {
        return null;
    }
}
