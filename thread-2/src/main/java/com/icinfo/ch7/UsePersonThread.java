package com.icinfo.ch7;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年09月04
 */
public class UsePersonThread extends Thread {
    private Person person;

    public UsePersonThread(Person person) {
        this.person = person;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + " print " + person.toString());
        }
    }
}
