package com.labs.java.io;
import java.io.*;
public class Pr implements Serializable {
    public static final long serialVersionUID = 2;
    public int id;
    public String name;
    public double price;

    Pr(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

