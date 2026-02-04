package json;
import java.util.*;
import com.google.gson.Gson;

public class DbToJson {
    public static void main(String[] args) {

        //DB records
        List<Map<String, Object>> dbData = new ArrayList<>();

        Map<String, Object> row1 = new HashMap<>();
        row1.put("id", 1);
        row1.put("name", "Amiley");
        dbData.add(row1);

        Map<String, Object> row2 = new HashMap<>();
        row2.put("id", 2);
        row2.put("name", "Ronald");
        dbData.add(row2);

        //convert DB data to JSON
        Gson gson = new Gson();
        String jsonReport = gson.toJson(dbData);

        //print JSON report
        System.out.println(jsonReport);
    }
}
