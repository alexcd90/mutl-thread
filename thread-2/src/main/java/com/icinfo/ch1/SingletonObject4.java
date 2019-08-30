package com.icinfo.ch1;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年08月30
 */
public class SingletonObject4 {
    private static SingletonObject4 instance;

    private SingletonObject4() {
        //---
    }

    public static SingletonObject4 getInstance(){
        if (null == instance){
            synchronized (SingletonObject4.class){
                if (null == instance){
                    instance = new SingletonObject4();
                }
            }
        }

        return SingletonObject4.instance;
    }
}
