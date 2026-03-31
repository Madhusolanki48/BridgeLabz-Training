package java_streams;
import java.io.*;

public class PipedStreamInterThreadCommunication {
    public static void main(String[] args) throws IOException {

        PipedOutputStream pipedOutputStream = new PipedOutputStream();
        PipedInputStream pipedInputStream = new PipedInputStream(pipedOutputStream);

        //reader thread
        Thread reader = new Thread(() -> {
            try {
                int data;
                while ((data = pipedInputStream.read()) != -1) {
                    System.out.print((char) data);
                }
                pipedInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        //writer thread
        Thread writer = new Thread(() -> {
            try {
                pipedOutputStream.write("Hello from Writer".getBytes());
                pipedOutputStream.flush();   //send data
                pipedOutputStream.close();   //signal end
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        //start reader first
        reader.start();
        writer.start();
    }
}
