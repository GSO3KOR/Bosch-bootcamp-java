package com.examples.java.nio;

import java.nio.charset.StandardCharsets;

public class EncodingExample {
    public static void main(String[] args) {
        char asciiChar = 'A';  // ASCII character
        char nonAsciiChar = 'é';  // Non-ASCII character (é)
//        char nonAsciiChar = '大';  // Non-ASCII character (大)


        // Convert to UTF-8/16 byte array and print byte lengths
        byte[] asciiBytesUtf8 = String.valueOf(asciiChar).getBytes(java.nio.charset.StandardCharsets.UTF_8);
        byte[] asciiBytesUtf16 = String.valueOf(asciiChar).getBytes(java.nio.charset.StandardCharsets.UTF_16);

        byte[] nonAsciiBytesUtf8 = String.valueOf(nonAsciiChar).getBytes(StandardCharsets.UTF_8);

        byte[] nonAsciiBytesUtf16 = String.valueOf(nonAsciiChar).getBytes(StandardCharsets.UTF_16);
        byte[] nonAsciiBytesUtf16BE = String.valueOf(nonAsciiChar).getBytes(StandardCharsets.UTF_16BE);
        byte[] nonAsciiBytesUtf16LE = String.valueOf(nonAsciiChar).getBytes(StandardCharsets.UTF_16LE);



        System.out.printf("Bytes for ASCII char '%s' with UTF-8: %s \n", asciiChar, asciiBytesUtf8.length);  // Should print 1
        System.out.printf("Bytes for ASCII char '%s' with UTF-16: %s \n", asciiChar, asciiBytesUtf16.length);  // Should print 4 as UTF16 uses 2 bytes for storing data and 2 bytes for BOM (Byte Order Mark) to indicate BigEndian or LittleEndian
        System.out.printf("Bytes for non-ASCII char '%s' with UTF-8: %s \n", nonAsciiChar, nonAsciiBytesUtf8.length);  // Should print 2
        System.out.printf("Bytes for non-ASCII char '%s' with UTF-16: %s \n", nonAsciiChar, nonAsciiBytesUtf16.length);  // Should print 4 as UTF16 uses 2 bytes for storing data and 2 bytes for BOM (Byte Order Mark) to indicate BigEndian or LittleEndian
        System.out.printf("Bytes for non-ASCII char '%s' with UTF-16BE: %s \n", nonAsciiChar, nonAsciiBytesUtf16BE.length);  // Should print 2 as UTF16BE uses 2 bytes for storing the data in BigEndian format
        System.out.printf("Bytes for non-ASCII char '%s' with UTF-16LE: %s \n", nonAsciiChar, nonAsciiBytesUtf16LE.length);  // Should print 2 as UTF16LE uses 2 bytes for storing the data in LittleEndian format

    }
}

