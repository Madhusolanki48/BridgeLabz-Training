package HospitalPatientManagementSystem;

public abstract class Patient implements IPayable {
	//attributes
	private int patientId;
	private String patientName;
	private int patientAge;
	//constructor
	public Patient(int patientId,String patientName,int patientAge) {
		this.patientId=patientId;
		this.patientName=patientName;
		this.patientAge=patientAge;
	}
	//Encapsulation
	//getters and setters
	public int getPatientId() {
		return patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public int getPatientAge() {
		return patientAge;
	}
	public void setPatientName(String patientName) {
		this.patientName=patientName;
	}
	public void setPatientAge(int patientAge) {
		this.patientAge=patientAge;
	}
	//polymorphism
    public abstract void displayPatientInfo();

}
