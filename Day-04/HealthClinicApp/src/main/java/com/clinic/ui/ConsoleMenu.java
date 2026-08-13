package com.clinic.ui;

import com.clinic.dao.AppointmentDAO;
import com.clinic.dao.BillingDAO;
import com.clinic.dao.DoctorDAO;
import com.clinic.dao.PatientDAO;
import com.clinic.dao.SpecializationDAO;
import com.clinic.dao.VisitHistoryDAO;
import com.clinic.dao.impl.AppointmentDAOImpl;
import com.clinic.dao.impl.BillingDAOImpl;
import com.clinic.dao.impl.DoctorDAOImpl;
import com.clinic.dao.impl.PatientDAOImpl;
import com.clinic.dao.impl.SpecializationDAOImpl;
import com.clinic.dao.impl.VisitHistoryDAOImpl;
import com.clinic.dto.Appointment;
import com.clinic.dto.Doctor;
import com.clinic.dto.Patient;
import com.clinic.dto.Specialization;
import com.clinic.service.AppointmentService;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ConsoleMenu {
    private final Scanner scanner = new Scanner(System.in);
    private final PatientDAO patientDAO = new PatientDAOImpl();
    private final DoctorDAO doctorDAO = new DoctorDAOImpl();
    private final SpecializationDAO specializationDAO = new SpecializationDAOImpl();
    private final AppointmentDAO appointmentDAO = new AppointmentDAOImpl();
    private final BillingDAO billingDAO = new BillingDAOImpl();
    private final VisitHistoryDAO visitHistoryDAO = new VisitHistoryDAOImpl();
    private final AppointmentService appointmentService = new AppointmentService(appointmentDAO, billingDAO, visitHistoryDAO);

    public void start() {
        boolean running = true;
        while (running) {
            printMainMenu();
            int choice = readInt("Enter your choice: ");
            try {
                switch (choice) {
                    case 1 -> patientMenu();
                    case 2 -> doctorMenu();
                    case 3 -> specializationMenu();
                    case 4 -> appointmentMenu();
                    case 5 -> completeAppointmentMenu();
                    case 6 -> running = false;
                    default -> System.out.println("Invalid choice.");
                }
            } catch (SQLException | RuntimeException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        System.out.println("Thank you.");
    }

    private void printMainMenu() {
        System.out.println("\n===== HEALTH CLINIC MANAGEMENT SYSTEM =====");
        System.out.println("1. Patient Module");
        System.out.println("2. Doctor Module");
        System.out.println("3. Specialization Module");
        System.out.println("4. Appointment Module");
        System.out.println("5. Complete Appointment (Billing + Visit History)");
        System.out.println("6. Exit");
    }

    private void patientMenu() throws SQLException {
        boolean back = false;
        while (!back) {
            System.out.println("\n-- Patient Module --");
            System.out.println("1. Add Patient");
            System.out.println("2. View All Patients");
            System.out.println("3. Update Patient Email");
            System.out.println("4. Soft Delete Patient");
            System.out.println("5. Back");
            switch (readInt("Choice: ")) {
                case 1 -> addPatient();
                case 2 -> patientDAO.getAllPatients().forEach(System.out::println);
                case 3 -> updatePatientEmail();
                case 4 -> softDeletePatient();
                case 5 -> back = true;
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private void doctorMenu() throws SQLException {
        boolean back = false;
        while (!back) {
            System.out.println("\n-- Doctor Module --");
            System.out.println("1. Add Doctor");
            System.out.println("2. View All Doctors");
            System.out.println("3. Back");
            switch (readInt("Choice: ")) {
                case 1 -> addDoctor();
                case 2 -> doctorDAO.getAllDoctors().forEach(System.out::println);
                case 3 -> back = true;
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private void specializationMenu() throws SQLException {
        boolean back = false;
        while (!back) {
            System.out.println("\n-- Specialization Module --");
            System.out.println("1. Add Specialization");
            System.out.println("2. View All Specializations");
            System.out.println("3. Back");
            switch (readInt("Choice: ")) {
                case 1 -> addSpecialization();
                case 2 -> specializationDAO.getAllSpecializations().forEach(System.out::println);
                case 3 -> back = true;
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private void appointmentMenu() throws SQLException {
        boolean back = false;
        while (!back) {
            System.out.println("\n-- Appointment Module --");
            System.out.println("1. Book Appointment");
            System.out.println("2. View All Appointments");
            System.out.println("3. Cancel Appointment");
            System.out.println("4. Back");
            switch (readInt("Choice: ")) {
                case 1 -> bookAppointment();
                case 2 -> appointmentDAO.getAllAppointments().forEach(System.out::println);
                case 3 -> cancelAppointment();
                case 4 -> back = true;
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private void completeAppointmentMenu() throws SQLException {
        boolean back = false;
        while (!back) {
            System.out.println("\n-- Complete Appointment (Billing + Visit History) --");
            System.out.println("1. Complete Appointment");
            System.out.println("2. View All Billing");
            System.out.println("3. View All Visit History");
            System.out.println("4. Back");
            switch (readInt("Choice: ")) {
                case 1 -> completeAppointment();
                case 2 -> billingDAO.getAllBilling().forEach(System.out::println);
                case 3 -> visitHistoryDAO.getAllVisitHistory().forEach(System.out::println);
                case 4 -> back = true;
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private void addPatient() throws SQLException {
        Patient patient = new Patient();
        patient.setFirstName(readLine("First name: "));
        patient.setLastName(readLine("Last name: "));
        patient.setDateOfBirth(LocalDate.parse(readLine("Date of birth (yyyy-mm-dd): ")));
        patient.setGender(readLine("Gender: "));
        patient.setPhone(readLine("Phone: "));
        patient.setEmail(readLine("Email: "));
        patient.setAddress(readLine("Address: "));
        System.out.println(patientDAO.insertPatient(patient) ? "Patient added." : "Patient not added.");
    }

    private void updatePatientEmail() throws SQLException {
        int id = readInt("Patient ID: ");
        String email = readLine("New email: ");
        System.out.println(patientDAO.updatePatientEmail(id, email) ? "Email updated." : "Patient not found.");
    }

    private void softDeletePatient() throws SQLException {
        int id = readInt("Patient ID: ");
        System.out.println(patientDAO.softDeletePatient(id) ? "Patient removed from active list." : "Patient not found.");
    }

    private void addDoctor() throws SQLException {
        Doctor doctor = new Doctor();
        doctor.setSpecializationId(readInt("Specialization ID: "));
        doctor.setFirstName(readLine("First name: "));
        doctor.setLastName(readLine("Last name: "));
        doctor.setPhone(readLine("Phone: "));
        doctor.setEmail(readLine("Email: "));
        System.out.println(doctorDAO.insertDoctor(doctor) ? "Doctor added." : "Doctor not added.");
    }

    private void addSpecialization() throws SQLException {
        Specialization specialization = new Specialization();
        specialization.setName(readLine("Name: "));
        specialization.setDescription(readLine("Description: "));
        System.out.println(specializationDAO.insertSpecialization(specialization) ? "Specialization added." : "Specialization not added.");
    }

    private void bookAppointment() throws SQLException {
        Appointment appointment = new Appointment();
        appointment.setPatientId(readInt("Patient ID: "));
        appointment.setDoctorId(readInt("Doctor ID: "));
        String date = readLine("Appointment date (yyyy-mm-dd HH:mm): ");
        appointment.setAppointmentDate(LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        appointment.setReason(readLine("Reason: "));
        System.out.println(appointmentDAO.insertAppointment(appointment) ? "Appointment booked." : "Appointment not booked.");
    }

    private void cancelAppointment() throws SQLException {
        int id = readInt("Appointment ID: ");
        System.out.println(appointmentDAO.cancelAppointment(id) ? "Appointment cancelled." : "Appointment not found.");
    }

    private void completeAppointment() throws SQLException {
        int appointmentId = readInt("Appointment ID: ");
        BigDecimal amount = new BigDecimal(readLine("Billing amount: "));
        String diagnosis = readLine("Diagnosis: ");
        String prescription = readLine("Prescription: ");
        String notes = readLine("Visit notes: ");
        boolean done = appointmentService.completeAppointmentWithBillingAndVisit(appointmentId, amount, diagnosis, prescription, notes);
        System.out.println(done ? "Appointment completed, billed, and recorded successfully." : "Appointment not completed.");
    }

    private int readInt(String prompt) {
        while (true) {
            try {
                return Integer.parseInt(readLine(prompt));
            } catch (NumberFormatException e) {
                System.out.println("Enter a valid number.");
            }
        }
    }

    private String readLine(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }
}
