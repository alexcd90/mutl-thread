package ch2;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年08月05
 */
public class BankVersion2 {
    private final static int MAX = 500;

    public static void main(String[] args) {
//        final TicketWindowRunnable ticketWindow = new TicketWindowRunnable();

        final Runnable ticketWindow = () -> {
            int idx = 1;
            while (idx < MAX) {
                System.out.println(Thread.currentThread() + " 的号码是:" + (idx++));
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread windowThread1 = new Thread(ticketWindow, "一号窗口");
        Thread windowThread2 = new Thread(ticketWindow, "二号窗口");
        windowThread1.start();
        windowThread2.start();

    }
}
