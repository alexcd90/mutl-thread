package ch11;

import java.util.Arrays;
import java.util.Optional;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年08月26
 */
public class Test2 {

    public void test(){
        Arrays.asList(Thread.currentThread().getStackTrace()).stream()
                .filter(e -> !e.isNativeMethod())
                .forEach(e -> Optional.of(e.getClassName() + ":" + e.getMethodName()
                        + ":" + e.getLineNumber()).ifPresent(System.out::println));
    }
}
