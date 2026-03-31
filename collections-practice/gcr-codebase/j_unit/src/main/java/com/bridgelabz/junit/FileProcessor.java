package com.bridgelabz.junit;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileProcessor {

    //method to write content to a file
    public void writeToFile(String filename, String content) throws IOException {
        Files.write(Path.of(filename), content.getBytes());
    }

    //method to read content from a file
    public String readFromFile(String filename) throws IOException {
        return Files.readString(Path.of(filename));
    }
}

