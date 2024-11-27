package com.labs.java.io;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ProductImportSerializer {
    public static void main(String[] args) {
        String inputFilePath = "src/input.txt"; // Input file path
        String outputFilePath = "src/product.ser"; // Serialized output file path
        String outputProductPath = "src/output.txt"; // Deserialized output file path

        try {
            // Step 1: Read product details from input.txt
            BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
            String productDetails = reader.readLine(); // Assuming one line per product
            reader.close();

            // Step 2: Create a Product object
            String[] details = productDetails.split(",");
            int id = Integer.parseInt(details[0]);
            String name = details[1];
            double price = Double.parseDouble(details[2]);
            Product product = new com.labs.java.io.Product(id, name, price);

            System.out.println("Product created: " + product);

            // Step 3: Serialize the Product object using NIO
            ByteBuffer buffer = serialize(product);
            try (FileChannel fileChannel = FileChannel.open(Paths.get(outputFilePath), StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {
                fileChannel.write(buffer);
            }
            System.out.println("Product serialized to " + outputFilePath);

            // Step 4: Deserialize the Product object using NIO
            Product deserializedProduct;
            try (FileChannel fileChannel = FileChannel.open(Paths.get(outputFilePath), StandardOpenOption.READ)) {
                ByteBuffer readBuffer = ByteBuffer.allocate((int) fileChannel.size());
                fileChannel.read(readBuffer);
                readBuffer.flip();
                deserializedProduct = deserialize(readBuffer);
            }
            System.out.println("Product deserialized: " + deserializedProduct);

            // Step 5: Write the deserialized product to output.txt
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputProductPath))) {
                writer.write(deserializedProduct.toString());
            }
            System.out.println("Product written to " + outputProductPath);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
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

    // Deserialize method: Converts ByteBuffer to an object
    private static Product deserialize(ByteBuffer buffer) throws IOException, ClassNotFoundException {
        byte[] bytes = new byte[buffer.remaining()];
        buffer.get(bytes); // Read bytes from buffer
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        try (ObjectInputStream ois = new ObjectInputStream(bais)) {
            return (com.labs.java.io.Product) ois.readObject();
        }
    }
}
