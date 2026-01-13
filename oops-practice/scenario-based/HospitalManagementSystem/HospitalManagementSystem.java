package HospitalManagementSystem;

import java.util.ArrayList;
import java.util.Scanner;

//main class
public class HospitalManagementSystem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		//lists
		ArrayList<Patient> patients = new ArrayList<>();
		ArrayList<Doctor> doctors = new ArrayList<>();
		ArrayList<Appointment> appointments = new ArrayList<>();

		//abstraction
		HospitalService service = new HospitalServiceImpl();

		//adding some doctors initially
		doctors.add(new Doctor(1, "Dr. Maxwell", "Cardiologist", 500));
		doctors.add(new Doctor(2, "Dr. David", "Dermatologist", 400));
		doctors.add(new Doctor(3, "Dr. Radren", "General Physician", 300));

		System.out.println("Welcome to Hospital Management System");

		while (true) {
			System.out.println("\n-----------  Home Page  -----------");
			System.out.println("1. Add Patient");
			System.out.println("2. Update Patient");
			System.out.println("3. Delete Patient");
			System.out.println("4. View All Patients");
			System.out.println("5. View Doctors");
			System.out.println("6. Book Appointment");
			System.out.println("7. Cancel Appointment");
			System.out.println("8. View Medical History");
			System.out.println("0. Exit");
			System.out.print("Enter choice: ");

			int choice = sc.nextInt();

			if (choice == 0) {
				System.out.println("Thank you! Have a Good Day...");
				break;
			}

			switch (choice) {

			//CRUD Operations
			case 1:   //create patient
				System.out.print("\nEnter Patient Id: ");
				int pid = sc.nextInt();
				sc.nextLine();

				System.out.print("Enter Patient Name: ");
				String pname = sc.nextLine();
				System.out.print("Enter Patient Phone: ");
				String phone = sc.nextLine();
				System.out.print("Enter Patient Age: ");
				int age = sc.nextInt();
				sc.nextLine();

				System.out.print("Enter Disease/Issue: ");
				String issue = sc.nextLine();

				Patient patient = new Patient(pid, pname, phone, age, issue);
				patients.add(patient);

				System.out.println("Patient Added Successfully!");
				break;

			case 2:    //update patient
				System.out.print("\nEnter Patient Id to Update: ");
				int updateId = sc.nextInt();
				sc.nextLine();

				Patient updatePatient = service.findPatient(patients, updateId);
				if (updatePatient == null) {
					System.out.println("Patient not found!");
					break;
				}

				System.out.print("Enter New Phone: ");
				String newPhone = sc.nextLine();
				System.out.print("Enter New Disease/Issue: ");
				String newIssue = sc.nextLine();
				updatePatient.setPhone(newPhone);
				updatePatient.setIssue(newIssue);

				System.out.println("Patient Updated Successfully!");
				break;

			case 3:    //delete patient
				System.out.print("\nEnter Patient Id to Delete: ");
				int deleteId = sc.nextInt();
				boolean removed = service.deletePatient(patients, deleteId);
				if (removed) {
					System.out.println("Patient Deleted Successfully!");
				} else {
					System.out.println("Patient not found!");
				}
				break;
				
			case 4:    //read patients
				System.out.println("\n----- Patient List -----");
				if (patients.size() == 0) {
					System.out.println("No patients registered yet!");
				} else {
					for (Patient p : patients)
						System.out.println(p);
				}
				break;

			case 5:    //read doctor management
				System.out.println("\n----- Doctor List -----");
				for (Doctor d : doctors)
					System.out.println(d);
				break;

			//Appointment Booking
			case 6:
				if (patients.size() == 0) {
					System.out.println("Please add patient first!");
					break;
				}

				System.out.print("\nEnter Patient Id: ");
				int apPid = sc.nextInt();
				Patient apPatient = service.findPatient(patients, apPid);
				if (apPatient == null) {
					System.out.println("Patient not found!");
					break;
				}
				System.out.println("\nChoose Doctor Id:");
				for (Doctor d : doctors)
					System.out.println(d);
				System.out.print("Enter Doctor Id: ");
				int docId = sc.nextInt();
				sc.nextLine();

				Doctor apDoctor = service.findDoctor(doctors, docId);
				if (apDoctor == null) {
					System.out.println("Doctor not found!");
					break;
				}

				System.out.print("Enter Appointment Slot (Morning/Evening): ");
				String slot = sc.nextLine();

				try {
					Appointment ap = service.bookAppointment(appointments, apPatient, apDoctor, slot);
					System.out.println("Appointment Booked Successfully!");
					System.out.println(ap);

					//medical history update
					apPatient.addHistory("Appointment booked with " + apDoctor.getName() + " (" + apDoctor.getSpecialization()
							+ ") Slot: " + slot);

					//polymorphism fee calculation
					double fee = apDoctor.calculateConsultationFee();
					System.out.println("Consultation Fee: " + fee);

				} catch (AppointmentNotAvailableException e) {
					System.out.println("Error: " + e.getMessage());
				}
				break;

			//Appointment Cancellation
			case 7:
				System.out.print("\nEnter Appointment Id to Cancel: ");
				int cancelId = sc.nextInt();

				boolean cancelled = service.cancelAppointment(appointments, cancelId);
				if (cancelled) {
					System.out.println("Appointment Cancelled Successfully!");
				} else {
					System.out.println("Appointment not found!");
				}
				break;

			//View medical history
			case 8:
				System.out.print("\nEnter Patient Id: ");
				int historyId = sc.nextInt();

				Patient historyPatient = service.findPatient(patients, historyId);
				if (historyPatient == null) {
					System.out.println("Patient not found!");
				} else {
					historyPatient.displayHistory();
				}
				break;

			default:
				System.out.println("Invalid choice!");
			}
		}
	}
}
