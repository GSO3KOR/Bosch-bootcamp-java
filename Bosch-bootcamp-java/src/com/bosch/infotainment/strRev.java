public class strRev {
    public static void main(String[] args) {
        String str = "Welcome to Java Training";
        String revStr = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            revStr += str.charAt(i);
        }
        System.out.println("Reversed string: " + revStr);
    }
}
