package com.icinfo.ch15;

import java.util.stream.IntStream;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年09月05
 */
public class PerThreadClient {
    public static void main(String[] args) {
        final MessageHandler handler = new MessageHandler();

        IntStream.rangeClosed(1,10)
                .forEach(i->{
                    handler.request(new Message(String.valueOf(i)));
                });

        handler.shutdown();
    }
}
