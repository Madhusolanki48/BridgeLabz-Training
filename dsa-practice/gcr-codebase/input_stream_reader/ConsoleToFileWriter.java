package input_stream_reader;
import java.io.*;
//InputStreamReader Problem 2: Read User Input and Write to File Using InputStreamReader

public class ConsoleToFileWriter {
    public static void main(String[] args) {
        String filePath = "src/input_stream_reader/output.txt";

        try {
        	 //console input
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            //write file
            FileWriter fw = new FileWriter(filePath); 

            while (true) {
            	//read line
                String input = br.readLine();   
                if (input.equalsIgnoreCase("exit"))
                	break; 
                //write line
                fw.write(input + "\n");        
            }
            fw.close();
            System.out.println("Saved to file!");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}




