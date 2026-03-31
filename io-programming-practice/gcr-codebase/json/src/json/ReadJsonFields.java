package json;
import java.io.FileReader;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ReadJsonFields {
	public static void main(String[] args) throws Exception {
		//read JSON file
		JsonObject obj=JsonParser.parseReader(new FileReader("data/user.json")).getAsJsonObject();
		System.out.println(obj.get("name").getAsString());
		System.out.println(obj.get("email").getAsString());
		System.out.println(obj.get("age").getAsInt());	
	}

}
