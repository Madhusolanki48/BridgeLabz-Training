package json;
import java.io.*;
import java.util.*;

public class CsvToJson {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("data/data.csv"));
        String line;
        List<String> list = new ArrayList<>();
        br.readLine();

        //read CSV
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            list.add("{\"name\":\"" + data[0] + "\",\"age\":" + data[1] + "}");
        }

        //print JSON array
        System.out.println(list);
    }
}
