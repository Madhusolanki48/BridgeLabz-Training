package json;
import java.io.FileReader;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ReadAllKeysValues {
    public static void main(String[] args) throws Exception {

        //read JSON file
        JsonObject obj = JsonParser
                .parseReader(new FileReader("data/user.json"))
                .getAsJsonObject();

        //print all keys and values
        for (String key : obj.keySet()) {
            System.out.println(key + " : " + obj.get(key));
        }
    }
}
