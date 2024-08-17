// States and Thread Lifecycle
public class ThreadLifecycleDemo implements Runnable {
    public void run() {
        Thread currentThread = Thread.currentThread();
        System.out.println(currentThread.getName() + " is in state: " + currentThread.getState());
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadLifecycleDemo lifecycle = new ThreadLifecycleDemo();
        Thread thread = new Thread(lifecycle);
        
        System.out.println(thread.getName() + " is in state: " + thread.getState());
        thread.start();
        System.out.println(thread.getName() + " is in state: " + thread.getState());
        
        thread.join();
        System.out.println(thread.getName() + " is in state: " + thread.getState());
    }
}
