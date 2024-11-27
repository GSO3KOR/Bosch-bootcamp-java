package com.java.generics;

public class GenericsDemo<T> {
    private T someValue;

    public GenericsDemo(T someValue) {
        this.someValue = someValue;
    }

    // Getter
    public T getSomeValue() {
        return someValue;
    }

    // Setter
    public void setSomeValue(T someValue) {
        this.someValue = someValue;
    }

    // Method to display the type of T
    public void displayType() {
        System.out.println("Type of T: " + someValue.getClass().getName());
    }

    public static void main(String[] args) {
        // Example with String
        GenericsDemo<String> stringDemo = new GenericsDemo<>("Hello Generics");
        System.out.println("Value: " + stringDemo.getSomeValue());
        stringDemo.displayType();

        // Example with Integer
        GenericsDemo<Integer> integerDemo = new GenericsDemo<>(123);
        System.out.println("Value: " + integerDemo.getSomeValue());
        integerDemo.displayType();
    }
}
