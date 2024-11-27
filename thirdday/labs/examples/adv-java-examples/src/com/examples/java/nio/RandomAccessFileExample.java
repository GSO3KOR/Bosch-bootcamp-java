package com.examples.java.nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class RandomAccessFileExample {
    public static void main(String[] args) {
        // Using RandomAccessFile for reading and writing
        try (RandomAccessFile raf = new RandomAccessFile("./output/randomAccess.txt", "rw");
             FileChannel channel = raf.getChannel()) {

            // Writing data
            String data = "RandomAccessFile with FileChannel example.";
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            buffer.put(data.getBytes());
            buffer.flip();
            channel.write(buffer);

            // Reading the same data
            buffer.clear();
            channel.position(0); // Set position to the beginning
            channel.read(buffer);

            buffer.flip();
            while (buffer.hasRemaining()) {
                System.out.print((char) buffer.get());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
