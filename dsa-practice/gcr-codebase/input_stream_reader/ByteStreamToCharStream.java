package input_stream_reader;
import java.io.*;
//InputStreamReader Problem 1: Convert Byte Stream to Character Stream Using InputStreamReader

public class ByteStreamToCharStream {
    public static void main(String[] args) {
        String filePath = "src/input_stream_reader/input.txt";

        try {
            FileInputStream fis = new FileInputStream(filePath); // byte stream
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8"); // byte->char
            BufferedReader br = new BufferedReader(isr); // line reader

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
