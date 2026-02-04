package json;
import java.io.FileReader;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class MergeJsonFiles {
    public static void main(String[] args) throws Exception {
        //read first JSON
        JsonObject obj1 = JsonParser
                .parseReader(new FileReader("data/a.json"))
                .getAsJsonObject();

        //read second JSON
        JsonObject obj2 = JsonParser
                .parseReader(new FileReader("data/b.json"))
                .getAsJsonObject();

        //merge obj2 into obj1
        for (String key : obj2.keySet()) {
            obj1.add(key, obj2.get(key));
        }

        //print merged JSON
        System.out.println(obj1);
    }
}
