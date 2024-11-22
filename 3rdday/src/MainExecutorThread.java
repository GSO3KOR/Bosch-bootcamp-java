import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainExecutorThread {
    public static void main(String[] args) {
        // Create a thread pool with a fixed number of threads
        ExecutorService es = Executors.newFixedThreadPool(2);

        // Define tasks to be executed
        Runnable task1 = new PrinterTask("Task 1");
        Runnable task2 = new PrinterTask("Task 2");

        // Submit tasks to the executor service
        es.submit(task1);
        es.submit(task2);

        // Shut down the executor service gracefully
        es.shutdown();
    }
}

// A simple class implementing Runnable for tasks
class PrinterTask implements Runnable {
    private String taskName;

    public PrinterTask(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " processing " + taskName + "...");
    }
}
