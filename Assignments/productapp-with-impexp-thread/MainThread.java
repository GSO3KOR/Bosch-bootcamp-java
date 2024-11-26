package com.labs.java.concurrency;

public class MainThread {
    public static void main(String[] args){
        System.out.println("Thread name "+Thread.currentThread().getName());
        System.out.println("Thread name "+Thread.currentThread().getId());
        System.out.println("Thread name "+Thread.currentThread().getPriority());
    }
}

