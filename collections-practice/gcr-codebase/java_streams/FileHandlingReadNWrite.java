package java_streams;
import java.io.*;

public class FileHandlingReadNWrite {
	public static void main(String[] args) {
		File source = new File("src/java_streams/source.txt");
		File dest = new File("src/java_streams/destination.txt");

		//check if source file exists
		if (!source.exists()) {
			System.out.println("Source file does not exist");
			return;
		}

		try (FileInputStream fis = new FileInputStream(source);
				FileOutputStream fos = new FileOutputStream(dest)) {
			int data;
			//read and write byte by byte
			while ((data = fis.read()) != -1) {
				fos.write(data);
			}

			System.out.println("File copied successfully");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
