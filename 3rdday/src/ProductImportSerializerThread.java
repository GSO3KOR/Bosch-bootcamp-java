package com.labs.java.io;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

// Product class (unchanged, same as provided)

public class ProductImportSerializerThread {
    public static void main(String[] args) {
        String inputFilePath = "src/input.txt"; // Input file path
        String outputFilePath = "src/product.ser"; // Serialized output file path
        String outputProductPath = "src/output.txt"; // Deserialized output file path

        // Create threads for import and export tasks
        Thread importThread = new Thread(() -> {
            try {
                importProduct(inputFilePath, outputFilePath);
            } catch (Exception e) {
                System.err.println("Import Thread Error: " + e.getMessage());
                e.printStackTrace();
            }
        });

        Thread exportThread = new Thread(() -> {
            try {
                exportProduct(outputFilePath, outputProductPath);
            } catch (Exception e) {
                System.err.println("Export Thread Error: " + e.getMessage());
                e.printStackTrace();
            }
        });

        // Start threads
        importThread.start();
        exportThread.start();

        // Wait for threads to complete
        try {
            importThread.join();
            exportThread.join();
        } catch (InterruptedException e) {
            System.err.println("Thread interrupted: " + e.getMessage());
        }

        System.out.println("Product import and export tasks completed.");
    }

    // Import task: Reads from a text file and serializes the product
    private static void importProduct(String inputFilePath, String outputFilePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
        String productDetails = reader.readLine(); // Assuming one line per product
        reader.close();

        // Parse product details and create a Product object
        String[] details = productDetails.split(",");
        int id = Integer.parseInt(details[0]);
        String name = details[1];
        double price = Double.parseDouble(details[2]);
        Product product = new Product(id, name, price);

        System.out.println("Import Thread: Product created: " + product);

        // Serialize the product and write to the file
        ByteBuffer buffer = serialize(product);
        try (FileChannel fileChannel = FileChannel.open(Paths.get(outputFilePath), StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {
            fileChannel.write(buffer);
        }
        System.out.println("Import Thread: Product serialized to " + outputFilePath);
    }

    // Export task: Reads from a serialized file and writes to a text file
    private static void exportProduct(String outputFilePath, String outputProductPath) throws IOException, ClassNotFoundException {
        Product deserializedProduct;
        try (FileChannel fileChannel = FileChannel.open(Paths.get(outputFilePath), StandardOpenOption.READ)) {
            ByteBuffer readBuffer = ByteBuffer.allocate((int) fileChannel.size());
            fileChannel.read(readBuffer);
            readBuffer.flip();
            deserializedProduct = deserialize(readBuffer);
        }
        System.out.println("Export Thread: Product deserialized: " + deserializedProduct);

        // Write the deserialized product to a text file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputProductPath))) {
            writer.write(deserializedProduct.toString());
        }
        System.out.println("Export Thread: Product written to " + outputProductPath);
    }

    // Serialize method: Converts an object to ByteBuffer
    private static ByteBuffer serialize(Product product) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
            oos.writeObject(product);
        }
        byte[] bytes = baos.toByteArray();
        ByteBuffer buffer = ByteBuffer.allocate(bytes.length);
        buffer.put(bytes);
        buffer.flip(); // Prepare the buffer for writing
        return buffer;
    }

    // Deserialize method: Converts a ByteBuffer to a Product object
    private static Product deserialize(ByteBuffer buffer) throws IOException, ClassNotFoundException {
        byte[] bytes = new byte[buffer.remaining()];
        buffer.get(bytes); // Read bytes from buffer
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        try (ObjectInputStream ois = new ObjectInputStream(bais)) {
            return (Product) ois.readObject();
        }
    }
}
