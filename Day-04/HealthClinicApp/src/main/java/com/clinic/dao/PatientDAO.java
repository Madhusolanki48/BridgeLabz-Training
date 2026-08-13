package com.clinic.dao;
import com.clinic.dto.Patient;
import java.sql.SQLException;
import java.util.List;

public interface PatientDAO {
    boolean insertPatient(Patient patient) throws SQLException;

    List<Patient> getAllPatients() throws SQLException;

    boolean updatePatientEmail(int patientId, String email) throws SQLException;

    boolean softDeletePatient(int patientId) throws SQLException;
}
