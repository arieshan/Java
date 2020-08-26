package session2;

import java.util.Random;

public class MyRunnable implements Runnable {
    public static int var = 0;
    @Override
    public void run() {
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
//            System.out.println("MyThread Running" + " " + Thread.currentThread().getName());
//            System.out.println(Thread.currentThread().getName() + "->" + "Running");
//            System.out.println(Thread.currentThread().getName() + " " + "is Running");
            var++;
            System.out.println(Thread.currentThread().getName() + "  " + var);
            try {
                Thread.sleep(Math.abs(rand.nextInt() % 200));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] argus) {
        MyRunnable runnable1 = new MyRunnable();
        MyRunnable runnable2 = new MyRunnable();
        Runnable runnable3 = () -> {System.out.println(Thread.currentThread().getName());};
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        Thread thread3 = new Thread(runnable3);
        thread1.start();
        thread2.start();
        runnable3.run();
    }
}
