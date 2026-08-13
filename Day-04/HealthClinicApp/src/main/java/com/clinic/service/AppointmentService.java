package com.clinic.service;

import com.clinic.config.HikariConnectionPool;
import com.clinic.dao.AppointmentDAO;
import com.clinic.dao.BillingDAO;
import com.clinic.dao.VisitHistoryDAO;
import com.clinic.dto.Appointment;
import com.clinic.dto.Billing;
import com.clinic.dto.VisitHistory;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;

public class AppointmentService {
    private final AppointmentDAO appointmentDAO;
    private final BillingDAO billingDAO;
    private final VisitHistoryDAO visitHistoryDAO;

    public AppointmentService(AppointmentDAO appointmentDAO, BillingDAO billingDAO, VisitHistoryDAO visitHistoryDAO) {
        this.appointmentDAO = appointmentDAO;
        this.billingDAO = billingDAO;
        this.visitHistoryDAO = visitHistoryDAO;
    }

    public boolean completeAppointmentWithBillingAndVisit(int appointmentId, BigDecimal amount, String diagnosis,
            String prescription, String notes) throws SQLException {
        Connection connection = null;
        try {
            connection = HikariConnectionPool.getConnection();
            connection.setAutoCommit(false);

            // Billing and visit history should save together, so we use one transaction.

            Appointment appointment = appointmentDAO.getAppointmentById(connection, appointmentId)
                    .orElseThrow(() -> new SQLException("Appointment not found."));
            if (!"Scheduled".equalsIgnoreCase(appointment.getStatus())) {
                throw new SQLException("Only scheduled appointments can be completed.");
            }

            appointmentDAO.updateStatus(connection, appointmentId, "Completed");

            Billing billing = new Billing(0, appointmentId, amount, "Pending", null);
            billingDAO.insertBilling(connection, billing);

            VisitHistory visit = new VisitHistory(0, appointmentId, appointment.getPatientId(),
                    appointment.getDoctorId(), diagnosis, prescription, notes, null);
            visitHistoryDAO.insertVisitHistory(connection, visit);

            connection.commit();
            return true;
        } catch (SQLException e) {
            if (connection != null) {
                // If any step fails, undo the status, billing, and visit insert.
                connection.rollback();
            }
            throw e;
        } finally {
            if (connection != null) {
                connection.setAutoCommit(true);
                connection.close();
            }
        }
    }
}

