package com.icinfo.ch1;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年08月30
 */
public class SingletonObject2 {

    private static SingletonObject2 instance;

    private SingletonObject2(){

    }

    public static SingletonObject2 getInstance(){
        if (null == instance){
            instance = new SingletonObject2();
        }
        return SingletonObject2.instance;
    }
}
