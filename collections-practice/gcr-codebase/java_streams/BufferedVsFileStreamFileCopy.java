package java_streams;
import java.io.*;

public class BufferedVsFileStreamFileCopy {
    public static void main(String[] args) throws IOException {
        File src = new File("src/java_streams/source.txt");
        File bufDest = new File("bufferedCopy.txt");
        File unbufDest = new File("unBufferedCopy.txt");

        byte[] buffer = new byte[4096];

        //Unbuffered
        long start1 = System.nanoTime();
        try (FileInputStream fis = new FileInputStream(src);
             FileOutputStream fos = new FileOutputStream(unbufDest)) {

            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
        long end1 = System.nanoTime();

        //Buffered
        long start2 = System.nanoTime();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(bufDest))) {

            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
        }
        long end2 = System.nanoTime();

        System.out.println("Unbuffered Time: " + (end1 - start1));
        System.out.println("Buffered Time: " + (end2 - start2));
    }
}

