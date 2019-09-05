package com.icinfo.ch11;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年09月05
 */
public class QueryFromDBAction {
    public void execute(){
        try {
            Thread.sleep(1000L);
            String name = "Alex" + Thread.currentThread().getName();
            ActionContext.getActionContext().getContext().setName(name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
