package com.icinfo.ch7;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年09月04
 */
public class Person {
    private final String name;
    private final String address;

    public Person(final String name, final String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

}
