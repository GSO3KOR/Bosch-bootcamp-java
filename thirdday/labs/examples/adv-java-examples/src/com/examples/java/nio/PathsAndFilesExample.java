package com.examples.java.nio;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class PathsAndFilesExample {
    public static void main(String[] args) {
        try {
            // 0. Create a Directory
            Path path = Paths.get("nio");

            if(!Files.exists(path)) {
                Files.createDirectory(path);
                System.out.println("Directory Created");
            }else {
                System.out.println("Directory already exists");
            }


            // 1. Create a Path object
            Path filePath = Paths.get("./nio/example.txt");
            System.out.println("File Path: " + filePath);

            // 2. Check if the file exists
            if (!Files.exists(filePath)) {
                // 3. Create a new file
                Files.createFile(filePath);
                System.out.println("File created: " + filePath.toAbsolutePath());
            }

            // 4. Write content to the file
            String content = "Hello, Java NIO!";
            Files.write(filePath, content.getBytes());
            System.out.println("Content written to file.");

            // 5. Read content from the file
            String readContent = Files.readString(filePath);
            System.out.println("File Content: " + readContent);

            // 6. Get file attributes
            long size = Files.size(filePath);
            System.out.println("File Size: " + size + " bytes");

            boolean isReadable = Files.isReadable(filePath);
            System.out.println("Is Readable: " + isReadable);

            // 7. Copy the file
            Path copyPath = Paths.get("./nio/example_copy.txt");
            Files.copy(filePath, copyPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File copied to: " + copyPath.toAbsolutePath());

            // 8. Move the file
            Path movePath = Paths.get("./nio/example_moved.txt");
            Files.move(filePath, movePath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File moved to: " + movePath.toAbsolutePath());

            // 9. Create a directory
            Path dirPath = Paths.get("./nio/example_dir");
            if (!Files.exists(dirPath)) {
                Files.createDirectory(dirPath);
                System.out.println("Directory created: " + dirPath.toAbsolutePath());
            }

            // 10. List directory contents
            Path nestedFilePath = dirPath.resolve("nested_file.txt");
            Files.createFile(nestedFilePath);
            System.out.println("Created file in directory: " + nestedFilePath.toAbsolutePath());

            System.out.println("Directory contents:");
            try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(dirPath)) {
                for (Path entry : directoryStream) {
                    System.out.println(" - " + entry.getFileName());
                }
            }

            // 11. Delete files and directory
            Files.delete(nestedFilePath);
            Files.delete(dirPath);
            Files.delete(movePath);
            Files.delete(copyPath);
            System.out.println("All files and directories cleaned up.");

        } catch (IOException e) {
            System.err.println("Error occurred: " + e.getMessage());
        }
    }
}

