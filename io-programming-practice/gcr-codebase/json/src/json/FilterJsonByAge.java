package json;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class FilterJsonByAge {
    public static void main(String[] args) {
        //JSON array
        String json = "[{\"name\":\"Aman\",\"age\":24},{\"name\":\"Rohit\",\"age\":28}]";

        //parse JSON
        JsonArray arr = JsonParser.parseString(json).getAsJsonArray();

        //filter age > 25
        for (int i = 0; i < arr.size(); i++) {
            JsonObject obj = arr.get(i).getAsJsonObject();
            if (obj.get("age").getAsInt() > 25) {
                System.out.println(obj);
            }
        }
    }
}
