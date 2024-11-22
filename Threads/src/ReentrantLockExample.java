import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    private final Lock lock = new ReentrantLock();

    public void method1() {
        lock.lock();  // Acquire lock
        try {
            // Critical section
            method2(); // Can call method2 which also acquires the same lock
        } finally {
            lock.unlock();  // Release lock
        }
    }

    public void method2() {
        lock.lock();  // Reentrant lock acquired again
        try {
            // Another critical section
        } finally {
            lock.unlock();  // Release lock
        }
    }
}
