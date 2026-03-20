package app;
import service.AppointmentService;
import service.BillService;
import service.DoctorService;
import service.PatientService;
import service.VisitService;
import model.Appointment;
import model.Doctor;
import model.Patient;
import model.Prescription;
import model.Visit;

import java.sql.Date;
import java.sql.Time;
import java.util.*;

public class TestPatientApp {

	public static void main(String[] args) {

		//service object
		PatientService service = new PatientService();
		//patient object
		Patient p = new Patient("Maxwell", Date.valueOf("2002-05-10"), "9876543310", "maxwell2@gmail.com", "Argentina", "B+");
		//calling service method
		boolean result = service.registerPatient(p);
		//output
		if (result) {
			System.out.println("Patient registered successfully!");
		} else {
			System.out.println("Registration failed!");
		}
		// UC-1.2 : updating patient with ID = 1
		Patient updatePatient = new Patient("UpdatedName", Date.valueOf("2002-05-10"), "9999999999",
				"updated@gmail.com", "Delhi", "A+");
		//set ID to update
		updatePatient.setPatientId(1);
		boolean updated = service.updatePatient(updatePatient);
		if (updated) {
			System.out.println("Patient updated successfully!");
		} else {
			System.out.println("Update failed!");
		}
		// UC-1.3 : search result
		System.out.println("\nSearch Results:");
		System.out.println("----------------------------------");
		List<Patient> list = service.searchPatient("Maxwell");
		for (Patient pt : list) {
			System.out.println("ID: " + pt.getPatientId());
			System.out.println("Name: " + pt.getName());
			System.out.println("Phone: " + pt.getPhone());
			System.out.println("Email: " + pt.getEmail());
			System.out.println("----------------------------------");
		}
		//UC-1.4 : view history
		service.viewVisitHistory(1);
		
		//----------------------- UC-2 -----------------------------

		DoctorService docService = new DoctorService();
		// UC-2.1 : Add Doctor
		Doctor d = new Doctor("Dr. John", "9999999999", 500.0, 1);
		int doctorId = docService.addDoctor(d);
		if (doctorId == -1) {
		    System.out.println("Doctor already exists!");
		    doctorId = 1; 
		} else {
		    System.out.println("Doctor added successfully! (ID: " + doctorId + ")");
		}

		System.out.println("----------------------------------");

		// UC-2.2 : Update Specialty
		boolean updated1 = docService.updateSpecialty(doctorId, 2);

		if (updated1) {
		    System.out.println("Doctor specialty updated!");
		} else {
		    System.out.println("Update failed!");
		}

		System.out.println("----------------------------------");

		// UC-2.3 : View Doctors by Specialty
		List<Doctor> list1 = docService.getDoctorsBySpecialty("Dermatology"); // ✅ FIXED

		if (list1.isEmpty()) {
		    System.out.println("No doctors found.");
		} else {
		    for (Doctor doc : list1) {
		        System.out.println("ID: " + doc.getDoctorId());
		        System.out.println("Name: " + doc.getName());
		        System.out.println("Contact: " + doc.getContact());
		        System.out.println("Fee: " + doc.getConsultationFee());
		        System.out.println("----------------------------------");
		    }
		}

		// UC-2.4 : Deactivate Doctor
		boolean deactivated = docService.deactivateDoctor(doctorId);

		if (deactivated) {
		    System.out.println("Doctor deactivated successfully!");
		} else {
		    System.out.println("Deactivation failed!");
		}
		
		//----------------------- UC-3 -----------------------------

		AppointmentService appService = new AppointmentService();
		System.out.println("\n------ Check Doctor Availability -------");

		boolean available = appService.checkAvailability(1, Date.valueOf("2026-03-21"), Time.valueOf("11:00:00"));

		System.out.println("Doctor ID      : 1");
		System.out.println("Date           : 2026-03-21");
		System.out.println("Time           : 11:00 AM");

		if (available) {
			System.out.println("Status         : Available!");
		} else {
			System.out.println("Status         : Not Available!");
		}

		// UC-3.1 Book
		System.out.println("\n----------- Book Appointment ---------");
		Appointment a = new Appointment();  
		a.setPatientId(1);
		a.setDoctorId(1);
		a.setAppointmentDate(Date.valueOf("2026-03-21"));
		a.setAppointmentTime(Time.valueOf("11:00:00"));
		a.setStatus("SCHEDULED");

		boolean booked = appService.book(a);

		if (booked) {
			System.out.println("Appointment booked successfully!");
		} else {
			System.out.println("Booking failed!");
		}

		// UC-3.3 Cancel
		System.out.println("\n--------- Cancel Appointment ---------");

		boolean cancelled = appService.cancel(1);

		if (cancelled) {
			System.out.println("Appointment cancelled successfully!");
		} else {
			System.out.println("Cancellation failed!");
		}

		// UC-3.4 Reschedule
		System.out.println("\n------- Reschedule Appointment -------");

		boolean rescheduled = appService.reschedule(1, 1, Date.valueOf("2026-03-22"), Time.valueOf("12:00:00"));

		if (rescheduled) {
			System.out.println("Appointment rescheduled successfully!");
		} else {
			System.out.println("Reschedule failed!");
		}

		// UC-3.5 View
		System.out.println("\n----------- Daily Schedule -----------");
		List<String> schedule = appService.getSchedule(Date.valueOf("2026-03-22"));

		if (schedule.isEmpty()) {
			System.out.println("No appointments found.");
		} else {
			int count = 1;
			for (String s : schedule) {
				System.out.println("Appointment #" + count++);
				System.out.println("--------------------------------------------------------------------");
				System.out.println(s);
				System.out.println("--------------------------------------------------------------------");
			}
		}
		
		// ----------------------- UC-4 -----------------------------
		VisitService visitService = new VisitService();
		// UC-4.1 Record Visit
		System.out.println("\n--- Record Visit ---");
		Visit v = new Visit();
		v.setAppointmentId(1);
		v.setDiagnosis("Fever");
		v.setNotes("Take rest");

		int visitId = visitService.recordVisit(v);

		System.out.println("Visit recorded! ID: " + visitId);

		// UC-4.3 Add Prescriptions
		System.out.println("\n--- Add Prescriptions ---");

		List<Prescription> presList = new ArrayList<>();

		Prescription p1 = new Prescription();
		p1.setVisitId(visitId);
		p1.setMedicineName("Paracetamol");
		p1.setDosage("500mg");
		p1.setDuration("3 days");

		Prescription p2 = new Prescription();
		p2.setVisitId(visitId);
		p2.setMedicineName("Vitamin C");
		p2.setDosage("1 tablet");
		p2.setDuration("5 days");

		presList.add(p1);
		presList.add(p2);

		visitService.addPrescriptions(presList);

		System.out.println("Prescriptions added!");

		// UC-4.2 View History
		System.out.println("\n--- Medical History ---");

		List<String> history = visitService.getHistory(1);

		for (String h : history) {
			System.out.println(h);
		}
		
		// ----------------------- UC-5 -----------------------------

		BillService billService = new BillService();

		// UC-5.1 Generate Bill
		System.out.println("\n------ Generate Bill ------");
		int billId = billService.generateBill(1);
		System.out.println("Bill generated! ID: " + billId);

		// UC-5.2 Payment
		System.out.println("\n----- Record Payment ------");
		boolean paid = billService.payBill(billId, 500, "CASH");
		System.out.println(paid ? "Payment successful!" : "Payment failed!");

		// UC-5.3 Outstanding Bills
		System.out.println("\n---- Outstanding Bills ----");
		List<String> pending = billService.getOutstandingBills();
		for (String p4 : pending) {
			System.out.println(p4);
		}

		// UC-5.4 Revenue Report
		System.out.println("\n----- Revenue Report ------");
		List<String> report = billService.getRevenueReport("2026-03-01", "2026-03-30");

		for (String r : report) {
			System.out.println(r);
		}
	}
}