package com.icinfo.ch6;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年08月05
 */
public class ThreadService {

    private Thread executeThead;

    private boolean finished = false;

    public void execute(Runnable task){
        executeThead = new Thread(()->{
            Thread runner = new Thread(task);
            runner.setDaemon(true);

            runner.start();

            try {
                runner.join();
                finished = true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        executeThead.start();

    }

    public void shutdown(long mills){
        long currentTime = System.currentTimeMillis();

        while (!finished){
            if ((System.currentTimeMillis() - currentTime) >= mills) {
                System.out.println("任务超时，需要结束他!");
                executeThead.interrupt();
                break;
            }

            try {
                executeThead.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("执行线程被打断!");
                break;
            }
        }

        finished = false;
    }
}
