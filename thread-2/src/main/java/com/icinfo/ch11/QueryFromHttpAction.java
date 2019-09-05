package com.icinfo.ch11;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年09月05
 */
public class QueryFromHttpAction {
    public void execute(){
        Context context = ActionContext.getActionContext().getContext();
        String name = context.getName();
        String cardID = getCarID(name);
        context.setCardId(cardID);
    }

    private String getCarID(String name) {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "435467523543" + Thread.currentThread().getId();
    }
}
