package com.bosch.infotainment;

import java.util.Scanner;

public class SamWorld {
    public static void main(String[] args){
        System.out.println("Just do it!!0");
        /*
        System.exit(1);
        System.out.println("After exit");
         */
    }

    public static class Temperature {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter temp in celsius: ");
            Float tCelsius = scanner.nextFloat();
            Float tFahrenheit = (tCelsius * (9 / 5)) + 32;
            System.out.println("Temp in fahrenheit " + tFahrenheit);
        }
    }
}
