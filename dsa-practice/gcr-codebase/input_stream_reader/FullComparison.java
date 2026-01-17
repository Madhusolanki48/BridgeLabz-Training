package input_stream_reader;
import java.io.*;
//Challenge Problem: Compare StringBuilder, StringBuffer, FileReader, and InputStreamReader

public class FullComparison {
    public static void main(String[] args) {
        int n = 1_000_000;
        String filePath = "src/input_stream_reader/input.txt";
        //stringBuilder time
        long stringBuilderStart = System.nanoTime();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++)
        	builder.append("hello");
        long stringBuilderEnd = System.nanoTime();

        //stringBuffer time
        long stringBufferStart = System.nanoTime();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < n; i++)
        	buffer.append("hello");
        long stringBufferEnd = System.nanoTime();

        System.out.println("StringBuilder time (ns): " 
        + (stringBuilderEnd - stringBuilderStart));
        System.out.println("StringBuffer time (ns): "
        + (stringBufferEnd - stringBufferStart));

        //FileReader word count
        try {
            long fileReaderStart = System.nanoTime();
            int wordCount1 = countWordsUsingFileReader(filePath);
            long fileReaderEnd = System.nanoTime();

            long inputStreamReaderStart = System.nanoTime();
            int wordCount2 = countWordsUsingInputStreamReader(filePath);
            long inputStreamReaderEnd = System.nanoTime();

            System.out.println("Word Count using FileReader: " + wordCount1 + " | time(ns): " + (fileReaderEnd - fileReaderStart));
            System.out.println("Words Count using InputStreamReader: " + wordCount2 + " | time(ns): " 
            + (inputStreamReaderEnd - inputStreamReaderStart));

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static int countWordsUsingFileReader(String filePath) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        int count = 0;
        String line;

        while ((line = br.readLine()) != null) {
            if (!line.trim().isEmpty())
            	count += line.trim().split("\\s+").length; //word count
        }
        return count;
    }

    static int countWordsUsingInputStreamReader(String filePath) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"));
        int count = 0;
        String line;

        while ((line = br.readLine()) != null) {
            if (!line.trim().isEmpty())
            	count += line.trim().split("\\s+").length; //word count
        }
        return count;
    }
}
