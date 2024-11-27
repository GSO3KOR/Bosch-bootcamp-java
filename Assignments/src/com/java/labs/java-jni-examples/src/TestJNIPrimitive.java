public class TestJNIPrimitive {
    static {
        System.loadLibrary("myjni"); // Load the native library (myjni.dll or libmyjni.so)
    }

    // Declare the native method that takes two int parameters and returns a double
    private native double average(int n1, int n2);

    // Test Driver
    public static void main(String args[]) {
        // Print the result of the average calculation using JNI
        System.out.println("In Java, the average is " + new TestJNIPrimitive().average(81, 95));
    }
}
