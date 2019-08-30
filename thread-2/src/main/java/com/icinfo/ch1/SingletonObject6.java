package com.icinfo.ch1;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年08月30
 */
public class SingletonObject6 {

    private SingletonObject6(){

    }

    private static class InstanceHolder {
        private final static SingletonObject6 instance = new SingletonObject6();
    }

    public static SingletonObject6 getInstance(){
        return InstanceHolder.instance;
    }
}
