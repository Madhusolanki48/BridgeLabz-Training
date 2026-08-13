package com.clinic.dao;
import com.clinic.dto.Appointment;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface AppointmentDAO {
    boolean insertAppointment(Appointment appointment) throws SQLException;

    List<Appointment> getAllAppointments() throws SQLException;

    Optional<Appointment> getAppointmentById(Connection connection, int appointmentId) throws SQLException;

    boolean updateStatus(Connection connection, int appointmentId, String status) throws SQLException;

    boolean cancelAppointment(int appointmentId) throws SQLException;
}
