package com.clinic.dao;

import com.clinic.dto.VisitHistory;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface VisitHistoryDAO {
    boolean insertVisitHistory(Connection connection, VisitHistory visitHistory) throws SQLException;

    List<VisitHistory> getAllVisitHistory() throws SQLException;
}
