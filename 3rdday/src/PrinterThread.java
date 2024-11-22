class PrinterThread extends Thread {
    private String threadName;

    public PrinterThread(String name) {
        this.threadName = name;
    }

    @Override
    public void run() {
        // Print the thread's name and its state
        System.out.println("Printer Thread: " + threadName);

        for (int i = 1; i <= 7; i++) {
            System.out.println("Printer Thread " + threadName + ": " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Thread State: " + this.getState());
    }

    public static void main(String[] args) {
        // Create threads with different names
        PrinterThread thread1 = new PrinterThread("1");
        PrinterThread thread2 = new PrinterThread("2");

        // Start threads
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main Thread State: " + Thread.currentThread().getState());
    }
}
