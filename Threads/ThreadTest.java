package Threads;

public class ThreadTest {

    static int counter = 0;  

    public static void main(String[] args) throws InterruptedException {

        MyThread t1 = new MyThread();
        t1.start();

        Thread x = new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                counter++;
            }
        });

        Thread y = new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                counter++;
            }
        });

        x.start();
        Thread.sleep(2);
        y.start();

        x.join();
        y.join();

        System.out.println("Counter: " + counter);
    }

    // ThreadTest obj = new ThreadTest();
    // Thread a = new Thread(obj::increment);

    // Thread b = new Thread(obj::increment);

    // a.start();
    // b.start();

    // a.join();
    // b.join();

    // System.out.println("Counter: " + counter);
    
}