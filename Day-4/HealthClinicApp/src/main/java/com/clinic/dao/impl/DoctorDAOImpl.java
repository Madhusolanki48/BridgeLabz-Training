package com.clinic.dao.impl;

import com.clinic.config.HikariConnectionPool;
import com.clinic.dao.DoctorDAO;
import com.clinic.dto.Doctor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAOImpl implements DoctorDAO {
    public boolean insertDoctor(Doctor doctor) throws SQLException {
        String sql = "INSERT INTO doctors(specialization_id,first_name,last_name,phone,email) VALUES (?,?,?,?,?)";
        try (Connection connection = HikariConnectionPool.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, doctor.getSpecializationId());
            ps.setString(2, doctor.getFirstName());
            ps.setString(3, doctor.getLastName());
            ps.setString(4, doctor.getPhone());
            ps.setString(5, doctor.getEmail());
            return ps.executeUpdate() > 0;
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Doctor email or specialization is invalid.");
            return false;
        }
    }

    public List<Doctor> getAllDoctors() throws SQLException {
        String sql = """
                SELECT d.*, s.name AS specialization_name
                FROM doctors d
                JOIN specializations s ON d.specialization_id = s.specialization_id
                WHERE d.is_active = TRUE
                ORDER BY d.doctor_id
                """;
        List<Doctor> doctors = new ArrayList<>();
        try (Connection connection = HikariConnectionPool.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                doctors.add(new Doctor(
                        rs.getInt("doctor_id"),
                        rs.getInt("specialization_id"),
                        rs.getString("specialization_name"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getBoolean("is_active")));
            }
        }
        return doctors;
    }
}
