import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOutputDemo {
    public static void main(String[] args) {

        String inputFile = "input.txt"; // Path to the file to be read
        String outputFile = "output.txt"; // Path to the file to be written

        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;

        try {
            inputStream = new FileInputStream(inputFile);
            outputStream = new FileOutputStream(outputFile);

            int val;
            while ((val = inputStream.read()) != -1) {
                System.out.print((char) val); // Print to console
                outputStream.write(val); // Write to output file
            }
            System.out.println("\nData successfully written to " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

