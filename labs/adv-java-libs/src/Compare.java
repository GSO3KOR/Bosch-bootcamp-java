package com.labs.java.generics;

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
}
