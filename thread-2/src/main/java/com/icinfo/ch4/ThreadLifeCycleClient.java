package com.icinfo.ch4;

import java.util.Arrays;

/**
 * @program: mutl-thread
 * @description: ${description}
 * @author: jkk
 * @create: 2019-09-02 21:32
 */
public class ThreadLifeCycleClient {
    public static void main(String[] args) {
        new ThreadLifeCycleObserver().cocurrentQuery(Arrays.asList("1" , "3"));
    }
}
