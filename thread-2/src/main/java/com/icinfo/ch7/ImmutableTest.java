package com.icinfo.ch7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年09月04
 */
public class ImmutableTest {
    private final int age;
    private final String name;
    private final List<String> list;

    public ImmutableTest(int age,String name){
        this.age = age;
        this.name = name;
        list = new ArrayList<>();
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public List<String> getList() {
        return Collections.unmodifiableList(list);
    }

}
