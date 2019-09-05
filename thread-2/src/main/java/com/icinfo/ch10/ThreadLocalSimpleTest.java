package com.icinfo.ch10;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年09月05
 */
public class ThreadLocalSimpleTest {
    private static ThreadLocal<String> threadLocal = new ThreadLocal<String>(){
        @Override
        protected String initialValue() {
            return "Alex";
        }
    };

    public static void main(String[] args) throws InterruptedException {
        String value = threadLocal.get();
        System.out.println(value);
        threadLocal.set("Alex-two");
        String value2 = threadLocal.get();
        System.out.println(value2);

    }
}
