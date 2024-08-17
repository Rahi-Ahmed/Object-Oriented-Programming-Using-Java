//Handling Threads in Java
public class RunnableDemo implements Runnable {
    public void run() {
        System.out.println("RunnableDemo is running");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableDemo());
        thread.start();
    }
}
