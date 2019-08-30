package com.icinfo.ch1;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年08月30
 */
public class SingletonObject5 {
    private static volatile SingletonObject5 instance;

    private SingletonObject5(){

    }

    public static SingletonObject5 getInstance(){
        if (null == instance){
            synchronized (SingletonObject5.class){
                if (null == instance){
                    instance = new SingletonObject5();
                }
            }
        }

        return SingletonObject5.instance;
    }
}
