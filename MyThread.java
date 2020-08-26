package session2;

import java.util.Random;

public class MyThread extends Thread{

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
        MyThread myThread = new MyThread();
        MyThread myThread2 = new MyThread();
        myThread.start();
        myThread2.start();
        Thread thread = new Thread() {
            public void run() {
            System.out.println("Thread Running");
            }
        };
        thread.start();
    }
}


//Thread thread = new Thread() {
//    public void run() {
//        System.out.println("Thread Running");
//    }
//}
//thread.start();