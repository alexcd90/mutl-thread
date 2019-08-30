package ch9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Optional;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年08月09
 */
public class CaptureService {
    final static private LinkedList<Control> CONTROLS = new LinkedList<Control>();

    private final static int MAX_WORKER = 5;

    public static void main(String[] args) {

        ArrayList<Thread> worker = new ArrayList<>();

        Arrays.asList("M1" , "M2", "M3" , "M4" , "M5" , "M6", "M7", "M8", "M9", "M10").stream()
                .map(CaptureService::createCaptureThread)
                .forEach(t ->{
                    t.start();
                    worker.add(t);
                });

        worker.stream().forEach(t ->{
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Optional.of("All of capture work finished").ifPresent(System.out::println);

    }

    private static Thread createCaptureThread(String name){
        return new Thread(()->{
                Optional.of("The worker [" + Thread.currentThread().getName() + "] BEGIN capture data.")
                        .ifPresent(System.out::println);

                synchronized (CONTROLS){
                   while (CONTROLS.size() >= MAX_WORKER){
                       try {
                           CONTROLS.wait();
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                   }

                   CONTROLS.addLast(new Control());
                }

            Optional.of("The worker [" + Thread.currentThread().getName() + "] is working...")
                    .ifPresent(System.out::println);

            try {
                Thread.sleep(200_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (CONTROLS){
                Optional.of("The worker [" + Thread.currentThread().getName() + "] END capture data.")
                        .ifPresent(System.out::println);

                CONTROLS.removeFirst();
                CONTROLS.notifyAll();
            }
        },name);
    }

    private static class Control {
    }

}
