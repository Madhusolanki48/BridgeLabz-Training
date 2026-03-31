package json;
import com.google.gson.Gson;

class Car {
	String brand;
	int year;
//constructor
	public Car(String brand, int year) {
		this.brand = brand;
		this.year = year;
	}
}

public class ObjectToJson {
	public static void main(String[] args) {
		//java object
		Car car = new Car("BMW", 1990);
		
		//java object to JSON
		Gson gson = new Gson();
		String json = gson.toJson(car);
		System.out.println(json);

	}

}
