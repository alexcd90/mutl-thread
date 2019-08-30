package com.icinfo.ch1;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年08月30
 */
public class SingletonObject3 {
    private static SingletonObject3 instance;

    private SingletonObject3() {
        //empty
    }

    public synchronized static SingletonObject3 getInstance(){
        if (null == instance){
            instance = new SingletonObject3();
        }
        return SingletonObject3.instance;
    }

}
