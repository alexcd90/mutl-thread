package ch4;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年08月05
 */
public class DaemonThread2 {
    public static void main(String[] args) {

        Thread t = new Thread(() -> {
            Thread innerThread = new Thread(() -> {
                try {
                    while (true) {
                        System.out.println("Do some thing for health check.");
                        Thread.sleep(20_000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            //守护线程，立即结束
            innerThread.setDaemon(true);
            innerThread.start();

            try {
                Thread.sleep(5_000);
                System.out.println("T thread finish done.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        // 守护线程，立即结束
        t.setDaemon(true);
        t.start();


    }

}
