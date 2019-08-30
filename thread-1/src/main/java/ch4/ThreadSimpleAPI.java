package ch4;

import java.util.Optional;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年08月05
 */
public class ThreadSimpleAPI {

    public static void main(String[] args) {
        Thread t = new Thread(()->{
            Optional.of("Hello").ifPresent(System.out::println);

            try {
                Thread.sleep(1_1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");

        t.start();
        Optional.of(t.getName()).ifPresent(System.out::println);
        Optional.of(t.getId()).ifPresent(System.out::println);
        Optional.of(t.getPriority()).ifPresent(System.out::println);


    }



}
