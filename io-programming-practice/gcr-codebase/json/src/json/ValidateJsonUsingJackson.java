package json;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ValidateJsonUsingJackson {
	public static void main(String[] args) {
		String json = "{\"name\":\"Maxwell\",\"age\":23}";
		try {
			//validate JSON structure
			new ObjectMapper().readTree(json);
			System.out.println("Valid JSON");
		}catch(Exception e) {
			System.out.println("Invalid JSON");
		}
	}

}
