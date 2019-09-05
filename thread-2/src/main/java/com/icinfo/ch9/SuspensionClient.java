package com.icinfo.ch9;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年09月05
 */
public class SuspensionClient {
    public static void main(String[] args) throws InterruptedException {
        RequestQueue queue = new RequestQueue();
        new ClientThread(queue,"Alex").start();
        ServerThread serverThread = new ServerThread(queue);
        serverThread.start();
//        serverThread.join();
        Thread.sleep(10000);
        serverThread.close();
    }
}
