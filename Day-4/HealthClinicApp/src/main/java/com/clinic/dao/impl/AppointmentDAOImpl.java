package com.clinic.dao.impl;

import com.clinic.config.HikariConnectionPool;
import com.clinic.dao.AppointmentDAO;
import com.clinic.dto.Appointment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AppointmentDAOImpl implements AppointmentDAO {
    public boolean insertAppointment(Appointment appointment) throws SQLException {
        String sql = "INSERT INTO appointments(patient_id,doctor_id,appointment_date,reason,status) VALUES (?,?,?,?,?)";
        try (Connection connection = HikariConnectionPool.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, appointment.getPatientId());
            ps.setInt(2, appointment.getDoctorId());
            ps.setTimestamp(3, Timestamp.valueOf(appointment.getAppointmentDate()));
            ps.setString(4, appointment.getReason());
            ps.setString(5, "Scheduled");
            return ps.executeUpdate() > 0;
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Patient or doctor id is invalid.");
            return false;
        }
    }

    public List<Appointment> getAllAppointments() throws SQLException {
        String sql = """
                SELECT a.*, CONCAT(p.first_name, ' ', p.last_name) AS patient_name,
                       CONCAT('Dr. ', d.first_name, ' ', d.last_name) AS doctor_name
                FROM appointments a
                JOIN patients p ON a.patient_id = p.patient_id
                JOIN doctors d ON a.doctor_id = d.doctor_id
                ORDER BY a.appointment_id
                """;
        List<Appointment> appointments = new ArrayList<>();
        try (Connection connection = HikariConnectionPool.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                appointments.add(mapAppointment(rs));
            }
        }
        return appointments;
    }

    public Optional<Appointment> getAppointmentById(Connection connection, int appointmentId) throws SQLException {
        String sql = """
                SELECT a.*, CONCAT(p.first_name, ' ', p.last_name) AS patient_name,
                       CONCAT('Dr. ', d.first_name, ' ', d.last_name) AS doctor_name
                FROM appointments a
                JOIN patients p ON a.patient_id = p.patient_id
                JOIN doctors d ON a.doctor_id = d.doctor_id
                WHERE a.appointment_id = ?
                """;
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, appointmentId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapAppointment(rs));
                }
            }
        }
        return Optional.empty();
    }

    public boolean updateStatus(Connection connection, int appointmentId, String status) throws SQLException {
        String sql = "UPDATE appointments SET status = ? WHERE appointment_id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, status);
            ps.setInt(2, appointmentId);
            return ps.executeUpdate() > 0;
        }
    }

    public boolean cancelAppointment(int appointmentId) throws SQLException {
        // Appointment is cancelled by changing status, not deleting the record.
        String sql = "UPDATE appointments SET status = 'Cancelled' WHERE appointment_id = ?";
        try (Connection connection = HikariConnectionPool.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, appointmentId);
            return ps.executeUpdate() > 0;
        }
    }

    private Appointment mapAppointment(ResultSet rs) throws SQLException {
        return new Appointment(
                rs.getInt("appointment_id"),
                rs.getInt("patient_id"),
                rs.getInt("doctor_id"),
                rs.getString("patient_name"),
                rs.getString("doctor_name"),
                rs.getTimestamp("appointment_date").toLocalDateTime(),
                rs.getString("reason"),
                rs.getString("status"));
    }
}


