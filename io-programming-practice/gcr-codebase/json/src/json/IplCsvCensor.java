package json;
import java.io.*;

public class IplCsvCensor {
    public static void main(String[] args) throws Exception {
        //read input CSV file
        BufferedReader br = new BufferedReader(new FileReader("data/ipl.csv"));

        //write output censored CSV file
        FileWriter fw = new FileWriter("data/ipl_censored.csv");

        //read and write header
        String header = br.readLine();
        fw.write(header + "\n");
        String line;
        while ((line = br.readLine()) != null) {

            //split CSV row
            String[] data = line.split(",");

            //mask team names
            data[1] = maskTeam(data[1]);
            data[2] = maskTeam(data[2]);

            //redact player of the match
            data[6] = "REDACTED";

            //write censored row
            fw.write(String.join(",", data) + "\n");
        }
        br.close();
        fw.close();
    }

    //team masking
    static String maskTeam(String team) {
        String[] parts = team.split(" ");
        return parts[0] + " ***";
    }
}
