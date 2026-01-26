package java_streams;
import java.io.*;

public class ByteArrayStreamImageToByteArray {
    public static void main(String[] args) {

        try (FileInputStream fis = new FileInputStream("src/java_streams/img.jpg");
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            int data;
            //read image into byte array
            while ((data = fis.read()) != -1) {
                baos.write(data);
            }

            byte[] imageBytes = baos.toByteArray();

            // write byte array back to image
            try (ByteArrayInputStream yteArrayInputStream = new ByteArrayInputStream(imageBytes);
                 FileOutputStream fos = new FileOutputStream("outputImage.jpg")) {

                while ((data = yteArrayInputStream.read()) != -1) {
                    fos.write(data);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
