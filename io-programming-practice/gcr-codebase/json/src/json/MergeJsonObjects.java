package json;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class MergeJsonObjects {
    public static void main(String[] args) {
        //first JSON object
        JsonObject obj1 = JsonParser.parseString(
                "{\"name\":\"Maxwell\",\"age\":23}"
        ).getAsJsonObject();

        //second JSON object
        JsonObject obj2 = JsonParser.parseString(
                "{\"email\":\"max@gmail.com\"}"
        ).getAsJsonObject();

        //merge obj2 into obj1
        for (String key : obj2.keySet()) {
            obj1.add(key, obj2.get(key));
        }
        
        //print merged JSON
        System.out.println(obj1);
    }
}
