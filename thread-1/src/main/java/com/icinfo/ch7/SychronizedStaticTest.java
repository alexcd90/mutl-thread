package com.icinfo.ch7;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年08月09
 */
public class SychronizedStaticTest {
    public static void main(String[] args) {

        new Thread("T1") {
            @Override
            public void run() {
                SychronizedStatic.m1();
            }
        }.start();

        new Thread("T2") {
            @Override
            public void run() {
                SychronizedStatic.m2();
            }
        }.start();

        new Thread("T3") {
            @Override
            public void run() {
                SychronizedStatic.m3();
            }
        }.start();
    }

}
