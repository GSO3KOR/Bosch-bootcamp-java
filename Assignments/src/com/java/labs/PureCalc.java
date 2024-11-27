public class PureCalc {
    public static int add(int a, int b) {
        return a + b;
    }

    // Pure function to subtract two numbers
    public static int subtract(int a, int b) {
        return a - b;
    }

    // Pure function to multiply two numbers
    public static int multiply(int a, int b) {
        return a * b;
    }

    // Pure function to divide two numbers (returns Optional to handle divide-by-zero)
    public static java.util.Optional<Integer> divide(int a, int b) {
        if (b == 0) {
            return java.util.Optional.empty(); // Return empty if division by zero
        }
        return java.util.Optional.of(a / b);
    }

    // Method to demonstrate functional-style calculations
    public static void main(String[] args) {
        // Example calculations using pure functions
        int result1 = add(10, 5); // 15
        int result2 = subtract(result1, 3); // 12
        int result3 = multiply(result2, 4); // 48

        java.util.Optional<Integer> result4 = divide(result3, 2); // Optional[24]

        // Display the results
        System.out.println("Addition Result: " + result1); // 15
        System.out.println("Subtraction Result: " + result2); // 12
        System.out.println("Multiplication Result: " + result3); // 48
        result4.ifPresentOrElse(
                r -> System.out.println("Division Result: " + r), // 24
                () -> System.out.println("Division by zero is not allowed!")
        );
    }
}
