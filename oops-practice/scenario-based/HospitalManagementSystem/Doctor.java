package HospitalManagementSystem;

//child class
public class Doctor extends Person {
	//attributes
	private String specialization;
	private double baseFee;

	//constructor
	public Doctor(int id, String name, String specialization, double baseFee) {
		super(id, name);
		this.specialization = specialization;
		this.baseFee = baseFee;
	}

	//getters
	public String getSpecialization() {
		return specialization;
	}

	public double getBaseFee() {
		return baseFee;
	}

	//polymorphism consultation fee calculation
	public double calculateConsultationFee() {
		//specialist fee extra 20% 
		return baseFee + (baseFee * 0.20);
	}

	@Override
	public String toString() {
		return "Doctor Details: " + "Id - " + getId() + " | Name - " + getName() + " | Specialization - " + specialization
				+ " | Base Fee - " + baseFee;
	}
}
