package com.examples.java.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelExample {
    public static void main(String[] args) {
        // Paths to input and output files
        String inputFile = "./input/input.txt";
        String outputFile = "./output/output.txt";

        // Reading a file using FileChannel
        try (FileInputStream fis = new FileInputStream(inputFile);
             FileChannel inputChannel = fis.getChannel()) {

            // Create a buffer
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            // Read data into the buffer
            while (inputChannel.read(buffer) > 0) {
                // Flip the buffer to prepare for reading
                buffer.flip();

                // Display the content (convert bytes to a string)
                while (buffer.hasRemaining()) {
                    System.out.print((char) buffer.get());
                }

                // Clear the buffer for reuse
                buffer.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Writing to a file using FileChannel
        try (FileOutputStream fos = new FileOutputStream(outputFile);
             FileChannel outputChannel = fos.getChannel()) {

            String data = "This is a test message written using FileChannel.";
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            // Write data into the buffer
            buffer.put(data.getBytes());

            // Flip the buffer to prepare for writing
            buffer.flip();

            // Write data from the buffer to the channel
            outputChannel.write(buffer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}