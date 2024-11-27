import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {
    public static void main(String[] args) {
        // Create a thread pool with 10 threads
        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        // Submit 100 tasks to the thread pool
        for (int i = 1; i <= 100; i++) {
            threadPool.submit(new Task(i));
        }

        // Shutdown the thread pool after tasks are completed
        threadPool.shutdown();
    }
}

class Task implements Runnable {
    private final int taskId;

    public Task(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " processing Task-" + taskId);
        try {
            Thread.sleep(500); // Simulate some work
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
