package com.icinfo.ch11;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年09月05
 */
public final class ActionContext {

    private static final ThreadLocal<Context> threadLocal = new ThreadLocal<Context>(){
        @Override
        protected Context initialValue() {
            return new Context();
        }
    };

    public Context getContext(){
        return threadLocal.get();
    }

    private ActionContext() {

    }

    private static class ContextHolder {
        private final static ActionContext actionContext = new ActionContext();
    }

    public static ActionContext getActionContext(){
        return ContextHolder.actionContext;
    }


}
