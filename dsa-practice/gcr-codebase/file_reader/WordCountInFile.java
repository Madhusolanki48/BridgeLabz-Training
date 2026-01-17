package file_reader;
import java.io.*;
//FileReader Problem 2: Count the Occurrence of a Word in a File Using FileReader

public class WordCountInFile {
    public static void main(String[] args) {
        String filePath = "src/file_reader/input.txt";
        String target = "AI";
        int count = 0;

        try {
        	//file reader
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;

            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+"); //split by space
                for (String word : words) {
                    if (word.equals(target))
                    	count++;   //match count
                }
            }
            br.close();
            System.out.println("Count = " + count);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
