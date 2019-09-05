package com.icinfo.ch8;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年09月05
 */
public interface Future<T> {
    T get() throws InterruptedException;
}
