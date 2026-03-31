package java_streams;
import java.io.*;

public class UserInputToFile {
    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             FileWriter fw = new FileWriter("src/java_streams/userData.txt")) {

            System.out.print("Enter name: ");
            String name = br.readLine();

            System.out.print("Enter age: ");
            String age = br.readLine();

            System.out.print("Enter favorite language: ");
            String lang = br.readLine();

            //write data to file
            fw.write("Name: " + name + "\n");
            fw.write("Age: " + age + "\n");
            fw.write("Language: " + lang + "\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

