package exceptions;
import java.io.FileInputStream;
import java.io.IOException;

public class CheckedException {
	public static void main(String[] args) {
		try {
			FileInputStream fileInputStream=new FileInputStream("src/exceptions/data.txt");
			int ch;
			while((ch=fileInputStream.read())!=-1) {
				System.out.print((char)ch);
			}
		}catch(IOException e) {    //handles file not found
			System.out.println("File not found!");
		}
	}

}
