package HospitalPatientManagementSystem;
import java.util.Scanner;

//main class
public class HospitalPatientManagementSystem {
	private static void printMenu() {
		System.out.println("""
				---------- Hospital Patient Management System ----------
				--------------------------------------------------------
				What would you like to do?
				1. Add Patient
				2. View All Patients
				3. Update Patient
				4. Delete Patient
				5. Generate Bill
				6. View Doctor Details
				0. Exit
				--------------------------------------------------------
				""");
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HospitalService service = new HospitalService();
		Doctor doctor = new Doctor(1, "Maxwell", "Cardiology");

		while (true) {
			printMenu();
			System.out.print("Enter your choice: ");
			int choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1: //add patient
				System.out.println("""
						Choose Patient Type:
						1. In-Patient
						2. Out-Patient
						""");
				System.out.print("Enter type: ");
				int type = sc.nextInt();
				sc.nextLine();

				if (type != 1 && type != 2) {
					System.out.println("Invalid patient type.");
					break;
				}
				System.out.print("Enter Patient's ID: ");
				int id = sc.nextInt();
				sc.nextLine();
				System.out.print("Enter Patient's Name: ");
				String name = sc.nextLine();

				System.out.print("Enter Patient's Age: ");
				int age = sc.nextInt();
				sc.nextLine();

				if (type == 1) {
					System.out.print("Enter Days Admitted: ");
					int days = sc.nextInt();

					System.out.print("Enter Daily Charges: ");
					double charge = sc.nextDouble();

					service.addPatient(new InPatient(id, name, age, days, charge));
					System.out.println("In-Patient added successfully.");

				} else {
					System.out.print("Enter Consultation Fee: ");
					int fee = sc.nextInt();

					service.addPatient(new OutPatient(id, name, age, fee));
					System.out.println("Out-Patient added successfully.");
				}

				System.out.println("Patient registration completed.\n");
				break;

			case 2: //list patients
				System.out.println("\nPatient Records:");
				service.listPatients();
				break;

			case 3: //update patient
				System.out.print("Enter Patient ID to update: ");
				int updateId = sc.nextInt();
				sc.nextLine();

				System.out.print("Enter New Patient's Name: ");
				String newName = sc.nextLine();

				System.out.print("Enter New Patient's Age: ");
				int newAge = sc.nextInt();

				service.updatePatient(updateId, newName, newAge);
				break;

			case 4: //delete patient record
				System.out.print("Enter Patient ID to delete: ");
				int deleteId = sc.nextInt();
				service.deletePatient(deleteId);
				break;

			case 5: //generate bill
				System.out.print("Enter Patient ID for bill generation: ");
				int billId = sc.nextInt();

				Patient patient = service.getPatient(billId);
				if (patient == null) {
					System.out.println("Patient not found.");
					break;
				}

				System.out.println("\n---------- BILL SUMMARY ----------");
				patient.displayPatientInfo(); //polymorphism
				Bill.generateBill(patient); //IPayable interface used
				System.out.println("---------------------------------\n");
				break;

			case 6: //view doctor's details
				System.out.println("\nDoctor Details:");
				doctor.displayDoctorInfo();
				break;

			case 0: //exit
				System.out.println("\nThank you for using Hospital Patient Management System.");
				System.out.println("Application closed.");
				return;

			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}
	}
}
