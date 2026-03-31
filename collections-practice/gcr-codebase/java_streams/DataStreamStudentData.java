package java_streams;
import java.io.*;

public class DataStreamStudentData {
    public static void main(String[] args) {

        //write data
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("student.txt"))) {

            dos.writeInt(101);
            dos.writeUTF("Maxwell");
            dos.writeDouble(8.6);

        } catch (IOException e) {
            e.printStackTrace();
        }

        //read data
        try (DataInputStream dis =new DataInputStream(new FileInputStream("student.txt"))) {

            System.out.println(dis.readInt());
            System.out.println(dis.readUTF());
            System.out.println(dis.readDouble());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
