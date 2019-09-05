package com.icinfo.ch16;

import java.io.IOException;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年09月05
 */
public class AppServerClient {
    public static void main(String[] args) throws InterruptedException, IOException {
        final AppServer server = new AppServer();
        server.start();
        Thread.sleep(30_000L);
        server.shutdown();
    }
}
