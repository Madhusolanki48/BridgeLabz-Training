package model;
import java.sql.Date;

public class Patient {
	// attributes
	private int patientId;
	private String name;
	private Date dob;
	private String phone;
	private String email;
	private String address;
	private String bloodGroup;

	//constructor for inserting new patient
	public Patient(String name, Date dob, String phone, String email, String address, String bloodGroup) {
		this.name = name;
		this.dob = dob;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.bloodGroup = bloodGroup;
	}

	//empty constructor
	public Patient() {
	}

	//getters
	public int getPatientId() {
	    return patientId;
	}
	public String getName() {
		return name;
	}
	public Date getDob() {
		return dob;
	}
	public String getPhone() {
		return phone;
	}
	public String getEmail() {
		return email;
	}
	public String getAddress() {
		return address;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setPatientId(int patientId) {
	    this.patientId = patientId;
	}
	public void setName(String name) {
		this.name = name;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}