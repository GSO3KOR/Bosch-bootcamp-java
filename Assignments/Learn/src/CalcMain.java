import java.util.Scanner;

public class CalcMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Calculator!");
        System.out.print("Enter first number: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter second number: ");
        int num2 = scanner.nextInt();

        // Perform operations
        int addition = num1 + num2;
        int subtraction = num1 - num2;
        int multiplication = num1 * num2;
        double division = num2 != 0 ? (double) num1 / num2 : Double.NaN; // Handle division by zero

        // Display results
        System.out.println("Addition: " + addition);
        System.out.println("Subtraction: " + subtraction);
        System.out.println("Multiplication: " + multiplication);
        System.out.println("Division: " + (num2 != 0 ? division : "Undefined (division by zero)"));

        System.out.println("Process finished.");
    }
}
