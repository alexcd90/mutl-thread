package com.icinfo.ch12;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年09月05
 */
public class BalkingClient {
    public static void main(String[] args) {

        final BalkingData balkingData = new BalkingData("E:\\SrcCode\\mutl-thread\\thread-2\\src\\main\\java\\com\\icinfo\\ch12\\rest.txt", ">>>>>>>>>>Begin>>>>>>>>>>");

        new CustomerThread(balkingData).start();
        new WaiterThread(balkingData).start();

    }
}
