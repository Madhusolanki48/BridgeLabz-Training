package model;

public class Doctor {
	// attributes
	private int doctorId;
	private String name;
	private String contact;
	private double consultationFee;
	private int specialtyId;

	// constructor
	public Doctor(String name, String contact, double fee, int specialtyId) {
		this.name = name;
		this.contact = contact;
		this.consultationFee = fee;
		this.specialtyId = specialtyId;
	}

	public Doctor() {
	}
    //getters and setters
	public int getDoctorId() {
		return doctorId;
	}
	
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getContact() {
		return contact;
	}

	public void setConsultationFee(double fee) {
		this.consultationFee = fee;
	}

	public double getConsultationFee() {
		return consultationFee;
	}
	public int getSpecialtyId() {
	    return specialtyId;
	}
}