package HospitalManagementSystem;

import java.util.ArrayList;

//service class
public class HospitalServiceImpl implements HospitalService {

	//find patient
	public Patient findPatient(ArrayList<Patient> patients, int id) {
		for (Patient p : patients) {
			if (p.getId() == id)
				return p;
		}
		return null;
	}

	//find doctor
	public Doctor findDoctor(ArrayList<Doctor> doctors, int id) {
		for (Doctor d : doctors) {
			if (d.getId() == id)
				return d;
		}
		return null;
	}

	//delete patient
	public boolean deletePatient(ArrayList<Patient> patients, int id) {
		for (int i = 0; i < patients.size(); i++) {
			if (patients.get(i).getId() == id) {
				patients.remove(i);
				return true;
			}
		}
		return false;
	}

	//book appointment
	public Appointment bookAppointment(ArrayList<Appointment> appointments, Patient patient, Doctor doctor, String slot)
			throws AppointmentNotAvailableException {

		//slot availability check
		for (Appointment a : appointments) {
			if (a.getDoctor().getId() == doctor.getId() && a.getSlot().equalsIgnoreCase(slot)
					&& a.getStatus().equals("BOOKED")) {
				throw new AppointmentNotAvailableException("This slot is already booked for Doctor: " + doctor.getName());
			}
		}

		Appointment ap = new Appointment(appointments.size() + 1, patient, doctor, slot);
		appointments.add(ap);
		return ap;
	}

	//cancel appointment
	public boolean cancelAppointment(ArrayList<Appointment> appointments, int appointmentId) {
		for (Appointment a : appointments) {
			if (a.getAppointmentId() == appointmentId) {
				a.setStatus("CANCELLED");
				return true;
			}
		}
		return false;
	}
}
