package json;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class CreateJsonObject {
    public static void main(String[] args) {
    //create JSON object
	JsonObject obj=new JsonObject();
	obj.addProperty("name", "Maxwell");
	obj.addProperty("age", 23);
	
	//create JSON array for subjects
	JsonArray subjects=new JsonArray();
	subjects.add("Data Structures");
	subjects.add("Database Management");
	subjects.add("Computer Networks");
	//add array to JSON object
	obj.add("subjects", subjects);
	System.out.println(obj);
	
    }

}
