package file_reader;
import java.io.*;
//FileReader Problem 1: Read a File Line by Line Using FileReader

public class ReadFileLineByLine {
    public static void main(String[] args) {
        String filePath = "src/file_reader/input.txt";

        try {
        	//FileReader object
            FileReader fr = new FileReader(filePath);  
            //line reader
            BufferedReader br = new BufferedReader(fr);        

            String line;
            while ((line = br.readLine()) != null) {   //read line
                System.out.println(line);
            }

            br.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}











