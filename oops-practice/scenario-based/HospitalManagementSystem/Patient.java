package HospitalManagementSystem;

import java.util.ArrayList;

//child class
public class Patient extends Person {
	//attributes
	private String phone;
	private int age;
	private String issue;
	private ArrayList<String> medicalHistory;

	//constructor
	public Patient(int id, String name, String phone, int age, String issue) {
		super(id, name);
		this.phone = phone;
		this.age = age;
		this.issue = issue;
		this.medicalHistory = new ArrayList<>();
	}

	//getters
	public String getPhone() {
		return phone;
	}

	public int getAge() {
		return age;
	}

	public String getIssue() {
		return issue;
	}

	//setters
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	//medical history methods
	public void addHistory(String record) {
		medicalHistory.add(record);
	}

	public void displayHistory() {
		System.out.println("\n----- Medical History -----");
		System.out.println("Patient: " + getName());
		if (medicalHistory.size() == 0) {
			System.out.println("No history available!");
			return;
		}
		for (String h : medicalHistory) {
			System.out.println(h);
		}
	}

	@Override
	public String toString() {
		return "Patient Details: " + "Id - " + getId() + " | Name - " + getName() + " | Phone - " + phone + " | Age - "
				+ age + " | Issue - " + issue;
	}
}
