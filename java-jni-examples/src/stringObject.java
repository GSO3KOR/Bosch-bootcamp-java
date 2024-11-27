public class stringObject {
    static {
        System.loadLibrary("helloworld");
    }

    // Declare the native method that takes the stringObject as an argument
    public native void sayHello(stringObject messageObject);

    // Define a String field to hold the message
    private String message;

    // Constructor to initialize the message
    public stringObject(String message) {
        this.message = message;
    }

    // Getter for the message
    public String getMessage() {
        return message;
    }

    public static void main(String[] args) {
        // Create an instance of stringObject with the message
        stringObject obj = new stringObject("Arjun's thread is created!");

        // Pass the object to the native method
        obj.sayHello(obj);
    }
}
