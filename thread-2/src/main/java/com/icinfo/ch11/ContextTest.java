package com.icinfo.ch11;

import java.util.stream.IntStream;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年09月05
 */
public class ContextTest {
    public static void main(String[] args) {
        IntStream.range(1,5)
                .forEach(i->
                        new Thread(new ExecutionTask()).start()
                        );
    }
}
