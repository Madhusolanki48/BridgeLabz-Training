package HospitalPatientManagementSystem;

public class Doctor {
	//attributes
	private int doctorId;
	private String doctorName;
	private String specialization;
	//constructor
	public Doctor(int doctorId,String doctorName,String specialization) {
		this.doctorId=doctorId;
		this.doctorName=doctorName;
		this.specialization=specialization;		
	}
	//method to display doctor's information
	public void displayDoctorInfo(){
		System.out.println("Doctor's Id : "+doctorId+" | Doctor's Name : "+doctorName+" | Specilized in : "+specialization);
	}

}
