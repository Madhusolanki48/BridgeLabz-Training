package json;
import java.io.FileReader;
import java.io.FileWriter;
import com.google.gson.*;

public class IplJsonCensor {
    public static void main(String[] args) throws Exception {
        //read JSON file
        JsonArray matches = JsonParser
                .parseReader(new FileReader("data/ipl.json"))
                .getAsJsonArray();

        //process each match
        for (int i = 0; i < matches.size(); i++) {
            JsonObject match = matches.get(i).getAsJsonObject();

            //mask team names
            match.addProperty("team1", maskTeam(match.get("team1").getAsString()));
            match.addProperty("team2", maskTeam(match.get("team2").getAsString()));

            //redact player of the match
            match.addProperty("player_of_match", "REDACTED");
        }

        //write censored JSON
        FileWriter writer = new FileWriter("data/ipl_censored.json");
        writer.write(matches.toString());
        writer.close();
    }

    //team masking
    static String maskTeam(String team) {
        String[] parts = team.split(" ");
        return parts[0] + " ***";
    }
}
