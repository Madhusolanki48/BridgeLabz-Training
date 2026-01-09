package HospitalPatientManagementSystem;

public class Bill {
	public static void generateBill(Patient patient) {
		System.out.println("Total Bill Amount : "+patient.calculateBill());
	
	}

}
