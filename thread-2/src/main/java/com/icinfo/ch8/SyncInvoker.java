package com.icinfo.ch8;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年09月05
 */
public class SyncInvoker {
    public static void main(String[] args) throws InterruptedException {
        /*String result = get();
        System.out.println(result);*/

        FutureService futureService = new FutureService();

        futureService.submit(()->{
            try {
                Thread.sleep(5000L);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            return "异步执行方式结束";
        });

        futureService.submit(()->{
            try {
                Thread.sleep(10000L);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            return "异步消费模式执行完毕";
        },System.out::println);

        System.out.println("main函数执行完毕");

    }

    private static String get() throws InterruptedException {
        Thread.sleep(10000L);
        return "Finish";
    }
}
