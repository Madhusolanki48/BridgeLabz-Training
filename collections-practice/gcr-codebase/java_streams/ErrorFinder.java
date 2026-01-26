package java_streams;
import java.io.*;

public class ErrorFinder {
    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new FileReader("src/java_streams/large.txt"))) {

            String line;
            // read line by line
            while ((line = br.readLine()) != null) {
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
