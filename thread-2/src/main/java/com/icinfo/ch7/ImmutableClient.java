package com.icinfo.ch7;

import java.util.stream.IntStream;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年09月04
 */
public class ImmutableClient {
    public static void main(String[] args) {
        Person person = new Person("Alex", "GuanSu");
        IntStream.range(0,5).forEach(i->
                new UsePersonThread(person).start());
    }
}
