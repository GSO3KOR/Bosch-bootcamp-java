package com.bosch.infotainment;

import java.util.Scanner;

public class TempConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Choose an option:");
            System.out.println("1. Celsius to Fahrenheit");
            System.out.println("2. Fahrenheit to Celsius");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter temperature in Celsius: ");
                    float tCelsius = scanner.nextFloat();
                    float tFahrenheit = (tCelsius * (9.0f / 5)) + 32;
                    System.out.println("com.bosch.infotainment.SamWorld.Temperature in Fahrenheit: " + tFahrenheit);
                    break;

                case 2:
                    System.out.print("Enter temperature in Fahrenheit: ");
                    tFahrenheit = scanner.nextFloat();
                    tCelsius = (tFahrenheit - 32) * (5.0f / 9);
                    System.out.println("com.bosch.infotainment.SamWorld.Temperature in Celsius: " + tCelsius);
                    break;

                case 3:
                    System.out.println("Exiting the program.");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please select 1, 2, or 3.");
            }
        }
        scanner.close();
    }
}
