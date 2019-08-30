package ch1;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年08月05
 */
public class TryConcurrency {

    public static void main(String[] args) {
        Thread t = new Thread("Read-Thread") {
            @Override
            public void run() {
                //Read-Thread
                println(Thread.currentThread().getName());
                readFromDataBase();
            }
        };

        t.start();

        new Thread("WRITE-Thread"){
            @Override
            public void run() {
                writeDataToFile();
            }
        }.start();
    }

    private static void readFromDataBase() {
        //read data from database and handle it.
        try {
            println("Begin read data from db.");
            Thread.sleep(1000 * 40L);
            println("Read data done and start handle it.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        println("The data handle finish and successfully.");
    }

    private static void writeDataToFile() {
        try {
            println("Begin write data to file.");
            Thread.sleep(1000 * 40L);
            println("Write data done and start handle it.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        println("The data handle finish and successfully.");
    }

    private static void println(String message) {
        System.out.println(message);
    }

}
