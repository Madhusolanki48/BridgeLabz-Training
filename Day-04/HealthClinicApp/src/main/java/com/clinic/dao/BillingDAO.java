package com.clinic.dao;
import com.clinic.dto.Billing;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface BillingDAO {
    boolean insertBilling(Connection connection, Billing billing) throws SQLException;

    List<Billing> getAllBilling() throws SQLException;
}
