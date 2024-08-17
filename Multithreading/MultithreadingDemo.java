//Introduction to Multithreading
public class MultithreadingDemo extends Thread {
    public void run() {
        try {
            System.out.println("Thread " + Thread.currentThread().getId() + " is running");
        } catch (Exception e) {
            System.out.println("Exception caught");
        }
    }

    public static void main(String[] args) {
        int n = 8; // Number of threads
        for (int i = 0; i < n; i++) {
            MultithreadingDemo thread = new MultithreadingDemo();
            thread.start();
        }
    }
}
