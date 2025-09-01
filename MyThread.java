package session2;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * A demonstration class for multi-threading behavior.
 * This class shows how multiple threads can safely increment a shared counter.
 */
public class MyThread extends Thread {
    // Using AtomicInteger for thread-safe operations
    private static final AtomicInteger counter = new AtomicInteger(0);
    private static final Random RANDOM = new Random();
    private static final int ITERATION_COUNT = 10;
    private static final int MAX_SLEEP_TIME = 200;

    @Override
    public void run() {
        for (int i = 0; i < ITERATION_COUNT; i++) {
            int currentValue = counter.incrementAndGet();
            System.out.println(String.format("%s: Counter value = %d",
                Thread.currentThread().getName(), currentValue));

            try {
                Thread.sleep(Math.abs(RANDOM.nextInt() % MAX_SLEEP_TIME));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread interrupted: " + e.getMessage());
                break;
            }
        }
    }

    /**
     * Main method to demonstrate thread execution.
     * Creates and starts multiple threads to show concurrent execution.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();

        thread1.setName("Thread-1");
        thread2.setName("Thread-2");

        thread1.start();
        thread2.start();

        // Example of anonymous thread class
        Thread anonymousThread = new Thread(() ->
            System.out.println("Anonymous thread running")
        );
        anonymousThread.setName("Anonymous-Thread");
        anonymousThread.start();
    }
}
