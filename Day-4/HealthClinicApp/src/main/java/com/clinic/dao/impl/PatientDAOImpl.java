package com.clinic.dao.impl;

import com.clinic.config.HikariConnectionPool;
import com.clinic.dao.PatientDAO;
import com.clinic.dto.Patient;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

public class PatientDAOImpl implements PatientDAO {
    public boolean insertPatient(Patient patient) throws SQLException {
        String sql = "INSERT INTO patients(first_name,last_name,date_of_birth,gender,phone,email,address) VALUES (?,?,?,?,?,?,?)";
        try (Connection connection = HikariConnectionPool.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, patient.getFirstName());
            ps.setString(2, patient.getLastName());
            ps.setDate(3, Date.valueOf(patient.getDateOfBirth()));
            ps.setString(4, patient.getGender());
            ps.setString(5, patient.getPhone());
            ps.setString(6, patient.getEmail());
            ps.setString(7, patient.getAddress());
            return ps.executeUpdate() > 0;
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Email already exists.");
            return false;
        }
    }

    public List<Patient> getAllPatients() throws SQLException {
        // Only active patients are shown because delete is handled as soft delete.
        String sql = "SELECT * FROM patients WHERE is_active = TRUE ORDER BY patient_id";
        List<Patient> patients = new ArrayList<>();
        try (Connection connection = HikariConnectionPool.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                patients.add(mapPatient(rs));
            }
        }
        return patients;
    }

    public boolean updatePatientEmail(int patientId, String email) throws SQLException {
        String sql = "UPDATE patients SET email = ? WHERE patient_id = ? AND is_active = TRUE";
        try (Connection connection = HikariConnectionPool.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, email);
            ps.setInt(2, patientId);
            return ps.executeUpdate() > 0;
        }
    }

    public boolean softDeletePatient(int patientId) throws SQLException {
        // The row stays in DB, but is hidden from normal patient list.
        String sql = "UPDATE patients SET is_active = FALSE WHERE patient_id = ?";
        try (Connection connection = HikariConnectionPool.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, patientId);
            return ps.executeUpdate() > 0;
        }
    }

    private Patient mapPatient(ResultSet rs) throws SQLException {
        return new Patient(
                rs.getInt("patient_id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getDate("date_of_birth").toLocalDate(),
                rs.getString("gender"),
                rs.getString("phone"),
                rs.getString("email"),
                rs.getString("address"),
                rs.getBoolean("is_active"));
    }
}


