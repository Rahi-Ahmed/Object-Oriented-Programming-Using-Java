import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    private static Semaphore semaphore = new Semaphore(1);

    public static void main(String[] args) {
        Thread t1 = new Thread(new Worker(), "Thread-1");
        Thread t2 = new Thread(new Worker(), "Thread-2");

        t1.start();
        t2.start();
    }

    static class Worker implements Runnable {
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + " is waiting for permit");
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName() + " gets permit");

                // Critical section
                Thread.sleep(1000);

                System.out.println(Thread.currentThread().getName() + " releases permit");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
