package com.clinic.dao.impl;

import com.clinic.config.HikariConnectionPool;
import com.clinic.dao.BillingDAO;
import com.clinic.dto.Billing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BillingDAOImpl implements BillingDAO {
    public boolean insertBilling(Connection connection, Billing billing) throws SQLException {
        String sql = "INSERT INTO billing(appointment_id, amount, payment_status) VALUES (?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, billing.getAppointmentId());
            ps.setBigDecimal(2, billing.getAmount());
            ps.setString(3, billing.getPaymentStatus());
            return ps.executeUpdate() > 0;
        }
    }

    public List<Billing> getAllBilling() throws SQLException {
        String sql = "SELECT * FROM billing ORDER BY billing_id";
        List<Billing> billingList = new ArrayList<>();
        try (Connection connection = HikariConnectionPool.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                billingList.add(new Billing(
                        rs.getInt("billing_id"),
                        rs.getInt("appointment_id"),
                        rs.getBigDecimal("amount"),
                        rs.getString("payment_status"),
                        rs.getTimestamp("billing_date").toLocalDateTime()));
            }
        }
        return billingList;
    }
}
