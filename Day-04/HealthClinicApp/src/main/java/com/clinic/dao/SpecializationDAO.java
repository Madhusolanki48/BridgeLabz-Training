package com.clinic.dao;

import com.clinic.dto.Specialization;
import java.sql.SQLException;
import java.util.List;

public interface SpecializationDAO {
    boolean insertSpecialization(Specialization specialization) throws SQLException;

    List<Specialization> getAllSpecializations() throws SQLException;
}
