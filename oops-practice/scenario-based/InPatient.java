package HospitalPatientManagementSystem;

public class InPatient extends Patient{
	//attributes
	private int daysAdmitted;
	private double dailyCharge;
	//constructor
	public InPatient(int patientId,String patientName,int patientAge,int daysAdmitted, double dailyCharge) {
		super(patientId,patientName,patientAge);
		this.daysAdmitted=daysAdmitted;
		this.dailyCharge=dailyCharge;
	}
	//method to calculate bill of a patient 
	public double calculateBill() {
		return daysAdmitted*dailyCharge;
	}
	//method to display In-Patient information
	public void displayPatientInfo() {
		System.out.println("Patient Type : In-Patient | Patient Id : "+getPatientId()+" | Patient's Name : "
	                       +getPatientName()+" | Patient's Age : "+getPatientAge()+" | No. of Days Admitted : "+daysAdmitted);
		
	}

}
