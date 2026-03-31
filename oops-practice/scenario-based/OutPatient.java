package HospitalPatientManagementSystem;

public class OutPatient extends Patient {
	//attribute
	private String doctorPrescription;
	private int consultationFee;
	public OutPatient(int patientId,String patientName,int patientAge,int consultationFee) {
		super(patientId,patientName,patientAge);
		this.consultationFee=consultationFee;
	}
	//method to calculate bill
	public double calculateBill() {
		return consultationFee;
	}
	//method to display Out-Patient Information
	public void displayPatientInfo() {
		System.out.println("Patient Type : Out-Patient | Patient Id : "+getPatientId()+" | Patient's Name : "
                +getPatientName()+" | Patient's Age : "+getPatientAge());
		
	}

}
