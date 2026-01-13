package HospitalManagementSystem;

//appointment class
public class Appointment {
	//attributes
	private int appointmentId;
	private Patient patient;
	private Doctor doctor;
	private String slot;
	private String status;

	//constructor
	public Appointment(int appointmentId, Patient patient, Doctor doctor, String slot) {
		this.appointmentId = appointmentId;
		this.patient = patient;
		this.doctor = doctor;
		this.slot = slot;
		this.status = "BOOKED";
	}

	//getters
	public int getAppointmentId() {
		return appointmentId;
	}

	public Patient getPatient() {
		return patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public String getSlot() {
		return slot;
	}

	public String getStatus() {
		return status;
	}

	//setter
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Appointment Details: " + "Id - " + appointmentId + " | Patient - " + patient.getName() + " | Doctor - "
				+ doctor.getName() + " | Slot - " + slot + " | Status - " + status;
	}
}
