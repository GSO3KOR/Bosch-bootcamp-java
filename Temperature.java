import java.util.Scanner;
public class Temperature {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter temp in celsius: ");
        Float tCelsius = scanner.nextFloat();
        Float tFahrenheit = (tCelsius * (9 / 5)) + 32;
        System.out.println("Temp in fahrenheit " + tFahrenheit);
    }
}
