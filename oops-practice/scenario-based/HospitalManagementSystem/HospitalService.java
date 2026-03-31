package HospitalManagementSystem;

import java.util.ArrayList;

//abstraction
public interface HospitalService {

	//methods
	Patient findPatient(ArrayList<Patient> patients, int id);

	Doctor findDoctor(ArrayList<Doctor> doctors, int id);

	boolean deletePatient(ArrayList<Patient> patients, int id);

	Appointment bookAppointment(ArrayList<Appointment> appointments, Patient patient, Doctor doctor, String slot)
			throws AppointmentNotAvailableException;

	boolean cancelAppointment(ArrayList<Appointment> appointments, int appointmentId);
}
