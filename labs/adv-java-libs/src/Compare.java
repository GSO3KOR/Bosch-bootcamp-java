package com.labs.java.generics;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

public class Compare {

    // Generic method to compare two values of type T
    public static <T extends Comparable<T>> void compare(T a, T b) {
        if (a.compareTo(b) > 0) {
            System.out.println(a + " is greater than " + b);
        } else if (a.compareTo(b) < 0) {
            System.out.println(a + " is less than " + b);
        } else {
            System.out.println(a + " is equal to " + b);
        }
    }

    public static void main(String[] args) {
        compare(10, 20);
        compare("Apple", "Banana");
        compare(15.5, 10.2);
        compare('A', 'B');
    }

    public static class Account {

        int accountId;
        String name;
        String type;
        double balance;
        String branch;

        public Account(int accountId, String name, String type, double balance, String branch) {
            this.accountId = accountId;
            this.name = name;
            this.type = type;
            this.balance = balance;
            this.branch = branch;
        }

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }

        @ApplyInterest(roi = "7.5") // Custom annotation with the rate of interest
        public double calculateBalance() {
            try {
                // Reflection to check if the method has the annotation
                Method method = this.getClass().getMethod("calculateBalance");
                if (method.isAnnotationPresent(ApplyInterest.class)) {
                    ApplyInterest annotation = method.getAnnotation(ApplyInterest.class);
                    double interestRate = Double.parseDouble(annotation.roi());
                    double interest = this.balance * interestRate / 100;
                    this.balance += interest; // Update balance with interest
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            return this.balance;
        }

        @Override
        public String toString() {
            return "Account [accountId=" + accountId + ", name=" + name + ", type=" + type + ", balance=" + balance
                    + ", branch=" + branch + "]";
        }

        // Main method to demonstrate
        public static void main(String[] args) {
            // Create an Account instance
            Account account = new Account(1, "John Doe", "Savings", 1000.0, "Main Branch");

            // Print the initial account details
            System.out.println("Initial Account Details: " + account);

            // Calculate balance after applying interest
            account.calculateBalance();

            // Print the updated account details
            System.out.println("Updated Account Details: " + account);
        }
    }

    @Target(ElementType.METHOD) // This annotation will be applied to methods
    @Retention(RetentionPolicy.RUNTIME) // Make the annotation available at runtime
    public static @interface ApplyInterest {
        String roi(); // rate of interest
    }
}
