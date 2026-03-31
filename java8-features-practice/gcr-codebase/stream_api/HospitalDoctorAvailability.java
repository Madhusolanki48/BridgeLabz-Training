package stream_api;
import java.util.*;

// stores doctor details
class Doctor {
	String name;
	String specialty;
	boolean weekendAvailable;

	// constructor
	Doctor(String name, String specialty, boolean weekendAvailable) {
		this.name = name;
		this.specialty = specialty;
		this.weekendAvailable = weekendAvailable;
	}
}

// main class
public class HospitalDoctorAvailability {
	public static void main(String[] args) {

		List<Doctor> doctors = Arrays.asList(new Doctor("Dr. Sherlock", "Cardiology", true),
				new Doctor("Dr. Maxwell", "Neurology", false), new Doctor("Dr. Garry", "Orthopedics", true),
				new Doctor("Dr. Vermen", "Dermatology", true), new Doctor("Dr. Sammy", "Pediatrics", false));
		System.out.println("Doctors available on weekends (sorted by specialty):");
		doctors.stream().filter(d -> d.weekendAvailable) // weekend available
				.sorted(Comparator.comparing(d -> d.specialty)) // sort by specialty
				.forEach(d -> System.out.println("Doctor Name : " + d.name + " | Specialty : " + d.specialty));
	}
}
