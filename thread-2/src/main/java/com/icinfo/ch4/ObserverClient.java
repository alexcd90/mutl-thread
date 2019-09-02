package com.icinfo.ch4;

/**
 * @program: mutl-thread
 * @description: ${description}
 * @author: jkk
 * @create: 2019-09-02 21:10
 */
public class ObserverClient {
    public static void main(String[] args) {
      final  Subject subject = new Subject();
      new BinaryObserver(subject);
      new OctalObserver(subject);

        System.out.println("==============");

        subject.setState(10);

        System.out.println("==============");

        subject.setState(10);

        System.out.println("==============");

        subject.setState(15);
    }
}
