package com.icinfo.ch16;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年09月05
 */
public class AppServer extends Thread{
    private final int port;

    private static final int DEFAULT_PORT = 12278;

    private volatile boolean start = true;

    private List<ClientHandler> clientHandlers = new ArrayList<>();

    private final ExecutorService executor = Executors.newFixedThreadPool(10);

    private ServerSocket server;

    public AppServer(int port) {
        this.port = port;
    }

    public AppServer() {
        this(DEFAULT_PORT);
    }

    @Override
    public void run() {
        try {
            this.server = new ServerSocket(port);
            while (start){
                final Socket socket = server.accept();
                final ClientHandler clientHandler = new ClientHandler(socket);
                executor.submit(clientHandler);
                this.clientHandlers.add(clientHandler);
            }
        } catch (IOException e) {
//            throw new RuntimeException(e);
        }finally {
            this.dispose();
        }
    }

    private void dispose(){
        System.out.println("dispose......");
        this.clientHandlers.stream()
                .forEach(ClientHandler::stop);
        this.executor.shutdown();
    }

    public void shutdown() throws IOException {
        this.start = false;
        this.interrupt();
        this.server.close();
    }
}
