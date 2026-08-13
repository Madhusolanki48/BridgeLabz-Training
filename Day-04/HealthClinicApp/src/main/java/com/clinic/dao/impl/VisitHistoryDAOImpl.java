package com.clinic.dao.impl;

import com.clinic.config.HikariConnectionPool;
import com.clinic.dao.VisitHistoryDAO;
import com.clinic.dto.VisitHistory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VisitHistoryDAOImpl implements VisitHistoryDAO {
    public boolean insertVisitHistory(Connection connection, VisitHistory visitHistory) throws SQLException {
        String sql = """
                INSERT INTO visit_history(appointment_id,patient_id,doctor_id,diagnosis,prescription,notes)
                VALUES (?,?,?,?,?,?)
                """;
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, visitHistory.getAppointmentId());
            ps.setInt(2, visitHistory.getPatientId());
            ps.setInt(3, visitHistory.getDoctorId());
            ps.setString(4, visitHistory.getDiagnosis());
            ps.setString(5, visitHistory.getPrescription());
            ps.setString(6, visitHistory.getNotes());
            return ps.executeUpdate() > 0;
        }
    }

    public List<VisitHistory> getAllVisitHistory() throws SQLException {
        String sql = "SELECT * FROM visit_history ORDER BY visit_id";
        List<VisitHistory> visits = new ArrayList<>();
        try (Connection connection = HikariConnectionPool.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                visits.add(new VisitHistory(
                        rs.getInt("visit_id"),
                        rs.getInt("appointment_id"),
                        rs.getInt("patient_id"),
                        rs.getInt("doctor_id"),
                        rs.getString("diagnosis"),
                        rs.getString("prescription"),
                        rs.getString("notes"),
                        rs.getTimestamp("visit_date").toLocalDateTime()));
            }
        }
        return visits;
    }
}
