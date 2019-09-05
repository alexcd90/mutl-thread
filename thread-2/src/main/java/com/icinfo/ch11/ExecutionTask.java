package com.icinfo.ch11;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年09月05
 */
public class ExecutionTask implements Runnable{
    private QueryFromDBAction queryAction = new QueryFromDBAction();
    private QueryFromHttpAction httpAction = new QueryFromHttpAction();


    @Override
    public void run() {
        queryAction.execute();
        System.out.println("The name query successful");
        httpAction.execute();
        System.out.println("The card id query successful");
        Context context = ActionContext.getActionContext().getContext();
        System.out.println("The Name is " + context.getName() + " and CardId " + context.getCardId());
    }
}
