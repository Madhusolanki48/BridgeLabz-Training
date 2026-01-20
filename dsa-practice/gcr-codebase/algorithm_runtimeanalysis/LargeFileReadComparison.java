package algorithm_runtimeanalysis;
import java.io.*;
public class LargeFileReadComparison {
	public static void main(String[] args) throws Exception {
        String filePath = "src/algorithm_runtimeanalysis/largeFile.txt"; 
        long start, end;

        //FileReader (character stream)
        start = System.nanoTime();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while (br.read() != -1) { } // reads char by char
        }
        end = System.nanoTime();
        System.out.println("FileReader Time: " + (end - start) / 1_000_000.0 + " ms");

        // InputStreamReader (byte stream + conversion)
        start = System.nanoTime();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)))) {
            while (br.read() != -1) { } 
        }
        end = System.nanoTime();
        System.out.println("InputStreamReader Time: " + (end - start) / 1_000_000.0 + " ms");
    }
}
