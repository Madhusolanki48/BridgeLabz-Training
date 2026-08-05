package com.clinic.config;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class HikariConnectionPool {
    private static final HikariDataSource dataSource;

    static {
        HikariConfig config = new HikariConfig();
        // Uses environment values if available, otherwise local DB values.
        config.setJdbcUrl(getEnv("CLINIC_DB_URL", "jdbc:mysql://localhost:3306/health_clinic_db?useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true"));
        config.setUsername(getEnv("CLINIC_DB_USER", "clinic_app_user"));
        config.setPassword(getEnv("CLINIC_DB_PASSWORD", "StrongPassword123!"));
        // Pool settings help reuse connections instead of opening a new one each time.
        config.setMaximumPoolSize(10);
        config.setMinimumIdle(2);
        config.setConnectionTimeout(30000);
        config.setIdleTimeout(600000);
        config.setMaxLifetime(1800000);
        dataSource = new HikariDataSource(config);
    }

    private HikariConnectionPool() {
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static void closePool() {
        dataSource.close();
    }

    private static String getEnv(String key, String defaultValue) {
        String value = System.getenv(key);
        return value == null || value.isBlank() ? defaultValue : value;
    }
}

