package com.clinic.dao;
import com.clinic.dto.Doctor;
import java.sql.SQLException;
import java.util.List;

public interface DoctorDAO {
    boolean insertDoctor(Doctor doctor) throws SQLException;

    List<Doctor> getAllDoctors() throws SQLException;
}
