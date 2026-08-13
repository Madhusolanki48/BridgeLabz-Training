package com.clinic.dao.impl;

import com.clinic.config.HikariConnectionPool;
import com.clinic.dao.SpecializationDAO;
import com.clinic.dto.Specialization;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SpecializationDAOImpl implements SpecializationDAO {
    public boolean insertSpecialization(Specialization specialization) throws SQLException {
        String sql = "INSERT INTO specializations(name, description) VALUES (?, ?)";
        try (Connection connection = HikariConnectionPool.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, specialization.getName());
            ps.setString(2, specialization.getDescription());
            return ps.executeUpdate() > 0;
        }
    }

    public List<Specialization> getAllSpecializations() throws SQLException {
        String sql = "SELECT * FROM specializations WHERE is_active = TRUE ORDER BY specialization_id";
        List<Specialization> specializations = new ArrayList<>();
        try (Connection connection = HikariConnectionPool.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                specializations.add(new Specialization(
                        rs.getInt("specialization_id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getBoolean("is_active")));
            }
        }
        return specializations;
    }
}
