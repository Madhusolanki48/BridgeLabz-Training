package exceptions;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;

public class TryWithResources {
	public static void main(String[] args) {
		try {
			BufferedReader br=new BufferedReader(new FileReader("src/exceptions/data.txt"));
			System.out.println(br.readLine());
		}catch(IOException e) {
			//handles file read issues
			System.out.println("Error Reading file!");
		}
	}

}
