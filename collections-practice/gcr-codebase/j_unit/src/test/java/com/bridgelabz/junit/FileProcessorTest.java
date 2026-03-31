package com.bridgelabz.junit;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileProcessorTest {
    FileProcessor processor = new FileProcessor();
    String filename = "testfile.txt";
    String content = "JUnit File Testing";

    //check write and read content
    @Test
    void testWriteAndReadFile() throws IOException {
        processor.writeToFile(filename, content);
        String result = processor.readFromFile(filename);
        assertEquals(content, result);
    }

    //check file exists after writing
    @Test
    void testFileExistsAfterWrite() throws IOException {
        processor.writeToFile(filename, content);
        assertTrue(Files.exists(Path.of(filename)));
    }

    //check IOException when file does not exist
    @Test
    void testReadNonExistingFile() {
        assertThrows(IOException.class, () -> {
            processor.readFromFile("nofile.txt");
        });
    }
}
