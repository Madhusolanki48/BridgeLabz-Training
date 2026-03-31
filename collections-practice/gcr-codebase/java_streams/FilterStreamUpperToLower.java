package java_streams;
import java.io.*;

public class FilterStreamUpperToLower {
    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new FileReader("src/java_streams/input.txt"));
             BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"))) {

            String line;
            //convert uppercase to lowercase
            while ((line = br.readLine()) != null) {
                bw.write(line.toLowerCase());
                bw.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

