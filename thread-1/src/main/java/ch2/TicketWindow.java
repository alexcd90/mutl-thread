package ch2;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年08月05
 */
public class TicketWindow extends Thread{

    private final String name;

    private static final int MAX = 50;

    // 线程非安全
    private static int index = 1;

    public TicketWindow(String name) {
        this.name = name;
    }

    @Override
    public void run(){
        while (index <= MAX){
            System.out.println("柜台：" + name + "当前的号码是:" + (index++));
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
