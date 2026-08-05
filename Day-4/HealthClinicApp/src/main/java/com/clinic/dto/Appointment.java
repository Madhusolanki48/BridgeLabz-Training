package com.clinic.dto;

import java.time.LocalDateTime;

public class Appointment {
    private int appointmentId;
    private int patientId;
    private int doctorId;
    private String patientName;
    private String doctorName;
    private LocalDateTime appointmentDate;
    private String reason;
    private String status;

    public Appointment() {
    }

    public Appointment(int appointmentId, int patientId, int doctorId, String patientName, String doctorName,
            LocalDateTime appointmentDate, String reason, String status) {
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.appointmentDate = appointmentDate;
        this.reason = reason;
        this.status = status;
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

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public LocalDateTime getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDateTime appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String toString() {
        return "[" + appointmentId + "] Patient: " + patientName + " | Doctor: " + doctorName + " | " + appointmentDate
                + " | Status: " + status;
    }
}
