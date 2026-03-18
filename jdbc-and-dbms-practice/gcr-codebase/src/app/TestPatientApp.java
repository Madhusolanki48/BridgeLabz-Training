package app;
import service.DoctorService;
import service.PatientService;
import model.Doctor;
import model.Patient;
import java.sql.Date;
import java.util.*;

public class TestPatientApp {

	public static void main(String[] args) {

		//service object
		PatientService service = new PatientService();
		//patient object
		Patient p = new Patient("Maxwell", Date.valueOf("2002-05-10"), "9876543310", "maxwell2@gmail.com", "Argentina", "B+");
		//calling service method
		boolean result = service.registerPatient(p);
		//output
		if (result) {
			System.out.println("Patient registered successfully!");
		} else {
			System.out.println("Registration failed!");
		}
		// UC-1.2 : updating patient with ID = 1
		Patient updatePatient = new Patient("UpdatedName", Date.valueOf("2002-05-10"), "9999999999",
				"updated@gmail.com", "Delhi", "A+");
		//set ID to update
		updatePatient.setPatientId(1);
		boolean updated = service.updatePatient(updatePatient);
		if (updated) {
			System.out.println("Patient updated successfully!");
		} else {
			System.out.println("Update failed!");
		}
		// UC-1.3 : search result
		System.out.println("\nSearch Results:");
		System.out.println("----------------------------------");
		List<Patient> list = service.searchPatient("Maxwell");
		for (Patient pt : list) {
			System.out.println("ID: " + pt.getPatientId());
			System.out.println("Name: " + pt.getName());
			System.out.println("Phone: " + pt.getPhone());
			System.out.println("Email: " + pt.getEmail());
			System.out.println("----------------------------------");
		}
		//UC-1.4 : view history
		service.viewVisitHistory(1);
		
		//----------------------- UC-2 -----------------------------

		DoctorService docService = new DoctorService();
		// UC-2.1 : Add Doctor
		Doctor d = new Doctor("Dr. John", "9999999999", 500.0, 1);
		int doctorId = docService.addDoctor(d);
		if (doctorId == -1) {
		    System.out.println("Doctor already exists!");
		    doctorId = 1; 
		} else {
		    System.out.println("Doctor added successfully! (ID: " + doctorId + ")");
		}

		System.out.println("----------------------------------");

		// UC-2.2 : Update Specialty
		boolean updated1 = docService.updateSpecialty(doctorId, 2);

		if (updated1) {
		    System.out.println("Doctor specialty updated!");
		} else {
		    System.out.println("Update failed!");
		}

		System.out.println("----------------------------------");

		// UC-2.3 : View Doctors by Specialty
		List<Doctor> list1 = docService.getDoctorsBySpecialty("Dermatology"); // ✅ FIXED

		if (list1.isEmpty()) {
		    System.out.println("No doctors found.");
		} else {
		    for (Doctor doc : list1) {
		        System.out.println("ID: " + doc.getDoctorId());
		        System.out.println("Name: " + doc.getName());
		        System.out.println("Contact: " + doc.getContact());
		        System.out.println("Fee: " + doc.getConsultationFee());
		        System.out.println("----------------------------------");
		    }
		}

		// UC-2.4 : Deactivate Doctor
		boolean deactivated = docService.deactivateDoctor(doctorId);

		if (deactivated) {
		    System.out.println("Doctor deactivated successfully!");
		} else {
		    System.out.println("Deactivation failed!");
		}
	}
}