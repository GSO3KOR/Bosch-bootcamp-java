public class HelloWorldJNI {
    static {
        System.loadLibrary("helloworld"); // No .dll extension
    }

    public native void sayHello();

    public static void main(String[] args) {
        new HelloWorldJNI().sayHello();
    }
}
