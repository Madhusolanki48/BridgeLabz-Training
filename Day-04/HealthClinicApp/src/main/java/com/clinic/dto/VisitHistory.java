package com.clinic.dto;

import java.time.LocalDateTime;

public class VisitHistory {
    private int visitId;
    private int appointmentId;
    private int patientId;
    private int doctorId;
    private String diagnosis;
    private String prescription;
    private String notes;
    private LocalDateTime visitDate;

    public VisitHistory() {
    }

    public VisitHistory(int visitId, int appointmentId, int patientId, int doctorId, String diagnosis,
            String prescription, String notes, LocalDateTime visitDate) {
        this.visitId = visitId;
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.diagnosis = diagnosis;
        this.prescription = prescription;
        this.notes = notes;
        this.visitDate = visitDate;
    }

    public int getVisitId() {
        return visitId;
    }

    public void setVisitId(int visitId) {
        this.visitId = visitId;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDateTime getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(LocalDateTime visitDate) {
        this.visitDate = visitDate;
    }

    public String toString() {
        return "[" + visitId + "] Appointment: " + appointmentId + " | " + diagnosis + " | " + visitDate;
    }
}
