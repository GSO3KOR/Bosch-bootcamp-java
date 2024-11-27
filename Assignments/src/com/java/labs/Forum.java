import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

public class Forum {

    // Custom RecursiveTask class
    static class SumTask extends RecursiveTask<Integer> {
        private final int[] array;
        private final int start;
        private final int end;

        private static final int THRESHOLD = 10; // Threshold for task splitting

        public SumTask(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {
            if ((end - start) <= THRESHOLD) {
                // If the task is small enough, calculate directly
                int sum = 0;
                for (int i = start; i < end; i++) {
                    sum += array[i];
                }
                return sum;
            } else {
                // Split the task into two subtasks
                int mid = (start + end) / 2;
                SumTask leftTask = new SumTask(array, start, mid);
                SumTask rightTask = new SumTask(array, mid, end);

                // Fork the subtasks
                leftTask.fork();
                rightTask.fork();

                // Combine the results
                int leftResult = leftTask.join();
                int rightResult = rightTask.join();
                return leftResult + rightResult;
            }
        }
    }

    public static void main(String[] args) {
        // Example array to sum
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1; // Fill array with numbers 1 to 100
        }

        // Create a ForkJoinPool
        ForkJoinPool pool = new ForkJoinPool();

        // Submit the main task to the pool
        SumTask mainTask = new SumTask(array, 0, array.length);
        int result = pool.invoke(mainTask);

        // Output the result
        System.out.println("Sum: " + result); // Should print 5050
    }
}
