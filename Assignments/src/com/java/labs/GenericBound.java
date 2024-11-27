package com.labs.java.generics;

public class GenericBound {

    // Generic method to print elements of an array
    public static <E> void printArray(E[] inputArray) {
        for (E element : inputArray) {
            System.out.printf("%s ", element);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Test the printArray method with different types of arrays

        // Integer Array
        Integer[] intArray = {1, 2, 3, 4, 5};
        System.out.println("Integer Array:");
        printArray(intArray);

        // String Array
        String[] stringArray = {"Hello", "Generics", "World"};
        System.out.println("String Array:");
        printArray(stringArray);

        // Double Array
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4};
        System.out.println("Double Array:");
        printArray(doubleArray);
    }
}
