package stream_api;

import java.util.*;

//main class
public class IoTSensorReadings {
	public static void main(String[] args) {

		List<Double> readings = Arrays.asList(45.5, 78.2, 32.1, 90.6, 60.0);

		double threshold = 60.0;

		readings.stream().filter(r -> r > threshold) // above threshold
				.forEach(r -> System.out.println(r)); // print reading
	}
}
