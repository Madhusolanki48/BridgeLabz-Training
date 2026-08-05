package com.clinic.dto;

public class Doctor {
    private int doctorId;
    private int specializationId;
    private String specializationName;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private boolean active;

    public Doctor() {
    }

    public Doctor(int doctorId, int specializationId, String specializationName, String firstName, String lastName,
            String phone, String email, boolean active) {
        this.doctorId = doctorId;
        this.specializationId = specializationId;
        this.specializationName = specializationName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.active = active;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getSpecializationId() {
        return specializationId;
    }

    public void setSpecializationId(int specializationId) {
        this.specializationId = specializationId;
    }

    public String getSpecializationName() {
        return specializationName;
    }

    public void setSpecializationName(String specializationName) {
        this.specializationName = specializationName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String toString() {
        return "[" + doctorId + "] Dr. " + firstName + " " + lastName + " | " + specializationName + " | " + phone;
    }
}
