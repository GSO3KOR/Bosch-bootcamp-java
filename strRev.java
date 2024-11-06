public class strRev {
    public static void main(String[] args) {
        String str = "Welcome to Java Training";
        String revStr = ""; // Initialize an empty string to hold the reversed string

        // Loop through the original string in reverse order
        for (int i = str.length() - 1; i >= 0; i--) {
            revStr += str.charAt(i); // Add each character from the end to the start
        }
        System.out.println("Reversed string: " + revStr);
    }
}
