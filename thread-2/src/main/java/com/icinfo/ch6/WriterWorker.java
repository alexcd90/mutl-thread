package com.icinfo.ch6;

import java.util.Random;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年09月04
 */
public class WriterWorker extends Thread {
    private static final Random random = new Random(System.currentTimeMillis());

    private final SharedData data;

    private final String filter;

    private int index = 0;

    public WriterWorker(SharedData data, String filter) {
        this.data = data;
        this.filter = filter;
    }

    @Override
    public void run() {
        while (true) {

            try {
                char c = nextChar();
                data.write(c);
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private char nextChar() {
        char c = filter.charAt(index);
        index++;
        if (index>=filter.length()){
            index = 0;
        }
        return c;
    }
}
